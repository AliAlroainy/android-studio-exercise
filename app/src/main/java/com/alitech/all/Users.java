package com.alitech.all;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Users extends AppCompatActivity {
    EditText fullName, userName, password, newfullname,
            newusername;
    TextView txtshowdata;
    DataBase db = new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        fullName = (EditText) findViewById(R.id.FullName);
        userName = (EditText) findViewById(R.id.UserName);
        password = (EditText) findViewById(R.id.Password);
        newfullname = (EditText) findViewById(R.id.newfullname);
        newusername = (EditText) findViewById(R.id.newusername);
        txtshowdata = (TextView) findViewById(R.id.txtshowdata);
    }

    public void insert(View view) {
        if (fullName.getText().toString().isEmpty() &&
                userName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Data",
                    Toast.LENGTH_SHORT).show();
        } else {
            long result = db.insertData(fullName.getText().toString(),
                    userName.getText().toString(), password.getText().toString());
            if (result != -1) {
                Toast.makeText(this, "Add Successfully",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error Happened!!!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void select(View view) {
        String result = db.selectData();
        if (result.isEmpty()) {
            txtshowdata.setText("There is not any user to show");
        } else {
            txtshowdata.setText(result);
        }
    }

    public void delete(View view) {
        if (fullName.getText().toString().isEmpty() &&
                userName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Data", Toast.LENGTH_SHORT).show();
        } else {
            long result = db.deleteData(fullName.getText().toString(),
                    userName.getText().toString());
            if (result != -1) {
                Toast.makeText(this, result + " Record Deleted",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error Happened!!!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void search(View view) {
        if (fullName.getText().toString().isEmpty() &&
                userName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Data",
                    Toast.LENGTH_SHORT).show();
        } else {
            String result =
                    db.searchtData(fullName.getText().toString(),
                            userName.getText().toString());
            if (result.isEmpty()) {
                txtshowdata.setText("There is not any user to show");
            } else {
                txtshowdata.setText(result);
            }
        }
    }

    public void update(View view) {
        newfullname.setVisibility(View.VISIBLE);
        newusername.setVisibility(View.VISIBLE);
        if (fullName.getText().toString().isEmpty() &&
                userName.getText().toString().isEmpty() && newfullname.getText().toString().isEmpty()
                && newusername.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Fill The New Data", Toast.LENGTH_SHORT).show();
        } else {
            int result = db.updateData(fullName.getText().toString(),
                    userName.getText().toString(), newfullname.getText().toString(),
                    newusername.getText().toString());
            if (result != 0) {
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                newfullname.setVisibility(View.GONE);
                newusername.setVisibility(View.GONE);
            } else {
                Toast.makeText(this, "Error Has Been Accure!!!",
                        Toast.LENGTH_SHORT).show();
                newfullname.setVisibility(View.GONE);
                newusername.setVisibility(View.GONE);
            }
        }
    }
}