package com.example.demo.reponsitosy;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.Hang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DanhMucRepo extends JpaRepository<DanhMuc,Long> {

    @Query("select dm from DanhMuc dm " +
            "where (:ten is null or dm.ten like %:ten%)" +
            "order by dm.ngayCapNhat desc ")
    public Page<DanhMuc> getAllPage(@Param("ten") String ten, Pageable pageable);

}
