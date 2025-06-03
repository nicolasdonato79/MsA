package com.example.msA.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();
    private static final Logger logger = LoggerFactory.getLogger(CustomErrorDecoder.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        String responseBody = "No message";
        try {
            if (response.body() != null) {
                responseBody = new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
                logger.error("Feign error body: {}", responseBody);
            }
        } catch (IOException e) {
            logger.error("Error reading response body", e);
        }

        return new RuntimeException("Error from MSMiddleware: " + responseBody + " (HTTP Status: " + response.status() + ")");
    }
}
