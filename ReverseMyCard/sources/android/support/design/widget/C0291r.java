package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p019v7.appcompat.C0555R;

/* renamed from: android.support.design.widget.r */
/* compiled from: ThemeUtils */
class C0291r {

    /* renamed from: a */
    private static final int[] f1057a = {C0555R.attr.colorPrimary};

    /* renamed from: a */
    static void m1597a(Context context) {
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f1057a);
        if (!obtainStyledAttributes.hasValue(0)) {
            z = true;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
