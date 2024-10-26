package com.example.demo.controller.admin;

import com.example.demo.entity.NguoiDung;
import com.example.demo.entity.VaiTro;
import com.example.demo.reponsitosy.NguoiDungRepo;
import com.example.demo.service.impl.NguoiDungServiceImpl;
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
@RequestMapping("/admin/tai-khoan-khach-hang")
public class QuanLyTKKhachHangController {

    @Autowired
    NguoiDungServiceImpl nguoiDungServiceImpl;
    @Autowired
    NguoiDungRepo nguoiDungRepo;

    @GetMapping("/danh-sach-tai-khoan-khach-hang")
    public String trangTaiKhoanKhachHang(Model model,
                                         @RequestParam(name = "key", required = false) String key,
                                         @RequestParam(name = "trangThai", required = false) Boolean trangThai,
                                         @RequestParam(defaultValue = "0") int page
    ) {
        String role = "admin";
        model.addAttribute("role", role);

        model.addAttribute("key", key);
        model.addAttribute("trangThai", trangThai);

        Pageable pageable = PageRequest.of(page, 3);
        Page<NguoiDung> itemPage = nguoiDungServiceImpl.searchKhachHang(key, trangThai, pageable);

        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());
        return "/admin/tai-khoan-khach-hang/danh-sach-tai-khoan-khach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/trang-them-tai-khoan-khach-hang")
    public String trangThemTaiKhoanKhachHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("nguoiDung", new NguoiDung());
        return "/admin/tai-khoan-khach-hang/them-tai-khoan-khach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/them-tai-khoan-khach-hang")
    public String themTaiKhoan(@Valid @ModelAttribute("nguoiDung") NguoiDung nguoiDung,
                               BindingResult result,
                               Model model,
                               RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/tai-khoan-khach-hang/them-tai-khoan-khach-hang";
        }
        if (nguoiDungServiceImpl.checkTrungEmail(nguoiDung.getEmail())) {
            model.addAttribute("error", "Email đã tồn tại!");
            return "/admin/tai-khoan-khach-hang/them-tai-khoan-khach-hang";
        }
        if (nguoiDungServiceImpl.checkTrungSdt(nguoiDung.getSdt())) {
            model.addAttribute("error", "Số điện thoại đã tồn tại!");
            return "/admin/tai-khoan-khach-hang/them-tai-khoan-khach-hang";
        }


        //add
        if (nguoiDungRepo.getIDMaxOfNguoiDung() == null) {
            nguoiDung.setMa(String.format("KH0%d", 1));
        } else if ((nguoiDungRepo.getIDMaxOfNguoiDung()) < 9) {
            nguoiDung.setMa(String.format("KH0%d", nguoiDungRepo.getIDMaxOfNguoiDung() + 1));
        } else if ((nguoiDungRepo.getIDMaxOfNguoiDung() + 1) >= 9) {
            nguoiDung.setMa(String.format("KH%d", nguoiDungRepo.getIDMaxOfNguoiDung() + 1));
        }
        if (nguoiDung.getVaiTro() == null) {
            nguoiDung.setVaiTro(new VaiTro());  // Khởi tạo đối tượng VaiTro mới
        }
        nguoiDung.getVaiTro().setId(3);
        nguoiDung.setNgayTao(Date.valueOf(LocalDate.now()));
        nguoiDungRepo.save(nguoiDung);

        redirectAttributes.addFlashAttribute("Add", "Thêm thành công");
        return "redirect:/admin/tai-khoan-khach-hang/danh-sach-tai-khoan-khach-hang";
    }

    @GetMapping("/trang-sua-tai-khoan-khach-hang/{id}")
    public String trangSuaTaiKhoanKhachHang(Model model, @PathVariable("id") Long id) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("nguoiDung", nguoiDungRepo.getReferenceById(id)); // Truyền role xuống view
        return "/admin/tai-khoan-khach-hang/sua-tai-khoan-khach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/sua-tai-khoan-khach-hang")
    public String suaTaiKhoan(@Valid @ModelAttribute("nguoiDung") NguoiDung nguoiDung,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/tai-khoan-khach-hang/sua-tai-khoan-khach-hang";
        }

        nguoiDung.setNgayTao(Date.valueOf(LocalDate.now()));
        nguoiDung.setNgayCapNhat(Date.valueOf(LocalDate.now()));

        nguoiDungRepo.save(nguoiDung);
        redirectAttributes.addFlashAttribute("Update", "Sửa thành công");
        return "redirect:/admin/tai-khoan-khach-hang/danh-sach-tai-khoan-khach-hang";
    }
}
