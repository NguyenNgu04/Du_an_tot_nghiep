package com.example.demo.reponsitosy;

import com.example.demo.entity.Hang;
import com.example.demo.entity.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KichThuocRepo extends JpaRepository<KichThuoc,Long> {

    @Query("select kt from KichThuoc kt " +
            "where (:ten is null or kt.ten like %:ten%)" +
            "and (:trangThai is null or kt.trangThai = :trangThai)" +
            "order by kt.ngayCapNhat desc ")
    public Page<KichThuoc> getAllPage(@Param("ten") String ten,@Param("trangThai") Boolean trangThai, Pageable pageable);
}
