package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/kich-thuoc")
public class KichThuocController {

    @GetMapping("/danh-sach-kich-thuoc")
    public String trangKichThuoc(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/kich-thuoc/danh-sach-kich-thuoc";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-kich-thuoc")
    public String trangThemKichThuoc(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/kich-thuoc/them-kich-thuoc";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-kich-thuoc")
    public String trangSuaKichThuoc(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/kich-thuoc/sua-kich-thuoc";  // Trả về file HTML trong folder templates/admin
    }
}
