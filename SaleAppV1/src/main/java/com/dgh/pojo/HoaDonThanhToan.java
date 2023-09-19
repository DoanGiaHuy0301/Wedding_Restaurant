/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "hoa_don_thanh_toan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDonThanhToan.findAll", query = "SELECT h FROM HoaDonThanhToan h"),
    @NamedQuery(name = "HoaDonThanhToan.findById", query = "SELECT h FROM HoaDonThanhToan h WHERE h.id = :id"),
        @NamedQuery(name = "HoaDonThanhToan.findByMaThanhToan", query = "SELECT h FROM HoaDonThanhToan h WHERE h.maThanhToan = :maThanhToan"),
    @NamedQuery(name = "HoaDonThanhToan.findByNgayThanhToan", query = "SELECT h FROM HoaDonThanhToan h WHERE h.ngayThanhToan = :ngayThanhToan"),
    @NamedQuery(name = "HoaDonThanhToan.findByIsActive", query = "SELECT h FROM HoaDonThanhToan h WHERE h.isActive = :isActive")})
public class HoaDonThanhToan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
     @Basic(optional = false)
    @NotNull
    @Column(name = "ma_thanh_toan")
    private String maThanhToan;
    @Column(name = "ngay_thanh_toan")
    @Temporal(TemporalType.DATE)
    private Date ngayThanhToan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "nhan_vien_id", referencedColumnName = "id")
    @ManyToOne
    private NhanVien nhanVienId;
    @JoinColumn(name = "chi_nhanh_id", referencedColumnName = "id")
    @ManyToOne
    private ChiNhanh chiNhanhId;
    @JoinColumn(name = "phieu_dat_ban_id", referencedColumnName = "id")
    @ManyToOne
    private PhieuDatBan phieuDatBanId;

    public HoaDonThanhToan() {
    }

    public HoaDonThanhToan(Integer id) {
        this.id = id;
    }

    public HoaDonThanhToan(Integer id, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public NhanVien getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(NhanVien nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public PhieuDatBan getPhieuDatBanId() {
        return phieuDatBanId;
    }

    public void setPhieuDatBanId(PhieuDatBan phieuDatBanId) {
        this.phieuDatBanId = phieuDatBanId;
    }
    
     public ChiNhanh getChiNhanhId() {
        return chiNhanhId;
    }

    public void setChiNhanhId(ChiNhanh chiNhanhId) {
        this.chiNhanhId = chiNhanhId;
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
        if (!(object instanceof HoaDonThanhToan)) {
            return false;
        }
        HoaDonThanhToan other = (HoaDonThanhToan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.HoaDonThanhToan[ id=" + id + " ]";
    }

}
