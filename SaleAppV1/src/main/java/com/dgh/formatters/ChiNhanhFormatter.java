/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.formatters;

import com.dgh.pojo.ChiNhanh;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class ChiNhanhFormatter implements Formatter<ChiNhanh> {

    @Override
    public String print(ChiNhanh chiNhanh, Locale locale) {
        return String.valueOf(chiNhanh.getId());
    }

    @Override
    public ChiNhanh parse(String chiNhanhId, Locale locale) throws ParseException {
        return new ChiNhanh(Integer.parseInt(chiNhanhId));
    }

}
