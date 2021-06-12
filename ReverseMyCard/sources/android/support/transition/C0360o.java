package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.ViewGroup;

/* renamed from: android.support.transition.o */
/* compiled from: TransitionIcs */
class C0360o extends C0362p {

    /* renamed from: a */
    C0373y f1160a;

    /* renamed from: b */
    C0363q f1161b;

    C0360o() {
    }

    /* renamed from: a */
    public void mo1415a(C0363q qVar, Object obj) {
        this.f1161b = qVar;
        if (obj == null) {
            this.f1160a = new C0361a(qVar);
        } else {
            this.f1160a = (C0373y) obj;
        }
    }

    /* renamed from: b */
    public void mo1446b(C0325ae aeVar) {
        this.f1160a.mo1383b(aeVar);
    }

    /* renamed from: c */
    public void mo1447c(C0325ae aeVar) {
        this.f1160a.mo1377a(aeVar);
    }

    /* renamed from: a */
    public Animator mo1443a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
        return this.f1160a.mo1419a(viewGroup, aeVar, aeVar2);
    }

    /* renamed from: a */
    public C0362p mo1444a(long j) {
        this.f1160a.mo1373a(j);
        return this;
    }

    /* renamed from: a */
    public C0362p mo1445a(TimeInterpolator timeInterpolator) {
        this.f1160a.mo1374a(timeInterpolator);
        return this;
    }

    public String toString() {
        return this.f1160a.toString();
    }

    /* renamed from: android.support.transition.o$a */
    /* compiled from: TransitionIcs */
    private static class C0361a extends C0373y {

        /* renamed from: a */
        private C0363q f1162a;

        public C0361a(C0363q qVar) {
            this.f1162a = qVar;
        }

        /* renamed from: a */
        public void mo1377a(C0325ae aeVar) {
            this.f1162a.mo682a(aeVar);
        }

        /* renamed from: b */
        public void mo1383b(C0325ae aeVar) {
            this.f1162a.mo683b(aeVar);
        }

        /* renamed from: a */
        public Animator mo1419a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
            return this.f1162a.mo681a(viewGroup, aeVar, aeVar2);
        }
    }
}
