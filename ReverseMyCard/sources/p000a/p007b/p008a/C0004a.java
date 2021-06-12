package p000a.p007b.p008a;

import java.io.Serializable;

/* renamed from: a.b.a.a */
/* compiled from: Clock */
public abstract class C0004a {
    /* renamed from: b */
    public abstract C0134m mo9b();

    /* renamed from: d */
    public abstract C0103e mo11d();

    /* renamed from: a */
    public static C0004a m14a() {
        return new C0005a(C0134m.m820a());
    }

    protected C0004a() {
    }

    /* renamed from: c */
    public long mo10c() {
        return mo11d().mo300c();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: a.b.a.a$a */
    /* compiled from: Clock */
    static final class C0005a extends C0004a implements Serializable {

        /* renamed from: a */
        private final C0134m f3a;

        C0005a(C0134m mVar) {
            this.f3a = mVar;
        }

        /* renamed from: b */
        public C0134m mo9b() {
            return this.f3a;
        }

        /* renamed from: c */
        public long mo10c() {
            return System.currentTimeMillis();
        }

        /* renamed from: d */
        public C0103e mo11d() {
            return C0103e.m536b(mo10c());
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0005a) {
                return this.f3a.equals(((C0005a) obj).f3a);
            }
            return false;
        }

        public int hashCode() {
            return this.f3a.hashCode() + 1;
        }

        public String toString() {
            return "SystemClock[" + this.f3a + "]";
        }
    }
}
