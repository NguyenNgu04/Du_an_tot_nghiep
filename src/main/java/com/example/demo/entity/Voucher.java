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
@Table(name = "voucher")
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voucher")
    private Long idVCH;

    @Column(name = "kieu_giam")
    private Boolean kieuGiamVCH;

    @Column(name = "gia_tri_giam")
    private float giaTriGiamVCH;

    @Column(name = "so_luong")
    private int soLuonhVCH;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDauVCH;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThucVCH;

    @Column(name = "ngay_tao")
    private Date ngayTaoVCH;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatVCH;


}
