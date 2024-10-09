package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hoa_don")
@Entity
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoa_don")
    private Long idHD;

    @Column(name = "ma_hoa_don")
    private String maHD;

    @ManyToOne
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "id_voucher")
    private Voucher voucher;

//    @ManyToOne
//    @JoinColumn(name = "id_dia_chi_van_chuyen")
//    private

    @ManyToOne
    @JoinColumn(name = "id_trang_thai_hoa_don")
    private TrangThaiHoaDon trangThaiHoaDon;

    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhanHD;

    @Column(name = "phi_ship")
    private float phiShipHD;

    @Column(name = "dia_chi")
    private String diaChiHD;

    @Column(name = "sdt_nguoi_nhan")
    private String sdtNguoiNhatHD;

    @Column(name = "thanh_tien")
    private float thanhTienHD;

    @Column(name = "ngay_tao")
    private Date ngayTaoHD;

    @Column(name = "mo_ta")
    private String moTaHD;

    @Column(name = "trang_thai")
    private Double trangThaiHD;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToanHD;

    @ManyToOne
    @JoinColumn(name = "id_pt_thanh_toan_hoa_don")
    private PTThanhToanHoaDon hoaDon;

}
