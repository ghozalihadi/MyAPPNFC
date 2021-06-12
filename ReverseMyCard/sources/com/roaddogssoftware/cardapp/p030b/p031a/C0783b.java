package com.roaddogssoftware.cardapp.p030b.p031a;

/* renamed from: com.roaddogssoftware.cardapp.b.a.b */
/* compiled from: Peak */
public class C0783b {

    /* renamed from: a */
    public int f1752a;

    /* renamed from: b */
    public int f1753b;

    public C0783b() {
        this(0, 0);
    }

    public C0783b(int i, int i2) {
        this.f1752a = i;
        this.f1753b = i2;
    }

    /* renamed from: a */
    public boolean mo8309a() {
        return this.f1753b > 0;
    }

    /* renamed from: a */
    public boolean mo8310a(C0783b bVar) {
        return (mo8309a() && bVar.mo8309a()) || (!mo8309a() && !bVar.mo8309a());
    }

    public String toString() {
        return "[idx: " + this.f1752a + ", " + "value: " + this.f1753b + "]";
    }
}
