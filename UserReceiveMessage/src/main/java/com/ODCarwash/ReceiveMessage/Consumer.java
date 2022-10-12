package com.ODCarwash.ReceiveMessage;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@RabbitListener(queues = MessageConfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus order) {
		System.out.println("message received from order:" + order);
	}
}
