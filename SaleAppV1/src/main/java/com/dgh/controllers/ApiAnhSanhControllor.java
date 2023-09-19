/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.AnhSanh;
import com.dgh.service.AnhSanhService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ApiAnhSanhControllor {

    @Autowired
    private AnhSanhService anhSanhService;

    @DeleteMapping("/anhSanh/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.anhSanhService.deleteAnhSanh(id);
    }

    @GetMapping("/anhSanh/")
    @CrossOrigin
    public ResponseEntity<List<AnhSanh>> list(@RequestParam  String loaiSanh) {
        List<AnhSanh> anhSanhList = this.anhSanhService.getAnhSanhByLoaiSanh(loaiSanh);
        return new ResponseEntity<>(anhSanhList, HttpStatus.OK);
    }
}
