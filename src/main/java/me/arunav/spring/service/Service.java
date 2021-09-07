package me.arunav.spring.service;

import me.arunav.spring.data.Dao;

import java.util.Arrays;

public class Service {

    private final Dao dao;

    Service(Dao dao) {
        this.dao = dao;
    }

    public int calculateSum() {
        return Arrays.stream(dao.getAllData()).sum();
    }
}
