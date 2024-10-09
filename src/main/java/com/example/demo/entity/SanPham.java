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
@Table(name = "san_pham")
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_san_pham")
    private Long idSP;

    @Column(name = "ten_san_pham")
    private String tenSP;

    @Column(name = "so_luong_ton")
    private int SoLuongTonSP;

    @Column(name = "gia_ban")
    private float giaBanSp;

    @Column(name = "url_anh")
    private String urlAnhSP;

    @Column(name = "ngay_tao")
    private Date ngayTaoSP;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatSP;

    @Column(name = "mo_ta")
    private String moTaSP;

    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "id_voucher")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "id_hang")
    private Hang hang;


}
