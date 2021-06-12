package p000a.p007b.p008a;

import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.c */
/* compiled from: DayOfWeek */
public enum C0065c implements C0082e, C0083f {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    

    /* renamed from: h */
    public static final C0097k<C0065c> f170h = null;

    /* renamed from: i */
    private static final C0065c[] f171i = null;

    static {
        f170h = new C0097k<C0065c>() {
            /* renamed from: a */
            public C0065c mo107b(C0082e eVar) {
                return C0065c.m357a(eVar);
            }
        };
        f171i = values();
    }

    /* renamed from: a */
    public static C0065c m356a(int i) {
        if (i >= 1 && i <= 7) {
            return f171i[i - 1];
        }
        throw new C0023b("Invalid value for DayOfWeek: " + i);
    }

    /* renamed from: a */
    public static C0065c m357a(C0082e eVar) {
        if (eVar instanceof C0065c) {
            return (C0065c) eVar;
        }
        try {
            return m356a(eVar.mo67c(C0071a.DAY_OF_WEEK));
        } catch (C0023b e) {
            throw new C0023b("Unable to obtain DayOfWeek from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName(), e);
        }
    }

    /* renamed from: a */
    public int mo236a() {
        return ordinal() + 1;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        if (iVar instanceof C0071a) {
            if (iVar == C0071a.DAY_OF_WEEK) {
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
        if (iVar == C0071a.DAY_OF_WEEK) {
            return iVar.mo249a();
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar == C0071a.DAY_OF_WEEK) {
            return mo236a();
        }
        return mo66b(iVar).mo275b(mo68d(iVar), iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (iVar == C0071a.DAY_OF_WEEK) {
            return (long) mo236a();
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: a */
    public C0065c mo237a(long j) {
        return f171i[((((int) (j % 7)) + 7) + ordinal()) % 7];
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m469c()) {
            return C0072b.DAYS;
        }
        if (kVar == C0089j.m472f() || kVar == C0089j.m473g() || kVar == C0089j.m468b() || kVar == C0089j.m470d() || kVar == C0089j.m467a() || kVar == C0089j.m471e()) {
            return null;
        }
        return kVar.mo107b(this);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return dVar.mo22b(C0071a.DAY_OF_WEEK, (long) mo236a());
    }
}
