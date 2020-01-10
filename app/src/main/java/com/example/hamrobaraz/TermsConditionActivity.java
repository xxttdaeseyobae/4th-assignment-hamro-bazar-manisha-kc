package com.example.hamrobaraz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.hamrobaraz.TermsPage.AdActivity;
import com.example.hamrobaraz.TermsPage.Safety;
import com.example.hamrobaraz.TermsPage.Terms;

public class TermsConditionActivity extends AppCompatActivity {
CheckBox chkTerms,chkSafety,chkAd;
Button btnread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
        chkTerms= findViewById(R.id.chkTerms);
        chkSafety = findViewById(R.id.chkSafety);
        chkAd= findViewById(R.id.chkAd);
        btnread= findViewById(R.id.btnread);

        chkTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TermsConditionActivity.this, Terms.class));
            }
        });

        chkSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TermsConditionActivity.this, Safety.class));
            }
        });

        chkAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TermsConditionActivity.this, AdActivity.class));
            }
        });
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (chkAd.isChecked()&& chkSafety.isChecked() && chkTerms.isChecked()) {
                    startActivity(new Intent(TermsConditionActivity.this, DashboardActivity.class));
                }
                else {
                    Toast.makeText(TermsConditionActivity.this,"Check all the boxes",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
