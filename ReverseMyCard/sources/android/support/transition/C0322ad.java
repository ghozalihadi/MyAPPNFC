package android.support.transition;

import android.animation.TimeInterpolator;
import android.support.transition.C0373y;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.transition.ad */
/* compiled from: TransitionSetPort */
class C0322ad extends C0373y {

    /* renamed from: a */
    ArrayList<C0373y> f1094a = new ArrayList<>();

    /* renamed from: b */
    int f1095b;

    /* renamed from: c */
    boolean f1096c = false;

    /* renamed from: w */
    private boolean f1097w = true;

    /* renamed from: a */
    public C0322ad mo1371a(int i) {
        switch (i) {
            case 0:
                this.f1097w = true;
                break;
            case 1:
                this.f1097w = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    /* renamed from: a */
    public C0322ad mo1372a(C0373y yVar) {
        if (yVar != null) {
            this.f1094a.add(yVar);
            yVar.f1190o = this;
            if (this.f1180e >= 0) {
                yVar.mo1373a(this.f1180e);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C0322ad mo1373a(long j) {
        super.mo1373a(j);
        if (this.f1180e >= 0) {
            int size = this.f1094a.size();
            for (int i = 0; i < size; i++) {
                this.f1094a.get(i).mo1373a(j);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C0322ad mo1374a(TimeInterpolator timeInterpolator) {
        return (C0322ad) super.mo1374a(timeInterpolator);
    }

    /* renamed from: c */
    public C0322ad mo1375a(C0373y.C0377b bVar) {
        return (C0322ad) super.mo1375a(bVar);
    }

    /* renamed from: d */
    public C0322ad mo1382b(C0373y.C0377b bVar) {
        return (C0322ad) super.mo1382b(bVar);
    }

    /* renamed from: k */
    private void m1707k() {
        C0324a aVar = new C0324a(this);
        Iterator<C0373y> it = this.f1094a.iterator();
        while (it.hasNext()) {
            it.next().mo1375a((C0373y.C0377b) aVar);
        }
        this.f1095b = this.f1094a.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1379a(ViewGroup viewGroup, C0326af afVar, C0326af afVar2) {
        Iterator<C0373y> it = this.f1094a.iterator();
        while (it.hasNext()) {
            it.next().mo1379a(viewGroup, afVar, afVar2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1388e() {
        if (this.f1094a.isEmpty()) {
            mo1466f();
            mo1467g();
            return;
        }
        m1707k();
        if (!this.f1097w) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.f1094a.size()) {
                    break;
                }
                final C0373y yVar = this.f1094a.get(i2);
                this.f1094a.get(i2 - 1).mo1375a((C0373y.C0377b) new C0373y.C0378c() {
                    /* renamed from: a */
                    public void mo1391a(C0373y yVar) {
                        yVar.mo1388e();
                        yVar.mo1382b((C0373y.C0377b) this);
                    }
                });
                i = i2 + 1;
            }
            C0373y yVar2 = this.f1094a.get(0);
            if (yVar2 != null) {
                yVar2.mo1388e();
                return;
            }
            return;
        }
        Iterator<C0373y> it = this.f1094a.iterator();
        while (it.hasNext()) {
            it.next().mo1388e();
        }
    }

    /* renamed from: a */
    public void mo1377a(C0325ae aeVar) {
        int id = aeVar.f1102b.getId();
        if (mo1462a(aeVar.f1102b, (long) id)) {
            Iterator<C0373y> it = this.f1094a.iterator();
            while (it.hasNext()) {
                C0373y next = it.next();
                if (next.mo1462a(aeVar.f1102b, (long) id)) {
                    next.mo1377a(aeVar);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo1383b(C0325ae aeVar) {
        int id = aeVar.f1102b.getId();
        if (mo1462a(aeVar.f1102b, (long) id)) {
            Iterator<C0373y> it = this.f1094a.iterator();
            while (it.hasNext()) {
                C0373y next = it.next();
                if (next.mo1462a(aeVar.f1102b, (long) id)) {
                    next.mo1383b(aeVar);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1378a(View view) {
        super.mo1378a(view);
        int size = this.f1094a.size();
        for (int i = 0; i < size; i++) {
            this.f1094a.get(i).mo1378a(view);
        }
    }

    /* renamed from: b */
    public void mo1384b(View view) {
        super.mo1384b(view);
        int size = this.f1094a.size();
        for (int i = 0; i < size; i++) {
            this.f1094a.get(i).mo1384b(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo1376a(String str) {
        String a = super.mo1376a(str);
        int i = 0;
        while (i < this.f1094a.size()) {
            String str2 = a + "\n" + this.f1094a.get(i).mo1376a(str + "  ");
            i++;
            a = str2;
        }
        return a;
    }

    /* renamed from: j */
    public C0322ad mo1389h() {
        C0322ad adVar = (C0322ad) super.clone();
        adVar.f1094a = new ArrayList<>();
        int size = this.f1094a.size();
        for (int i = 0; i < size; i++) {
            adVar.mo1372a(this.f1094a.get(i).clone());
        }
        return adVar;
    }

    /* renamed from: android.support.transition.ad$a */
    /* compiled from: TransitionSetPort */
    static class C0324a extends C0373y.C0378c {

        /* renamed from: a */
        C0322ad f1100a;

        C0324a(C0322ad adVar) {
            this.f1100a = adVar;
        }

        /* renamed from: d */
        public void mo1392d(C0373y yVar) {
            if (!this.f1100a.f1096c) {
                this.f1100a.mo1466f();
                this.f1100a.f1096c = true;
            }
        }

        /* renamed from: a */
        public void mo1391a(C0373y yVar) {
            C0322ad adVar = this.f1100a;
            adVar.f1095b--;
            if (this.f1100a.f1095b == 0) {
                this.f1100a.f1096c = false;
                this.f1100a.mo1467g();
            }
            yVar.mo1382b((C0373y.C0377b) this);
        }
    }
}
