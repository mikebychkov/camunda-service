package com.example.camundaservice.process_4_db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {

    Optional<AccessRequest> findByEntityId(Long entityId);
}
