package com.example.sampleproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class DetailsActivity extends AppCompatActivity {
    private TextInputEditText fName,lName,departmentEdit,password;
    private DataBaseHelper dataBaseHelper;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fName=findViewById(R.id.fName);
        lName=findViewById(R.id.lName);
        departmentEdit=findViewById(R.id.departmentEdit);
        password=findViewById(R.id.password);
        MaterialButton submitBtn = findViewById(R.id.submitBtn);
        Cursor c=DataBaseHelper.database.rawQuery("SELECT * FROM STUDENT WHERE Student_Password='"+getIntent().getStringExtra("password")+"'", null);
        c.moveToFirst();
        fName.setText(c.getString(c.getColumnIndex("Student_Fname")));
        lName.setText(c.getString(c.getColumnIndex("Student_Lname")));
        departmentEdit.setText(c.getString(c.getColumnIndex("Student_Dep")));
        password.setText(c.getString(c.getColumnIndex("Student_Password")));
        submitBtn.setText("Logout");
        submitBtn.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
    }
}