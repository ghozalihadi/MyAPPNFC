package android.support.p016v4.p018os;

import android.os.Build;

/* renamed from: android.support.v4.os.BuildCompat */
public class BuildCompat {
    private BuildCompat() {
    }

    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isAtLeastNMR1() {
        return Build.VERSION.SDK_INT >= 25;
    }
}
