package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;

/* renamed from: android.support.transition.s */
/* compiled from: TransitionKitKat */
class C0364s extends C0362p {

    /* renamed from: a */
    Transition f1163a;

    /* renamed from: b */
    C0363q f1164b;

    C0364s() {
    }

    /* renamed from: a */
    static void m1838a(TransitionValues transitionValues, C0325ae aeVar) {
        if (transitionValues != null) {
            aeVar.f1102b = transitionValues.view;
            if (transitionValues.values.size() > 0) {
                aeVar.f1101a.putAll(transitionValues.values);
            }
        }
    }

    /* renamed from: a */
    static void m1836a(C0325ae aeVar, TransitionValues transitionValues) {
        if (aeVar != null) {
            transitionValues.view = aeVar.f1102b;
            if (aeVar.f1101a.size() > 0) {
                transitionValues.values.putAll(aeVar.f1101a);
            }
        }
    }

    /* renamed from: a */
    static void m1837a(C0363q qVar, TransitionValues transitionValues) {
        C0325ae aeVar = new C0325ae();
        m1838a(transitionValues, aeVar);
        qVar.mo682a(aeVar);
        m1836a(aeVar, transitionValues);
    }

    /* renamed from: b */
    static void m1839b(C0363q qVar, TransitionValues transitionValues) {
        C0325ae aeVar = new C0325ae();
        m1838a(transitionValues, aeVar);
        qVar.mo683b(aeVar);
        m1836a(aeVar, transitionValues);
    }

    /* renamed from: a */
    static C0325ae m1835a(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return null;
        }
        C0325ae aeVar = new C0325ae();
        m1838a(transitionValues, aeVar);
        return aeVar;
    }

    /* renamed from: d */
    static TransitionValues m1840d(C0325ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        TransitionValues transitionValues = new TransitionValues();
        m1836a(aeVar, transitionValues);
        return transitionValues;
    }

    /* renamed from: a */
    public void mo1415a(C0363q qVar, Object obj) {
        this.f1164b = qVar;
        if (obj == null) {
            this.f1163a = new C0365a(qVar);
        } else {
            this.f1163a = (Transition) obj;
        }
    }

    /* renamed from: b */
    public void mo1446b(C0325ae aeVar) {
        TransitionValues transitionValues = new TransitionValues();
        m1836a(aeVar, transitionValues);
        this.f1163a.captureEndValues(transitionValues);
        m1838a(transitionValues, aeVar);
    }

    /* renamed from: c */
    public void mo1447c(C0325ae aeVar) {
        TransitionValues transitionValues = new TransitionValues();
        m1836a(aeVar, transitionValues);
        this.f1163a.captureStartValues(transitionValues);
        m1838a(transitionValues, aeVar);
    }

    /* renamed from: a */
    public Animator mo1443a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
        TransitionValues transitionValues;
        TransitionValues transitionValues2 = null;
        if (aeVar != null) {
            transitionValues = new TransitionValues();
            m1836a(aeVar, transitionValues);
        } else {
            transitionValues = null;
        }
        if (aeVar2 != null) {
            transitionValues2 = new TransitionValues();
            m1836a(aeVar2, transitionValues2);
        }
        return this.f1163a.createAnimator(viewGroup, transitionValues, transitionValues2);
    }

    /* renamed from: a */
    public C0362p mo1444a(long j) {
        this.f1163a.setDuration(j);
        return this;
    }

    /* renamed from: a */
    public C0362p mo1445a(TimeInterpolator timeInterpolator) {
        this.f1163a.setInterpolator(timeInterpolator);
        return this;
    }

    public String toString() {
        return this.f1163a.toString();
    }

    /* renamed from: android.support.transition.s$a */
    /* compiled from: TransitionKitKat */
    private static class C0365a extends Transition {

        /* renamed from: a */
        private C0363q f1165a;

        public C0365a(C0363q qVar) {
            this.f1165a = qVar;
        }

        public void captureStartValues(TransitionValues transitionValues) {
            C0364s.m1837a(this.f1165a, transitionValues);
        }

        public void captureEndValues(TransitionValues transitionValues) {
            C0364s.m1839b(this.f1165a, transitionValues);
        }

        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.f1165a.mo681a(viewGroup, C0364s.m1835a(transitionValues), C0364s.m1835a(transitionValues2));
        }
    }
}
