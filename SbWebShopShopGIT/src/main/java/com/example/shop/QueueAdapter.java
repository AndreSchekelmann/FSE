package com.example.shop;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.amqp.core.AmqpTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QueueAdapter implements MessageQueue{
	

    public static final boolean NON_DURABLE = false;
    public static final String MY_QUEUE_NAME = "myQueue";
    
    private final AmqpTemplate amqpTemplate;
    
    public QueueAdapter (AmqpTemplate amqpTemplate) {
    	this.amqpTemplate = amqpTemplate;
    }
    
   
    public boolean send(DomainEvent domainEvent) {
    	
    	String payload = "";
    	
    	if (domainEvent.getEvent().equalsIgnoreCase("bestellungAbgeschlossen")) {
    		
    		Bestellung bestellung = (Bestellung)domainEvent.getObject();
    		
    		Collection<BestellItemTO> itemToList= new ArrayList<BestellItemTO>();
    		for (BestellItem item:bestellung.getItems())
    			itemToList.add(new BestellItemTO(item));
    		
    		ObjectMapper objectMapper = new ObjectMapper();
    		 
    		try {
    			payload = objectMapper.writeValueAsString(itemToList);
    		
    		} catch (JsonProcessingException e) {
    			// TODO Auto-generated catch block
    			// die folgende Meldung gehört eigentlich in ein Log
    			System.out.println("Interner Fehler");
    			e.printStackTrace();
    			return false;
    		}
    		
    		System.out.println("DEBUG INFO Payload: "+payload);
    		
    	}
    	
    	amqpTemplate.convertAndSend(MY_QUEUE_NAME, domainEvent.getEvent() + "/" + payload);
    	
    	return true;
    	
    }
   
    
}
