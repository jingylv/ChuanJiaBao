package zhongxinxintuo.chuanjiabao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import zhongxinxintuo.chuanjiabao.R;

public class RegisterSuccessActivity extends AppCompatActivity {

    @InjectView(R.id.iv_login_back)
    ImageView ivLoginBack;
    @InjectView(R.id.btn_register_success_login)
    Button btnRegisterSuccessLogin;
    @InjectView(R.id.tv_login_title)
    TextView tvLoginTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);
        ButterKnife.inject(this);
        tvLoginTitle.setText("成功");
    }

    @OnClick({R.id.iv_login_back, R.id.btn_register_success_login})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.iv_login_back:
                finish();
                break;
            case R.id.btn_register_success_login:
                //跳转到登录页面
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
