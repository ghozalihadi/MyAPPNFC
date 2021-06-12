package p000a.p007b.p008a.p011c;

import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.c.b */
/* compiled from: DefaultInterfaceTemporalAccessor */
public abstract class C0068b implements C0082e {
    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        if (mo18a(iVar)) {
            return iVar.mo249a();
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        return mo66b(iVar).mo275b(mo68d(iVar), iVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m467a() || kVar == C0089j.m468b() || kVar == C0089j.m469c()) {
            return null;
        }
        return kVar.mo107b(this);
    }
}
