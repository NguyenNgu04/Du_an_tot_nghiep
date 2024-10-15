package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/chat-lieu")
public class ChatLieuController {

    @GetMapping("/danh-sach-chat-lieu")
    public String trangChatLieu(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/chat-lieu/danh-sach-chat-lieu";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/them-chat-lieu")
    public String trangThemChatLieu(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/chat-lieu/them-chat-lieu";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/sua-chat-lieu")
    public String trangSuaChatLieu(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/chat-lieu/sua-chat-lieu";  // Trả về file HTML trong folder templates/admin
    }

}
