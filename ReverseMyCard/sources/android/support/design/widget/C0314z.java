package android.support.design.widget;

import android.graphics.PorterDuff;
import android.os.Build;
import android.support.design.widget.C0292s;

/* renamed from: android.support.design.widget.z */
/* compiled from: ViewUtils */
class C0314z {

    /* renamed from: a */
    static final C0292s.C0298d f1091a = new C0292s.C0298d() {
        /* renamed from: a */
        public C0292s mo1337a() {
            return new C0292s(Build.VERSION.SDK_INT >= 12 ? new C0304u() : new C0302t());
        }
    };

    /* renamed from: a */
    static C0292s m1694a() {
        return f1091a.mo1337a();
    }

    /* renamed from: a */
    static boolean m1695a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    static PorterDuff.Mode m1693a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            default:
                return mode;
        }
    }
}
