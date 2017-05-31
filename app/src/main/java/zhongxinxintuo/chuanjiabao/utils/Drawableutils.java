package zhongxinxintuo.chuanjiabao.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;



public class Drawableutils {

    public static Drawable getDrawable() {

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.BLUE);
        drawable.setCornerRadius(20);
        drawable.setStroke(2, Color.RED);
        drawable.setGradientType(GradientDrawable.RECTANGLE);
        return drawable;
    }

    public static StateListDrawable getSelector(Drawable normalDrawable, Drawable pressDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        //给当前的颜色选择器添加选中图片指向状态，未选中图片指向状态
        stateListDrawable.addState(
                new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed},
                pressDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled},
                normalDrawable);
        //设置默认状态
        stateListDrawable.addState(new int[]{}, normalDrawable);
        return stateListDrawable;
    }
}
