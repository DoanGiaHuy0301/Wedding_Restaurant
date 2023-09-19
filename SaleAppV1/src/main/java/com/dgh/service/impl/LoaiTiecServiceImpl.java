/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.LoaiTiec;
import com.dgh.repository.LoaiTiecRepository;
import com.dgh.service.LoaiTiecService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class LoaiTiecServiceImpl implements LoaiTiecService {
    @Autowired
    private LoaiTiecRepository loaiTiecRepo;

    @Override
    public List<LoaiTiec> getLoaiTiec(Map<String, String> params) {
        return this.loaiTiecRepo.getLoaiTiec(params);
    }

    @Override
    public boolean addOrUpdateLoaiTiec(LoaiTiec l) {
        l.setIsDelete(Boolean.FALSE);
        return this.loaiTiecRepo.addOrUpdateLoaiTiec(l);
    }

    @Override
    public LoaiTiec getLoaiTiecById(int id) {
        return this.loaiTiecRepo.getLoaiTiecById(id);
    }

    @Override
    public boolean deleteLoaiTiec(int id) {
        return this.loaiTiecRepo.deleteLoaiTiec(id);
    }
    
}
