package com.involves.audit.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.involves.audit.services.auditing.Auditing;
import com.involves.audit.services.auditing.AuditingBuilder;
import com.involves.audit.services.auditing.AuditingService;

@Service
public class CustomerAudit {

	private AuditingService auditingService;

	@Autowired
	public CustomerAudit(AuditingService auditingService) {
		this.auditingService = auditingService;
	}

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void processCustomerCreatedEvent(CustomerCreatedEvent customerEvent) {

		Auditing auditing = AuditingBuilder.aAuditing()
			.withField("actor", customerEvent.getUsername())
			.withField("id", customerEvent.getCustomer().getId())
			.withField("name", customerEvent.getCustomer().getName())
			.withField("birthday", customerEvent.getCustomer().getBirthday().getTime())
			.withField("profileId", customerEvent.getCustomer().getProfileId())
	    .build();

		auditingService.audit("CUSTOMER_SAVE", auditing);
	}
}
