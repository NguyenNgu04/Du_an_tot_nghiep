package com.example.demo.controller.admin;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.NguoiDung;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.entity.VaiTro;
import com.example.demo.reponsitosy.ChatLieuRepo;
import com.example.demo.reponsitosy.DanhMucRepo;
import com.example.demo.reponsitosy.HangRepo;
import com.example.demo.reponsitosy.KichThuocRepo;
import com.example.demo.reponsitosy.MauSacRepo;
import com.example.demo.reponsitosy.SanPhamChiTietRepo;
import com.example.demo.reponsitosy.SanPhamRepo;
import com.example.demo.service.impl.SanPhamChiTietServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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
import java.util.List;

@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamCTController {

    @Autowired
    SanPhamRepo sanPhamRepo;
    @Autowired
    SanPhamChiTietRepo sanPhamChiTietRepo;
    @Autowired
    MauSacRepo mauSacRepo;
    @Autowired
    KichThuocRepo kichThuocRepo;
    @Autowired
    HangRepo hangRepo;
    @Autowired
    DanhMucRepo danhMucRepo;
    @Autowired
    ChatLieuRepo chatLieuRepo;
    @Autowired
    SanPhamChiTietServiceImpl sanPhamChiTietServiceImpl;

    @GetMapping("/san-pham-chi-tiet")
    public String trangSanPhamChiTiet(Model model,
                                      @RequestParam(name = "tenSP", required = false) String tenSP,
                                      @RequestParam(name = "trangThai", required = false) Boolean trangThai,
                                      @RequestParam(name = "idCL", required = false) Long idCL,
                                      @RequestParam(name = "idKT", required = false) Long idKT,
                                      @RequestParam(name = "idMS", required = false) Long idMS,
                                      @RequestParam(name = "idH", required = false) Long idH,
                                      @RequestParam(name = "idDM", required = false) Long idDM,
                                      @RequestParam(defaultValue = "0") int page
    ) {
        String role = "admin";
        model.addAttribute("role", role);

        model.addAttribute("tenSP", tenSP);
        model.addAttribute("trangThai", trangThai);
        model.addAttribute("idCL", idCL);
        model.addAttribute("idKT", idKT);
        model.addAttribute("idMS", idMS);
        model.addAttribute("idH", idH);
        model.addAttribute("idDM", idDM);

        model.addAttribute("listCL", chatLieuRepo.findAll());
        model.addAttribute("listKT", kichThuocRepo.findAll());
        model.addAttribute("listMS", mauSacRepo.findAll());
        model.addAttribute("listH", hangRepo.findAll());
        model.addAttribute("listDM", danhMucRepo.findAll());

        Pageable pageable = PageRequest.of(page, 3);
        Page<SanPhamChiTiet> itemPage = sanPhamChiTietRepo.getAllSpctBySomeField( tenSP, trangThai, idCL, idKT, idMS, idH, idDM, pageable);

        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());

        return "/admin/san-pham/san-pham-chi-tiet";
    }

    @GetMapping("/trang-them-san-pham-chi-tiet")
    public String trangThemSanPhamChiTiet(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("spct", new SanPhamChiTiet());

        model.addAttribute("listSP", sanPhamRepo.findAll());
        model.addAttribute("listCL", chatLieuRepo.findAll());
        model.addAttribute("listKT", kichThuocRepo.findAll());
        model.addAttribute("listMS", mauSacRepo.findAll());

        return "/admin/san-pham/them-san-pham-chi-tiet";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/them-san-pham-chi-tiet")
    public String themTaiKhoan(@Valid @ModelAttribute("spct") SanPhamChiTiet sanPhamChiTiet,
                               BindingResult result,
                               Model model,
                               RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            model.addAttribute("listCL", chatLieuRepo.findAll());
            model.addAttribute("listKT", kichThuocRepo.findAll());
            model.addAttribute("listMS", mauSacRepo.findAll());
            return "/admin/san-pham/them-chi-tiet-san-pham";
        }


        //add
        sanPhamChiTiet.setNgayTao(Date.valueOf(LocalDate.now()));
        sanPhamChiTiet.setNgayCapNhat(Date.valueOf(LocalDate.now()));
        sanPhamChiTiet.setTrangThai(true);

        sanPhamChiTietRepo.save(sanPhamChiTiet);

        redirectAttributes.addFlashAttribute("Add", "Thêm thành công");
        return "redirect:/admin/san-pham/san-pham-chi-tiet";

    }

    @GetMapping("/trang-sua-san-pham-chi-tiet/{id}")
    public String trangSuaSanPhamChiTiet(Model model, @PathVariable("id") Long id) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("spct", sanPhamChiTietRepo.getReferenceById(id));

        model.addAttribute("listSP", sanPhamRepo.findAll());
        model.addAttribute("listCL", chatLieuRepo.findAll());
        model.addAttribute("listKT", kichThuocRepo.findAll());
        model.addAttribute("listMS", mauSacRepo.findAll());

        return "/admin/san-pham/sua-san-pham-chi-tiet";  // Trả về file HTML trong folder templates/admin
    }

    @PostMapping("/sua-san-pham-chi-tiet")
    public String suaTaiKhoan(@Valid @ModelAttribute("spct") SanPhamChiTiet sanPhamChiTiet,
                               BindingResult result,
                               Model model,
                               RedirectAttributes redirectAttributes) {

        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //validate
        if (result.hasErrors()) {
            return "/admin/san-pham/sua-chi-tiet-san-pham";
        }

        //add
        sanPhamChiTiet.setNgayTao(Date.valueOf(LocalDate.now()));
        sanPhamChiTiet.setNgayCapNhat(Date.valueOf(LocalDate.now()));


        sanPhamChiTietRepo.save(sanPhamChiTiet);

        redirectAttributes.addFlashAttribute("Update", "Sửa thành công");
        return "redirect:/admin/san-pham/san-pham-chi-tiet";

    }


}
