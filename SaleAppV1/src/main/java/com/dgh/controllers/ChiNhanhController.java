/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.ChiNhanh;
import com.dgh.service.ChiNhanhService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class ChiNhanhController {

    @Autowired
    private ChiNhanhService chiNhanhService;

    @GetMapping("/chiNhanh")
    public String list(Model model, @RequestParam Map<String, String> params) {
        return "chiNhanh";
    }
    
    
    @GetMapping("/themChiNhanh")
    public String listAdd(Model model) {
        model.addAttribute("themChiNhanh", new ChiNhanh());
        return "themChiNhanh";
    }
    
     @GetMapping("/themChiNhanh/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("themChiNhanh", this.chiNhanhService.getChiNhanhById(id));
        return "themChiNhanh";
    }


    @PostMapping("/themChiNhanh")
    public String add(@ModelAttribute(value = "themChiNhanh") @Valid ChiNhanh cn,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.chiNhanhService.addOrUpdateChiNhanh(cn) == true) {
                return "redirect:chiNhanh";
            }
        }
        return "themChiNhanh";
    }
}
