package zhongxinxintuo.chuanjiabao.utils;


import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.view.View;

/**
 * 专门提供为处理一些UI相关的问题而创建的工具类
 */
public class UIUtils {

    public static Context getContext() {
        return MyApplication.context;
    }

    public static Handler getHandler() {
        return MyApplication.handler;
    }

    public static int getColor(int colorId) {
        return getContext().getResources().getColor(colorId);
    }

    public static View getView(int viewId) {
        return View.inflate(getContext(), viewId, null);
    }

    public static String[] getStringArr(int arrId) {
        return getContext().getResources().getStringArray(arrId);
    }

    //与屏幕分辨率相关的
    public static int dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);
    }

    public static int px2dp(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }


    public static void runOnUiThread(Runnable runnable) {
        //根据pid 来判断是不是主线程
        if(MyApplication.getMainThreadId() == Process.myPid()) {
            runnable.run();
        }else{
            //给handler发送一个runnable()
            MyApplication.getHandler().post(runnable);
        }
    }
}


