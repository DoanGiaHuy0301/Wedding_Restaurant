package com.dgh.pojo;

import com.dgh.pojo.ThongTinChiTietDatTiec;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(DichVu.class)
public class DichVu_ { 

    public static volatile SingularAttribute<DichVu, String> loaiDichVu;
    public static volatile SingularAttribute<DichVu, Boolean> isDelete;
    public static volatile SingularAttribute<DichVu, Float> giaDichVu;
    public static volatile SetAttribute<DichVu, ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet;
    public static volatile SingularAttribute<DichVu, Integer> id;

}