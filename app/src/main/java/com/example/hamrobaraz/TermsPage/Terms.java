package com.example.hamrobaraz.TermsPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hamrobaraz.R;

public class Terms extends AppCompatActivity {
    WebView wvterms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        wvterms = findViewById(R.id.wvterms);

        wvterms.getSettings().setJavaScriptEnabled(true);
        wvterms.getSettings().setAppCacheEnabled(true);
        wvterms.setWebViewClient(new WebViewClient());
        wvterms.loadUrl("https://hamrobazaar.com/safetytips.php");



    }
}
