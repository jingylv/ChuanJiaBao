package zhongxinxintuo.chuanjiabao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import zhongxinxintuo.chuanjiabao.R;

public class SplashActivity extends AppCompatActivity {

    @InjectView(R.id.iv_splash)
    ImageView ivSplash;
    @InjectView(R.id.rl_splash)
    RelativeLayout rlSplash;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startLaunchAcitivity();  //开启MainActivity
            }
        }, 2000);

    }

    private void startLaunchAcitivity() {
        startActivity(new Intent(this, LaunchActivity.class));
        finish();
    }



    //渐变动画
//    private void startSplash() {
//        AlphaAnimation alpha = new AlphaAnimation(0.5f, 1f);
//        alpha.setDuration(2000);
//        alpha.setFillAfter(true);
//
//        alpha.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                //跳转至下一个页面
//                jumpTo();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        rlSplash.startAnimation(alpha);
//    }
//
//    private void jumpTo() {
//        startActivity(new Intent(this, LaunchActivity.class));
//        finish();
//    }


}
