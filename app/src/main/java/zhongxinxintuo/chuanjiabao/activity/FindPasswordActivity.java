package zhongxinxintuo.chuanjiabao.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import zhongxinxintuo.chuanjiabao.R;
import zhongxinxintuo.chuanjiabao.utils.ToastUtils;

public class FindPasswordActivity extends AppCompatActivity {

    @InjectView(R.id.iv_login_back)
    ImageView ivLoginBack;
    @InjectView(R.id.tv_login_title)
    TextView tvLoginTitle;
    @InjectView(R.id.edt_login_phone)
    EditText edtLoginPhone;
    @InjectView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @InjectView(R.id.tv_verification_code)
    TextView tvVerificationCode;
    @InjectView(R.id.btn_register_next)
    Button btnRegisterNext;
    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        ButterKnife.inject(this);
        tvLoginTitle.setText("找回密码");
    }

    @OnClick({R.id.iv_login_back, R.id.tv_verification_code, R.id.btn_register_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_login_back:
                finish();
                break;
            case R.id.tv_verification_code:
                if (TextUtils.isEmpty(edtLoginPhone.getText())) {
                    ToastUtils.showToast(this, "请输入手机号");
                    edtLoginPhone.getText().clear();
                } else if (edtLoginPhone.getText().toString().length() != 11) {
                    ToastUtils.showToast(this, "手机号输入有误，请重新输入");
                    edtLoginPhone.getText().clear();
                } else {
                    //获取验证码
                    ToastUtils.showToast(this, "验证码已发送");
                    //验证码倒计时
                    time = new TimeCount(11000, 1000);//参数依次为总时长，计时时间间隔
                    time.start();

                    //向服务器请求验证码
                    /**
                     * 具体逻辑实现
                     */

                }

                break;
            case R.id.btn_register_next:
                String number = edtLoginPhone.getText().toString().trim();
                String code = edtLoginPassword.getText().toString().trim();
                Map<String, String> map = new HashMap<String, String>();
                map.put("phone", number);
                map.put("code", code);
                if (TextUtils.isEmpty(number)) {
                    ToastUtils.showToast(this, "请填写完整");
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    ToastUtils.showToast(this, "请输入验证码");
                    return;
                }

                //将账号和验证码发送至服务器进行验证

                /**
                 * 具体逻辑实现
                 */

                //进入设置密码页面
                startActivity(new Intent(this, RegisterPasswordActivity.class));
                finish();
                break;
        }

    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程显示
        @Override
        public void onTick(long millisUntilFinished) {
            tvVerificationCode.setText(millisUntilFinished / 1000 + "秒后重新发送");
            tvVerificationCode.setClickable(false);
//            tvVerificationCode.setBackgroundDrawable(getDrawable(R.drawable.bg_btn_shape_sending));
            tvVerificationCode.setBackgroundColor(Color.parseColor("#f2f2f2"));
        }

        //计时完成触发
        @Override
        public void onFinish() {
            tvVerificationCode.setText("获取验证码");
//            tvVerificationCode.setBackgroundDrawable(getDrawable(R.drawable.bg_btn_shape_login));
            tvVerificationCode.setClickable(true);
            tvVerificationCode.setBackgroundColor(Color.parseColor("#f12330"));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (time != null) {
            time.cancel();
            time = null;
        }
    }

}
