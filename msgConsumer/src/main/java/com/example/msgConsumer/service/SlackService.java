package com.example.msgConsumer.service;

import static java.time.Instant.now;

import com.example.msgConsumer.clients.SlackClient;
import com.example.msgConsumer.configuration.ArtemisConfiguration;
import com.example.msgConsumer.domain.dto.AmqMessageDto;
import com.example.msgConsumer.domain.dto.SlackPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;


@Slf4j
@Service
@RequiredArgsConstructor
public class SlackService {

    private final SlackClient slackClient;

    @JmsListener(destination = ArtemisConfiguration.SLACK_QUEUE)
    public void consumeMessage(Message message) {

        System.out.println("--------------->>  " + message.getPayload().toString());
        System.out.println("--------------->>  " + message.toString());
        System.out.println("--------------->>  " + message.getHeaders().values().toString());
//        System.out.println("--------------->>  " + payload.toString());

        slackClient.pushSlackMsg(
            SlackPayload.builder().text(placeTimestamp() + "Last msg -> " + message.getPayload()).build());
//        Integer delayMs = message.getMessageProperties().getReceivedDelay();
//
//        if (numReattempt != null && parseInt(numReattempt) > 0) {
//            slackClient.pushSlackMsg(SlackPayload.builder().text(placeTimestamp() + "Reattempt No -> " + numReattempt + " msg -> " + payload.getMsg()).build());
//            template.convertAndSend(DELAYED_EXCHANGE, DELAY_QUEUE_NAME, buildMessage(payload, delayMs, numReattempt));
//        } else {
//            slackClient.pushSlackMsg(SlackPayload.builder().text(placeTimestamp() + "Last mesg -> " + payload.getMsg()).build());
//        }
    }

    private String placeTimestamp() {
        return "Timestamp : [" + now() + "] ";
    }

//    private Message buildMessage(Object body, Integer delayMs, String retryCount) {
//
//        MessageProperties props = new MessageProperties();
//        Integer retry = parseInt(retryCount);
//        retry--;
//
////        props.setHeader(DELAY_HEADER, delayMs == null ? RETRY_BACKOFF : delayMs);
//        props.setDelay(delayMs == null ? parseInt(RETRY_BACKOFF) : delayMs);
//        props.setHeader(NUM_ATTEMPT_HEADER, String.valueOf(retry));
//        props.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
//
//        System.out.println("PROPS slack : " + props.toString());
//
//        return messageConverter.toMessage(body, props);
//    }
}