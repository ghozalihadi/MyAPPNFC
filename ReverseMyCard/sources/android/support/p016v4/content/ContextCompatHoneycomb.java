package android.support.p016v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompatHoneycomb */
class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    static void startActivities(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }

    public static File getObbDir(Context context) {
        return context.getObbDir();
    }
}
