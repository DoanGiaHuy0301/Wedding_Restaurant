package com.dgh.pojo;

import com.dgh.pojo.HoaDonThanhToan;
import com.dgh.pojo.NhanVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(ChiNhanh.class)
public class ChiNhanh_ { 

    public static volatile SingularAttribute<ChiNhanh, String> diaChi;
    public static volatile SingularAttribute<ChiNhanh, Boolean> isDelete;
    public static volatile SingularAttribute<ChiNhanh, Integer> id;
    public static volatile SingularAttribute<ChiNhanh, String> tenChiNhanh;
    public static volatile SetAttribute<ChiNhanh, HoaDonThanhToan> hoaDonThanhToanSet;
    public static volatile SetAttribute<ChiNhanh, NhanVien> nhanVienSet;

}