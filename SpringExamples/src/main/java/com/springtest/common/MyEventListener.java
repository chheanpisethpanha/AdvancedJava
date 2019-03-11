package com.springtest.common;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

///to tell that this class is a Spring Component with this annotation
@Component
public class MyEventListener implements ApplicationListener{

	/// Listen to event occur within the application
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
	} 
}
