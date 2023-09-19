package com.dgh.pojo;

import com.dgh.pojo.DichVu;
import com.dgh.pojo.LoaiTiec;
import com.dgh.pojo.PhieuDatBan;
import com.dgh.pojo.ThongTinSanh;
import com.dgh.pojo.ThucDon;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(ThongTinChiTietDatTiec.class)
public class ThongTinChiTietDatTiec_ { 

    public static volatile SingularAttribute<ThongTinChiTietDatTiec, DichVu> dichVuId;
    public static volatile SingularAttribute<ThongTinChiTietDatTiec, ThongTinSanh> sanhId;
    public static volatile SingularAttribute<ThongTinChiTietDatTiec, Boolean> isDelete;
    public static volatile SingularAttribute<ThongTinChiTietDatTiec, String> soLuongBan;
    public static volatile SingularAttribute<ThongTinChiTietDatTiec, Integer> id;
    public static volatile SingularAttribute<ThongTinChiTietDatTiec, ThucDon> thucDonId;
    public static volatile SingularAttribute<ThongTinChiTietDatTiec, String> ca;
    public static volatile SetAttribute<ThongTinChiTietDatTiec, PhieuDatBan> phieuDatBanSet;
    public static volatile SingularAttribute<ThongTinChiTietDatTiec, LoaiTiec> loaiTiecId;

}