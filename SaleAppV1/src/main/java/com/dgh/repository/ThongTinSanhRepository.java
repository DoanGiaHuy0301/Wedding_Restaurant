/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.pojo.ThongTinSanh;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *
 * @author DELL
 */
public interface ThongTinSanhRepository {
    List<ThongTinSanh> getThongTinSanh(Map<String, String> params);
    boolean addOrUpdateSanh(ThongTinSanh s);
    ThongTinSanh getSanhById(int id);
    boolean deleteSanh(int id);
    Long countThongTinSanh();
    List<ThongTinSanh> getSanhChuaDuocDat(String date);
}
