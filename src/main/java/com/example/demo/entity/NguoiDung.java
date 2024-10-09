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
@Table(name = "nguoi_dung")
@Entity
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nguoi_dung")
    private Long idND;

    @Column(name = "ten_nguoi_dung")
    private String tenND;

    @Column(name = "ma_nguoi_dung")
    private String maND;

    @Column(name = "Email")
    private String emailND;

    @Column(name = "sdt_nguoi_dung")
    private String sdtND;

    @Column(name = "Ngay_Sinh")
    private Date ngaySinhND;

    @Column(name = "Dia_Chi")
    private String diaChiND;

    @Column(name = "Gioi_Tinh")
    private Double gioiTinhND;

    @Column(name = "Mat_Khau")
    private String matKhauND;

    @Column(name = "Anh_Dai_Dien")
    private String anhDaiDienND;

    @Column(name = "Trang_thai")
    private Double trangThaiND;

    @Column(name = "ngay_tao")
    private Date ngayTaoND;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhatND;

    @ManyToOne
    @JoinColumn(name = "id_vai_tro")
    private VaiTro vaiTro;

}
