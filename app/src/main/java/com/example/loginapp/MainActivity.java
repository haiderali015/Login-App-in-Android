package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
         DBHelper Db= new DBHelper(this);
         Button makeacc=(Button) findViewById(R.id.makeacc);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=username.getText().toString();
                String pass=password.getText().toString();
                if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass))
                {
                    Toast.makeText(MainActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkunamepass =Db.checkUsernamePassword(uname,pass);
                    if(checkunamepass==true)
                    {
                        Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        makeacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),signup.class);
                startActivity(intent);
            }
        });






    }
}