package com.example.msgConsumer.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class ArtemisConfiguration {

    public static final String SLACK_QUEUE = "slack.queue";

}
