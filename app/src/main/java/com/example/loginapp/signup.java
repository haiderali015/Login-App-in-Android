package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText username,password,cnfrmpass;
    Button signup;
    DBHelper Db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        cnfrmpass = findViewById(R.id.cnfrmpass1);
        Button alreadyacc=(Button) findViewById(R.id.alreadyacc);


        Db = new DBHelper(this);
        signup=findViewById(R.id.register);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=username.getText().toString();
                String pass=password.getText().toString();
                String repass=cnfrmpass.getText().toString();

                if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                {
                    Toast.makeText(signup.this,"All fields are required",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean usernameCheck = Db.checkUsername(uname);
                        if(usernameCheck==false)
                        {
                            Boolean insert = Db.insertData(uname,pass);
                            if(insert==true)
                            {
                                Toast.makeText(signup.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(signup.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(signup.this,"User already exists",Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(signup.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        alreadyacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}