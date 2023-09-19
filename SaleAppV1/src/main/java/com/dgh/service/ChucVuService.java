/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.ChucVu;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ChucVuService {
    List<ChucVu> getChucVu();
    ChucVu getChucVuById(int id);
//    ChucVu getChucVuNativeById(int id);
}
