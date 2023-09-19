/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.dto.HoaDonDTO;
import com.dgh.dto.HoaDonDaThanhToanOnlineDTO;
import com.dgh.pojo.HoaDonThanhToan;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface HoaDonRepository {

    HoaDonDTO getHoaDonDtoByPhieuDatBanId(int id);
    
    HoaDonDTO getHoaDonChoNhanVienByPhieuDatBanId(int id);

    List<HoaDonDTO> getHoaDonDtoBySoDienThoai(String soDienThoai);

    HoaDonDaThanhToanOnlineDTO getHoaDonDaThanhToanByPhieuDatBanId(int id);

    HoaDonThanhToan addThanhToanHoaDon(HoaDonThanhToan hd);
    
    boolean updateHoaDon(HoaDonThanhToan hd);
    
    HoaDonThanhToan getHoaDonById(int id);
}
