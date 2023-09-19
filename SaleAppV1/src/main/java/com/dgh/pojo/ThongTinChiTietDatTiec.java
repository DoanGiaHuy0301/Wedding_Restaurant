/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "thong_tin_chi_tiet_dat_tiec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThongTinChiTietDatTiec.findAll", query = "SELECT t FROM ThongTinChiTietDatTiec t"),
    @NamedQuery(name = "ThongTinChiTietDatTiec.findById", query = "SELECT t FROM ThongTinChiTietDatTiec t WHERE t.id = :id"),
    @NamedQuery(name = "ThongTinChiTietDatTiec.findBySoLuongBan", query = "SELECT t FROM ThongTinChiTietDatTiec t WHERE t.soLuongBan = :soLuongBan"),
    @NamedQuery(name = "ThongTinChiTietDatTiec.findByCa", query = "SELECT t FROM ThongTinChiTietDatTiec t WHERE t.ca = :ca"),
    @NamedQuery(name = "ThongTinChiTietDatTiec.findByIsDelete", query = "SELECT t FROM ThongTinChiTietDatTiec t WHERE t.isDelete = :isDelete")})
public class ThongTinChiTietDatTiec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "so_luong_ban")
    private String soLuongBan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ca")
    private String ca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isDelete")
    private boolean isDelete;
    @OneToMany(mappedBy = "chiTietDatTiecId")
    private Set<PhieuDatBan> phieuDatBanSet;
    @JoinColumn(name = "dich_vu_id", referencedColumnName = "id")
    @ManyToOne
    private DichVu dichVuId;
    @JoinColumn(name = "sanh_id", referencedColumnName = "id")
    @ManyToOne
    private ThongTinSanh sanhId;
    @JoinColumn(name = "thuc_don_id", referencedColumnName = "id")
    @ManyToOne
    private ThucDon thucDonId;
    @JoinColumn(name = "loai_tiec_id", referencedColumnName = "id")
    @ManyToOne
    private LoaiTiec loaiTiecId;

    public ThongTinChiTietDatTiec() {
    }

    public ThongTinChiTietDatTiec(Integer id) {
        this.id = id;
    }

    public ThongTinChiTietDatTiec(Integer id, String soLuongBan, String ca, String soLuongNhanVien, boolean isDelete) {
        this.id = id;
        this.soLuongBan = soLuongBan;
        this.ca = ca;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(String soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
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

    public DichVu getDichVuId() {
        return dichVuId;
    }

    public void setDichVuId(DichVu dichVuId) {
        this.dichVuId = dichVuId;
    }

    public ThongTinSanh getSanhId() {
        return sanhId;
    }

    public void setSanhId(ThongTinSanh sanhId) {
        this.sanhId = sanhId;
    }

    public ThucDon getThucDonId() {
        return thucDonId;
    }

    public void setThucDonId(ThucDon thucDonId) {
        this.thucDonId = thucDonId;
    }
    
     public LoaiTiec getLoaiTiecId() {
        return loaiTiecId;
    }

    public void setLoaiTiecId(LoaiTiec loaiTiecId) {
        this.loaiTiecId = loaiTiecId;
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
        if (!(object instanceof ThongTinChiTietDatTiec)) {
            return false;
        }
        ThongTinChiTietDatTiec other = (ThongTinChiTietDatTiec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.ThongTinChiTietDatTiec[ id=" + id + " ]";
    }
    
}
