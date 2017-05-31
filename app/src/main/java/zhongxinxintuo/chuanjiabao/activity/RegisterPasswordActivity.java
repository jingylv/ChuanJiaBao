package zhongxinxintuo.chuanjiabao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class RegisterPasswordActivity extends AppCompatActivity {

    @InjectView(R.id.iv_login_back)
    ImageView ivLoginBack;
    @InjectView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @InjectView(R.id.edt_login_password_second)
    EditText edtLoginPasswordSecond;
    @InjectView(R.id.btn_register_password_confirm)
    Button btnRegisterPasswordConfirm;
    @InjectView(R.id.tv_login_title)
    TextView tvLoginTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);
        ButterKnife.inject(this);
        tvLoginTitle.setText("设置密码");

        edtLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edtLoginPasswordSecond.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    @OnClick({R.id.iv_login_back, R.id.btn_register_password_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_login_back:
                finish();
                break;
            case R.id.btn_register_password_confirm:
                String pwd = edtLoginPassword.getText().toString().trim();
                String pwdSecond = edtLoginPasswordSecond.getText().toString().trim();
                Map<String, String> map = new HashMap<>();
                map.put("password", pwd);
                map.put("passwordSecond", pwdSecond);

                if (pwd.length() < 6) {
                    ToastUtils.showToast(this, "密码长度不能小于六位");
                    return;
                }

                if (!pwd.equals(pwdSecond)) {
                    ToastUtils.showToast(this, "两次输入的密码不一致");
                    return;
                }

                //向服务器提交数据
                /**
                 * 具体实现
                 */

                //进入注册成功页面
                startActivity(new Intent(this, RegisterSuccessActivity.class));
                break;
        }
    }
}
