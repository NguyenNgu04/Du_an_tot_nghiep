package com.example.demo.controller.admin;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.Hang;
import com.example.demo.reponsitosy.DanhMucRepo;
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
@RequestMapping("/admin/danh-muc")
public class DanhMucController {

    @Autowired
    DanhMucRepo danhMucRepo;
    @GetMapping("/danh-sach-danh-muc")
    public String trangChatLieu(Model model,
                                @RequestParam(name = "key", required = false) String key,
                                @RequestParam(defaultValue = "0") int page) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("key", key);

        Pageable pageable = PageRequest.of(page, 3);
        Page<DanhMuc> itemPage = danhMucRepo.getAllPage(key, pageable);

        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());

        return "/admin/danh-muc/danh-sach-danh-muc";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/trang-them-danh-muc")
    public String trangThemDanhMuc(Model model){
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("danhMuc", new DanhMuc());

        return "/admin/danh-muc/them-danh-muc";

    }

    @PostMapping("/them-danh-muc")
    public String ThemDanhMuc(@Valid @ModelAttribute("danhMuc") DanhMuc danhMuc,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/danh-mua/them-danh-muc";
        }
        danhMuc.setNgayTao(Date.valueOf(LocalDate.now()));
        danhMuc.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        danhMucRepo.save(danhMuc);

        redirectAttributes.addFlashAttribute("Add", "Thêm thành công");

        return "redirect:/admin/danh-muc/danh-sach-danh-muc";
    }

    @GetMapping("/trang-sua-danh-muc/{id}")
    public String trangSuaDanhMuc(Model model,@PathVariable("id") Long id){

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("danhMuc", danhMucRepo.getReferenceById(id));

        return "/admin/danh-muc/sua-danh-muc";

    }

    @PostMapping("/sua-danh-muc")
    public String SuaDanhMuc(@Valid @ModelAttribute("danhMuc") DanhMuc danhMuc,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/danh-mua/sua-danh-muc";
        }
        danhMuc.setNgayTao(Date.valueOf(LocalDate.now()));
        danhMuc.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        danhMucRepo.save(danhMuc);

        redirectAttributes.addFlashAttribute("Update", "Sửa thành công");

        return "redirect:/admin/danh-muc/danh-sach-danh-muc";
    }
}
