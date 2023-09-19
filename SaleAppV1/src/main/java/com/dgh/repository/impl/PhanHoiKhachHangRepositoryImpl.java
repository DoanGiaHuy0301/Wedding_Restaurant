/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.PhanHoiKhachHang;
import com.dgh.repository.PhanHoiKhachHangRepository;
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
public class PhanHoiKhachHangRepositoryImpl implements PhanHoiKhachHangRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public PhanHoiKhachHang themPhanHoi(PhanHoiKhachHang p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(p);
            return p;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
