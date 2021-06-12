package p000a.p007b.p008a;

import java.io.Serializable;
import java.util.regex.Pattern;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p013e.C0111d;
import p000a.p007b.p008a.p013e.C0113e;
import p000a.p007b.p008a.p013e.C0114f;

/* renamed from: a.b.a.o */
/* compiled from: ZoneRegion */
final class C0138o extends C0134m implements Serializable {

    /* renamed from: c */
    private static final Pattern f386c = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");

    /* renamed from: d */
    private final String f387d;

    /* renamed from: e */
    private final transient C0111d f388e;

    /* renamed from: a */
    static C0138o m851a(String str, boolean z) {
        C0069c.m378a(str, "zoneId");
        if (str.length() < 2 || !f386c.matcher(str).matches()) {
            throw new C0023b("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        C0111d dVar = null;
        try {
            dVar = C0114f.m598a(str, true);
        } catch (C0113e e) {
            if (str.equals("GMT0")) {
                dVar = C0136n.f379d.mo444d();
            } else if (z) {
                throw e;
            }
        }
        return new C0138o(str, dVar);
    }

    C0138o(String str, C0111d dVar) {
        this.f387d = str;
        this.f388e = dVar;
    }

    /* renamed from: c */
    public String mo443c() {
        return this.f387d;
    }

    /* renamed from: d */
    public C0111d mo444d() {
        return this.f388e != null ? this.f388e : C0114f.m598a(this.f387d, false);
    }
}
