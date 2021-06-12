package p000a.p007b.p008a.p009a;

import java.io.Serializable;
import p000a.p007b.p008a.C0121h;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0098l;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.a.c */
/* compiled from: ChronoLocalDateTimeImpl */
final class C0010c<D extends C0006a> extends C0008b<D> implements C0081d, C0083f, Serializable {

    /* renamed from: a */
    private final D f6a;

    /* renamed from: b */
    private final C0121h f7b;

    /* renamed from: a */
    static <R extends C0006a> C0010c<R> m66a(R r, C0121h hVar) {
        return new C0010c<>(r, hVar);
    }

    private C0010c(D d, C0121h hVar) {
        C0069c.m378a(d, "date");
        C0069c.m378a(hVar, "time");
        this.f6a = d;
        this.f7b = hVar;
    }

    /* renamed from: a */
    private C0010c<D> m67a(C0081d dVar, C0121h hVar) {
        return (this.f6a == dVar && this.f7b == hVar) ? this : new C0010c<>(this.f6a.mo38l().mo92a(dVar), hVar);
    }

    /* renamed from: f */
    public D mo55f() {
        return this.f6a;
    }

    /* renamed from: e */
    public C0121h mo53e() {
        return this.f7b;
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
            return iVar.mo255c() ? this.f7b.mo66b(iVar) : this.f6a.mo66b(iVar);
        }
        return iVar.mo252b(this);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return iVar.mo255c() ? this.f7b.mo67c(iVar) : this.f6a.mo67c(iVar);
        }
        return mo66b(iVar).mo275b(mo68d(iVar), iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return iVar.mo255c() ? this.f7b.mo68d(iVar) : this.f6a.mo68d(iVar);
        }
        return iVar.mo254c(this);
    }

    /* renamed from: a */
    public C0010c<D> mo48c(C0083f fVar) {
        if (fVar instanceof C0006a) {
            return m67a((C0081d) (C0006a) fVar, this.f7b);
        }
        if (fVar instanceof C0121h) {
            return m67a((C0081d) this.f6a, (C0121h) fVar);
        }
        if (fVar instanceof C0010c) {
            return this.f6a.mo38l().mo99b((C0081d) (C0010c) fVar);
        }
        return this.f6a.mo38l().mo99b((C0081d) (C0010c) fVar.mo16a(this));
    }

    /* renamed from: a */
    public C0010c<D> mo49c(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return this.f6a.mo38l().mo99b(iVar.mo247a(this, j));
        }
        if (iVar.mo255c()) {
            return m67a((C0081d) this.f6a, this.f7b.mo22b(iVar, j));
        }
        return m67a((C0081d) this.f6a.mo22b(iVar, j), this.f7b);
    }

    /* renamed from: a */
    public C0010c<D> mo56f(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return this.f6a.mo38l().mo99b(lVar.mo257a(this, j));
        }
        switch ((C0072b) lVar) {
            case NANOS:
                return m71e(j);
            case MICROS:
                return m68b(j / 86400000000L).m71e((j % 86400000000L) * 1000);
            case MILLIS:
                return m68b(j / 86400000).m71e((j % 86400000) * 1000000);
            case SECONDS:
                return mo62a(j);
            case MINUTES:
                return m70d(j);
            case HOURS:
                return m69c(j);
            case HALF_DAYS:
                return m68b(j / 256).m69c((j % 256) * 12);
            default:
                return m67a((C0081d) this.f6a.mo30d(j, lVar), this.f7b);
        }
    }

    /* renamed from: b */
    private C0010c<D> m68b(long j) {
        return m67a((C0081d) this.f6a.mo30d(j, C0072b.DAYS), this.f7b);
    }

    /* renamed from: c */
    private C0010c<D> m69c(long j) {
        return m65a(this.f6a, j, 0, 0, 0);
    }

    /* renamed from: d */
    private C0010c<D> m70d(long j) {
        return m65a(this.f6a, 0, j, 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0010c<D> mo62a(long j) {
        return m65a(this.f6a, 0, 0, j, 0);
    }

    /* renamed from: e */
    private C0010c<D> m71e(long j) {
        return m65a(this.f6a, 0, 0, 0, j);
    }

    /* renamed from: a */
    private C0010c<D> m65a(D d, long j, long j2, long j3, long j4) {
        if ((j | j2 | j3 | j4) == 0) {
            return m67a((C0081d) d, this.f7b);
        }
        long d2 = this.f7b.mo395d();
        long j5 = (j4 % 86400000000000L) + ((j3 % 86400) * 1000000000) + ((j2 % 1440) * 60000000000L) + ((j % 24) * 3600000000000L) + d2;
        long e = C0069c.m386e(j5, 86400000000000L) + (j4 / 86400000000000L) + (j3 / 86400) + (j2 / 1440) + (j / 24);
        long f = C0069c.m387f(j5, 86400000000000L);
        return m67a((C0081d) d.mo30d(e, C0072b.DAYS), f == d2 ? this.f7b : C0121h.m716b(f));
    }

    /* renamed from: b */
    public C0013e<D> mo46b(C0134m mVar) {
        return C0016f.m114a(this, mVar, (C0136n) null);
    }
}
