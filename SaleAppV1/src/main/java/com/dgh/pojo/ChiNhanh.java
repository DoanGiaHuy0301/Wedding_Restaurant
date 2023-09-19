/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "chi_nhanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiNhanh.findAll", query = "SELECT c FROM ChiNhanh c"),
    @NamedQuery(name = "ChiNhanh.findById", query = "SELECT c FROM ChiNhanh c WHERE c.id = :id"),
    @NamedQuery(name = "ChiNhanh.findByTenChiNhanh", query = "SELECT c FROM ChiNhanh c WHERE c.tenChiNhanh = :tenChiNhanh"),
    @NamedQuery(name = "ChiNhanh.findByDiaChi", query = "SELECT c FROM ChiNhanh c WHERE c.diaChi = :diaChi"),
    @NamedQuery(name = "ChiNhanh.findByIsDelete", query = "SELECT c FROM ChiNhanh c WHERE c.isDelete = :isDelete")})
public class ChiNhanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @NotBlank(message = "{chiNhanh.tenChiNhanh.notBlankMsg}")
    @Column(name = "ten_chi_nhanh")
    private String tenChiNhanh;
    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    @NotBlank(message = "{chiNhanh.tenChiNhanh.notBlankMsg}")
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "isDelete")
    private Boolean isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chiNhanhId")
    private Set<NhanVien> nhanVienSet;
    @OneToMany(mappedBy = "chiNhanhId")
    private Set<HoaDonThanhToan> hoaDonThanhToanSet;

    public ChiNhanh() {
    }

    public ChiNhanh(Integer id) {
        this.id = id;
    }

    public ChiNhanh(Integer id, String tenChiNhanh, String diaChi) {
        this.id = id;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public Set<NhanVien> getNhanVienSet() {
        return nhanVienSet;
    }

    public void setNhanVienSet(Set<NhanVien> nhanVienSet) {
        this.nhanVienSet = nhanVienSet;
    }

    @XmlTransient
    public Set<HoaDonThanhToan> hoaDonThanhToanSet() {
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
        if (!(object instanceof ChiNhanh)) {
            return false;
        }
        ChiNhanh other = (ChiNhanh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.ChiNhanh[ id=" + id + " ]";
    }
    
}
