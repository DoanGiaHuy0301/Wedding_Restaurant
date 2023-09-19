/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.dto.NhanVienDTO;
import com.dgh.pojo.ChiNhanh;
import com.dgh.pojo.ChucVu;
import com.dgh.pojo.NhanVien;
import com.dgh.pojo.TaiKhoan;
import com.dgh.repository.NhanVienRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class NhanVienRepositoryImpl implements NhanVienRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<NhanVienDTO> getNhanVien(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<NhanVien> root = q.from(NhanVien.class);

        Join<NhanVien, ChiNhanh> chiNhanhJoin = root.join("chiNhanhId");
        Join<NhanVien, ChucVu> chucVuJoin = root.join("chucVuId");
        Join<NhanVien, TaiKhoan> taiKhoanJoin = root.join("taiKhoanId");

        q.multiselect(
                root.get("id"),
                root.get("tenNhanVien"),
                root.get("ngaySinh"),
                root.get("soDienThoai"),
                root.get("email"),
                root.get("gioiTinh"),
                root.get("diaChi"),
                root.get("ngayVaoLam"),
                chiNhanhJoin.get("tenChiNhanh"),
                chucVuJoin.get("chucVu"),
                taiKhoanJoin.get("tenDangNhap"),
                taiKhoanJoin.get("matKhau"),
                taiKhoanJoin.get("vaiTro")
        );

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(root.get("isDelete"), 0));

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.or(
                        b.like(root.get("tenNhanVien"), String.format("%%%s%%", kw)),
                        b.like(root.get("soDienThoai"), String.format("%%%s%%", kw)),
                        b.like(root.get("email"), String.format("%%%s%%", kw)),
                        b.like(root.get("diaChi"), String.format("%%%s%%", kw))
                ));
            }
        }

        q.where(predicates.toArray(new Predicate[0]));

        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

        List<Object[]> rows = query.getResultList();
        List<NhanVienDTO> nhanVienList = new ArrayList<>();

        for (Object[] row : rows) {
            NhanVienDTO nhanVien = new NhanVienDTO();
            nhanVien.setId((Integer) row[0]);
            nhanVien.setTenNhanVien((String) row[1]);
            nhanVien.setNgaySinh((Date) row[2]);
            nhanVien.setEmail((String) row[3]);
            nhanVien.setSoDienThoai((String) row[4]);
            nhanVien.setGioiTinh((Integer) row[5]);
            nhanVien.setDiaChi((String) row[6]);
            nhanVien.setNgayVaoLam((Date) row[7]);
            nhanVien.setChiNhanh((String) row[8]);
            nhanVien.setChucVu((String) row[9]);
            nhanVien.setTaiKhoan((String) row[10]);
            nhanVienList.add(nhanVien);
        }

        return nhanVienList;
    }

    @Override
    public boolean addNhanVien(NhanVien nv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (nv.getId() == null) {
                s.save(nv);
            } else {
                s.update(nv);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public NhanVien getNhanVienById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(NhanVien.class, id);
    }

    @Override
    public boolean deleteNhanVienById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        NhanVien nv = this.getNhanVienById(id);
        nv.setIsDelete(Boolean.TRUE);
        try {
            s.update(nv);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Long countNhanVien() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM NhanVien");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public NhanVien getNhanVienByTaiKhoanId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("SELECT * FROM nhan_vien WHERE nhan_vien.tai_khoan_id = :id");

        q.setParameter("id", id);

         Object[] row = (Object[]) q.getSingleResult();
        NhanVien nhanVien = new NhanVien(); 
        nhanVien.setId((Integer) row[0]);
    
        return nhanVien;
    }

}
