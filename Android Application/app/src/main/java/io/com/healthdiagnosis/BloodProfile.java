package io.com.healthdiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BloodProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_profile);
        EditText edtChol = findViewById(R.id.edtCholestrol);
        EditText edtGluc = findViewById(R.id.edtGlucose);
        Button btn = findViewById(R.id.bldNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cholestrol = edtChol.getText().toString();
                String glucose = edtGluc.getText().toString();
                Intent i = new Intent (BloodProfile.this, FinalDetails.class);
                i.putExtra("cholestrol",cholestrol);
                Details.cholestrol = cholestrol;
                i.putExtra("glucose",glucose);
                Details.glucose = glucose;
                startActivity(i);
            }
        });

    }
}