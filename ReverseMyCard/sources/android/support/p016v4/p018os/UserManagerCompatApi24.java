package android.support.p016v4.p018os;

import android.content.Context;
import android.os.UserManager;

/* renamed from: android.support.v4.os.UserManagerCompatApi24 */
public class UserManagerCompatApi24 {
    public static boolean isUserUnlocked(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
