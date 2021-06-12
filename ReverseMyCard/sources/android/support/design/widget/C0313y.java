package android.support.design.widget;

import android.support.p016v4.view.ViewCompat;
import android.view.View;

/* renamed from: android.support.design.widget.y */
/* compiled from: ViewOffsetHelper */
class C0313y {

    /* renamed from: a */
    private final View f1086a;

    /* renamed from: b */
    private int f1087b;

    /* renamed from: c */
    private int f1088c;

    /* renamed from: d */
    private int f1089d;

    /* renamed from: e */
    private int f1090e;

    public C0313y(View view) {
        this.f1086a = view;
    }

    /* renamed from: a */
    public void mo1360a() {
        this.f1087b = this.f1086a.getTop();
        this.f1088c = this.f1086a.getLeft();
        m1687d();
    }

    /* renamed from: d */
    private void m1687d() {
        ViewCompat.offsetTopAndBottom(this.f1086a, this.f1089d - (this.f1086a.getTop() - this.f1087b));
        ViewCompat.offsetLeftAndRight(this.f1086a, this.f1090e - (this.f1086a.getLeft() - this.f1088c));
    }

    /* renamed from: a */
    public boolean mo1361a(int i) {
        if (this.f1089d == i) {
            return false;
        }
        this.f1089d = i;
        m1687d();
        return true;
    }

    /* renamed from: b */
    public boolean mo1363b(int i) {
        if (this.f1090e == i) {
            return false;
        }
        this.f1090e = i;
        m1687d();
        return true;
    }

    /* renamed from: b */
    public int mo1362b() {
        return this.f1089d;
    }

    /* renamed from: c */
    public int mo1364c() {
        return this.f1087b;
    }
}
