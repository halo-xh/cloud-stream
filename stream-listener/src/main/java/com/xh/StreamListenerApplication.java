package com.xh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding({Sink.class})
@SpringBootApplication
public class StreamListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamListenerApplication.class, args);
	}

}
