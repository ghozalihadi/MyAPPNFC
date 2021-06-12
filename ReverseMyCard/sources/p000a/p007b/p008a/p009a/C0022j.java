package p000a.p007b.p008a.p009a;

import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.a.j */
/* compiled from: IsoEra */
public enum C0022j implements C0020h {
    BCE,
    CE;

    /* renamed from: a */
    public static C0022j m153a(int i) {
        switch (i) {
            case 0:
                return BCE;
            case 1:
                return CE;
            default:
                throw new C0023b("Invalid era: " + i);
        }
    }

    /* renamed from: a */
    public int mo114a() {
        return ordinal();
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        if (iVar instanceof C0071a) {
            if (iVar == C0071a.ERA) {
                return true;
            }
            return false;
        } else if (iVar == null || !iVar.mo250a(this)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (iVar == C0071a.ERA) {
            return iVar.mo249a();
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar == C0071a.ERA) {
            return mo114a();
        }
        return mo66b(iVar).mo275b(mo68d(iVar), iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (iVar == C0071a.ERA) {
            return (long) mo114a();
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return dVar.mo22b(C0071a.ERA, (long) mo114a());
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m469c()) {
            return C0072b.ERAS;
        }
        if (kVar == C0089j.m468b() || kVar == C0089j.m470d() || kVar == C0089j.m467a() || kVar == C0089j.m471e() || kVar == C0089j.m472f() || kVar == C0089j.m473g()) {
            return null;
        }
        return kVar.mo107b(this);
    }
}
