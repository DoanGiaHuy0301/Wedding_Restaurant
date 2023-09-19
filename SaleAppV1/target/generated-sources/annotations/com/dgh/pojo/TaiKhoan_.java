package com.dgh.pojo;

import com.dgh.pojo.KhachHang;
import com.dgh.pojo.NhanVien;
import com.dgh.pojo.PhanHoiKhachHang;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(TaiKhoan.class)
public class TaiKhoan_ { 

    public static volatile SingularAttribute<TaiKhoan, String> vaiTro;
    public static volatile SetAttribute<TaiKhoan, PhanHoiKhachHang> phanHoiKhachHangSet;
    public static volatile SingularAttribute<TaiKhoan, String> matKhau;
    public static volatile SetAttribute<TaiKhoan, KhachHang> khachHangSet;
    public static volatile SingularAttribute<TaiKhoan, String> tenDangNhap;
    public static volatile SingularAttribute<TaiKhoan, Integer> id;
    public static volatile SingularAttribute<TaiKhoan, String> avatar;
    public static volatile SetAttribute<TaiKhoan, NhanVien> nhanVienSet;

}