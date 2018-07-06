package com.hudutech.nazarenelostfoundapp;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

public class PostItemActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int IMAGE_PICK = 1;
    private static final int PLACE_PICKER_REQUEST = 100;
    private TextView tvChooseImage;
    private TextInputEditText txtItemName;
    private TextInputEditText txtItemDesc;
    private TextView tvPickLocation;
    private TextInputEditText txtLocationDesc;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);
        getSupportActionBar().setTitle("Post Lost Item");
        tvChooseImage = findViewById(R.id.tv_choose_image);
        txtItemName = findViewById(R.id.txt_item_name);
        txtItemDesc = findViewById(R.id.txt_item_desc);
        tvPickLocation = findViewById(R.id.tv_pick_location);
        txtItemDesc = findViewById(R.id.txt_item_desc);
        txtLocationDesc = findViewById(R.id.txt_location_desc);
        mProgress = new ProgressDialog(this);

        Button mButtonSubmit = findViewById(R.id.btn_submit_lost_item);

        mButtonSubmit.setOnClickListener(this);
        tvChooseImage.setOnClickListener(this);
        tvPickLocation.setOnClickListener(this);
        watchInputs();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICK && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Image Picked", Toast.LENGTH_SHORT).show();
        }

        if (requestCode == PLACE_PICKER_REQUEST && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Location selected", Toast.LENGTH_SHORT).show();
            if (mProgress.isShowing()) mProgress.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.btn_submit_lost_item:
                if (validateInputs()) {
                    startActivity(new Intent(PostItemActivity.this, MainActivity.class));
                }else{
                    Snackbar.make(v, "Fix the errors above", Snackbar.LENGTH_LONG).show();
                }

                break;
            case R.id.tv_choose_image:
                chooseImage();
                break;
            case R.id.tv_pick_location:
                pickLocation();
                break;
        }
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select a photo"), IMAGE_PICK);
    }

    private void pickLocation() {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {

            mProgress.setMessage("Detecting please wait...");
            mProgress.show();

            startActivityForResult(builder.build(PostItemActivity.this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
            if (mProgress.isShowing()) mProgress.dismiss();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
            if (mProgress.isShowing()) mProgress.dismiss();
        }
    }

    private boolean validateInputs() {
        boolean valid = true;
        if (TextUtils.isEmpty(txtItemName.getText().toString().trim())) {
            txtItemName.setError("Required");
            valid = false;
        }else {
            txtItemName.setError(null);
        }

        if (TextUtils.isEmpty(txtItemDesc.getText().toString().trim())) {
            txtItemDesc.setError("Required");
            valid = false;
        }else {
            txtItemDesc.setError(null);
        }

        if (TextUtils.isEmpty(txtLocationDesc.getText().toString().trim())) {
            txtLocationDesc.setError("Required");
            valid = false;
        }else {
            txtLocationDesc.setError(null);
        }

        return valid;
    }

    private void watchInputs() {
        txtItemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txtItemName.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtItemName.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                txtItemName.setError(null);

            }
        });


        txtItemDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txtItemDesc.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtItemDesc.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                txtItemDesc.setError(null);

            }
        });

        txtLocationDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txtLocationDesc.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtLocationDesc.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {
                txtLocationDesc.setError(null);

            }
        });

    }

}
