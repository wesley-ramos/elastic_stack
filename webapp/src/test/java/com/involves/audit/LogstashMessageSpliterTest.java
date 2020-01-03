package com.involves.audit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.net.DatagramPacket;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.involves.audit.auditing.Auditing;
import com.involves.audit.auditing.AuditingBuilder;
import com.involves.audit.auditing.AuditingConnection;
import com.involves.audit.auditing.LogstashMessageSpliter;
import com.involves.audit.utils.MessageSerializer;

@RunWith(MockitoJUnitRunner.class)
public class LogstashMessageSpliterTest {

	@Mock
	private AuditingConnection connection;

	@Mock
	private MessageSerializer serializer;

	@Test
	public void wesley() throws Exception {

		Auditing auditing = AuditingBuilder.aAuditing().withField("actor", "wesley.ramos").withField("id", 1)
				.withField("name", "formulario de preço").withField("goal", "preço").build();

		when(serializer.serialize(auditing.getData())).thenReturn(auditing.getData().toString());

		LogstashMessageSpliter prepareMessage = new LogstashMessageSpliter(serializer);

		List<DatagramPacket> packets = prepareMessage.split(null, 100, auditing);

		assertThat(packets,
				allOf(hasItem(allOf(hasProperty("offset", equalTo(0)), hasProperty("length", equalTo(30)))),
						hasItem(allOf(hasProperty("offset", equalTo(30)), hasProperty("length", equalTo(30)))),
						hasItem(allOf(hasProperty("offset", equalTo(60)), hasProperty("length", equalTo(6))))));

	}

}
