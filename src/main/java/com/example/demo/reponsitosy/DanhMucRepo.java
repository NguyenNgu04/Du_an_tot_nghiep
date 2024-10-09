package com.example.demo.reponsitosy;

import com.example.demo.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanhMucRepo extends JpaRepository<DanhMuc,Long> {
}
