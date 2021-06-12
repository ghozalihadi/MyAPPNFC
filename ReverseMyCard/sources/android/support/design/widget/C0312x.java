package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.design.widget.x */
/* compiled from: ViewOffsetBehavior */
class C0312x<V extends View> extends CoordinatorLayout.C0206a<V> {

    /* renamed from: a */
    private C0313y f1083a;

    /* renamed from: b */
    private int f1084b = 0;

    /* renamed from: c */
    private int f1085c = 0;

    public C0312x() {
    }

    public C0312x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo735a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo1291b(coordinatorLayout, v, i);
        if (this.f1083a == null) {
            this.f1083a = new C0313y(v);
        }
        this.f1083a.mo1360a();
        if (this.f1084b != 0) {
            this.f1083a.mo1361a(this.f1084b);
            this.f1084b = 0;
        }
        if (this.f1085c == 0) {
            return true;
        }
        this.f1083a.mo1363b(this.f1085c);
        this.f1085c = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1291b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.mo867a((View) v, i);
    }

    /* renamed from: a */
    public boolean mo729a(int i) {
        if (this.f1083a != null) {
            return this.f1083a.mo1361a(i);
        }
        this.f1084b = i;
        return false;
    }

    /* renamed from: b */
    public int mo739b() {
        if (this.f1083a != null) {
            return this.f1083a.mo1362b();
        }
        return 0;
    }
}
