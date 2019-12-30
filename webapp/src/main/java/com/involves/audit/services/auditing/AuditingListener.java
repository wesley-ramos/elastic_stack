package com.involves.audit.services.auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.involves.audit.services.customer.CustomerCreatedEvent;
import com.involves.audit.services.form.FormCreatedEvent;

@Service
public class AuditingListener {
	
	private AuditingService auditingService;
	
	@Autowired
	public AuditingListener(AuditingService auditingService) {
		this.auditingService = auditingService;
	}
	
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void processCustomerCreatedEvent(CustomerCreatedEvent customerEvent) {
		
		Auditing  auditing = AuditingBuilder.aAuditing()
			.withField("actor", customerEvent.getUsername())
			.withField("id", customerEvent.getCustomer().getId())
			.withField("name", customerEvent.getCustomer().getName())
			.withField("birthday", customerEvent.getCustomer().getBirthday().getTime())
			.withField("profileId", customerEvent.getCustomer().getProfileId())
		.build();
			
		auditingService.audit(Functionality.CUSTOMER, auditing);
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
