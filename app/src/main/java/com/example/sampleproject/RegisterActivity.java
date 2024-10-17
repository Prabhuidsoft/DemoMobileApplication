package com.example.sampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText fName,lName,departmentEdit,password;
    private DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fName=findViewById(R.id.fName);
        lName=findViewById(R.id.lName);
        departmentEdit=findViewById(R.id.departmentEdit);
        password=findViewById(R.id.password);
        MaterialButton submitBtn = findViewById(R.id.submitBtn);
        dataBaseHelper = new DataBaseHelper(this);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        return;
                    }
                    // Get new FCM registration token
                    String token = task.getResult();
                });
        submitBtn.setOnClickListener(view -> {
            int id = 100 + (int) (Math.random()*899);
            String sql = "INSERT INTO STUDENT (Student_Id,Student_Fname, Student_Lname, Student_Password,Student_Dep) VALUES('"+ id +"','"+fName.getText()+"','"+lName.getText()+"','"+password.getText()+"','"+departmentEdit.getText()+"')" ;
            DataBaseHelper.database.execSQL(sql);
            Toast.makeText(getApplicationContext(),"Student added successfully",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
    }
}