package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "pt_thanh_toan")
@Entity
public class PTThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pt_thanh_toan")
    private Long id;

    @Column(name = "ma_thanh_toan")
    private String ma;

    @Column(name = "ten_phuong_thuc")
    private String ten;

    @Column(name = "noi_dung_thanh_toan")
    private String noiDung;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;

    @Column(name = "trang_thai_thanh_toan")
    private Boolean trangThai;

    @Column(name = "phi_giao_dich")
    private float phiGiaoDich;

    @Column(name = "thong_tin_them")
    private String thongTinThem;

}
