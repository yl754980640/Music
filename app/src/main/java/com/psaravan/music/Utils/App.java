package com.psaravan.music.Utils;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

/**
 * Application class that holds all singleton objects and provides
 * access to common objects and variables.
 *
 * @author Saravan Pantham
 */
public class App extends Application {

    // Debug tags.
    public static String INFO = "INFO";
    public static String ERROR = "ERROR";
    public static String DEBUG = "DEBUG";

    private static Context mContext;

    @Override
    public void onCreate() {
        mContext = this.getApplicationContext();
    }

    /**
     * @return The application wide context.
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * Application-wide method to set a specific window's status bar color.
     * @param window The window to apply the status bar color to.
     * @param color The color to apply to the status bar.
     */
    public static void setStatusColorBarColor(Window window, int color) {
        if (window==null)
            return;

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(color);
    }

    /**
     * Calculates the dimensions of the current screen.
     * @return An int array that contains the screen width and height in pixels.
     */
    public static int[] getScreenDimensions() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();

        int[] dimens = new int[2];
        display.getSize(point);
        dimens[0] = point.x;
        dimens[1] = point.y;

        return dimens;
    }
}
