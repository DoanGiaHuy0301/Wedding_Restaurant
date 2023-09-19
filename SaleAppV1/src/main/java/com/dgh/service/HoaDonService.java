/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.dto.HoaDonDTO;
import com.dgh.dto.HoaDonDaThanhToanOnlineDTO;
import com.dgh.pojo.HoaDonThanhToan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface HoaDonService {
    HoaDonDTO getHoaDonDtoById(int id);
    HoaDonDTO getHoaDonChoNhanVienByPhieuDatBanId(int id);
    List<HoaDonDTO> getHoaDonDtoBySoDienThoai(String soDienThoai);
    HoaDonDaThanhToanOnlineDTO getHoaDonDaThanhToanByPhieuDatBanId(int id);
    boolean ThanhToanHoaHon (Map<String, String> params);
    boolean ThanhToanHoaDonNhanVien(Map<String, String> params);
}
