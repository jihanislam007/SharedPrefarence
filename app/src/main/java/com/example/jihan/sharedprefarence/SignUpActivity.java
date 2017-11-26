package com.example.jihan.sharedprefarence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText UserNameEditText,
            PasswordEditText;

    Button DoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        UserNameEditText = findViewById(R.id.UserNameEditText);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        DoneTextView = findViewById(R.id.DoneTextView);

        DoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////////////////////sharedPrefarences data save///////////////////////

                SharedPreferences preferences = getSharedPreferences("ju_pmit", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = preferences.edit();

                String username = UserNameEditText.getText().toString();
                String pass = PasswordEditText.getText().toString();

                editor.putString("user_name", username);
                editor.putString("password", pass);

                editor.apply();

                Toast.makeText(SignUpActivity.this , "You are successfully registered", Toast.LENGTH_LONG).show();

            }
        });
    }
}
