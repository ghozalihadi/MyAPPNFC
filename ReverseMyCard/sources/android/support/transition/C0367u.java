package android.support.transition;

import android.support.p016v4.util.ArrayMap;
import android.support.p016v4.view.ViewCompat;
import android.support.transition.C0373y;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.transition.u */
/* compiled from: TransitionManagerPort */
class C0367u {

    /* renamed from: a */
    static ArrayList<ViewGroup> f1167a = new ArrayList<>();

    /* renamed from: b */
    private static final String[] f1168b = new String[0];

    /* renamed from: c */
    private static String f1169c = "TransitionManager";

    /* renamed from: d */
    private static C0373y f1170d = new C0340b();

    /* renamed from: e */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<C0373y>>>> f1171e = new ThreadLocal<>();

    /* renamed from: a */
    static ArrayMap<ViewGroup, ArrayList<C0373y>> m1848a() {
        WeakReference weakReference = f1171e.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference(new ArrayMap());
            f1171e.set(weakReference);
        }
        return (ArrayMap) weakReference.get();
    }

    /* renamed from: b */
    private static void m1850b(ViewGroup viewGroup, C0373y yVar) {
        if (yVar != null && viewGroup != null) {
            C0368a aVar = new C0368a(yVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    /* renamed from: c */
    private static void m1851c(ViewGroup viewGroup, C0373y yVar) {
        ArrayList arrayList = m1848a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C0373y) it.next()).mo1378a((View) viewGroup);
            }
        }
        if (yVar != null) {
            yVar.mo1460a(viewGroup, true);
        }
        C0357l a = C0357l.m1810a(viewGroup);
        if (a != null) {
            a.mo1439a();
        }
    }

    /* renamed from: a */
    public static void m1849a(ViewGroup viewGroup, C0373y yVar) {
        if (!f1167a.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            f1167a.add(viewGroup);
            if (yVar == null) {
                yVar = f1170d;
            }
            C0373y h = yVar.clone();
            m1851c(viewGroup, h);
            C0357l.m1811a(viewGroup, (C0357l) null);
            m1850b(viewGroup, h);
        }
    }

    /* renamed from: android.support.transition.u$a */
    /* compiled from: TransitionManagerPort */
    private static class C0368a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        C0373y f1172a;

        /* renamed from: b */
        ViewGroup f1173b;

        C0368a(C0373y yVar, ViewGroup viewGroup) {
            this.f1172a = yVar;
            this.f1173b = viewGroup;
        }

        /* renamed from: a */
        private void m1852a() {
            this.f1173b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1173b.removeOnAttachStateChangeListener(this);
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            m1852a();
            C0367u.f1167a.remove(this.f1173b);
            ArrayList arrayList = C0367u.m1848a().get(this.f1173b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C0373y) it.next()).mo1384b((View) this.f1173b);
                }
            }
            this.f1172a.mo1461a(true);
        }

        public boolean onPreDraw() {
            ArrayList arrayList;
            ArrayList arrayList2;
            m1852a();
            C0367u.f1167a.remove(this.f1173b);
            final ArrayMap<ViewGroup, ArrayList<C0373y>> a = C0367u.m1848a();
            ArrayList arrayList3 = a.get(this.f1173b);
            if (arrayList3 == null) {
                ArrayList arrayList4 = new ArrayList();
                a.put(this.f1173b, arrayList4);
                arrayList = arrayList4;
                arrayList2 = null;
            } else if (arrayList3.size() > 0) {
                arrayList = arrayList3;
                arrayList2 = new ArrayList(arrayList3);
            } else {
                arrayList = arrayList3;
                arrayList2 = null;
            }
            arrayList.add(this.f1172a);
            this.f1172a.mo1375a((C0373y.C0377b) new C0373y.C0378c() {
                /* renamed from: a */
                public void mo1391a(C0373y yVar) {
                    ((ArrayList) a.get(C0368a.this.f1173b)).remove(yVar);
                }
            });
            this.f1172a.mo1460a(this.f1173b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C0373y) it.next()).mo1384b((View) this.f1173b);
                }
            }
            this.f1172a.mo1459a(this.f1173b);
            return true;
        }
    }
}
