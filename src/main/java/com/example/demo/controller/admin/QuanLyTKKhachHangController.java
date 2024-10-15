package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/tai-khoan-khach-hang")
public class QuanLyTKKhachHangController {

    @GetMapping("/danh-sach-tai-khoan-khach-hang")
    public String trangTaiKhoanKhachHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-khach-hang/danh-sach-tai-khoan-khach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-tai-khoan-khach-hang")
    public String trangThemTaiKhoanKhachHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-khach-hang/them-tai-khoan-khach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-tai-khoan-khach-hang")
    public String trangSuaTaiKhoanKhachHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-khach-hang/sua-tai-khoan-khach-hang";  // Trả về file HTML trong folder templates/admin
    }
}
