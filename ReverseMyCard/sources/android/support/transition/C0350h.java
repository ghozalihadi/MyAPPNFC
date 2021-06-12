package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;

/* renamed from: android.support.transition.h */
/* compiled from: FadeIcs */
class C0350h extends C0360o implements C0333ak {
    public C0350h(C0363q qVar) {
        mo1415a(qVar, new C0352j());
    }

    public C0350h(C0363q qVar, int i) {
        mo1415a(qVar, new C0352j(i));
    }

    /* renamed from: a */
    public boolean mo1416a(C0325ae aeVar) {
        return ((C0352j) this.f1160a).mo1421c(aeVar);
    }

    /* renamed from: a */
    public Animator mo1414a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((C0352j) this.f1160a).mo1418a(viewGroup, aeVar, i, aeVar2, i2);
    }

    /* renamed from: b */
    public Animator mo1417b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((C0352j) this.f1160a).mo1420b(viewGroup, aeVar, i, aeVar, i);
    }
}
