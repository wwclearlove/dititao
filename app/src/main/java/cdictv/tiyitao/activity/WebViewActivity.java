package cdictv.tiyitao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import cdictv.tiyitao.R;

public class WebViewActivity extends AppCompatActivity  {

    private ImageView left_menu;
    private TextView title;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
//        webview.getSettings().setDomStorageEnabled(true);
        webview.loadUrl(getIntent().getStringExtra("uri"));
        title.setText(getIntent().getStringExtra("title"));

    }

}
