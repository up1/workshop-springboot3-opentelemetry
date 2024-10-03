# Workshop :: Spring Boot 3 + OpenTelemetry
* Spring Boot 3
* Opentelemetry
  * Distributed tracing
  * Application metric
  * Logging

## Steps to run
```
$docker compose up -d --build 
$docker compose ps
```

## Distributed tracing with [Jaeger](https://www.jaegertracing.io/)
* Hello API
  * http://localhost:8080/hello
  * http://localhost:8080/user/all
* Jaeger
  * http://localhost:16686/search

## Application metric
* Actuator with Prometheus
  * http://localhost:8080/actuator
  * http://localhost:8080/actuator/prometheus
* Login API
  * Login success = 200 => http://localhost:8080/login?case=success
  * Login fail case01 = 400 => http://localhost:8080/login?case=case01
  * Login fail case02 = 500 => http://localhost:8080/login?case=case02
* Prometheus server
  * http://localhost:9000
  * metric name
    * http_server_requests_seconds_count
    * login_api_total