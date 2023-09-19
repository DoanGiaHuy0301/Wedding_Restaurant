/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.dto.NhanVienDTO;
import com.dgh.pojo.NhanVien;
import com.dgh.repository.NhanVienRepository;
import com.dgh.service.NhanVienService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class NhanVienServiceImpl implements NhanVienService{

    @Autowired
    private NhanVienRepository nhanVienRepo;
    
    @Override
    public List<NhanVienDTO> getNhanVien(Map<String, String> params) {
        return this.nhanVienRepo.getNhanVien(params);
    }

    @Override
    public boolean addNhanVien(NhanVien nv) {
        nv.setIsDelete(Boolean.FALSE);
        return this.nhanVienRepo.addNhanVien(nv);
    }

    @Override
    public NhanVien getNhanVienById(int id) {
        return this.nhanVienRepo.getNhanVienById(id);
    }

    @Override
    public boolean deleteNhanVienById(int id) {
        return this.nhanVienRepo.deleteNhanVienById(id);
    }

    @Override
    public Long countNhanVien() {
        return this.nhanVienRepo.countNhanVien();
    }


    
}
