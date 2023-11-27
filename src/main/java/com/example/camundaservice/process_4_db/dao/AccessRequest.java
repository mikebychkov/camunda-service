package com.example.camundaservice.process_4_db.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "access_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_request_sequence")
    @SequenceGenerator(name = "access_request_sequence")
    private Long id;

    @Column(name = "entity_id")
    private Long entityId;

    @Column(name = "username")
    private String username;

    @Column(name = "comment")
    private String comment;

    @Column(name = "is_granted")
    private Boolean isGranted;

    @Column(name = "admin_name")
    private String adminName;
}
