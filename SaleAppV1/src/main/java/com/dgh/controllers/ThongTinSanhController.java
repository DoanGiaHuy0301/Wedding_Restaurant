/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.ThongTinSanh;
import com.dgh.service.ThongTinSanhService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class ThongTinSanhController {

    @Autowired
    private ThongTinSanhService thongTinSanhService;
    @Autowired
    private Environment env;

    @GetMapping("/thongTinSanh")
    public String list(Model model, @RequestParam Map<String, String> params) {

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.thongTinSanhService.countThongTinSanh();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "thongTinSanh";
    }

    @GetMapping("/themSanh")
    public String listAdd(Model model) {
        model.addAttribute("themSanh", new ThongTinSanh());
        return "themSanh";
    }

    @GetMapping("/themSanh/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("themSanh", this.thongTinSanhService.getSanhById(id));
        return "themSanh";
    }

    @PostMapping("/themSanh")
    public String add(@ModelAttribute(value = "themSanh") @Valid ThongTinSanh s,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.thongTinSanhService.addOrUpdateSanh(s) == true) {
                return "redirect:thongTinSanh";
            }
        }
        return "themSanh";
    }
}
