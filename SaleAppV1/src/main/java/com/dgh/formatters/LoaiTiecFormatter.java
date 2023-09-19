/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.formatters;

import com.dgh.pojo.LoaiTiec;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class LoaiTiecFormatter implements Formatter<LoaiTiec>{

    @Override
    public String print(LoaiTiec loaiTiec, Locale locale) {
        return String.valueOf(loaiTiec.getId());
    }

    @Override
    public LoaiTiec parse(String loaiTiecId, Locale locale) throws ParseException {
       return new LoaiTiec(Integer.parseInt(loaiTiecId));
    }
    
}
