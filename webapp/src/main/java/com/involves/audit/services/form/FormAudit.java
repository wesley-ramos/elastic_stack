package com.involves.audit.services.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.involves.audit.services.auditing.Auditing;
import com.involves.audit.services.auditing.AuditingBuilder;
import com.involves.audit.services.auditing.AuditingService;

@Service
public class FormAudit {

	private AuditingService auditingService;

	@Autowired
	public FormAudit(AuditingService auditingService) {
		this.auditingService = auditingService;
	}

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void processFormCreatedEvent(FormCreatedEvent formEvent) {

		Auditing auditing = AuditingBuilder.aAuditing()
			.withField("actor", formEvent.getUsername())
			.withField("id", formEvent.getForm().getId())
			.withField("name", formEvent.getForm().getName())
			.withField("goal", formEvent.getForm().getGoal())
		.build();

		auditingService.audit("form_save", auditing);
	}
}
