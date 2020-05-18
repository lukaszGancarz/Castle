package com.clockworkjava.castle.domain.repository;

import com.clockworkjava.castle.domain.Knight;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void createKnight(Knight knight);

    void build();

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight) {
        throw new UnsupportedOperationException();
    }

}
