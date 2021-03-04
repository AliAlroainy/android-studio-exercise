package com.alitech.all;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText FirstName, LastName, PassWord;
    Button Clear, Register;

    DataBase db = new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        PassWord = findViewById(R.id.PassWordRegister);

        Clear = findViewById(R.id.ClearReg);
        Register = findViewById(R.id.RegisterButton);

        Register.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (FirstName.getText().toString().isEmpty() &&
                                                    LastName.getText().toString().isEmpty() &&
                                                    PassWord.getText().toString().isEmpty()) {
                                                Toast.makeText(Register.this, "Please Enter Data",
                                                        Toast.LENGTH_SHORT).show();
                                            } else {


                                                long result = db.insertData(FirstName.getText().toString(),
                                                        LastName.getText().toString(), PassWord.getText().toString());
                                                if (result != -1) {
                                                    Toast.makeText(Register.this, "Add Successfully",
                                                            Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(Register.this, "Error Happened!!!",
                                                            Toast.LENGTH_SHORT).show();
                                                }


                                            }
                                        }
                                    }
        );


       Clear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirstName.clearComposingText();
               LastName.clearComposingText();
               PassWord.clearComposingText();

           }
       });


    }
}