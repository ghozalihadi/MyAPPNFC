package android.support.p016v4.text;

import android.text.TextUtils;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextUtilsCompatJellybeanMr1 */
class TextUtilsCompatJellybeanMr1 {
    TextUtilsCompatJellybeanMr1() {
    }

    public static String htmlEncode(String str) {
        return TextUtils.htmlEncode(str);
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
