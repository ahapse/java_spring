package com.avdhoot.Maven1;
import javax.naming.Context;
import javax.swing.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Below 3 lines demonstrate the XML based configuration for Dependency injection;
//    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
//    	System.out.println(context);
//    	Object ibjObject = context.getBean("car");
    	
    	
//    	Below lines demonstrate the Annotation based configuration for dependency based injection;
//    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
//    	System.out.println(context);
//    	Object ibjObject = context.getBean("annotationBased");

    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
    	Object tObject = context.getBean("example");
    	System.out.println(tObject);
    	
        
    }
}
