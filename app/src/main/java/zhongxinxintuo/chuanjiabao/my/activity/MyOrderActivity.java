package zhongxinxintuo.chuanjiabao.my.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import zhongxinxintuo.chuanjiabao.R;
import zhongxinxintuo.chuanjiabao.my.fragment.MyOrderDiscoverFragment;
import zhongxinxintuo.chuanjiabao.my.fragment.MyOrderMyFragment;
import zhongxinxintuo.chuanjiabao.my.fragment.MyOrderOrderFragment;
import zhongxinxintuo.chuanjiabao.utils.ToastUtils;

public class MyOrderActivity extends AppCompatActivity {

    @InjectView(R.id.iv_my_order_title_close)
    ImageView ivMyOrderTitleClose;
    @InjectView(R.id.tv_my_order_title_name)
    TextView tvMyOrderTitleName;
    @InjectView(R.id.iv_my_order_title_more)
    ImageView ivMyOrderTitleMore;
    @InjectView(R.id.fl_my_order)
    FrameLayout flMyOrder;
    @InjectView(R.id.rg_my_order)
    RadioGroup rgMyOrder;
    private List<Fragment> fragments;
    private Fragment tempFragment;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        ButterKnife.inject(this);

        //初始化fragment
        initFragment();

        //fragment设置监听
        initListenerFragment();
    }

    private void initListenerFragment() {
        rgMyOrder.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_my_order_discover:
                        position = 0;
                        tvMyOrderTitleName.setText("我的活动");
                        break;
                    case R.id.rb_my_order_order:
                        position = 1;
                        tvMyOrderTitleName.setText("我的订单");
                        break;
                    case R.id.rb_my_order_my:
                        position = 2;
                        tvMyOrderTitleName.setText("我");
                        break;
                }
                //根据位置切换到不同的fragment
                Fragment currentFragment = fragments.get(position);
                switchFragment(currentFragment);
            }
        });

        //打开应用时默认显示首页
        rgMyOrder.check(R.id.rb_my_order_order);

    }

    private void switchFragment(Fragment currentFragment) {
        if (tempFragment != currentFragment) {
            //得到事务
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //如果当前页面没有被加载
            if (!currentFragment.isAdded()) {
                //缓存的隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                //添加
                ft.add(R.id.fl_my_order, currentFragment);

            } else {//如果当前页面已经被加载过
                //缓存的隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }

                //显示
                ft.show(currentFragment);
            }
            //提交
            ft.commit();

            //把当前的赋值给缓存
            tempFragment = currentFragment;
        }
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MyOrderDiscoverFragment());
        fragments.add(new MyOrderOrderFragment());
        fragments.add(new MyOrderMyFragment());
    }

    @OnClick({R.id.iv_my_order_title_close, R.id.iv_my_order_title_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_my_order_title_close:
                ToastUtils.showToast(this, "关闭");
                finish();
                break;
            case R.id.iv_my_order_title_more:
                ToastUtils.showToast(this, "更多");
                break;
        }
    }
}
