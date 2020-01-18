package com.jos.dem.spring.webflux.lombok.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  private String nickname;
  private String email;

}
