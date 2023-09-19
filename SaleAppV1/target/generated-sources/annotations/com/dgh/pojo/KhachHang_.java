package com.dgh.pojo;

import com.dgh.pojo.TaiKhoan;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(KhachHang.class)
public class KhachHang_ { 

    public static volatile SingularAttribute<KhachHang, String> soDienThoai;
    public static volatile SingularAttribute<KhachHang, String> tenKhachHang;
    public static volatile SingularAttribute<KhachHang, TaiKhoan> taiKhoanId;
    public static volatile SingularAttribute<KhachHang, Integer> id;
    public static volatile SingularAttribute<KhachHang, String> email;

}