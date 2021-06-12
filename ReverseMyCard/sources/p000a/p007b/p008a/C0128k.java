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

/* renamed from: a.b.a.k */
/* compiled from: Year */
public final class C0128k extends C0068b implements C0081d, C0083f, Serializable, Comparable<C0128k> {

    /* renamed from: a */
    public static final C0097k<C0128k> f365a = new C0097k<C0128k>() {
        /* renamed from: a */
        public C0128k mo107b(C0082e eVar) {
            return C0128k.m769a(eVar);
        }
    };

    /* renamed from: b */
    private static final C0025b f366b = new C0028c().mo145a((C0088i) C0071a.YEAR, 4, 10, C0060j.EXCEEDS_PAD).mo161j();

    /* renamed from: c */
    private final int f367c;

    /* renamed from: a */
    public static C0128k m768a(int i) {
        C0071a.YEAR.mo246a((long) i);
        return new C0128k(i);
    }

    /* renamed from: a */
    public static C0128k m769a(C0082e eVar) {
        if (eVar instanceof C0128k) {
            return (C0128k) eVar;
        }
        try {
            if (!C0021i.f19b.equals(C0018g.m125a(eVar))) {
                eVar = C0115f.m610a(eVar);
            }
            return m768a(eVar.mo67c(C0071a.YEAR));
        } catch (C0023b e) {
            throw new C0023b("Unable to obtain Year from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
        }
    }

    /* renamed from: a */
    public static boolean m770a(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    private C0128k(int i) {
        this.f367c = i;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        boolean z = true;
        if (!(iVar instanceof C0071a)) {
            if (iVar == null || !iVar.mo250a(this)) {
                z = false;
            }
            return z;
        } else if (iVar == C0071a.YEAR || iVar == C0071a.YEAR_OF_ERA || iVar == C0071a.ERA) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (iVar == C0071a.YEAR_OF_ERA) {
            return this.f367c <= 0 ? C0100n.m491a(1, 1000000000) : C0100n.m491a(1, 999999999);
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
            case YEAR_OF_ERA:
                return (long) (this.f367c < 1 ? 1 - this.f367c : this.f367c);
            case YEAR:
                return (long) this.f367c;
            case ERA:
                return (long) (this.f367c < 1 ? 0 : 1);
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public C0128k mo21b(C0083f fVar) {
        return (C0128k) fVar.mo16a(this);
    }

    /* renamed from: a */
    public C0128k mo22b(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return (C0128k) iVar.mo247a(this, j);
        }
        C0071a aVar = (C0071a) iVar;
        aVar.mo246a(j);
        switch (aVar) {
            case YEAR_OF_ERA:
                if (this.f367c < 1) {
                    j = 1 - j;
                }
                return m768a((int) j);
            case YEAR:
                return m768a((int) j);
            case ERA:
                if (mo68d(C0071a.ERA) != j) {
                    return m768a(1 - this.f367c);
                }
                return this;
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public C0128k mo30d(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return (C0128k) lVar.mo257a(this, j);
        }
        switch ((C0072b) lVar) {
            case YEARS:
                return mo417b(j);
            case DECADES:
                return mo417b(C0069c.m377a(j, 10));
            case CENTURIES:
                return mo417b(C0069c.m377a(j, 100));
            case MILLENNIA:
                return mo417b(C0069c.m377a(j, 1000));
            case ERAS:
                return mo22b((C0088i) C0071a.ERA, C0069c.m382b(mo68d(C0071a.ERA), j));
            default:
                throw new C0099m("Unsupported unit: " + lVar);
        }
    }

    /* renamed from: b */
    public C0128k mo417b(long j) {
        return j == 0 ? this : m768a(C0071a.YEAR.mo251b(((long) this.f367c) + j));
    }

    /* renamed from: b */
    public C0128k mo27c(long j, C0098l lVar) {
        return j == Long.MIN_VALUE ? mo30d(Long.MAX_VALUE, lVar).mo30d(1, lVar) : mo30d(-j, lVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m468b()) {
            return C0021i.f19b;
        }
        if (kVar == C0089j.m469c()) {
            return C0072b.YEARS;
        }
        if (kVar == C0089j.m472f() || kVar == C0089j.m473g() || kVar == C0089j.m470d() || kVar == C0089j.m467a() || kVar == C0089j.m471e()) {
            return null;
        }
        return super.mo17a(kVar);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        if (C0018g.m125a((C0082e) dVar).equals(C0021i.f19b)) {
            return dVar.mo22b(C0071a.YEAR, (long) this.f367c);
        }
        throw new C0023b("Adjustment only supported on ISO date-time");
    }

    /* renamed from: a */
    public int compareTo(C0128k kVar) {
        return this.f367c - kVar.f367c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0128k)) {
            return false;
        }
        if (this.f367c != ((C0128k) obj).f367c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f367c;
    }

    public String toString() {
        return Integer.toString(this.f367c);
    }
}
