package com.example.camundaservice.process_3_serialization.service;

import com.example.camundaservice.process_3_serialization.domain.Warrior;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class WarriorServiceImpl implements WarriorService {

    private static final Random rnd = new Random();

    @Override
    public List<Warrior> createWarriors(final int count) throws IOException {

        Path path = Paths.get("./MOCK_DATA.csv");

        if (!path.toFile().exists()) {
            throw new RuntimeException("MOCK DATA FILE DOESN'T EXISTS");
        }

        long total = 1000;
        try (Stream<String> stream = Files.lines(path)) {
            total = stream.count();
        }

        try (Stream<String> stream = Files.lines(path)) {
            return stream
                    .skip(rnd.nextInt(1, (int) total - count))
                    .limit(count)
                    .map(s -> {
                        String[] arrData = s.split(",");
                        return new Warrior(arrData[0], arrData[1], Integer.valueOf(arrData[2]), true);
                    }).toList();
        }
    }
}
