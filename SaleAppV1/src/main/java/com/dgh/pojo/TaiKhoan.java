/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "tai_khoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findById", query = "SELECT t FROM TaiKhoan t WHERE t.id = :id"),
    @NamedQuery(name = "TaiKhoan.findByTenDangNhap", query = "SELECT t FROM TaiKhoan t WHERE t.tenDangNhap = :tenDangNhap"),
    @NamedQuery(name = "TaiKhoan.findByMatKhau", query = "SELECT t FROM TaiKhoan t WHERE t.matKhau = :matKhau"),
    @NamedQuery(name = "TaiKhoan.findByVaiTro", query = "SELECT t FROM TaiKhoan t WHERE t.vaiTro = :vaiTro"),
    @NamedQuery(name = "TaiKhoan.findByAvatar", query = "SELECT t FROM TaiKhoan t WHERE t.avatar = :avatar")})
public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten_dang_nhap")
    private String tenDangNhap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mat_khau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vai_tro")
    private String vaiTro;
    @Size(max = 255)
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taiKhoanId")
    @JsonIgnore
    private Set<NhanVien> nhanVienSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taiKhoanId")
    @JsonIgnore
    private Set<KhachHang> khachHangSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taiKhoanId")
    @JsonIgnore
    private Set<PhanHoiKhachHang> phanHoiKhachHangSet;

    public TaiKhoan() {
    }

    public TaiKhoan(Integer id) {
        this.id = id;
    }

    public TaiKhoan(Integer id, String tenDangNhap, String matKhau, String vaiTro) {
        this.id = id;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Set<NhanVien> getNhanVienSet() {
        return nhanVienSet;
    }

    public void setNhanVienSet(Set<NhanVien> nhanVienSet) {
        this.nhanVienSet = nhanVienSet;
    }

    @XmlTransient
    public Set<KhachHang> getKhachHangSet() {
        return khachHangSet;
    }

    public void setKhachHangSet(Set<KhachHang> khachHangSet) {
        this.khachHangSet = khachHangSet;
    }

    @XmlTransient
    public Set<PhanHoiKhachHang> getPhanHoiKhachHangSet() {
        return phanHoiKhachHangSet;
    }

    public void setPhanHoiKhachHangSet(Set<PhanHoiKhachHang> phanHoiKhachHangSet) {
        this.phanHoiKhachHangSet = phanHoiKhachHangSet;
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
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.TaiKhoan[ id=" + id + " ]";
    }
    
}
