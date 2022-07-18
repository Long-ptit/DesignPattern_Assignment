package com.example.baseproject;

import com.example.baseproject.builder.Builder;
import com.example.baseproject.builder.HuyndaiCarBuilder;
import com.example.baseproject.builder.KiaCarBuilder;
import com.example.baseproject.car.Car;
import com.example.baseproject.car.CarType;
import com.example.baseproject.car.Engine;

public class OEMDirector {

    public void createCarSUV(Builder builder) {
        builder.setCarType(CarType.SUV_CAR);
    }


    public void createCarSport(Builder builder) {
        builder.setCarType(CarType.SPORT_CAR);
    }

    public void createCarTruck(Builder builder) {
        builder.setCarType(CarType.TRUCK_CAR);
    }

    public Car handleCarType(Builder builder) {
        if (builder instanceof HuyndaiCarBuilder) {
            builder.setSeats(2);
            builder.setEngine(new Engine(50));
        } else if (builder instanceof KiaCarBuilder) {
            builder.setSeats(4);
            builder.setEngine(new Engine(70));
        }

        return builder.build();
    }


}
