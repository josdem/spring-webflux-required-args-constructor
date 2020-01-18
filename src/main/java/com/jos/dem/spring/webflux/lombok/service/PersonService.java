package com.jos.dem.spring.webflux.lombok.service;

import com.jos.dem.spring.webflux.lombok.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

  Flux<Person> getAll();
  Mono<Person> getByNickname(String nickname);

}
