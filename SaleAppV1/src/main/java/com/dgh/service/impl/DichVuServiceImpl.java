/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.DichVu;
import com.dgh.repository.DichVuRepository;
import com.dgh.service.DichVuService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class DichVuServiceImpl implements DichVuService{
    @Autowired
    private DichVuRepository dichVuRepo;

    @Override
    public List<DichVu> getDichVu(Map<String, String> params) {
        return this.dichVuRepo.getDichVu(params);
    }

    @Override
    public boolean addOrUpdateDichVu(DichVu dv) {
        dv.setIsDelete(Boolean.FALSE);
        return this.dichVuRepo.addOrUpdateDichVu(dv);
    }

    @Override
    public DichVu getDichVuById(int id) {
        return this.dichVuRepo.getDichVuById(id);
    }

    @Override
    public boolean deleteDichVu(int id) {
        return this.dichVuRepo.deleteChiNhanhById(id);
    }
    
}
