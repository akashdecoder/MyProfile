package com.springboot.myprofile.repository;

import com.springboot.myprofile.model.Uploads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UploadsRepository extends JpaRepository<Uploads, Long> {
    List<Uploads> findAll();
}
