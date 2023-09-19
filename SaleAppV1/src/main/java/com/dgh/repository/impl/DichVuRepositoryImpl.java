/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.DichVu;
import com.dgh.repository.DichVuRepository;
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
public class DichVuRepositoryImpl implements DichVuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<DichVu> getDichVu(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<DichVu> q = b.createQuery(DichVu.class);
        Root<DichVu> root = q.from(DichVu.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(root.get("isDelete"), 0)); 

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("loaiDichVu"), String.format("%%%s%%", kw)));
                
            }
            
            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(root.get("giaDichVu"), Double.parseDouble(fromPrice)));
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(root.get("giaDichVu"), Double.parseDouble(toPrice)));
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
    public boolean addOrUpdateDichVu(DichVu dv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if(dv.getId() == null) {
                
                s.save(dv);
            } else 
                s.update(dv);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public DichVu getDichVuById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(DichVu.class, id);
    }

    @Override
    public boolean deleteChiNhanhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        DichVu dv = this.getDichVuById(id);
        dv.setIsDelete(Boolean.TRUE);
        try {
            s.update(dv);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   

}
