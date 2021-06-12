package p000a.p007b.p008a;

import java.io.Serializable;
import p000a.p007b.p008a.p010b.C0025b;
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

/* renamed from: a.b.a.e */
/* compiled from: Instant */
public final class C0103e extends C0068b implements C0081d, C0083f, Serializable, Comparable<C0103e> {

    /* renamed from: a */
    public static final C0103e f283a = new C0103e(0, 0);

    /* renamed from: b */
    public static final C0103e f284b = m534a(-31557014167219200L, 0);

    /* renamed from: c */
    public static final C0103e f285c = m534a(31556889864403199L, 999999999);

    /* renamed from: d */
    public static final C0097k<C0103e> f286d = new C0097k<C0103e>() {
        /* renamed from: a */
        public C0103e mo107b(C0082e eVar) {
            return C0103e.m535a(eVar);
        }
    };

    /* renamed from: e */
    private final long f287e;

    /* renamed from: f */
    private final int f288f;

    /* renamed from: a */
    public static C0103e m532a(long j) {
        return m533a(j, 0);
    }

    /* renamed from: a */
    public static C0103e m534a(long j, long j2) {
        return m533a(C0069c.m382b(j, C0069c.m386e(j2, 1000000000)), C0069c.m381b(j2, 1000000000));
    }

    /* renamed from: b */
    public static C0103e m536b(long j) {
        return m533a(C0069c.m386e(j, 1000), C0069c.m381b(j, 1000) * 1000000);
    }

    /* renamed from: a */
    public static C0103e m535a(C0082e eVar) {
        try {
            return m534a(eVar.mo68d(C0071a.INSTANT_SECONDS), (long) eVar.mo67c(C0071a.NANO_OF_SECOND));
        } catch (C0023b e) {
            throw new C0023b("Unable to obtain Instant from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName(), e);
        }
    }

    /* renamed from: a */
    private static C0103e m533a(long j, int i) {
        if ((((long) i) | j) == 0) {
            return f283a;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new C0103e(j, i);
        }
        throw new C0023b("Instant exceeds minimum or maximum instant");
    }

    private C0103e(long j, int i) {
        this.f287e = j;
        this.f288f = i;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        boolean z = true;
        if (!(iVar instanceof C0071a)) {
            if (iVar == null || !iVar.mo250a(this)) {
                z = false;
            }
            return z;
        } else if (iVar == C0071a.INSTANT_SECONDS || iVar == C0071a.NANO_OF_SECOND || iVar == C0071a.MICRO_OF_SECOND || iVar == C0071a.MILLI_OF_SECOND) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        return super.mo66b(iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return mo66b(iVar).mo275b(iVar.mo254c(this), iVar);
        }
        switch ((C0071a) iVar) {
            case NANO_OF_SECOND:
                return this.f288f;
            case MICRO_OF_SECOND:
                return this.f288f / 1000;
            case MILLI_OF_SECOND:
                return this.f288f / 1000000;
            case INSTANT_SECONDS:
                C0071a.INSTANT_SECONDS.mo251b(this.f287e);
                break;
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        switch ((C0071a) iVar) {
            case NANO_OF_SECOND:
                return (long) this.f288f;
            case MICRO_OF_SECOND:
                return (long) (this.f288f / 1000);
            case MILLI_OF_SECOND:
                return (long) (this.f288f / 1000000);
            case INSTANT_SECONDS:
                return this.f287e;
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public long mo294a() {
        return this.f287e;
    }

    /* renamed from: b */
    public int mo298b() {
        return this.f288f;
    }

    /* renamed from: a */
    public C0103e mo21b(C0083f fVar) {
        return (C0103e) fVar.mo16a(this);
    }

    /* renamed from: a */
    public C0103e mo22b(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return (C0103e) iVar.mo247a(this, j);
        }
        C0071a aVar = (C0071a) iVar;
        aVar.mo246a(j);
        switch (aVar) {
            case NANO_OF_SECOND:
                if (j != ((long) this.f288f)) {
                    return m533a(this.f287e, (int) j);
                }
                return this;
            case MICRO_OF_SECOND:
                int i = ((int) j) * 1000;
                if (i != this.f288f) {
                    return m533a(this.f287e, i);
                }
                return this;
            case MILLI_OF_SECOND:
                int i2 = ((int) j) * 1000000;
                return i2 != this.f288f ? m533a(this.f287e, i2) : this;
            case INSTANT_SECONDS:
                if (j != this.f287e) {
                    return m533a(j, this.f288f);
                }
                return this;
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public C0103e mo30d(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return (C0103e) lVar.mo257a(this, j);
        }
        switch ((C0072b) lVar) {
            case NANOS:
                return mo304e(j);
            case MICROS:
                return m537b(j / 1000000, (j % 1000000) * 1000);
            case MILLIS:
                return mo303d(j);
            case SECONDS:
                return mo301c(j);
            case MINUTES:
                return mo301c(C0069c.m377a(j, 60));
            case HOURS:
                return mo301c(C0069c.m377a(j, 3600));
            case HALF_DAYS:
                return mo301c(C0069c.m377a(j, 43200));
            case DAYS:
                return mo301c(C0069c.m377a(j, 86400));
            default:
                throw new C0099m("Unsupported unit: " + lVar);
        }
    }

    /* renamed from: c */
    public C0103e mo301c(long j) {
        return m537b(j, 0);
    }

    /* renamed from: d */
    public C0103e mo303d(long j) {
        return m537b(j / 1000, (j % 1000) * 1000000);
    }

    /* renamed from: e */
    public C0103e mo304e(long j) {
        return m537b(0, j);
    }

    /* renamed from: b */
    private C0103e m537b(long j, long j2) {
        return (j | j2) == 0 ? this : m534a(C0069c.m382b(C0069c.m382b(this.f287e, j), j2 / 1000000000), (j2 % 1000000000) + ((long) this.f288f));
    }

    /* renamed from: b */
    public C0103e mo27c(long j, C0098l lVar) {
        return j == Long.MIN_VALUE ? mo30d(Long.MAX_VALUE, lVar).mo30d(1, lVar) : mo30d(-j, lVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m469c()) {
            return C0072b.NANOS;
        }
        if (kVar == C0089j.m472f() || kVar == C0089j.m473g() || kVar == C0089j.m468b() || kVar == C0089j.m467a() || kVar == C0089j.m470d() || kVar == C0089j.m471e()) {
            return null;
        }
        return kVar.mo107b(this);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return dVar.mo22b(C0071a.INSTANT_SECONDS, this.f287e).mo22b(C0071a.NANO_OF_SECOND, (long) this.f288f);
    }

    /* renamed from: c */
    public long mo300c() {
        return C0069c.m377a(this.f287e, 1000) + ((long) (this.f288f / 1000000));
    }

    /* renamed from: a */
    public int compareTo(C0103e eVar) {
        int a = C0069c.m376a(this.f287e, eVar.f287e);
        return a != 0 ? a : this.f288f - eVar.f288f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0103e)) {
            return false;
        }
        C0103e eVar = (C0103e) obj;
        if (this.f287e == eVar.f287e && this.f288f == eVar.f288f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((int) (this.f287e ^ (this.f287e >>> 32))) + (this.f288f * 51);
    }

    public String toString() {
        return C0025b.f42m.mo125a((C0082e) this);
    }
}
