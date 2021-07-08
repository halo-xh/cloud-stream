package com.xh.stream;

import com.xh.stream.channels.ChannelOutConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({ChannelOutConfig.class})
public class Topic2channelApplication {

    public static void main(String[] args) {
        SpringApplication.run(Topic2channelApplication.class, args);
    }

}
