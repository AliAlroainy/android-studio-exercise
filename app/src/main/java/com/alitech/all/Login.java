package com.alitech.all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Login , Pass;
    Button LoginButton , RegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = findViewById(R.id.LoginName);
        Pass = findViewById(R.id.LoginPassword);
        LoginButton = findViewById(R.id.LogB);
        RegisterButton = findViewById(R.id.RegB);

        DataBase db = new DataBase(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, Table.class);
                startActivity(intent);
                /*
                if (Login.getText().toString().isEmpty() && Pass.getText().toString().isEmpty())
                {
                    Toast.makeText( Login.this, "Please Enter Data", Toast.LENGTH_SHORT).show();
                } else {

                    String result = db.searchtData(Login.getText().toString(), Pass.getText().toString());

                    if (result.isEmpty()) {
                        Toast.makeText( Login.this, "this user not here", Toast.LENGTH_SHORT).show();
                    } else {

                    }

                }

            }*/
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

    }
}