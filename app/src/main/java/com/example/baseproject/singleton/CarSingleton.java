package com.example.baseproject.singleton;

import com.example.baseproject.car.Car;

public class CarSingleton {
    private static CarSingleton instance;
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }


    private CarSingleton() {

    }

    public static synchronized CarSingleton getInstance() {
        if (instance == null) {
            instance = new CarSingleton();
        }
        return instance;
    }
}
