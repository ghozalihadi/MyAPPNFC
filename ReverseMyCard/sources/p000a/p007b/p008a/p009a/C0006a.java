package p000a.p007b.p008a.p009a;

import java.util.Comparator;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0121h;
import p000a.p007b.p008a.p011c.C0067a;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0087h;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0098l;

/* renamed from: a.b.a.a.a */
/* compiled from: ChronoLocalDate */
public abstract class C0006a extends C0067a implements C0081d, C0083f, Comparable<C0006a> {

    /* renamed from: a */
    private static final Comparator<C0006a> f4a = new Comparator<C0006a>() {
        /* renamed from: a */
        public int compare(C0006a aVar, C0006a aVar2) {
            return C0069c.m376a(aVar.mo37k(), aVar2.mo37k());
        }
    };

    /* renamed from: c */
    public abstract C0006a mo22b(C0088i iVar, long j);

    /* renamed from: f */
    public abstract C0006a mo30d(long j, C0098l lVar);

    /* renamed from: l */
    public abstract C0018g mo38l();

    /* renamed from: c */
    public C0020h mo26c() {
        return mo38l().mo94a(mo67c(C0071a.ERA));
    }

    /* renamed from: h */
    public boolean mo34h() {
        return mo38l().mo97a(mo68d(C0071a.YEAR));
    }

    /* renamed from: j */
    public int mo36j() {
        return mo34h() ? 366 : 365;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return iVar.mo253b();
        }
        return iVar != null && iVar.mo250a(this);
    }

    /* renamed from: c */
    public C0006a mo21b(C0083f fVar) {
        return mo38l().mo92a(super.mo21b(fVar));
    }

    /* renamed from: b */
    public C0006a mo28c(C0087h hVar) {
        return mo38l().mo92a(super.mo28c(hVar));
    }

    /* renamed from: e */
    public C0006a mo27c(long j, C0098l lVar) {
        return mo38l().mo92a(super.mo27c(j, lVar));
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m468b()) {
            return mo38l();
        }
        if (kVar == C0089j.m469c()) {
            return C0072b.DAYS;
        }
        if (kVar == C0089j.m472f()) {
            return C0115f.m608a(mo37k());
        }
        if (kVar == C0089j.m473g() || kVar == C0089j.m470d() || kVar == C0089j.m467a() || kVar == C0089j.m471e()) {
            return null;
        }
        return super.mo17a(kVar);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return dVar.mo22b(C0071a.EPOCH_DAY, mo37k());
    }

    /* renamed from: b */
    public C0008b<?> mo20b(C0121h hVar) {
        return C0010c.m66a(this, hVar);
    }

    /* renamed from: k */
    public long mo37k() {
        return mo68d(C0071a.EPOCH_DAY);
    }

    /* renamed from: a */
    public int compareTo(C0006a aVar) {
        int a = C0069c.m376a(mo37k(), aVar.mo37k());
        if (a == 0) {
            return mo38l().compareTo(aVar.mo38l());
        }
        return a;
    }

    /* renamed from: b */
    public boolean mo23b(C0006a aVar) {
        return mo37k() < aVar.mo37k();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0006a)) {
            return false;
        }
        if (compareTo((C0006a) obj) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long k = mo37k();
        return ((int) (k ^ (k >>> 32))) ^ mo38l().hashCode();
    }

    public String toString() {
        long d = mo68d(C0071a.YEAR_OF_ERA);
        long d2 = mo68d(C0071a.MONTH_OF_YEAR);
        long d3 = mo68d(C0071a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(mo38l().toString()).append(" ").append(mo26c()).append(" ").append(d).append(d2 < 10 ? "-0" : "-").append(d2).append(d3 < 10 ? "-0" : "-").append(d3);
        return sb.toString();
    }
}
