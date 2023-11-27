package com.example.camundaservice.process_4_db.process;

import com.example.camundaservice.process_4_db.dao.AccessRequestService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Long entityId = (Long) delegateExecution.getVariable(ProcessVarName.ENTITY_ID);
        String username = (String) delegateExecution.getVariable(ProcessVarName.USERNAME);
        String comment = (String) delegateExecution.getVariable(ProcessVarName.COMMENT);

        accessRequestService.create(entityId, username, comment);
    }
}
