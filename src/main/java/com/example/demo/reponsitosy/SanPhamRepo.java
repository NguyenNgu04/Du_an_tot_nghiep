package com.example.demo.reponsitosy;

import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepo extends JpaRepository<SanPham,Long> {
}
