package com.example.camundaservice.process_serialization.service;

import com.example.camundaservice.process_serialization.domain.Warrior;

import java.io.IOException;
import java.util.List;

public interface WarriorService {

    List<Warrior> createWarriors(final int count) throws IOException;
}
