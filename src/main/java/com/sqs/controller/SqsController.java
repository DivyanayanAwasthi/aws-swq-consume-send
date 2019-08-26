package com.sqs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.sqs.config.SqsConfig;

@Controller
public class SqsController {

	@Autowired
	SqsConfig sqsConfig;
	
	

	private static final String queueUrl="https://sqs.us-east-1.amazonaws.com/xxxxxxx/test-queue";
	private static final String message = "hello world";

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendMessage() {
		
		SendMessageResult sendMessageResult = sqsConfig.sendMessage(queueUrl, message);
		System.out.println(sendMessageResult);
		return new ResponseEntity<String>(sendMessageResult.getMessageId(), HttpStatus.OK);
	}
	
	@GetMapping(value="/consume",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> consumeMessage() {
		
		List<Message> messagess = sqsConfig.recieveMessage(queueUrl);
		return new ResponseEntity<String>(messagess.toString(), HttpStatus.OK);
	}
	

}
