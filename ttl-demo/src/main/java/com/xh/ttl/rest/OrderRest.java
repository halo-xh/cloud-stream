package com.xh.ttl.rest;

import com.xh.ttl.kafka.producer.TimedSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class OrderRest {

    @Autowired
    private TimedSender sender;

    @RequestMapping("/order/{id}")
    public String sendOrder(@PathVariable String id) {
        try {
            sender.sender(null);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return id;
    }


}
