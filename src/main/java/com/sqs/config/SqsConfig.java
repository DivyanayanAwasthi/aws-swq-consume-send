package com.sqs.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageResult;

@Configuration
public class SqsConfig {

	/**
	 * Return SQS client 
	 * @return AmazonSQS
	 */
	@Bean
	public AmazonSQS amazonSQS() {

		AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials())).build();
		return amazonSQS;
	}
	
	/**
	 * 
	 * @return AWSCredentials
	 */
	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials("xxxxx", "xxx");
	}
	
	/**
	 * 
	 * @param sqsUrl  SQS endpoint url
	 * @param message  message body
	 * @return SendMessageResult
	 */
	public SendMessageResult sendMessage(String queueUrl, String message) {
		AmazonSQS sqsClient = amazonSQS();
		return sqsClient.sendMessage(queueUrl, message);
	}
	
	public List<Message> recieveMessage(String queueUrl) {
		AmazonSQS sqsClient = amazonSQS();
		List<Message> messages = sqsClient.receiveMessage(queueUrl).getMessages();
		for (Message m : messages) {
			sqsClient.deleteMessage(queueUrl, m.getReceiptHandle());
		}
		return messages;

	}
}
