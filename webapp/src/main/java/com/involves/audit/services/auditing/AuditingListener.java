package com.involves.audit.services.auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.involves.audit.services.custumer.CustumerCreatedEvent;
import com.involves.audit.services.form.FormCreatedEvent;

@Service
public class AuditingListener {
	
	private AuditingService auditingService;
	
	@Autowired
	public AuditingListener(AuditingService auditingService) {
		this.auditingService = auditingService;
	}
	
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void processCustumerCreatedEvent(CustumerCreatedEvent custumerEvent) {
		
		Auditing  auditing = AuditingBuilder.aAuditing()
			.withField("actor", custumerEvent.getUsername())
			.withField("id", custumerEvent.getCustumer().getId())
			.withField("name", custumerEvent.getCustumer().getName())
			.withField("birthday", custumerEvent.getCustumer().getBirthday().getTime())
			.withField("profileId", custumerEvent.getCustumer().getProfileId())
		.build();
			
		auditingService.audit(Functionality.CUSTUMER, auditing);
    }
	
	
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void processFormCreatedEvent(FormCreatedEvent formEvent) {
		
		Auditing  auditing = AuditingBuilder.aAuditing()
			.withField("actor", formEvent.getUsername())
			.withField("id", formEvent.getForm().getId())
			.withField("name", formEvent.getForm().getName())
			.withField("goal", formEvent.getForm().getGoal())
		.build();
			
		auditingService.audit(Functionality.FORM, auditing);
    }
}
