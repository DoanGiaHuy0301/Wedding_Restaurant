/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.LoaiTiec;
import com.dgh.repository.LoaiTiecRepository;
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
 * @author admin
 */
@Repository
@Transactional
public class LoaiTiecRepositoryImpl implements LoaiTiecRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<LoaiTiec> getLoaiTiec(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<LoaiTiec> q = b.createQuery(LoaiTiec.class);
        Root<LoaiTiec> root = q.from(LoaiTiec.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("isDelete"), 0)); 

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("tenLoaiTiec"), String.format("%%%s%%", kw)));
                
            }
        }

        if (!predicates.isEmpty()) {
            q.where(predicates.toArray(new Predicate[0]));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateLoaiTiec(LoaiTiec l) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (l.getId() == null) {
                s.save(l);
            } else {
                s.update(l);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public LoaiTiec getLoaiTiecById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(LoaiTiec.class, id);
    }

    @Override
    public boolean deleteLoaiTiec(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        LoaiTiec lt = this.getLoaiTiecById(id);
        lt.setIsDelete(Boolean.TRUE);
        try {
            s.update(lt);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
