package com.example.demo.reponsitosy;

import com.example.demo.entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTiet,Long> {

    @Query("select spct from SanPhamChiTiet spct " +
            "join spct.sanPham sp " +
            "join spct.chatLieu cl " +
            "join spct.kichThuoc kt " +
            "join spct.mauSac ms " +
            "join spct.sanPham.hang h " +
            "join spct.sanPham.danhMuc dm " +
            "where (:tenSP is null or sp.ten like %:tenSP%) " +
            "and (:trangThai is null or spct.trangThai =:trangThai) " +
            "and (:idCL is null or cl.id =:idCL) " +
            "and (:idKT is null or kt.id =:idKT) " +
            "and (:idMS is null or ms.id =:idMS) " +
            "and (:idH is null or h.id =:idH) " +
            "and (:idDM is null or dm.id =:idDM) " +
            "order by spct.ngayCapNhat desc ")
    Page<SanPhamChiTiet> getAllSpctBySomeField(
                                    @Param("tenSP") String tenSP,
                                    @Param("trangThai") Boolean trangThai,
                                    @Param("idCL") Long idCL,
                                    @Param("idKT") Long idKT,
                                    @Param("idMS") Long idMS,
                                    @Param("idH") Long idH,
                                    @Param("idDM") Long idDM,
                                    Pageable pageable);






}
