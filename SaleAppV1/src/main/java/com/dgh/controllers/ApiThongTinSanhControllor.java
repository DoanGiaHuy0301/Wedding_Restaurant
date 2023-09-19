/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.ThongTinSanh;
import com.dgh.service.ThongTinSanhService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiThongTinSanhControllor {
    @Autowired
    private ThongTinSanhService thongTinSanhService;
    
    @PutMapping("/thongTinSanh/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.thongTinSanhService.deleteSanh(id);
    }
    
    @GetMapping("/thongTinSanh/")
    @CrossOrigin
    public ResponseEntity<List<ThongTinSanh>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.thongTinSanhService.getThongTinSanh(params), HttpStatus.OK);
    }
    
    @GetMapping("/thongTinSanhChuaDat/")
    @CrossOrigin
    public ResponseEntity<List<ThongTinSanh>> listSanhChuaDat(@RequestParam String date) {
        return new ResponseEntity<>(this.thongTinSanhService.getSanhChuaDuocDat(date), HttpStatus.OK);
    }
}
