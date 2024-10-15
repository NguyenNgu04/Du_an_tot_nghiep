package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/hang")
public class HangController {

    @GetMapping("/danh-sach-hang")
    public String trangHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/hang/danh-sach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-hang")
    public String trangThemHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/hang/them-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-hang")
    public String trangSuaHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/hang/sua-hang";  // Trả về file HTML trong folder templates/admin
    }
}
