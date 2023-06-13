package com.example.demo.model;

import com.example.demo.util.LocalDateDeserializer;
import com.example.demo.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;

@RedisHash(timeToLive = 60)
@Setter
@Getter
public class HealSpot {
    @NonNull
    String id;
    String name;
    String address;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate createAt;
}
