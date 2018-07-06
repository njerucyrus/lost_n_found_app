package com.hudutech.nazarenelostfoundapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText mFullname;
    private TextInputEditText mEmail;
    private TextInputEditText mPhoneNumber;
    private TextInputEditText mPassword;
    private TextInputEditText mConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Create Account");
        Button mButtonRegister = findViewById(R.id.btn_register);

        mFullname = findViewById(R.id.txt_fullname);
        mEmail = findViewById(R.id.txt_email);
        mPhoneNumber = findViewById(R.id.txt_phonenumber);
        mPassword = findViewById(R.id.txt_reg_password);
        mConfirmPassword = findViewById(R.id.txt_reg_confirm_password);


        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                } else {
                    Snackbar.make(v, "Fix the errors above to continue", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        watchInputs();
    }

    private boolean validateInputs() {
        boolean valid = false;
        if (TextUtils.isEmpty(mFullname.getText().toString().trim())) {
            mFullname.setError("Required");
            valid = false;
        } else {
            mFullname.setError(null);
        }

        if (TextUtils.isEmpty(mEmail.getText().toString().trim())) {
            mEmail.setError("Required");
            valid = false;
        } else {
            mEmail.setError(null);
        }

        if (TextUtils.isEmpty(mPhoneNumber.getText().toString().trim())) {
            mPhoneNumber.setError("Required");
            valid = false;
        } else {
            mPhoneNumber.setError(null);
        }

        if (TextUtils.isEmpty(mPassword.getText().toString().trim())) {
            mPassword.setError("Required");
            valid = false;
        } else {
            mPassword.setError(null);
        }

        if (TextUtils.isEmpty(mConfirmPassword.getText().toString().trim())) {
            mConfirmPassword.setError("Required");
            valid = false;
        } else {
            mConfirmPassword.setError(null);
        }
        return valid;
    }


    private void watchInputs() {
        mFullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mFullname.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFullname.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                mFullname.setError(null);

            }
        });


        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mEmail.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEmail.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                mEmail.setError(null);

            }
        });

        mPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mPhoneNumber.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPhoneNumber.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPhoneNumber.setError(null);

            }
        });


        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mPassword.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPassword.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPassword.setError(null);

            }
        });


        mConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mConfirmPassword.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mConfirmPassword.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                mConfirmPassword.setError(null);

            }
        });
    }
}
