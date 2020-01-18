package com.jos.dem.spring.webflux.lombok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LombokController {

  @GetMapping("/")
  public Mono<String> index(){
    return Mono.just("Hello World!");
  }

}
