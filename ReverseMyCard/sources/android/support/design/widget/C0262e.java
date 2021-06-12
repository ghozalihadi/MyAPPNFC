package android.support.design.widget;

import android.support.p016v4.util.Pools;
import android.support.p016v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.design.widget.e */
/* compiled from: DirectedAcyclicGraph */
final class C0262e<T> {

    /* renamed from: a */
    private final Pools.Pool<ArrayList<T>> f964a = new Pools.SimplePool(10);

    /* renamed from: b */
    private final SimpleArrayMap<T, ArrayList<T>> f965b = new SimpleArrayMap<>();

    /* renamed from: c */
    private final ArrayList<T> f966c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f967d = new HashSet<>();

    C0262e() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1245a(T t) {
        if (!this.f965b.containsKey(t)) {
            this.f965b.put(t, null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo1248b(T t) {
        return this.f965b.containsKey(t);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1246a(T t, T t2) {
        if (!this.f965b.containsKey(t) || !this.f965b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f965b.get(t);
        if (arrayList == null) {
            arrayList = m1458c();
            this.f965b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public List mo1249c(T t) {
        return this.f965b.get(t);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public List mo1250d(T t) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        int size = this.f965b.size();
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f965b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList2 == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = arrayList2;
                }
                arrayList.add(this.f965b.keyAt(i));
                arrayList2 = arrayList;
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo1251e(T t) {
        int size = this.f965b.size();
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f965b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1244a() {
        int size = this.f965b.size();
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f965b.valueAt(i);
            if (valueAt != null) {
                m1457a(valueAt);
            }
        }
        this.f965b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList<T> mo1247b() {
        this.f966c.clear();
        this.f967d.clear();
        int size = this.f965b.size();
        for (int i = 0; i < size; i++) {
            m1456a(this.f965b.keyAt(i), this.f966c, this.f967d);
        }
        return this.f966c;
    }

    /* renamed from: a */
    private void m1456a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = this.f965b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m1456a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    /* renamed from: c */
    private ArrayList<T> m1458c() {
        ArrayList<T> acquire = this.f964a.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    /* renamed from: a */
    private void m1457a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f964a.release(arrayList);
    }
}
