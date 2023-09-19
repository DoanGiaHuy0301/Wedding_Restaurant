/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.PhanHoiKhachHang;
import com.dgh.pojo.TaiKhoan;
import com.dgh.repository.PhanHoiKhachHangRepository;
import com.dgh.repository.TaiKhoanRepository;
import com.dgh.service.PhanHoiKhachHangService;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class PhanHoiKhachHangServiceImpl implements PhanHoiKhachHangService {

    @Autowired
    private PhanHoiKhachHangRepository phanHoiKhachHangRepo;
    @Autowired
    private TaiKhoanRepository taiKhoanRepo;
    
    @Override
    public PhanHoiKhachHang themPhanHoi(PhanHoiKhachHang p) {
        p.setNgayPhanHoi(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        TaiKhoan user = this.taiKhoanRepo.getTaiKhoanByTenDangNhap(authentication.getName());
        p.setTaiKhoanId(user);
        return this.phanHoiKhachHangRepo.themPhanHoi(p);
    }
    
}
