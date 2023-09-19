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
@Table(name = "thuc_don")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThucDon.findAll", query = "SELECT t FROM ThucDon t"),
    @NamedQuery(name = "ThucDon.findById", query = "SELECT t FROM ThucDon t WHERE t.id = :id"),
    @NamedQuery(name = "ThucDon.findByMaThucDon", query = "SELECT t FROM ThucDon t WHERE t.maThucDon = :maThucDon"),
    @NamedQuery(name = "ThucDon.findByMonKhaiVi", query = "SELECT t FROM ThucDon t WHERE t.monKhaiVi = :monKhaiVi"),
    @NamedQuery(name = "ThucDon.findByMonChinh1", query = "SELECT t FROM ThucDon t WHERE t.monChinh1 = :monChinh1"),
    @NamedQuery(name = "ThucDon.findByMonChinh2", query = "SELECT t FROM ThucDon t WHERE t.monChinh2 = :monChinh2"),
    @NamedQuery(name = "ThucDon.findByMonChinh3", query = "SELECT t FROM ThucDon t WHERE t.monChinh3 = :monChinh3"),
    @NamedQuery(name = "ThucDon.findByMonChinh4", query = "SELECT t FROM ThucDon t WHERE t.monChinh4 = :monChinh4"),
    @NamedQuery(name = "ThucDon.findByMonTrangMieng", query = "SELECT t FROM ThucDon t WHERE t.monTrangMieng = :monTrangMieng"),
    @NamedQuery(name = "ThucDon.findByBia", query = "SELECT t FROM ThucDon t WHERE t.bia = :bia"),
    @NamedQuery(name = "ThucDon.findByNuocNgot", query = "SELECT t FROM ThucDon t WHERE t.nuocNgot = :nuocNgot"),
    @NamedQuery(name = "ThucDon.findByGiaGoi", query = "SELECT t FROM ThucDon t WHERE t.giaGoi = :giaGoi"),
    @NamedQuery(name = "ThucDon.findByIsDelete", query = "SELECT t FROM ThucDon t WHERE t.isDelete = :isDelete")})
public class ThucDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "ma_thuc_don")
    @NotBlank(message = "{thucDon.maThucDon.notBlankMsg}")
    private String maThucDon;
    @Size(max = 255)
    @Column(name = "mon_khai_vi")
    @NotBlank(message = "{thucDon.monKhaiVi.notBlankMsg}")
    private String monKhaiVi;
    @Size(max = 255)
    @Column(name = "mon_chinh_1")
    @NotBlank(message = "{thucDon.monChinh.notBlankMsg}")
    private String monChinh1;
    @Size(max = 255)
    @Column(name = "mon_chinh_2")
    @NotBlank(message = "{thucDon.monChinh.notBlankMsg}")
    private String monChinh2;
    @Size(max = 255)
    @Column(name = "mon_chinh_3")
    @NotBlank(message = "{thucDon.monChinh.notBlankMsg}")
    private String monChinh3;
    @Size(max = 255)
    @Column(name = "mon_chinh_4")
    @NotBlank(message = "{thucDon.monChinh.notBlankMsg}")
    private String monChinh4;
    @Size(max = 255)
    @NotBlank(message = "{thucDon.monTrangMieng.notBlankMsg}")
    @Column(name = "mon_trang_mieng")
    private String monTrangMieng;
    @Size(max = 100)
    @NotBlank(message = "{thucDon.monPhu.notBlankMsg}")
    @Column(name = "bia")
    private String bia;
    @Size(max = 100)
    @NotBlank(message = "{thucDon.monPhu.notBlankMsg}")
    @Column(name = "nuoc_ngot")
    private String nuocNgot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gia_goi")
    private Float giaGoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isDelete")
    private boolean isDelete;
    @OneToMany(mappedBy = "thucDonId")
    @JsonIgnore
    private Set<ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet;

    public ThucDon() {
    }

    public ThucDon(Integer id) {
        this.id = id;
    }

    public ThucDon(Integer id, boolean isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaThucDon() {
        return maThucDon;
    }

    public void setMaThucDon(String maThucDon) {
        this.maThucDon = maThucDon;
    }

    public String getMonKhaiVi() {
        return monKhaiVi;
    }

    public void setMonKhaiVi(String monKhaiVi) {
        this.monKhaiVi = monKhaiVi;
    }

    public String getMonChinh1() {
        return monChinh1;
    }

    public void setMonChinh1(String monChinh1) {
        this.monChinh1 = monChinh1;
    }

    public String getMonChinh2() {
        return monChinh2;
    }

    public void setMonChinh2(String monChinh2) {
        this.monChinh2 = monChinh2;
    }

    public String getMonChinh3() {
        return monChinh3;
    }

    public void setMonChinh3(String monChinh3) {
        this.monChinh3 = monChinh3;
    }

    public String getMonChinh4() {
        return monChinh4;
    }

    public void setMonChinh4(String monChinh4) {
        this.monChinh4 = monChinh4;
    }

    public String getMonTrangMieng() {
        return monTrangMieng;
    }

    public void setMonTrangMieng(String monTrangMieng) {
        this.monTrangMieng = monTrangMieng;
    }

    public String getBia() {
        return bia;
    }

    public void setBia(String bia) {
        this.bia = bia;
    }

    public String getNuocNgot() {
        return nuocNgot;
    }

    public void setNuocNgot(String nuocNgot) {
        this.nuocNgot = nuocNgot;
    }

    public Float getGiaGoi() {
        return giaGoi;
    }

    public void setGiaGoi(Float giaGoi) {
        this.giaGoi = giaGoi;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public Set<ThongTinChiTietDatTiec> getThongTinChiTietDatTiecSet() {
        return thongTinChiTietDatTiecSet;
    }

    public void setThongTinChiTietDatTiecSet(Set<ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet) {
        this.thongTinChiTietDatTiecSet = thongTinChiTietDatTiecSet;
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
        if (!(object instanceof ThucDon)) {
            return false;
        }
        ThucDon other = (ThucDon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.ThucDon[ id=" + id + " ]";
    }
    
}
