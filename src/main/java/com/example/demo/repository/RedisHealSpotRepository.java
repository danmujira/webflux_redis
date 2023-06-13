package com.example.demo.repository;

import com.example.demo.constant.RedisKey;
import com.example.demo.model.HealSpot;
import com.example.demo.util.RedisComponent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class RedisHealSpotRepository {

    private final RedisComponent redisComponent;
    private final ObjectMapper objectMapper;

    public Mono<HealSpot> save(HealSpot healSpot) {
        return redisComponent.set(RedisKey.HEAL_SPOT_KEY.getKey(), healSpot.getId(), healSpot).map(b -> healSpot);
    }

    public Mono<HealSpot> get(String key) {
        return redisComponent.get(RedisKey.HEAL_SPOT_KEY.getKey(), key).flatMap(b -> Mono.just(objectMapper.convertValue(b, HealSpot.class)));
    }

    public Flux<HealSpot> getAll() {
        return redisComponent.get(RedisKey.HEAL_SPOT_KEY.getKey())
                .map(b -> objectMapper.convertValue(b, HealSpot.class))
                .collectList().flatMapMany(Flux::fromIterable);
    }

    public Mono<Long> delete(String key) {
        return redisComponent.remove(RedisKey.HEAL_SPOT_KEY.getKey(), key);
    }
}
