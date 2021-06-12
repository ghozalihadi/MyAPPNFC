package android.support.transition;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.transition.z */
/* compiled from: TransitionSet */
public class C0379z extends C0358m {
    public C0379z() {
        super(true);
        if (Build.VERSION.SDK_INT < 19) {
            this.f1159a = new C0319aa(this);
        } else {
            this.f1159a = new C0321ac(this);
        }
    }

    /* renamed from: a */
    public C0379z mo1473a(int i) {
        ((C0320ab) this.f1159a).mo1367b(i);
        return this;
    }

    /* renamed from: a */
    public C0379z mo1474a(C0358m mVar) {
        ((C0320ab) this.f1159a).mo1368b(mVar.f1159a);
        return this;
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
