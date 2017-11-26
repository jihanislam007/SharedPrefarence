package com.example.jihan.sharedprefarence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ForgotPasswordActivity extends AppCompatActivity {

    TextView UserNameTextView,
            PasswordTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        UserNameTextView = findViewById(R.id.UserNameTextView);
        PasswordTextView = findViewById(R.id.PasswordTextView);

        SharedPreferences preferences = getSharedPreferences("ju_pmit", Context.MODE_PRIVATE);

        String name = preferences.getString("user_name","There is no data");;
        String password = preferences.getString("password","There is No data");

        UserNameTextView.setText(name);
        PasswordTextView.setText(password);

    }
}
