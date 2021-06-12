package p020b.p021a.p022a;

import java.io.Serializable;
import p000a.p001a.p002a.p005b.C0002a;
import p000a.p001a.p002a.p005b.p006a.C0003a;

/* renamed from: b.a.a.h */
/* compiled from: Name */
public final class C0663h extends C0659d implements Serializable {

    /* renamed from: a */
    private final String f1272a;

    /* renamed from: b */
    private final String f1273b;

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    public C0663h() {
        this((String) null);
    }

    public C0663h(String str) {
        super(str);
        String[] split = C0002a.m2a(str).split("/");
        this.f1272a = m1953a(split, 1);
        this.f1273b = m1953a(split, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0663h)) {
            return false;
        }
        C0663h hVar = (C0663h) obj;
        if (this.f1272a == null) {
            if (hVar.f1272a != null) {
                return false;
            }
        } else if (!this.f1272a.equalsIgnoreCase(hVar.f1272a)) {
            return false;
        }
        if (this.f1273b == null) {
            if (hVar.f1273b != null) {
                return false;
            }
            return true;
        } else if (!this.f1273b.equalsIgnoreCase(hVar.f1273b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public String mo8056a() {
        StringBuilder sb = new StringBuilder();
        if (mo8057b()) {
            sb.append(C0002a.m2a(this.f1272a));
        }
        if (mo8058c()) {
            sb.append(" ");
        }
        if (mo8059d()) {
            sb.append(C0002a.m2a(this.f1273b));
        }
        return sb.toString();
    }

    /* renamed from: b */
    public boolean mo8057b() {
        return !C0002a.m10b(this.f1272a);
    }

    /* renamed from: c */
    public boolean mo8058c() {
        return mo8057b() && mo8059d();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f1272a == null ? 0 : this.f1272a.hashCode()) + 31) * 31;
        if (this.f1273b != null) {
            i = this.f1273b.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: d */
    public boolean mo8059d() {
        return !C0002a.m10b(this.f1273b);
    }

    /* renamed from: e */
    public boolean mo8060e() {
        return mo8057b() || mo8059d();
    }

    public String toString() {
        return mo8056a();
    }

    /* renamed from: a */
    private String m1953a(String[] strArr, int i) {
        if (strArr.length > i) {
            return C0003a.m13b(C0002a.m2a(strArr[i]), '.', '\'', ' ');
        }
        return "";
    }
}
