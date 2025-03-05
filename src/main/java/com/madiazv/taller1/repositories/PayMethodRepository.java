package com.madiazv.taller1.repositories;

import com.madiazv.taller1.models.PayMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayMethodRepository extends JpaRepository<PayMethod, Long> {
}
