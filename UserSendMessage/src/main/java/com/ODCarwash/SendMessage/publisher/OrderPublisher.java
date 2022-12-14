package com.ODCarwash.SendMessage.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ODCarwash.SendMessage.config.MessageConfig;
import com.ODCarwash.SendMessage.dto.Order;
import com.ODCarwash.SendMessage.dto.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

	@Autowired
	private  RabbitTemplate rabbitTemplate;
	
	@PostMapping("/{restName}")
	public String bookOrder(@RequestBody Order order, @PathVariable String restName) { 
		order.setId(UUID.randomUUID().toString());
		OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully with: " + restName);
		rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, orderStatus);
		return "Success!!";
	}
}
