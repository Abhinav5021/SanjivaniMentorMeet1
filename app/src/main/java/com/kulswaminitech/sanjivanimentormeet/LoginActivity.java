package com.kulswaminitech.sanjivanimentormeet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    //    public MyDBHelper DB;
    public EditText username;
    public TextInputEditText password;
    public Button loginbtn;
    public String SelectedUser;
    public String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
//        DB = new MyDBHelper(this);

//        Getting USER from selectUserActivity
        SelectedUser = getIntent().getExtras().getString("UserStatus");
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = username.getText().toString().trim();
                pass = password.getText().toString().trim();
                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "All fields Required..!", Toast.LENGTH_SHORT).show();
                } else {
//                    new CheckLoginTask().execute(user, pass);
                    if (user.equals("2100340265") && pass.equals("Skbp@145")) {
                        Toast.makeText(LoginActivity.this, "Login Successful as "+SelectedUser.toUpperCase(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Bundle args = new Bundle();
                        args.putString("User",SelectedUser);
                        args.putString("Enrollment",user);
                        intent.putExtras(args);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials..!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private class CheckLoginTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String user = params[0];
            String pass = params[1];
            return DatabaseOperations.checkLogin(user, pass);
        }

        @Override
        protected void onPostExecute(Boolean isValidLogin) {
            if (isValidLogin) {
                Toast.makeText(LoginActivity.this, "Login Successful as " + SelectedUser.toUpperCase(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Bundle args = new Bundle();
                args.putString("User", SelectedUser);
                args.putString("Enrollment", user);
                intent.putExtras(args);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid Credentials..!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

//if (user.isEmpty() || pass.isEmpty()) {
//        Toast.makeText(LoginActivity.this, "All fields Required..!", Toast.LENGTH_SHORT).show();
//        } else {
//        String userFromDB = "";
//        String passwordFromDB = "";
//        try {
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM LOGIN WHERE USERNAME=" +" and PASSWORD="+pass);
//        while(rs.next()) {
//        userFromDB = rs.getString(1); //username
//        passwordFromDB = rs.getString(2); //password
//        }
//        conn.close();
//        }catch (Exception e){
//        Toast.makeText(LoginActivity.this, e.toString(),Toast.LENGTH_SHORT).show();
//        }
//                    if(user.equals(userFromDB) && pass.equals(passwordFromDB)){
//                        Toast.makeText(LoginActivity.this, "Login Successful as "+SelectedUser.toUpperCase(), Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        Bundle args = new Bundle();
//                        args.putString("User",SelectedUser);
//                        args.putString("Enrollment",user);
//                        intent.putExtras(args);
//                        startActivity(intent);
//                            finish();
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Invalid Credentials..!", Toast.LENGTH_SHORT).show();
//                    }


//        }