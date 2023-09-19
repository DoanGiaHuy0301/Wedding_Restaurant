/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.dto.ThongKeDoanhThuDTO;
import com.dgh.dto.ThongKeMatDoSanhCuoiDTO;
import com.dgh.dto.ThongKeMatDoTiecCuoiDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dgh.repository.ThongKeRepository;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class ThongKeRepositoryImpl implements ThongKeRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ThongKeMatDoSanhCuoiDTO> thongKeMatDoSanhCuoi(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        String sql = "";

        Map<String, Object> parameters = new HashMap<>();
        if (params.containsKey("year") && !params.get("year").isEmpty()) {
            if (params.containsKey("month") && !params.get("month").isEmpty()) {
                parameters.put("year", Integer.parseInt(params.get("year")));
                parameters.put("month", Integer.parseInt(params.get("month")));
                sql = "SELECT thong_tin_sanh.ten_sanh, COUNT(*) AS so_luong FROM thong_tin_sanh \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON thong_tin_sanh.id = thong_tin_chi_tiet_dat_tiec.sanh_id \n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id \n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id \n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year \n"
                        + " AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan) = :month AND hoa_don_thanh_toan.isActive = 1\n"
                        + "  GROUP BY thong_tin_sanh.ten_sanh";
            } else if (params.containsKey("quarter") && !params.get("quarter").isEmpty()) {
                parameters.put("year", Integer.parseInt(params.get("year")));
                if (Integer.parseInt(params.get("quarter")) == 1) {
                    parameters.put("startMonth", 1);
                    parameters.put("endMonth", 3);
                } else if (Integer.parseInt(params.get("quarter")) == 2) {
                    parameters.put("startMonth", 4);
                    parameters.put("endMonth", 6);
                } else if (Integer.parseInt(params.get("quarter")) == 3) {
                    parameters.put("startMonth", 7);
                    parameters.put("endMonth", 9);
                } else {
                    parameters.put("startMonth", 10);
                    parameters.put("endMonth", 12);
                }

                sql = "SELECT thong_tin_sanh.ten_sanh, COUNT(*) AS so_luong FROM thong_tin_sanh \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON thong_tin_sanh.id = thong_tin_chi_tiet_dat_tiec.sanh_id \n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id \n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id \n"
                        + "WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year  \n"
                        + "AND hoa_don_thanh_toan.isActive = 1 AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan)\n"
                        + "BETWEEN :startMonth AND :endMonth GROUP BY thong_tin_sanh.ten_sanh";
            } else {
                parameters.put("year", Integer.parseInt(params.get("year")));
                sql = "SELECT thong_tin_sanh.ten_sanh, COUNT(*) AS so_luong FROM thong_tin_sanh \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON thong_tin_sanh.id = thong_tin_chi_tiet_dat_tiec.sanh_id \n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id \n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id \n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year AND hoa_don_thanh_toan.isActive = 1 \n"
                        + " GROUP BY thong_tin_sanh.ten_sanh";
            }
        } else {
            parameters.put("year", LocalDate.now().getYear());
            if (params.containsKey("month") && !params.get("month").isEmpty()) {
                parameters.put("month", Integer.parseInt(params.get("month")));
                sql = "SELECT thong_tin_sanh.ten_sanh, COUNT(*) AS so_luong FROM thong_tin_sanh \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON thong_tin_sanh.id = thong_tin_chi_tiet_dat_tiec.sanh_id \n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id \n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id \n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year \n"
                        + " AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan) = :month AND hoa_don_thanh_toan.isActive = 1\n"
                        + " GROUP BY thong_tin_sanh.ten_sanh";
            } else if (params.containsKey("quarter") && !params.get("quarter").isEmpty()) {
                if (Integer.parseInt(params.get("quarter")) == 1) {
                    parameters.put("startMonth", 1);
                    parameters.put("endMonth", 3);
                } else if (Integer.parseInt(params.get("quarter")) == 2) {
                    parameters.put("startMonth", 4);
                    parameters.put("endMonth", 6);
                } else if (Integer.parseInt(params.get("quarter")) == 3) {
                    parameters.put("startMonth", 7);
                    parameters.put("endMonth", 9);
                } else {
                    parameters.put("startMonth", 10);
                    parameters.put("endMonth", 12);
                }
                sql = "SELECT thong_tin_sanh.ten_sanh, COUNT(*) AS so_luong FROM thong_tin_sanh \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON thong_tin_sanh.id = thong_tin_chi_tiet_dat_tiec.sanh_id \n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id \n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id \n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year  \n"
                        + " AND hoa_don_thanh_toan.isActive = 1 AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan)\n"
                        + " BETWEEN :startMonth AND :endMonth GROUP BY thong_tin_sanh.ten_sanh";
            } else {
                sql = "SELECT thong_tin_sanh.ten_sanh, COUNT(*) AS so_luong FROM thong_tin_sanh \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON thong_tin_sanh.id = thong_tin_chi_tiet_dat_tiec.sanh_id \n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id \n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id \n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year AND hoa_don_thanh_toan.isActive = 1\n"
                        + " GROUP BY thong_tin_sanh.ten_sanh";
            }
        }
        Query query = s.createNativeQuery(sql);
        for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
            query.setParameter(parameter.getKey(), parameter.getValue());
        }
        List<ThongKeMatDoSanhCuoiDTO> response = new ArrayList<>();
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            String columnName = result[0].toString();
            Integer columnValue = ((BigInteger) result[1]).intValue();

            ThongKeMatDoSanhCuoiDTO thongKeMatDoSanhCuoiDTO = new ThongKeMatDoSanhCuoiDTO();
            thongKeMatDoSanhCuoiDTO.setName(columnName);
            thongKeMatDoSanhCuoiDTO.setData(columnValue);
            response.add(thongKeMatDoSanhCuoiDTO);
        }

        return response;
    }

    @Override
    public List<ThongKeMatDoTiecCuoiDTO> thongKeMatDoTiecCuoi(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        String sql = "";

        Map<String, Object> parameters = new HashMap<>();
        if (params.containsKey("year") && !params.get("year").isEmpty()) {
            if (params.containsKey("month") && !params.get("month").isEmpty()) {
                parameters.put("year", Integer.parseInt(params.get("year")));
                parameters.put("month", Integer.parseInt(params.get("month")));
                sql = "SELECT loai_tiec.ten_loai_tiec , COUNT(*) AS so_luong_tiec_cuoi FROM loai_tiec \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON loai_tiec.id = thong_tin_chi_tiet_dat_tiec.loai_tiec_id\n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id\n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id\n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year \n"
                        + " AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan) = :month AND hoa_don_thanh_toan.isActive = 1 \n"
                        + " GROUP BY loai_tiec.ten_loai_tiec";
            } else if (params.containsKey("quarter") && !params.get("quarter").isEmpty()) {
                parameters.put("year", Integer.parseInt(params.get("year")));
                if (Integer.parseInt(params.get("quarter")) == 1) {
                    parameters.put("startMonth", 1);
                    parameters.put("endMonth", 3);
                } else if (Integer.parseInt(params.get("quarter")) == 2) {
                    parameters.put("startMonth", 4);
                    parameters.put("endMonth", 6);
                } else if (Integer.parseInt(params.get("quarter")) == 3) {
                    parameters.put("startMonth", 7);
                    parameters.put("endMonth", 9);
                } else {
                    parameters.put("startMonth", 10);
                    parameters.put("endMonth", 12);
                }

                sql = "SELECT loai_tiec.ten_loai_tiec , COUNT(*) AS so_luong_tiec_cuoi FROM loai_tiec \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON loai_tiec.id = thong_tin_chi_tiet_dat_tiec.loai_tiec_id\n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id\n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id\n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year \n"
                        + " AND hoa_don_thanh_toan.isActive = 1 AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan)\n"
                        + " BETWEEN :startMonth AND :endMonth GROUP BY loai_tiec.ten_loai_tiec";
            } else {
                parameters.put("year", Integer.parseInt(params.get("year")));
                sql = "SELECT loai_tiec.ten_loai_tiec , COUNT(*) AS so_luong_tiec_cuoi FROM loai_tiec \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON loai_tiec.id = thong_tin_chi_tiet_dat_tiec.loai_tiec_id\n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id\n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id\n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year\n"
                        + " AND hoa_don_thanh_toan.isActive = 1 \n"
                        + " GROUP BY loai_tiec.ten_loai_tiec";
            }
        } else {
            parameters.put("year", LocalDate.now().getYear());
            if (params.containsKey("month") && !params.get("month").isEmpty()) {
                parameters.put("month", Integer.parseInt(params.get("month")));
                sql = "SELECT loai_tiec.ten_loai_tiec , COUNT(*) AS so_luong_tiec_cuoi FROM loai_tiec \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON loai_tiec.id = thong_tin_chi_tiet_dat_tiec.loai_tiec_id\n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id\n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id\n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year \n"
                        + " AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan) = :month \n"
                        + " AND hoa_don_thanh_toan.isActive = 1 \n"
                        + " GROUP BY loai_tiec.ten_loai_tiec";
            } else if (params.containsKey("quarter") && !params.get("quarter").isEmpty()) {
                if (Integer.parseInt(params.get("quarter")) == 1) {
                    parameters.put("startMonth", 1);
                    parameters.put("endMonth", 3);
                } else if (Integer.parseInt(params.get("quarter")) == 2) {
                    parameters.put("startMonth", 4);
                    parameters.put("endMonth", 6);
                } else if (Integer.parseInt(params.get("quarter")) == 3) {
                    parameters.put("startMonth", 7);
                    parameters.put("endMonth", 9);
                } else {
                    parameters.put("startMonth", 10);
                    parameters.put("endMonth", 12);
                }
                sql = "SELECT loai_tiec.ten_loai_tiec , COUNT(*) AS so_luong_tiec_cuoi FROM loai_tiec \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON loai_tiec.id = thong_tin_chi_tiet_dat_tiec.loai_tiec_id\n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id\n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id\n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year AND MONTH(hoa_don_thanh_toan.ngay_thanh_toan) "
                        + " BETWEEN :startMonth AND :endMonth \n"
                        + " AND hoa_don_thanh_toan.isActive = 1 \n"
                        + " GROUP BY loai_tiec.ten_loai_tiec";
            } else {
                sql = "SELECT loai_tiec.ten_loai_tiec , COUNT(*) AS so_luong_tiec_cuoi FROM loai_tiec \n"
                        + " JOIN thong_tin_chi_tiet_dat_tiec ON loai_tiec.id = thong_tin_chi_tiet_dat_tiec.loai_tiec_id\n"
                        + " JOIN phieu_dat_ban ON thong_tin_chi_tiet_dat_tiec.id = phieu_dat_ban.chi_tiet_dat_tiec_id\n"
                        + " JOIN hoa_don_thanh_toan ON phieu_dat_ban.id = hoa_don_thanh_toan.phieu_dat_ban_id\n"
                        + " WHERE YEAR(hoa_don_thanh_toan.ngay_thanh_toan) = :year \n"
                        + " AND hoa_don_thanh_toan.isActive = 1 \n"
                        + " GROUP BY loai_tiec.ten_loai_tiec";
            }
        }
        Query query = s.createNativeQuery(sql);
        for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
            query.setParameter(parameter.getKey(), parameter.getValue());
        }
        List<ThongKeMatDoTiecCuoiDTO> response = new ArrayList<>();
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            String columnName = result[0].toString();
            Integer columnValue = ((BigInteger) result[1]).intValue();

            ThongKeMatDoTiecCuoiDTO thongKeMatDoTiecCuoiDTO = new ThongKeMatDoTiecCuoiDTO();
            thongKeMatDoTiecCuoiDTO.setName(columnName);
            thongKeMatDoTiecCuoiDTO.setData(columnValue);
            response.add(thongKeMatDoTiecCuoiDTO);
        }

        return response;
    }

    @Override
    public List<ThongKeDoanhThuDTO> thongKeDoanhThu(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        String sql = "";

        Map<String, Object> parameters = new HashMap<>();
        if (params.containsKey("year") && !params.get("year").isEmpty()) {
            if (params.containsKey("month") && !params.get("month").isEmpty()) {
                parameters.put("year", Integer.parseInt(params.get("year")));
                parameters.put("month", Integer.parseInt(params.get("month")));
                sql = "SELECT month(hd.ngay_thanh_toan), SUM(p.tong_tien) as \"tong_doanh_thu\" FROM phieu_dat_ban as p \n"
                        + " JOIN hoa_don_thanh_toan as hd on p.id = hd.phieu_dat_ban_id \n"
                        + " WHERE month(hd.ngay_thanh_toan) = :month and year(hd.ngay_thanh_toan) = :year and hd.isActive = 1 \n"
                        + " GROUP BY month(hd.ngay_thanh_toan)";
            } else if (params.containsKey("quarter") && !params.get("quarter").isEmpty()) {
                parameters.put("year", Integer.parseInt(params.get("year")));
                if (Integer.parseInt(params.get("quarter")) == 1) {
                    parameters.put("startMonth", 1);
                    parameters.put("endMonth", 3);
                } else if (Integer.parseInt(params.get("quarter")) == 2) {
                    parameters.put("startMonth", 4);
                    parameters.put("endMonth", 6);
                } else if (Integer.parseInt(params.get("quarter")) == 3) {
                    parameters.put("startMonth", 7);
                    parameters.put("endMonth", 9);
                } else {
                    parameters.put("startMonth", 10);
                    parameters.put("endMonth", 12);
                }

                sql = "SELECT month(hd.ngay_thanh_toan), SUM(p.tong_tien) as \"tong_doanh_thu\" \n"
                        + "FROM phieu_dat_ban as p\n"
                        + "JOIN hoa_don_thanh_toan as hd on p.id = hd.phieu_dat_ban_id\n"
                        + "WHERE year(hd.ngay_thanh_toan) = :year and hd.isActive = 1 AND month(hd.ngay_thanh_toan)\n"
                        + " BETWEEN :startMonth AND :endMonth GROUP BY month(hd.ngay_thanh_toan)";
            } else {
                parameters.put("year", Integer.parseInt(params.get("year")));
                sql = "SELECT month(hd.ngay_thanh_toan), SUM(p.tong_tien) as \"tong_doanh_thu\" \n"
                        + "FROM phieu_dat_ban as p\n"
                        + "JOIN hoa_don_thanh_toan as hd on p.id = hd.phieu_dat_ban_id\n"
                        + "WHERE year(hd.ngay_thanh_toan) = :year and hd.isActive = 1\n"
                        + "GROUP BY month(hd.ngay_thanh_toan)";
            }
        } else {
            parameters.put("year", LocalDate.now().getYear());
            if (params.containsKey("month") && !params.get("month").isEmpty()) {
                parameters.put("month", Integer.parseInt(params.get("month")));
                sql = "SELECT month(hd.ngay_thanh_toan), SUM(p.tong_tien) as \"tong_doanh_thu\" FROM phieu_dat_ban as p \n"
                        + " JOIN hoa_don_thanh_toan as hd on p.id = hd.phieu_dat_ban_id \n"
                        + " WHERE month(hd.ngay_thanh_toan) = :month and year(hd.ngay_thanh_toan) = :year and hd.isActive = 1 \n"
                        + " GROUP BY month(hd.ngay_thanh_toan)";
            } else if (params.containsKey("quarter") && !params.get("quarter").isEmpty()) {
                if (Integer.parseInt(params.get("quarter")) == 1) {
                    parameters.put("startMonth", 1);
                    parameters.put("endMonth", 3);
                } else if (Integer.parseInt(params.get("quarter")) == 2) {
                    parameters.put("startMonth", 4);
                    parameters.put("endMonth", 6);
                } else if (Integer.parseInt(params.get("quarter")) == 3) {
                    parameters.put("startMonth", 7);
                    parameters.put("endMonth", 9);
                } else {
                    parameters.put("startMonth", 10);
                    parameters.put("endMonth", 12);
                }
                sql = "SELECT month(hd.ngay_thanh_toan), SUM(p.tong_tien) as \"tong_doanh_thu\" FROM phieu_dat_ban as p \n"
                        + " JOIN hoa_don_thanh_toan as hd on p.id = hd.phieu_dat_ban_id \n"
                        + " WHERE year(hd.ngay_thanh_toan) = :year and hd.isActive = 1 AND  month(hd.ngay_thanh_toan) "
                        + " BETWEEN :startMonth AND :endMonth \n"
                        + " GROUP BY month(hd.ngay_thanh_toan)";
            } else {
                sql = "SELECT month(hd.ngay_thanh_toan), SUM(p.tong_tien) as \"tong_doanh_thu\" \n"
                        + "FROM phieu_dat_ban as p\n"
                        + "JOIN hoa_don_thanh_toan as hd on p.id = hd.phieu_dat_ban_id\n"
                        + "WHERE year(hd.ngay_thanh_toan) = :year and hd.isActive = 1\n"
                        + "GROUP BY month(hd.ngay_thanh_toan)";
            }
        }
        Query query = s.createNativeQuery(sql);
        for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
            query.setParameter(parameter.getKey(), parameter.getValue());
        }
        List<ThongKeDoanhThuDTO> response = new ArrayList<>();
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            String columnTime = result[0].toString();
            String columnValue = result[1].toString();

            ThongKeDoanhThuDTO thongKeDoanhThuDTO = new ThongKeDoanhThuDTO();
            thongKeDoanhThuDTO.setTime(columnTime);
            thongKeDoanhThuDTO.setData(columnValue);
            response.add(thongKeDoanhThuDTO);
        }

        return response;
    }

}
