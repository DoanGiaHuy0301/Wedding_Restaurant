/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.dto.HoaDonDTO;
import com.dgh.repository.HoaDonRepository;
import com.dgh.repository.PhieuDatBanRepository;
import com.dgh.service.PhieuDatBanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class PhieuDatBanServiceImpl implements PhieuDatBanService{
    
    @Autowired
    private PhieuDatBanRepository phieuDatBanRepo;

    @Override
    public List<HoaDonDTO> getPhieuDatBanBySoDienThoai(String soDienThoai) {
        return this.phieuDatBanRepo.getPhieuDatBanBySoDienThoai(soDienThoai);
    }
    
}
