package com.kulswaminitech.sanjivanimentormeet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperations {
    public static boolean checkLogin(String user, String pass) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            String usernameColumn = "USERNAME";
            String passwordColumn = "PASSWORD";
            String sqlQuery = "SELECT * FROM LOGIN WHERE " + usernameColumn + "= ? AND" + passwordColumn + "=?";
//
            try (PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);
//
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    return rs.next();
                }
            } finally {
                conn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM LOGIN WHERE USERNAME=" +" and PASSWORD="+pass);
//                while(rs.next()) {
//                    userFromDB = rs.getString(1); //username
//                    passwordFromDB = rs.getString(2); //password
//                }
//                conn.close();
//            }
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


