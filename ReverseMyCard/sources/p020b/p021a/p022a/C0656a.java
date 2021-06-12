package p020b.p021a.p022a;

import java.util.Arrays;
import p000a.p001a.p002a.p005b.C0002a;

/* renamed from: b.a.a.a */
/* compiled from: AccountNumber */
public final class C0656a extends C0659d implements C0664i, Comparable<C0656a> {

    /* renamed from: a */
    private final String f1230a;

    /* renamed from: b */
    private final C0660e f1231b;

    /* renamed from: c */
    private final C0662g f1232c;

    /* renamed from: d */
    private final boolean f1233d;

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    public C0656a() {
        this((String) null);
    }

    public C0656a(String str) {
        super(str);
        this.f1230a = C0671p.f1309a.matcher(C0002a.m2a(str)).replaceAll("");
        this.f1233d = m1916l();
        this.f1232c = C0662g.m1951a(this.f1230a);
        this.f1231b = C0660e.m1947a(this.f1230a);
    }

    /* renamed from: a */
    public int compareTo(C0656a aVar) {
        if (aVar == null) {
            return 1;
        }
        if (!mo8032g() && !aVar.mo8032g()) {
            return 0;
        }
        if (!mo8032g() || aVar.mo8032g()) {
            return this.f1230a.compareTo(aVar.f1230a);
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0656a)) {
            return false;
        }
        C0656a aVar = (C0656a) obj;
        if (this.f1230a == null) {
            if (aVar.f1230a != null) {
                return false;
            }
            return true;
        } else if (!this.f1230a.equals(aVar.f1230a)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public String mo8024a() {
        return this.f1230a;
    }

    /* renamed from: b */
    public int mo8025b() {
        return this.f1230a.length();
    }

    /* renamed from: c */
    public C0660e mo8026c() {
        return this.f1231b;
    }

    /* renamed from: d */
    public String mo8028d() {
        return C0002a.m5a(C0002a.m3a(this.f1230a, 6), 6, "0");
    }

    /* renamed from: e */
    public String mo8029e() {
        return C0002a.m9b(C0002a.m7b(this.f1230a, 4), 4, "0");
    }

    /* renamed from: f */
    public C0662g mo8031f() {
        return this.f1232c;
    }

    public int hashCode() {
        int hashCode;
        if (this.f1230a == null) {
            hashCode = 0;
        } else {
            hashCode = this.f1230a.hashCode();
        }
        return hashCode + 31;
    }

    /* renamed from: g */
    public boolean mo8032g() {
        return !C0002a.m10b(this.f1230a);
    }

    /* renamed from: h */
    public boolean mo8033h() {
        return Arrays.asList(new Integer[]{13, 14, 15, 16, 19}).contains(Integer.valueOf(mo8025b()));
    }

    /* renamed from: i */
    public boolean mo8035i() {
        return mo8032g() && mo8033h() && mo8036j() && this.f1231b != null && this.f1231b != C0660e.Unknown;
    }

    /* renamed from: j */
    public boolean mo8036j() {
        return this.f1233d;
    }

    public String toString() {
        return this.f1230a;
    }

    /* renamed from: l */
    private boolean m1916l() {
        int length = this.f1230a.length() - 1;
        boolean z = false;
        int i = 0;
        while (length >= 0) {
            int digit = Character.digit(this.f1230a.charAt(length), 10);
            if (z && (digit = digit * 2) > 9) {
                digit -= 9;
            }
            i += digit;
            length--;
            z = !z;
        }
        if (i % 10 == 0) {
            return true;
        }
        return false;
    }
}
