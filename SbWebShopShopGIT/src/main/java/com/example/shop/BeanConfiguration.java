package com.example.shop;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	
	 @Bean
	 ShopService shopService(ArtikelRepository artikelRepository, ShopDomainService shopDomainService) {
	        return new ShopApplicationService(artikelRepository, shopDomainService);
	 }
	 
	 @Bean
	 ShopDomainService bestandDomainService(ArtikelRepository artikelRepository, MessageQueue messageQueue) {
	        return new ShopDomainService(artikelRepository, messageQueue);
	 }
	 
	 @Bean
	 ArtikelRepository artikelRepository(JdbcArtikelEntityRepository jdbcArtikelEntityRepository) {
	        return new DbArtikelRepository(jdbcArtikelEntityRepository);
	 }
	 
	 @Bean
	 MessageQueue messageQueue(AmqpTemplate amqpTemplate) {
		 return new QueueAdapter(amqpTemplate);
	 }
	 
	 @Bean
	 public Queue myQueue() {
		 return new Queue(QueueAdapter.MY_QUEUE_NAME, QueueAdapter.NON_DURABLE);    
   }
	 
}
