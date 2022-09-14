package com.filichkin.webfluxfargate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

@RestController
@RequestMapping("/test/v1")
public class Controller {

    @GetMapping
//    @CrossOrigin
    Mono<String> getUser(){
      return Mono.delay(Duration.ofSeconds(1)).map(ignore-> UUID.randomUUID().toString());
    }
}
