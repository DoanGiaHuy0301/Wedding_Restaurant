/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.dto.ThongKeDoanhThuDTO;
import com.dgh.dto.ThongKeMatDoSanhCuoiDTO;
import com.dgh.dto.ThongKeMatDoTiecCuoiDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ThongKeService {
    List<ThongKeMatDoSanhCuoiDTO> thongKeMatDoSanhCuoi(Map<String, String> params);
    List<ThongKeMatDoTiecCuoiDTO> thongKeMatDoTiecCuoi(Map<String, String> params);
    List<ThongKeDoanhThuDTO> thongKeDoanhThu(Map<String, String> params);
}
