package org.subiny92.androidstudyexam.SampleWebView;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class WebViewActivity extends AppCompatActivity {

    private EditText et_url;
    private WebView webView;
    private Button btn_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        et_url = (EditText) findViewById(R.id.et_url);
        webView = (WebView) findViewById(R.id.webView);

        btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = et_url.getText().toString();

                if (!url.startsWith("http")) {
                    Toast.makeText(WebViewActivity.this, "해당 URL을 찾을 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    webView.loadUrl(et_url.getText().toString());
                }
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/www/sample.html");
        final Handler handler = new Handler();
        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void clickedChangeImage() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        btn_open.setText("클릭 후 열기");
                        webView.loadUrl("javascript:changeImage()");
                    }
                });
            }
        }, "sample");
    }
}
