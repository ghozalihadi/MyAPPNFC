package p000a.p007b.p008a;

import java.io.Serializable;
import p000a.p007b.p008a.p009a.C0008b;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0087h;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0098l;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.g */
/* compiled from: LocalDateTime */
public final class C0118g extends C0008b<C0115f> implements C0081d, C0083f, Serializable {

    /* renamed from: a */
    public static final C0118g f326a = m668a(C0115f.f318a, C0121h.f332a);

    /* renamed from: b */
    public static final C0118g f327b = m668a(C0115f.f319b, C0121h.f333b);

    /* renamed from: c */
    public static final C0097k<C0118g> f328c = new C0097k<C0118g>() {
        /* renamed from: a */
        public C0118g mo107b(C0082e eVar) {
            return C0118g.m666a(eVar);
        }
    };

    /* renamed from: d */
    private final C0115f f329d;

    /* renamed from: e */
    private final C0121h f330e;

    /* renamed from: a */
    public static C0118g m664a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new C0118g(C0115f.m606a(i, i2, i3), C0121h.m711a(i4, i5, i6, i7));
    }

    /* renamed from: a */
    public static C0118g m668a(C0115f fVar, C0121h hVar) {
        C0069c.m378a(fVar, "date");
        C0069c.m378a(hVar, "time");
        return new C0118g(fVar, hVar);
    }

    /* renamed from: a */
    public static C0118g m665a(long j, int i, C0136n nVar) {
        C0069c.m378a(nVar, "offset");
        long f = ((long) nVar.mo452f()) + j;
        return new C0118g(C0115f.m608a(C0069c.m386e(f, 86400)), C0121h.m713a((long) C0069c.m381b(f, 86400), i));
    }

    /* renamed from: a */
    public static C0118g m666a(C0082e eVar) {
        if (eVar instanceof C0118g) {
            return (C0118g) eVar;
        }
        if (eVar instanceof C0139p) {
            return ((C0139p) eVar).mo83g();
        }
        try {
            return new C0118g(C0115f.m610a(eVar), C0121h.m714a(eVar));
        } catch (C0023b e) {
            throw new C0023b("Unable to obtain LocalDateTime from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
        }
    }

    private C0118g(C0115f fVar, C0121h hVar) {
        this.f329d = fVar;
        this.f330e = hVar;
    }

    /* renamed from: b */
    private C0118g m669b(C0115f fVar, C0121h hVar) {
        return (this.f329d == fVar && this.f330e == hVar) ? this : new C0118g(fVar, hVar);
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        boolean z = true;
        if (!(iVar instanceof C0071a)) {
            if (iVar == null || !iVar.mo250a(this)) {
                z = false;
            }
            return z;
        } else if (iVar.mo253b() || iVar.mo255c()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return iVar.mo255c() ? this.f330e.mo66b(iVar) : this.f329d.mo66b(iVar);
        }
        return iVar.mo252b(this);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return iVar.mo255c() ? this.f330e.mo67c(iVar) : this.f329d.mo67c(iVar);
        }
        return super.mo67c(iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return iVar.mo255c() ? this.f330e.mo68d(iVar) : this.f329d.mo68d(iVar);
        }
        return iVar.mo254c(this);
    }

    /* renamed from: a */
    public int mo366a() {
        return this.f329d.mo356d();
    }

    /* renamed from: b */
    public int mo373b() {
        return this.f330e.mo382a();
    }

    /* renamed from: c */
    public int mo376c() {
        return this.f330e.mo388b();
    }

    /* renamed from: a */
    public C0118g mo48c(C0083f fVar) {
        if (fVar instanceof C0115f) {
            return m669b((C0115f) fVar, this.f330e);
        }
        if (fVar instanceof C0121h) {
            return m669b(this.f329d, (C0121h) fVar);
        }
        if (fVar instanceof C0118g) {
            return (C0118g) fVar;
        }
        return (C0118g) fVar.mo16a(this);
    }

    /* renamed from: a */
    public C0118g mo49c(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return (C0118g) iVar.mo247a(this, j);
        }
        if (iVar.mo255c()) {
            return m669b(this.f329d, this.f330e.mo22b(iVar, j));
        }
        return m669b(this.f329d.mo25c(iVar, j), this.f330e);
    }

    /* renamed from: a */
    public C0118g mo28c(C0087h hVar) {
        return (C0118g) hVar.mo241a(this);
    }

    /* renamed from: a */
    public C0118g mo56f(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return (C0118g) lVar.mo257a(this, j);
        }
        switch ((C0072b) lVar) {
            case NANOS:
                return mo380e(j);
            case MICROS:
                return mo367a(j / 86400000000L).mo380e((j % 86400000000L) * 1000);
            case MILLIS:
                return mo367a(j / 86400000).mo380e((j % 86400000) * 1000000);
            case SECONDS:
                return mo379d(j);
            case MINUTES:
                return mo377c(j);
            case HOURS:
                return mo374b(j);
            case HALF_DAYS:
                return mo367a(j / 256).mo374b((j % 256) * 12);
            default:
                return m669b(this.f329d.mo33f(j, lVar), this.f330e);
        }
    }

    /* renamed from: a */
    public C0118g mo367a(long j) {
        return m669b(this.f329d.mo359e(j), this.f330e);
    }

    /* renamed from: b */
    public C0118g mo374b(long j) {
        return m667a(this.f329d, j, 0, 0, 0, 1);
    }

    /* renamed from: c */
    public C0118g mo377c(long j) {
        return m667a(this.f329d, 0, j, 0, 0, 1);
    }

    /* renamed from: d */
    public C0118g mo379d(long j) {
        return m667a(this.f329d, 0, 0, j, 0, 1);
    }

    /* renamed from: e */
    public C0118g mo380e(long j) {
        return m667a(this.f329d, 0, 0, 0, j, 1);
    }

    /* renamed from: b */
    public C0118g mo52e(long j, C0098l lVar) {
        return j == Long.MIN_VALUE ? mo56f(Long.MAX_VALUE, lVar).mo56f(1, lVar) : mo56f(-j, lVar);
    }

    /* renamed from: a */
    private C0118g m667a(C0115f fVar, long j, long j2, long j3, long j4, int i) {
        if ((j | j2 | j3 | j4) == 0) {
            return m669b(fVar, this.f330e);
        }
        long d = this.f330e.mo395d();
        long j5 = (((j4 % 86400000000000L) + ((j3 % 86400) * 1000000000) + ((j2 % 1440) * 60000000000L) + ((j % 24) * 3600000000000L)) * ((long) i)) + d;
        long e = C0069c.m386e(j5, 86400000000000L) + (((j4 / 86400000000000L) + (j3 / 86400) + (j2 / 1440) + (j / 24)) * ((long) i));
        long f = C0069c.m387f(j5, 86400000000000L);
        return m669b(fVar.mo359e(e), f == d ? this.f330e : C0121h.m716b(f));
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m472f()) {
            return mo55f();
        }
        return super.mo17a(kVar);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return super.mo16a(dVar);
    }

    /* renamed from: a */
    public C0139p mo46b(C0134m mVar) {
        return C0139p.m858a(this, mVar);
    }

    /* renamed from: d */
    public C0115f mo55f() {
        return this.f329d;
    }

    /* renamed from: e */
    public C0121h mo53e() {
        return this.f330e;
    }

    /* renamed from: a */
    public int compareTo(C0008b<?> bVar) {
        if (bVar instanceof C0118g) {
            return m663a((C0118g) bVar);
        }
        return super.compareTo(bVar);
    }

    /* renamed from: a */
    private int m663a(C0118g gVar) {
        int a = this.f329d.mo343a(gVar.mo55f());
        if (a == 0) {
            return this.f330e.compareTo(gVar.mo53e());
        }
        return a;
    }

    /* renamed from: b */
    public boolean mo47b(C0008b<?> bVar) {
        if (bVar instanceof C0118g) {
            return m663a((C0118g) bVar) > 0;
        }
        return super.mo47b(bVar);
    }

    /* renamed from: c */
    public boolean mo50c(C0008b<?> bVar) {
        if (bVar instanceof C0118g) {
            return m663a((C0118g) bVar) < 0;
        }
        return super.mo50c(bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0118g)) {
            return false;
        }
        C0118g gVar = (C0118g) obj;
        if (!this.f329d.equals(gVar.f329d) || !this.f330e.equals(gVar.f330e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f329d.hashCode() ^ this.f330e.hashCode();
    }

    public String toString() {
        return this.f329d.toString() + 'T' + this.f330e.toString();
    }
}
