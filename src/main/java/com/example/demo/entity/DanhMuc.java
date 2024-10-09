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
@Table(name = "danh_muc")
@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_danh_muc")
    private Long idDM;

    @Column(name = "ten_danh_muc")
    private String tenDM;

    @Column(name = "mo_ta")
    private  String moTaDM;

    @Column(name = "ngay_tao")
    private Date ngayTaoDM;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatDM;

}
