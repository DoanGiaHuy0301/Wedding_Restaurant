/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dgh.dto.KhachHangTaiKhoanDTO;
import com.dgh.pojo.KhachHang;
import com.dgh.pojo.TaiKhoan;
import com.dgh.repository.TaiKhoanRepository;
import com.dgh.service.TaiKhoanService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addTaiKhoan(TaiKhoan tk) {
        tk.setMatKhau(encoder.encode(tk.getMatKhau()));
        return this.taiKhoanRepo.addTaiKhoan(tk);
    }

    @Override
    public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
        TaiKhoan u = this.taiKhoanRepo.getTaiKhoanByTenDangNhap(tenDangNhap);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getVaiTro()));
        return new org.springframework.security.core.userdetails.User(
                u.getTenDangNhap(), u.getMatKhau(), authorities);
    }

    @Override
    public boolean deleteTaiKhoanById(int id) {
        return this.taiKhoanRepo.deleteTaiKhoanById(id);
    }

    @Override
    public TaiKhoan getTaiKhoanByTenDangNhap(String tenDangNhap) {
        return this.taiKhoanRepo.getTaiKhoanByTenDangNhap(tenDangNhap);
    }

    @Override
    public boolean authUser(String tenDangNhap, String matKhau) {
        return this.taiKhoanRepo.authUser(tenDangNhap, matKhau);
    }

    @Override
    public KhachHangTaiKhoanDTO addUser(Map<String, String> params, MultipartFile avatar) {
        TaiKhoan u = new TaiKhoan();
        u.setTenDangNhap(params.get("tenDangNhap"));
        u.setMatKhau(this.encoder.encode(params.get("matKhau")));
        u.setVaiTro("ROLE_USER");
       
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(TaiKhoanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        TaiKhoan tk = this.taiKhoanRepo.addUser(u);
        KhachHang k = new KhachHang();
        k.setTenKhachHang(params.get("tenKhachHang"));
        k.setSoDienThoai(params.get("soDienThoai"));
        k.setEmail(params.get("email"));
        k.setTaiKhoanId(tk);
        KhachHang khachHang = this.taiKhoanRepo.addCus(k);
        
        
        
        KhachHangTaiKhoanDTO kh = new KhachHangTaiKhoanDTO();
        kh.setTenKhachHang(khachHang.getTenKhachHang());
        kh.setSoDienThoai(khachHang.getSoDienThoai());
        kh.setEmail(khachHang.getEmail());
        kh.setTenDangNhap(tk.getTenDangNhap());
        kh.setMatKhau(tk.getMatKhau());
        kh.setVaiTro(tk.getVaiTro());
        kh.setAvatar(tk.getAvatar());
        return kh;
    }

    @Override
    public boolean kiemTratenDangNhapTonTai(String tenDangNhap) {
        return this.taiKhoanRepo.kiemTratenDangNhapTonTai(tenDangNhap);
    }

   




}
