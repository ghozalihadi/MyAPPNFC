package p000a.p007b.p008a;

import java.io.Serializable;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p009a.C0021i;
import p000a.p007b.p008a.p010b.C0025b;
import p000a.p007b.p008a.p010b.C0028c;
import p000a.p007b.p008a.p010b.C0060j;
import p000a.p007b.p008a.p011c.C0068b;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0098l;
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.l */
/* compiled from: YearMonth */
public final class C0131l extends C0068b implements C0081d, C0083f, Serializable, Comparable<C0131l> {

    /* renamed from: a */
    public static final C0097k<C0131l> f370a = new C0097k<C0131l>() {
        /* renamed from: a */
        public C0131l mo107b(C0082e eVar) {
            return C0131l.m790a(eVar);
        }
    };

    /* renamed from: b */
    private static final C0025b f371b = new C0028c().mo145a((C0088i) C0071a.YEAR, 4, 10, C0060j.EXCEEDS_PAD).mo137a('-').mo143a((C0088i) C0071a.MONTH_OF_YEAR, 2).mo161j();

    /* renamed from: c */
    private final int f372c;

    /* renamed from: d */
    private final int f373d;

    /* renamed from: a */
    public static C0131l m789a(int i, int i2) {
        C0071a.YEAR.mo246a((long) i);
        C0071a.MONTH_OF_YEAR.mo246a((long) i2);
        return new C0131l(i, i2);
    }

    /* renamed from: a */
    public static C0131l m790a(C0082e eVar) {
        if (eVar instanceof C0131l) {
            return (C0131l) eVar;
        }
        try {
            if (!C0021i.f19b.equals(C0018g.m125a(eVar))) {
                eVar = C0115f.m610a(eVar);
            }
            return m789a(eVar.mo67c(C0071a.YEAR), eVar.mo67c(C0071a.MONTH_OF_YEAR));
        } catch (C0023b e) {
            throw new C0023b("Unable to obtain YearMonth from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
        }
    }

    /* renamed from: a */
    public static C0131l m791a(CharSequence charSequence, C0025b bVar) {
        C0069c.m378a(bVar, "formatter");
        return (C0131l) bVar.mo124a(charSequence, f370a);
    }

    private C0131l(int i, int i2) {
        this.f372c = i;
        this.f373d = i2;
    }

    /* renamed from: b */
    private C0131l m792b(int i, int i2) {
        return (this.f372c == i && this.f373d == i2) ? this : new C0131l(i, i2);
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        boolean z = true;
        if (!(iVar instanceof C0071a)) {
            if (iVar == null || !iVar.mo250a(this)) {
                z = false;
            }
            return z;
        } else if (iVar == C0071a.YEAR || iVar == C0071a.MONTH_OF_YEAR || iVar == C0071a.PROLEPTIC_MONTH || iVar == C0071a.YEAR_OF_ERA || iVar == C0071a.ERA) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (iVar == C0071a.YEAR_OF_ERA) {
            return mo424a() <= 0 ? C0100n.m491a(1, 1000000000) : C0100n.m491a(1, 999999999);
        }
        return super.mo66b(iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        return mo66b(iVar).mo275b(mo68d(iVar), iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        switch ((C0071a) iVar) {
            case MONTH_OF_YEAR:
                return (long) this.f373d;
            case PROLEPTIC_MONTH:
                return m793f();
            case YEAR_OF_ERA:
                return (long) (this.f372c < 1 ? 1 - this.f372c : this.f372c);
            case YEAR:
                return (long) this.f372c;
            case ERA:
                return (long) (this.f372c < 1 ? 0 : 1);
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: f */
    private long m793f() {
        return (((long) this.f372c) * 12) + ((long) (this.f373d - 1));
    }

    /* renamed from: a */
    public int mo424a() {
        return this.f372c;
    }

    /* renamed from: b */
    public C0124i mo431b() {
        return C0124i.m747a(this.f373d);
    }

    /* renamed from: c */
    public boolean mo435c() {
        return C0021i.f19b.mo97a((long) this.f372c);
    }

    /* renamed from: d */
    public int mo437d() {
        return mo431b().mo405a(mo435c());
    }

    /* renamed from: a */
    public C0131l mo21b(C0083f fVar) {
        return (C0131l) fVar.mo16a(this);
    }

    /* renamed from: a */
    public C0131l mo22b(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return (C0131l) iVar.mo247a(this, j);
        }
        C0071a aVar = (C0071a) iVar;
        aVar.mo246a(j);
        switch (aVar) {
            case MONTH_OF_YEAR:
                return mo432b((int) j);
            case PROLEPTIC_MONTH:
                return mo433b(j - mo68d(C0071a.PROLEPTIC_MONTH));
            case YEAR_OF_ERA:
                if (this.f372c < 1) {
                    j = 1 - j;
                }
                return mo426a((int) j);
            case YEAR:
                return mo426a((int) j);
            case ERA:
                if (mo68d(C0071a.ERA) != j) {
                    return mo426a(1 - this.f372c);
                }
                return this;
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public C0131l mo426a(int i) {
        C0071a.YEAR.mo246a((long) i);
        return m792b(i, this.f373d);
    }

    /* renamed from: b */
    public C0131l mo432b(int i) {
        C0071a.MONTH_OF_YEAR.mo246a((long) i);
        return m792b(this.f372c, i);
    }

    /* renamed from: a */
    public C0131l mo30d(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return (C0131l) lVar.mo257a(this, j);
        }
        switch ((C0072b) lVar) {
            case MONTHS:
                return mo433b(j);
            case YEARS:
                return mo427a(j);
            case DECADES:
                return mo427a(C0069c.m377a(j, 10));
            case CENTURIES:
                return mo427a(C0069c.m377a(j, 100));
            case MILLENNIA:
                return mo427a(C0069c.m377a(j, 1000));
            case ERAS:
                return mo22b((C0088i) C0071a.ERA, C0069c.m382b(mo68d(C0071a.ERA), j));
            default:
                throw new C0099m("Unsupported unit: " + lVar);
        }
    }

    /* renamed from: a */
    public C0131l mo427a(long j) {
        return j == 0 ? this : m792b(C0071a.YEAR.mo251b(((long) this.f372c) + j), this.f373d);
    }

    /* renamed from: b */
    public C0131l mo433b(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.f372c) * 12) + ((long) (this.f373d - 1)) + j;
        return m792b(C0071a.YEAR.mo251b(C0069c.m386e(j2, 12)), C0069c.m381b(j2, 12) + 1);
    }

    /* renamed from: b */
    public C0131l mo27c(long j, C0098l lVar) {
        return j == Long.MIN_VALUE ? mo30d(Long.MAX_VALUE, lVar).mo30d(1, lVar) : mo30d(-j, lVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m468b()) {
            return C0021i.f19b;
        }
        if (kVar == C0089j.m469c()) {
            return C0072b.MONTHS;
        }
        if (kVar == C0089j.m472f() || kVar == C0089j.m473g() || kVar == C0089j.m470d() || kVar == C0089j.m467a() || kVar == C0089j.m471e()) {
            return null;
        }
        return super.mo17a(kVar);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        if (C0018g.m125a((C0082e) dVar).equals(C0021i.f19b)) {
            return dVar.mo22b(C0071a.PROLEPTIC_MONTH, m793f());
        }
        throw new C0023b("Adjustment only supported on ISO date-time");
    }

    /* renamed from: e */
    public C0115f mo438e() {
        return C0115f.m606a(this.f372c, this.f373d, mo437d());
    }

    /* renamed from: a */
    public int compareTo(C0131l lVar) {
        int i = this.f372c - lVar.f372c;
        if (i == 0) {
            return this.f373d - lVar.f373d;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0131l)) {
            return false;
        }
        C0131l lVar = (C0131l) obj;
        if (this.f372c == lVar.f372c && this.f373d == lVar.f373d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f372c ^ (this.f373d << 27);
    }

    public String toString() {
        String str;
        int abs = Math.abs(this.f372c);
        StringBuilder sb = new StringBuilder(9);
        if (abs >= 1000) {
            sb.append(this.f372c);
        } else if (this.f372c < 0) {
            sb.append(this.f372c - 10000).deleteCharAt(1);
        } else {
            sb.append(this.f372c + 10000).deleteCharAt(0);
        }
        if (this.f373d < 10) {
            str = "-0";
        } else {
            str = "-";
        }
        return sb.append(str).append(this.f373d).toString();
    }
}
