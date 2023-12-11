package com.example.shop;

public interface MessageQueue {
	
	public boolean send(DomainEvent domainEvent);

}
