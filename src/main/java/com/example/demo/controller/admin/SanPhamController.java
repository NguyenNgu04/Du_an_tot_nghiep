package com.example.demo.controller.admin;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.Hang;
import com.example.demo.entity.SanPham;
import com.example.demo.reponsitosy.DanhMucRepo;
import com.example.demo.reponsitosy.HangRepo;
import com.example.demo.reponsitosy.SanPhamRepo;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamRepo sanPhamRepo;
    @Autowired
    DanhMucRepo danhMucRepo;
    @Autowired
    HangRepo hangRepo;
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/danh-sach-san-pham")
    public String trangSanPham(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(required = false) String tenSanPham,
                               @RequestParam(required = false) Long hangId,
                               @RequestParam(required = false) Long danhMucId,
                               Model model) {
        String role = "admin";
        model.addAttribute("role", role);
        model.addAttribute("listDM", danhMucRepo.findAll());
        model.addAttribute("listTH", hangRepo.findAll());

        int itemsPerPage = 5;
        Pageable pageable = PageRequest.of(page, itemsPerPage);

        // Lấy danh sách sản phẩm phân trang với điều kiện lọc
        Page<SanPham> sanPhamPage;
        if (tenSanPham != null && !tenSanPham.isEmpty()) {
            sanPhamPage = sanPhamRepo.findByTenContaining(tenSanPham, pageable);
        } else if (hangId != null && hangId != 0) {
            sanPhamPage = sanPhamRepo.findByHangId(hangId, pageable);
        } else if (danhMucId != null && danhMucId != 0) {
            sanPhamPage = sanPhamRepo.findByDanhMucId(danhMucId, pageable);
        } else {
            sanPhamPage = sanPhamRepo.findAll(pageable);
        }

        model.addAttribute("listSP", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());
        model.addAttribute("tenSanPham", tenSanPham);
        model.addAttribute("hangId", hangId);
        model.addAttribute("danhMucId", danhMucId);

        return "/admin/san-pham/danh-sach-san-pham";
    }

    @GetMapping("/them-san-pham")
    public String trangThemSanPham(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("sanPham", new SanPham());
        model.addAttribute("listDM", danhMucRepo.findAll());
        model.addAttribute("listTH", hangRepo.findAll());
        return "admin/san-pham/them-san-pham";  // Trả về file HTML trong folder templates/admin
    }


    @GetMapping("/sua-san-pham")
    public String hienThiFormSuaSanPham(@RequestParam("id") Long id, Model model) {
        // Tìm sản phẩm theo ID
        SanPham sanPham = sanPhamRepo.findById(id).orElse(null);
        model.addAttribute("sanPham", sanPham);
        // Lấy danh sách danh mục và thương hiệu
        model.addAttribute("listDM", danhMucRepo.findAll());
        model.addAttribute("listTH", hangRepo.findAll());

        return "/admin/san-pham/sua-san-pham"; // Tên của template Thymeleaf
    }


    @PostMapping("/them-san-pham")
    public String themSanPham(@RequestParam String tenSanPham,
                              @RequestParam int soLuong,
                              @RequestParam float giaBan,
                              @RequestParam String urlAnh,
                              @RequestParam Long idDanhMuc,
                              @RequestParam Long idHang,
                              @RequestParam(required = false) String moTa,
                              RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> loi = sanPhamService.kiemTraLoiThemSanPham(tenSanPham, soLuong, giaBan, urlAnh, idDanhMuc, idHang, moTa);

        if (!loi.isEmpty()) {
            loi.forEach((key, value) -> redirectAttributes.addFlashAttribute(key, value));
            redirectAttributes.addFlashAttribute("tenSanPham", tenSanPham);
            redirectAttributes.addFlashAttribute("soLuong", soLuong);
            redirectAttributes.addFlashAttribute("giaBan", giaBan);
            redirectAttributes.addFlashAttribute("urlAnh", urlAnh);
            return "redirect:/admin/san-pham/them-san-pham"; // Quay lại trang thêm sản phẩm
        }

        sanPhamService.themSanPham(tenSanPham, soLuong, giaBan, urlAnh, idDanhMuc, idHang, moTa);
        redirectAttributes.addFlashAttribute("successMessageThem", "Thêm sản phẩm thành công!");
        return "redirect:/admin/san-pham/danh-sach-san-pham"; // Chuyển hướng về trang danh sách sản phẩm
    }

    @PostMapping("/sua-san-pham")
    public String suaSanPham(@RequestParam Long id,
                             @RequestParam String tenSanPham,
                             @RequestParam int soLuong,
                             @RequestParam float giaBan,
                             @RequestParam String urlAnh,
                             @RequestParam Long idDanhMuc,
                             @RequestParam Long idHang,
                             @RequestParam(required = false) String moTa,
                             RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> loi = sanPhamService.kiemTraLoiSuaSanPham(id, tenSanPham, soLuong, giaBan, urlAnh, idDanhMuc, idHang, moTa);

        if (!loi.isEmpty()) {
            loi.forEach((key, value) -> redirectAttributes.addFlashAttribute(key, value));
            redirectAttributes.addFlashAttribute("tenSanPham", tenSanPham);
            redirectAttributes.addFlashAttribute("soLuong", soLuong);
            redirectAttributes.addFlashAttribute("giaBan", giaBan);
            redirectAttributes.addFlashAttribute("urlAnh", urlAnh);
            return "redirect:/admin/san-pham/sua-san-pham?id=" + id; // Quay lại trang sửa sản phẩm
        }

        SanPham sanPham = sanPhamService.suaSanPham(id, tenSanPham, soLuong, giaBan, urlAnh, idDanhMuc, idHang, moTa);
        if (sanPham != null) {
            redirectAttributes.addFlashAttribute("successMessageSua", "Sửa sản phẩm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi sửa sản phẩm.");
        }

        return "redirect:/admin/san-pham/danh-sach-san-pham"; // Chuyển hướng về trang danh sách sản phẩm
    }
}
