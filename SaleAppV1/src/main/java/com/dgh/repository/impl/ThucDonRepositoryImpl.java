/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.ThucDon;
import com.dgh.repository.ThucDonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateError;
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
public class ThucDonRepositoryImpl implements ThucDonRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<ThucDon> getThucDon(Map<String, String> params) {
       Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<ThucDon> q = b.createQuery(ThucDon.class);
        Root<ThucDon> root = q.from(ThucDon.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("isDelete"), 0)); // Thêm điều kiện isDelete = 0

        if (!predicates.isEmpty()) {
            q.where(predicates.toArray(new Predicate[0]));
        }

        q.orderBy(b.asc(root.get("id")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateThucDon(ThucDon td) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if(td.getId() == null) {
                s.save(td);
            } else {
                s.update(td);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ThucDon getThucDonById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ThucDon.class, id);
    }

    @Override
    public boolean deleteThucDonById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        ThucDon td = this.getThucDonById(id);
        td.setIsDelete(Boolean.TRUE);
        try {
            s.update(td);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
    
}
