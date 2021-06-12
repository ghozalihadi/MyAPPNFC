package p000a.p007b.p008a;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;
import p000a.p007b.p008a.p013e.C0111d;

/* renamed from: a.b.a.n */
/* compiled from: ZoneOffset */
public final class C0136n extends C0134m implements C0082e, C0083f, Serializable, Comparable<C0136n> {

    /* renamed from: c */
    public static final C0097k<C0136n> f378c = new C0097k<C0136n>() {
        /* renamed from: a */
        public C0136n mo107b(C0082e eVar) {
            return C0136n.m834b(eVar);
        }
    };

    /* renamed from: d */
    public static final C0136n f379d = m832a(0);

    /* renamed from: e */
    public static final C0136n f380e = m832a(-64800);

    /* renamed from: f */
    public static final C0136n f381f = m832a(64800);

    /* renamed from: g */
    private static final ConcurrentMap<Integer, C0136n> f382g = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: h */
    private static final ConcurrentMap<String, C0136n> f383h = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: i */
    private final int f384i;

    /* renamed from: j */
    private final transient String f385j;

    /* renamed from: b */
    public static C0136n m835b(String str) {
        int a;
        int a2;
        int a3;
        C0069c.m378a(str, "offsetId");
        C0136n nVar = (C0136n) f383h.get(str);
        if (nVar != null) {
            return nVar;
        }
        switch (str.length()) {
            case 2:
                str = str.charAt(0) + "0" + str.charAt(1);
                break;
            case 3:
                break;
            case 5:
                a = m831a((CharSequence) str, 1, false);
                a2 = m831a((CharSequence) str, 3, false);
                a3 = 0;
                break;
            case 6:
                a = m831a((CharSequence) str, 1, false);
                a2 = m831a((CharSequence) str, 4, true);
                a3 = 0;
                break;
            case 7:
                a = m831a((CharSequence) str, 1, false);
                a2 = m831a((CharSequence) str, 3, false);
                a3 = m831a((CharSequence) str, 5, false);
                break;
            case 9:
                a = m831a((CharSequence) str, 1, false);
                a2 = m831a((CharSequence) str, 4, true);
                a3 = m831a((CharSequence) str, 7, true);
                break;
            default:
                throw new C0023b("Invalid ID for ZoneOffset, invalid format: " + str);
        }
        a2 = 0;
        a = m831a((CharSequence) str, 1, false);
        a3 = 0;
        char charAt = str.charAt(0);
        if (charAt != '+' && charAt != '-') {
            throw new C0023b("Invalid ID for ZoneOffset, plus/minus not found when expected: " + str);
        } else if (charAt == '-') {
            return m833a(-a, -a2, -a3);
        } else {
            return m833a(a, a2, a3);
        }
    }

    /* renamed from: a */
    private static int m831a(CharSequence charSequence, int i, boolean z) {
        if (!z || charSequence.charAt(i - 1) == ':') {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence.charAt(i + 1);
            if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
                return ((charAt - '0') * 10) + (charAt2 - '0');
            }
            throw new C0023b("Invalid ID for ZoneOffset, non numeric characters found: " + charSequence);
        }
        throw new C0023b("Invalid ID for ZoneOffset, colon not found when expected: " + charSequence);
    }

    /* renamed from: a */
    public static C0136n m833a(int i, int i2, int i3) {
        m837b(i, i2, i3);
        return m832a(m838c(i, i2, i3));
    }

    /* renamed from: b */
    public static C0136n m834b(C0082e eVar) {
        C0136n nVar = (C0136n) eVar.mo17a(C0089j.m471e());
        if (nVar != null) {
            return nVar;
        }
        throw new C0023b("Unable to obtain ZoneOffset from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
    }

    /* renamed from: b */
    private static void m837b(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new C0023b("Zone offset hours not in valid range: value " + i + " is not in the range -18 to 18");
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new C0023b("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new C0023b("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new C0023b("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i2) > 59) {
            throw new C0023b("Zone offset minutes not in valid range: abs(value) " + Math.abs(i2) + " is not in the range 0 to 59");
        } else if (Math.abs(i3) > 59) {
            throw new C0023b("Zone offset seconds not in valid range: abs(value) " + Math.abs(i3) + " is not in the range 0 to 59");
        } else if (Math.abs(i) != 18) {
        } else {
            if (Math.abs(i2) > 0 || Math.abs(i3) > 0) {
                throw new C0023b("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    /* renamed from: c */
    private static int m838c(int i, int i2, int i3) {
        return (i * 3600) + (i2 * 60) + i3;
    }

    /* renamed from: a */
    public static C0136n m832a(int i) {
        if (Math.abs(i) > 64800) {
            throw new C0023b("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i % 900 != 0) {
            return new C0136n(i);
        } else {
            Integer valueOf = Integer.valueOf(i);
            C0136n nVar = (C0136n) f382g.get(valueOf);
            if (nVar != null) {
                return nVar;
            }
            f382g.putIfAbsent(valueOf, new C0136n(i));
            C0136n nVar2 = (C0136n) f382g.get(valueOf);
            f383h.putIfAbsent(nVar2.mo443c(), nVar2);
            return nVar2;
        }
    }

    private C0136n(int i) {
        this.f384i = i;
        this.f385j = m836b(i);
    }

    /* renamed from: b */
    private static String m836b(int i) {
        if (i == 0) {
            return "Z";
        }
        int abs = Math.abs(i);
        StringBuilder sb = new StringBuilder();
        int i2 = abs / 3600;
        int i3 = (abs / 60) % 60;
        sb.append(i < 0 ? "-" : "+").append(i2 < 10 ? "0" : "").append(i2).append(i3 < 10 ? ":0" : ":").append(i3);
        int i4 = abs % 60;
        if (i4 != 0) {
            sb.append(i4 < 10 ? ":0" : ":").append(i4);
        }
        return sb.toString();
    }

    /* renamed from: f */
    public int mo452f() {
        return this.f384i;
    }

    /* renamed from: c */
    public String mo443c() {
        return this.f385j;
    }

    /* renamed from: d */
    public C0111d mo444d() {
        return C0111d.m585a(this);
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        if (iVar instanceof C0071a) {
            if (iVar == C0071a.OFFSET_SECONDS) {
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
        if (iVar == C0071a.OFFSET_SECONDS) {
            return iVar.mo249a();
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (iVar == C0071a.OFFSET_SECONDS) {
            return this.f384i;
        }
        if (!(iVar instanceof C0071a)) {
            return mo66b(iVar).mo275b(mo68d(iVar), iVar);
        }
        throw new C0099m("Unsupported field: " + iVar);
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (iVar == C0071a.OFFSET_SECONDS) {
            return (long) this.f384i;
        }
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        throw new C0023b("Unsupported field: " + iVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m471e() || kVar == C0089j.m470d()) {
            return this;
        }
        if (kVar == C0089j.m472f() || kVar == C0089j.m473g() || kVar == C0089j.m469c() || kVar == C0089j.m468b() || kVar == C0089j.m467a()) {
            return null;
        }
        return kVar.mo107b(this);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return dVar.mo22b(C0071a.OFFSET_SECONDS, (long) this.f384i);
    }

    /* renamed from: a */
    public int compareTo(C0136n nVar) {
        return nVar.f384i - this.f384i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0136n)) {
            return false;
        }
        if (this.f384i != ((C0136n) obj).f384i) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f384i;
    }

    public String toString() {
        return this.f385j;
    }
}
