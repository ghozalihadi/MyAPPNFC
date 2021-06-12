package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: android.support.design.widget.p */
/* compiled from: SnackbarManager */
class C0284p {

    /* renamed from: a */
    private static C0284p f1042a;

    /* renamed from: b */
    private final Object f1043b = new Object();

    /* renamed from: c */
    private final Handler f1044c = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C0284p.this.mo1307a((C0287b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* renamed from: d */
    private C0287b f1045d;

    /* renamed from: e */
    private C0287b f1046e;

    /* renamed from: android.support.design.widget.p$a */
    /* compiled from: SnackbarManager */
    interface C0286a {
        /* renamed from: a */
        void mo1035a();

        /* renamed from: a */
        void mo1036a(int i);
    }

    /* renamed from: a */
    static C0284p m1574a() {
        if (f1042a == null) {
            f1042a = new C0284p();
        }
        return f1042a;
    }

    private C0284p() {
    }

    /* renamed from: a */
    public void mo1304a(int i, C0286a aVar) {
        synchronized (this.f1043b) {
            if (m1578f(aVar)) {
                this.f1045d.f1049b = i;
                this.f1044c.removeCallbacksAndMessages(this.f1045d);
                m1577b(this.f1045d);
                return;
            }
            if (m1579g(aVar)) {
                this.f1046e.f1049b = i;
            } else {
                this.f1046e = new C0287b(i, aVar);
            }
            if (this.f1045d == null || !m1575a(this.f1045d, 4)) {
                this.f1045d = null;
                m1576b();
            }
        }
    }

    /* renamed from: a */
    public void mo1306a(C0286a aVar, int i) {
        synchronized (this.f1043b) {
            if (m1578f(aVar)) {
                m1575a(this.f1045d, i);
            } else if (m1579g(aVar)) {
                m1575a(this.f1046e, i);
            }
        }
    }

    /* renamed from: a */
    public void mo1305a(C0286a aVar) {
        synchronized (this.f1043b) {
            if (m1578f(aVar)) {
                this.f1045d = null;
                if (this.f1046e != null) {
                    m1576b();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo1308b(C0286a aVar) {
        synchronized (this.f1043b) {
            if (m1578f(aVar)) {
                m1577b(this.f1045d);
            }
        }
    }

    /* renamed from: c */
    public void mo1309c(C0286a aVar) {
        synchronized (this.f1043b) {
            if (m1578f(aVar)) {
                this.f1044c.removeCallbacksAndMessages(this.f1045d);
            }
        }
    }

    /* renamed from: d */
    public void mo1310d(C0286a aVar) {
        synchronized (this.f1043b) {
            if (m1578f(aVar)) {
                m1577b(this.f1045d);
            }
        }
    }

    /* renamed from: e */
    public boolean mo1311e(C0286a aVar) {
        boolean z;
        synchronized (this.f1043b) {
            z = m1578f(aVar) || m1579g(aVar);
        }
        return z;
    }

    /* renamed from: android.support.design.widget.p$b */
    /* compiled from: SnackbarManager */
    private static class C0287b {

        /* renamed from: a */
        final WeakReference<C0286a> f1048a;

        /* renamed from: b */
        int f1049b;

        C0287b(int i, C0286a aVar) {
            this.f1048a = new WeakReference<>(aVar);
            this.f1049b = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo1313a(C0286a aVar) {
            return aVar != null && this.f1048a.get() == aVar;
        }
    }

    /* renamed from: b */
    private void m1576b() {
        if (this.f1046e != null) {
            this.f1045d = this.f1046e;
            this.f1046e = null;
            C0286a aVar = (C0286a) this.f1045d.f1048a.get();
            if (aVar != null) {
                aVar.mo1035a();
            } else {
                this.f1045d = null;
            }
        }
    }

    /* renamed from: a */
    private boolean m1575a(C0287b bVar, int i) {
        C0286a aVar = (C0286a) bVar.f1048a.get();
        if (aVar == null) {
            return false;
        }
        this.f1044c.removeCallbacksAndMessages(bVar);
        aVar.mo1036a(i);
        return true;
    }

    /* renamed from: f */
    private boolean m1578f(C0286a aVar) {
        return this.f1045d != null && this.f1045d.mo1313a(aVar);
    }

    /* renamed from: g */
    private boolean m1579g(C0286a aVar) {
        return this.f1046e != null && this.f1046e.mo1313a(aVar);
    }

    /* renamed from: b */
    private void m1577b(C0287b bVar) {
        if (bVar.f1049b != -2) {
            int i = 2750;
            if (bVar.f1049b > 0) {
                i = bVar.f1049b;
            } else if (bVar.f1049b == -1) {
                i = 1500;
            }
            this.f1044c.removeCallbacksAndMessages(bVar);
            this.f1044c.sendMessageDelayed(Message.obtain(this.f1044c, 0, bVar), (long) i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1307a(C0287b bVar) {
        synchronized (this.f1043b) {
            if (this.f1045d == bVar || this.f1046e == bVar) {
                m1575a(bVar, 2);
            }
        }
    }
}
