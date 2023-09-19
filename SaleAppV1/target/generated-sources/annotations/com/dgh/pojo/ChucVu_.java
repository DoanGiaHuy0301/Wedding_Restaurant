package com.dgh.pojo;

import com.dgh.pojo.NhanVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-14T23:07:10")
@StaticMetamodel(ChucVu.class)
public class ChucVu_ { 

    public static volatile SingularAttribute<ChucVu, Integer> id;
    public static volatile SingularAttribute<ChucVu, String> chucVu;
    public static volatile SetAttribute<ChucVu, NhanVien> nhanVienSet;

}