package com.example.demo.reponsitosy;

import com.example.demo.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GioHangRepo extends JpaRepository<GioHang,Long> {
}
