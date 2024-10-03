package com.example.oteldemo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping("/login")
    public String login( @RequestParam(name = "case") String caseName){
        if("success".equals(caseName)) {
            generateMetric(caseName, 200);
        } else if ("case01".equals(caseName)) {
            generateMetric(caseName, 400);
        } else if ("case02".equals(caseName)) {
            generateMetric(caseName, 500);
        } else {
            generateMetric("other", 503);
        }
        return "Login with " + caseName;
    }

    private void generateMetric(String caseName, int code) {
        Counter counter = Counter
                .builder("login_api")
                .description("Login metric")
                .tag("case", caseName)
                .tag("status_code", String.valueOf(code))
                .register(meterRegistry);
        counter.increment();
    }

}