package com.example.demo;

import com.example.demo.model.HealSpot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWebClientTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void save_test() {
        HealSpot healSpot = new HealSpot();
        healSpot.setId("id_3");
        healSpot.setName("제주 자연휴양림");
        healSpot.setAddress("제주 애월 20");
        healSpot.setCreateAt(LocalDate.now());

        webTestClient.post().uri("/v1/healspot")
                .body(BodyInserters.fromValue(healSpot))
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.id").isEqualTo("id_3");
    }

    @Test
    public void get_all_test() {
        webTestClient.get().uri("/v1/healspot")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(HealSpot.class);
    }

    @Test
    public void get_one_test() {
        webTestClient.get().uri("/v1/healspot/id_2")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(HealSpot.class);
    }
}
