/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.dto.HoaDonDTO;
import com.dgh.pojo.PhieuDatBan;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface PhieuDatBanRepository {
    PhieuDatBan themPhieu(PhieuDatBan p);
    PhieuDatBan getPhieuDatBanById(int id);
    boolean updatePayPhieuDatBan(PhieuDatBan p);
    List<HoaDonDTO> getPhieuDatBanBySoDienThoai(String soDienThoai);
}
