package com.spring.configuration;

import com.hazelcast.config.HazelCast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class HazelCastConfig {

    private String configName = "group1";

    private HazelcastInstance instance;
    @PostConstruct
    public void init(){
        instance = HazelCast.instance(configName);
    }
    public <E> IList<E> getList(String listName) {
        return instance.getList(listName);
    }
}