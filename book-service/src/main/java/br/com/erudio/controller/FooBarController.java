package br.com.erudio.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("book-service")
@Tag(name = "Foo Bar")
public class FooBarController {

    private Logger logger = LoggerFactory.getLogger(FooBarController.class);
    static int x;
    @Operation(summary = "Foo bar")
    @GetMapping("/foo-bar")
    //@Retry(name = "foo", fallbackMethod = "fallback")
    //@CircuitBreaker(name = "default", fallbackMethod = "fallback")
    //@RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String fooBar() {

        logger.info((x++) +"=  Pedido para foo-bar foi recebido!!!");
        //var response = new RestTemplate().getForEntity("http//localhost:8080/foo-bar", String.class);
        return "Foo Bar!!!";
        //return response.getBody();
    }

    public String fallback( Exception ex){
        return "fallbackMethod";
    }
}
