package android.support.design.widget;

import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.s */
/* compiled from: ValueAnimatorCompat */
class C0292s {

    /* renamed from: a */
    private final C0299e f1058a;

    /* renamed from: android.support.design.widget.s$a */
    /* compiled from: ValueAnimatorCompat */
    interface C0295a {
        /* renamed from: b */
        void mo1125b(C0292s sVar);

        /* renamed from: c */
        void mo1335c(C0292s sVar);

        /* renamed from: d */
        void mo1336d(C0292s sVar);
    }

    /* renamed from: android.support.design.widget.s$c */
    /* compiled from: ValueAnimatorCompat */
    interface C0297c {
        /* renamed from: a */
        void mo746a(C0292s sVar);
    }

    /* renamed from: android.support.design.widget.s$d */
    /* compiled from: ValueAnimatorCompat */
    interface C0298d {
        /* renamed from: a */
        C0292s mo1337a();
    }

    /* renamed from: android.support.design.widget.s$b */
    /* compiled from: ValueAnimatorCompat */
    static class C0296b implements C0295a {
        C0296b() {
        }

        /* renamed from: c */
        public void mo1335c(C0292s sVar) {
        }

        /* renamed from: b */
        public void mo1125b(C0292s sVar) {
        }

        /* renamed from: d */
        public void mo1336d(C0292s sVar) {
        }
    }

    /* renamed from: android.support.design.widget.s$e */
    /* compiled from: ValueAnimatorCompat */
    static abstract class C0299e {

        /* renamed from: android.support.design.widget.s$e$a */
        /* compiled from: ValueAnimatorCompat */
        interface C0300a {
            /* renamed from: a */
            void mo1332a();

            /* renamed from: b */
            void mo1333b();

            /* renamed from: c */
            void mo1334c();
        }

        /* renamed from: android.support.design.widget.s$e$b */
        /* compiled from: ValueAnimatorCompat */
        interface C0301b {
            /* renamed from: a */
            void mo1331a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo1338a();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo1339a(float f, float f2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo1340a(int i, int i2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo1341a(long j);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo1342a(C0300a aVar);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo1343a(C0301b bVar);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo1344a(Interpolator interpolator);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract boolean mo1345b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract int mo1346c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract float mo1347d();

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public abstract void mo1348e();

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public abstract float mo1349f();

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public abstract void mo1350g();

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public abstract long mo1351h();

        C0299e() {
        }
    }

    C0292s(C0299e eVar) {
        this.f1058a = eVar;
    }

    /* renamed from: a */
    public void mo1317a() {
        this.f1058a.mo1338a();
    }

    /* renamed from: b */
    public boolean mo1324b() {
        return this.f1058a.mo1345b();
    }

    /* renamed from: a */
    public void mo1323a(Interpolator interpolator) {
        this.f1058a.mo1344a(interpolator);
    }

    /* renamed from: a */
    public void mo1322a(final C0297c cVar) {
        if (cVar != null) {
            this.f1058a.mo1343a((C0299e.C0301b) new C0299e.C0301b() {
                /* renamed from: a */
                public void mo1331a() {
                    cVar.mo746a(C0292s.this);
                }
            });
        } else {
            this.f1058a.mo1343a((C0299e.C0301b) null);
        }
    }

    /* renamed from: a */
    public void mo1321a(final C0295a aVar) {
        if (aVar != null) {
            this.f1058a.mo1342a((C0299e.C0300a) new C0299e.C0300a() {
                /* renamed from: a */
                public void mo1332a() {
                    aVar.mo1335c(C0292s.this);
                }

                /* renamed from: b */
                public void mo1333b() {
                    aVar.mo1125b(C0292s.this);
                }

                /* renamed from: c */
                public void mo1334c() {
                    aVar.mo1336d(C0292s.this);
                }
            });
        } else {
            this.f1058a.mo1342a((C0299e.C0300a) null);
        }
    }

    /* renamed from: a */
    public void mo1319a(int i, int i2) {
        this.f1058a.mo1340a(i, i2);
    }

    /* renamed from: c */
    public int mo1325c() {
        return this.f1058a.mo1346c();
    }

    /* renamed from: a */
    public void mo1318a(float f, float f2) {
        this.f1058a.mo1339a(f, f2);
    }

    /* renamed from: d */
    public float mo1326d() {
        return this.f1058a.mo1347d();
    }

    /* renamed from: a */
    public void mo1320a(long j) {
        this.f1058a.mo1341a(j);
    }

    /* renamed from: e */
    public void mo1327e() {
        this.f1058a.mo1348e();
    }

    /* renamed from: f */
    public float mo1328f() {
        return this.f1058a.mo1349f();
    }

    /* renamed from: g */
    public void mo1329g() {
        this.f1058a.mo1350g();
    }

    /* renamed from: h */
    public long mo1330h() {
        return this.f1058a.mo1351h();
    }
}
