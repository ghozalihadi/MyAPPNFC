package p000a.p007b.p008a;

import java.io.Serializable;
import p000a.p007b.p008a.p011c.C0068b;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0098l;
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.h */
/* compiled from: LocalTime */
public final class C0121h extends C0068b implements C0081d, C0083f, Serializable, Comparable<C0121h> {

    /* renamed from: a */
    public static final C0121h f332a = f337f[0];

    /* renamed from: b */
    public static final C0121h f333b = new C0121h(23, 59, 59, 999999999);

    /* renamed from: c */
    public static final C0121h f334c = f337f[0];

    /* renamed from: d */
    public static final C0121h f335d = f337f[12];

    /* renamed from: e */
    public static final C0097k<C0121h> f336e = new C0097k<C0121h>() {
        /* renamed from: a */
        public C0121h mo107b(C0082e eVar) {
            return C0121h.m714a(eVar);
        }
    };

    /* renamed from: f */
    private static final C0121h[] f337f = new C0121h[24];

    /* renamed from: g */
    private final byte f338g;

    /* renamed from: h */
    private final byte f339h;

    /* renamed from: i */
    private final byte f340i;

    /* renamed from: j */
    private final int f341j;

    static {
        for (int i = 0; i < f337f.length; i++) {
            f337f[i] = new C0121h(i, 0, 0, 0);
        }
    }

    /* renamed from: a */
    public static C0121h m709a(int i, int i2) {
        C0071a.HOUR_OF_DAY.mo246a((long) i);
        if (i2 == 0) {
            return f337f[i];
        }
        C0071a.MINUTE_OF_HOUR.mo246a((long) i2);
        return new C0121h(i, i2, 0, 0);
    }

    /* renamed from: a */
    public static C0121h m710a(int i, int i2, int i3) {
        C0071a.HOUR_OF_DAY.mo246a((long) i);
        if ((i2 | i3) == 0) {
            return f337f[i];
        }
        C0071a.MINUTE_OF_HOUR.mo246a((long) i2);
        C0071a.SECOND_OF_MINUTE.mo246a((long) i3);
        return new C0121h(i, i2, i3, 0);
    }

    /* renamed from: a */
    public static C0121h m711a(int i, int i2, int i3, int i4) {
        C0071a.HOUR_OF_DAY.mo246a((long) i);
        C0071a.MINUTE_OF_HOUR.mo246a((long) i2);
        C0071a.SECOND_OF_MINUTE.mo246a((long) i3);
        C0071a.NANO_OF_SECOND.mo246a((long) i4);
        return m715b(i, i2, i3, i4);
    }

    /* renamed from: a */
    public static C0121h m712a(long j) {
        C0071a.SECOND_OF_DAY.mo246a(j);
        int i = (int) (j / 3600);
        long j2 = j - ((long) (i * 3600));
        int i2 = (int) (j2 / 60);
        return m715b(i, i2, (int) (j2 - ((long) (i2 * 60))), 0);
    }

    /* renamed from: a */
    static C0121h m713a(long j, int i) {
        C0071a.SECOND_OF_DAY.mo246a(j);
        C0071a.NANO_OF_SECOND.mo246a((long) i);
        int i2 = (int) (j / 3600);
        long j2 = j - ((long) (i2 * 3600));
        int i3 = (int) (j2 / 60);
        return m715b(i2, i3, (int) (j2 - ((long) (i3 * 60))), i);
    }

    /* renamed from: b */
    public static C0121h m716b(long j) {
        C0071a.NANO_OF_DAY.mo246a(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return m715b(i, i2, i3, (int) (j3 - (((long) i3) * 1000000000)));
    }

    /* renamed from: a */
    public static C0121h m714a(C0082e eVar) {
        C0121h hVar = (C0121h) eVar.mo17a(C0089j.m473g());
        if (hVar != null) {
            return hVar;
        }
        throw new C0023b("Unable to obtain LocalTime from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
    }

    /* renamed from: b */
    private static C0121h m715b(int i, int i2, int i3, int i4) {
        if ((i2 | i3 | i4) == 0) {
            return f337f[i];
        }
        return new C0121h(i, i2, i3, i4);
    }

    private C0121h(int i, int i2, int i3, int i4) {
        this.f338g = (byte) i;
        this.f339h = (byte) i2;
        this.f340i = (byte) i3;
        this.f341j = i4;
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return iVar.mo255c();
        }
        return iVar != null && iVar.mo250a(this);
    }

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        return super.mo66b(iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar instanceof C0071a) {
            return m717e(iVar);
        }
        return super.mo67c(iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        if (iVar == C0071a.NANO_OF_DAY) {
            return mo395d();
        }
        if (iVar == C0071a.MICRO_OF_DAY) {
            return mo395d() / 1000;
        }
        return (long) m717e(iVar);
    }

    /* renamed from: e */
    private int m717e(C0088i iVar) {
        switch ((C0071a) iVar) {
            case NANO_OF_SECOND:
                return this.f341j;
            case NANO_OF_DAY:
                throw new C0023b("Field too large for an int: " + iVar);
            case MICRO_OF_SECOND:
                return this.f341j / 1000;
            case MICRO_OF_DAY:
                throw new C0023b("Field too large for an int: " + iVar);
            case MILLI_OF_SECOND:
                return this.f341j / 1000000;
            case MILLI_OF_DAY:
                return (int) (mo395d() / 1000000);
            case SECOND_OF_MINUTE:
                return this.f340i;
            case SECOND_OF_DAY:
                return mo391c();
            case MINUTE_OF_HOUR:
                return this.f339h;
            case MINUTE_OF_DAY:
                return (this.f338g * 60) + this.f339h;
            case HOUR_OF_AMPM:
                return this.f338g % 12;
            case CLOCK_HOUR_OF_AMPM:
                int i = this.f338g % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case HOUR_OF_DAY:
                return this.f338g;
            case CLOCK_HOUR_OF_DAY:
                if (this.f338g == 0) {
                    return 24;
                }
                return this.f338g;
            case AMPM_OF_DAY:
                return this.f338g / 12;
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public int mo382a() {
        return this.f340i;
    }

    /* renamed from: b */
    public int mo388b() {
        return this.f341j;
    }

    /* renamed from: a */
    public C0121h mo21b(C0083f fVar) {
        if (fVar instanceof C0121h) {
            return (C0121h) fVar;
        }
        return (C0121h) fVar.mo16a(this);
    }

    /* renamed from: a */
    public C0121h mo22b(C0088i iVar, long j) {
        long j2 = 0;
        if (!(iVar instanceof C0071a)) {
            return (C0121h) iVar.mo247a(this, j);
        }
        C0071a aVar = (C0071a) iVar;
        aVar.mo246a(j);
        switch (aVar) {
            case NANO_OF_SECOND:
                return mo396d((int) j);
            case NANO_OF_DAY:
                return m716b(j);
            case MICRO_OF_SECOND:
                return mo396d(((int) j) * 1000);
            case MICRO_OF_DAY:
                return m716b(1000 * j);
            case MILLI_OF_SECOND:
                return mo396d(((int) j) * 1000000);
            case MILLI_OF_DAY:
                return m716b(1000000 * j);
            case SECOND_OF_MINUTE:
                return mo392c((int) j);
            case SECOND_OF_DAY:
                return mo398e(j - ((long) mo391c()));
            case MINUTE_OF_HOUR:
                return mo389b((int) j);
            case MINUTE_OF_DAY:
                return mo397d(j - ((long) ((this.f338g * 60) + this.f339h)));
            case HOUR_OF_AMPM:
                return mo393c(j - ((long) (this.f338g % 12)));
            case CLOCK_HOUR_OF_AMPM:
                if (j == 12) {
                    j = 0;
                }
                return mo393c(j - ((long) (this.f338g % 12)));
            case HOUR_OF_DAY:
                return mo384a((int) j);
            case CLOCK_HOUR_OF_DAY:
                if (j != 24) {
                    j2 = j;
                }
                return mo384a((int) j2);
            case AMPM_OF_DAY:
                return mo393c((j - ((long) (this.f338g / 12))) * 12);
            default:
                throw new C0099m("Unsupported field: " + iVar);
        }
    }

    /* renamed from: a */
    public C0121h mo384a(int i) {
        if (this.f338g == i) {
            return this;
        }
        C0071a.HOUR_OF_DAY.mo246a((long) i);
        return m715b(i, this.f339h, this.f340i, this.f341j);
    }

    /* renamed from: b */
    public C0121h mo389b(int i) {
        if (this.f339h == i) {
            return this;
        }
        C0071a.MINUTE_OF_HOUR.mo246a((long) i);
        return m715b(this.f338g, i, this.f340i, this.f341j);
    }

    /* renamed from: c */
    public C0121h mo392c(int i) {
        if (this.f340i == i) {
            return this;
        }
        C0071a.SECOND_OF_MINUTE.mo246a((long) i);
        return m715b(this.f338g, this.f339h, i, this.f341j);
    }

    /* renamed from: d */
    public C0121h mo396d(int i) {
        if (this.f341j == i) {
            return this;
        }
        C0071a.NANO_OF_SECOND.mo246a((long) i);
        return m715b(this.f338g, this.f339h, this.f340i, i);
    }

    /* renamed from: a */
    public C0121h mo30d(long j, C0098l lVar) {
        if (!(lVar instanceof C0072b)) {
            return (C0121h) lVar.mo257a(this, j);
        }
        switch ((C0072b) lVar) {
            case NANOS:
                return mo400f(j);
            case MICROS:
                return mo400f((j % 86400000000L) * 1000);
            case MILLIS:
                return mo400f((j % 86400000) * 1000000);
            case SECONDS:
                return mo398e(j);
            case MINUTES:
                return mo397d(j);
            case HOURS:
                return mo393c(j);
            case HALF_DAYS:
                return mo393c((j % 2) * 12);
            default:
                throw new C0099m("Unsupported unit: " + lVar);
        }
    }

    /* renamed from: c */
    public C0121h mo393c(long j) {
        return j == 0 ? this : m715b(((((int) (j % 24)) + this.f338g) + 24) % 24, this.f339h, this.f340i, this.f341j);
    }

    /* renamed from: d */
    public C0121h mo397d(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.f338g * 60) + this.f339h;
        int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
        return i != i2 ? m715b(i2 / 60, i2 % 60, this.f340i, this.f341j) : this;
    }

    /* renamed from: e */
    public C0121h mo398e(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.f338g * 3600) + (this.f339h * 60) + this.f340i;
        int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
        return i != i2 ? m715b(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.f341j) : this;
    }

    /* renamed from: f */
    public C0121h mo400f(long j) {
        if (j == 0) {
            return this;
        }
        long d = mo395d();
        long j2 = (((j % 86400000000000L) + d) + 86400000000000L) % 86400000000000L;
        return d != j2 ? m715b((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000)) : this;
    }

    /* renamed from: b */
    public C0121h mo27c(long j, C0098l lVar) {
        return j == Long.MIN_VALUE ? mo30d(Long.MAX_VALUE, lVar).mo30d(1, lVar) : mo30d(-j, lVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m469c()) {
            return C0072b.NANOS;
        }
        if (kVar == C0089j.m473g()) {
            return this;
        }
        if (kVar == C0089j.m468b() || kVar == C0089j.m467a() || kVar == C0089j.m470d() || kVar == C0089j.m471e() || kVar == C0089j.m472f()) {
            return null;
        }
        return kVar.mo107b(this);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return dVar.mo22b(C0071a.NANO_OF_DAY, mo395d());
    }

    /* renamed from: c */
    public int mo391c() {
        return (this.f338g * 3600) + (this.f339h * 60) + this.f340i;
    }

    /* renamed from: d */
    public long mo395d() {
        return (((long) this.f338g) * 3600000000000L) + (((long) this.f339h) * 60000000000L) + (((long) this.f340i) * 1000000000) + ((long) this.f341j);
    }

    /* renamed from: a */
    public int compareTo(C0121h hVar) {
        int a = C0069c.m374a((int) this.f338g, (int) hVar.f338g);
        if (a != 0) {
            return a;
        }
        int a2 = C0069c.m374a((int) this.f339h, (int) hVar.f339h);
        if (a2 != 0) {
            return a2;
        }
        int a3 = C0069c.m374a((int) this.f340i, (int) hVar.f340i);
        if (a3 == 0) {
            return C0069c.m374a(this.f341j, hVar.f341j);
        }
        return a3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0121h)) {
            return false;
        }
        C0121h hVar = (C0121h) obj;
        if (this.f338g == hVar.f338g && this.f339h == hVar.f339h && this.f340i == hVar.f340i && this.f341j == hVar.f341j) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long d = mo395d();
        return (int) (d ^ (d >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.f338g;
        byte b2 = this.f339h;
        byte b3 = this.f340i;
        int i = this.f341j;
        sb.append(b < 10 ? "0" : "").append(b).append(b2 < 10 ? ":0" : ":").append(b2);
        if (b3 > 0 || i > 0) {
            sb.append(b3 < 10 ? ":0" : ":").append(b3);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(1000000000 + i).substring(1));
                }
            }
        }
        return sb.toString();
    }
}
