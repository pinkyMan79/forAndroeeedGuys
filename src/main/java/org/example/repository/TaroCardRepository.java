package org.example.repository;

import org.example.models.TaroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaroCardRepository extends JpaRepository<TaroEntity, UUID> {
}
