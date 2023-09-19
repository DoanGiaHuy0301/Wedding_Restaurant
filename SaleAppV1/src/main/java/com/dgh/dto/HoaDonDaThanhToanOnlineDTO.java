/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.dto;

import com.dgh.pojo.DichVu;
import com.dgh.pojo.LoaiTiec;
import com.dgh.pojo.ThongTinSanh;
import com.dgh.pojo.ThucDon;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class HoaDonDaThanhToanOnlineDTO {
    private String tenKhachHang;
    private Date ngayToChuc;
    private String diaChi;
    private String soDienThoai;
    private String ca;
    private String soLuongBan;
    private LoaiTiec loaiTiec;
    private DichVu loaiDichVu;
    private ThucDon maThucDon;
    private ThongTinSanh tenSanh;
    private double tongTienSanh;
    private double tongTienThucDon;
    private double tongTienHoaDon;
    private int nhanVienId;
    private int chiNhanhId;
    private String maThanhToan;
    private boolean isDaThanhToan;

    public boolean isIsDaThanhToan() {
        return isDaThanhToan;
    }

    public void setIsDaThanhToan(boolean isDaThanhToan) {
        this.isDaThanhToan = isDaThanhToan;
    }

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public int getChiNhanhId() {
        return chiNhanhId;
    }

    public void setChiNhanhId(int chiNhanhId) {
        this.chiNhanhId = chiNhanhId;
    }
    
    public ThongTinSanh getTenSanh() {
        return tenSanh;
    }

    public void setTenSanh(ThongTinSanh tenSanh) {
        this.tenSanh = tenSanh;
    }

    public double getTongTienSanh() {
        return tongTienSanh;
    }

    public void setTongTienSanh(double tongTienSanh) {
        this.tongTienSanh = tongTienSanh;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(String soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public LoaiTiec getLoaiTiec() {
        return loaiTiec;
    }

    public void setLoaiTiec(LoaiTiec loaiTiec) {
        this.loaiTiec = loaiTiec;
    }

    public DichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(DichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public ThucDon getMaThucDon() {
        return maThucDon;
    }

    public void setMaThucDon(ThucDon maThucDon) {
        this.maThucDon = maThucDon;
    }

    public double getTongTienThucDon() {
        return tongTienThucDon;
    }

    public void setTongTienThucDon(double tongTienThucDon) {
        this.tongTienThucDon = tongTienThucDon;
    }

    public double getTongTienHoaDon() {
        return tongTienHoaDon;
    }

    public void setTongTienHoaDon(double tongTienHoaDon) {
        this.tongTienHoaDon = tongTienHoaDon;
    }
    
}
