package com.example.shutdownhook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/process/{no}")
    public String process(@PathVariable int no) throws InterruptedException {
      System.out.println("Start Process No." + no);
        Thread.sleep(20000);
        System.out.println("End Process No." + no);
        return "shutdown!";
    }

    @GetMapping("/terminate")
    public void terminate() throws InterruptedException {
      System.out.println("Terminating!");
      System.exit(0);
    }
}