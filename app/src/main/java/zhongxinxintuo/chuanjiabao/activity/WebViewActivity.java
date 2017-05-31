package zhongxinxintuo.chuanjiabao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import zhongxinxintuo.chuanjiabao.R;

import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;

public class WebViewActivity extends AppCompatActivity {


    @InjectView(R.id.iv_login_back)
    ImageView ivLoginBack;
    @InjectView(R.id.tv_login_title)
    TextView tvLoginTitle;
    @InjectView(R.id.wv_webview)
    WebView wvWebview;
    @InjectView(R.id.pb_webview)
    ProgressBar pbWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.inject(this);
        tvLoginTitle.setText("广告");
        String url = getIntent().getStringExtra("url");
        //加载H5
        wvWebview.loadUrl(url);
        //获取settings
        WebSettings settings = wvWebview.getSettings();
        //1.支持与js交互
        settings.setJavaScriptEnabled(true);
        //2.支持缩放按钮
        settings.setBuiltInZoomControls(true);
        //3.支持双击单击
        settings.setUseWideViewPort(true);

        wvWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //隐藏ProgressBar
                pbWebview.setVisibility(View.GONE);

            }

        });


    }

    @OnClick(R.id.iv_login_back)
    public void onClick() {
        //进入主页面
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    //按下退出键进入主页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        return false;
    }
}
