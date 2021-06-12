package p020b.p021a.p022a;

/* renamed from: b.a.a.l */
/* compiled from: ServiceCode1 */
public enum C0667l implements C0670o {
    f1278a(-1, "Unknown", ""),
    v_1(1, "International interchange", "None"),
    v_2(2, "International interchange", "Integrated circuit card"),
    v_5(5, "National interchange", "None"),
    v_6(6, "National interchange", "Integrated circuit card"),
    v_7(7, "Private", "None"),
    v_9(9, "Test", "Test");
    

    /* renamed from: h */
    private final int f1286h;

    /* renamed from: i */
    private final String f1287i;

    /* renamed from: j */
    private final String f1288j;

    private C0667l(int i, String str, String str2) {
        this.f1286h = i;
        this.f1287i = str;
        this.f1288j = str2;
    }

    /* renamed from: a */
    public String mo8072a() {
        return String.format("Interchange: %s. Technology: %s.", new Object[]{this.f1287i, this.f1288j});
    }

    /* renamed from: b */
    public int mo8073b() {
        return this.f1286h;
    }

    public String toString() {
        return String.format("%d - %s", new Object[]{Integer.valueOf(this.f1286h), mo8072a()});
    }
}
