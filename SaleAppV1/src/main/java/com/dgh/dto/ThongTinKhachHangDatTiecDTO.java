/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.dto;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class ThongTinKhachHangDatTiecDTO {
    private int id;
    private String tenKhachHang;
    private Date ngayToChuc;
    private String soDienThoai;
    private String diaChi;
    private String soLuongBan;
    private String ca;
    private int sanhId;
    private int thucDonId;
    private int dichVuId;
    private int loaiTiecId;

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(Date ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(String soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public int getSanhId() {
        return sanhId;
    }

    public void setSanhId(int sanhId) {
        this.sanhId = sanhId;
    }

    public int getThucDonId() {
        return thucDonId;
    }

    public void setThucDonId(int thucDonId) {
        this.thucDonId = thucDonId;
    }

    public int getDichVuId() {
        return dichVuId;
    }

    public void setDichVuId(int dichVuId) {
        this.dichVuId = dichVuId;
    }

    public int getLoaiTiecId() {
        return loaiTiecId;
    }

    public void setLoaiTiecId(int loaiTiecId) {
        this.loaiTiecId = loaiTiecId;
    }
}
