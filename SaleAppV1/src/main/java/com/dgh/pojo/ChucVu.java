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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "chuc_vu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChucVu.findAll", query = "SELECT c FROM ChucVu c"),
    @NamedQuery(name = "ChucVu.findById", query = "SELECT c FROM ChucVu c WHERE c.id = :id"),
    @NamedQuery(name = "ChucVu.findByChucVu", query = "SELECT c FROM ChucVu c WHERE c.chucVu = :chucVu")})
public class ChucVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "chuc_vu")
    private String chucVu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chucVuId")
    private Set<NhanVien> nhanVienSet;

    public ChucVu() {
    }

    public ChucVu(Integer id) {
        this.id = id;
    }

    public ChucVu(Integer id, String chucVu) {
        this.id = id;
        this.chucVu = chucVu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @XmlTransient
    public Set<NhanVien> getNhanVienSet() {
        return nhanVienSet;
    }

    public void setNhanVienSet(Set<NhanVien> nhanVienSet) {
        this.nhanVienSet = nhanVienSet;
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
        if (!(object instanceof ChucVu)) {
            return false;
        }
        ChucVu other = (ChucVu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.ChucVu[ id=" + id + " ]";
    }
    
}
