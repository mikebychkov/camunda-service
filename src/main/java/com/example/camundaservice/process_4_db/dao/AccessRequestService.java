package com.example.camundaservice.process_4_db.dao;

public interface AccessRequestService {

    Long create(Long entityId, String username, String comment);
    void update(Long entityId, String adminName, Boolean isGranted);
}
