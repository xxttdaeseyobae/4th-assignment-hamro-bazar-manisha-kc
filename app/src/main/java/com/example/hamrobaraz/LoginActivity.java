package com.example.hamrobaraz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText etemail, etpassword;
Button btnlogin,btnforgot,btnregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnforgot = findViewById(R.id.btnforgot);
        btnregister = findViewById(R.id.btnregister);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etemail.getText().toString(),
                        password = etpassword.getText().toString();
                if (validate()) {
                    if ((etemail.equals("softwarica@gmail.com") && (password.equals("coventry")))) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

        private boolean validate() {
            if (TextUtils.isEmpty(etemail.getText())) {
                etemail.setError("Enter Email");
                etemail.requestFocus();
                return false;
            } else if (TextUtils.isEmpty(etpassword.getText())) {
                etpassword.setError("Enter password");
                etpassword.requestFocus();
                return false;
            }
            return true;
        }}












