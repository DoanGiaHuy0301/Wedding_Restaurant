/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.dto.HoaDonDTO;
import com.dgh.dto.HoaDonDaThanhToanOnlineDTO;
import com.dgh.dto.KhachHangTaiKhoanDTO;
import com.dgh.dto.ThongTinKhachHangDatTiecDTO;
import com.dgh.service.HoaDonService;
import com.dgh.service.PhieuDatBanService;
import com.dgh.service.ThongTinDatTiecService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiDatTiecController {
    @Autowired
    private ThongTinDatTiecService thongTinDatTiecService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private PhieuDatBanService phieuDatBanService;
    
    @PostMapping(path = "/datTiec/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<ThongTinKhachHangDatTiecDTO> addPhieu(@RequestParam Map<String, String> params) {
        ThongTinKhachHangDatTiecDTO datTiecDto = this.thongTinDatTiecService.datTiec(params);
        return new ResponseEntity<>(datTiecDto, HttpStatus.CREATED);
    }
    
    @GetMapping("/thanhToan/")
    @CrossOrigin
    public ResponseEntity<HoaDonDTO> getBill(@RequestParam  int id) {
        HoaDonDTO hoaDon = this.hoaDonService.getHoaDonDtoById(id);
        return new ResponseEntity<>(hoaDon, HttpStatus.OK);
    }
    
    @GetMapping("/hoaDonKhachHang/")
    @CrossOrigin
    public ResponseEntity<HoaDonDTO> getHoaDonByNhanVien(@RequestParam  int id) {
        HoaDonDTO hoaDon = this.hoaDonService.getHoaDonChoNhanVienByPhieuDatBanId(id);
        return new ResponseEntity<>(hoaDon, HttpStatus.OK);
    }
    
    @GetMapping("/hoaDon/")
    @CrossOrigin
    public ResponseEntity<List<HoaDonDTO>> getHoaDonChuaThanhToan(@RequestParam  String soDienThoai) {
        List<HoaDonDTO> hoaDon = this.hoaDonService.getHoaDonDtoBySoDienThoai(soDienThoai);
        return new ResponseEntity<>(hoaDon, HttpStatus.OK);
    }
    
    @GetMapping("/phieuDatBan/")
    @CrossOrigin
    public ResponseEntity<List<HoaDonDTO>> getPhieuDatBan(@RequestParam  String soDienThoai) {
        List<HoaDonDTO> phieuDatBan = this.phieuDatBanService.getPhieuDatBanBySoDienThoai(soDienThoai);
        return new ResponseEntity<>(phieuDatBan, HttpStatus.OK);
    }
    
    @GetMapping("/daThanhToan/")
    @CrossOrigin
    public ResponseEntity<HoaDonDaThanhToanOnlineDTO> getBillIsSuccess(@RequestParam  int id) {
        HoaDonDaThanhToanOnlineDTO hoaDon = this.hoaDonService.getHoaDonDaThanhToanByPhieuDatBanId(id);
        return new ResponseEntity<>(hoaDon, HttpStatus.OK);
    }
    
    @PostMapping("/thanhToanMomo/")
    @CrossOrigin
    public ResponseEntity<Boolean> pay(@RequestParam Map<String, String> params) {
        boolean isSuccess = this.hoaDonService.ThanhToanHoaHon(params) ;
        if(isSuccess) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        
    }
    
//    Nhân viên thanh toán cho khách hàng tại quầy
    @PostMapping("/thanhToanHoaDon/")
    @CrossOrigin
    public ResponseEntity<Boolean> payBillByNhanVien(@RequestParam Map<String, String> params) {
        boolean isSuccess = this.hoaDonService.ThanhToanHoaDonNhanVien(params) ;
        if(isSuccess) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        
    }
    
}
