package com.example.demo.reponsitosy;

import com.example.demo.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HangRepo extends JpaRepository<Hang,Long> {
}
