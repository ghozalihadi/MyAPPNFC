package android.support.p016v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompatApi21 */
class ContextCompatApi21 {
    ContextCompatApi21() {
    }

    public static Drawable getDrawable(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }

    public static File getCodeCacheDir(Context context) {
        return context.getCodeCacheDir();
    }
}
