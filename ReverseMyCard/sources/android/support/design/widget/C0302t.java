package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.C0292s;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.t */
/* compiled from: ValueAnimatorCompatImplGingerbread */
class C0302t extends C0292s.C0299e {

    /* renamed from: a */
    private static final Handler f1063a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private long f1064b;

    /* renamed from: c */
    private boolean f1065c;

    /* renamed from: d */
    private float f1066d;

    /* renamed from: e */
    private final int[] f1067e = new int[2];

    /* renamed from: f */
    private final float[] f1068f = new float[2];

    /* renamed from: g */
    private long f1069g = 200;

    /* renamed from: h */
    private Interpolator f1070h;

    /* renamed from: i */
    private ArrayList<C0292s.C0299e.C0300a> f1071i;

    /* renamed from: j */
    private ArrayList<C0292s.C0299e.C0301b> f1072j;

    /* renamed from: k */
    private final Runnable f1073k = new Runnable() {
        public void run() {
            C0302t.this.mo1353j();
        }
    };

    C0302t() {
    }

    /* renamed from: a */
    public void mo1338a() {
        if (!this.f1065c) {
            if (this.f1070h == null) {
                this.f1070h = new AccelerateDecelerateInterpolator();
            }
            this.f1065c = true;
            this.f1066d = 0.0f;
            mo1352i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo1352i() {
        this.f1064b = SystemClock.uptimeMillis();
        m1642k();
        m1643l();
        f1063a.postDelayed(this.f1073k, 10);
    }

    /* renamed from: b */
    public boolean mo1345b() {
        return this.f1065c;
    }

    /* renamed from: a */
    public void mo1344a(Interpolator interpolator) {
        this.f1070h = interpolator;
    }

    /* renamed from: a */
    public void mo1342a(C0292s.C0299e.C0300a aVar) {
        if (this.f1071i == null) {
            this.f1071i = new ArrayList<>();
        }
        this.f1071i.add(aVar);
    }

    /* renamed from: a */
    public void mo1343a(C0292s.C0299e.C0301b bVar) {
        if (this.f1072j == null) {
            this.f1072j = new ArrayList<>();
        }
        this.f1072j.add(bVar);
    }

    /* renamed from: a */
    public void mo1340a(int i, int i2) {
        this.f1067e[0] = i;
        this.f1067e[1] = i2;
    }

    /* renamed from: c */
    public int mo1346c() {
        return C0255a.m1401a(this.f1067e[0], this.f1067e[1], mo1349f());
    }

    /* renamed from: a */
    public void mo1339a(float f, float f2) {
        this.f1068f[0] = f;
        this.f1068f[1] = f2;
    }

    /* renamed from: d */
    public float mo1347d() {
        return C0255a.m1400a(this.f1068f[0], this.f1068f[1], mo1349f());
    }

    /* renamed from: a */
    public void mo1341a(long j) {
        this.f1069g = j;
    }

    /* renamed from: e */
    public void mo1348e() {
        this.f1065c = false;
        f1063a.removeCallbacks(this.f1073k);
        m1644m();
        m1645n();
    }

    /* renamed from: f */
    public float mo1349f() {
        return this.f1066d;
    }

    /* renamed from: g */
    public void mo1350g() {
        if (this.f1065c) {
            this.f1065c = false;
            f1063a.removeCallbacks(this.f1073k);
            this.f1066d = 1.0f;
            m1642k();
            m1645n();
        }
    }

    /* renamed from: h */
    public long mo1351h() {
        return this.f1069g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final void mo1353j() {
        if (this.f1065c) {
            float a = C0281m.m1557a(((float) (SystemClock.uptimeMillis() - this.f1064b)) / ((float) this.f1069g), 0.0f, 1.0f);
            if (this.f1070h != null) {
                a = this.f1070h.getInterpolation(a);
            }
            this.f1066d = a;
            m1642k();
            if (SystemClock.uptimeMillis() >= this.f1064b + this.f1069g) {
                this.f1065c = false;
                m1645n();
            }
        }
        if (this.f1065c) {
            f1063a.postDelayed(this.f1073k, 10);
        }
    }

    /* renamed from: k */
    private void m1642k() {
        if (this.f1072j != null) {
            int size = this.f1072j.size();
            for (int i = 0; i < size; i++) {
                this.f1072j.get(i).mo1331a();
            }
        }
    }

    /* renamed from: l */
    private void m1643l() {
        if (this.f1071i != null) {
            int size = this.f1071i.size();
            for (int i = 0; i < size; i++) {
                this.f1071i.get(i).mo1332a();
            }
        }
    }

    /* renamed from: m */
    private void m1644m() {
        if (this.f1071i != null) {
            int size = this.f1071i.size();
            for (int i = 0; i < size; i++) {
                this.f1071i.get(i).mo1334c();
            }
        }
    }

    /* renamed from: n */
    private void m1645n() {
        if (this.f1071i != null) {
            int size = this.f1071i.size();
            for (int i = 0; i < size; i++) {
                this.f1071i.get(i).mo1333b();
            }
        }
    }
}
