package com.example.demo.reponsitosy;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.Hang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatLieuRepo extends JpaRepository<ChatLieu,Long> {

    @Query("select cl from ChatLieu cl where (:ten is null or cl.ten like %:ten%) " +
            "and (:trangThai is null or cl.trangThai = :trangThai)" +
            "order by cl.ngayCapNhat desc ")
    public Page<ChatLieu> getAllPage(@Param("ten") String ten,@Param("trangThai") Boolean trangThai, Pageable pageable);

}
