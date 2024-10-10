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
@Table(name = "pt_thanh_toan_hoa_don")
@Entity
public class PTThanhToanHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thanh_toan_hoa_don")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pt_thanh_toan")
    private PTThanhToan ptThanhToan;

    @Column(name = "so_tien_thanh_toan")
    private float soTienThanhToan;

    @Column(name = "ngay_giao_dich")
    private Date ngayGiaoDich;

    @Column(name = "ghi_chu")
    private String ghiChu;
}
