package com.example.demo.service.impl;

import com.example.demo.entity.NguoiDung;
import com.example.demo.entity.VaiTro;
import com.example.demo.reponsitosy.NguoiDungRepo;
import com.example.demo.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    @Override
    public Page<NguoiDung> searchNhanVien(String key, Boolean trangThai, Pageable pageable) {

        return nguoiDungRepo.seacherNhanVien(key, trangThai, pageable);
    }

    @Override
    public Page<NguoiDung> searchKhachHang(String key, Boolean trangThai, Pageable pageable) {
        return nguoiDungRepo.seacherKhachHang(key, trangThai, pageable);
    }

    @Override
    public boolean checkTrungEmail(String email) {
        return nguoiDungRepo.existsByEmail(email);
    }

    @Override
    public boolean checkTrungSdt(String sdt) {
        return nguoiDungRepo.existsBySdt(sdt);
    }



}
