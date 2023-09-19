/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.dto.KhachHangTaiKhoanDTO;
import com.dgh.pojo.KhachHang;
import com.dgh.pojo.TaiKhoan;

/**
 *
 * @author DELL
 */
public interface TaiKhoanRepository {
    TaiKhoan getTaiKhoanByTenDangNhap(String tenDangNhap);
    boolean addTaiKhoan(TaiKhoan tk);
    TaiKhoan addUser(TaiKhoan tk);
    KhachHang addCus(KhachHang kh);
//    KhachHangTaiKhoanDTO addCus(KhachHangTaiKhoanDTO k);
    TaiKhoan timKiemTaiKhoanById(int id);
    boolean deleteTaiKhoanById(int id);
    boolean authUser(String tenDangNhap, String matKhau);
    boolean kiemTratenDangNhapTonTai(String tenDangNhap);
}
