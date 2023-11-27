package com.example.camundaservice.process_2_collections;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class EvaluateResults implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int myArmySize = (int) delegateExecution.getVariable("myArmySize");
        int enemyArmySize = (int) delegateExecution.getVariable("enemyArmySize");

        delegateExecution.setVariable("battleResult", myArmySize > enemyArmySize ? "WIN" : "LOSE");

        delegateExecution.removeVariable("myArmy");
        delegateExecution.removeVariable("enemyArmy");
        delegateExecution.removeVariable("tryAgain");
    }
}
