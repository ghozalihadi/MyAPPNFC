package p020b.p021a.p023b.p024a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p005b.C0002a;
import p020b.p021a.p022a.C0656a;
import p020b.p021a.p022a.C0661f;
import p020b.p021a.p022a.C0663h;
import p020b.p021a.p022a.C0664i;
import p020b.p021a.p022a.C0666k;

/* renamed from: b.a.b.a.d */
/* compiled from: Track1FormatB */
public class C0675d extends C0673b {

    /* renamed from: a */
    private static final Pattern f1318a = Pattern.compile("(%?([A-Z])([0-9]{1,19})\\^([^\\^]{2,26})\\^([0-9]{4}|\\^)([0-9]{3}|\\^)?([^\\?]+)?\\??)[\t\n\r ]{0,2}.*");

    /* renamed from: b */
    private final C0663h f1319b;

    /* renamed from: c */
    private final String f1320c;

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
    public static C0675d m2004a(String str) {
        String str2;
        String str3;
        C0656a aVar;
        C0663h hVar;
        C0661f fVar;
        C0666k kVar;
        String str4;
        Matcher matcher = f1318a.matcher(C0002a.m2a(str));
        if (matcher.matches()) {
            str2 = m1999a(matcher, 1);
            str3 = m1999a(matcher, 2);
            aVar = new C0656a(m1999a(matcher, 3));
            hVar = new C0663h(m1999a(matcher, 4));
            fVar = new C0661f(m1999a(matcher, 5));
            kVar = new C0666k(m1999a(matcher, 6));
            str4 = m1999a(matcher, 7);
        } else {
            str2 = null;
            str3 = "";
            aVar = new C0656a();
            hVar = new C0663h();
            fVar = new C0661f();
            kVar = new C0666k();
            str4 = "";
        }
        return new C0675d(str2, aVar, fVar, hVar, kVar, str3, str4);
    }

    private C0675d(String str, C0664i iVar, C0661f fVar, C0663h hVar, C0666k kVar, String str2, String str3) {
        super(str, iVar, fVar, kVar, str3);
        this.f1320c = str2;
        this.f1319b = hVar;
    }

    /* renamed from: j */
    public C0663h mo8094j() {
        return this.f1319b;
    }

    /* renamed from: l */
    public boolean mo8095l() {
        return this.f1319b != null && this.f1319b.mo8060e();
    }
}
