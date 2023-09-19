/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.ChucVu;
import com.dgh.repository.ChucVuRepository;
import java.util.List;
import javax.persistence.Query;
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
public class ChucVuRepositoryImpl implements ChucVuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ChucVu> getChucVu() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM ChucVu");

        return q.getResultList();
    }

    @Override
    public ChucVu getChucVuById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ChucVu.class, id);
    }

//    @Override
//    public ChucVu getChucVuById(int id) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createNativeQuery("Select * From chuc_vu Where chuc_vu.id = ?");
//        
//        q.setParameter(0, id);
//        return (ChucVu) q.getSingleResult();
//    }
//    @Override
//    public ChucVu getChucVuNativeById(int id) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createNativeQuery("Select * From chuc_vu where chuc_vu.id = ?");
//
//        q.setParameter(0, id);
//        return (ChucVu) q.getSingleResult();
//    }

}
