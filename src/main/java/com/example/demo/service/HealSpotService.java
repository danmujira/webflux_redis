package com.example.demo.service;

import com.example.demo.model.HealSpot;
import com.example.demo.repository.RedisHealSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class HealSpotService {
    private final RedisHealSpotRepository repository;

    public Mono<HealSpot> create(HealSpot healSpot) {
        return repository.save(healSpot);
    }

    public Mono<HealSpot> get(String key) {
        return repository.get(key);
    }

    public Flux<HealSpot> getAll() {
        return repository.getAll();
    }

    public Mono<Long> delete(String key) {
        return repository.delete(key);
    }


}
