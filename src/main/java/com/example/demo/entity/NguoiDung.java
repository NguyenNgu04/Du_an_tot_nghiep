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
    private Long id;

    @Column(name = "ten_nguoi_dung")
    private String ten;

    @Column(name = "ma_nguoi_dung")
    private String ma;

    @Column(name = "Email")
    private String email;

    @Column(name = "sdt_nguoi_dung")
    private String sdt;

    @Column(name = "Ngay_Sinh")
    private Date ngaySinh;

    @Column(name = "Dia_Chi")
    private String diaChi;

    @Column(name = "Gioi_Tinh")
    private Double gioiTinh;

    @Column(name = "Mat_Khau")
    private String matKhau;

    @Column(name = "Anh_Dai_Dien")
    private String anhDaiDien;

    @Column(name = "Trang_thai")
    private Boolean trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_cap_nhat")
    private Date ngayCapNhat;

    @ManyToOne
    @JoinColumn(name = "id_vai_tro")
    private VaiTro vaiTro;

}
