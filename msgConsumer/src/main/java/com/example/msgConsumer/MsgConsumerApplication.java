package com.example.msgConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsgConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgConsumerApplication.class, args);
	}

}
