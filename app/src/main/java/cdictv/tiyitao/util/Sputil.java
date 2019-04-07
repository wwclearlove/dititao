package cdictv.tiyitao.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import cdictv.tiyitao.App;

public class Sputil {
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences getmSharedPreferences(){
        if(mSharedPreferences==null){
            mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(App.INSTANCE);
        }
        return mSharedPreferences;
    }
    public static void putString(String key,String value){
        getmSharedPreferences().edit().putString(key,value).apply();
    }
    public static void putBoolen(String key,Boolean value){
        getmSharedPreferences().edit().putBoolean(key,value).apply();
    }
    public static String getString(String key){
      return getmSharedPreferences().getString(key,null);
    }
    public static boolean getBoolen(String key, Boolean defValue){
       return getmSharedPreferences().getBoolean(key,defValue);

    }
    public static int getValue(String key, int defValue){
        return getmSharedPreferences().getInt(key,defValue);
    }
    public static void removeKey(String key){
        getmSharedPreferences().edit().remove(key).apply();
    }
}
