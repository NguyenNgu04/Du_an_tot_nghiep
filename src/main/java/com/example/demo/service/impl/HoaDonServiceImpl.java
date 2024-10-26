package com.example.demo.service.impl;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.VaiTro;
import com.example.demo.reponsitosy.HoaDonRepo;
import com.example.demo.service.HoaDonService;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepo hoaDonRepo;

    @Override
    public List<HoaDon> getAllByTrangThai() {
        return hoaDonRepo.getAllByTrangThai();
    }





}
