package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.transition.m */
/* compiled from: Transition */
public abstract class C0358m implements C0363q {

    /* renamed from: a */
    C0362p f1159a;

    public C0358m() {
        this(false);
    }

    C0358m(boolean z) {
        if (!z) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f1159a = new C0359n();
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.f1159a = new C0364s();
            } else {
                this.f1159a = new C0360o();
            }
            this.f1159a.mo1449a((C0363q) this);
        }
    }

    /* renamed from: a */
    public Animator mo681a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
        return null;
    }

    /* renamed from: a */
    public C0358m mo1440a(long j) {
        this.f1159a.mo1444a(j);
        return this;
    }

    /* renamed from: a */
    public C0358m mo1441a(TimeInterpolator timeInterpolator) {
        this.f1159a.mo1445a(timeInterpolator);
        return this;
    }

    public String toString() {
        return this.f1159a.toString();
    }
}
