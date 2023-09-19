/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "thong_tin_chi_tiet_khach_hang_dat_tiec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThongTinChiTietKhachHangDatTiec.findAll", query = "SELECT t FROM ThongTinChiTietKhachHangDatTiec t"),
    @NamedQuery(name = "ThongTinChiTietKhachHangDatTiec.findById", query = "SELECT t FROM ThongTinChiTietKhachHangDatTiec t WHERE t.id = :id"),
    @NamedQuery(name = "ThongTinChiTietKhachHangDatTiec.findByTenKhachHang", query = "SELECT t FROM ThongTinChiTietKhachHangDatTiec t WHERE t.tenKhachHang = :tenKhachHang"),
    @NamedQuery(name = "ThongTinChiTietKhachHangDatTiec.findByNgayToChuc", query = "SELECT t FROM ThongTinChiTietKhachHangDatTiec t WHERE t.ngayToChuc = :ngayToChuc"),
    @NamedQuery(name = "ThongTinChiTietKhachHangDatTiec.findBySoDienThoai", query = "SELECT t FROM ThongTinChiTietKhachHangDatTiec t WHERE t.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "ThongTinChiTietKhachHangDatTiec.findByDiaChi", query = "SELECT t FROM ThongTinChiTietKhachHangDatTiec t WHERE t.diaChi = :diaChi"),
    @NamedQuery(name = "ThongTinChiTietKhachHangDatTiec.findByIsDelete", query = "SELECT t FROM ThongTinChiTietKhachHangDatTiec t WHERE t.isDelete = :isDelete")})
public class ThongTinChiTietKhachHangDatTiec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten_khach_hang")
    private String tenKhachHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_to_chuc")
    @Temporal(TemporalType.DATE)
    private Date ngayToChuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dia_chi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isDelete")
    private boolean isDelete;
    @OneToMany(mappedBy = "chiTietKhachHangId")
    private Set<PhieuDatBan> phieuDatBanSet;

    public ThongTinChiTietKhachHangDatTiec() {
    }

    public ThongTinChiTietKhachHangDatTiec(Integer id) {
        this.id = id;
    }

    public ThongTinChiTietKhachHangDatTiec(Integer id, String tenKhachHang, Date ngayToChuc, String soDienThoai, String diaChi, boolean isDelete) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.ngayToChuc = ngayToChuc;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public Set<PhieuDatBan> getPhieuDatBanSet() {
        return phieuDatBanSet;
    }

    public void setPhieuDatBanSet(Set<PhieuDatBan> phieuDatBanSet) {
        this.phieuDatBanSet = phieuDatBanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThongTinChiTietKhachHangDatTiec)) {
            return false;
        }
        ThongTinChiTietKhachHangDatTiec other = (ThongTinChiTietKhachHangDatTiec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.ThongTinChiTietKhachHangDatTiec[ id=" + id + " ]";
    }
    
}
