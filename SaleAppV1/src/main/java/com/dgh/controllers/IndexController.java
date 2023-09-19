/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.service.AnhSanhService;
import com.dgh.service.ChiNhanhService;
import com.dgh.service.ChucVuService;
import com.dgh.service.DichVuService;
import com.dgh.service.LoaiTiecService;
import com.dgh.service.NhanVienService;
import com.dgh.service.ThongTinSanhService;
import com.dgh.service.ThucDonService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {

    @Autowired
    private LoaiTiecService loaiTiecService;
    @Autowired
    private ChiNhanhService chiNhanhService;
    @Autowired
    private DichVuService dichVuService;
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private ThucDonService thucDonService;
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private ThongTinSanhService thongTinSanhService;
    @Autowired
    private AnhSanhService anhSanhService;

    @ModelAttribute
    public void commonAttri(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("chiNhanh", this.chiNhanhService.getDanhSachChiNhanh(params));
        model.addAttribute("chucVu", this.chucVuService.getChucVu());
        model.addAttribute("thongTinSanh", this.thongTinSanhService.getThongTinSanh(params));
        model.addAttribute("loaiTiec", this.loaiTiecService.getLoaiTiec(params));
        model.addAttribute("anhSanh", this.anhSanhService.getAnhSanh());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        return "index";
    }
}
