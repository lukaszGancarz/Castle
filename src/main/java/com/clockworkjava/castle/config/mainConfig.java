package com.clockworkjava.castle.config;

import com.clockworkjava.castle.domain.repository.DBKnightRepository;
import com.clockworkjava.castle.domain.repository.InMemoryRepository;
import com.clockworkjava.castle.domain.repository.KnightRepository;
import org.springframework.context.annotation.*;

@Configuration
public class mainConfig {

    @Bean(name="inMemoryKnightRepository")
    @Profile("!dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }
}
