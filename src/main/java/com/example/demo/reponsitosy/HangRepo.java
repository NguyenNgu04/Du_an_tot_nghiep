package com.example.demo.reponsitosy;

import com.example.demo.entity.Hang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HangRepo extends JpaRepository<Hang,Long> {

    @Query("select h from Hang h " +
            "where (:ten is null or h.ten like %:ten%)" +
            "order by h.ngayCapNhat desc ")
    public Page<Hang> getAllPage(@Param("ten") String ten, Pageable pageable);
}
