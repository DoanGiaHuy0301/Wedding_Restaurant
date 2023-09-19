/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.dto.ThongTinKhachHangDatTiecDTO;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ThongTinDatTiecService {
    ThongTinKhachHangDatTiecDTO datTiec(Map<String, String> params);
}
