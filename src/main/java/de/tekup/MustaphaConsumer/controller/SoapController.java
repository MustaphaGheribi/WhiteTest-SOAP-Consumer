package de.tekup.MustaphaConsumer.controller;

import de.tekup.MustaphaConsumer.Client;
import de.tekup.MustaphaConsumer.WhiteTestsClasses.ExamResponse;
import de.tekup.MustaphaConsumer.WhiteTestsClasses.StudentRequest;
import de.tekup.MustaphaConsumer.WhiteTestsClasses.WhiteTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapController {
	@Autowired
	private Client client;

	@GetMapping(path="/reserve",produces = MediaType.APPLICATION_XML_VALUE)
	public WhiteTestResponse reserve() {

		StudentRequest request = new StudentRequest();
		request.setExamCode("100");
		request.setStudentId(1);

		return client.reserve(request);
	}

}
