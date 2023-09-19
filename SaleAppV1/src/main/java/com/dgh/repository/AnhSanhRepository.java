/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.pojo.AnhSanh;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface AnhSanhRepository {
    List<AnhSanh> getAnhSanh();
    boolean addOrUploadAnhSanh(AnhSanh as);
    AnhSanh getAnhSanhById(int id);
    boolean deleteAnhSanh(int id);
    List<AnhSanh> getAnhSanhByLoaiSanh(String loaiSanh);
}
