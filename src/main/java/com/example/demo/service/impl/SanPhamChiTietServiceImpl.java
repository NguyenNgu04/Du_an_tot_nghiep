package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.reponsitosy.ChatLieuRepo;
import com.example.demo.reponsitosy.KichThuocRepo;
import com.example.demo.reponsitosy.MauSacRepo;
import com.example.demo.reponsitosy.SanPhamChiTietRepo;
import com.example.demo.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {
    @Autowired
    private KichThuocRepo kichThuocRepo;

    @Autowired
    private ChatLieuRepo chatLieuRepo;

    @Autowired
    private MauSacRepo mauSacRepo;

    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;

}
