package android.support.p016v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompatKitKat */
class AccessibilityEventCompatKitKat {
    AccessibilityEventCompatKitKat() {
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
