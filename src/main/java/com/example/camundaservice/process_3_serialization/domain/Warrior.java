package com.example.camundaservice.process_3_serialization.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Warrior implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String title;
    private Integer hitPoints;
    private Boolean isAlive;
}
