package com.alitech.all;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Browsing extends AppCompatActivity {
    Button back_button;
    Button next_button;
    Button home_button;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsing);
        back_button = (Button) findViewById(R.id.back_button);
        next_button = (Button) findViewById(R.id.next_button);
        home_button = (Button) findViewById(R.id.home_button);
        webView = (WebView) findViewById(R.id.webview);
        String url = "https://www.google.com";
        webView.loadUrl(url);
        webView.setWebViewClient(new myBrowser());
//---------------Enable Javascript--------------------------------//
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Browsing.this, "Back", Toast.LENGTH_SHORT).show();
                webView.goBack();
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Browsing.this, "Next",
                        Toast.LENGTH_SHORT).show();
                webView.goForward();
            }
        });
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Browsing.this, "Home",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private class myBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String request) {
            view.loadUrl(request);
            return true;
        }
    }
}
