package com.dgh.pojo;

import com.dgh.pojo.ChiNhanh;
import com.dgh.pojo.NhanVien;
import com.dgh.pojo.PhieuDatBan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(HoaDonThanhToan.class)
public class HoaDonThanhToan_ { 

    public static volatile SingularAttribute<HoaDonThanhToan, Date> ngayThanhToan;
    public static volatile SingularAttribute<HoaDonThanhToan, Integer> id;
    public static volatile SingularAttribute<HoaDonThanhToan, Boolean> isActive;
    public static volatile SingularAttribute<HoaDonThanhToan, NhanVien> nhanVienId;
    public static volatile SingularAttribute<HoaDonThanhToan, String> maThanhToan;
    public static volatile SingularAttribute<HoaDonThanhToan, PhieuDatBan> phieuDatBanId;
    public static volatile SingularAttribute<HoaDonThanhToan, ChiNhanh> chiNhanhId;

}