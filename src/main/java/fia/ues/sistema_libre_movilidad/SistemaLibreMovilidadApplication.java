package fia.ues.sistema_libre_movilidad;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;

import fia.ues.sistema_libre_movilidad.listener.SolicitudMessageListener;

@SpringBootApplication
public class SistemaLibreMovilidadApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SistemaLibreMovilidadApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaLibreMovilidadApplication.class, args);
	}

	public final static String SFG_MESSAGE_QUEUE = "sfg-message-queue";
	
	@Bean
	Queue queue() 
	{
		return new Queue(SFG_MESSAGE_QUEUE, false); 
	}

	@Bean
	TopicExchange exchange(){
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(SFG_MESSAGE_QUEUE);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	MessageListenerAdapter listenerAdapter){
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(SFG_MESSAGE_QUEUE);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(SolicitudMessageListener reciever){
		return new MessageListenerAdapter(reciever, "receiveMessage");
	}
}
