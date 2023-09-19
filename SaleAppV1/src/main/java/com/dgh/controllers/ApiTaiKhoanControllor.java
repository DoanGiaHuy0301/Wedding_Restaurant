/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.components.JwtService;
import com.dgh.dto.KhachHangTaiKhoanDTO;
import com.dgh.pojo.KhachHang;
import com.dgh.pojo.TaiKhoan;
import com.dgh.service.TaiKhoanService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class ApiTaiKhoanControllor {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody TaiKhoan user) {
        try {
            TaiKhoan u = this.taiKhoanService.getTaiKhoanByTenDangNhap(user.getTenDangNhap());
            int id = u.getId();
            
            if (u.getId() != -1 && (u.getVaiTro().equals("ROLE_USER") || u.getVaiTro().equals("ROLE_STAFF"))) {
                if (this.taiKhoanService.authUser(user.getTenDangNhap(), user.getMatKhau()) == true) {
                    String token = this.jwtService.generateTokenLogin(user.getTenDangNhap());

                    return new ResponseEntity<>(token, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("Sai tên đăng nhập hoặc mật khẩu", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
             return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    

    @PostMapping(path = "/users/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<KhachHangTaiKhoanDTO> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        KhachHangTaiKhoanDTO user = this.taiKhoanService.addUser(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<TaiKhoan> details(Principal user) {
        if (user == null) {
            return null;
        }
        TaiKhoan u = this.taiKhoanService.getTaiKhoanByTenDangNhap(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    
    @PostMapping("/username-exist/")
    @CrossOrigin
    public ResponseEntity<?> isExistUsername(@RequestParam String tenDangNhap) {
        if (this.taiKhoanService.kiemTratenDangNhapTonTai(tenDangNhap)) {
            return ResponseEntity.badRequest().body("Tên đăng nhập đã tồn tại");
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
