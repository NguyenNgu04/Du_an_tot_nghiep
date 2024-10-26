package com.example.demo.reponsitosy;

import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepo extends JpaRepository<SanPham,Long> {
    boolean existsByTen(String tenSanPham);
    Page<SanPham> findAll(Pageable pageable);

    Page<SanPham> findByTenContaining(String tenSanPham, Pageable pageable);
    Page<SanPham> findByHangId(Long hangId, Pageable pageable);
    Page<SanPham> findByDanhMucId(Long danhMucId, Pageable pageable);
}
