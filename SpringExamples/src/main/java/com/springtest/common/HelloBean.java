package com.springtest.common;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class HelloBean implements ApplicationEventPublisherAware, BeanNameAware{
	    private String message;
	    private ApplicationEventPublisher publisher;
	    //private String beanName;
	    @Value("#{19+1}") // 20
		private double add; 
	    
	    public double getAdd() {
			return add;
		}

		public void setMessage(String message)
	    {
	        this.message = message;
	    }
	    
	    public void getMessage()
	    {
	        System.out.println("Your message : " + message);
	        
	        /// Publish an event whenever this method invoked
	        HelloEvent helloEvent = new HelloEvent(this);
	        publisher.publishEvent(helloEvent); 
	    }
	    
	    
	    
	    
	    
	    
	    	/// getting event handler from spring framework
		public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
			this.publisher = applicationEventPublisher;
			
		}
		
			/// override setBeanName method from BeanNameAware interface
		public void setBeanName(String beanName) {
			//System.out.println(beanName + " bean has been initialized.");
		}
			
}
