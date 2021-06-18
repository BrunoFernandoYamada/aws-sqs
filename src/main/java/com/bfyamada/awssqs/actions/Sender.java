package com.bfyamada.awssqs.actions;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class Sender {

	public static void main(String[] args) {
		
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
		
		String queueUrl = "https://sqs.us-east-2.amazonaws.com/115944444857/MySQLQueue";
		
		/*
		 * Mandar atributos, não é obrigatório
		 */
		Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
		messageAttributes.put("Name", new MessageAttributeValue()
				.withStringValue("Bruno")
				.withDataType("String"));
	
		SendMessageRequest send_msg_request = new SendMessageRequest()
				.withQueueUrl(queueUrl)
				.withMessageBody("Hello World")
				.withDelaySeconds(5)
				.withMessageAttributes(messageAttributes);
		
		SendMessageResult result = sqs.sendMessage(send_msg_request);
		System.out.println(result.getMessageId());

	}

}
