package me.arunav.spring.service;

import java.util.Arrays;

public class Service {

    private Dao dao;

    Service(Dao dao) {
        this.dao = dao;
    }

    public int calculateSum() {
        return Arrays.stream(dao.getAllData()).sum();
    }
}
