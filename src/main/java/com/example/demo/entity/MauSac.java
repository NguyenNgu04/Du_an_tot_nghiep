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
@Table(name = "mau_sac")
@Entity
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mau_sac")
    private Long idMS;

    @Column(name = "ten_mau_sac")
    private String tenMS;

    @Column(name = "mo_ta")
    private  String moTaMS;

    @Column(name = "trang_thai")
    private String trangThaiMS;

    @Column(name = "ngay_tao")
    private Date ngayTaoMS;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatMS;

}
