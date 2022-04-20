package io.com.healthdiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PatientDetail extends AppCompatActivity{
    String gender = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);
        Spinner s = findViewById(R.id.spinner);
        List<String> categories = new ArrayList<>();
        categories.add("Male");
        categories.add("Female");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,categories);
        //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = categories.get(position);
                if(gender == "Male") gender = "0";
                else gender = "1";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        EditText edtName = findViewById(R.id.edtName);
        EditText edtAge = findViewById(R.id.edtAge);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String age = edtAge.getText().toString();
                Intent i = new Intent (PatientDetail.this,Physic.class);

                i.putExtra("name",name);
                i.putExtra("age",age);
                Details.age = age;
                Details.gender = gender;
                startActivity(i);
            }
        });

    }
}
