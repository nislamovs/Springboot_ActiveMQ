package com.example.msgProducer.controllers;


import com.example.msgProducer.domain.dto.AmqMessageDto;
import com.example.msgProducer.domain.exceptions.UnknownChannelException;
import com.example.msgProducer.domain.responses.DefaultResponse;
import com.example.msgProducer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;
import static java.time.Instant.now;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(value = "/api/v1/message")
@RequiredArgsConstructor
@Slf4j
@RestController
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/{messagingChannel}")
    public ResponseEntity<?> pushMsgToChannel(@PathVariable(value = "messagingChannel") String msgChannel,
                                              @RequestBody AmqMessageDto msgBody) {

        switch (msgChannel.toUpperCase()) {

            case "SLACK":
                messageService.pushToSlack(msgBody);
                break;

            default:
                throw new UnknownChannelException(format("Channel with name [%s] not found!", msgChannel));
        }

        return ok(DefaultResponse.builder().status("Message pushed!").timestamp(now()).build());
    }
}
