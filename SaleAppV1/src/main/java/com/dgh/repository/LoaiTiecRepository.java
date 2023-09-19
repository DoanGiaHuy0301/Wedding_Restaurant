/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.pojo.LoaiTiec;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface LoaiTiecRepository {
    List<LoaiTiec> getLoaiTiec(Map<String, String> params);
    boolean addOrUpdateLoaiTiec(LoaiTiec l);
    LoaiTiec getLoaiTiecById(int id);
    boolean deleteLoaiTiec(int id);
}
