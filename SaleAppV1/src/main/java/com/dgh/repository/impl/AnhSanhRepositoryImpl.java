/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.AnhSanh;
import com.dgh.repository.AnhSanhRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
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
public class AnhSanhRepositoryImpl implements AnhSanhRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<AnhSanh> getAnhSanh() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM AnhSanh");

        return q.getResultList();
    }

    @Override
    public boolean addOrUploadAnhSanh(AnhSanh as) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (as.getId() == null) {
                s.save(as);
            } else {
                s.update(as);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public AnhSanh getAnhSanhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(AnhSanh.class, id);
    }

    @Override
    public boolean deleteAnhSanh(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        AnhSanh a = this.getAnhSanhById(id);
        try {
            s.delete(a);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AnhSanh> getAnhSanhByLoaiSanh(String loaiSanh) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("select anh_sanh.anh_sanh, thong_tin_sanh.loai_sanh\n"
                + "from anh_sanh\n"
                + "join thong_tin_sanh on anh_sanh.sanh_id = thong_tin_sanh.id\n"
                + "where thong_tin_sanh.loai_sanh = :loaiSanh");

        q.setParameter("loaiSanh", loaiSanh);

        return q.getResultList();
    }

}
