package com.example.demo.reponsitosy;

import com.example.demo.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepo extends JpaRepository<Voucher,Long> {
}
