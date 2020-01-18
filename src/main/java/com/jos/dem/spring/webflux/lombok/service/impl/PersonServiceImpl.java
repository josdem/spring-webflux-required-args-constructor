package com.jos.dem.spring.webflux.lombok.service.impl;

import com.jos.dem.spring.webflux.lombok.model.Person;
import com.jos.dem.spring.webflux.lombok.service.PersonService;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {

  private Map<String, Person> persons = new HashMap<>();

  @PostConstruct
  public void setup(){
    Stream.of(new Person("josdem", "joseluis.delacruz@gmail.com"),
        new Person("tgrip", "tgrip@email.com"),
        new Person("edzero", "edzero@email.com"),
        new Person("skuarch", "skuarch@email.com"),
        new Person("jeduan", "jeduan@email.com"))
        .forEach(person -> persons.put(person.getNickname(), person));
  }

  public Flux<Person> getAll(){
    return Flux.fromIterable(persons.values());
  }

  public Mono<Person> getByNickname(String nickname){
    return Mono.just(persons.get(nickname));
  }

}
