package io.com.healthdiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class Result extends AppCompatActivity {
   String url = "https://health-diag.herokuapp.com/predict";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView t = findViewById(R.id.result);
        String gender = getIntent().getStringExtra("gender");
        //Toast.makeText(Result.this, gender, Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()

        {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String data = jsonObject.getString("disease");
                    String diseases = "";
                    String ans = data.substring(2,3);
                    int count = 1;
                    if(ans.equals("1")){ diseases+= ""+count+ ".Cardiovascular Diseases(CVD\'s)";
                    count++;}
                    Log.e("disease1",ans);
                    Log.e("disease2",data.substring(5,6));
                    if(data.substring(5,6).equals("1")){
                        diseases+= "\n"+count+ ".Diabetes";
                        count++;
                    }
                    if(data.substring(8,9).equals("1")){
                        diseases += "\n"+count+ ".Hypertension";
                        count++;
                    }
                    if(data.substring(11,12).equals("1")) {
                        diseases += "\n"+count+ ".Stroke";
                    }

                   // Log.e("disease1",data);
                    t.setText(diseases);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Result.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String,String>();
                params.put("age_in_years",Details.age);
                params.put("gender",Details.gender);
                params.put("height",Details.height);
                params.put("weight", Details.weight);
                params.put("BMI",Details.bmi);
                params.put("ap_lo", Details.aplo);
                params.put("ap_hi", Details.aphi);
                params.put("MAP", "91");
                params.put("Heart_Rate",Details.HeartRate);
                params.put("Max_Heart_Rate","90");
                params.put("glu",Details.glucose);
                params.put("cholestrol",Details.cholestrol);
                params.put("smoke",Details.smoke);
                params.put("alco",Details.alcohol);
                params.put("active",Details.activity);

                /*Log.e("age", getIntent().getStringExtra("age"));
                Log.e("age_in_years",getIntent().getStringExtra("age"));
                Log.e("gender",getIntent().getStringExtra("gender"));
                Log.e("height",getIntent().getStringExtra("height"));
                Log.e("weight",getIntent().getStringExtra("weight"));
                Log.e("BMI",getIntent().getStringExtra("bmi"));
                Log.e("ap_lo",getIntent().getStringExtra("sys"));
                Log.e("ap_hi",getIntent().getStringExtra("diasys"));
                Log.e("Heart_Rate",getIntent().getStringExtra("heartRate"));
                Log.e("Max_Heart_Rate","90");
                Log.e("glu",getIntent().getStringExtra("glucose"));
                Log.e("cholestrol",getIntent().getStringExtra("cholestrol"));
                Log.e("smoke",getIntent().getStringExtra("smoke"));
                Log.e("alco",getIntent().getStringExtra("alcohol"));
                Log.e("active",getIntent().getStringExtra("activity"));*/

                return params;
            }

        };
        RequestQueue queue = Volley.newRequestQueue(Result.this);
        queue.add(stringRequest);
    }
}