package com.example.mvcstructure.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ScreenUtil {

    private static ScreenUtil instance;

    public static ScreenUtil getInstance() {
        if (instance == null)
            instance = new ScreenUtil();
        return instance;
    }

    private Context mContext;

    private ScreenUtil() {
        mContext = Contextor.getInstance().getContext();
    }

    public int getScreenWidth(){
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
    public int getScreenHeight(){
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }
}
