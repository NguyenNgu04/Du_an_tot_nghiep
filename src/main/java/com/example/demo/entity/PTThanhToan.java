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
    private Long idPTTT;

    @Column(name = "ma_thanh_toan")
    private String maPTTT;

    @Column(name = "ten_phuong_thuc")
    private String tenPTTT;

    @Column(name = "noi_dung_thanh_toan")
    private String noiDungPTTT;

    @Column(name = "ngay_thanh_toan")
    private Date ngayPTTT;

    @Column(name = "trang_thai_thanh_toan")
    private Double trangThaiPTTT;

    @Column(name = "phi_giao_dich")
    private float phiGiaoDichPTTT;

    @Column(name = "thong_tin_them")
    private String thongTinThemPTTT;

}
