package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.support.p016v4.util.ArrayMap;
import android.support.p016v4.util.LongSparseArray;
import android.support.p016v4.util.SimpleArrayMap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.transition.y */
/* compiled from: TransitionPort */
abstract class C0373y implements Cloneable {

    /* renamed from: a */
    private static ThreadLocal<ArrayMap<Animator, C0376a>> f1176a = new ThreadLocal<>();

    /* renamed from: b */
    private String f1177b = getClass().getName();

    /* renamed from: c */
    private C0326af f1178c = new C0326af();

    /* renamed from: d */
    long f1179d = -1;

    /* renamed from: e */
    long f1180e = -1;

    /* renamed from: f */
    TimeInterpolator f1181f = null;

    /* renamed from: g */
    ArrayList<Integer> f1182g = new ArrayList<>();

    /* renamed from: h */
    ArrayList<View> f1183h = new ArrayList<>();

    /* renamed from: i */
    ArrayList<Integer> f1184i = null;

    /* renamed from: j */
    ArrayList<View> f1185j = null;

    /* renamed from: k */
    ArrayList<Class> f1186k = null;

    /* renamed from: l */
    ArrayList<Integer> f1187l = null;

    /* renamed from: m */
    ArrayList<View> f1188m = null;

    /* renamed from: n */
    ArrayList<Class> f1189n = null;

    /* renamed from: o */
    C0322ad f1190o = null;

    /* renamed from: p */
    ViewGroup f1191p = null;

    /* renamed from: q */
    boolean f1192q = false;

    /* renamed from: r */
    int f1193r = 0;

    /* renamed from: s */
    boolean f1194s = false;

    /* renamed from: t */
    ArrayList<C0377b> f1195t = null;

    /* renamed from: u */
    ArrayList<Animator> f1196u = new ArrayList<>();

    /* renamed from: v */
    ArrayList<Animator> f1197v = new ArrayList<>();

    /* renamed from: w */
    private C0326af f1198w = new C0326af();

    /* renamed from: x */
    private boolean f1199x = false;

    /* renamed from: android.support.transition.y$b */
    /* compiled from: TransitionPort */
    public interface C0377b {
        /* renamed from: a */
        void mo1391a(C0373y yVar);

        /* renamed from: b */
        void mo1430b(C0373y yVar);

        /* renamed from: c */
        void mo1431c(C0373y yVar);

        /* renamed from: d */
        void mo1392d(C0373y yVar);
    }

    /* renamed from: a */
    public abstract void mo1377a(C0325ae aeVar);

    /* renamed from: b */
    public abstract void mo1383b(C0325ae aeVar);

    /* renamed from: j */
    private static ArrayMap<Animator, C0376a> mo1390j() {
        ArrayMap<Animator, C0376a> arrayMap = f1176a.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, C0376a> arrayMap2 = new ArrayMap<>();
        f1176a.set(arrayMap2);
        return arrayMap2;
    }

    /* renamed from: b */
    public long mo1463b() {
        return this.f1180e;
    }

    /* renamed from: a */
    public C0373y mo1373a(long j) {
        this.f1180e = j;
        return this;
    }

    /* renamed from: c */
    public long mo1464c() {
        return this.f1179d;
    }

    /* renamed from: d */
    public TimeInterpolator mo1465d() {
        return this.f1181f;
    }

    /* renamed from: a */
    public C0373y mo1374a(TimeInterpolator timeInterpolator) {
        this.f1181f = timeInterpolator;
        return this;
    }

    /* renamed from: a */
    public String[] mo1428a() {
        return null;
    }

    /* renamed from: a */
    public Animator mo1419a(ViewGroup viewGroup, C0325ae aeVar, C0325ae aeVar2) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1379a(ViewGroup viewGroup, C0326af afVar, C0326af afVar2) {
        Animator a;
        View view;
        C0325ae aeVar;
        Animator animator;
        C0325ae aeVar2;
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) afVar2.f1103a);
        SparseArray sparseArray = new SparseArray(afVar2.f1104b.size());
        for (int i = 0; i < afVar2.f1104b.size(); i++) {
            sparseArray.put(afVar2.f1104b.keyAt(i), afVar2.f1104b.valueAt(i));
        }
        LongSparseArray longSparseArray = new LongSparseArray(afVar2.f1105c.size());
        for (int i2 = 0; i2 < afVar2.f1105c.size(); i2++) {
            longSparseArray.put(afVar2.f1105c.keyAt(i2), afVar2.f1105c.valueAt(i2));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View next : afVar.f1103a.keySet()) {
            boolean z = false;
            if (next.getParent() instanceof ListView) {
                z = true;
            }
            if (!z) {
                int id = next.getId();
                C0325ae aeVar3 = afVar.f1103a.get(next) != null ? afVar.f1103a.get(next) : afVar.f1104b.get(id);
                if (afVar2.f1103a.get(next) != null) {
                    aeVar2 = afVar2.f1103a.get(next);
                    arrayMap.remove(next);
                } else if (id != -1) {
                    aeVar2 = afVar2.f1104b.get(id);
                    View view2 = null;
                    for (View view3 : arrayMap.keySet()) {
                        if (view3.getId() != id) {
                            view3 = view2;
                        }
                        view2 = view3;
                    }
                    if (view2 != null) {
                        arrayMap.remove(view2);
                    }
                } else {
                    aeVar2 = null;
                }
                sparseArray.remove(id);
                if (mo1462a(next, (long) id)) {
                    arrayList.add(aeVar3);
                    arrayList2.add(aeVar2);
                }
            } else {
                ListView listView = (ListView) next.getParent();
                if (listView.getAdapter().hasStableIds()) {
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(next));
                    longSparseArray.remove(itemIdAtPosition);
                    arrayList.add(afVar.f1105c.get(itemIdAtPosition));
                    arrayList2.add((Object) null);
                }
            }
        }
        int size = afVar.f1105c.size();
        for (int i3 = 0; i3 < size; i3++) {
            long keyAt = afVar.f1105c.keyAt(i3);
            if (mo1462a((View) null, keyAt)) {
                longSparseArray.remove(keyAt);
                arrayList.add(afVar.f1105c.get(keyAt));
                arrayList2.add(afVar2.f1105c.get(keyAt));
            }
        }
        for (View view4 : arrayMap.keySet()) {
            int id2 = view4.getId();
            if (mo1462a(view4, (long) id2)) {
                Object obj = afVar.f1103a.get(view4) != null ? afVar.f1103a.get(view4) : afVar.f1104b.get(id2);
                sparseArray.remove(id2);
                arrayList.add((C0325ae) obj);
                arrayList2.add((C0325ae) arrayMap.get(view4));
            }
        }
        int size2 = sparseArray.size();
        for (int i4 = 0; i4 < size2; i4++) {
            int keyAt2 = sparseArray.keyAt(i4);
            if (mo1462a((View) null, (long) keyAt2)) {
                arrayList.add(afVar.f1104b.get(keyAt2));
                arrayList2.add((C0325ae) sparseArray.get(keyAt2));
            }
        }
        int size3 = longSparseArray.size();
        for (int i5 = 0; i5 < size3; i5++) {
            long keyAt3 = longSparseArray.keyAt(i5);
            arrayList.add(afVar.f1105c.get(keyAt3));
            arrayList2.add((C0325ae) longSparseArray.get(keyAt3));
        }
        ArrayMap<Animator, C0376a> j = mo1390j();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < arrayList.size()) {
                C0325ae aeVar4 = (C0325ae) arrayList.get(i7);
                C0325ae aeVar5 = (C0325ae) arrayList2.get(i7);
                if (!(aeVar4 == null && aeVar5 == null) && ((aeVar4 == null || !aeVar4.equals(aeVar5)) && (a = mo1419a(viewGroup, aeVar4, aeVar5)) != null)) {
                    if (aeVar5 != null) {
                        View view5 = aeVar5.f1102b;
                        String[] a2 = mo1428a();
                        if (view5 != null && a2 != null && a2.length > 0) {
                            C0325ae aeVar6 = new C0325ae();
                            aeVar6.f1102b = view5;
                            C0325ae aeVar7 = afVar2.f1103a.get(view5);
                            if (aeVar7 != null) {
                                for (int i8 = 0; i8 < a2.length; i8++) {
                                    aeVar6.f1101a.put(a2[i8], aeVar7.f1101a.get(a2[i8]));
                                }
                            }
                            int size4 = j.size();
                            int i9 = 0;
                            while (true) {
                                if (i9 >= size4) {
                                    aeVar = aeVar6;
                                    animator = a;
                                    break;
                                }
                                C0376a aVar = j.get(j.keyAt(i9));
                                if (aVar.f1205c != null && aVar.f1203a == view5 && (((aVar.f1204b == null && mo1468i() == null) || aVar.f1204b.equals(mo1468i())) && aVar.f1205c.equals(aeVar6))) {
                                    animator = null;
                                    aeVar = aeVar6;
                                    break;
                                }
                                i9++;
                            }
                        } else {
                            aeVar = null;
                            animator = a;
                        }
                        a = animator;
                        view = view5;
                    } else {
                        view = aeVar4.f1102b;
                        aeVar = null;
                    }
                    if (a != null) {
                        j.put(a, new C0376a(view, mo1468i(), C0339ao.m1777a(viewGroup), aeVar));
                        this.f1196u.add(a);
                    }
                }
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1462a(View view, long j) {
        if (this.f1184i != null && this.f1184i.contains(Integer.valueOf((int) j))) {
            return false;
        }
        if (this.f1185j != null && this.f1185j.contains(view)) {
            return false;
        }
        if (!(this.f1186k == null || view == null)) {
            int size = this.f1186k.size();
            for (int i = 0; i < size; i++) {
                if (this.f1186k.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f1182g.size() == 0 && this.f1183h.size() == 0) {
            return true;
        }
        if (this.f1182g.size() > 0) {
            for (int i2 = 0; i2 < this.f1182g.size(); i2++) {
                if (((long) this.f1182g.get(i2).intValue()) == j) {
                    return true;
                }
            }
        }
        if (view == null || this.f1183h.size() <= 0) {
            return false;
        }
        for (int i3 = 0; i3 < this.f1183h.size(); i3++) {
            if (this.f1183h.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1388e() {
        mo1466f();
        ArrayMap<Animator, C0376a> j = mo1390j();
        Iterator<Animator> it = this.f1196u.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (j.containsKey(next)) {
                mo1466f();
                m1857a(next, j);
            }
        }
        this.f1196u.clear();
        mo1467g();
    }

    /* renamed from: a */
    private void m1857a(Animator animator, final ArrayMap<Animator, C0376a> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    C0373y.this.f1197v.add(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    C0373y.this.f1197v.remove(animator);
                }
            });
            mo1458a(animator);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1460a(ViewGroup viewGroup, boolean z) {
        mo1461a(z);
        if (this.f1182g.size() > 0 || this.f1183h.size() > 0) {
            if (this.f1182g.size() > 0) {
                for (int i = 0; i < this.f1182g.size(); i++) {
                    int intValue = this.f1182g.get(i).intValue();
                    View findViewById = viewGroup.findViewById(intValue);
                    if (findViewById != null) {
                        C0325ae aeVar = new C0325ae();
                        aeVar.f1102b = findViewById;
                        if (z) {
                            mo1377a(aeVar);
                        } else {
                            mo1383b(aeVar);
                        }
                        if (z) {
                            this.f1178c.f1103a.put(findViewById, aeVar);
                            if (intValue >= 0) {
                                this.f1178c.f1104b.put(intValue, aeVar);
                            }
                        } else {
                            this.f1198w.f1103a.put(findViewById, aeVar);
                            if (intValue >= 0) {
                                this.f1198w.f1104b.put(intValue, aeVar);
                            }
                        }
                    }
                }
            }
            if (this.f1183h.size() > 0) {
                for (int i2 = 0; i2 < this.f1183h.size(); i2++) {
                    View view = this.f1183h.get(i2);
                    if (view != null) {
                        C0325ae aeVar2 = new C0325ae();
                        aeVar2.f1102b = view;
                        if (z) {
                            mo1377a(aeVar2);
                        } else {
                            mo1383b(aeVar2);
                        }
                        if (z) {
                            this.f1178c.f1103a.put(view, aeVar2);
                        } else {
                            this.f1198w.f1103a.put(view, aeVar2);
                        }
                    }
                }
                return;
            }
            return;
        }
        m1858a((View) viewGroup, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1461a(boolean z) {
        if (z) {
            this.f1178c.f1103a.clear();
            this.f1178c.f1104b.clear();
            this.f1178c.f1105c.clear();
            return;
        }
        this.f1198w.f1103a.clear();
        this.f1198w.f1104b.clear();
        this.f1198w.f1105c.clear();
    }

    /* renamed from: a */
    private void m1858a(View view, boolean z) {
        boolean z2;
        int i;
        long itemIdAtPosition;
        if (view != null) {
            if (view.getParent() instanceof ListView) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || ((ListView) view.getParent()).getAdapter().hasStableIds()) {
                if (!z2) {
                    i = view.getId();
                    itemIdAtPosition = -1;
                } else {
                    ListView listView = (ListView) view.getParent();
                    i = -1;
                    itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                }
                if (this.f1184i != null && this.f1184i.contains(Integer.valueOf(i))) {
                    return;
                }
                if (this.f1185j == null || !this.f1185j.contains(view)) {
                    if (!(this.f1186k == null || view == null)) {
                        int size = this.f1186k.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.f1186k.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    C0325ae aeVar = new C0325ae();
                    aeVar.f1102b = view;
                    if (z) {
                        mo1377a(aeVar);
                    } else {
                        mo1383b(aeVar);
                    }
                    if (z) {
                        if (!z2) {
                            this.f1178c.f1103a.put(view, aeVar);
                            if (i >= 0) {
                                this.f1178c.f1104b.put(i, aeVar);
                            }
                        } else {
                            this.f1178c.f1105c.put(itemIdAtPosition, aeVar);
                        }
                    } else if (!z2) {
                        this.f1198w.f1103a.put(view, aeVar);
                        if (i >= 0) {
                            this.f1198w.f1104b.put(i, aeVar);
                        }
                    } else {
                        this.f1198w.f1105c.put(itemIdAtPosition, aeVar);
                    }
                    if (!(view instanceof ViewGroup)) {
                        return;
                    }
                    if (this.f1187l != null && this.f1187l.contains(Integer.valueOf(i))) {
                        return;
                    }
                    if (this.f1188m == null || !this.f1188m.contains(view)) {
                        if (!(this.f1189n == null || view == null)) {
                            int size2 = this.f1189n.size();
                            int i3 = 0;
                            while (i3 < size2) {
                                if (!this.f1189n.get(i3).isInstance(view)) {
                                    i3++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                            m1858a(viewGroup.getChildAt(i4), z);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1378a(View view) {
        if (!this.f1199x) {
            ArrayMap<Animator, C0376a> j = mo1390j();
            int size = j.size();
            C0339ao a = C0339ao.m1777a(view);
            for (int i = size - 1; i >= 0; i--) {
                C0376a valueAt = j.valueAt(i);
                if (valueAt.f1203a != null && a.equals(valueAt.f1206d)) {
                    j.keyAt(i).cancel();
                }
            }
            if (this.f1195t != null && this.f1195t.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f1195t.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C0377b) arrayList.get(i2)).mo1430b(this);
                }
            }
            this.f1194s = true;
        }
    }

    /* renamed from: b */
    public void mo1384b(View view) {
        if (this.f1194s) {
            if (!this.f1199x) {
                ArrayMap<Animator, C0376a> j = mo1390j();
                int size = j.size();
                C0339ao a = C0339ao.m1777a(view);
                for (int i = size - 1; i >= 0; i--) {
                    C0376a valueAt = j.valueAt(i);
                    if (valueAt.f1203a != null && a.equals(valueAt.f1206d)) {
                        j.keyAt(i).end();
                    }
                }
                if (this.f1195t != null && this.f1195t.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.f1195t.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((C0377b) arrayList.get(i2)).mo1431c(this);
                    }
                }
            }
            this.f1194s = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1459a(ViewGroup viewGroup) {
        C0376a aVar;
        C0325ae aeVar;
        boolean z;
        ArrayMap<Animator, C0376a> j = mo1390j();
        for (int size = j.size() - 1; size >= 0; size--) {
            Animator keyAt = j.keyAt(size);
            if (!(keyAt == null || (aVar = j.get(keyAt)) == null || aVar.f1203a == null || aVar.f1203a.getContext() != viewGroup.getContext())) {
                C0325ae aeVar2 = aVar.f1205c;
                View view = aVar.f1203a;
                C0325ae aeVar3 = this.f1198w.f1103a != null ? this.f1198w.f1103a.get(view) : null;
                if (aeVar3 == null) {
                    aeVar = this.f1198w.f1104b.get(view.getId());
                } else {
                    aeVar = aeVar3;
                }
                if (aeVar2 != null && aeVar != null) {
                    Iterator<String> it = aeVar2.f1101a.keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        Object obj = aeVar2.f1101a.get(next);
                        Object obj2 = aeVar.f1101a.get(next);
                        if (obj != null && obj2 != null && !obj.equals(obj2)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        j.remove(keyAt);
                    }
                }
            }
        }
        mo1379a(viewGroup, this.f1178c, this.f1198w);
        mo1388e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1458a(Animator animator) {
        if (animator == null) {
            mo1467g();
            return;
        }
        if (mo1463b() >= 0) {
            animator.setDuration(mo1463b());
        }
        if (mo1464c() >= 0) {
            animator.setStartDelay(mo1464c());
        }
        if (mo1465d() != null) {
            animator.setInterpolator(mo1465d());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                C0373y.this.mo1467g();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo1466f() {
        if (this.f1193r == 0) {
            if (this.f1195t != null && this.f1195t.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f1195t.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C0377b) arrayList.get(i)).mo1392d(this);
                }
            }
            this.f1199x = false;
        }
        this.f1193r++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo1467g() {
        this.f1193r--;
        if (this.f1193r == 0) {
            if (this.f1195t != null && this.f1195t.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f1195t.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C0377b) arrayList.get(i)).mo1391a(this);
                }
            }
            for (int i2 = 0; i2 < this.f1178c.f1105c.size(); i2++) {
                View view = this.f1178c.f1105c.valueAt(i2).f1102b;
            }
            for (int i3 = 0; i3 < this.f1198w.f1105c.size(); i3++) {
                View view2 = this.f1198w.f1105c.valueAt(i3).f1102b;
            }
            this.f1199x = true;
        }
    }

    /* renamed from: a */
    public C0373y mo1375a(C0377b bVar) {
        if (this.f1195t == null) {
            this.f1195t = new ArrayList<>();
        }
        this.f1195t.add(bVar);
        return this;
    }

    /* renamed from: b */
    public C0373y mo1382b(C0377b bVar) {
        if (this.f1195t != null) {
            this.f1195t.remove(bVar);
            if (this.f1195t.size() == 0) {
                this.f1195t = null;
            }
        }
        return this;
    }

    public String toString() {
        return mo1376a("");
    }

    /* renamed from: h */
    public C0373y clone() {
        try {
            C0373y yVar = (C0373y) super.clone();
            try {
                yVar.f1196u = new ArrayList<>();
                yVar.f1178c = new C0326af();
                yVar.f1198w = new C0326af();
                return yVar;
            } catch (CloneNotSupportedException e) {
                return yVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: i */
    public String mo1468i() {
        return this.f1177b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo1376a(String str) {
        String str2;
        String str3 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f1180e != -1) {
            str3 = str3 + "dur(" + this.f1180e + ") ";
        }
        if (this.f1179d != -1) {
            str3 = str3 + "dly(" + this.f1179d + ") ";
        }
        if (this.f1181f != null) {
            str3 = str3 + "interp(" + this.f1181f + ") ";
        }
        if (this.f1182g.size() <= 0 && this.f1183h.size() <= 0) {
            return str3;
        }
        String str4 = str3 + "tgts(";
        if (this.f1182g.size() > 0) {
            str2 = str4;
            for (int i = 0; i < this.f1182g.size(); i++) {
                if (i > 0) {
                    str2 = str2 + ", ";
                }
                str2 = str2 + this.f1182g.get(i);
            }
        } else {
            str2 = str4;
        }
        if (this.f1183h.size() > 0) {
            for (int i2 = 0; i2 < this.f1183h.size(); i2++) {
                if (i2 > 0) {
                    str2 = str2 + ", ";
                }
                str2 = str2 + this.f1183h.get(i2);
            }
        }
        return str2 + ")";
    }

    /* renamed from: android.support.transition.y$c */
    /* compiled from: TransitionPort */
    public static class C0378c implements C0377b {
        /* renamed from: d */
        public void mo1392d(C0373y yVar) {
        }

        /* renamed from: a */
        public void mo1391a(C0373y yVar) {
        }

        /* renamed from: b */
        public void mo1430b(C0373y yVar) {
        }

        /* renamed from: c */
        public void mo1431c(C0373y yVar) {
        }
    }

    /* renamed from: android.support.transition.y$a */
    /* compiled from: TransitionPort */
    private static class C0376a {

        /* renamed from: a */
        View f1203a;

        /* renamed from: b */
        String f1204b;

        /* renamed from: c */
        C0325ae f1205c;

        /* renamed from: d */
        C0339ao f1206d;

        C0376a(View view, String str, C0339ao aoVar, C0325ae aeVar) {
            this.f1203a = view;
            this.f1204b = str;
            this.f1205c = aeVar;
            this.f1206d = aoVar;
        }
    }
}
