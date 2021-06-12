package android.support.design.widget;

import android.support.design.widget.C0292s;
import android.util.StateSet;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.q */
/* compiled from: StateListAnimator */
final class C0288q {

    /* renamed from: a */
    C0292s f1050a = null;

    /* renamed from: b */
    private final ArrayList<C0290a> f1051b = new ArrayList<>();

    /* renamed from: c */
    private C0290a f1052c = null;

    /* renamed from: d */
    private final C0292s.C0295a f1053d = new C0292s.C0296b() {
        /* renamed from: b */
        public void mo1125b(C0292s sVar) {
            if (C0288q.this.f1050a == sVar) {
                C0288q.this.f1050a = null;
            }
        }
    };

    C0288q() {
    }

    /* renamed from: a */
    public void mo1316a(int[] iArr, C0292s sVar) {
        C0290a aVar = new C0290a(iArr, sVar);
        sVar.mo1321a(this.f1053d);
        this.f1051b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1315a(int[] iArr) {
        C0290a aVar;
        int size = this.f1051b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f1051b.get(i);
            if (StateSet.stateSetMatches(aVar.f1055a, iArr)) {
                break;
            }
            i++;
        }
        if (aVar != this.f1052c) {
            if (this.f1052c != null) {
                m1592b();
            }
            this.f1052c = aVar;
            if (aVar != null) {
                m1591a(aVar);
            }
        }
    }

    /* renamed from: a */
    private void m1591a(C0290a aVar) {
        this.f1050a = aVar.f1056b;
        this.f1050a.mo1317a();
    }

    /* renamed from: b */
    private void m1592b() {
        if (this.f1050a != null) {
            this.f1050a.mo1327e();
            this.f1050a = null;
        }
    }

    /* renamed from: a */
    public void mo1314a() {
        if (this.f1050a != null) {
            this.f1050a.mo1329g();
            this.f1050a = null;
        }
    }

    /* renamed from: android.support.design.widget.q$a */
    /* compiled from: StateListAnimator */
    static class C0290a {

        /* renamed from: a */
        final int[] f1055a;

        /* renamed from: b */
        final C0292s f1056b;

        C0290a(int[] iArr, C0292s sVar) {
            this.f1055a = iArr;
            this.f1056b = sVar;
        }
    }
}
