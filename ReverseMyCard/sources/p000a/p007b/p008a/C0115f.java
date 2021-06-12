package p000a.p007b.p008a;

import java.io.Serializable;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p009a.C0020h;
import p000a.p007b.p008a.p009a.C0021i;
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
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.f */
/* compiled from: LocalDate */
public final class C0115f extends C0006a implements C0081d, C0083f, Serializable {

    /* renamed from: a */
    public static final C0115f f318a = m606a(-999999999, 1, 1);

    /* renamed from: b */
    public static final C0115f f319b = m606a(999999999, 12, 31);

    /* renamed from: c */
    public static final C0097k<C0115f> f320c = new C0097k<C0115f>() {
        /* renamed from: a */
        public C0115f mo107b(C0082e eVar) {
            return C0115f.m610a(eVar);
        }
    };

    /* renamed from: d */
    private final int f321d;

    /* renamed from: e */
    private final short f322e;

    /* renamed from: f */
    private final short f323f;

    /* renamed from: a */
    public static C0115f m604a() {
        return m609a(C0004a.m14a());
    }

    /* renamed from: a */
    public static C0115f m609a(C0004a aVar) {
        C0069c.m378a(aVar, "clock");
        C0103e d = aVar.mo11d();
        C0136n a = aVar.mo9b().mo444d().mo309a(d);
        return m608a(C0069c.m386e(((long) a.mo452f()) + d.mo294a(), 86400));
    }

    /* renamed from: a */
    public static C0115f m607a(int i, C0124i iVar, int i2) {
        C0071a.YEAR.mo246a((long) i);
        C0069c.m378a(iVar, "month");
        C0071a.DAY_OF_MONTH.mo246a((long) i2);
        return m612b(i, iVar, i2);
    }

    /* renamed from: a */
    public static C0115f m606a(int i, int i2, int i3) {
        C0071a.YEAR.mo246a((long) i);
        C0071a.MONTH_OF_YEAR.mo246a((long) i2);
        C0071a.DAY_OF_MONTH.mo246a((long) i3);
        return m612b(i, C0124i.m747a(i2), i3);
    }

    /* renamed from: a */
    public static C0115f m605a(int i, int i2) {
        C0071a.YEAR.mo246a((long) i);
        C0071a.DAY_OF_YEAR.mo246a((long) i2);
        boolean a = C0021i.f19b.mo97a((long) i);
        if (i2 != 366 || a) {
            C0124i a2 = C0124i.m747a(((i2 - 1) / 31) + 1);
            if (i2 > (a2.mo407b(a) + a2.mo405a(a)) - 1) {
                a2 = a2.mo406a(1);
            }
            return m612b(i, a2, (i2 - a2.mo407b(a)) + 1);
        }
        throw new C0023b("Invalid date 'DayOfYear 366' as '" + i + "' is not a leap year");
    }

    /* renamed from: a */
    public static C0115f m608a(long j) {
        long j2;
        long j3;
        long j4 = (719528 + j) - 60;
        long j5 = 0;
        if (j4 < 0) {
            long j6 = ((1 + j4) / 146097) - 1;
            j5 = 400 * j6;
            j4 += (-j6) * 146097;
        }
        long j7 = ((400 * j4) + 591) / 146097;
        long j8 = j4 - ((((365 * j7) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        if (j8 < 0) {
            j3 = j7 - 1;
            j2 = j4 - ((((365 * j3) + (j3 / 4)) - (j3 / 100)) + (j3 / 400));
        } else {
            j2 = j8;
            j3 = j7;
        }
        int i = (int) j2;
        int i2 = ((i * 5) + 2) / 153;
        C0071a aVar = C0071a.YEAR;
        return new C0115f(aVar.mo251b(j5 + j3 + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    /* renamed from: a */
    public static C0115f m610a(C0082e eVar) {
        C0115f fVar = (C0115f) eVar.mo17a(C0089j.m472f());
        if (fVar != null) {
            return fVar;
        }
        throw new C0023b("Unable to obtain LocalDate from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
    }

    /* renamed from: b */
    private static C0115f m612b(int i, C0124i iVar, int i2) {
        if (i2 <= 28 || i2 <= iVar.mo405a(C0021i.f19b.mo97a((long) i))) {
            return new C0115f(i, iVar.mo404a(), i2);
        }
        if (i2 == 29) {
            throw new C0023b("Invalid date 'February 29' as '" + i + "' is not a leap year");
        }
        throw new C0023b("Invalid date '" + iVar.name() + " " + i2 + "'");
    }

    /* renamed from: b */
    private static C0115f m611b(int i, int i2, int i3) {
        switch (i2) {
            case 2:
                i3 = Math.min(i3, C0021i.f19b.mo97a((long) i) ? 29 : 28);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                i3 = Math.min(i3, 30);
                break;
        }
        return m606a(i, i2, i3);
    }

    private C0115f(int i, int i2, int i3) {
        this.f321d = i;
        this.f322e = (short) i2;
        this.f323f = (short) i3;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        return super.mo18a(iVar);
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        C0071a aVar = (C0071a) iVar;
        if (aVar.mo253b()) {
            switch (aVar) {
                case DAY_OF_MONTH:
                    return C0100n.m491a(1, (long) mo364i());
                case DAY_OF_YEAR:
                    return C0100n.m491a(1, (long) mo36j());
                case ALIGNED_WEEK_OF_MONTH:
                    return C0100n.m491a(1, (mo360e() != C0124i.FEBRUARY || mo34h()) ? 5 : 4);
                case YEAR_OF_ERA:
                    return mo356d() <= 0 ? C0100n.m491a(1, 1000000000) : C0100n.m491a(1, 999999999);
                default:
                    return iVar.mo249a();
            }
        } else {
            throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return m613e(iVar);
        }
        return super.mo67c(iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        if (iVar == C0071a.EPOCH_DAY) {
            return mo37k();
        }
        if (iVar == C0071a.PROLEPTIC_MONTH) {
            return m614m();
        }
        return (long) m613e(iVar);
    }

    /* renamed from: e */
    private int m613e(C0088i iVar) {
        switch ((C0071a) iVar) {
            case DAY_OF_MONTH:
                return this.f323f;
            case DAY_OF_YEAR:
                return mo361f();
            case ALIGNED_WEEK_OF_MONTH:
                return ((this.f323f - 1) / 7) + 1;
            case YEAR_OF_ERA:
                return this.f321d >= 1 ? this.f321d : 1 - this.f321d;
            case DAY_OF_WEEK:
                return mo363g().mo236a();
            case ALIGNED_DAY_OF_WEEK_IN_MONTH:
                return ((this.f323f - 1) % 7) + 1;
            case ALIGNED_DAY_OF_WEEK_IN_YEAR:
                return ((mo361f() - 1) % 7) + 1;
            case EPOCH_DAY:
                throw new C0023b("Field too large for an int: " + iVar);
            case ALIGNED_WEEK_OF_YEAR:
                return ((mo361f() - 1) / 7) + 1;
            case MONTH_OF_YEAR:
                return this.f322e;
            case PROLEPTIC_MONTH:
                throw new C0023b("Field too large for an int: " + iVar);
            case YEAR:
                return this.f321d;
            case ERA:
                return this.f321d >= 1 ? 1 : 0;
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: m */
    private long m614m() {
        return (((long) this.f321d) * 12) + ((long) (this.f322e - 1));
    }

    /* renamed from: b */
    public C0021i mo38l() {
        return C0021i.f19b;
    }

    /* renamed from: c */
    public C0020h mo26c() {
        return super.mo26c();
    }

    /* renamed from: d */
    public int mo356d() {
        return this.f321d;
    }

    /* renamed from: e */
    public C0124i mo360e() {
        return C0124i.m747a((int) this.f322e);
    }

    /* renamed from: f */
    public int mo361f() {
        return (mo360e().mo407b(mo34h()) + this.f323f) - 1;
    }

    /* renamed from: g */
    public C0065c mo363g() {
        return C0065c.m356a(C0069c.m381b(mo37k() + 3, 7) + 1);
    }

    /* renamed from: h */
    public boolean mo34h() {
        return C0021i.f19b.mo97a((long) this.f321d);
    }

    /* renamed from: i */
    public int mo364i() {
        switch (this.f322e) {
            case 2:
                return mo34h() ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    /* renamed from: j */
    public int mo36j() {
        return mo34h() ? 366 : 365;
    }

    /* renamed from: a */
    public C0115f mo24c(C0083f fVar) {
        if (fVar instanceof C0115f) {
            return (C0115f) fVar;
        }
        return (C0115f) fVar.mo16a(this);
    }

    /* renamed from: a */
    public C0115f mo25c(C0088i iVar, long j) {
        if (!(iVar instanceof C0071a)) {
            return (C0115f) iVar.mo247a(this, j);
        }
        C0071a aVar = (C0071a) iVar;
        aVar.mo246a(j);
        switch (aVar) {
            case DAY_OF_MONTH:
                return mo354c((int) j);
            case DAY_OF_YEAR:
                return mo357d((int) j);
            case ALIGNED_WEEK_OF_MONTH:
                return mo358d(j - mo68d((C0088i) C0071a.ALIGNED_WEEK_OF_MONTH));
            case YEAR_OF_ERA:
                if (this.f321d < 1) {
                    j = 1 - j;
                }
                return mo344a((int) j);
            case DAY_OF_WEEK:
                return mo359e(j - ((long) mo363g().mo236a()));
            case ALIGNED_DAY_OF_WEEK_IN_MONTH:
                return mo359e(j - mo68d((C0088i) C0071a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case ALIGNED_DAY_OF_WEEK_IN_YEAR:
                return mo359e(j - mo68d((C0088i) C0071a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case EPOCH_DAY:
                return m608a(j);
            case ALIGNED_WEEK_OF_YEAR:
                return mo358d(j - mo68d((C0088i) C0071a.ALIGNED_WEEK_OF_YEAR));
            case MONTH_OF_YEAR:
                return mo351b((int) j);
            case PROLEPTIC_MONTH:
                return mo355c(j - mo68d((C0088i) C0071a.PROLEPTIC_MONTH));
            case YEAR:
                return mo344a((int) j);
            case ERA:
                if (mo68d((C0088i) C0071a.ERA) != j) {
                    return mo344a(1 - this.f321d);
                }
                return this;
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public C0115f mo344a(int i) {
        if (this.f321d == i) {
            return this;
        }
        C0071a.YEAR.mo246a((long) i);
        return m611b(i, (int) this.f322e, (int) this.f323f);
    }

    /* renamed from: b */
    public C0115f mo351b(int i) {
        if (this.f322e == i) {
            return this;
        }
        C0071a.MONTH_OF_YEAR.mo246a((long) i);
        return m611b(this.f321d, i, (int) this.f323f);
    }

    /* renamed from: c */
    public C0115f mo354c(int i) {
        return this.f323f == i ? this : m606a(this.f321d, (int) this.f322e, i);
    }

    /* renamed from: d */
    public C0115f mo357d(int i) {
        return mo361f() == i ? this : m605a(this.f321d, i);
    }

    /* renamed from: a */
    public C0115f mo28c(C0087h hVar) {
        return (C0115f) hVar.mo241a(this);
    }

    /* renamed from: a */
    public C0115f mo33f(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return (C0115f) lVar.mo257a(this, j);
        }
        switch ((C0072b) lVar) {
            case DAYS:
                return mo359e(j);
            case WEEKS:
                return mo358d(j);
            case MONTHS:
                return mo355c(j);
            case YEARS:
                return mo352b(j);
            case DECADES:
                return mo352b(C0069c.m377a(j, 10));
            case CENTURIES:
                return mo352b(C0069c.m377a(j, 100));
            case MILLENNIA:
                return mo352b(C0069c.m377a(j, 1000));
            case ERAS:
                return mo25c((C0088i) C0071a.ERA, C0069c.m382b(mo68d((C0088i) C0071a.ERA), j));
            default:
                throw new C0099m("Unsupported unit: " + lVar);
        }
    }

    /* renamed from: b */
    public C0115f mo352b(long j) {
        return j == 0 ? this : m611b(C0071a.YEAR.mo251b(((long) this.f321d) + j), (int) this.f322e, (int) this.f323f);
    }

    /* renamed from: c */
    public C0115f mo355c(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.f321d) * 12) + ((long) (this.f322e - 1)) + j;
        return m611b(C0071a.YEAR.mo251b(C0069c.m386e(j2, 12)), C0069c.m381b(j2, 12) + 1, (int) this.f323f);
    }

    /* renamed from: d */
    public C0115f mo358d(long j) {
        return mo359e(C0069c.m377a(j, 7));
    }

    /* renamed from: e */
    public C0115f mo359e(long j) {
        return j == 0 ? this : m608a(C0069c.m382b(mo37k(), j));
    }

    /* renamed from: b */
    public C0115f mo31e(long j, C0098l lVar) {
        return j == Long.MIN_VALUE ? mo33f(Long.MAX_VALUE, lVar).mo33f(1, lVar) : mo33f(-j, lVar);
    }

    /* renamed from: f */
    public C0115f mo362f(long j) {
        return j == Long.MIN_VALUE ? mo352b(Long.MAX_VALUE).mo352b(1) : mo352b(-j);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        return kVar == C0089j.m472f() ? this : super.mo17a(kVar);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return super.mo16a(dVar);
    }

    /* renamed from: a */
    public C0118g mo20b(C0121h hVar) {
        return C0118g.m668a(this, hVar);
    }

    /* renamed from: k */
    public long mo37k() {
        long j;
        long j2 = (long) this.f321d;
        long j3 = (long) this.f322e;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / -400) + ((j2 / -4) - (j2 / -100)));
        }
        long j5 = j + (((367 * j3) - 362) / 12) + ((long) (this.f323f - 1));
        if (j3 > 2) {
            j5--;
            if (!mo34h()) {
                j5--;
            }
        }
        return j5 - 719528;
    }

    /* renamed from: a */
    public int compareTo(C0006a aVar) {
        if (aVar instanceof C0115f) {
            return mo343a((C0115f) aVar);
        }
        return super.compareTo(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo343a(C0115f fVar) {
        int i = this.f321d - fVar.f321d;
        if (i != 0) {
            return i;
        }
        int i2 = this.f322e - fVar.f322e;
        if (i2 == 0) {
            return this.f323f - fVar.f323f;
        }
        return i2;
    }

    /* renamed from: b */
    public boolean mo23b(C0006a aVar) {
        if (aVar instanceof C0115f) {
            return mo343a((C0115f) aVar) < 0;
        }
        return super.mo23b(aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0115f)) {
            return false;
        }
        if (mo343a((C0115f) obj) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f321d;
        return (((i << 11) + (this.f322e << 6)) + this.f323f) ^ (i & -2048);
    }

    public String toString() {
        String str;
        String str2;
        int i = this.f321d;
        short s = this.f322e;
        short s2 = this.f323f;
        int abs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000).deleteCharAt(1);
        } else {
            sb.append(i + 10000).deleteCharAt(0);
        }
        if (s < 10) {
            str = "-0";
        } else {
            str = "-";
        }
        StringBuilder append = sb.append(str).append(s);
        if (s2 < 10) {
            str2 = "-0";
        } else {
            str2 = "-";
        }
        return append.append(str2).append(s2).toString();
    }
}
