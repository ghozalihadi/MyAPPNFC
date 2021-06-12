package p020b.p021a.p022a;

import java.io.Serializable;
import p000a.p001a.p002a.p005b.C0002a;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0131l;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p010b.C0025b;

/* renamed from: b.a.a.f */
/* compiled from: ExpirationDate */
public final class C0661f extends C0659d implements Serializable {

    /* renamed from: a */
    private static final C0025b f1256a = C0025b.m185a("yyMM");

    /* renamed from: b */
    private final C0131l f1257b;

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    public C0661f() {
        this((String) null);
    }

    public C0661f(String str) {
        super(str);
        C0131l lVar;
        try {
            lVar = C0131l.m791a((CharSequence) C0671p.f1309a.matcher(C0002a.m2a(str)).replaceAll(""), f1256a);
        } catch (Exception e) {
            lVar = null;
        }
        this.f1257b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0661f)) {
            return false;
        }
        C0661f fVar = (C0661f) obj;
        if (this.f1257b == null) {
            if (fVar.f1257b != null) {
                return false;
            }
            return true;
        } else if (!this.f1257b.equals(fVar.f1257b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo8049a() {
        return this.f1257b != null;
    }

    public int hashCode() {
        int hashCode;
        if (this.f1257b == null) {
            hashCode = 0;
        } else {
            hashCode = this.f1257b.hashCode();
        }
        return hashCode + 31;
    }

    /* renamed from: b */
    public boolean mo8050b() {
        if (!mo8049a()) {
            return true;
        }
        return this.f1257b.mo438e().mo23b((C0006a) C0115f.m604a());
    }

    public String toString() {
        if (mo8049a()) {
            return this.f1257b.toString();
        }
        return "";
    }
}
