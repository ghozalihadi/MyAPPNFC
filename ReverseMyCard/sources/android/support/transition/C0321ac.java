package android.support.transition;

import android.transition.TransitionSet;

/* renamed from: android.support.transition.ac */
/* compiled from: TransitionSetKitKat */
class C0321ac extends C0364s implements C0320ab {

    /* renamed from: c */
    private TransitionSet f1093c = new TransitionSet();

    public C0321ac(C0363q qVar) {
        mo1415a(qVar, (Object) this.f1093c);
    }

    /* renamed from: a */
    public C0321ac mo1367b(int i) {
        this.f1093c.setOrdering(i);
        return this;
    }

    /* renamed from: a */
    public C0321ac mo1368b(C0362p pVar) {
        this.f1093c.addTransition(((C0364s) pVar).f1163a);
        return this;
    }
}
