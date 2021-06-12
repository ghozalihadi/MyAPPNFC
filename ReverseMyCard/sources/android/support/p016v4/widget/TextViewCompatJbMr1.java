package android.support.p016v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.TextViewCompatJbMr1 */
class TextViewCompatJbMr1 {
    TextViewCompatJbMr1() {
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawable drawable5;
        boolean z = textView.getLayoutDirection() == 1;
        if (z) {
            drawable5 = drawable3;
        } else {
            drawable5 = drawable;
        }
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawable drawable5;
        boolean z = textView.getLayoutDirection() == 1;
        if (z) {
            drawable5 = drawable3;
        } else {
            drawable5 = drawable;
        }
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = textView.getLayoutDirection() == 1;
        if (z) {
            i5 = i3;
        } else {
            i5 = i;
        }
        if (!z) {
            i = i3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
    }

    static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }
}
