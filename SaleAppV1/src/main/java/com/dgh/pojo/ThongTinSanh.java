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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "thong_tin_sanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThongTinSanh.findAll", query = "SELECT t FROM ThongTinSanh t"),
    @NamedQuery(name = "ThongTinSanh.findById", query = "SELECT t FROM ThongTinSanh t WHERE t.id = :id"),
    @NamedQuery(name = "ThongTinSanh.findByLoaiSanh", query = "SELECT t FROM ThongTinSanh t WHERE t.loaiSanh = :loaiSanh"),
    @NamedQuery(name = "ThongTinSanh.findByTenSanh", query = "SELECT t FROM ThongTinSanh t WHERE t.tenSanh = :tenSanh"),
    @NamedQuery(name = "ThongTinSanh.findBySoLuongBan", query = "SELECT t FROM ThongTinSanh t WHERE t.soLuongBan = :soLuongBan"),
    @NamedQuery(name = "ThongTinSanh.findByDonGiaToiThieu", query = "SELECT t FROM ThongTinSanh t WHERE t.donGiaToiThieu = :donGiaToiThieu"),
    @NamedQuery(name = "ThongTinSanh.findByIsDelete", query = "SELECT t FROM ThongTinSanh t WHERE t.isDelete = :isDelete")})
public class ThongTinSanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "loai_sanh")
    @NotBlank(message = "{thongTinSanh.loaiSanh.notBlankMsg}")
    private String loaiSanh;
    @Size(max = 255)
    @Column(name = "ten_sanh")
    @NotBlank(message = "{thongTinSanh.tenSanh.notBlankMsg}")
    private String tenSanh;
    @Column(name = "so_luong_ban")
    @NotNull(message = "{thongTinSanh.soLuongBan.notNullMsg}")
    private Integer soLuongBan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "don_gia_toi_thieu")
    private Float donGiaToiThieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isDelete")
    private boolean isDelete;
    @JoinColumn(name = "loai_tiec_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private LoaiTiec loaiTiecId;
    @OneToMany(mappedBy = "sanhId")
    @JsonIgnore
    private Set<AnhSanh> anhSanhSet;
    @OneToMany(mappedBy = "sanhId")
    @JsonIgnore
    private Set<ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet;

    public ThongTinSanh() {
    }

    public ThongTinSanh(Integer id) {
        this.id = id;
    }

    public ThongTinSanh(Integer id, boolean isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiSanh() {
        return loaiSanh;
    }

    public void setLoaiSanh(String loaiSanh) {
        this.loaiSanh = loaiSanh;
    }

    public String getTenSanh() {
        return tenSanh;
    }

    public void setTenSanh(String tenSanh) {
        this.tenSanh = tenSanh;
    }

    public Integer getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(Integer soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public Float getDonGiaToiThieu() {
        return donGiaToiThieu;
    }

    public void setDonGiaToiThieu(Float donGiaToiThieu) {
        this.donGiaToiThieu = donGiaToiThieu;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public LoaiTiec getLoaiTiecId() {
        return loaiTiecId;
    }

    public void setLoaiTiecId(LoaiTiec loaiTiecId) {
        this.loaiTiecId = loaiTiecId;
    }

    @XmlTransient
    public Set<AnhSanh> getAnhSanhSet() {
        return anhSanhSet;
    }

    public void setAnhSanhSet(Set<AnhSanh> anhSanhSet) {
        this.anhSanhSet = anhSanhSet;
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
        if (!(object instanceof ThongTinSanh)) {
            return false;
        }
        ThongTinSanh other = (ThongTinSanh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.ThongTinSanh[ id=" + id + " ]";
    }
    
}
