package android.support.p016v4.content.res;

import android.content.res.Resources;

/* renamed from: android.support.v4.content.res.ConfigurationHelperHoneycombMr2 */
class ConfigurationHelperHoneycombMr2 {
    ConfigurationHelperHoneycombMr2() {
    }

    static int getScreenHeightDp(Resources resources) {
        return resources.getConfiguration().screenHeightDp;
    }

    static int getScreenWidthDp(Resources resources) {
        return resources.getConfiguration().screenWidthDp;
    }

    static int getSmallestScreenWidthDp(Resources resources) {
        return resources.getConfiguration().smallestScreenWidthDp;
    }
}
