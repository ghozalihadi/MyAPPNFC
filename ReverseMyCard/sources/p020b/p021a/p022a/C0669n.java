package p020b.p021a.p022a;

/* renamed from: b.a.a.n */
/* compiled from: ServiceCode3 */
public enum C0669n implements C0670o {
    f1296a(-1, "Unknown", ""),
    v_0(0, "No restrictions", "PIN required"),
    v_1(1, "No restrictions", "None"),
    v_2(2, "Goods and services only", "None"),
    v_3(3, "ATM only", "PIN required"),
    v_4(4, "Cash only", "None"),
    v_5(5, "Goods and services only", "PIN required"),
    v_6(6, "No restrictions", "Prompt for PIN if PED present"),
    v_7(7, "Goods and services only", "Prompt for PIN if PED present");
    

    /* renamed from: j */
    private final int f1306j;

    /* renamed from: k */
    private final String f1307k;

    /* renamed from: l */
    private final String f1308l;

    private C0669n(int i, String str, String str2) {
        this.f1306j = i;
        this.f1307k = str;
        this.f1308l = str2;
    }

    /* renamed from: a */
    public String mo8077a() {
        return String.format("Allowed Services: %s. PIN Requirements: %s.", new Object[]{this.f1307k, this.f1308l});
    }

    /* renamed from: b */
    public int mo8073b() {
        return this.f1306j;
    }

    public String toString() {
        return String.format("%d - %s", new Object[]{Integer.valueOf(this.f1306j), mo8077a()});
    }
}
