package com.dgh.pojo;

import com.dgh.pojo.PhieuDatBan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(ThongTinChiTietKhachHangDatTiec.class)
public class ThongTinChiTietKhachHangDatTiec_ { 

    public static volatile SingularAttribute<ThongTinChiTietKhachHangDatTiec, Date> ngayToChuc;
    public static volatile SingularAttribute<ThongTinChiTietKhachHangDatTiec, String> soDienThoai;
    public static volatile SingularAttribute<ThongTinChiTietKhachHangDatTiec, String> diaChi;
    public static volatile SingularAttribute<ThongTinChiTietKhachHangDatTiec, Boolean> isDelete;
    public static volatile SingularAttribute<ThongTinChiTietKhachHangDatTiec, String> tenKhachHang;
    public static volatile SingularAttribute<ThongTinChiTietKhachHangDatTiec, Integer> id;
    public static volatile SetAttribute<ThongTinChiTietKhachHangDatTiec, PhieuDatBan> phieuDatBanSet;

}