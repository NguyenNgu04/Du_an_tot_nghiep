package com.example.demo.controller.admin;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.reponsitosy.MauSacRepo;
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
@RequestMapping("/admin/mau-sac")
public class MauSacController {

    @Autowired
    MauSacRepo mauSacRepo;
    @GetMapping("/danh-sach-mau-sac")
    public String trangMauSac(Model model,
                              @RequestParam(name = "key", required = false) String key,
                              @RequestParam(name = "trangThai", required = false) Boolean trangThai,
                              @RequestParam(defaultValue = "0") int page) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("key", key);
        model.addAttribute("trangThai", trangThai);

        Pageable pageable = PageRequest.of(page, 3);
        Page<MauSac> itemPage = mauSacRepo.getAllPage(key, trangThai, pageable);

        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());

        return "/admin/mau-sac/danh-sach-mau-sac";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/trang-them-mau-sac")
    public String trangThemMauSac (Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("mauSac", new MauSac());
        return "/admin/mau-sac/them-mau-sac";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/them-mau-sac")
    public String ThemMauSac(@Valid @ModelAttribute("mauSac") MauSac mauSac,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/mau-sac/them-mau-sac";
        }
        mauSac.setNgayTao(Date.valueOf(LocalDate.now()));
        mauSac.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        mauSacRepo.save(mauSac);

        redirectAttributes.addFlashAttribute("Add", "Thêm thành công");

        return "redirect:/admin/mau-sac/danh-sach-mau-sac";
    }

    @GetMapping("/trang-sua-mau-sac/{id}")
    public String trangSuaMauSac (Model model, @PathVariable("id") Long id) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("mauSac", mauSacRepo.getReferenceById(id));
        return "/admin/mau-sac/sua-mau-sac";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/sua-mau-sac")
    public String SuaMauSac(@Valid @ModelAttribute("mauSac") MauSac mauSac,
                             BindingResult result,
                             Model model,
                             RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/mau-sac/sua-mau-sac";
        }
        mauSac.setNgayTao(Date.valueOf(LocalDate.now()));
        mauSac.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        mauSacRepo.save(mauSac);

        redirectAttributes.addFlashAttribute("Update", "Sửa thành công");

        return "redirect:/admin/mau-sac/danh-sach-mau-sac";
    }
}
