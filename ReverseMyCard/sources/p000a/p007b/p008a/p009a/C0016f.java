package p000a.p007b.p008a.p009a;

import java.io.Serializable;
import java.util.List;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0118g;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0098l;
import p000a.p007b.p008a.p013e.C0107b;
import p000a.p007b.p008a.p013e.C0111d;

/* renamed from: a.b.a.a.f */
/* compiled from: ChronoZonedDateTimeImpl */
final class C0016f<D extends C0006a> extends C0013e<D> implements Serializable {

    /* renamed from: a */
    private final C0010c<D> f11a;

    /* renamed from: b */
    private final C0136n f12b;

    /* renamed from: c */
    private final C0134m f13c;

    /* renamed from: a */
    static <R extends C0006a> C0013e<R> m114a(C0010c<R> cVar, C0134m mVar, C0136n nVar) {
        C0136n nVar2;
        C0069c.m378a(cVar, "localDateTime");
        C0069c.m378a(mVar, "zone");
        if (mVar instanceof C0136n) {
            return new C0016f(cVar, (C0136n) mVar, mVar);
        }
        C0111d d = mVar.mo444d();
        C0118g a = C0118g.m666a((C0082e) cVar);
        List<C0136n> a2 = d.mo310a(a);
        if (a2.size() == 1) {
            nVar2 = a2.get(0);
        } else if (a2.size() == 0) {
            C0107b b = d.mo313b(a);
            cVar = cVar.mo62a(b.mo328g().mo240a());
            nVar2 = b.mo327f();
        } else if (nVar == null || !a2.contains(nVar)) {
            nVar2 = a2.get(0);
        } else {
            nVar2 = nVar;
        }
        C0069c.m378a(nVar2, "offset");
        return new C0016f(cVar, nVar2, mVar);
    }

    /* renamed from: a */
    static <R extends C0006a> C0016f<R> m115a(C0018g gVar, C0103e eVar, C0134m mVar) {
        C0136n a = mVar.mo444d().mo309a(eVar);
        C0069c.m378a(a, "offset");
        return new C0016f<>((C0010c) gVar.mo100c((C0082e) C0118g.m665a(eVar.mo294a(), eVar.mo298b(), a)), a, mVar);
    }

    /* renamed from: a */
    private C0016f<D> m116a(C0103e eVar, C0134m mVar) {
        return m115a(mo84h().mo38l(), eVar, mVar);
    }

    private C0016f(C0010c<D> cVar, C0136n nVar, C0134m mVar) {
        this.f11a = (C0010c) C0069c.m378a(cVar, "dateTime");
        this.f12b = (C0136n) C0069c.m378a(nVar, "offset");
        this.f13c = (C0134m) C0069c.m378a(mVar, "zone");
    }

    /* renamed from: a */
    public C0136n mo73a() {
        return this.f12b;
    }

    /* renamed from: g */
    public C0008b<D> mo83g() {
        return this.f11a;
    }

    /* renamed from: b */
    public C0134m mo75b() {
        return this.f13c;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        return (iVar instanceof C0071a) || (iVar != null && iVar.mo250a(this));
    }

    /* renamed from: c */
    public C0013e<D> mo22b(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return mo84h().mo38l().mo101c(iVar.mo247a(this, j));
        }
        C0071a aVar = (C0071a) iVar;
        switch (aVar) {
            case INSTANT_SECONDS:
                return mo30d(j - mo86i(), C0072b.SECONDS);
            case OFFSET_SECONDS:
                return m116a(this.f11a.mo43a(C0136n.m832a(aVar.mo251b(j))), this.f13c);
            default:
                return m114a(this.f11a.mo49c(iVar, j), this.f13c, this.f12b);
        }
    }

    /* renamed from: f */
    public C0013e<D> mo30d(long j, C0098l lVar) {
        if (lVar instanceof C0072b) {
            return mo21b((C0083f) this.f11a.mo56f(j, lVar));
        }
        return mo84h().mo38l().mo101c(lVar.mo257a(this, j));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0013e)) {
            return false;
        }
        if (compareTo((C0013e<?>) (C0013e) obj) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (mo83g().hashCode() ^ mo73a().hashCode()) ^ Integer.rotateLeft(mo75b().hashCode(), 3);
    }

    public String toString() {
        String str = mo83g().toString() + mo73a().toString();
        if (mo73a() != mo75b()) {
            return str + '[' + mo75b().toString() + ']';
        }
        return str;
    }
}
