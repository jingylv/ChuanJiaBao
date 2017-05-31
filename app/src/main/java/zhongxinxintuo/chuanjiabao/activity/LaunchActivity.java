package zhongxinxintuo.chuanjiabao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import zhongxinxintuo.chuanjiabao.R;
import zhongxinxintuo.chuanjiabao.utils.ToastUtils;

public class LaunchActivity extends AppCompatActivity {

    @InjectView(R.id.iv_launch_ad)
    ImageView ivLaunchAd;
    @InjectView(R.id.btn_launch_ad)
    Button btnLaunchAd;
    @InjectView(R.id.btn_launch_time)
    Button btnLaunchTime;
    @InjectView(R.id.btn_launch_start)
    Button btnLaunchStart;
    @InjectView(R.id.ll_launch)
    LinearLayout llLaunch;

    private int time = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                btnLaunchTime.setText(getTime() + "秒跳过");
                handler.sendEmptyMessageDelayed(0, 1000);
            }

        }
    };

    private int getTime() {
        time--;
        if (time == 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return time;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.inject(this);
        //开启启动页
        overridePendingTransition(R.anim.launch_enter, R.anim.launch_exit);

        handler.sendEmptyMessageDelayed(0, 1000);

    }


    @OnClick({R.id.btn_launch_ad, R.id.btn_launch_time, R.id.btn_launch_start})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_launch_ad:
                handler.removeMessages(0);
                //进入广告详情页面
                ToastUtils.showToast(this, "即刻尊享");
                startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://trust.ecitic.com/"));
                finish();
                break;
            case R.id.btn_launch_time:
                //进入主页面
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.btn_launch_start:
                //进入主页面
                startActivity(new Intent(this, MainActivity.class));
//                //进入登录页面
//                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
