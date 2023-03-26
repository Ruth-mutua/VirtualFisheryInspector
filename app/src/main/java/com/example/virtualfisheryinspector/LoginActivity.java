package com.example.virtualfisheryinspector;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    DBHelper DB;


       @SuppressLint("MissingInflatedId")
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

           username=(EditText) findViewById(R.id.inputUsername);
           password=(EditText) findViewById(R.id.inputUserPassword);
           login=(Button)findViewById(R.id.btn_login);
           DB= new DBHelper(this);

           login.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   String user= username.getText().toString();
                   String pass= password.getText().toString();

                   if (user.equals("")||pass.equals(""))
                       Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                   else {
                       Boolean checkuserpass= DB.checkusernamepassword( user, pass);
                       if (checkuserpass==true){
                           Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                           Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
                           startActivity(intent);
                       }else{
                           Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                       }

                   }

               }
           });


           TextView btn= findViewById(R.id.textViewSignup);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }

        });
    }
}