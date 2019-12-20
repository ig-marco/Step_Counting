package com.example.stepcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView display;
    SensorManager sensorManager;
    Sensor sensor;
    Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.display);
        reset=(Button)findViewById(R.id.reset);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else
            Toast.makeText(this, "No sensor detected", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        display.setText("" + event.values[0] + ".");



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }



}
