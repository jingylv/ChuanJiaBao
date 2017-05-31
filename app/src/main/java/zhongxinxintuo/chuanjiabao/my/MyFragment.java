package zhongxinxintuo.chuanjiabao.my;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import zhongxinxintuo.chuanjiabao.R;
import zhongxinxintuo.chuanjiabao.activity.LoginActivity;
import zhongxinxintuo.chuanjiabao.base.BaseFragment;
import zhongxinxintuo.chuanjiabao.my.activity.MessageActivity;
import zhongxinxintuo.chuanjiabao.my.activity.MyOrderActivity;
import zhongxinxintuo.chuanjiabao.utils.ToastUtils;

/**
 * Created by jingylv on 2017/5/16.
 * 我的
 */

public class MyFragment extends BaseFragment {

    @InjectView(R.id.titlebar_iv_msg)
    ImageView titlebarIvMsg;
    @InjectView(R.id.titlebar_title)
    TextView titlebarTitle;
    @InjectView(R.id.titlerbar_iv_setting)
    ImageView titlerbarIvSetting;
    @InjectView(R.id.iv_my_bg)
    ImageView ivMyBg;
    @InjectView(R.id.tv_my_name)
    TextView tvMyName;
    @InjectView(R.id.iv_my_sex)
    ImageView ivMySex;
    @InjectView(R.id.tv_my_sex)
    TextView tvMySex;
    @InjectView(R.id.tv_my_phone)
    TextView tvMyPhone;
    @InjectView(R.id.tv_my_email)
    TextView tvMyEmail;
    @InjectView(R.id.tv_my_account)
    TextView tvMyAccount;
    @InjectView(R.id.tv_my_consume)
    TextView tvMyConsume;
    @InjectView(R.id.tv_my_integration)
    TextView tvMyIntegration;
    @InjectView(R.id.tv_my_work)
    TextView tvMyWork;
    @InjectView(R.id.iv_my_order1)
    ImageView ivMyOrder1;
    @InjectView(R.id.iv_my_order2)
    ImageView ivMyOrder2;
    @InjectView(R.id.tv_my_order)
    TextView tvMyOrder;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_my, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        Log.e("TAG", "我的页面数据被加载了");
        super.initData();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.titlebar_iv_msg, R.id.titlerbar_iv_setting, R.id.tv_my_account, R.id.tv_my_consume, R.id.tv_my_integration, R.id.tv_my_work, R.id.iv_my_order1, R.id.iv_my_order2, R.id.tv_my_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar_iv_msg:
                ToastUtils.showToast(getActivity(), "消息");
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.titlerbar_iv_setting:
                ToastUtils.showToast(getActivity(), "设置");
                //暂时先来个跳转到登录页面
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.tv_my_account:
                ToastUtils.showToast(getActivity(), "账户");
                break;
            case R.id.tv_my_consume:
                ToastUtils.showToast(getActivity(), "消费");
                break;
            case R.id.tv_my_integration:
                ToastUtils.showToast(getActivity(), "积分");
                break;
            case R.id.tv_my_work:
                ToastUtils.showToast(getActivity(), "我的业务");
                break;
            case R.id.iv_my_order1:
                ToastUtils.showToast(getActivity(), "订单1");
                break;
            case R.id.iv_my_order2:
                ToastUtils.showToast(getActivity(), "订单2");
                break;
            case R.id.tv_my_order:
                ToastUtils.showToast(getActivity(), "我的订单");
                startActivity(new Intent(getActivity(), MyOrderActivity.class));
                break;
        }
    }
}
