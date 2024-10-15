package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamController {

    @GetMapping("/danh-sach-san-pham")
    public String trangSanPham(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/danh-sach-san-pham";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-san-pham")
    public String trangThemSanPham(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/them-san-pham";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-san-pham")
    public String trangSuaSanPham(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/sua-san-pham";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/san-pham-chi-tiet")
    public String trangSanPhamChiTiet(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/san-pham-chi-tiet";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-san-pham-chi-tiet")
    public String trangThemSanPhamChiTiet(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/them-san-pham-chi-tiet";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-san-pham-chi-tiet")
    public String trangSuaSanPhamChiTiet(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/sua-san-pham-chi-tiet";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/xem-san-pham-chi-tiet")
    public String trangXemSanPhamChiTiet(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/xem-san-pham-chi-tiet";  // Trả về file HTML trong folder templates/admin
    }
}
