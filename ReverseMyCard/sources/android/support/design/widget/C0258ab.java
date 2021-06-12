package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: android.support.design.widget.ab */
/* compiled from: VisibilityAwareImageButton */
class C0258ab extends ImageButton {

    /* renamed from: a */
    private int f905a;

    public C0258ab(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0258ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0258ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f905a = getVisibility();
    }

    public void setVisibility(int i) {
        mo1200a(i, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1200a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f905a = i;
        }
    }

    /* access modifiers changed from: package-private */
    public final int getUserSetVisibility() {
        return this.f905a;
    }
}
