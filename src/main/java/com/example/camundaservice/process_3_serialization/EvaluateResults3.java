package com.example.camundaservice.process_3_serialization;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class EvaluateResults3 implements JavaDelegate {

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
