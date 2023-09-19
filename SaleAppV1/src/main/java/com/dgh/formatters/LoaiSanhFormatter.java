/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.formatters;

import com.dgh.pojo.ThongTinSanh;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class LoaiSanhFormatter implements Formatter<ThongTinSanh>{

    @Override
    public String print(ThongTinSanh loaiSanh, Locale locale) {
        return String.valueOf(loaiSanh.getId());
    }

    @Override
    public ThongTinSanh parse(String sanhId, Locale locale) throws ParseException {
        return new ThongTinSanh(Integer.parseInt(sanhId));
    }
    
}
