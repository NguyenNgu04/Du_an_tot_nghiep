package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DieuKhienController {

    //Admin
    @GetMapping("/admin/ban-hang/ban-hang-quay")
    public String trangBanHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/ban-hang/ban-hang-quay";  // Trả về file HTML trong folder templates/admin
    }

//    @GetMapping("/admin/chat-lieu/danh-sach-chat-lieu")
//    public String trangChatLieu(Model model) {
//        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
//        model.addAttribute("role", role); // Truyền role xuống view
//        return "/admin/chat-lieu/danh-sach-chat-lieu";  // Trả về file HTML trong folder templates/admin
//    }

//    @GetMapping("/admin/danh-muc/danh-sach-danh-muc")
//    public String trangDanhMuc(Model model) {
//        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
//        model.addAttribute("role", role); // Truyền role xuống view
//        return "/admin/danh-muc/danh-sach-danh-muc";  // Trả về file HTML trong folder templates/admin
//    }

    @GetMapping("/admin/giam-gia/danh-sach-giam-gia")
    public String trangGiamGia(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/giam-gia/danh-sach-giam-gia";  // Trả về file HTML trong folder templates/admin
    }

//    @GetMapping("/admin/hang/danh-sach-hang")
//    public String trangHang(Model model) {
//        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
//        model.addAttribute("role", role); // Truyền role xuống view
//        return "/admin/hang/danh-sach-hang";  // Trả về file HTML trong folder templates/admin
//    }

    @GetMapping("/admin/hoa-don/danh-sach-hoa-don")
    public String trangHoaDon(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/hoa-don/danh-sach-hoa-don";  // Trả về file HTML trong folder templates/admin
    }

//    @GetMapping("/admin/kich-thuoc/danh-sach-kich-thuoc")
//    public String trangKichThuoc(Model model) {
//        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
//        model.addAttribute("role", role); // Truyền role xuống view
//        return "/admin/kich-thuoc/danh-sach-kich-thuoc";  // Trả về file HTML trong folder templates/admin
//    }

//    @GetMapping("/admin/mau-sac/danh-sach-mau-sac")
//    public String trangMauSac(Model model) {
//        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
//        model.addAttribute("role", role); // Truyền role xuống view
//        return "/admin/mau-sac/danh-sach-mau-sac";  // Trả về file HTML trong folder templates/admin
//    }

    @GetMapping("/admin/tai-khoan-nhan-vien/danh-sach-tai-khoan-nhan-vien")
    public String trangTaiKhoanNhanVien(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-nhan-vien/danh-sach-tai-khoan-nhan-vien";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/admin/tai-khoan-khach-hang/danh-sach-tai-khoan-khach-hang")
    public String trangTaiKhoanKhachHang(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/tai-khoan-khach-hang/danh-sach-tai-khoan-khach-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/admin/san-pham/danh-sach-san-pham")
    public String trangSanPham(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/san-pham/danh-sach-san-pham";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/admin/thong-ke/trang-thong-ke")
    public String tranThongKe(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/thong-ke/trang-thong-ke";  // Trả về file HTML trong folder templates/admin
    }

    // NhanVien

    @GetMapping("/nhan-vien/ban-hang/trang-ban-hang")
    public String trangBanHangForNhanVien(Model model) {
        String role = "nhan-vien"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/nhan-vien/ban-hang/trang-ban-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/nhan-vien/hoa-don/danh-sach-hoa-don")
    public String trangHoaDonForNhanVien(Model model) {
        String role = "nhan-vien"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/nhan-vien/hoa-don/danh-sach-hoa-don";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/nhan-vien/tai-khoan/thong-tin-tai-khoan")
    public String trangTaiKhoanForNhanVien(Model model) {
        String role = "nhan-vien"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/nhan-vien/tai-khoan/thong-tin-tai-khoan";  // Trả về file HTML trong folder templates/admin
    }

    // KhachHang

    @GetMapping("/khach-hang/trang-mua-hang/danh-sach-san-pham")
    public String trangMuaHangForKhachHang(Model model) {
        String role = "khach-hang"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/khach-hang/trang-mua-hang/danh-sach-san-pham";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/khach-hang/gio-hang/danh-sach-san-pham-trong-gio-hang")
    public String trangGioHangForKhachHang(Model model) {
        String role = "khach-hang"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/khach-hang/gio-hang/danh-sach-san-pham-trong-gio-hang";  // Trả về file HTML trong folder templates/admin
    }

    @GetMapping("/khach-hang/tai-khoan/thong-tin-tai-khoan")
    public String trangTaiKhoanForKhachHang(Model model) {
        String role = "khach-hang"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/khach-hang/tai-khoan/thong-tin-tai-khoan";  // Trả về file HTML trong folder templates/admin
    }



}
