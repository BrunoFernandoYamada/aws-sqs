package com.bfyamada.awssqs.actions;

import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;

public class DeleteMessages {

	public static void main(String[] args) {
		
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
				.withRegion(Regions.US_EAST_2)
				.build();
		
		String queueUrl = "https://sqs.us-east-2.amazonaws.com/115944444857/MySQLQueue";
		
		List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
		
		for(Message m : messages) {
			sqs.deleteMessage(queueUrl, m.getReceiptHandle());
			System.out.println("Message: " + m.getBody() );
			System.out.println("Deleted");
		}

	}

}
