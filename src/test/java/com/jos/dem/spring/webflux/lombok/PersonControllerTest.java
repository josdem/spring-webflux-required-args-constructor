package com.jos.dem.spring.webflux.lombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jos.dem.spring.webflux.lombok.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	@DisplayName("Should get all persons")
	void shouldGetAllPersons() {
		webTestClient.get()
				.uri("/persons/")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Person.class)
				.value(persons -> {
					assertTrue(persons.contains(new Person("josdem", "joseluis.delacruz@gmail.com")), "should contain josdem");
					assertTrue(persons.contains(new Person("tgrip", "tgrip@email.com")), "should contain tgrip");
					assertTrue(persons.contains(new Person("edzero", "edzero@email.com")), "should contain edzero");
					assertTrue(persons.contains(new Person("skuarch", "skuarch@email.com")), "should contain skuarch");
					assertTrue(persons.contains(new Person("jeduan", "jeduan@email.com")), "should contain jeduan");
				});
	}

	@Test
	@DisplayName("Should get josdem")
	void shouldGetPerson(){
		webTestClient.get()
				.uri("/persons/josdem")
				.exchange()
				.expectStatus().isOk()
				.expectBody(Person.class)
				.value(person -> {
					assertEquals(new Person("josdem", "joseluis.delacruz@gmail.com"), person, "should get josdem");
				});
	}

}
