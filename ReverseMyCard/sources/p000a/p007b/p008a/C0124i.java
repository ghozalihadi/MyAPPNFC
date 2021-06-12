package p000a.p007b.p008a;

import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p009a.C0021i;
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

/* renamed from: a.b.a.i */
/* compiled from: Month */
public enum C0124i implements C0082e, C0083f {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    

    /* renamed from: m */
    public static final C0097k<C0124i> f356m = null;

    /* renamed from: n */
    private static final C0124i[] f357n = null;

    static {
        f356m = new C0097k<C0124i>() {
            /* renamed from: a */
            public C0124i mo107b(C0082e eVar) {
                return C0124i.m748a(eVar);
            }
        };
        f357n = values();
    }

    /* renamed from: a */
    public static C0124i m747a(int i) {
        if (i >= 1 && i <= 12) {
            return f357n[i - 1];
        }
        throw new C0023b("Invalid value for MonthOfYear: " + i);
    }

    /* renamed from: a */
    public static C0124i m748a(C0082e eVar) {
        if (eVar instanceof C0124i) {
            return (C0124i) eVar;
        }
        try {
            if (!C0021i.f19b.equals(C0018g.m125a(eVar))) {
                eVar = C0115f.m610a(eVar);
            }
            return m747a(eVar.mo67c(C0071a.MONTH_OF_YEAR));
        } catch (C0023b e) {
            throw new C0023b("Unable to obtain Month from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName(), e);
        }
    }

    /* renamed from: a */
    public int mo404a() {
        return ordinal() + 1;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        if (iVar instanceof C0071a) {
            if (iVar == C0071a.MONTH_OF_YEAR) {
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
        if (iVar == C0071a.MONTH_OF_YEAR) {
            return iVar.mo249a();
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar == C0071a.MONTH_OF_YEAR) {
            return mo404a();
        }
        return mo66b(iVar).mo275b(mo68d(iVar), iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (iVar == C0071a.MONTH_OF_YEAR) {
            return (long) mo404a();
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: a */
    public C0124i mo406a(long j) {
        return f357n[((((int) (j % 12)) + 12) + ordinal()) % 12];
    }

    /* renamed from: a */
    public int mo405a(boolean z) {
        switch (this) {
            case FEBRUARY:
                return z ? 29 : 28;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return 30;
            default:
                return 31;
        }
    }

    /* renamed from: b */
    public int mo407b(boolean z) {
        int i = z ? 1 : 0;
        switch (this) {
            case FEBRUARY:
                return 32;
            case APRIL:
                return i + 91;
            case JUNE:
                return i + 152;
            case SEPTEMBER:
                return i + 244;
            case NOVEMBER:
                return i + 305;
            case JANUARY:
                return 1;
            case MARCH:
                return i + 60;
            case MAY:
                return i + 121;
            case JULY:
                return i + 182;
            case AUGUST:
                return i + 213;
            case OCTOBER:
                return i + 274;
            default:
                return i + 335;
        }
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m468b()) {
            return C0021i.f19b;
        }
        if (kVar == C0089j.m469c()) {
            return C0072b.MONTHS;
        }
        if (kVar == C0089j.m472f() || kVar == C0089j.m473g() || kVar == C0089j.m470d() || kVar == C0089j.m467a() || kVar == C0089j.m471e()) {
            return null;
        }
        return kVar.mo107b(this);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        if (C0018g.m125a((C0082e) dVar).equals(C0021i.f19b)) {
            return dVar.mo22b(C0071a.MONTH_OF_YEAR, (long) mo404a());
        }
        throw new C0023b("Adjustment only supported on ISO date-time");
    }
}
