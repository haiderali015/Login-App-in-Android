package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    EditText username,password,cnfrmpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         username =  findViewById(R.id.username);
         password =  findViewById(R.id.password);
         cnfrmpass = findViewById(R.id.cnfrmpass);
        DBHelper Db= new DBHelper(this);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        Button register = (Button) findViewById(R.id.register);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("haider") && password.getText().toString().equals("ali"))
                {
                    //correct
                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //incorrect
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=username.getText().toString();
                String pass=password.getText().toString();
                String repass=cnfrmpass.getText().toString();

                if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                {
                    Toast.makeText(MainActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }
                else
                {

                }

            }
        });



    }
}