/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.dto.NhanVienDTO;
import com.dgh.pojo.NhanVien;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface NhanVienRepository {

    List<NhanVienDTO> getNhanVien(Map<String, String> params);

    boolean addNhanVien(NhanVien nv);

    NhanVien getNhanVienById(int id);

    NhanVien getNhanVienByTaiKhoanId(int id);

    boolean deleteNhanVienById(int id);

    Long countNhanVien();

}
