package com.example.demo.controller.admin;

import com.example.demo.entity.ChatLieu;
import com.example.demo.reponsitosy.ChatLieuRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin/chat-lieu")
public class ChatLieuController {

    @Autowired
    ChatLieuRepo chatLieuRepo;
    @GetMapping("/danh-sach-chat-lieu")
    public String trangChatLieu(Model model,
                                @RequestParam(name = "key", required = false) String key,
                                @RequestParam(name = "trangThai", required = false) Boolean trangThai,
                                @RequestParam(defaultValue = "0") int page) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("key", key);
        model.addAttribute("trangThai", trangThai);

        Pageable pageable = PageRequest.of(page, 3);
        Page<ChatLieu> itemPage = chatLieuRepo.getAllPage(key, trangThai, pageable);

        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());

        return "/admin/chat-lieu/danh-sach-chat-lieu";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/trang-them-chat-lieu")
    public String trangThemChatLieu(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("chatLieu", new ChatLieu());

        return "/admin/chat-lieu/them-chat-lieu";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/them-chat-lieu")
    public String ThemDanhMuc(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/chat-lieu/them-chat-Lieu";
        }
        chatLieu.setNgayTao(Date.valueOf(LocalDate.now()));
        chatLieu.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        chatLieuRepo.save(chatLieu);

        redirectAttributes.addFlashAttribute("Add", "Thêm thành công");

        return "redirect:/admin/chat-lieu/danh-sach-chat-lieu";
    }

    @GetMapping("/trang-sua-chat-lieu/{id}")
    public String trangSuaChatLieu(Model model, @PathVariable("id") Long id) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("chatLieu", chatLieuRepo.getReferenceById(id));
        return "/admin/chat-lieu/sua-chat-lieu";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/sua-chat-lieu")
    public String SuaDanhMuc(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/chat-lieu/sua-chat-lieu";
        }
        chatLieu.setNgayTao(Date.valueOf(LocalDate.now()));
        chatLieu.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        chatLieuRepo.save(chatLieu);

        redirectAttributes.addFlashAttribute("Update", "Sửa thành công");

        return "redirect:/admin/chat-lieu/danh-sach-chat-lieu";
    }
}
