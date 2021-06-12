package android.support.transition;

import android.os.IBinder;
import android.view.View;

/* renamed from: android.support.transition.ao */
/* compiled from: WindowIdPort */
class C0339ao {

    /* renamed from: a */
    private final IBinder f1121a;

    private C0339ao(IBinder iBinder) {
        this.f1121a = iBinder;
    }

    /* renamed from: a */
    static C0339ao m1777a(View view) {
        return new C0339ao(view.getWindowToken());
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0339ao) && ((C0339ao) obj).f1121a.equals(this.f1121a);
    }
}
