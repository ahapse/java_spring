package com.avdhoot.spring.jdbc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avdhoot.spring.jdbc1.dao.StudentDao;
import com.avdhoot.spring.jdbc1.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/avdhoot/spring/jdbc1/config.xml");
        
        StudentDao studentDao = context.getBean("StudentDao", StudentDao.class);
//        
//        Student student = new Student();
//        student.setId(2);
//        student.setNameString("Today2");
//        student.setCityString("Now2");
//        
//        int res = studentDao.create(student);
//        System.out.println("Results = "+res);
        
        System.out.println(studentDao.getStudent(2));
    }
}
