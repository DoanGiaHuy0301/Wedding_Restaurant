package com.dgh.pojo;

import com.dgh.pojo.ChiNhanh;
import com.dgh.pojo.ChucVu;
import com.dgh.pojo.HoaDonThanhToan;
import com.dgh.pojo.TaiKhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(NhanVien.class)
public class NhanVien_ { 

    public static volatile SingularAttribute<NhanVien, String> soDienThoai;
    public static volatile SingularAttribute<NhanVien, String> tenNhanVien;
    public static volatile SingularAttribute<NhanVien, Date> ngayVaoLam;
    public static volatile SingularAttribute<NhanVien, Boolean> isDelete;
    public static volatile SingularAttribute<NhanVien, Integer> gioiTinh;
    public static volatile SetAttribute<NhanVien, HoaDonThanhToan> hoaDonThanhToanSet;
    public static volatile SingularAttribute<NhanVien, ChiNhanh> chiNhanhId;
    public static volatile SingularAttribute<NhanVien, String> diaChi;
    public static volatile SingularAttribute<NhanVien, ChucVu> chucVuId;
    public static volatile SingularAttribute<NhanVien, Date> ngaySinh;
    public static volatile SingularAttribute<NhanVien, TaiKhoan> taiKhoanId;
    public static volatile SingularAttribute<NhanVien, Integer> id;
    public static volatile SingularAttribute<NhanVien, String> email;

}