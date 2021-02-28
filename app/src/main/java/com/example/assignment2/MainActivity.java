package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView= findViewById(R.id.mywebview);
        progressBar= findViewById(R.id.progressBar);
        //webView.loadUrl("https://nulms.namal.edu.pk/");
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //Toast.makeText(MainActivity.this, "Loading", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }



        });

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }
        });

        Intent intent=getIntent();

        if(intent!=null)
        {
           String URL= intent.getData().toString();
           webView.loadUrl(URL);
        }

    }

    @Override
    public void onBackPressed() {



       // if(webView.goBack();)
        //{
         //   webView.goBack();
        //}
        //else
        //{
          //  super.onBackPressed();
        //}
    }
}