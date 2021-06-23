package com.springboot.myprofile.repository;

import com.springboot.myprofile.model.Uploads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadsRepository extends JpaRepository<Uploads, Long> {
    List<Uploads> findAll();
}
