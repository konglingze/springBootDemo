package edu.nuc.springboot.task.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.nuc.springboot.task.service.AsyncService;

@RestController
public class HelloController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }
}
