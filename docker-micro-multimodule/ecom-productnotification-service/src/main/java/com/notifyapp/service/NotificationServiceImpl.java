package com.notifyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notifyapp.model.Order;
import com.notifyapp.model.OrderEvent;

@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	private JavaMailSender mailSender;//to send mail
	
	@KafkaListener(topics="orderevent-topic",groupId="notify-id",containerFactory="containerFactory")
	public void consumeOrderEvent(OrderEvent orderEvent) {
		System.out.println(orderEvent.getStatus());
		Order order=orderEvent.getOrder();
		//get the userId and call userService to get name
		int userId=order.getUserId();
		String to="ramyakpass@gmail.com";
		String subject=orderEvent.getStatus()+"!!! Order Placed";
		String body="OrderId: "+orderEvent.getOrderEventId()+
				"\nStatus: "+orderEvent.getStatus()+
				"\nItems: "+orderEvent.getOrder().getItemNames();
		//call send mail method to send the mail
		sendMail(to,subject,body);
	}
	
	
	
	@Override
	public void sendMail(String to, String subject, String body) {
		// code to send mail
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		mailMessage.setFrom("ramyakpass@gmail.com");
		mailSender.send(mailMessage);
		System.out.println("✅ Mail sent successfully to " + to);
	}

}
