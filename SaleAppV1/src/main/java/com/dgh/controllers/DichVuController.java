/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.DichVu;
import com.dgh.service.DichVuService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class DichVuController {

    @Autowired
    private DichVuService dichVuService;

    @GetMapping("/dichVu")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("dichVu", this.dichVuService.getDichVu(params));
        return "dichVu";
    }

    @GetMapping("/themDichVu")
    public String listAdd(Model model) {
        model.addAttribute("themDichVu", new DichVu());
        return "themDichVu";
    }

    @GetMapping("/themDichVu/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("themDichVu", this.dichVuService.getDichVuById(id));
        return "themDichVu";
    }

    @PostMapping("/themDichVu")
    public String add(@ModelAttribute(value = "themDichVu") @Valid DichVu dv,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.dichVuService.addOrUpdateDichVu(dv) == true) {
                return "redirect:dichVu";
            }
        }

        return "themDichVu";
    }
}
