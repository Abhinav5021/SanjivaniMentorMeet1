package com.kulswaminitech.sanjivanimentormeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectUserActivity extends AppCompatActivity {
    Button mentorIncharge,mentor,student;
//    SelectUserActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        mentorIncharge = findViewById(R.id.mentorInchargeBtn);
        mentor = findViewById(R.id.mentorBtn);
        student = findViewById(R.id.studentBtn);

        mentorIncharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "Mentor Incharge ";
                Intent intent = new Intent(SelectUserActivity.this,LoginActivity.class);
                Bundle args = new Bundle();
                args.putString("UserStatus",user);
                intent.putExtras(args);
//                intent.putExtra("UserStatus",user);
                startActivity(intent);
                Toast.makeText(SelectUserActivity.this,"Enter Login Credentials of : "+user,Toast.LENGTH_SHORT).show();

//                Activity activity = new SelectUserActivity();
//                Bundle args = new Bundle();
//                args.putString("user","MentorIncharge");
//                activity.setArguments(args);
            }
        });

        mentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "Mentor ";
                Intent intent = new Intent(SelectUserActivity.this,LoginActivity.class);
                Bundle args = new Bundle();
                args.putString("UserStatus",user);
                intent.putExtras(args);
//                intent.putExtra("UserStatus",user);
                startActivity(intent);
                Toast.makeText(SelectUserActivity.this,"Enter Login Credentials of : "+user,Toast.LENGTH_SHORT).show();
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "Student ";
                Intent intent = new Intent(SelectUserActivity.this,LoginActivity.class);
//                intent.putExtra("UserStatus",user);
                Bundle args = new Bundle();
                args.putString("UserStatus",user);
                intent.putExtras(args);
                startActivity(intent);
                Toast.makeText(SelectUserActivity.this,"Enter Login Credentials of : "+user,Toast.LENGTH_SHORT).show();
            }
        });

    }
}