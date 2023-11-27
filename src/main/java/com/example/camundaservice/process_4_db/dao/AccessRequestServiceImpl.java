package com.example.camundaservice.process_4_db.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccessRequestServiceImpl implements AccessRequestService {

    private final AccessRequestRepository accessRequestRepository;

    @Override
    public Long create(Long entityId, String username, String comment) {

        AccessRequest ar = AccessRequest.builder()
                .entityId(entityId)
                .username(username)
                .comment(comment)
                .build();

        return accessRequestRepository.save(ar).getId();
    }

    @Override
    public void update(Long entityId, String adminName, Boolean isGranted) {

        AccessRequest ar = accessRequestRepository.findByEntityId(entityId)
                .orElseThrow(() -> new RuntimeException("REQUEST NOT FOUND"));

        ar.setAdminName(adminName);
        ar.setIsGranted(isGranted);

        accessRequestRepository.save(ar);
    }
}
