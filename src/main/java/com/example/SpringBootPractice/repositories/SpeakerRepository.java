package com.example.SpringBootPractice.repositories;

import com.example.SpringBootPractice.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
