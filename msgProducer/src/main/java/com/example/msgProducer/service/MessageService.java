package com.example.msgProducer.service;

import com.example.msgProducer.configuration.ArtemisConfiguration;
import com.example.msgProducer.domain.dto.AmqMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {

    private final JmsTemplate jmsTemplate;

    public void pushToSlack(AmqMessageDto msgBody) {

        log.info("Push to slack queue");
        jmsTemplate.convertAndSend(ArtemisConfiguration.SLACK_QUEUE, msgBody.getMsg());
    }

}
