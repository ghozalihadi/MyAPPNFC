package android.support.transition;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.ViewGroup;

/* renamed from: android.support.transition.am */
/* compiled from: VisibilityKitKat */
class C0335am extends C0364s implements C0333ak {
    C0335am() {
    }

    /* renamed from: a */
    public void mo1415a(C0363q qVar, Object obj) {
        this.f1164b = qVar;
        if (obj == null) {
            this.f1163a = new C0336a((C0334al) qVar);
        } else {
            this.f1163a = (Visibility) obj;
        }
    }

    /* renamed from: a */
    public boolean mo1416a(C0325ae aeVar) {
        return ((Visibility) this.f1163a).isVisible(m1840d(aeVar));
    }

    /* renamed from: a */
    public Animator mo1414a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((Visibility) this.f1163a).onAppear(viewGroup, m1840d(aeVar), i, m1840d(aeVar2), i2);
    }

    /* renamed from: b */
    public Animator mo1417b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((Visibility) this.f1163a).onDisappear(viewGroup, m1840d(aeVar), i, m1840d(aeVar2), i2);
    }

    /* renamed from: android.support.transition.am$a */
    /* compiled from: VisibilityKitKat */
    private static class C0336a extends Visibility {

        /* renamed from: a */
        private final C0334al f1113a;

        C0336a(C0334al alVar) {
            this.f1113a = alVar;
        }

        public void captureStartValues(TransitionValues transitionValues) {
            C0364s.m1837a((C0363q) this.f1113a, transitionValues);
        }

        public void captureEndValues(TransitionValues transitionValues) {
            C0364s.m1839b(this.f1113a, transitionValues);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.f1113a.mo681a(viewGroup, C0364s.m1835a(transitionValues), C0364s.m1835a(transitionValues2));
        }

        public boolean isVisible(TransitionValues transitionValues) {
            if (transitionValues == null) {
                return false;
            }
            C0325ae aeVar = new C0325ae();
            C0364s.m1838a(transitionValues, aeVar);
            return this.f1113a.mo1413c(aeVar);
        }

        public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.f1113a.mo1411a(viewGroup, C0364s.m1835a(transitionValues), i, C0364s.m1835a(transitionValues2), i2);
        }

        public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.f1113a.mo1412b(viewGroup, C0364s.m1835a(transitionValues), i, C0364s.m1835a(transitionValues2), i2);
        }
    }
}
