package zhongxinxintuo.chuanjiabao.my.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import zhongxinxintuo.chuanjiabao.R;
import zhongxinxintuo.chuanjiabao.utils.ToastUtils;

public class MessageActivity extends AppCompatActivity {

    @InjectView(R.id.titlebar_iv_msg)
    ImageView titlebarIvMsg;
    @InjectView(R.id.titlebar_title)
    TextView titlebarTitle;
    @InjectView(R.id.titlerbar_iv_setting)
    ImageView titlerbarIvSetting;
    @InjectView(R.id.iv_message_service)
    ImageView ivMessageService;
    @InjectView(R.id.iv_message_product1)
    ImageView ivMessageProduct1;
    @InjectView(R.id.iv_message_product2)
    ImageView ivMessageProduct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        titlebarIvMsg.setImageResource(R.drawable.top_bar_left_back);
        titlebarTitle.setText("会话");
        titlerbarIvSetting.setVisibility(View.GONE);

    }

    @OnClick({R.id.titlebar_iv_msg, R.id.iv_message_service, R.id.iv_message_product1, R.id.iv_message_product2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_iv_msg:
                finish();
                break;
            case R.id.iv_message_service:
                ToastUtils.showToast(this, "客服");
                break;
            case R.id.iv_message_product1:
                ToastUtils.showToast(this, "产品A");
                break;
            case R.id.iv_message_product2:
                ToastUtils.showToast(this, "产品B");
                break;
        }
    }
}
