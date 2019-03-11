package com.springtest.common;

import org.springframework.context.ApplicationEvent;

public class HelloEvent extends ApplicationEvent{
	
	/// constructor to initialize the event
	public HelloEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	//creating custom event message
	public String toString() {
		return "Hello Event Occured";
	}
}
