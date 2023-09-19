/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
@Table(name = "loai_tiec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiTiec.findAll", query = "SELECT l FROM LoaiTiec l"),
    @NamedQuery(name = "LoaiTiec.findById", query = "SELECT l FROM LoaiTiec l WHERE l.id = :id"),
    @NamedQuery(name = "LoaiTiec.findByTenLoaiTiec", query = "SELECT l FROM LoaiTiec l WHERE l.tenLoaiTiec = :tenLoaiTiec"),
    @NamedQuery(name = "LoaiTiec.findByIsDelete", query = "SELECT l FROM LoaiTiec l WHERE l.isDelete = :isDelete")})
public class LoaiTiec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @NotBlank(message = "{loaiTiec.tenLoaiTiec.notBlankMsg}")
    @Column(name = "ten_loai_tiec")
    private String tenLoaiTiec;
    @Column(name = "isDelete")
    private Boolean isDelete;
    @OneToMany(mappedBy = "loaiTiecId")
    @JsonIgnore
    private Set<ThongTinSanh> thongTinSanhSet;
    @OneToMany(mappedBy = "loaiTiecId")
    @JsonIgnore
    private Set<ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet;

    public Set<ThongTinChiTietDatTiec> getThongTinChiTietDatTiecSet() {
        return thongTinChiTietDatTiecSet;
    }

    public void setThongTinChiTietDatTiecSet(Set<ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet) {
        this.thongTinChiTietDatTiecSet = thongTinChiTietDatTiecSet;
    }

    public LoaiTiec() {
    }

    public LoaiTiec(Integer id) {
        this.id = id;
    }

    public LoaiTiec(Integer id, String tenLoaiTiec) {
        this.id = id;
        this.tenLoaiTiec = tenLoaiTiec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLoaiTiec() {
        return tenLoaiTiec;
    }

    public void setTenLoaiTiec(String tenLoaiTiec) {
        this.tenLoaiTiec = tenLoaiTiec;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public Set<ThongTinSanh> getThongTinSanhSet() {
        return thongTinSanhSet;
    }

    public void setThongTinSanhSet(Set<ThongTinSanh> thongTinSanhSet) {
        this.thongTinSanhSet = thongTinSanhSet;
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
        if (!(object instanceof LoaiTiec)) {
            return false;
        }
        LoaiTiec other = (LoaiTiec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.LoaiTiec[ id=" + id + " ]";
    }
    
}
