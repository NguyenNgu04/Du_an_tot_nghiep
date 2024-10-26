package com.example.demo.service;

import com.example.demo.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface SanPhamService {
    Map<String, String> kiemTraLoiThemSanPham(String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa);

    Map<String, String> kiemTraLoiSuaSanPham(Long idSanPham, String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa);

    SanPham themSanPham(String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa);
    SanPham suaSanPham(Long idSanPham, String tenSanPham, int soLuong, float giaBan, String urlAnh, Long idDanhMuc, Long idHang, String moTa);

}
