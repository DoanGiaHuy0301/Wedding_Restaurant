/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.pojo.ThucDon;
import java.util.List;
import java.util.Map;


/**
 *
 * @author DELL
 */
public interface ThucDonRepository {
    List<ThucDon> getThucDon(Map<String, String> params);
    boolean addOrUpdateThucDon(ThucDon td);
    ThucDon getThucDonById(int id);
    boolean deleteThucDonById(int id);
}
