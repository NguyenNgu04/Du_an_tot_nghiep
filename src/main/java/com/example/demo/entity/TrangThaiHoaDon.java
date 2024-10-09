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
@Table(name = "trang_thai_hoa_don")
@Entity
public class TrangThaiHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trang_thai_hoa_don")
    private Long idTTHD;

    @Column(name = "ten_trang_thai")
    private String tenTTHD;

    @Column(name = "mo_ta")
    private  String moTaTTHD;

    @Column(name = "ngay_tao")
    private Date ngayTaoTTHD;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatTTHD;

}
