/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.ThongTinSanh;
import com.dgh.repository.ThongTinSanhRepository;
import com.dgh.service.ThongTinSanhService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ThongTinSanhServiceImpl implements ThongTinSanhService{

    @Autowired
    private ThongTinSanhRepository thongTinSanhRepo;
    @Override
    public List<ThongTinSanh> getThongTinSanh(Map<String, String> params) {
        return this.thongTinSanhRepo.getThongTinSanh(params);
    }

    @Override
    public boolean addOrUpdateSanh(ThongTinSanh s) {
        s.setIsDelete(false);
        return this.thongTinSanhRepo.addOrUpdateSanh(s);
    }

    @Override
    public ThongTinSanh getSanhById(int id) {
        return this.thongTinSanhRepo.getSanhById(id);
    }

    @Override
    public boolean deleteSanh(int id) {
        return this.thongTinSanhRepo.deleteSanh(id);
    }

    @Override
    public Long countThongTinSanh() {
        return this.thongTinSanhRepo.countThongTinSanh();
    }

    @Override
    public List<ThongTinSanh> getSanhChuaDuocDat(String date) {
        return this.thongTinSanhRepo.getSanhChuaDuocDat(date);
    }
    
}
