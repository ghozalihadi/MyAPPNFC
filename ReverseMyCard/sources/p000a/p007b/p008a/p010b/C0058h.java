package p000a.p007b.p008a.p010b;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: a.b.a.b.h */
/* compiled from: DecimalStyle */
public final class C0058h {

    /* renamed from: a */
    public static final C0058h f136a = new C0058h('0', '+', '-', '.');

    /* renamed from: b */
    private static final ConcurrentMap<Locale, C0058h> f137b = new ConcurrentHashMap(16, 0.75f, 2);

    /* renamed from: c */
    private final char f138c;

    /* renamed from: d */
    private final char f139d;

    /* renamed from: e */
    private final char f140e;

    /* renamed from: f */
    private final char f141f;

    private C0058h(char c, char c2, char c3, char c4) {
        this.f138c = c;
        this.f139d = c2;
        this.f140e = c3;
        this.f141f = c4;
    }

    /* renamed from: a */
    public char mo221a() {
        return this.f138c;
    }

    /* renamed from: b */
    public char mo224b() {
        return this.f139d;
    }

    /* renamed from: c */
    public char mo225c() {
        return this.f140e;
    }

    /* renamed from: d */
    public char mo226d() {
        return this.f141f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo222a(char c) {
        int i = c - this.f138c;
        if (i < 0 || i > 9) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo223a(String str) {
        if (this.f138c == '0') {
            return str;
        }
        int i = this.f138c - '0';
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            charArray[i2] = (char) (charArray[i2] + i);
        }
        return new String(charArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0058h)) {
            return false;
        }
        C0058h hVar = (C0058h) obj;
        if (this.f138c == hVar.f138c && this.f139d == hVar.f139d && this.f140e == hVar.f140e && this.f141f == hVar.f141f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f138c + this.f139d + this.f140e + this.f141f;
    }

    public String toString() {
        return "DecimalStyle[" + this.f138c + this.f139d + this.f140e + this.f141f + "]";
    }
}
