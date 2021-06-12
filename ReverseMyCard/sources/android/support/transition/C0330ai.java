package android.support.transition;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.transition.ai */
/* compiled from: Visibility */
public abstract class C0330ai extends C0358m implements C0334al {
    C0330ai(boolean z) {
        super(true);
        if (!z) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.f1159a = new C0335am();
            } else {
                this.f1159a = new C0331aj();
            }
            this.f1159a.mo1449a((C0363q) this);
        }
    }

    /* renamed from: b */
    public void mo683b(C0325ae aeVar) {
        this.f1159a.mo1446b(aeVar);
    }

    /* renamed from: a */
    public void mo682a(C0325ae aeVar) {
        this.f1159a.mo1447c(aeVar);
    }

    /* renamed from: c */
    public boolean mo1413c(C0325ae aeVar) {
        return ((C0333ak) this.f1159a).mo1416a(aeVar);
    }

    /* renamed from: a */
    public Animator mo1411a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((C0333ak) this.f1159a).mo1414a(viewGroup, aeVar, i, aeVar2, i2);
    }

    /* renamed from: b */
    public Animator mo1412b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return ((C0333ak) this.f1159a).mo1417b(viewGroup, aeVar, i, aeVar2, i2);
    }
}
