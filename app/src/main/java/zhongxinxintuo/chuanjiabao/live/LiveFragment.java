package zhongxinxintuo.chuanjiabao.live;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import zhongxinxintuo.chuanjiabao.base.BaseFragment;

/**
 * Created by jingylv on 2017/5/16.
 * 生活
 */

public class LiveFragment extends BaseFragment {

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
        Log.e("TAG", "生活页面数据被加载了");
        super.initData();
        textView.setText("生活");
    }
}
