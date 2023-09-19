package com.dgh.pojo;

import com.dgh.pojo.AnhSanh;
import com.dgh.pojo.LoaiTiec;
import com.dgh.pojo.ThongTinChiTietDatTiec;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(ThongTinSanh.class)
public class ThongTinSanh_ { 

    public static volatile SetAttribute<ThongTinSanh, AnhSanh> anhSanhSet;
    public static volatile SingularAttribute<ThongTinSanh, String> loaiSanh;
    public static volatile SingularAttribute<ThongTinSanh, String> tenSanh;
    public static volatile SingularAttribute<ThongTinSanh, Float> donGiaToiThieu;
    public static volatile SingularAttribute<ThongTinSanh, Boolean> isDelete;
    public static volatile SingularAttribute<ThongTinSanh, Integer> soLuongBan;
    public static volatile SetAttribute<ThongTinSanh, ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet;
    public static volatile SingularAttribute<ThongTinSanh, Integer> id;
    public static volatile SingularAttribute<ThongTinSanh, LoaiTiec> loaiTiecId;

}