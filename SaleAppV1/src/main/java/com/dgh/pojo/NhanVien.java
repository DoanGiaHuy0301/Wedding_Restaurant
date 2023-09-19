/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "nhan_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findById", query = "SELECT n FROM NhanVien n WHERE n.id = :id"),
    @NamedQuery(name = "NhanVien.findByTenNhanVien", query = "SELECT n FROM NhanVien n WHERE n.tenNhanVien = :tenNhanVien"),
    @NamedQuery(name = "NhanVien.findByNgaySinh", query = "SELECT n FROM NhanVien n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "NhanVien.findByGioiTinh", query = "SELECT n FROM NhanVien n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "NhanVien.findBySoDienThoai", query = "SELECT n FROM NhanVien n WHERE n.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "NhanVien.findByEmail", query = "SELECT n FROM NhanVien n WHERE n.email = :email"),
    @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "NhanVien.findByNgayVaoLam", query = "SELECT n FROM NhanVien n WHERE n.ngayVaoLam = :ngayVaoLam"),
    @NamedQuery(name = "NhanVien.findByIsDelete", query = "SELECT n FROM NhanVien n WHERE n.isDelete = :isDelete")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ten_nhan_vien")
    @NotBlank(message = "{nhanVien.tenNhanVien.notNullMsg}")
    private String tenNhanVien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gioi_tinh")
    private int gioiTinh;
    @Basic(optional = false)
    @Column(name = "so_dien_thoai")
    @NotBlank(message = "{nhanVien.soDienThoai.notNullMsg}")
    private String soDienThoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Column(name = "email")
    @NotBlank(message = "{nhanVien.email.notNullMsg}")
    private String email;
    @Basic(optional = false)
    @Column(name = "dia_chi")
    @NotBlank(message = "{nhanVien.diaChi.notNullMsg}")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_vao_lam")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayVaoLam;
    @Column(name = "isDelete")
    private Boolean isDelete;
    @JoinColumn(name = "chi_nhanh_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private ChiNhanh chiNhanhId;
    @JoinColumn(name = "chuc_vu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private ChucVu chucVuId;
    @JoinColumn(name = "tai_khoan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private TaiKhoan taiKhoanId;
    @OneToMany(mappedBy = "nhanVienId")
    @JsonIgnore
    private Set<HoaDonThanhToan> hoaDonThanhToanSet;

    public NhanVien() {
    }

    public NhanVien(Integer id) {
        this.id = id;
    }

    public NhanVien(Integer id, String tenNhanVien, Date ngaySinh, int gioiTinh, String soDienThoai, String email, String diaChi, Date ngayVaoLam) {
        this.id = id;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayVaoLam = ngayVaoLam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public ChiNhanh getChiNhanhId() {
        return chiNhanhId;
    }

    public void setChiNhanhId(ChiNhanh chiNhanhId) {
        this.chiNhanhId = chiNhanhId;
    }

    public ChucVu getChucVuId() {
        return chucVuId;
    }

    public void setChucVuId(ChucVu chucVuId) {
        this.chucVuId = chucVuId;
    }

    public TaiKhoan getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(TaiKhoan taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
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
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.NhanVien[ id=" + id + " ]";
    }
    
}
