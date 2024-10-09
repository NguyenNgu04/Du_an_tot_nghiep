package com.example.demo.reponsitosy;

import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTiet,Long> {
}
