package com.example.baseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.baseproject.builder.Builder;
import com.example.baseproject.builder.HuyndaiCarBuilder;
import com.example.baseproject.builder.KiaCarBuilder;
import com.example.baseproject.car.CarType;
import com.example.baseproject.singleton.CarSingleton;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpCarType, mSpCarBranch;
    private Button mBtnSendToDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mBtnSendToDetail.setOnClickListener(v -> sendData());
    }

    private void initView() {
        mSpCarType = findViewById(R.id.sp_cartype);
        mSpCarBranch = findViewById(R.id.sp_car_branch);
        mBtnSendToDetail = findViewById(R.id.btn_send);
    }

    // SUV_CAR, SPORT_CAR, TRUCK_CAR -> 0, 1, 2
    private void sendData() {
        Builder builder = null;
        if (mSpCarBranch.getSelectedItemPosition() == 0) {
            builder = new HuyndaiCarBuilder();
        } else {
            builder = new KiaCarBuilder();
        }


        OEMDirector oemDirector = new OEMDirector();
        switch (mSpCarType.getSelectedItemPosition()) {
            case 0:
                builder.setCarType(CarType.SUV_CAR);
                break;
            case 1:
                builder.setCarType(CarType.SPORT_CAR);
                break;
            case 2:
                builder.setCarType(CarType.TRUCK_CAR);
                break;

        }

        CarSingleton carSingleton = CarSingleton.getInstance();
        carSingleton.setCar(oemDirector.handleCarType(builder));

        Intent intent = new Intent(this, DetailCarActivity.class);
        startActivity(intent);
    }
}