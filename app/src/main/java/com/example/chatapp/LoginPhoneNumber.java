package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class LoginPhoneNumber extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText phoneNo;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_number);

        countryCodePicker = findViewById(R.id.county_code);
        phoneNo = findViewById(R.id.mobile_number);
        button = findViewById(R.id.send_opt_btn);
        progressBar = findViewById(R.id.mobile_number_loader);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneNo);

        button.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()){
                phoneNo.setError("phone number not valid");
                return;
            }

            Intent intent = new Intent(LoginPhoneNumber.this, OTPActivity.class);
            intent.putExtra("phone", countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });

    }
}