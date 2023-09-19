/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.NhanVien;
import com.dgh.service.ChiNhanhService;
import com.dgh.service.ChucVuService;
import com.dgh.service.NhanVienService;
import com.dgh.service.TaiKhoanService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class NhanVienController {

    @Autowired
    private Environment env;
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/nhanVien")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("nhanVien", this.nhanVienService.getNhanVien(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.nhanVienService.countNhanVien();
        model.addAttribute("counterNV", Math.ceil(count * 1.0 / pageSize));
        return "nhanVien";
    }

    @GetMapping("/themNhanVien")
    public String listAdd(Model model) {
        model.addAttribute("themNhanVien", new NhanVien());
        return "themNhanVien";
    }

    @PostMapping("/themNhanVien")
    public String themNhanVien(@ModelAttribute(value = "themNhanVien") @Valid NhanVien nv,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.taiKhoanService.addTaiKhoan(nv.getTaiKhoanId()) == true) {
                if (this.nhanVienService.addNhanVien(nv) == true) {
                    return "redirect:nhanVien";
                }
            }
        }
        return "themNhanVien";
    }

}
