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
@Table(name = "vai_tro")
@Entity
public class VaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vai_tro")
    private Long idVT;

    @Column(name = "ten")
    private String tenVT;

    @Column(name = "mo_ta")
    private  String moTaVT;

    @Column(name = "ngay_tao")
    private Date ngayTaoVT;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatVT;

}
