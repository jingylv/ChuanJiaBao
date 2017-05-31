package zhongxinxintuo.chuanjiabao.my.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import zhongxinxintuo.chuanjiabao.base.BaseFragment;

/**
 * Created by jingylv on 2017/5/22.
 */

public class MyOrderMyFragment extends BaseFragment {
    private TextView textView;

    @Override
    public View initView() {
        Log.e("TAG", "我的订单我的页面视图初始化了");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        Log.e("TAG", "我的订单我的页面数据初始化了");
        super.initData();
        textView.setText("我是我的页面");
    }
}
