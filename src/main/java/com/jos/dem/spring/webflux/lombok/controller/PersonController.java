package com.jos.dem.spring.webflux.lombok.controller;

import com.jos.dem.spring.webflux.lombok.model.Person;
import com.jos.dem.spring.webflux.lombok.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/")
  public Flux<Person> findAll(){
    log.info("Calling find persons");
    return personService.getAll();
  }

  @GetMapping("/{nickname}")
  public Mono<Person> findById(@PathVariable String nickname){
    log.info("Calling find person by nickname: {}", nickname);
    return personService.getByNickname(nickname);
  }

}
