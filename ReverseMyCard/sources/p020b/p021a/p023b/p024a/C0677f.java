package p020b.p021a.p023b.p024a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p005b.C0002a;

/* renamed from: b.a.b.a.f */
/* compiled from: Track3 */
public class C0677f extends C0674c {

    /* renamed from: a */
    private static final Pattern f1322a = Pattern.compile(".*?[\t\n\r ]{0,2}(\\+(.*)\\?)");

    /* renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo8082d() {
        return super.mo8082d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ boolean mo8083e() {
        return super.mo8083e();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ String mo8084f() {
        return super.mo8084f();
    }

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* renamed from: a */
    public static C0677f m2028a(String str) {
        String str2;
        String str3;
        Matcher matcher = f1322a.matcher(C0002a.m2a(str));
        if (matcher.matches()) {
            str2 = m1999a(matcher, 1);
            str3 = m1999a(matcher, 2);
        } else {
            str2 = null;
            str3 = "";
        }
        return new C0677f(str2, str3);
    }

    private C0677f(String str, String str2) {
        super(str, str2);
    }
}
