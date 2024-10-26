package com.example.demo.controller.admin;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichThuoc;
import com.example.demo.reponsitosy.KichThuocRepo;
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
@RequestMapping("/admin/kich-thuoc")
public class KichThuocController {

    @Autowired
    KichThuocRepo kichThuocRepo;
    @GetMapping("/danh-sach-kich-thuoc")
    public String trangKichThuoc(Model model,
                                 @RequestParam(name = "key", required = false) String key,
                                 @RequestParam(name = "trangThai", required = false) Boolean trangThai,
                                 @RequestParam(defaultValue = "0") int page) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("key", key);
        model.addAttribute("trangThai", trangThai);

        Pageable pageable = PageRequest.of(page, 3);
        Page<KichThuoc> itemPage = kichThuocRepo.getAllPage(key, trangThai, pageable);

        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());

        return "/admin/kich-thuoc/danh-sach-kich-thuoc";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/trang-them-kich-thuoc")
    public String trangThemKichThuoc(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("kichThuoc", new KichThuoc());
        return "/admin/kich-thuoc/them-kich-thuoc";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/them-kich-thuoc")
    public String ThemKichThuoc(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/kich-thuoc/them-kich-thuoc";
        }
        kichThuoc.setNgayTao(Date.valueOf(LocalDate.now()));
        kichThuoc.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        kichThuocRepo.save(kichThuoc);

        redirectAttributes.addFlashAttribute("Add", "Thêm thành công");

        return "redirect:/admin/kich-thuoc/danh-sach-kich-thuoc";
    }

    @GetMapping("/trang-sua-kich-thuoc/{id}")
    public String trangSuaKichThuoc(Model model, @PathVariable("id") Long id) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("kichThuoc", kichThuocRepo.getReferenceById(id));
        return "/admin/kich-thuoc/sua-kich-thuoc";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/sua-kich-thuoc")
    public String SuaKichThuoc(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/kich-thuoc/sua-kich-thuoc";
        }
        kichThuoc.setNgayTao(Date.valueOf(LocalDate.now()));
        kichThuoc.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        kichThuocRepo.save(kichThuoc);

        redirectAttributes.addFlashAttribute("Update", "Sửa thành công");

        return "redirect:/admin/kich-thuoc/danh-sach-kich-thuoc";
    }
}
