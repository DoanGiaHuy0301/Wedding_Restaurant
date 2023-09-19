/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.ThucDon;
import com.dgh.service.ThucDonService;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class ThucDonController {

    @Autowired
    private ThucDonService thucDonService;

    @GetMapping("/thucDon")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("thucDon", this.thucDonService.getThucDon(params));
        return "thucDon";
    }

    @GetMapping("/themThucDon")
    public String listAdd(Model model) {
        model.addAttribute("themThucDon", new ThucDon());
        return "themThucDon";
    }

    @GetMapping("/themThucDon/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("themThucDon", this.thucDonService.getThucDonById(id));
        return "themThucDon";
    }

    @PostMapping("/themThucDon")
    public String add(@ModelAttribute(value = "themThucDon") @Valid ThucDon td,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.thucDonService.addOrUpdateThucDon(td) == true) {
                return "redirect:thucDon";
            }
        }

        return "themThucDon";
    }
}
