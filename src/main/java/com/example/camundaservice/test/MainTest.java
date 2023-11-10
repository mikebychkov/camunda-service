package com.example.camundaservice.test;

import com.example.camundaservice.process_serialization.domain.Warrior;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;

public class MainTest {

    private static final Random rnd = new Random();

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("./MOCK_DATA.csv");

        if (!path.toFile().exists()) {
            throw new RuntimeException("MOCK DATA FILE DOESN'T EXISTS");
        }

        Optional<String> dataString = Files.lines(path).skip(rnd.nextInt(1, 1000)).findAny();

        System.out.println(dataString.get());

        String[] arrData = dataString.get().split(",");

        Warrior w = new Warrior(arrData[0], arrData[1], Integer.valueOf(arrData[2]), true);
        System.out.println(w);
    }
}
