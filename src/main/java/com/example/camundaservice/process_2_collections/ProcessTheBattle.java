package com.example.camundaservice.process_2_collections;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Random;

@Component
public class ProcessTheBattle implements JavaDelegate {

    private final Random rnd = new Random();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        LinkedList<Integer> myArmy = (LinkedList<Integer>) delegateExecution.getVariable("myArmy");
        LinkedList<Integer> enemyArmy = (LinkedList<Integer>) delegateExecution.getVariable("enemyArmy");

        if (rnd.nextBoolean()) {
            System.out.print("ENEMY WARRIOR KILLED");
            enemyArmy.pollLast();
        } else {
            System.out.print("MY WARRIOR KILLED");
            myArmy.pollLast();
        }

        System.out.printf(" (my: %s, enemy: %s)%n", myArmy.size(), enemyArmy.size());

        delegateExecution.setVariable("myArmy", myArmy);
        delegateExecution.setVariable("enemyArmy", enemyArmy);

        delegateExecution.setVariable("myArmySize", myArmy.size());
        delegateExecution.setVariable("enemyArmySize", enemyArmy.size());

        delegateExecution.setVariable("tryAgain", false);

        Thread.sleep(100);
    }
}
