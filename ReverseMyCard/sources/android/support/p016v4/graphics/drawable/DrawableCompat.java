package android.support.p016v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompat */
public final class DrawableCompat {
    static final DrawableImpl IMPL;

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$DrawableImpl */
    interface DrawableImpl {
        void applyTheme(Drawable drawable, Resources.Theme theme);

        boolean canApplyTheme(Drawable drawable);

        void clearColorFilter(Drawable drawable);

        int getAlpha(Drawable drawable);

        ColorFilter getColorFilter(Drawable drawable);

        int getLayoutDirection(Drawable drawable);

        void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);

        boolean isAutoMirrored(Drawable drawable);

        void jumpToCurrentState(Drawable drawable);

        void setAutoMirrored(Drawable drawable, boolean z);

        void setHotspot(Drawable drawable, float f, float f2);

        void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4);

        boolean setLayoutDirection(Drawable drawable, int i);

        void setTint(Drawable drawable, int i);

        void setTintList(Drawable drawable, ColorStateList colorStateList);

        void setTintMode(Drawable drawable, PorterDuff.Mode mode);

        Drawable wrap(Drawable drawable);
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl */
    static class BaseDrawableImpl implements DrawableImpl {
        BaseDrawableImpl() {
        }

        public void jumpToCurrentState(Drawable drawable) {
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
        }

        public boolean isAutoMirrored(Drawable drawable) {
            return false;
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void setTint(Drawable drawable, int i) {
            DrawableCompatBase.setTint(drawable, i);
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            DrawableCompatBase.setTintList(drawable, colorStateList);
        }

        public void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            DrawableCompatBase.setTintMode(drawable, mode);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatBase.wrapForTinting(drawable);
        }

        public boolean setLayoutDirection(Drawable drawable, int i) {
            return false;
        }

        public int getLayoutDirection(Drawable drawable) {
            return 0;
        }

        public int getAlpha(Drawable drawable) {
            return 0;
        }

        public void applyTheme(Drawable drawable, Resources.Theme theme) {
        }

        public boolean canApplyTheme(Drawable drawable) {
            return false;
        }

        public ColorFilter getColorFilter(Drawable drawable) {
            return null;
        }

        public void clearColorFilter(Drawable drawable) {
            drawable.clearColorFilter();
        }

        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            DrawableCompatBase.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl */
    static class HoneycombDrawableImpl extends BaseDrawableImpl {
        HoneycombDrawableImpl() {
        }

        public void jumpToCurrentState(Drawable drawable) {
            DrawableCompatHoneycomb.jumpToCurrentState(drawable);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatHoneycomb.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$JellybeanMr1DrawableImpl */
    static class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl {
        JellybeanMr1DrawableImpl() {
        }

        public boolean setLayoutDirection(Drawable drawable, int i) {
            return DrawableCompatJellybeanMr1.setLayoutDirection(drawable, i);
        }

        public int getLayoutDirection(Drawable drawable) {
            int layoutDirection = DrawableCompatJellybeanMr1.getLayoutDirection(drawable);
            if (layoutDirection >= 0) {
                return layoutDirection;
            }
            return 0;
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$KitKatDrawableImpl */
    static class KitKatDrawableImpl extends JellybeanMr1DrawableImpl {
        KitKatDrawableImpl() {
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
            DrawableCompatKitKat.setAutoMirrored(drawable, z);
        }

        public boolean isAutoMirrored(Drawable drawable) {
            return DrawableCompatKitKat.isAutoMirrored(drawable);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatKitKat.wrapForTinting(drawable);
        }

        public int getAlpha(Drawable drawable) {
            return DrawableCompatKitKat.getAlpha(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$LollipopDrawableImpl */
    static class LollipopDrawableImpl extends KitKatDrawableImpl {
        LollipopDrawableImpl() {
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
            DrawableCompatLollipop.setHotspot(drawable, f, f2);
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
            DrawableCompatLollipop.setHotspotBounds(drawable, i, i2, i3, i4);
        }

        public void setTint(Drawable drawable, int i) {
            DrawableCompatLollipop.setTint(drawable, i);
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            DrawableCompatLollipop.setTintList(drawable, colorStateList);
        }

        public void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            DrawableCompatLollipop.setTintMode(drawable, mode);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatLollipop.wrapForTinting(drawable);
        }

        public void applyTheme(Drawable drawable, Resources.Theme theme) {
            DrawableCompatLollipop.applyTheme(drawable, theme);
        }

        public boolean canApplyTheme(Drawable drawable) {
            return DrawableCompatLollipop.canApplyTheme(drawable);
        }

        public ColorFilter getColorFilter(Drawable drawable) {
            return DrawableCompatLollipop.getColorFilter(drawable);
        }

        public void clearColorFilter(Drawable drawable) {
            DrawableCompatLollipop.clearColorFilter(drawable);
        }

        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            DrawableCompatLollipop.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$MDrawableImpl */
    static class MDrawableImpl extends LollipopDrawableImpl {
        MDrawableImpl() {
        }

        public boolean setLayoutDirection(Drawable drawable, int i) {
            return DrawableCompatApi23.setLayoutDirection(drawable, i);
        }

        public int getLayoutDirection(Drawable drawable) {
            return DrawableCompatApi23.getLayoutDirection(drawable);
        }

        public Drawable wrap(Drawable drawable) {
            return drawable;
        }

        public void clearColorFilter(Drawable drawable) {
            drawable.clearColorFilter();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            IMPL = new MDrawableImpl();
        } else if (i >= 21) {
            IMPL = new LollipopDrawableImpl();
        } else if (i >= 19) {
            IMPL = new KitKatDrawableImpl();
        } else if (i >= 17) {
            IMPL = new JellybeanMr1DrawableImpl();
        } else if (i >= 11) {
            IMPL = new HoneycombDrawableImpl();
        } else {
            IMPL = new BaseDrawableImpl();
        }
    }

    public static void jumpToCurrentState(Drawable drawable) {
        IMPL.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        IMPL.setAutoMirrored(drawable, z);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return IMPL.isAutoMirrored(drawable);
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        IMPL.setHotspot(drawable, f, f2);
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        IMPL.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    public static void setTint(Drawable drawable, int i) {
        IMPL.setTint(drawable, i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        IMPL.setTintList(drawable, colorStateList);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        IMPL.setTintMode(drawable, mode);
    }

    public static int getAlpha(Drawable drawable) {
        return IMPL.getAlpha(drawable);
    }

    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        IMPL.applyTheme(drawable, theme);
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return IMPL.canApplyTheme(drawable);
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        return IMPL.getColorFilter(drawable);
    }

    public static void clearColorFilter(Drawable drawable) {
        IMPL.clearColorFilter(drawable);
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        IMPL.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable wrap(Drawable drawable) {
        return IMPL.wrap(drawable);
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        if (drawable instanceof DrawableWrapper) {
            return ((DrawableWrapper) drawable).getWrappedDrawable();
        }
        return drawable;
    }

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        return IMPL.setLayoutDirection(drawable, i);
    }

    public static int getLayoutDirection(Drawable drawable) {
        return IMPL.getLayoutDirection(drawable);
    }

    private DrawableCompat() {
    }
}
