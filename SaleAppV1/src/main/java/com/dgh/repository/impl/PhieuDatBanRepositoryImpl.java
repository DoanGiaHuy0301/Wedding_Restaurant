/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.dto.HoaDonDTO;
import com.dgh.pojo.DichVu;
import com.dgh.pojo.LoaiTiec;
import com.dgh.pojo.PhieuDatBan;
import com.dgh.pojo.ThongTinSanh;
import com.dgh.pojo.ThucDon;
import com.dgh.repository.PhieuDatBanRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class PhieuDatBanRepositoryImpl implements PhieuDatBanRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public PhieuDatBan themPhieu(PhieuDatBan p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(p);
            return p;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public PhieuDatBan getPhieuDatBanById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(PhieuDatBan.class, id);
    }

    @Override
    public boolean updatePayPhieuDatBan(PhieuDatBan p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<HoaDonDTO> getPhieuDatBanBySoDienThoai(String soDienThoai) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("SELECT p.tong_tien, p.tien_coc, p.tien_con_lai, p.ngay_dat_coc, ctkh.ten_khach_hang, ctkh.so_dien_thoai, ctkh.dia_chi, ctdt.so_luong_ban, ctdt.ca,\n"
                + "		lt.ten_loai_tiec,s.ten_sanh, s.don_gia_toi_thieu, td.ma_thuc_don, td.gia_goi, dv.loai_dich_vu, dv.gia_dich_vu, p.id\n"
                + "FROM phieu_dat_ban as p \n"
                + "JOIN thong_tin_chi_tiet_dat_tiec as ctdt on ctdt.id = p.chi_tiet_dat_tiec_id\n"
                + "JOIN thong_tin_chi_tiet_khach_hang_dat_tiec as ctkh on ctkh.id = p.chi_tiet_khach_hang_id\n"
                + "JOIN thong_tin_sanh as s on s.id = ctdt.sanh_id\n"
                + "JOIN thuc_don as td on td.id = ctdt.thuc_don_id\n"
                + "JOIN loai_tiec as lt on lt.id = ctdt.loai_tiec_id\n"
                + "JOIN dich_vu as dv on dv.id = ctdt.dich_vu_id\n"
                + "WHERE ctkh.so_dien_thoai = :soDienThoai  AND (p.tong_tien IS NULL OR p.tong_tien = '' OR p.tong_tien IS NOT NULL) AND p.ngay_dat_coc IS NULL\n"
                + "GROUP BY p.id;");
        q.setParameter("soDienThoai", soDienThoai);

        List<Object[]> rows = q.getResultList();
        List<HoaDonDTO> hoaDonDTOList = new ArrayList<>();
        for (Object[] row : rows) {
            HoaDonDTO hoaDonDTO = new HoaDonDTO();
         
            hoaDonDTO.setNgayDatCoc((Date) row[3]);
            hoaDonDTO.setTenKhachHang((String) row[4]);
            hoaDonDTO.setSoDienThoai((String) row[5]);
            hoaDonDTO.setDiaChi((String) row[6]);
            hoaDonDTO.setSoLuongBan((String) row[7]);
            hoaDonDTO.setCa((String) row[8]);

            LoaiTiec lt = new LoaiTiec();
            lt.setTenLoaiTiec((String) row[9]);
            hoaDonDTO.setLoaiTiec(lt);

            ThongTinSanh st = new ThongTinSanh();
            st.setTenSanh((String) row[10]);
            st.setDonGiaToiThieu((Float) row[11]);
            hoaDonDTO.setTenSanh(st);

            ThucDon td = new ThucDon();
            td.setMaThucDon((String) row[12]);
            td.setGiaGoi((Float) row[13]);
            hoaDonDTO.setMaThucDon(td);

            DichVu dv = new DichVu();
            dv.setLoaiDichVu((String) row[14]);
            dv.setGiaDichVu((Float) row[15]);
            hoaDonDTO.setLoaiDichVu(dv);

            hoaDonDTO.setPhieuDatBanId((Integer) row[16]);
            hoaDonDTOList.add(hoaDonDTO);
        }
        return hoaDonDTOList;
    }

}
