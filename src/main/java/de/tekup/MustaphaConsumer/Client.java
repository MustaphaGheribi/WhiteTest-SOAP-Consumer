package de.tekup.MustaphaConsumer;

import de.tekup.MustaphaConsumer.WhiteTestsClasses.ExamResponse;
import de.tekup.MustaphaConsumer.WhiteTestsClasses.Request;
import de.tekup.MustaphaConsumer.WhiteTestsClasses.StudentRequest;
import de.tekup.MustaphaConsumer.WhiteTestsClasses.WhiteTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class Client {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;
	private WebServiceTemplate template;

	public WhiteTestResponse reserve(StudentRequest request) {
		template = new WebServiceTemplate(jaxb2Marshaller);
		WhiteTestResponse response = (WhiteTestResponse) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		return response;
	}

}
