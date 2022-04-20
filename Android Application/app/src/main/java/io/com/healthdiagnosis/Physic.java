package io.com.healthdiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Physic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic);
        EditText edtHeight = findViewById(R.id.edtHeight);
        EditText edtWeight = findViewById(R.id.edtWeight);
        TextView t = findViewById(R.id.txtBMI);
        Button btn = findViewById(R.id.phNext);
        Button setBMI = findViewById(R.id.setBMI);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = edtHeight.getText().toString();
                String weight = edtWeight.getText().toString();
                Intent i = new Intent (Physic.this,PressureProfile.class);
                double h = Integer.parseInt(height);
                double w = Integer.parseInt(weight);
                double bmi = w / (h *0.01 * h * 0.01);
                i.putExtra("bmi",bmi);
                Details.bmi = ""+bmi;
                i.putExtra("height",height);
                Details.height = height;
                i.putExtra("weight",weight);
                Details.weight = weight;
                startActivity(i);
            }
        });
        setBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = edtHeight.getText().toString();
                String weight = edtWeight.getText().toString();
                double h = Integer.parseInt(height);
                double w = Integer.parseInt(weight);
                double bmi = w / (h *0.01 * h * 0.01);
                t.setText(""+bmi);
            }
        });

    }
}