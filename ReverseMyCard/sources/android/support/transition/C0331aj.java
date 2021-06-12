package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;

/* renamed from: android.support.transition.aj */
/* compiled from: VisibilityIcs */
class C0331aj extends C0360o implements C0333ak {
    C0331aj() {
    }

    /* renamed from: a */
    public void mo1415a(C0363q qVar, Object obj) {
        this.f1161b = qVar;
        if (obj == null) {
            this.f1160a = new C0332a((C0334al) qVar);
        } else {
            this.f1160a = (C0337an) obj;
        }
    }

    /* renamed from: a */
    public boolean mo1416a(C0325ae aeVar) {
        return ((C0337an) this.f1160a).mo1421c(aeVar);
    }

    /* renamed from: a */
    public Animator mo1414a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((C0337an) this.f1160a).mo1418a(viewGroup, aeVar, i, aeVar2, i2);
    }

    /* renamed from: b */
    public Animator mo1417b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((C0337an) this.f1160a).mo1420b(viewGroup, aeVar, i, aeVar2, i2);
    }

    /* renamed from: android.support.transition.aj$a */
    /* compiled from: VisibilityIcs */
    private static class C0332a extends C0337an {

        /* renamed from: a */
        private C0334al f1112a;

        C0332a(C0334al alVar) {
            this.f1112a = alVar;
        }

        /* renamed from: a */
        public void mo1377a(C0325ae aeVar) {
            this.f1112a.mo682a(aeVar);
        }

        /* renamed from: b */
        public void mo1383b(C0325ae aeVar) {
            this.f1112a.mo683b(aeVar);
        }

        /* renamed from: a */
        public Animator mo1419a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
            return this.f1112a.mo681a(viewGroup, aeVar, aeVar2);
        }

        /* renamed from: c */
        public boolean mo1421c(C0325ae aeVar) {
            return this.f1112a.mo1413c(aeVar);
        }

        /* renamed from: a */
        public Animator mo1418a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
            return this.f1112a.mo1411a(viewGroup, aeVar, i, aeVar2, i2);
        }

        /* renamed from: b */
        public Animator mo1420b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
            return this.f1112a.mo1412b(viewGroup, aeVar, i, aeVar2, i2);
        }
    }
}
