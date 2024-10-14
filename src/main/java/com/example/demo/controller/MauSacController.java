package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/mau-sac")
public class MauSacController {

    @GetMapping("/danh-sach-mau-sac")
    public String trangMauSac(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/mau-sac/danh-sach-mau-sac";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-mau-sac")
    public String trangThemMauSac (Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/mau-sac/them-mau-sac";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-mau-sac")
    public String trangSuaMauSac (Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/mau-sac/sua-mau-sac";  // Trả về file HTML trong folder templates/admin
    }
}
