package com.springtest.common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class Main {
	static ExpressionParser expressionParser = new SpelExpressionParser();
		public static void main(String[] args) throws Exception
		{
			//BeanFactory bean = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
			//ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\Ztranger\\eclipse-workspace\\SpringExamples\\src\\main\\resources\\applicationContext.xml");
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
			//HelloBean helloBean = (HelloBean) bean.getBean("myBean");
			HelloBean helloBean = (HelloBean) context.getBean("myBean");
			helloBean.getMessage();
			//System.out.println(helloBean.getAdd());
			
			
//			Expression expression = expressionParser.parseExpression("'Hello SpEL'");
//			String strVal = (String) expression.getValue();
//	        System.out.println("STR VALUE: " + strVal);
		}
}
