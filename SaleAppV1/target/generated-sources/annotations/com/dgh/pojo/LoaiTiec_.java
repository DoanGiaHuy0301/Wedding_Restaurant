package com.dgh.pojo;

import com.dgh.pojo.ThongTinChiTietDatTiec;
import com.dgh.pojo.ThongTinSanh;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(LoaiTiec.class)
public class LoaiTiec_ { 

    public static volatile SetAttribute<LoaiTiec, ThongTinSanh> thongTinSanhSet;
    public static volatile SingularAttribute<LoaiTiec, Boolean> isDelete;
    public static volatile SetAttribute<LoaiTiec, ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet;
    public static volatile SingularAttribute<LoaiTiec, Integer> id;
    public static volatile SingularAttribute<LoaiTiec, String> tenLoaiTiec;

}