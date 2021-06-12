package android.support.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.an */
/* compiled from: VisibilityPort */
abstract class C0337an extends C0373y {

    /* renamed from: a */
    private static final String[] f1114a = {"android:visibility:visibility", "android:visibility:parent"};

    C0337an() {
    }

    /* renamed from: a */
    public String[] mo1428a() {
        return f1114a;
    }

    /* renamed from: d */
    private void m1769d(C0325ae aeVar) {
        aeVar.f1101a.put("android:visibility:visibility", Integer.valueOf(aeVar.f1102b.getVisibility()));
        aeVar.f1101a.put("android:visibility:parent", aeVar.f1102b.getParent());
    }

    /* renamed from: a */
    public void mo1377a(C0325ae aeVar) {
        m1769d(aeVar);
    }

    /* renamed from: b */
    public void mo1383b(C0325ae aeVar) {
        m1769d(aeVar);
    }

    /* renamed from: c */
    public boolean mo1421c(C0325ae aeVar) {
        if (aeVar == null) {
            return false;
        }
        return ((Integer) aeVar.f1101a.get("android:visibility:visibility")).intValue() == 0 && ((View) aeVar.f1101a.get("android:visibility:parent")) != null;
    }

    /* renamed from: a */
    private C0338a m1768a(C0325ae aeVar, C0325ae aeVar2) {
        C0338a aVar = new C0338a();
        aVar.f1115a = false;
        aVar.f1116b = false;
        if (aeVar != null) {
            aVar.f1117c = ((Integer) aeVar.f1101a.get("android:visibility:visibility")).intValue();
            aVar.f1119e = (ViewGroup) aeVar.f1101a.get("android:visibility:parent");
        } else {
            aVar.f1117c = -1;
            aVar.f1119e = null;
        }
        if (aeVar2 != null) {
            aVar.f1118d = ((Integer) aeVar2.f1101a.get("android:visibility:visibility")).intValue();
            aVar.f1120f = (ViewGroup) aeVar2.f1101a.get("android:visibility:parent");
        } else {
            aVar.f1118d = -1;
            aVar.f1120f = null;
        }
        if (!(aeVar == null || aeVar2 == null)) {
            if (aVar.f1117c == aVar.f1118d && aVar.f1119e == aVar.f1120f) {
                return aVar;
            }
            if (aVar.f1117c != aVar.f1118d) {
                if (aVar.f1117c == 0) {
                    aVar.f1116b = false;
                    aVar.f1115a = true;
                } else if (aVar.f1118d == 0) {
                    aVar.f1116b = true;
                    aVar.f1115a = true;
                }
            } else if (aVar.f1119e != aVar.f1120f) {
                if (aVar.f1120f == null) {
                    aVar.f1116b = false;
                    aVar.f1115a = true;
                } else if (aVar.f1119e == null) {
                    aVar.f1116b = true;
                    aVar.f1115a = true;
                }
            }
        }
        if (aeVar == null) {
            aVar.f1116b = true;
            aVar.f1115a = true;
        } else if (aeVar2 == null) {
            aVar.f1116b = false;
            aVar.f1115a = true;
        }
        return aVar;
    }

    /* renamed from: a */
    public Animator mo1419a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
        View view;
        int i;
        boolean z;
        boolean z2 = false;
        int i2 = -1;
        C0338a a = m1768a(aeVar, aeVar2);
        if (a.f1115a) {
            if (this.f1183h.size() > 0 || this.f1182g.size() > 0) {
                View view2 = aeVar != null ? aeVar.f1102b : null;
                if (aeVar2 != null) {
                    view = aeVar2.f1102b;
                } else {
                    view = null;
                }
                if (view2 != null) {
                    i = view2.getId();
                } else {
                    i = -1;
                }
                if (view != null) {
                    i2 = view.getId();
                }
                if (mo1462a(view2, (long) i) || mo1462a(view, (long) i2)) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z;
            }
            if (!(!z2 && a.f1119e == null && a.f1120f == null)) {
                if (a.f1116b) {
                    return mo1418a(viewGroup, aeVar, a.f1117c, aeVar2, a.f1118d);
                }
                return mo1420b(viewGroup, aeVar, a.f1117c, aeVar2, a.f1118d);
            }
        }
        return null;
    }

    /* renamed from: a */
    public Animator mo1418a(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return null;
    }

    /* renamed from: b */
    public Animator mo1420b(ViewGroup viewGroup, C0325ae aeVar, int i, C0325ae aeVar2, int i2) {
        return null;
    }

    /* renamed from: android.support.transition.an$a */
    /* compiled from: VisibilityPort */
    private static class C0338a {

        /* renamed from: a */
        boolean f1115a;

        /* renamed from: b */
        boolean f1116b;

        /* renamed from: c */
        int f1117c;

        /* renamed from: d */
        int f1118d;

        /* renamed from: e */
        ViewGroup f1119e;

        /* renamed from: f */
        ViewGroup f1120f;

        C0338a() {
        }
    }
}
