package org.tms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tms.lesson43il.exceptions.CarFailedException;

import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class FeignConfig {

    private final ObjectMapper mapper;

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {

            int status = response.status();

            if (status >= 400 && status <= 499) {

                Response.Body body = response.body();

                try {
                    return mapper.readValue(body.asInputStream(), CarFailedException.class);
                }
                catch (IOException exc) {
                    throw new RuntimeException();
                }
            }
            return null;
        };
    }
}