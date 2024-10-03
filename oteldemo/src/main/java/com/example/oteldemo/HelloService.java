package com.example.oteldemo;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @WithSpan("HelloService:getMessage")
    public String getMessage() {
        return "Hello world";
    }
}
