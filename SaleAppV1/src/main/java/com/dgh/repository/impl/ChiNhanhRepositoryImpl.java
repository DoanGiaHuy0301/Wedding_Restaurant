/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.ChiNhanh;
import com.dgh.repository.ChiNhanhRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class ChiNhanhRepositoryImpl implements ChiNhanhRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

//    @Override
//    public List<ChiNhanh> getChiNhanh() {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM ChiNhanh Where isDelete = 0");
//
//        return q.getResultList();
//    }
    @Override
    public boolean addOrUpdateChiNhanh(ChiNhanh cn) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (cn.getId() == null) {
                s.save(cn);
            } else {
                s.update(cn);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ChiNhanh getChiNhanhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ChiNhanh.class, id);
    }

    @Override
    public boolean deleteChiNhanhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        ChiNhanh cn = this.getChiNhanhById(id);
        cn.setIsDelete(Boolean.TRUE);
        try {
            s.update(cn);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ChiNhanh> getDanhSachChiNhanh(Map<String, String> params) {

        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<ChiNhanh> q = b.createQuery(ChiNhanh.class);
        Root<ChiNhanh> root = q.from(ChiNhanh.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("isDelete"), 0)); // Thêm điều kiện isDelete = 0

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate tenChiNhanhPredicate = b.like(root.get("tenChiNhanh"), String.format("%%%s%%", kw));
                Predicate diaChiPredicate = b.like(root.get("diaChi"), String.format("%%%s%%", kw));

                // Sử dụng OR để kết hợp hai điều kiện tìm kiếm
                predicates.add(b.or(tenChiNhanhPredicate, diaChiPredicate));
            }
        }

        if (!predicates.isEmpty()) {
            q.where(predicates.toArray(new Predicate[0]));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }


}
