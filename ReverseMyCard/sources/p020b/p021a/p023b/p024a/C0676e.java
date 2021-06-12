package p020b.p021a.p023b.p024a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p005b.C0002a;
import p020b.p021a.p022a.C0656a;
import p020b.p021a.p022a.C0661f;
import p020b.p021a.p022a.C0664i;
import p020b.p021a.p022a.C0666k;

/* renamed from: b.a.b.a.e */
/* compiled from: Track2 */
public class C0676e extends C0673b {

    /* renamed from: a */
    private static final Pattern f1321a = Pattern.compile(".*[\\t\\n\\r ]?(;([0-9]{1,19})=([0-9]{4})([0-9]{3})(.*)\\?).*");

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C0661f mo8086a() {
        return super.mo8086a();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ C0664i mo8087b() {
        return super.mo8087b();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ C0666k mo8088c() {
        return super.mo8088c();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo8082d() {
        return super.mo8082d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ boolean mo8083e() {
        return super.mo8083e();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ String mo8084f() {
        return super.mo8084f();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ boolean mo8090g() {
        return super.mo8090g();
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ boolean mo8091h() {
        return super.mo8091h();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ boolean mo8093i() {
        return super.mo8093i();
    }

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* renamed from: a */
    public static C0676e m2017a(String str) {
        String str2;
        C0656a aVar;
        C0661f fVar;
        C0666k kVar;
        String str3;
        Matcher matcher = f1321a.matcher(C0002a.m2a(str));
        if (matcher.matches()) {
            str2 = m1999a(matcher, 1);
            aVar = new C0656a(m1999a(matcher, 2));
            fVar = new C0661f(m1999a(matcher, 3));
            kVar = new C0666k(m1999a(matcher, 4));
            str3 = m1999a(matcher, 5);
        } else {
            str2 = null;
            aVar = new C0656a();
            fVar = new C0661f();
            kVar = new C0666k();
            str3 = "";
        }
        return new C0676e(str2, aVar, fVar, kVar, str3);
    }

    private C0676e(String str, C0664i iVar, C0661f fVar, C0666k kVar, String str2) {
        super(str, iVar, fVar, kVar, str2);
    }
}
