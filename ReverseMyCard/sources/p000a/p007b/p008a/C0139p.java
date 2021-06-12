package p000a.p007b.p008a;

import java.io.Serializable;
import java.util.List;
import p000a.p007b.p008a.p009a.C0013e;
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
import p000a.p007b.p008a.p013e.C0107b;
import p000a.p007b.p008a.p013e.C0111d;

/* renamed from: a.b.a.p */
/* compiled from: ZonedDateTime */
public final class C0139p extends C0013e<C0115f> implements C0081d, Serializable {

    /* renamed from: a */
    public static final C0097k<C0139p> f389a = new C0097k<C0139p>() {
        /* renamed from: a */
        public C0139p mo107b(C0082e eVar) {
            return C0139p.m855a(eVar);
        }
    };

    /* renamed from: b */
    private final C0118g f390b;

    /* renamed from: c */
    private final C0136n f391c;

    /* renamed from: d */
    private final C0134m f392d;

    /* renamed from: a */
    public static C0139p m858a(C0118g gVar, C0134m mVar) {
        return m859a(gVar, mVar, (C0136n) null);
    }

    /* renamed from: a */
    public static C0139p m859a(C0118g gVar, C0134m mVar, C0136n nVar) {
        C0136n nVar2;
        C0069c.m378a(gVar, "localDateTime");
        C0069c.m378a(mVar, "zone");
        if (mVar instanceof C0136n) {
            return new C0139p(gVar, (C0136n) mVar, mVar);
        }
        C0111d d = mVar.mo444d();
        List<C0136n> a = d.mo310a(gVar);
        if (a.size() == 1) {
            nVar2 = a.get(0);
        } else if (a.size() == 0) {
            C0107b b = d.mo313b(gVar);
            gVar = gVar.mo379d(b.mo328g().mo240a());
            nVar2 = b.mo327f();
        } else if (nVar == null || !a.contains(nVar)) {
            nVar2 = (C0136n) C0069c.m378a(a.get(0), "offset");
        } else {
            nVar2 = nVar;
        }
        return new C0139p(gVar, nVar2, mVar);
    }

    /* renamed from: a */
    public static C0139p m856a(C0103e eVar, C0134m mVar) {
        C0069c.m378a(eVar, "instant");
        C0069c.m378a(mVar, "zone");
        return m854a(eVar.mo294a(), eVar.mo298b(), mVar);
    }

    /* renamed from: a */
    public static C0139p m860a(C0118g gVar, C0136n nVar, C0134m mVar) {
        C0069c.m378a(gVar, "localDateTime");
        C0069c.m378a(nVar, "offset");
        C0069c.m378a(mVar, "zone");
        return m854a(gVar.mo44b(nVar), gVar.mo376c(), mVar);
    }

    /* renamed from: a */
    private static C0139p m854a(long j, int i, C0134m mVar) {
        C0136n a = mVar.mo444d().mo309a(C0103e.m534a(j, (long) i));
        return new C0139p(C0118g.m665a(j, i, a), a, mVar);
    }

    /* renamed from: a */
    public static C0139p m855a(C0082e eVar) {
        if (eVar instanceof C0139p) {
            return (C0139p) eVar;
        }
        try {
            C0134m a = C0134m.m821a(eVar);
            if (eVar.mo18a((C0088i) C0071a.INSTANT_SECONDS)) {
                try {
                    return m854a(eVar.mo68d(C0071a.INSTANT_SECONDS), eVar.mo67c(C0071a.NANO_OF_SECOND), a);
                } catch (C0023b e) {
                }
            }
            return m858a(C0118g.m666a(eVar), a);
        } catch (C0023b e2) {
            throw new C0023b("Unable to obtain ZonedDateTime from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
        }
    }

    private C0139p(C0118g gVar, C0136n nVar, C0134m mVar) {
        this.f390b = gVar;
        this.f391c = nVar;
        this.f392d = mVar;
    }

    /* renamed from: a */
    private C0139p m857a(C0118g gVar) {
        return m859a(gVar, this.f392d, this.f391c);
    }

    /* renamed from: b */
    private C0139p m862b(C0118g gVar) {
        return m860a(gVar, this.f391c, this.f392d);
    }

    /* renamed from: a */
    private C0139p m861a(C0136n nVar) {
        if (nVar.equals(this.f391c) || !this.f392d.mo444d().mo312a(this.f390b, nVar)) {
            return this;
        }
        return new C0139p(this.f390b, nVar, this.f392d);
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        return (iVar instanceof C0071a) || (iVar != null && iVar.mo250a(this));
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        if (iVar == C0071a.INSTANT_SECONDS || iVar == C0071a.OFFSET_SECONDS) {
            return iVar.mo249a();
        }
        return this.f390b.mo66b(iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return super.mo67c(iVar);
        }
        switch ((C0071a) iVar) {
            case INSTANT_SECONDS:
                throw new C0023b("Field too large for an int: " + iVar);
            case OFFSET_SECONDS:
                return mo73a().mo452f();
            default:
                return this.f390b.mo67c(iVar);
        }
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        switch ((C0071a) iVar) {
            case INSTANT_SECONDS:
                return mo86i();
            case OFFSET_SECONDS:
                return (long) mo73a().mo452f();
            default:
                return this.f390b.mo68d(iVar);
        }
    }

    /* renamed from: a */
    public C0136n mo73a() {
        return this.f391c;
    }

    /* renamed from: b */
    public C0134m mo75b() {
        return this.f392d;
    }

    /* renamed from: c */
    public int mo459c() {
        return this.f390b.mo376c();
    }

    /* renamed from: a */
    public C0139p mo76c(C0083f fVar) {
        if (fVar instanceof C0115f) {
            return m857a(C0118g.m668a((C0115f) fVar, this.f390b.mo53e()));
        }
        if (fVar instanceof C0121h) {
            return m857a(C0118g.m668a(this.f390b.mo55f(), (C0121h) fVar));
        }
        if (fVar instanceof C0118g) {
            return m857a((C0118g) fVar);
        }
        if (fVar instanceof C0103e) {
            C0103e eVar = (C0103e) fVar;
            return m854a(eVar.mo294a(), eVar.mo298b(), this.f392d);
        } else if (fVar instanceof C0136n) {
            return m861a((C0136n) fVar);
        } else {
            return (C0139p) fVar.mo16a(this);
        }
    }

    /* renamed from: a */
    public C0139p mo77c(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return (C0139p) iVar.mo247a(this, j);
        }
        C0071a aVar = (C0071a) iVar;
        switch (aVar) {
            case INSTANT_SECONDS:
                return m854a(j, mo459c(), this.f392d);
            case OFFSET_SECONDS:
                return m861a(C0136n.m832a(aVar.mo251b(j)));
            default:
                return m857a(this.f390b.mo49c(iVar, j));
        }
    }

    /* renamed from: a */
    public C0139p mo28c(C0087h hVar) {
        return (C0139p) hVar.mo241a(this);
    }

    /* renamed from: a */
    public C0139p mo81f(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return (C0139p) lVar.mo257a(this, j);
        }
        if (lVar.mo258a()) {
            return m857a(this.f390b.mo56f(j, lVar));
        }
        return m862b(this.f390b.mo56f(j, lVar));
    }

    /* renamed from: b */
    public C0139p mo79e(long j, C0098l lVar) {
        return j == Long.MIN_VALUE ? mo81f(Long.MAX_VALUE, lVar).mo81f(1, lVar) : mo81f(-j, lVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m472f()) {
            return mo84h();
        }
        return super.mo17a(kVar);
    }

    /* renamed from: d */
    public C0118g mo83g() {
        return this.f390b;
    }

    /* renamed from: e */
    public C0115f mo84h() {
        return this.f390b.mo55f();
    }

    /* renamed from: f */
    public C0121h mo82f() {
        return this.f390b.mo53e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0139p)) {
            return false;
        }
        C0139p pVar = (C0139p) obj;
        if (!this.f390b.equals(pVar.f390b) || !this.f391c.equals(pVar.f391c) || !this.f392d.equals(pVar.f392d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f390b.hashCode() ^ this.f391c.hashCode()) ^ Integer.rotateLeft(this.f392d.hashCode(), 3);
    }

    public String toString() {
        String str = this.f390b.toString() + this.f391c.toString();
        if (this.f391c != this.f392d) {
            return str + '[' + this.f392d.toString() + ']';
        }
        return str;
    }
}
