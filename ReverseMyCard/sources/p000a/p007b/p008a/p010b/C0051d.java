package p000a.p007b.p008a.p010b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p000a.p007b.p008a.C0127j;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p009a.C0021i;
import p000a.p007b.p008a.p010b.C0028c;
import p000a.p007b.p008a.p011c.C0068b;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0099m;

/* renamed from: a.b.a.b.d */
/* compiled from: DateTimeParseContext */
final class C0051d {

    /* renamed from: a */
    private Locale f112a;

    /* renamed from: b */
    private C0058h f113b;

    /* renamed from: c */
    private C0018g f114c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0134m f115d;

    /* renamed from: e */
    private boolean f116e = true;

    /* renamed from: f */
    private boolean f117f = true;

    /* renamed from: g */
    private final ArrayList<C0053a> f118g = new ArrayList<>();

    C0051d(C0025b bVar) {
        this.f112a = bVar.mo126a();
        this.f113b = bVar.mo128b();
        this.f114c = bVar.mo129c();
        this.f115d = bVar.mo130d();
        this.f118g.add(new C0053a());
    }

    C0051d(C0051d dVar) {
        this.f112a = dVar.f112a;
        this.f113b = dVar.f113b;
        this.f114c = dVar.f114c;
        this.f115d = dVar.f115d;
        this.f116e = dVar.f116e;
        this.f117f = dVar.f117f;
        this.f118g.add(new C0053a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0051d mo192a() {
        return new C0051d(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Locale mo199b() {
        return this.f112a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0058h mo201c() {
        return this.f113b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0018g mo203d() {
        C0018g gVar = m297j().f119a;
        if (gVar != null) {
            return gVar;
        }
        C0018g gVar2 = this.f114c;
        if (gVar2 == null) {
            return C0021i.f19b;
        }
        return gVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo204e() {
        return this.f116e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo196a(boolean z) {
        this.f116e = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo198a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 > charSequence.length() || i2 + i3 > charSequence2.length()) {
            return false;
        }
        if (mo204e()) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (charSequence.charAt(i + i4) != charSequence2.charAt(i2 + i4)) {
                    return false;
                }
            }
        } else {
            for (int i5 = 0; i5 < i3; i5++) {
                char charAt = charSequence.charAt(i + i5);
                char charAt2 = charSequence2.charAt(i2 + i5);
                if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo197a(char c, char c2) {
        if (mo204e()) {
            return c == c2;
        }
        return m296b(c, c2);
    }

    /* renamed from: b */
    static boolean m296b(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo205f() {
        return this.f117f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo200b(boolean z) {
        this.f117f = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo206g() {
        this.f118g.add(m297j().mo210a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo202c(boolean z) {
        if (z) {
            this.f118g.remove(this.f118g.size() - 2);
        } else {
            this.f118g.remove(this.f118g.size() - 1);
        }
    }

    /* renamed from: j */
    private C0053a m297j() {
        return this.f118g.get(this.f118g.size() - 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Long mo193a(C0088i iVar) {
        return m297j().f121c.get(iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo191a(C0088i iVar, long j, int i, int i2) {
        C0069c.m378a(iVar, "field");
        Long put = m297j().f121c.put(iVar, Long.valueOf(j));
        return (put == null || put.longValue() == j) ? i2 : i ^ -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo194a(C0028c.C0042j jVar, long j, int i, int i2) {
        C0053a j2 = m297j();
        if (j2.f124f == null) {
            j2.f124f = new ArrayList(2);
        }
        j2.f124f.add(new Object[]{jVar, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo195a(C0134m mVar) {
        C0069c.m378a(mVar, "zone");
        m297j().f120b = mVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo207h() {
        m297j().f122d = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C0053a mo208i() {
        return m297j();
    }

    public String toString() {
        return m297j().toString();
    }

    /* renamed from: a.b.a.b.d$a */
    /* compiled from: DateTimeParseContext */
    final class C0053a extends C0068b {

        /* renamed from: a */
        C0018g f119a;

        /* renamed from: b */
        C0134m f120b;

        /* renamed from: c */
        final Map<C0088i, Long> f121c;

        /* renamed from: d */
        boolean f122d;

        /* renamed from: e */
        C0127j f123e;

        /* renamed from: f */
        List<Object[]> f124f;

        private C0053a() {
            this.f119a = null;
            this.f120b = null;
            this.f121c = new HashMap();
            this.f123e = C0127j.f360a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C0053a mo210a() {
            C0053a aVar = new C0053a();
            aVar.f119a = this.f119a;
            aVar.f120b = this.f120b;
            aVar.f121c.putAll(this.f121c);
            aVar.f122d = this.f122d;
            return aVar;
        }

        public String toString() {
            return this.f121c.toString() + "," + this.f119a + "," + this.f120b;
        }

        /* renamed from: a */
        public boolean mo18a(C0088i iVar) {
            return this.f121c.containsKey(iVar);
        }

        /* renamed from: c */
        public int mo67c(C0088i iVar) {
            if (this.f121c.containsKey(iVar)) {
                return C0069c.m375a(this.f121c.get(iVar).longValue());
            }
            throw new C0099m("Unsupported field: " + iVar);
        }

        /* renamed from: d */
        public long mo68d(C0088i iVar) {
            if (this.f121c.containsKey(iVar)) {
                return this.f121c.get(iVar).longValue();
            }
            throw new C0099m("Unsupported field: " + iVar);
        }

        /* renamed from: a */
        public <R> R mo17a(C0097k<R> kVar) {
            if (kVar == C0089j.m468b()) {
                return this.f119a;
            }
            if (kVar == C0089j.m467a() || kVar == C0089j.m470d()) {
                return this.f120b;
            }
            return super.mo17a(kVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0024a mo211b() {
            C0024a aVar = new C0024a();
            aVar.f23a.putAll(this.f121c);
            aVar.f24b = C0051d.this.mo203d();
            if (this.f120b != null) {
                aVar.f25c = this.f120b;
            } else {
                aVar.f25c = C0051d.this.f115d;
            }
            aVar.f28f = this.f122d;
            aVar.f29g = this.f123e;
            return aVar;
        }
    }
}
