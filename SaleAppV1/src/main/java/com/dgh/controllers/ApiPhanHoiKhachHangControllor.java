/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.PhanHoiKhachHang;
import com.dgh.service.PhanHoiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiPhanHoiKhachHangControllor {
    @Autowired
    private PhanHoiKhachHangService phanHoiService;
    
    @PostMapping(path="/phanHoiKhachHang/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<PhanHoiKhachHang> themPhanHoi(@RequestBody PhanHoiKhachHang phanHoi) {
        PhanHoiKhachHang ph = this.phanHoiService.themPhanHoi(phanHoi);
        
        return new ResponseEntity<>(ph, HttpStatus.CREATED);
    }
}
