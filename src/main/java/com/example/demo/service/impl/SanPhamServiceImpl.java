package com.example.demo.service.impl;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.Hang;
import com.example.demo.entity.SanPham;
import com.example.demo.reponsitosy.DanhMucRepo;
import com.example.demo.reponsitosy.HangRepo;
import com.example.demo.reponsitosy.SanPhamRepo;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private DanhMucRepo danhMucRepo;

    @Autowired
    private HangRepo hangRepo;

    @Override
    public Map<String, String> kiemTraLoiThemSanPham(String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa) {
        Map<String, String> loi = new HashMap<>();

        if (tenSanPham == null || tenSanPham.trim().isEmpty()) {
            loi.put("errorTenSanPham", "Tên sản phẩm không được để trống!");
        }
        if (sanPhamRepo.existsByTen(tenSanPham)) {
            loi.put("errorTenSanPhamTrung", "Tên sản phẩm đã tồn tại!");
        }
        if (soLuong <= 0) {
            loi.put("errorSoLuong", "Số lượng phải lớn hơn 0!");
        }
        if (giaBan < 0) {
            loi.put("errorGiaBan", "Giá bán không được âm!");
        }
        if (urlAnh == null || urlAnh.trim().isEmpty()) {
            loi.put("errorUrlAnh", "Url ảnh không được để trống!");
        }

        DanhMuc danhMuc = danhMucRepo.findById(idDanhMuc).orElse(null);
        Hang hang = hangRepo.findById(idHang).orElse(null);
        if (danhMuc == null) {
            loi.put("errorDM", "Bạn chưa chọn danh mục");
        }
        if (hang == null) {
            loi.put("errorTH", "Bạn chưa chọn thương hiệu.");
        }

        return loi;
    }
    @Override
    public Map<String, String> kiemTraLoiSuaSanPham(Long id, String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa) {
        Map<String, String> loi = new HashMap<>();

        // Kiểm tra xem sản phẩm có tồn tại không
        if (!sanPhamRepo.existsById(id)) {
            loi.put("errorSanPhamKhongTonTai", "Sản phẩm không tồn tại.");
        }
        if (tenSanPham == null || tenSanPham.trim().isEmpty()) {
            loi.put("errorTenSanPham", "Tên sản phẩm không được để trống!");
        }
        if (soLuong <= 0) {
            loi.put("errorSoLuong", "Số lượng phải lớn hơn 0!");
        }
        if (giaBan < 0) {
            loi.put("errorGiaBan", "Giá bán không được âm!");
        }
        if (urlAnh == null || urlAnh.trim().isEmpty()) {
            loi.put("errorUrlAnh", "Url ảnh không được để trống!");
        }

        DanhMuc danhMuc = danhMucRepo.findById(idDanhMuc).orElse(null);
        Hang hang = hangRepo.findById(idHang).orElse(null);
        if (danhMuc == null) {
            loi.put("errorDM", "Bạn chưa chọn danh mục!");
        }
        if (hang == null) {
            loi.put("errorTH", "Bạn chưa chọn thương hiệu!");
        }

        return loi;
    }

    @Override
    public SanPham themSanPham(String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa) {
        SanPham sanPham = new SanPham();
        sanPham.setTen(tenSanPham);
        sanPham.setSoLuongTon(soLuong);
        sanPham.setGiaBan(giaBan);
        sanPham.setUrlAnh(urlAnh);
        sanPham.setNgayTao(new Date());
        sanPham.setNgayCapNhat(new Date());
        sanPham.setMoTa(moTa);

        DanhMuc danhMuc = danhMucRepo.findById(idDanhMuc).orElse(null);
        Hang hang = hangRepo.findById(idHang).orElse(null);
        sanPham.setDanhMuc(danhMuc);
        sanPham.setHang(hang);

        return sanPhamRepo.save(sanPham);
    }

    @Override
    public SanPham suaSanPham(Long id, String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa) {
        SanPham sanPham = sanPhamRepo.findById(id).orElse(null);
        if (sanPham != null) {
            sanPham.setId(id);
            sanPham.setTen(tenSanPham);
            sanPham.setSoLuongTon(soLuong);
            sanPham.setGiaBan(giaBan);
            sanPham.setUrlAnh(urlAnh);
            sanPham.setNgayCapNhat(new Date());
            sanPham.setMoTa(moTa);

            DanhMuc danhMuc = danhMucRepo.findById(idDanhMuc).orElse(null);
            Hang hang = hangRepo.findById(idHang).orElse(null);
            sanPham.setDanhMuc(danhMuc);
            sanPham.setHang(hang);

            return sanPhamRepo.save(sanPham);
        }
        return null;
    }
}
