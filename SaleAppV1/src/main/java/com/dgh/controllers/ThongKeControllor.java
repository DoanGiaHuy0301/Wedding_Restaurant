/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.service.ThongKeService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class ThongKeControllor {
    @Autowired
    private ThongKeService thongKeService;
    
    @GetMapping("/thongKeSanh")
    public String listSanh(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("thongKe", this.thongKeService.thongKeMatDoSanhCuoi(params));
        return "thongKeSanh";
    }
    
    @GetMapping("/thongKeTiecCuoi")
    public String listTiecCuoi(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("thongKeTiecCuoi", this.thongKeService.thongKeMatDoTiecCuoi(params));
        return "thongKeTiecCuoi";
    }
    
    @GetMapping("/thongKeDoanhThu")
    public String doanhThu(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("thongKeDoanhThu", this.thongKeService.thongKeDoanhThu(params));
        return "thongKeDoanhThu";
    }
    
    
}
