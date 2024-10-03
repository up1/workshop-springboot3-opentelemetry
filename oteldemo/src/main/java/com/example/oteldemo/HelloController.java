package com.example.oteldemo;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@RestController
public class HelloController {
    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("java-service");
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final HelloService service;

    public HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String sayHi(){
        logger.info("Default log");
        logger.info("Add property message {}", keyValue("orderId", 1234));

        return service.getMessage();
    }

}