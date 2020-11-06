package com.example.CodeIt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, email, password, repassword;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.EmailAddress);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.regbutton);
        signin = (Button) findViewById(R.id.loginbutton);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(user.equals("")||mail.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(MainActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(!mail.trim().matches(emailPattern)){
                    Toast.makeText(MainActivity.this,"Please enter valid email", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals((repass))){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(MainActivity.this, "Registeration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User already exists!  Please Login",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Password does not match",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}