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
@Table(name = "gio_hang_chi_tiet")
@Entity
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gio_hang_chi_tiet")
    private Long idGHCT;

    @ManyToOne
    @JoinColumn(name = "id_gio_hang")
    private GioHang gioHang;

    @Column(name = "so_luong")
    private int soLuongGHCT;

    @Column(name = "don_gia")
    private Double donGiaGHCT;

    @Column(name = "thanh_tien")
    private Double thanhTienGHCT;

    @Column(name = "trang_thai")
    private String trangThaiGHCT;

    @Column(name = "ngay_tao")
    private Date ngayTaoGHCT;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatGHCT;



}
