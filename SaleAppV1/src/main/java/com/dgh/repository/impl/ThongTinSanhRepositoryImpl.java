/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.ThongTinSanh;
import com.dgh.repository.ThongTinSanhRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class ThongTinSanhRepositoryImpl implements ThongTinSanhRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    @Override
    public List<ThongTinSanh> getThongTinSanh(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<ThongTinSanh> q = b.createQuery(ThongTinSanh.class);
        Root<ThongTinSanh> root = q.from(ThongTinSanh.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("isDelete"), 0)); // Thêm điều kiện isDelete = 0

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate loaiSanhPredicate = b.like(root.get("loaiSanh"), String.format("%%%s%%", kw));
                Predicate tenSanhPredicate = b.like(root.get("tenSanh"), String.format("%%%s%%", kw));

                // Sử dụng OR để kết hợp hai điều kiện tìm kiếm
                predicates.add(b.or(loaiSanhPredicate, tenSanhPredicate));
            }

        }

        if (!predicates.isEmpty()) {
            q.where(predicates.toArray(new Predicate[0]));
        }

        q.orderBy(b.asc(root.get("id")));

        Query query = session.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateSanh(ThongTinSanh s) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (s.getId() == null) {
                session.save(s);
            } else {
                session.update(s);
            }

            return true;
        } catch (HibernateError ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ThongTinSanh getSanhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ThongTinSanh.class, id);
    }

    @Override
    public boolean deleteSanh(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        ThongTinSanh t = this.getSanhById(id);
        t.setIsDelete(true);
        try {
            s.update(t);
            return true;
        } catch (HibernateError ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Long countThongTinSanh() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM ThongTinSanh");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<ThongTinSanh> getSanhChuaDuocDat(String date) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("SELECT DISTINCT s.*\n"
                + " FROM thong_tin_sanh AS s\n"
                + " WHERE s.isDelete = 0 AND s.ten_sanh NOT IN (\n"
                + "     SELECT DISTINCT s.ten_sanh\n"
                + "     FROM thong_tin_sanh AS s\n"
                + "     JOIN thong_tin_chi_tiet_dat_tiec AS ctdt ON ctdt.loai_tiec_id = s.id\n"
                + "     JOIN phieu_dat_ban AS p ON p.chi_tiet_dat_tiec_id = ctdt.id\n"
                + "     JOIN thong_tin_chi_tiet_khach_hang_dat_tiec as ctkh on ctkh.id = p.chi_tiet_khach_hang_id\n"
                + "     WHERE ctkh.ngay_to_chuc = :date \n"
                + ");");
        q.setParameter("date", date);
        List<Object[]> rows = q.getResultList();
        List<ThongTinSanh> thongTinSanhList = new ArrayList<>();

        for (Object[] row : rows) {
            ThongTinSanh thongTinSanh = new ThongTinSanh();
            thongTinSanh.setId((Integer) row[0]);
            thongTinSanh.setLoaiSanh((String) row[1]);
            thongTinSanh.setTenSanh((String) row[2]);
            thongTinSanh.setSoLuongBan((Integer) row[3]);
            thongTinSanh.setDonGiaToiThieu((Float) row[4]);
            thongTinSanhList.add(thongTinSanh);
        }

        return thongTinSanhList;
    }

}
