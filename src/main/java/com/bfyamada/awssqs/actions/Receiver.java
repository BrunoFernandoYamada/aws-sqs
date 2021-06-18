package com.bfyamada.awssqs.actions;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class Receiver {

	public static void main(String[] args) {
		
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
		
		String queueUrl = "https://sqs.us-east-2.amazonaws.com/115944444857/MySQLQueue";
		
		ReceiveMessageRequest receive_request = new ReceiveMessageRequest()
				.withQueueUrl(queueUrl)
				.withWaitTimeSeconds(20)
				.withVisibilityTimeout(20)
				.withMaxNumberOfMessages(10);
				
		List<Message> messages = sqs.receiveMessage(receive_request).getMessages();
		
		for(Message m : messages) {
			System.out.println(m.getBody());
			//deleta a mensagem apos recebida
			sqs.deleteMessage(queueUrl, m.getReceiptHandle());
		}

	}

}
