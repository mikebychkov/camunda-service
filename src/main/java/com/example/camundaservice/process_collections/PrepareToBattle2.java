package com.example.camundaservice.process_collections;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class PrepareToBattle2 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        long myWarriors = (long) delegateExecution.getVariable("myWarriors");

        if (myWarriors < 1 || myWarriors > 100) {
            throw new BpmnError("warriorsError");
        }

        long enemyWarriors = (long) (Math.random() * 100);

        LinkedList<Integer> myArmy = new LinkedList<>(Collections.nCopies((int) myWarriors, 1));
        LinkedList<Integer> enemyArmy = new LinkedList<>(Collections.nCopies((int) enemyWarriors, 1));

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
