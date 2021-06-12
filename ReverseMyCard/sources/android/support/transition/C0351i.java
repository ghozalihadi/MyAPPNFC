package android.support.transition;

import android.animation.Animator;
import android.transition.Fade;
import android.view.ViewGroup;

/* renamed from: android.support.transition.i */
/* compiled from: FadeKitKat */
class C0351i extends C0364s implements C0333ak {
    public C0351i(C0363q qVar) {
        mo1415a(qVar, (Object) new Fade());
    }

    public C0351i(C0363q qVar, int i) {
        mo1415a(qVar, (Object) new Fade(i));
    }

    /* renamed from: a */
    public boolean mo1416a(C0325ae aeVar) {
        return ((Fade) this.f1163a).isVisible(m1840d(aeVar));
    }

    /* renamed from: a */
    public Animator mo1414a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((Fade) this.f1163a).onAppear(viewGroup, m1840d(aeVar), i, m1840d(aeVar2), i2);
    }

    /* renamed from: b */
    public Animator mo1417b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((Fade) this.f1163a).onDisappear(viewGroup, m1840d(aeVar), i, m1840d(aeVar2), i2);
    }
}
