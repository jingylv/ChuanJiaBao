package zhongxinxintuo.chuanjiabao.invest;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import zhongxinxintuo.chuanjiabao.base.BaseFragment;

/**
 * Created by jingylv on 2017/5/16.
 * 投资
 */

public class InvestFragment extends BaseFragment {

    private TextView textView;

    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        Log.e("TAG", "投资页面数据被加载了");
        super.initData();
        textView.setText("投资");
    }
}
