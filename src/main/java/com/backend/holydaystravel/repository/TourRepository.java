package com.backend.holydaystravel.repository;

import com.backend.holydaystravel.domain.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TourRepository extends JpaRepository<Tour, Long> {
}