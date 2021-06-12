package android.support.design.widget;

import android.graphics.Outline;

/* renamed from: android.support.design.widget.c */
/* compiled from: CircularBorderDrawableLollipop */
class C0260c extends C0259b {
    C0260c() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.f907b);
        outline.setOval(this.f907b);
    }
}
