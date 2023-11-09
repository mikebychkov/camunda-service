package com.example.camundaservice.process;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrepareToBattle implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        long myWarriors = (long) delegateExecution.getVariable("myWarriors");

        if (myWarriors < 1 || myWarriors > 100) {
            throw new BpmnError("warriorsError");
        }

        long enemyWarriors = (long) (Math.random() * 100);

        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("battleResult", myWarriors > enemyWarriors ? "WIN" : "LOSE");
    }
}
