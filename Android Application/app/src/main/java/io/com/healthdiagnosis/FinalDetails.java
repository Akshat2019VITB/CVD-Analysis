package io.com.healthdiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class FinalDetails extends AppCompatActivity {
    CheckBox ch1,ch2, ch3;
    String smoke,alcohol,activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_details);
        ch1 = findViewById(R.id.chkSmoke);
        ch2 = findViewById(R.id.chkAlcohol);
        ch3 = findViewById(R.id.chkActivity);
        Button btn = findViewById(R.id.btnPredict);
        smoke = "0";
        alcohol = "0";
        activity = "0";
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch1.isChecked()) smoke = "1";
                if(ch2.isChecked()) alcohol = "1";
                if(ch3.isChecked()) activity = "1";

                Intent i = new Intent (FinalDetails.this,Result.class);
                i.putExtra("smoke",smoke);
                Details.smoke = smoke;
                i.putExtra("alcohol",alcohol);
                Details.alcohol = alcohol;
                i.putExtra("activity",activity);
                Details.activity = activity;
                startActivity(i);
            }
        });


    }
}