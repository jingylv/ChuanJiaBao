package zhongxinxintuo.chuanjiabao.utils;

import android.app.Activity;

import java.util.Stack;



public class AppManager {
    private AppManager() {
    }

    private static AppManager appManager = new AppManager();

    public static AppManager getInstance() {
        return appManager;
    }

    /**
     *  * 统一应用程序中所有的Activity的栈管理（单例）
     *  * 涉及到activity的添加、删除指定、删除当前、删除所有、返回栈大小的方法
     *  
     */


    private Stack<Activity> stack = new Stack<>();

    //添加Activity到栈中
    public void addActivity(Activity activity) {
        if (activity != null) {
            stack.add(activity);

        }
    }

    //删除指定的Activity
    public void removeActivity(Activity activity) {
        if (activity != null) {
            for (int i = stack.size() - 1; i >= 0; i--) {
                Activity currentActivity = stack.get(i);
                if (currentActivity.getClass().equals(activity.getClass())) {
                    currentActivity.finish(); //删除系统任务栈中的activity
                    stack.remove(currentActivity); //删除自定义任务栈中的activity
                }
            }
        }
    }

    //删除所有的Activity
    public void removeAllActivity() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            Activity currentActivity = stack.get(i);
            currentActivity.finish();
            stack.remove(currentActivity);
        }
    }

    //移除当前的Activity
    public void removeCurrentAcitvity() {
        Activity currentActivity = stack.get(stack.size() - 1);
        currentActivity.finish();
        stack.remove(currentActivity);
    }

    //获取栈的大小
    public int getStackSize() {
        return stack.size();
    }

    public void remove(Activity activity) {
        if (activity != null) {
            for (int i = stack.size() - 1; i >= 0; i--) {
                Activity currentActivity = stack.get(i);
                if (currentActivity == activity) {
                    stack.remove(currentActivity);
                }
            }
        }

    }
}
