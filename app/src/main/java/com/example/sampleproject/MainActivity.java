package com.example.sampleproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText userName,password;
    private MaterialButton loginBtn,regBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        loginBtn=findViewById(R.id.loginBtn);
        regBtn=findViewById(R.id.regBtn);
        regBtn.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
        loginBtn.setOnClickListener(view -> {
            try {
                Cursor c=DataBaseHelper.database.rawQuery("SELECT * FROM STUDENT WHERE Student_Password='"+password.getText()+"'", null);
                if (c.moveToFirst()){
                    Intent intent=new Intent(getApplicationContext(),DetailsActivity.class);
                    intent.putExtra("password",password.getText());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter the correct user name and password",Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception error){
                Toast.makeText(getApplicationContext(),"Please enter the correct user name and password",Toast.LENGTH_LONG).show();
            }
        });
        FirebaseApp.initializeApp(getBaseContext());
    }
}