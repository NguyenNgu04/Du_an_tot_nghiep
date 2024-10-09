package com.example.demo.reponsitosy;

import com.example.demo.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NguoiDungRepo extends JpaRepository<NguoiDung,Long> {
}
