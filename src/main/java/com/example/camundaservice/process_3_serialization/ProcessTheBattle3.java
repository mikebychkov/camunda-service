package com.example.camundaservice.process_3_serialization;

import com.example.camundaservice.process_3_serialization.domain.Warrior;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Random;

@Component
public class ProcessTheBattle3 implements JavaDelegate {

    private final Random rnd = new Random();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        LinkedList<Warrior> myArmy = (LinkedList<Warrior>) delegateExecution.getVariable("myArmy");
        LinkedList<Warrior> enemyArmy = (LinkedList<Warrior>) delegateExecution.getVariable("enemyArmy");

        if (rnd.nextBoolean()) {
            Warrior w = enemyArmy.pollLast();
            System.out.printf("ENEMY WARRIOR KILLED: %s", w);
        } else {
            Warrior w = myArmy.pollLast();
            System.out.printf("MY WARRIOR KILLED: %s", w);
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
