package android.support.p016v4.content.res;

import android.content.res.Resources;
import android.os.Build;

/* renamed from: android.support.v4.content.res.ConfigurationHelper */
public final class ConfigurationHelper {
    private static final ConfigurationHelperImpl IMPL;

    /* renamed from: android.support.v4.content.res.ConfigurationHelper$ConfigurationHelperImpl */
    private interface ConfigurationHelperImpl {
        int getDensityDpi(Resources resources);

        int getScreenHeightDp(Resources resources);

        int getScreenWidthDp(Resources resources);

        int getSmallestScreenWidthDp(Resources resources);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            IMPL = new JellybeanMr1Impl();
        } else if (i >= 13) {
            IMPL = new HoneycombMr2Impl();
        } else {
            IMPL = new GingerbreadImpl();
        }
    }

    private ConfigurationHelper() {
    }

    /* renamed from: android.support.v4.content.res.ConfigurationHelper$GingerbreadImpl */
    private static class GingerbreadImpl implements ConfigurationHelperImpl {
        GingerbreadImpl() {
        }

        public int getScreenHeightDp(Resources resources) {
            return ConfigurationHelperGingerbread.getScreenHeightDp(resources);
        }

        public int getScreenWidthDp(Resources resources) {
            return ConfigurationHelperGingerbread.getScreenWidthDp(resources);
        }

        public int getSmallestScreenWidthDp(Resources resources) {
            return ConfigurationHelperGingerbread.getSmallestScreenWidthDp(resources);
        }

        public int getDensityDpi(Resources resources) {
            return ConfigurationHelperGingerbread.getDensityDpi(resources);
        }
    }

    /* renamed from: android.support.v4.content.res.ConfigurationHelper$HoneycombMr2Impl */
    private static class HoneycombMr2Impl extends GingerbreadImpl {
        HoneycombMr2Impl() {
        }

        public int getScreenHeightDp(Resources resources) {
            return ConfigurationHelperHoneycombMr2.getScreenHeightDp(resources);
        }

        public int getScreenWidthDp(Resources resources) {
            return ConfigurationHelperHoneycombMr2.getScreenWidthDp(resources);
        }

        public int getSmallestScreenWidthDp(Resources resources) {
            return ConfigurationHelperHoneycombMr2.getSmallestScreenWidthDp(resources);
        }
    }

    /* renamed from: android.support.v4.content.res.ConfigurationHelper$JellybeanMr1Impl */
    private static class JellybeanMr1Impl extends HoneycombMr2Impl {
        JellybeanMr1Impl() {
        }

        public int getDensityDpi(Resources resources) {
            return ConfigurationHelperJellybeanMr1.getDensityDpi(resources);
        }
    }

    public static int getScreenHeightDp(Resources resources) {
        return IMPL.getScreenHeightDp(resources);
    }

    public static int getScreenWidthDp(Resources resources) {
        return IMPL.getScreenWidthDp(resources);
    }

    public static int getSmallestScreenWidthDp(Resources resources) {
        return IMPL.getSmallestScreenWidthDp(resources);
    }

    public static int getDensityDpi(Resources resources) {
        return IMPL.getDensityDpi(resources);
    }
}
