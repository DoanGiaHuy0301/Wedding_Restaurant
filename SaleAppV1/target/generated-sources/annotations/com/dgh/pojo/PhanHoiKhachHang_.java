package com.dgh.pojo;

import com.dgh.pojo.TaiKhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(PhanHoiKhachHang.class)
public class PhanHoiKhachHang_ { 

    public static volatile SingularAttribute<PhanHoiKhachHang, String> phanHoi;
    public static volatile SingularAttribute<PhanHoiKhachHang, TaiKhoan> taiKhoanId;
    public static volatile SingularAttribute<PhanHoiKhachHang, Integer> id;
    public static volatile SingularAttribute<PhanHoiKhachHang, Date> ngayPhanHoi;

}