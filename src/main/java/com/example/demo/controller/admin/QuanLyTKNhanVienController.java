package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/tai-khoan-nhan-vien")
public class QuanLyTKNhanVienController {

    @GetMapping("/danh-sach-tai-khoan-nhan-vien")
    public String trangTaiKhoanNhanVien(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-nhan-vien/danh-sach-tai-khoan-nhan-vien";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-tai-khoan-nhan-vien")
    public String trangThemTaiKhoanNhanVien(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-nhan-vien/them-tai-khoan-nhan-vien";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-tai-khoan-nhan-vien")
    public String trangSuaTaiKhoanNhanVien(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-nhan-vien/sua-tai-khoan-nhan-vien";  // Trả về file HTML trong folder templates/admin
    }
}
