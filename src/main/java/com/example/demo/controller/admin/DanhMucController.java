package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/danh-muc")
public class DanhMucController {

    @GetMapping("/danh-sach-danh-muc")
    public String trangChatLieu(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/danh-muc/danh-sach-danh-muc";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-danh-muc")
    public String trangThemDanhMuc(Model model){
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/danh-muc/them-danh-muc";

    }

    @GetMapping("/sua-danh-muc")
    public String trangSuaDanhMuc(Model model){
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/danh-muc/sua-danh-muc";

    }
}
