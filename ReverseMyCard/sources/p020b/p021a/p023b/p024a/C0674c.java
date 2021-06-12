package p020b.p021a.p023b.p024a;

import java.io.Serializable;
import java.util.regex.Matcher;
import p000a.p001a.p002a.p005b.C0002a;
import p020b.p021a.p022a.C0665j;

/* renamed from: b.a.b.a.c */
/* compiled from: BaseTrackData */
abstract class C0674c implements C0665j, Serializable {

    /* renamed from: a */
    private final String f1316a;

    /* renamed from: b */
    private final String f1317b;

    /* renamed from: a */
    protected static String m1999a(Matcher matcher, int i) {
        if (matcher.groupCount() > i - 1) {
            return matcher.group(i);
        }
        return null;
    }

    C0674c(String str, String str2) {
        this.f1316a = str;
        this.f1317b = str2 == null ? "" : str2;
    }

    /* renamed from: f */
    public String mo8084f() {
        return this.f1317b;
    }

    /* renamed from: k */
    public String mo8037k() {
        return this.f1316a;
    }

    /* renamed from: e */
    public boolean mo8083e() {
        return !C0002a.m10b(this.f1317b);
    }

    /* renamed from: d */
    public boolean mo8082d() {
        return !C0002a.m10b(this.f1316a);
    }

    public String toString() {
        return this.f1316a;
    }
}
