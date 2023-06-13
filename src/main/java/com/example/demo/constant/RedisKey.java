package com.example.demo.constant;

import lombok.Getter;

@Getter
public enum RedisKey {
    HEAL_SPOT_KEY("HEAL_SPOT_KEY", "휴양림 키"),
    MEMBER_KEY("MEMBER_KEY", "멤버 키");

    
    private String key;
    private String desc;
    
    RedisKey(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }


}
