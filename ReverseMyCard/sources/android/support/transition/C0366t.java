package android.support.transition;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.transition.t */
/* compiled from: TransitionManager */
public class C0366t {

    /* renamed from: a */
    private static C0371w f1166a;

    static {
        if (Build.VERSION.SDK_INT < 19) {
            f1166a = new C0370v();
        } else {
            f1166a = new C0372x();
        }
    }

    /* renamed from: a */
    public static void m1847a(ViewGroup viewGroup, C0358m mVar) {
        f1166a.mo1457a(viewGroup, mVar == null ? null : mVar.f1159a);
    }
}
