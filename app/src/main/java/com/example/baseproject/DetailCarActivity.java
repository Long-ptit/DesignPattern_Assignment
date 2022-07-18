package com.example.baseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.baseproject.car.Car;
import com.example.baseproject.singleton.CarSingleton;

public class DetailCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_car);
        CarSingleton carSingleton = CarSingleton.getInstance();
        Car car = carSingleton.getCar();
        TextView textView = findViewById(R.id.tv_data);
        textView.setText(car.toString());
        Log.d("ptit", "onCreate: " + car.toString());
    }
}