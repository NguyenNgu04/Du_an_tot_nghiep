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
@Table(name = "hoa_don_chi_tiet")
@Entity
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoa_don_chi_tiet")
    private Long idHDCT;
    @Column(name = "ma_hoa_don")
    private String maHDCT;

    @ManyToOne
    @JoinColumn(name = "id_san_pham_chi_tiet")
    private SanPhamChiTiet sanPhamChiTiet;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;

    @Column(name = "so_luong")
    private int soLuongHDCT;

    @Column(name = "tong_tien")
    private float tongTienHDCT;

    @Column(name = "ngay_tao")
    private Date ngayTaoHDCT;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatHDCT;

    @Column(name = "trang_thai")
    private boolean trangThaiHDCT;

    @Column(name = "mo_ta")
    private String moTaHDCT;


}
