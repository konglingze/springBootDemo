package edu.nuc.springboot.service;

import edu.nuc.springboot.bean.Employee;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class employeeService {

  /*  @RabbitListener(queues = "zhongbeidaxue")
    public void receive(Employee employee) {
        System.out.println("监听程序正在监听");
        System.out.println(employee);

    }*/

    @RabbitListener(queues = "zhongbeidaxue")
    public void receive2(Message message) {
        System.out.println(message.getBody());
        System.out.println("------------------------------");
        System.out.println(message.getMessageProperties());
    }

}
