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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "phieu_dat_ban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhieuDatBan.findAll", query = "SELECT p FROM PhieuDatBan p"),
    @NamedQuery(name = "PhieuDatBan.findById", query = "SELECT p FROM PhieuDatBan p WHERE p.id = :id"),
    @NamedQuery(name = "PhieuDatBan.findByTongTien", query = "SELECT p FROM PhieuDatBan p WHERE p.tongTien = :tongTien"),
    @NamedQuery(name = "PhieuDatBan.findByTienCoc", query = "SELECT p FROM PhieuDatBan p WHERE p.tienCoc = :tienCoc"),
    @NamedQuery(name = "PhieuDatBan.findByTienConLai", query = "SELECT p FROM PhieuDatBan p WHERE p.tienConLai = :tienConLai"),
    @NamedQuery(name = "PhieuDatBan.findByNgayXuatPhieu", query = "SELECT p FROM PhieuDatBan p WHERE p.ngayXuatPhieu = :ngayXuatPhieu"),
    @NamedQuery(name = "PhieuDatBan.findByNgayDatCoc", query = "SELECT p FROM PhieuDatBan p WHERE p.ngayDatCoc = :ngayDatCoc"),
    @NamedQuery(name = "PhieuDatBan.findByIsDelete", query = "SELECT p FROM PhieuDatBan p WHERE p.isDelete = :isDelete")})
public class PhieuDatBan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tong_tien")
    private Double tongTien;
    @Column(name = "tien_coc")
    private Double tienCoc;
    @Column(name = "tien_con_lai")
    private Double tienConLai;
    @Column(name = "ngay_xuat_phieu")
    @Temporal(TemporalType.DATE)
    private Date ngayXuatPhieu;
    @Column(name = "ngay_dat_coc")
    @Temporal(TemporalType.DATE)
    private Date ngayDatCoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isDelete")
    private boolean isDelete;
    @JoinColumn(name = "chi_tiet_dat_tiec_id", referencedColumnName = "id")
    @ManyToOne
    private ThongTinChiTietDatTiec chiTietDatTiecId;
    @JoinColumn(name = "chi_tiet_khach_hang_id", referencedColumnName = "id")
    @ManyToOne
    private ThongTinChiTietKhachHangDatTiec chiTietKhachHangId;
    @OneToMany(mappedBy = "phieuDatBanId")
    private Set<HoaDonThanhToan> hoaDonThanhToanSet;

    public PhieuDatBan() {
    }

    public PhieuDatBan(Integer id) {
        this.id = id;
    }

    public PhieuDatBan(Integer id, boolean isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(Double tienCoc) {
        this.tienCoc = tienCoc;
    }

    public Double getTienConLai() {
        return tienConLai;
    }

    public void setTienConLai(Double tienConLai) {
        this.tienConLai = tienConLai;
    }

    public Date getNgayXuatPhieu() {
        return ngayXuatPhieu;
    }

    public void setNgayXuatPhieu(Date ngayXuatPhieu) {
        this.ngayXuatPhieu = ngayXuatPhieu;
    }
    
     public Date getNgayDatCoc() {
        return ngayDatCoc;
    }

    public void setNgayDatCoc(Date ngayDatCoc) {
        this.ngayDatCoc = ngayDatCoc;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }


    public ThongTinChiTietDatTiec getChiTietDatTiecId() {
        return chiTietDatTiecId;
    }

    public void setChiTietDatTiecId(ThongTinChiTietDatTiec chiTietDatTiecId) {
        this.chiTietDatTiecId = chiTietDatTiecId;
    }

    public ThongTinChiTietKhachHangDatTiec getChiTietKhachHangId() {
        return chiTietKhachHangId;
    }

    public void setChiTietKhachHangId(ThongTinChiTietKhachHangDatTiec chiTietKhachHangId) {
        this.chiTietKhachHangId = chiTietKhachHangId;
    }

    @XmlTransient
    public Set<HoaDonThanhToan> getHoaDonThanhToanSet() {
        return hoaDonThanhToanSet;
    }

    public void setHoaDonThanhToanSet(Set<HoaDonThanhToan> hoaDonThanhToanSet) {
        this.hoaDonThanhToanSet = hoaDonThanhToanSet;
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
        if (!(object instanceof PhieuDatBan)) {
            return false;
        }
        PhieuDatBan other = (PhieuDatBan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.PhieuDatBan[ id=" + id + " ]";
    }
    
}
