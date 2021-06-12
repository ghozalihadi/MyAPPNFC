package android.support.p016v4.content.res;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/* renamed from: android.support.v4.content.res.ConfigurationHelperGingerbread */
class ConfigurationHelperGingerbread {
    ConfigurationHelperGingerbread() {
    }

    static int getScreenHeightDp(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    static int getScreenWidthDp(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    static int getSmallestScreenWidthDp(Resources resources) {
        return Math.min(getScreenWidthDp(resources), getScreenHeightDp(resources));
    }

    static int getDensityDpi(Resources resources) {
        return resources.getDisplayMetrics().densityDpi;
    }
}
