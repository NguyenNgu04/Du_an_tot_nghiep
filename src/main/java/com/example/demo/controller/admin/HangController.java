package com.example.demo.controller.admin;

import com.example.demo.entity.Hang;
import com.example.demo.entity.NguoiDung;
import com.example.demo.reponsitosy.HangRepo;
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
@RequestMapping("/admin/hang")
public class HangController {

    @Autowired
    HangRepo hangRepo;

    @GetMapping("/danh-sach-hang")
    public String trangHang(Model model,
                            @RequestParam(name = "key", required = false) String key,
                            @RequestParam(defaultValue = "0") int page ) {
        //fragment
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("key", key);

        Pageable pageable = PageRequest.of(page, 3);
        Page<Hang> itemPage = hangRepo.getAllPage(key, pageable);

        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());

        return "/admin/hang/danh-sach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/trang-them-hang")
    public String trangThemHang(Model model) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("hang", new Hang());

        return "/admin/hang/them-hang";
    }

    @PostMapping("/them-hang")
    public String ThemHang(@Valid @ModelAttribute("hang") Hang hang,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/hang/them-hang";
        }
        hang.setNgayTao(Date.valueOf(LocalDate.now()));
        hang.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        hangRepo.save(hang);

        redirectAttributes.addFlashAttribute("Add", "Thêm thành công");

        return "redirect:/admin/hang/danh-sach-hang";
    }

    @GetMapping("/trang-sua-hang/{id}")
    public String trangSuaHang(Model model, @PathVariable("id") Long id)  {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("hang", hangRepo.getReferenceById(id));

        return "/admin/hang/sua-hang";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/sua-hang")
    public String SuaHang(@Valid @ModelAttribute("hang") Hang hang,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/hang/sua-hang";
        }
        hang.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        hang.setNgayTao(Date.valueOf(LocalDate.now()));
        hangRepo.save(hang);

        redirectAttributes.addFlashAttribute("Update", "Sửa thành công");

        return "redirect:/admin/hang/danh-sach-hang";
    }

}
