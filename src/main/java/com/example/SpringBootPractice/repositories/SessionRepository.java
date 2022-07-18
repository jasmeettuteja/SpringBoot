package com.example.SpringBootPractice.repositories;

import com.example.SpringBootPractice.models.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Sessions,Long> {
}
