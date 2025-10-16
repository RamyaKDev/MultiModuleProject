package com.notifyapp.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.notifyapp.model.OrderEvent;

@Configuration
public class KafkaConfig {
	@Bean
ConsumerFactory<String,OrderEvent> consumerFactory(){
	//add some properties
	Map<String,Object> properties=new HashMap<>();
	properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka:9092");
	properties.put(ConsumerConfig.GROUP_ID_CONFIG, "notify-id");
	properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
	
	return new DefaultKafkaConsumerFactory<>(
			properties,new StringDeserializer(),new JsonDeserializer<>()
			);
}
@Bean
//create the container to store the event
ConcurrentKafkaListenerContainerFactory<String, OrderEvent> containerFactory(){
	ConcurrentKafkaListenerContainerFactory<String, OrderEvent> factory=new ConcurrentKafkaListenerContainerFactory<>();
	factory.setConsumerFactory(consumerFactory());
	return factory;
}

}
