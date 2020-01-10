package com.example.hamrobaraz.TermsPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hamrobaraz.R;

public class Safety extends AppCompatActivity {
WebView wvsafety;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);

        wvsafety = findViewById(R.id.wvsafety);

        wvsafety.getSettings().setJavaScriptEnabled(true);
        wvsafety.getSettings().setAppCacheEnabled(true);
        wvsafety.setWebViewClient(new WebViewClient());
        wvsafety.loadUrl("https://hamrobazaar.com/safetytips.php");

    }
}
