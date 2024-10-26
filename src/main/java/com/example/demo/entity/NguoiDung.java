package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;


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
    @NotBlank(message = "Tên người dùng không được để trống")
    private String ten;

    @Column(name = "ma_nguoi_dung")
    private String ma;

    @Column(name = "Email", unique = true)
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email phải đúng định dạng")
    private String email;

    @Column(name = "sdt_nguoi_dung", unique = true)
    @Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại có 10 chữ số và bắt đầu bằng số 0")
    @NotBlank(message = "Số điện thoại không được để trống")

    private String sdt;

    @Column(name = "Ngay_Sinh")
    @NotNull(message = "Ngày sình không được để trống")
    private Date ngaySinh;

    @Column(name = "Dia_Chi")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;

    @Column(name = "Gioi_Tinh")
    private Boolean gioiTinh;

    @Column(name = "Mat_Khau")
    @NotBlank(message = "Mật khẩu không được để trống")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,10}$",
            message = "Mật khẩu phải có từ 6-10 ký tự, bao gồm chữ hoa, chữ thường và số, không có ký tự đặc biệt")
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
