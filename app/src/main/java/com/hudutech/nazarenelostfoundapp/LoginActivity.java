package com.hudutech.nazarenelostfoundapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText mUsername;
    private TextInputEditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login Here");

        //INITIALIZE INPUT VARIABLES
        mUsername = findViewById(R.id.txt_username);
        mPassword = findViewById(R.id.txt_password);

        //INTIALIZE LOGIN BUTTON
        Button mButtonLogin = findViewById(R.id.btn_login);
        mButtonLogin.setOnClickListener(this);

        TextView tvRegister = findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(this);

    }

    private void doLogin(String username, String password) {
        if (TextUtils.equals(username, "admin") && TextUtils.equals(password, "admin")) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        } else {
            Toast.makeText(LoginActivity.this, "Invalid Username/password", Toast.LENGTH_LONG).show();
        }
    }

    //[VALIDATE INPUTS TO MAKE SURE ALL REQUIRED FIELD ARE NOT BLANK]
    private boolean validateInputs() {
        boolean valid = true;
        if (TextUtils.isEmpty(mUsername.getText().toString().trim())) {
            mUsername.setError("Required");
            valid = false;
        } else {
            mUsername.setError(null);
        }

        if (TextUtils.isEmpty(mPassword.getText().toString().trim())) {
            mPassword.setError("Required");
            valid = false;
        } else {
            mPassword.setError(null);
        }
        return valid;
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.btn_login:
                if (validateInputs()) {
                    doLogin(mUsername.getText().toString().trim(), mPassword.getText().toString().trim());
                } else {
                    Snackbar.make(v, "Please fix error above to continue", Snackbar.LENGTH_LONG).show();
                }
                break;

            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

        }
    }
}
