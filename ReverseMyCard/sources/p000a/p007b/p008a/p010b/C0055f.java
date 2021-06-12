package p000a.p007b.p008a.p010b;

import java.util.Locale;
import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p009a.C0021i;
import p000a.p007b.p008a.p011c.C0068b;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.b.f */
/* compiled from: DateTimePrintContext */
final class C0055f {

    /* renamed from: a */
    private C0082e f128a;

    /* renamed from: b */
    private Locale f129b;

    /* renamed from: c */
    private C0058h f130c;

    /* renamed from: d */
    private int f131d;

    C0055f(C0082e eVar, C0025b bVar) {
        this.f128a = m322a(eVar, bVar);
        this.f129b = bVar.mo126a();
        this.f130c = bVar.mo128b();
    }

    /* renamed from: a */
    private static C0082e m322a(final C0082e eVar, C0025b bVar) {
        final C0134m mVar;
        final C0006a aVar = null;
        C0018g c = bVar.mo129c();
        C0134m d = bVar.mo130d();
        if (c == null && d == null) {
            return eVar;
        }
        C0018g gVar = (C0018g) eVar.mo17a(C0089j.m468b());
        C0134m mVar2 = (C0134m) eVar.mo17a(C0089j.m467a());
        if (C0069c.m379a((Object) gVar, (Object) c)) {
            c = null;
        }
        if (C0069c.m379a((Object) mVar2, (Object) d)) {
            d = null;
        }
        if (c == null && d == null) {
            return eVar;
        }
        final C0018g gVar2 = c != null ? c : gVar;
        if (d != null) {
            mVar = d;
        } else {
            mVar = mVar2;
        }
        if (d != null) {
            if (eVar.mo18a((C0088i) C0071a.INSTANT_SECONDS)) {
                return (gVar2 != null ? gVar2 : C0021i.f19b).mo93a(C0103e.m535a(eVar), d);
            }
            C0134m e = d.mo445e();
            C0136n nVar = (C0136n) eVar.mo17a(C0089j.m471e());
            if ((e instanceof C0136n) && nVar != null && !e.equals(nVar)) {
                throw new C0023b("Invalid override zone for temporal: " + d + " " + eVar);
            }
        }
        if (c != null) {
            if (eVar.mo18a((C0088i) C0071a.EPOCH_DAY)) {
                aVar = gVar2.mo98b(eVar);
            } else if (!(c == C0021i.f19b && gVar == null)) {
                C0071a[] values = C0071a.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    C0071a aVar2 = values[i];
                    if (!aVar2.mo253b() || !eVar.mo18a((C0088i) aVar2)) {
                        i++;
                    } else {
                        throw new C0023b("Invalid override chronology for temporal: " + c + " " + eVar);
                    }
                }
            }
        }
        return new C0068b() {
            /* renamed from: a */
            public boolean mo18a(C0088i iVar) {
                if (aVar == null || !iVar.mo253b()) {
                    return eVar.mo18a(iVar);
                }
                return aVar.mo18a(iVar);
            }

            /* renamed from: b */
            public C0100n mo66b(C0088i iVar) {
                if (aVar == null || !iVar.mo253b()) {
                    return eVar.mo66b(iVar);
                }
                return aVar.mo66b(iVar);
            }

            /* renamed from: d */
            public long mo68d(C0088i iVar) {
                if (aVar == null || !iVar.mo253b()) {
                    return eVar.mo68d(iVar);
                }
                return aVar.mo68d(iVar);
            }

            /* renamed from: a */
            public <R> R mo17a(C0097k<R> kVar) {
                if (kVar == C0089j.m468b()) {
                    return gVar2;
                }
                if (kVar == C0089j.m467a()) {
                    return mVar;
                }
                if (kVar == C0089j.m469c()) {
                    return eVar.mo17a(kVar);
                }
                return kVar.mo107b(this);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0082e mo213a() {
        return this.f128a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Locale mo216b() {
        return this.f129b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0058h mo217c() {
        return this.f130c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo218d() {
        this.f131d++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo219e() {
        this.f131d--;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <R> R mo215a(C0097k<R> kVar) {
        R a = this.f128a.mo17a(kVar);
        if (a != null || this.f131d != 0) {
            return a;
        }
        throw new C0023b("Unable to extract value: " + this.f128a.getClass());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Long mo214a(C0088i iVar) {
        try {
            return Long.valueOf(this.f128a.mo68d(iVar));
        } catch (C0023b e) {
            if (this.f131d > 0) {
                return null;
            }
            throw e;
        }
    }

    public String toString() {
        return this.f128a.toString();
    }
}
