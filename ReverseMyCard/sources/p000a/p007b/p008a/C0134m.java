package p000a.p007b.p008a;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p013e.C0111d;
import p000a.p007b.p008a.p013e.C0113e;
import p000a.p007b.p008a.p013e.C0114f;

/* renamed from: a.b.a.m */
/* compiled from: ZoneId */
public abstract class C0134m implements Serializable {

    /* renamed from: a */
    public static final C0097k<C0134m> f376a = new C0097k<C0134m>() {
        /* renamed from: a */
        public C0134m mo107b(C0082e eVar) {
            return C0134m.m821a(eVar);
        }
    };

    /* renamed from: b */
    public static final Map<String, String> f377b;

    /* renamed from: c */
    public abstract String mo443c();

    /* renamed from: d */
    public abstract C0111d mo444d();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        f377b = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static C0134m m820a() {
        return m824a(TimeZone.getDefault().getID(), f377b);
    }

    /* renamed from: b */
    public static Set<String> m825b() {
        return C0114f.m600a();
    }

    /* renamed from: a */
    public static C0134m m824a(String str, Map<String, String> map) {
        C0069c.m378a(str, "zoneId");
        C0069c.m378a(map, "aliasMap");
        String str2 = map.get(str);
        if (str2 == null) {
            str2 = str;
        }
        return m822a(str2);
    }

    /* renamed from: a */
    public static C0134m m822a(String str) {
        C0069c.m378a(str, "zoneId");
        if (str.equals("Z")) {
            return C0136n.f379d;
        }
        if (str.length() == 1) {
            throw new C0023b("Invalid zone: " + str);
        } else if (str.startsWith("+") || str.startsWith("-")) {
            return C0136n.m835b(str);
        } else {
            if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
                return new C0138o(str, C0136n.f379d.mo444d());
            }
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                C0136n b = C0136n.m835b(str.substring(3));
                if (b.mo452f() == 0) {
                    return new C0138o(str.substring(0, 3), b.mo444d());
                }
                return new C0138o(str.substring(0, 3) + b.mo443c(), b.mo444d());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return C0138o.m851a(str, true);
            } else {
                C0136n b2 = C0136n.m835b(str.substring(2));
                if (b2.mo452f() == 0) {
                    return new C0138o("UT", b2.mo444d());
                }
                return new C0138o("UT" + b2.mo443c(), b2.mo444d());
            }
        }
    }

    /* renamed from: a */
    public static C0134m m823a(String str, C0136n nVar) {
        C0069c.m378a(str, "prefix");
        C0069c.m378a(nVar, "offset");
        if (str.length() == 0) {
            return nVar;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: " + str);
        } else if (nVar.mo452f() == 0) {
            return new C0138o(str, nVar.mo444d());
        } else {
            return new C0138o(str + nVar.mo443c(), nVar.mo444d());
        }
    }

    /* renamed from: a */
    public static C0134m m821a(C0082e eVar) {
        C0134m mVar = (C0134m) eVar.mo17a(C0089j.m470d());
        if (mVar != null) {
            return mVar;
        }
        throw new C0023b("Unable to obtain ZoneId from TemporalAccessor: " + eVar + ", type " + eVar.getClass().getName());
    }

    C0134m() {
        if (getClass() != C0136n.class && getClass() != C0138o.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    /* renamed from: e */
    public C0134m mo445e() {
        try {
            C0111d d = mo444d();
            if (d.mo311a()) {
                return d.mo309a(C0103e.f283a);
            }
            return this;
        } catch (C0113e e) {
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0134m) {
            return mo443c().equals(((C0134m) obj).mo443c());
        }
        return false;
    }

    public int hashCode() {
        return mo443c().hashCode();
    }

    public String toString() {
        return mo443c();
    }
}
