package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long>  {
    Optional<Mobile> findBydeviceName(String deviceName);
}
