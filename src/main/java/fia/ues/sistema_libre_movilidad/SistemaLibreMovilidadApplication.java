package fia.ues.sistema_libre_movilidad;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;

import fia.ues.sistema_libre_movilidad.Entidad.Frontera;
import fia.ues.sistema_libre_movilidad.Entidad.Pais;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Repositorio.FronteraRepositorio;
import fia.ues.sistema_libre_movilidad.Repositorio.PaisRepositorio;
import fia.ues.sistema_libre_movilidad.Repositorio.UsuarioRepositorio;
import fia.ues.sistema_libre_movilidad.listener.SolicitudMessageListener;

@SpringBootApplication
public class SistemaLibreMovilidadApplication extends SpringBootServletInitializer implements CommandLineRunner{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SistemaLibreMovilidadApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaLibreMovilidadApplication.class, args);
	}

	public final static String SFG_MESSAGE_QUEUE = "sfg-message-queue";
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	UsuarioRepositorio repositorio;

	@Autowired
	PaisRepositorio paisRepositorio;

	@Autowired
	FronteraRepositorio fronteraRepositorio;

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

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario1 = new Usuario("Admin","AdminApellido","12-2-1989","M", "79898989","admin@gmail.com", encoder.encode("1234"),"Administrador");
		repositorio.save(usuario1);


		Pais pais1= new Pais("El Salvador");
		paisRepositorio.save(pais1);
		Pais pais2= new Pais("Guatemala");
		paisRepositorio.save(pais2);
		Pais pais3= new Pais("Honduras");
		paisRepositorio.save(pais3);
		Pais pais4= new Pais("Nicaragua");
		paisRepositorio.save(pais4);


		Frontera frontera1=new Frontera("El Poi",pais1);
		fronteraRepositorio.save(frontera1);


	}
}
