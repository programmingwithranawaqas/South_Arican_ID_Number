package com.example.sain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText etId;
    Button btnSubmit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        init();

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etId.setText("");
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String id = etId.getText().toString().trim();

                if(id.length()==13)
                {
                    String dob = id.substring(0, 6);
                    String year = "19"+dob.substring(0,2);

                    String []months = {"January","February", "March", "April",
                        "May","June","July","August","September", "October","November", "December"};
                    int m = Integer.parseInt(dob.substring(2,4));
                    String month = months[m-1];
                    String day = dob.substring(4,6);
                    String gender;
                    String citizenShip;
                    String validity;


                    if( Integer.parseInt(id.substring(6,10)) < 5000)
                    {
                        gender = "Female";
                    }
                    else
                    {
                        gender = "Male";
                    }


                    char ch = id.charAt(10);
                    switch (ch)
                    {
                        case '0':
                        {
                            citizenShip = "SA Citizen";
                            break;
                        }
                        case '1':
                        {
                            citizenShip = "Permanent Resident";
                            break;
                        }
                        default:{
                            citizenShip = "Invalid";
                        }
                    }

                    tvResult.setText(day+" "+month+" "+year+"\n"+gender+"\n"+citizenShip);

                    if(Integer.parseInt(String.valueOf(id.charAt(12)))==0)
                    {
                        validity = "Invalid";
                    }
                    else
                    {
                        validity = "Valid";
                    }

                   tvResult.setText(tvResult.getText()+"\n"+validity);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid id", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void init()
    {
        tvResult = findViewById(R.id.tvResult);
        etId = findViewById(R.id.etId);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
    }
}