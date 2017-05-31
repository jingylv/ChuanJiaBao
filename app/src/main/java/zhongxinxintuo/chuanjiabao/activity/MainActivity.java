package zhongxinxintuo.chuanjiabao.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import zhongxinxintuo.chuanjiabao.R;
import zhongxinxintuo.chuanjiabao.home.HomeFragment;
import zhongxinxintuo.chuanjiabao.invest.InvestFragment;
import zhongxinxintuo.chuanjiabao.live.LiveFragment;
import zhongxinxintuo.chuanjiabao.my.MyFragment;
import zhongxinxintuo.chuanjiabao.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;
    private List<Fragment> fragments;
    private int position = 0;
    private Fragment tempFragment;     //临时fragment
    private boolean isDouble = false;  //双击

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        //初始化fragment
        initFragment();

        //fragment设置监听
        initListenerFragment();

    }

    private void initListenerFragment() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_invest:
                        position = 1;
                        break;
                    case R.id.rb_live:
                        position = 2;
                        break;
                    case R.id.rb_my:
                        position = 3;
                        break;
                }
                //根据位置切换到不同的fragment
                Fragment currentFragment = fragments.get(position);
                switchFragment(currentFragment);
            }
        });

        //打开应用时默认显示首页
        rgMain.check(R.id.rb_home);


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
                ft.add(R.id.fl_main, currentFragment);

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
        fragments.add(new HomeFragment());
        fragments.add(new InvestFragment());
        fragments.add(new LiveFragment());
        fragments.add(new MyFragment());
    }

    //双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //如果不在首页,那么先跳转到首页然后再双击退出
            if (position != 0) {
                rgMain.check(R.id.rb_home);
            } else {
                if (isDouble) {
                    finish();
                    System.exit(0);
                }

                isDouble = true;
                ToastUtils.showToast(this, "再按一次将退出传家宝");
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isDouble = false;
                    }
                }, 2000);
            }
        }
        return false;
    }

}
