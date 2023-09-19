/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.formatters;

import com.dgh.pojo.ChucVu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class ChucVuFormatter implements Formatter<ChucVu> {

    @Override
    public String print(ChucVu chucVu, Locale locale) {
        return String.valueOf(chucVu.getId());
    }

    @Override
    public ChucVu parse(String chucVuId, Locale locale) throws ParseException {
        return new ChucVu(Integer.parseInt(chucVuId));
    }

}
