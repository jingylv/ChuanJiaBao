package zhongxinxintuo.chuanjiabao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
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

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.iv_login_back)
    ImageView ivLoginBack;
    @InjectView(R.id.edt_login_phone)
    EditText edtLoginPhone;
    @InjectView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @InjectView(R.id.tv_login_forget_password)
    TextView tvLoginForgetPassword;
    @InjectView(R.id.btn_login_login)
    Button btnLoginLogin;
    @InjectView(R.id.btn_login_register)
    Button btnLoginRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        //设置密码不可见
        edtLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        //设置密码可见
//        edtLoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

    }

    @OnClick({R.id.iv_login_back, R.id.tv_login_forget_password, R.id.btn_login_login, R.id.btn_login_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_login_back:
                ToastUtils.showToast(this, "返回主页面");
                //返回到主页面
                startActivity(new Intent(this, MainActivity.class));
                //结束当前页面
                finish();
                break;
            case R.id.tv_login_forget_password:
                //跳转到找回密码页面
                ToastUtils.showToast(this, "找回密码");
                startActivity(new Intent(this, FindPasswordActivity.class));
                break;
            case R.id.btn_login_login:
                if (TextUtils.isEmpty(edtLoginPhone.getText()) || TextUtils.isEmpty(edtLoginPhone.getText())) {
                    ToastUtils.showToast(this, "请填写完整");
                    return;
                }
                //账号密码获取并提交至服务器进行校验
                String number = edtLoginPhone.getText().toString().trim();
                String pwd = edtLoginPhone.getText().toString().trim();
                Map<String, String> map = new HashMap<String, String>();
                map.put("phone", number);
                map.put("password", pwd);
                //请求服务器


                //登录成功跳转到主页面
                ToastUtils.showToast(this, "登录成功");
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.btn_login_register:
                //跳转至注册页面
                ToastUtils.showToast(this, "注册");
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
