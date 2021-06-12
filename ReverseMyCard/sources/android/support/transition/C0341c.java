package android.support.transition;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.transition.c */
/* compiled from: ChangeBounds */
public class C0341c extends C0358m {
    public C0341c() {
        super(true);
        if (Build.VERSION.SDK_INT < 19) {
            this.f1159a = new C0342d(this);
        } else {
            this.f1159a = new C0343e(this);
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

    /* renamed from: a */
    public Animator mo681a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
        return this.f1159a.mo1443a(viewGroup, aeVar, aeVar2);
    }
}
