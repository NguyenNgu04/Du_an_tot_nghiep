package com.example.demo.reponsitosy;

import com.example.demo.entity.NguoiDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NguoiDungRepo extends JpaRepository<NguoiDung,Long> {

    //find tk nhan vien
    @Query("select nd " +
            "from NguoiDung nd join nd.vaiTro vt " +
            "where(vt.id = 2) and ( :key is null or nd.ten like %:key% or nd.sdt like %:key% ) " +
            "and ( :trangThai is null or nd.trangThai = :trangThai) order by nd.ngayCapNhat desc ")
    Page<NguoiDung> seacherNhanVien (@Param("key") String key,
                                     @Param("trangThai") Boolean trangThai,
                                     Pageable pageable);

    //find tk khach hang
    @Query("select nd " +
            "from NguoiDung nd join nd.vaiTro vt " +
            "where(vt.id = 3) and ( :key is null or nd.ten like %:key% or nd.sdt like %:key% ) " +
            "and ( :trangThai is null or nd.trangThai = :trangThai) order by nd.ngayCapNhat desc ")
    Page<NguoiDung> seacherKhachHang (@Param("key") String key,
                                     @Param("trangThai") Boolean trangThai,
                                     Pageable pageable);


    //check trùng
    boolean existsByEmail(String email);
    boolean existsBySdt(String sdt);

    @Query("select max(id) from NguoiDung ")
    Long getIDMaxOfNguoiDung();



}
