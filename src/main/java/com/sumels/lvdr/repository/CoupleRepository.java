package com.sumels.lvdr.repository;

import com.sumels.lvdr.model.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CoupleRepository extends JpaRepository<Couple, Long> {
}
