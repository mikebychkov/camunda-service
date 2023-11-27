package com.example.camundaservice.process_4_db.process;

import com.example.camundaservice.process_4_db.dao.AccessRequestService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Long entityId = (Long) delegateExecution.getVariable(ProcessVarName.ENTITY_ID);
        String adminName = (String) delegateExecution.getVariable(ProcessVarName.ADMIN_NAME);
        Boolean isGranted = (Boolean) delegateExecution.getVariable(ProcessVarName.IS_GRANTED);

        accessRequestService.update(entityId, adminName, isGranted);
    }
}
