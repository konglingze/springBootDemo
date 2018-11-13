package edu.nuc.springboot;

import ch.qos.logback.core.net.SyslogOutputStream;
import edu.nuc.springboot.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
        // amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        /*amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE, "amqpadmin.exchange",
                "amqpadmin.haha", null));*/
    }

    @Test
    public void contextLoads() {
        //rabbitTemplate.send (exchange,routeKey,object);

        Map<String, Object> map = new HashMap<>();
        map.put("mag", "中北大学来电");
        map.put("data", Arrays.asList("helloworld", 123, true));
        rabbitTemplate.convertAndSend("exchange.direct",
                "zhongbeidaxue", map);
    }

    @Test
    public void contextLoads2() {
        //rabbitTemplate.send (exchange,routeKey,object);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmail("694458593@qq.com");
        employee.setLastName("赵晓阳");
        employee.setGender(1);
        employee.setdId(1);
        rabbitTemplate.convertAndSend("exchange.direct",
                "zhongbeidaxue", employee);
    }

    @Test
    public void receive() {
        Object object = rabbitTemplate.receiveAndConvert("zhongbeidaxue");
        System.out.println(object.getClass());
        System.out.println(object);
    }

    @Test
    public void receive2() {


    }

}
