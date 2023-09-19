/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.pojo.ChiNhanh;
import java.util.List;
import java.util.Map;


/**
 *
 * @author DELL
 */
public interface ChiNhanhRepository {
    List<ChiNhanh> getDanhSachChiNhanh(Map<String, String> params);
    boolean addOrUpdateChiNhanh(ChiNhanh cn);
    ChiNhanh getChiNhanhById(int id);
    boolean deleteChiNhanhById(int id);
}
