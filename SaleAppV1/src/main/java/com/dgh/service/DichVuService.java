/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.DichVu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface DichVuService {
    List<DichVu> getDichVu(Map<String, String> params);
    boolean addOrUpdateDichVu(DichVu dv);
    DichVu getDichVuById(int id);
    boolean deleteDichVu(int id);
}
