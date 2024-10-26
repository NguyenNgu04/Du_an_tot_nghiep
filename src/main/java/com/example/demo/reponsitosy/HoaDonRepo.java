package com.example.demo.reponsitosy;

import com.example.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepo extends JpaRepository<HoaDon,Long> {

    @Query("select hd from HoaDon hd where hd.trangThai = true")
    List<HoaDon> getAllByTrangThai();


    @Query("select max(id) from HoaDon")
    Long getIDMaxOfHD();
}
