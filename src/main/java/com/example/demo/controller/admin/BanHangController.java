package com.example.demo.controller.admin;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.reponsitosy.HoaDonRepo;
import com.example.demo.service.impl.HoaDonChiTietServiceImpl;
import com.example.demo.service.impl.HoaDonServiceImpl;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/ban-hang")
public class BanHangController {

    @Autowired
    HoaDonServiceImpl hoaDonServiceImpl;

    @Autowired
    HoaDonChiTietServiceImpl hoaDonChiTietServiceImpl;

    @Autowired
    HoaDonRepo hoaDonRepo;

    @GetMapping("ban-hang-quay")
    public String hienThiFormBanHang(Model model){
        //fragment
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        model.addAttribute("hoaDon", new HoaDon());
        //Hiện thị hóa đơn chưa thanh toán
        List<HoaDon> listHDChuaTT = hoaDonServiceImpl.getAllByTrangThai();
        model.addAttribute("listHD", listHDChuaTT);
        return "/admin/ban-hang/ban-hang-quay";
    }

    @PostMapping("tao-hd")
    public String taoHoaDon(Model model,HoaDon hoaDon){
        //fragment
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //
        if(hoaDonRepo.getIDMaxOfHD() == null){
            hoaDon.setMa(String.format("HD0%d", 1));
        }else if((hoaDonRepo.getIDMaxOfHD() ) < 9){
            hoaDon.setMa(String.format("HD0%d", hoaDonRepo.getIDMaxOfHD() + 1 ));
        }else if((hoaDonRepo.getIDMaxOfHD() + 1) >= 9){
            hoaDon.setMa(String.format("HD%d", hoaDonRepo.getIDMaxOfHD() + 1));
        }
//        hoaDon.getNguoiDung().setId(null);
//        hoaDon.getVoucher().setId(null);
        hoaDon.setTrangThaiHoaDon(null);
        hoaDon.setTenNguoiNhan(null);
        hoaDon.setPhiShip(0);
        hoaDon.setDiaChi(null);
        hoaDon.setSdtNguoiNhan(null);
        hoaDon.setThanhTien(0);
        hoaDon.setNgayTao(Date.valueOf(LocalDate.now()));
        hoaDon.setMoTa(null);
        hoaDon.setTrangThai(true);
        hoaDon.setNgayThanhToan(null);
//        hoaDon.getPtThanhToanHoaDon().setId(null);

        hoaDonRepo.save(hoaDon);

        return "redirect:/admin/ban-hang/ban-hang-quay";
    }

    @GetMapping("list-hdct/{id}")
    public String getHDCTByIdHD(Model model, @PathVariable("id") Long idHD){
        //fragment
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        //hiện thị
        List<HoaDonChiTiet> listHDCT = hoaDonChiTietServiceImpl.getALlByIdHoaDon(idHD);
        model.addAttribute("listHDCT", listHDCT);

        List<HoaDon> listHDChuaTT = hoaDonServiceImpl.getAllByTrangThai();
        model.addAttribute("listHD", listHDChuaTT);

        return "admin/ban-hang/ban-hang-quay";
    }

}
