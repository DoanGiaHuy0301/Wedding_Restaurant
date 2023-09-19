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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "phan_hoi_khach_hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhanHoiKhachHang.findAll", query = "SELECT p FROM PhanHoiKhachHang p"),
    @NamedQuery(name = "PhanHoiKhachHang.findById", query = "SELECT p FROM PhanHoiKhachHang p WHERE p.id = :id"),
    @NamedQuery(name = "PhanHoiKhachHang.findByPhanHoi", query = "SELECT p FROM PhanHoiKhachHang p WHERE p.phanHoi = :phanHoi"),
    @NamedQuery(name = "PhanHoiKhachHang.findByNgayPhanHoi", query = "SELECT p FROM PhanHoiKhachHang p WHERE p.ngayPhanHoi = :ngayPhanHoi")})
public class PhanHoiKhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "phan_hoi")
    private String phanHoi;
    @Column(name = "ngay_phan_hoi")
    @Temporal(TemporalType.DATE)
    private Date ngayPhanHoi;
    @JoinColumn(name = "tai_khoan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TaiKhoan taiKhoanId;

    public PhanHoiKhachHang() {
    }

    public PhanHoiKhachHang(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhanHoi() {
        return phanHoi;
    }

    public void setPhanHoi(String phanHoi) {
        this.phanHoi = phanHoi;
    }
    
    public Date getNgayPhanHoi() {
        return ngayPhanHoi;
    }

    public void setNgayPhanHoi(Date ngayPhanHoi) {
        this.ngayPhanHoi = ngayPhanHoi;
    }

    public TaiKhoan getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(TaiKhoan taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
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
        if (!(object instanceof PhanHoiKhachHang)) {
            return false;
        }
        PhanHoiKhachHang other = (PhanHoiKhachHang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.PhanHoiKhachHang[ id=" + id + " ]";
    }
    
}
