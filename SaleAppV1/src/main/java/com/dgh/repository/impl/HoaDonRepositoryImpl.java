/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.dto.HoaDonDTO;
import com.dgh.dto.HoaDonDaThanhToanOnlineDTO;
import com.dgh.pojo.DichVu;
import com.dgh.pojo.HoaDonThanhToan;
import com.dgh.pojo.LoaiTiec;
import com.dgh.pojo.ThongTinSanh;
import com.dgh.pojo.ThucDon;
import com.dgh.repository.HoaDonRepository;
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
public class HoaDonRepositoryImpl implements HoaDonRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public HoaDonDTO getHoaDonDtoByPhieuDatBanId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("SELECT ctkh.ten_khach_hang, ctkh.ngay_to_chuc, ctkh.so_dien_thoai, ctkh.dia_chi,\n"
                + "                		ctdt.ca, ctdt.so_luong_ban, lt.ten_loai_tiec, s.ten_sanh, s.don_gia_toi_thieu, \n"
                + "                        td.ma_thuc_don, td.gia_goi, dv.loai_dich_vu, dv.gia_dich_vu,\n"
                + "                    SUM(CASE \n"
                + "                        WHEN ctdt.ca = 'SA' THEN s.don_gia_toi_thieu\n"
                + "                        WHEN ctdt.ca = 'CH' THEN s.don_gia_toi_thieu * 1.05\n"
                + "                        WHEN ctdt.ca = 'T' THEN s.don_gia_toi_thieu * 1.15\n"
                + "                        ELSE 0\n"
                + "                    END) as \"gia_sanh\",\n"
                + "                    SUM(ctdt.so_luong_ban * td.gia_goi) as \"tien_thuc_don\",\n"
                + "                    SUM(ctdt.so_luong_ban * td.gia_goi + dv.gia_dich_vu +\n"
                + "                        (CASE \n"
                + "                            WHEN ctdt.ca = 'SA' THEN s.don_gia_toi_thieu\n"
                + "                           WHEN ctdt.ca = 'CH' THEN s.don_gia_toi_thieu * 1.05\n"
                + "                            WHEN ctdt.ca = 'T' THEN s.don_gia_toi_thieu * 1.15\n"
                + "                            ELSE 0\n"
                + "                        END)\n"
                + "                    ) as \"tong_tien\", SUM((ctdt.so_luong_ban * td.gia_goi + dv.gia_dich_vu +\n"
                + "                        (CASE \n"
                + "                            WHEN ctdt.ca = 'SA' THEN s.don_gia_toi_thieu\n"
                + "                           WHEN ctdt.ca = 'CH' THEN s.don_gia_toi_thieu * 1.05\n"
                + "                            WHEN ctdt.ca = 'T' THEN s.don_gia_toi_thieu * 1.15\n"
                + "                            ELSE 0\n"
                + "                        END)) * 0.2\n"
                + "                    ) as \"dat_coc\",\n"
                + "                     (SUM(\n"
                + "                     ctdt.so_luong_ban * td.gia_goi + dv.gia_dich_vu +\n"
                + "                     (\n"
                + "                         CASE \n"
                + "                             WHEN ctdt.ca = 'SA' THEN s.don_gia_toi_thieu\n"
                + "                             WHEN ctdt.ca = 'CH' THEN s.don_gia_toi_thieu * 1.05\n"
                + "                             WHEN ctdt.ca = 'T' THEN s.don_gia_toi_thieu * 1.15\n"
                + "                             ELSE 0\n"
                + "                     END\n"
                + "                     )\n"
                + "                 ) - (SUM(\n"
                + "                 ctdt.so_luong_ban * td.gia_goi + dv.gia_dich_vu +\n"
                + "                 (\n"
                + "               CASE \n"
                + "                   WHEN ctdt.ca = 'SA' THEN s.don_gia_toi_thieu\n"
                + "                   WHEN ctdt.ca = 'CH' THEN s.don_gia_toi_thieu * 1.05\n"
                + "                   WHEN ctdt.ca = 'T' THEN s.don_gia_toi_thieu * 1.15\n"
                + "                   ELSE 0\n"
                + "               END\n"
                + "           )\n"
                + "       ) * 0.2)) as \"tien_con_lai\"\n"
                + "                FROM phieu_dat_ban as p\n"
                + "                JOIN thong_tin_chi_tiet_dat_tiec as ctdt ON p.chi_tiet_dat_tiec_id = ctdt.id\n"
                + "                JOIN thong_tin_chi_tiet_khach_hang_dat_tiec as ctkh ON p.chi_tiet_khach_hang_id = ctkh.id\n"
                + "                JOIN thong_tin_sanh as s ON s.id = ctdt.sanh_id\n"
                + "                JOIN thuc_don as td ON td.id = ctdt.thuc_don_id\n"
                + "                JOIN dich_vu as dv ON dv.id = ctdt.dich_vu_id\n"
                + "                JOIN loai_tiec as lt on lt.id = ctdt.loai_tiec_id\n"
                + "                WHERE p.id = :id\n"
                + "                GROUP BY p.id;");
        q.setParameter("id", id);

        Object[] row = (Object[]) q.getSingleResult();
        HoaDonDTO hoaDonDTO = new HoaDonDTO();

        hoaDonDTO.setTenKhachHang((String) row[0]);
        hoaDonDTO.setNgayToChuc((Date) row[1]);
        hoaDonDTO.setSoDienThoai((String) row[2]);
        hoaDonDTO.setDiaChi((String) row[3]);
        hoaDonDTO.setCa((String) row[4]);
        hoaDonDTO.setSoLuongBan((String) row[5]);

        LoaiTiec lt = new LoaiTiec();
        lt.setTenLoaiTiec((String) row[6]);
        hoaDonDTO.setLoaiTiec(lt);

        ThongTinSanh st = new ThongTinSanh();
        st.setTenSanh((String) row[7]);
        st.setDonGiaToiThieu((Float) row[8]);
        hoaDonDTO.setTenSanh(st);

        ThucDon td = new ThucDon();
        td.setMaThucDon((String) row[9]);
        td.setGiaGoi((Float) row[10]);
        hoaDonDTO.setMaThucDon(td);

        DichVu dv = new DichVu();
        dv.setLoaiDichVu((String) row[11]);
        dv.setGiaDichVu((Float) row[12]);
        hoaDonDTO.setLoaiDichVu(dv);

        hoaDonDTO.setTongTienSanh((double) row[13]);
        hoaDonDTO.setTongTienThucDon((double) row[14]);
        hoaDonDTO.setTongTienHoaDon((double) row[15]);
        hoaDonDTO.setTienCoc((double) row[16]);
        hoaDonDTO.setTienConLai((double) row[17]);

        return hoaDonDTO;
    }

    @Override
    public HoaDonThanhToan addThanhToanHoaDon(HoaDonThanhToan hd) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(hd);
            return hd;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public HoaDonDaThanhToanOnlineDTO getHoaDonDaThanhToanByPhieuDatBanId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("SELECT ctkh.ten_khach_hang, ctkh.ngay_to_chuc, ctkh.so_dien_thoai, ctkh.dia_chi,\n"
                + "		ctdt.ca, ctdt.so_luong_ban, lt.ten_loai_tiec, s.ten_sanh, s.don_gia_toi_thieu, \n"
                + "        td.ma_thuc_don, td.gia_goi, dv.loai_dich_vu, dv.gia_dich_vu,\n"
                + "    SUM(CASE \n"
                + "        WHEN ctdt.ca = 'SA' THEN s.don_gia_toi_thieu\n"
                + "        WHEN ctdt.ca = 'CH' THEN s.don_gia_toi_thieu * 1.05\n"
                + "        WHEN ctdt.ca = 'T' THEN s.don_gia_toi_thieu * 1.15\n"
                + "        ELSE 0\n"
                + "    END) as \"gia_sanh\",\n"
                + "    SUM(ctdt.so_luong_ban * td.gia_goi) as \"tien_thuc_don\",\n"
                + "    SUM(ctdt.so_luong_ban * td.gia_goi + dv.gia_dich_vu +\n"
                + "        (CASE \n"
                + "            WHEN ctdt.ca = 'SA' THEN s.don_gia_toi_thieu\n"
                + "            WHEN ctdt.ca = 'CH' THEN s.don_gia_toi_thieu * 1.05\n"
                + "            WHEN ctdt.ca = 'T' THEN s.don_gia_toi_thieu * 1.15\n"
                + "            ELSE 0\n"
                + "        END)\n"
                + "    ) as \"tong_tien\", hdtt.isActive\n"
                + "FROM phieu_dat_ban as p\n"
                + "JOIN thong_tin_chi_tiet_dat_tiec as ctdt ON p.chi_tiet_dat_tiec_id = ctdt.id\n"
                + "JOIN thong_tin_chi_tiet_khach_hang_dat_tiec as ctkh ON p.chi_tiet_khach_hang_id = ctkh.id\n"
                + "JOIN thong_tin_sanh as s ON s.id = ctdt.sanh_id\n"
                + "JOIN thuc_don as td ON td.id = ctdt.thuc_don_id\n"
                + "JOIN dich_vu as dv ON dv.id = ctdt.dich_vu_id\n"
                + "JOIN loai_tiec as lt on lt.id = ctdt.loai_tiec_id\n"
                + "JOIN hoa_don_thanh_toan as hdtt on hdtt.phieu_dat_ban_id = p.id\n"
                + "WHERE p.id = :id\n"
                + "GROUP BY p.id;");
        q.setParameter("id", id);

        Object[] row = (Object[]) q.getSingleResult();
        HoaDonDaThanhToanOnlineDTO hoaDonDangThanhToan = new HoaDonDaThanhToanOnlineDTO();

        hoaDonDangThanhToan.setTenKhachHang((String) row[0]);
        hoaDonDangThanhToan.setNgayToChuc((Date) row[1]);
        hoaDonDangThanhToan.setSoDienThoai((String) row[2]);
        hoaDonDangThanhToan.setDiaChi((String) row[3]);
        hoaDonDangThanhToan.setCa((String) row[4]);
        hoaDonDangThanhToan.setSoLuongBan((String) row[5]);

        LoaiTiec lt = new LoaiTiec();
        lt.setTenLoaiTiec((String) row[6]);
        hoaDonDangThanhToan.setLoaiTiec(lt);

        ThongTinSanh st = new ThongTinSanh();
        st.setTenSanh((String) row[7]);
        st.setDonGiaToiThieu((Float) row[8]);
        hoaDonDangThanhToan.setTenSanh(st);

        ThucDon td = new ThucDon();
        td.setMaThucDon((String) row[9]);
        td.setGiaGoi((Float) row[10]);
        hoaDonDangThanhToan.setMaThucDon(td);

        DichVu dv = new DichVu();
        dv.setLoaiDichVu((String) row[11]);
        dv.setGiaDichVu((Float) row[12]);
        hoaDonDangThanhToan.setLoaiDichVu(dv);

        hoaDonDangThanhToan.setTongTienSanh((double) row[13]);
        hoaDonDangThanhToan.setTongTienThucDon((double) row[14]);
        hoaDonDangThanhToan.setTongTienHoaDon((double) row[15]);
        hoaDonDangThanhToan.setIsDaThanhToan((boolean) row[16]);

        return hoaDonDangThanhToan;
    }

    @Override
    public List<HoaDonDTO> getHoaDonDtoBySoDienThoai(String soDienThoai) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("SELECT p.tong_tien, p.tien_coc, p.tien_con_lai, p.ngay_dat_coc, ctkh.ten_khach_hang, ctkh.so_dien_thoai, ctkh.dia_chi, ctdt.so_luong_ban, ctdt.ca,\n"
                + "		lt.ten_loai_tiec,s.ten_sanh, s.don_gia_toi_thieu, td.ma_thuc_don, td.gia_goi, dv.loai_dich_vu, dv.gia_dich_vu, p.id, hd.id as \"hoa_don_id\"\n"
                + "FROM hoa_don_thanh_toan as hd\n"
                + "JOIN phieu_dat_ban as p on p.id = hd.phieu_dat_ban_id\n"
                + "JOIN thong_tin_chi_tiet_dat_tiec as ctdt on ctdt.id = p.chi_tiet_dat_tiec_id\n"
                + "JOIN thong_tin_chi_tiet_khach_hang_dat_tiec as ctkh on ctkh.id = p.chi_tiet_khach_hang_id\n"
                + "JOIN thong_tin_sanh as s on s.id = ctdt.sanh_id\n"
                + "JOIN thuc_don as td on td.id = ctdt.thuc_don_id\n"
                + "JOIN loai_tiec as lt on lt.id = ctdt.loai_tiec_id\n"
                + "JOIN dich_vu as dv on dv.id = ctdt.dich_vu_id\n"
                + "WHERE hd.isActive = 0 AND ctkh.so_dien_thoai = :soDienThoai\n"
                + "GROUP BY hd.id");
        q.setParameter("soDienThoai", soDienThoai);

        List<Object[]> rows = q.getResultList();
        List<HoaDonDTO> hoaDonDTOList = new ArrayList<>();
        for (Object[] row : rows) {
            HoaDonDTO hoaDonDTO = new HoaDonDTO();
            hoaDonDTO.setTongTienHoaDon((double) row[0]);
            hoaDonDTO.setTienCoc((double) row[1]);
            hoaDonDTO.setTienConLai((double) row[2]);
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
            hoaDonDTO.setId((Integer) row[17]);
            hoaDonDTOList.add(hoaDonDTO);
        }
        return hoaDonDTOList;
    }

    @Override
    public boolean updateHoaDon(HoaDonThanhToan hd) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(hd);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public HoaDonDTO getHoaDonChoNhanVienByPhieuDatBanId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNativeQuery("SELECT p.tong_tien, p.tien_coc, p.tien_con_lai, p.ngay_dat_coc, ctkh.ten_khach_hang, ctkh.so_dien_thoai,\n"
                + "		ctkh.dia_chi, ctdt.so_luong_ban, ctdt.ca,\n"
                + "		lt.ten_loai_tiec,s.ten_sanh, s.don_gia_toi_thieu,\n"
                + "        td.ma_thuc_don, td.gia_goi, dv.loai_dich_vu, dv.gia_dich_vu,\n"
                + "        p.id as \"phieu_dat_ban_id\", hd.id as \"hoa_don_id\", ctkh.ngay_to_chuc\n"
                + "FROM hoa_don_thanh_toan as hd\n"
                + "JOIN phieu_dat_ban as p on p.id = hd.phieu_dat_ban_id\n"
                + "JOIN thong_tin_chi_tiet_dat_tiec as ctdt on ctdt.id = p.chi_tiet_dat_tiec_id\n"
                + "JOIN thong_tin_chi_tiet_khach_hang_dat_tiec as ctkh on ctkh.id = p.chi_tiet_khach_hang_id\n"
                + "JOIN thong_tin_sanh as s on s.id = ctdt.sanh_id\n"
                + "JOIN thuc_don as td on td.id = ctdt.thuc_don_id\n"
                + "JOIN loai_tiec as lt on lt.id = ctdt.loai_tiec_id\n"
                + "JOIN dich_vu as dv on dv.id = ctdt.dich_vu_id\n"
                + "WHERE hd.isActive = 0 AND p.id = :id\n"
                + "GROUP BY p.id;");
        q.setParameter("id", id);

        Object[] row = (Object[]) q.getSingleResult();
        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        hoaDonDTO.setTongTienHoaDon((double) row[0]);
        hoaDonDTO.setTienCoc((double) row[1]);
        hoaDonDTO.setTienConLai((double) row[2]);
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
        hoaDonDTO.setId((Integer) row[17]);
        hoaDonDTO.setNgayToChuc((Date) row[18]);

        return hoaDonDTO;
    }

    @Override
    public HoaDonThanhToan getHoaDonById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(HoaDonThanhToan.class, id);
    }

}
