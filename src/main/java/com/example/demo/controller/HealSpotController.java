package com.example.demo.controller;

import com.example.demo.model.HealSpot;
import com.example.demo.service.HealSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class HealSpotController {
    private final HealSpotService healSpotService;

    @PostMapping("/healspot")
    public Mono<HealSpot> create(@RequestBody HealSpot healSpot) {
        return healSpotService.create(healSpot);
    }

    @GetMapping("/healspot/{id}")
    public Mono<HealSpot> get(@PathVariable String id) {
        return healSpotService.get(id);
    }

    @GetMapping("/healspot")
    public Flux<HealSpot> getAll() {
        return healSpotService.getAll();
    }

    @DeleteMapping("/healspot/{id}")
    public Mono<Long> delete(@PathVariable  String id) {
        return healSpotService.delete(id);
    }


}
