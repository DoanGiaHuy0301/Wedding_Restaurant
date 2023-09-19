/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.dto.ThongTinKhachHangDatTiecDTO;
import com.dgh.pojo.DichVu;
import com.dgh.pojo.LoaiTiec;
import com.dgh.pojo.PhieuDatBan;
import com.dgh.pojo.ThongTinChiTietDatTiec;
import com.dgh.pojo.ThongTinChiTietKhachHangDatTiec;
import com.dgh.pojo.ThongTinSanh;
import com.dgh.pojo.ThucDon;
import com.dgh.repository.DichVuRepository;
import com.dgh.repository.LoaiTiecRepository;
import com.dgh.repository.PhieuDatBanRepository;
import com.dgh.repository.ThongTinChiTiecDatTiecRepository;
import com.dgh.repository.ThongTinChiTiecKhachHangDatTiecRepository;
import com.dgh.repository.ThongTinSanhRepository;
import com.dgh.repository.ThucDonRepository;
import com.dgh.service.ThongTinDatTiecService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ThongTinDatTiecServiceImpl implements ThongTinDatTiecService{
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    @Autowired
    private ThongTinChiTiecDatTiecRepository chiTiecDatTiecRepo;
    @Autowired
    private ThongTinChiTiecKhachHangDatTiecRepository chiTiecKhachHangRepo;
    @Autowired
    private ThongTinSanhRepository thongTinSanhRepo;
    @Autowired
    private ThucDonRepository thucDonRepo;
    @Autowired 
    private LoaiTiecRepository loaiTiecRepo;
    @Autowired
    private DichVuRepository dichVuRepo;
    @Autowired 
    private PhieuDatBanRepository phieuDatBanRepo;

    @Override
    public ThongTinKhachHangDatTiecDTO datTiec(Map<String, String> params) {
        
        ThongTinChiTietDatTiec ctdt = new ThongTinChiTietDatTiec();
        
        ThongTinSanh s = this.thongTinSanhRepo.getSanhById(Integer.parseInt(params.get("sanhId")));
        ThucDon td = this.thucDonRepo.getThucDonById(Integer.parseInt(params.get("thucDonId")));
        DichVu dv = this.dichVuRepo.getDichVuById(Integer.parseInt(params.get("dichVuId")));
        LoaiTiec lt = this.loaiTiecRepo.getLoaiTiecById(Integer.parseInt(params.get("loaiTiecId")));
        
        ctdt.setSoLuongBan(params.get("soLuongBan"));
        ctdt.setCa(params.get("ca"));
        ctdt.setSanhId(s);
        ctdt.setIsDelete(false);
        ctdt.setThucDonId(td);
        ctdt.setDichVuId(dv);
        ctdt.setLoaiTiecId(lt);
        
        ThongTinChiTietDatTiec dt = this.chiTiecDatTiecRepo.themChiTiecDatTiec(ctdt);
        
        ThongTinChiTietKhachHangDatTiec ctkh = new ThongTinChiTietKhachHangDatTiec();
        String ngayToChucString = params.get("ngayToChuc");
        Date ngayToChuc = null;
        
        try {
            ngayToChuc = simpleDateFormat.parse(ngayToChucString);
        } catch (ParseException ex) {
             ex.printStackTrace();
        }
        ctkh.setTenKhachHang(params.get("tenKhachHang"));
        ctkh.setNgayToChuc(ngayToChuc);
        ctkh.setSoDienThoai(params.get("soDienThoai"));
        ctkh.setDiaChi(params.get("diaChi"));
        ctkh.setIsDelete(false);
        
        ThongTinChiTietKhachHangDatTiec kh = this.chiTiecKhachHangRepo.themChiTiecKhachHang(ctkh);
        
        PhieuDatBan phieuDatBan = new PhieuDatBan();
        phieuDatBan.setNgayXuatPhieu(new Date());
        phieuDatBan.setChiTietDatTiecId(ctdt);
        phieuDatBan.setChiTietKhachHangId(ctkh);
        
        PhieuDatBan p = this.phieuDatBanRepo.themPhieu(phieuDatBan);
        
        ThongTinKhachHangDatTiecDTO datTiecDTO = new ThongTinKhachHangDatTiecDTO();
        datTiecDTO.setId(p.getId());
        datTiecDTO.setTenKhachHang(kh.getTenKhachHang());
        datTiecDTO.setNgayToChuc(kh.getNgayToChuc());
        datTiecDTO.setSoDienThoai(kh.getSoDienThoai());
        datTiecDTO.setDiaChi(kh.getDiaChi());
        datTiecDTO.setSoLuongBan(dt.getSoLuongBan());
        datTiecDTO.setCa(dt.getCa());
        datTiecDTO.setSanhId(dt.getSanhId().getId());
        datTiecDTO.setLoaiTiecId(dt.getLoaiTiecId().getId());
        datTiecDTO.setThucDonId(dt.getThucDonId().getId());
        datTiecDTO.setDichVuId(dt.getDichVuId().getId());
        
        return datTiecDTO;
    }
    
}
