package p020b.p021a.p022a;

/* renamed from: b.a.a.b */
/* compiled from: AccountNumberInfo */
public final class C0657b extends C0659d implements C0664i {

    /* renamed from: a */
    private final C0662g f1234a;

    /* renamed from: b */
    private final String f1235b;

    /* renamed from: c */
    private final String f1236c;

    /* renamed from: d */
    private final C0660e f1237d;

    /* renamed from: e */
    private final boolean f1238e;

    /* renamed from: f */
    private final int f1239f;

    /* renamed from: g */
    private final boolean f1240g;

    /* renamed from: h */
    private final boolean f1241h;

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    public C0657b(C0664i iVar) {
        super((String) null);
        iVar = iVar == null ? new C0656a() : iVar;
        this.f1234a = iVar.mo8031f();
        this.f1235b = iVar.mo8028d();
        this.f1236c = iVar.mo8029e();
        this.f1237d = iVar.mo8026c();
        this.f1238e = iVar.mo8036j();
        this.f1239f = iVar.mo8025b();
        this.f1240g = iVar.mo8033h();
        this.f1241h = iVar.mo8035i();
    }

    /* renamed from: a */
    public String mo8024a() {
        throw new IllegalAccessError("Account number is not available");
    }

    /* renamed from: b */
    public int mo8025b() {
        return this.f1239f;
    }

    /* renamed from: c */
    public C0660e mo8026c() {
        return this.f1237d;
    }

    /* renamed from: d */
    public String mo8028d() {
        return this.f1235b;
    }

    /* renamed from: e */
    public String mo8029e() {
        return this.f1236c;
    }

    /* renamed from: f */
    public C0662g mo8031f() {
        return this.f1234a;
    }

    /* renamed from: g */
    public boolean mo8032g() {
        return false;
    }

    /* renamed from: h */
    public boolean mo8033h() {
        return this.f1240g;
    }

    /* renamed from: i */
    public boolean mo8035i() {
        return this.f1241h;
    }

    /* renamed from: j */
    public boolean mo8036j() {
        return this.f1238e;
    }

    public String toString() {
        return String.format("%s-%s", new Object[]{this.f1237d, this.f1236c});
    }
}
