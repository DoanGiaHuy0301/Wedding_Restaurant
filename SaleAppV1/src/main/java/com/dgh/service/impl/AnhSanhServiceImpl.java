/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dgh.pojo.AnhSanh;
import com.dgh.repository.AnhSanhRepository;
import com.dgh.service.AnhSanhService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class AnhSanhServiceImpl implements AnhSanhService{

    @Autowired
    private AnhSanhRepository AnhSanhRepo;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<AnhSanh> getAnhSanh() {
        return this.AnhSanhRepo.getAnhSanh();
    }

    @Override
    public boolean addOrUploadAnhSanh(AnhSanh as) {
        if (!as.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(as.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                as.setAnhSanh(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(AnhSanhServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return this.AnhSanhRepo.addOrUploadAnhSanh(as);
    }

    @Override
    public AnhSanh getAnhSanhById(int id) {
        return this.AnhSanhRepo.getAnhSanhById(id);
    }

    @Override
    public boolean deleteAnhSanh(int id) {
        return this.AnhSanhRepo.deleteAnhSanh(id);
    }

    @Override
    public List<AnhSanh> getAnhSanhByLoaiSanh(String loaiSanh) {
        return this.AnhSanhRepo.getAnhSanhByLoaiSanh(loaiSanh);
    }
    
}
