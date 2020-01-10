package com.example.hamrobaraz.TermsPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hamrobaraz.R;

public class AdActivity extends AppCompatActivity {
WebView wvad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        wvad = findViewById(R.id.wvad);

        wvad.getSettings().setJavaScriptEnabled(true);
        wvad.getSettings().setAppCacheEnabled(true);
        wvad.setWebViewClient(new WebViewClient());
        wvad.loadUrl("https://hamrobazaar.com/safetytips.php");

    }
}
