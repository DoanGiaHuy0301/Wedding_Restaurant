/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.ThongTinChiTietKhachHangDatTiec;
import com.dgh.repository.ThongTinChiTiecKhachHangDatTiecRepository;
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
public class ThongTinChiTiecKhachHangDatTiecRepositoryImpl implements ThongTinChiTiecKhachHangDatTiecRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public ThongTinChiTietKhachHangDatTiec themChiTiecKhachHang(ThongTinChiTietKhachHangDatTiec ctkh) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(ctkh);
            return ctkh;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
