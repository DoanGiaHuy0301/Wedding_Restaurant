/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.dto.ThongKeDoanhThuDTO;
import com.dgh.dto.ThongKeMatDoSanhCuoiDTO;
import com.dgh.dto.ThongKeMatDoTiecCuoiDTO;
import com.dgh.repository.ThongKeRepository;
import org.springframework.stereotype.Service;
import com.dgh.service.ThongKeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
@Service
public class ThongKeServiceImpl implements ThongKeService{
    @Autowired
    private ThongKeRepository thongKeRepo;

    @Override
    public List<ThongKeMatDoSanhCuoiDTO> thongKeMatDoSanhCuoi(Map<String, String> params) {
        return this.thongKeRepo.thongKeMatDoSanhCuoi(params);
    }

    @Override
    public List<ThongKeMatDoTiecCuoiDTO> thongKeMatDoTiecCuoi(Map<String, String> params) {
        return this.thongKeRepo.thongKeMatDoTiecCuoi(params);
    }

    @Override
    public List<ThongKeDoanhThuDTO> thongKeDoanhThu(Map<String, String> params) {
        return this.thongKeRepo.thongKeDoanhThu(params);
    }
    
    
}
