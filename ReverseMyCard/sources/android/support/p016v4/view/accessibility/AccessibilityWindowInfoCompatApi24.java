package android.support.p016v4.view.accessibility;

import android.view.accessibility.AccessibilityWindowInfo;

/* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompatApi24 */
class AccessibilityWindowInfoCompatApi24 {
    AccessibilityWindowInfoCompatApi24() {
    }

    public static CharSequence getTitle(Object obj) {
        return ((AccessibilityWindowInfo) obj).getTitle();
    }

    public static Object getAnchor(Object obj) {
        return ((AccessibilityWindowInfo) obj).getAnchor();
    }
}
