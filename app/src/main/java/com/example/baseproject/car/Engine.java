package com.example.baseproject.car;

public class Engine {

    private int power;

    public Engine(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                '}';
    }
}
