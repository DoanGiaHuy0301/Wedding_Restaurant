/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.AnhSanh;
import com.dgh.service.AnhSanhService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class AnhSanhControllor {

    @Autowired
    private AnhSanhService anhSanhService;

    @GetMapping("/anhSanh")
    public String list() {
        return "anhSanh";
    }

    @GetMapping("/themAnhSanh")
    public String listAdd(Model model) {
        model.addAttribute("themAnhSanh", new AnhSanh());
        return "themAnhSanh";
    }

    @GetMapping("/themAnhSanh/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("themAnhSanh", this.anhSanhService.getAnhSanhById(id));
        return "themAnhSanh";
    }

    @PostMapping("/themAnhSanh")
    public String add(@ModelAttribute(value = "themAnhSanh") @Valid AnhSanh as,
            BindingResult rs) {
            if (this.anhSanhService.addOrUploadAnhSanh(as) == true) {
                return "redirect:anhSanh";
            }
        
        return "themAnhSanh";
    }

}
