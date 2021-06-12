package android.support.p016v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: android.support.v4.content.res.ResourcesCompat */
public final class ResourcesCompat {
    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ResourcesCompatApi21.getDrawable(resources, i, theme);
        }
        return resources.getDrawable(i);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ResourcesCompatApi21.getDrawableForDensity(resources, i, i2, theme);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            return ResourcesCompatIcsMr1.getDrawableForDensity(resources, i, i2);
        }
        return resources.getDrawable(i);
    }

    public static int getColor(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ResourcesCompatApi23.getColor(resources, i, theme);
        }
        return resources.getColor(i);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ResourcesCompatApi23.getColorStateList(resources, i, theme);
        }
        return resources.getColorStateList(i);
    }

    private ResourcesCompat() {
    }
}
