package android.support.transition;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.transition.g */
/* compiled from: Fade */
public class C0349g extends C0330ai {
    public C0349g(int i) {
        super(true);
        if (Build.VERSION.SDK_INT >= 19) {
            if (i > 0) {
                this.f1159a = new C0351i(this, i);
            } else {
                this.f1159a = new C0351i(this);
            }
        } else if (i > 0) {
            this.f1159a = new C0350h(this, i);
        } else {
            this.f1159a = new C0350h(this);
        }
    }

    public C0349g() {
        this(-1);
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
