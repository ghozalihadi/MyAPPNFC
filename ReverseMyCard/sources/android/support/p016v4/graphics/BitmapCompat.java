package android.support.p016v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;

/* renamed from: android.support.v4.graphics.BitmapCompat */
public final class BitmapCompat {
    static final BitmapImpl IMPL;

    /* renamed from: android.support.v4.graphics.BitmapCompat$BitmapImpl */
    interface BitmapImpl {
        int getAllocationByteCount(Bitmap bitmap);

        boolean hasMipMap(Bitmap bitmap);

        void setHasMipMap(Bitmap bitmap, boolean z);
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$BaseBitmapImpl */
    static class BaseBitmapImpl implements BitmapImpl {
        BaseBitmapImpl() {
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return false;
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$HcMr1BitmapCompatImpl */
    static class HcMr1BitmapCompatImpl extends BaseBitmapImpl {
        HcMr1BitmapCompatImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatHoneycombMr1.getAllocationByteCount(bitmap);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$JbMr2BitmapCompatImpl */
    static class JbMr2BitmapCompatImpl extends HcMr1BitmapCompatImpl {
        JbMr2BitmapCompatImpl() {
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return BitmapCompatJellybeanMR2.hasMipMap(bitmap);
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
            BitmapCompatJellybeanMR2.setHasMipMap(bitmap, z);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$KitKatBitmapCompatImpl */
    static class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl {
        KitKatBitmapCompatImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatKitKat.getAllocationByteCount(bitmap);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            IMPL = new KitKatBitmapCompatImpl();
        } else if (i >= 18) {
            IMPL = new JbMr2BitmapCompatImpl();
        } else if (i >= 12) {
            IMPL = new HcMr1BitmapCompatImpl();
        } else {
            IMPL = new BaseBitmapImpl();
        }
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        IMPL.setHasMipMap(bitmap, z);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }

    private BitmapCompat() {
    }
}
