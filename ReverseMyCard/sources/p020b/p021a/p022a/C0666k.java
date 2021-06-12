package p020b.p021a.p022a;

import java.io.Serializable;
import p000a.p001a.p002a.p005b.C0002a;

/* renamed from: b.a.a.k */
/* compiled from: ServiceCode */
public class C0666k extends C0659d implements Serializable {

    /* renamed from: a */
    private final String f1274a;

    /* renamed from: b */
    private final C0667l f1275b;

    /* renamed from: c */
    private final C0668m f1276c;

    /* renamed from: d */
    private final C0669n f1277d;

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    public C0666k() {
        this((String) null);
    }

    public C0666k(String str) {
        super(str);
        this.f1274a = C0671p.f1309a.matcher(C0002a.m2a(str)).replaceAll("");
        this.f1275b = (C0667l) m1971a(0, C0667l.f1278a);
        this.f1276c = (C0668m) m1971a(1, C0668m.f1289a);
        this.f1277d = (C0669n) m1971a(2, C0669n.f1296a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0666k)) {
            return false;
        }
        C0666k kVar = (C0666k) obj;
        if (this.f1274a == null) {
            if (kVar.f1274a != null) {
                return false;
            }
            return true;
        } else if (!this.f1274a.equals(kVar.f1274a)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public String mo8064a() {
        return this.f1274a;
    }

    /* renamed from: b */
    public C0667l mo8065b() {
        return this.f1275b;
    }

    /* renamed from: c */
    public C0668m mo8066c() {
        return this.f1276c;
    }

    /* renamed from: d */
    public C0669n mo8067d() {
        return this.f1277d;
    }

    public int hashCode() {
        return (this.f1274a == null ? 0 : this.f1274a.hashCode()) + 31;
    }

    /* renamed from: e */
    public boolean mo8068e() {
        return (this.f1275b == C0667l.f1278a || this.f1276c == C0668m.f1289a || this.f1277d == C0669n.f1296a) ? false : true;
    }

    public String toString() {
        return this.f1274a;
    }

    /* renamed from: a */
    private <S extends Enum<S> & C0670o> S m1971a(int i, S s) {
        if (this.f1274a.length() > i) {
            int digit = Character.digit(this.f1274a.charAt(i), 10);
            for (S s2 : (Enum[]) s.getDeclaringClass().getEnumConstants()) {
                if (((C0670o) s2).mo8073b() == digit) {
                    return s2;
                }
            }
        }
        return s;
    }
}
