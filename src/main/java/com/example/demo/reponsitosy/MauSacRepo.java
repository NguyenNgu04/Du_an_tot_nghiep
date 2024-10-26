package com.example.demo.reponsitosy;

import com.example.demo.entity.Hang;
import com.example.demo.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MauSacRepo extends JpaRepository<MauSac,Long> {

    @Query("select ms from MauSac ms " +
            "where (:ten is null or ms.ten like %:ten%)" +
            "and (:trangThai is null or ms.trangThai = :trangThai)" +
            "order by ms.ngayCapNhat desc ")
    public Page<MauSac> getAllPage(@Param("ten") String ten,@Param("trangThai") Boolean trangThai, Pageable pageable);

}
