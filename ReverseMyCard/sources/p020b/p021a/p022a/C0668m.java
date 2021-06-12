package p020b.p021a.p022a;

/* renamed from: b.a.a.m */
/* compiled from: ServiceCode2 */
public enum C0668m implements C0670o {
    f1289a(-1, "Unknown"),
    v_0(0, "Normal"),
    v_2(2, "By issuer"),
    v_4(4, "By issuer unless explicit bilateral agreeement applies");
    

    /* renamed from: e */
    private final int f1294e;

    /* renamed from: f */
    private final String f1295f;

    private C0668m(int i, String str) {
        this.f1294e = i;
        this.f1295f = str;
    }

    /* renamed from: a */
    public String mo8075a() {
        return String.format("Authorization Processing: %s.", new Object[]{this.f1295f});
    }

    /* renamed from: b */
    public int mo8073b() {
        return this.f1294e;
    }

    public String toString() {
        return String.format("%d - %s", new Object[]{Integer.valueOf(this.f1294e), mo8075a()});
    }
}
