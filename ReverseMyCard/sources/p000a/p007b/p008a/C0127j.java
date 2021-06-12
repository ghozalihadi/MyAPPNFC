package p000a.p007b.p008a;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import p000a.p007b.p008a.p009a.C0012d;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0098l;
import p000a.p007b.p008a.p012d.C0099m;

/* renamed from: a.b.a.j */
/* compiled from: Period */
public final class C0127j extends C0012d implements Serializable {

    /* renamed from: a */
    public static final C0127j f360a = new C0127j(0, 0, 0);

    /* renamed from: b */
    private static final Pattern f361b = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);

    /* renamed from: c */
    private final int f362c;

    /* renamed from: d */
    private final int f363d;

    /* renamed from: e */
    private final int f364e;

    /* renamed from: a */
    public static C0127j m761a(int i) {
        return m762a(0, 0, i);
    }

    /* renamed from: a */
    private static C0127j m762a(int i, int i2, int i3) {
        if ((i | i2 | i3) == 0) {
            return f360a;
        }
        return new C0127j(i, i2, i3);
    }

    private C0127j(int i, int i2, int i3) {
        this.f362c = i;
        this.f363d = i2;
        this.f364e = i3;
    }

    /* renamed from: a */
    public List<C0098l> mo70a() {
        return Collections.unmodifiableList(Arrays.asList(new C0072b[]{C0072b.YEARS, C0072b.MONTHS, C0072b.DAYS}));
    }

    /* renamed from: a */
    public long mo69a(C0098l lVar) {
        if (lVar == C0072b.YEARS) {
            return (long) this.f362c;
        }
        if (lVar == C0072b.MONTHS) {
            return (long) this.f363d;
        }
        if (lVar == C0072b.DAYS) {
            return (long) this.f364e;
        }
        throw new C0099m("Unsupported unit: " + lVar);
    }

    /* renamed from: b */
    public boolean mo71b() {
        return this == f360a;
    }

    /* renamed from: c */
    public long mo409c() {
        return (((long) this.f362c) * 12) + ((long) this.f363d);
    }

    /* renamed from: a */
    public C0081d mo241a(C0081d dVar) {
        C0069c.m378a(dVar, "temporal");
        if (this.f362c != 0) {
            if (this.f363d != 0) {
                dVar = dVar.mo30d(mo409c(), C0072b.MONTHS);
            } else {
                dVar = dVar.mo30d((long) this.f362c, C0072b.YEARS);
            }
        } else if (this.f363d != 0) {
            dVar = dVar.mo30d((long) this.f363d, C0072b.MONTHS);
        }
        if (this.f364e != 0) {
            return dVar.mo30d((long) this.f364e, C0072b.DAYS);
        }
        return dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0127j)) {
            return false;
        }
        C0127j jVar = (C0127j) obj;
        if (this.f362c == jVar.f362c && this.f363d == jVar.f363d && this.f364e == jVar.f364e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f362c + Integer.rotateLeft(this.f363d, 8) + Integer.rotateLeft(this.f364e, 16);
    }

    public String toString() {
        if (this == f360a) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        if (this.f362c != 0) {
            sb.append(this.f362c).append('Y');
        }
        if (this.f363d != 0) {
            sb.append(this.f363d).append('M');
        }
        if (this.f364e != 0) {
            sb.append(this.f364e).append('D');
        }
        return sb.toString();
    }
}
