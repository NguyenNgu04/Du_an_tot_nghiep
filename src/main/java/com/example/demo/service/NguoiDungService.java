package com.example.demo.service;

import com.example.demo.entity.NguoiDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface NguoiDungService {

    Page<NguoiDung> searchNhanVien(String key, Boolean trangThai, Pageable pageable);

    Page<NguoiDung> searchKhachHang(String key, Boolean trangThai, Pageable pageable);

    boolean checkTrungEmail(String email);

    boolean checkTrungSdt(String sdt);

}
