package com.example.demo.util;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisComponent {
    private final ReactiveRedisOperations<String, Object> redisOperations;

    /**
     * 해시키에 key, value 세팅
     * @param key
     * @param hasKey
     * @param val
     * @return
     */
    public Mono<Object> set(String key, String hasKey, Object val) {
        return redisOperations.opsForHash().put(key, hasKey, val).map(b -> val);
    }

    /**
     * key에 해당하는 값 조회
     * @param key
     * @return
     */
    public Flux<Object> get(@NonNull String key) {
        return redisOperations.opsForHash().values(key);
    }

    /**
     * key, hashKey에 매핑되는 값 조회
     * @param key
     * @param hashKey
     * @return
     */
    public Mono<Object> get(String key, Object hashKey) {
        return redisOperations.opsForHash().get(key, hashKey);
    }

    /**
     * key, hashkey에 매핑되는 데이터 삭제
     * @param key
     * @param hashKey
     * @return
     */
    public Mono<Long> remove(String key, Object hashKey) {
        return redisOperations.opsForHash().remove(key, hashKey);
    }
    


}
