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
@Table(name = "kich_thuoc")
@Entity
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kich_thuoc")
    private Long idKT;

    @Column(name = "ten_kich_thuoc")
    private String tenKT;

    @Column(name = "mo_ta")
    private  String moTaKT;

    @Column(name = "trang_thai")
    private String trangThaiKT;

    @Column(name = "ngay_tao")
    private Date ngayTaoKT;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatKT;

}
