package com.pjatk.cemetery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CemeteryRepository extends JpaRepository<Cemetery, Integer> {
    List<Cemetery> findAllByIdIsGreaterThan(Integer id);
}
