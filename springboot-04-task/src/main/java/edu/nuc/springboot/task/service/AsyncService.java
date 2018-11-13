package edu.nuc.springboot.task.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    //@Async

    //@Scheduled(cron = "* * * * * Mon-SAT")
    //@Scheduled(cron = "0,1,2,3,4,5 * * * * Mon-SAT")
    //@Scheduled(cron = "0-5 * * * * Mon-SAT")
    @Scheduled(cron = "0/5 * * * * Mon-SAT")
    public void hello() {
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("处理数据中");

    }


}
