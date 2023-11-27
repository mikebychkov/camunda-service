package com.example.camundaservice.process_3_serialization;

import com.example.camundaservice.process_3_serialization.domain.Warrior;
import com.example.camundaservice.process_3_serialization.service.WarriorService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class PrepareToBattle3 implements JavaDelegate {

    @Autowired
    private WarriorService warriorService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        long myWarriors = (long) delegateExecution.getVariable("myWarriors");

        if (myWarriors < 1 || myWarriors > 100) {
            throw new BpmnError("warriorsError");
        }

        long enemyWarriors = (long) (Math.random() * 100);

        LinkedList<Warrior> myArmy = new LinkedList<>(warriorService.createWarriors((int) myWarriors));
        LinkedList<Warrior> enemyArmy = new LinkedList<>(warriorService.createWarriors((int) enemyWarriors));

        delegateExecution.setVariable("myArmy", myArmy);
        delegateExecution.setVariable("enemyArmy", enemyArmy);

        delegateExecution.setVariable("myArmySize", myArmy.size());
        delegateExecution.setVariable("enemyArmySize", enemyArmy.size());

        delegateExecution.removeVariable("myWarriors");

        System.out.println("=".repeat(50));
        System.out.print("NEW BATTLE STARTED");
        System.out.printf(" (my: %s, enemy: %s)%n", myArmy.size(), enemyArmy.size());
        System.out.println("=".repeat(50));
    }
}
