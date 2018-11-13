package edu.nuc.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.ApplicationContextAssert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {
   @Autowired
    Student student;
   @Autowired
   ApplicationContext ioc;

    @Test
    public void contextLoads() {

        //System.out.println(student.toString());
        //System.out.println(ioc.containsBean("Student001"));
        System.out.println(ioc.containsBean("student"));
        //System.out.println(ioc.getBean("Student001").toString());
        //System.out.println(student==ioc.getBean("Student001"));
        //
        System.out.println(ioc.getBean("student").toString());
        //System.out.println(student==ioc.getBean("student"));
    }
}
