package io.com.healthdiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PressureProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_profile);
        EditText edtSys = findViewById(R.id.edtSystolic);
        EditText edtDiaSys = findViewById(R.id.edtDiasys);
        EditText edtHeartR = findViewById(R.id.edtHeart);

        Button btn = findViewById(R.id.pressureNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sys = edtSys.getText().toString();
                String diasys = edtHeartR.getText().toString();
                String heartRate = edtHeartR.getText().toString();
                Intent i = new Intent (PressureProfile.this,BloodProfile.class);
                i.putExtra("sys",sys);
                Details.aplo = sys;
                Details.aphi = diasys;
                i.putExtra("diasys",diasys);
                i.putExtra("heartRate",heartRate);
                Details.HeartRate = heartRate;
                startActivity(i);

            }
        });
    }
}