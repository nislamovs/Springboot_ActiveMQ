package com.example.msgConsumer.configuration.errorHandling;

import com.example.msgConsumer.domain.exceptions.SlackTokenAuthException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        if (    response.status() == HttpStatus.FORBIDDEN.value() || response.status() == HttpStatus.NOT_FOUND.value())
            throw new SlackTokenAuthException("Some problem was encountered using slack token. Check if it is correct and try again.");
        return new Exception(response.reason());
    }
}