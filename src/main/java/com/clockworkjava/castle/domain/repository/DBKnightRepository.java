package com.clockworkjava.castle.domain.repository;

import com.clockworkjava.castle.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository{

    @Override
    public void createKnight(String name, int age) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Knight> getAllKnights() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteKnight(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createKnight(Knight knight) {
        throw new UnsupportedOperationException();
    }

    @Override
    @PostConstruct
    public void build() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Knight getKnightById(Integer id) {
        throw new UnsupportedOperationException();
    }
}
