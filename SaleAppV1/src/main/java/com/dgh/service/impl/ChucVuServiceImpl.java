/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.ChucVu;
import com.dgh.repository.ChucVuRepository;
import com.dgh.service.ChucVuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepo;

    @Override
    public List<ChucVu> getChucVu() {
        return this.chucVuRepo.getChucVu();
    }

    @Override
    public ChucVu getChucVuById(int id) {
        return this.chucVuRepo.getChucVuById(id);
    }

//    @Override
//    public ChucVu getChucVuNativeById(int id) {
//        return this.chucVuRepo.getChucVuNativeById(id);
//    }

}
