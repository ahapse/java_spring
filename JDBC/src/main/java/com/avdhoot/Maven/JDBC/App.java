package com.avdhoot.Maven.JDBC;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */			
public class App 
{
    public static void main( String[] args )
    {			
        System.out.println( "jdbc started working!" );
        ApplicationContext aContext = new ClassPathXmlApplicationContext("com/avdhoot/Maven/JDBC/Config.xml");
        JdbcTemplate template = aContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String querString = "insert into student values(?,?,?)";
        int result = template.update(querString, 102, "PQR", "AHM");
        System.out.println("No. of updates" + result);
    }
}			
			