package android.support.design.internal;

import android.animation.TimeInterpolator;
import android.support.p016v4.view.animation.FastOutSlowInInterpolator;
import android.support.transition.C0318a;
import android.support.transition.C0358m;
import android.support.transition.C0366t;
import android.support.transition.C0379z;
import android.view.ViewGroup;

/* renamed from: android.support.design.internal.b */
/* compiled from: BottomNavigationAnimationHelperIcs */
class C0168b extends C0167a {

    /* renamed from: a */
    private final C0379z f534a = new C0318a();

    C0168b() {
        this.f534a.mo1473a(0);
        this.f534a.mo1440a(115);
        this.f534a.mo1441a((TimeInterpolator) new FastOutSlowInInterpolator());
        this.f534a.mo1474a((C0358m) new C0185h());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo631a(ViewGroup viewGroup) {
        C0366t.m1847a(viewGroup, this.f534a);
    }
}
