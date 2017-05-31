package zhongxinxintuo.chuanjiabao.utils;

import android.content.Context;
import android.content.SharedPreferences;



public class CacheUtils {
    private static SharedPreferences sp;

    public static void setBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            if(context!=null) {
                sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
            }
        }

        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key) {
        if (sp == null) {
            if(context!=null) {
                sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
            }

        }
        return sp.getBoolean(key, false);
    }


    public static void setInt(Context context, String key, int value) {
        if (sp == null) {
            if (context != null) {
                sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
            }
        }

        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key) {
        if(sp==null) {
            if(context!=null) {
                sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
            }
        }
        return sp.getInt(key, 0);
    }


    public static void setString(Context context, String key, String value) {
        if (sp == null) {
            if(context!=null) {
                sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
            }

        }

        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key) {
        if (sp == null) {
            if (context != null) {
                sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
            }
        }
        return sp.getString(key, "");
    }
}
