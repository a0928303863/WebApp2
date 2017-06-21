package com.example.cjcu.webapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView mWebView=null;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mWebView.loadUrl("http://10.0.2.2/whatapp");
                    return true;
                case R.id.navigation_dashboard:
                    mWebView.loadUrl("http://10.0.2.2/whatapp/index.php/2017-06-21-02-08-58");
                    return true;
                case R.id.navigation_notifications:
                    mWebView.loadUrl("http://10.0.2.2/whatapp/index.php/2017-06-21-02-11-38");
                    return true;
            }
            return false;
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //抓到id為webview的物件
        mWebView = (WebView)findViewById(R.id.webview);
        //設定網頁內容
        mWebView.setWebViewClient(mWebViewClient);
        //開啟JS功能，讓網頁中的JS可以執行
        mWebView.getSettings().setJavaScriptEnabled(true);
        //導頁到google的網頁
        mWebView.loadUrl("http://10.0.2.2/whatWeb/index.html");


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //
    WebViewClient mWebViewClient = new WebViewClient(){
        @Override
      public boolean shouldOverrideUrlLoading(WebView view,String url) {
          view.loadUrl(url);
          return true;
      }
    };

}
