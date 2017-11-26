package com.example.jihan.sharedprefarence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    EditText UserNameEditText,
            PasswordEditText;

    TextView SignInTextView,
            SignUpTextView,
            ForgotPassTextView;
    String user_name = "";
    String  user_pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        UserNameEditText  = findViewById(R.id.UserNameEditText);
        PasswordEditText  = findViewById(R.id.PasswordEditText);
        SignInTextView  = findViewById(R.id.SignInTextView);
        SignUpTextView  = findViewById(R.id.SignUpTextView);
        ForgotPassTextView  = findViewById(R.id.ForgotPassTextView);

        SignInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////////////Start Retrieve data from shared preferences //////////////
                user_name = UserNameEditText.getText().toString();
                user_pass = PasswordEditText.getText().toString();


                SharedPreferences preferences = getSharedPreferences("ju_pmit", Context.MODE_PRIVATE);

                String username_data = preferences.getString("user_name","There is no data");
                String userpass_data = preferences.getString("password","There is No data");

                 /////////////finish Retrieve data from shared preferences //////////////

               if(user_name.equals(username_data)  && user_pass.equals(userpass_data)){
                    Intent in = new Intent(LogInActivity.this , HomeActivity.class);
                    startActivity(in);
                    Toast.makeText(LogInActivity.this , "User Name :"+username_data+"\n"+"Password :"+userpass_data , Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LogInActivity.this , "Your User name or Password is Invalid, Please SignUp or Try Again later" , Toast.LENGTH_LONG).show();
                }
            }
        });

        SignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LogInActivity.this , SignUpActivity.class);
                startActivity(in);
            }
        });

        ForgotPassTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LogInActivity.this , ForgotPasswordActivity.class);
                startActivity(in);
            }
        });

    }

}