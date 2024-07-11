package com.example.oteldemo;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("java-service");
    private final HelloService service;


    public HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String sayHi(){
        return service.getMessage();
    }

}

@Service
class HelloService {
    @WithSpan("HelloService:getMessage")
    public String getMessage() {
        return "Hello world";
    }
}