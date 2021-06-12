package p020b.p021a.p023b.p024a;

import p020b.p021a.p022a.C0658c;
import p020b.p021a.p022a.C0661f;
import p020b.p021a.p022a.C0663h;
import p020b.p021a.p022a.C0664i;
import p020b.p021a.p022a.C0666k;

/* renamed from: b.a.b.a.a */
/* compiled from: BankCardMagneticTrack */
public class C0672a extends C0674c {

    /* renamed from: a */
    private final C0675d f1310a;

    /* renamed from: b */
    private final C0676e f1311b;

    /* renamed from: c */
    private final C0677f f1312c;

    /* renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo8082d() {
        return super.mo8082d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ boolean mo8083e() {
        return super.mo8083e();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ String mo8084f() {
        return super.mo8084f();
    }

    /* renamed from: k */
    public /* bridge */ /* synthetic */ String mo8037k() {
        return super.mo8037k();
    }

    /* renamed from: a */
    public static C0672a m1985a(String str) {
        return new C0672a(str, C0675d.m2004a(str), C0676e.m2017a(str), C0677f.m2028a(str));
    }

    private C0672a(String str, C0675d dVar, C0676e eVar, C0677f fVar) {
        super(str, "");
        this.f1310a = dVar;
        this.f1311b = eVar;
        this.f1312c = fVar;
    }

    /* renamed from: a */
    public C0675d mo8079a() {
        return this.f1310a;
    }

    /* renamed from: b */
    public C0676e mo8080b() {
        return this.f1311b;
    }

    /* renamed from: c */
    public C0658c mo8081c() {
        C0664i b;
        C0663h hVar;
        C0661f a;
        C0666k c;
        if (this.f1310a.mo8091h()) {
            b = this.f1310a.mo8087b();
        } else {
            b = this.f1311b.mo8087b();
        }
        if (this.f1310a.mo8095l()) {
            hVar = this.f1310a.mo8094j();
        } else {
            hVar = new C0663h();
        }
        if (this.f1310a.mo8090g()) {
            a = this.f1310a.mo8086a();
        } else {
            a = this.f1311b.mo8086a();
        }
        if (this.f1310a.mo8093i()) {
            c = this.f1310a.mo8088c();
        } else {
            c = this.f1311b.mo8088c();
        }
        return new C0658c(b, a, hVar, c);
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("TRACK 1: ");
        if (this.f1310a.mo8082d()) {
            sb.append(this.f1310a.mo8037k()).append(property);
            if (this.f1310a.mo8091h()) {
                sb.append("  Primary Account Number: ").append(this.f1310a.mo8087b()).append(property);
            } else {
                sb.append("  No Primary Account Number").append(property);
            }
            if (this.f1310a.mo8090g()) {
                sb.append("  Expiration Date: ");
                sb.append(this.f1311b.mo8086a()).append(property);
            } else {
                sb.append("  No Expiration Date").append(property);
            }
            if (this.f1310a.mo8095l()) {
                sb.append("  Name: ");
                sb.append(this.f1310a.mo8094j()).append(property);
            } else {
                sb.append("  No Name").append(property);
            }
            if (this.f1310a.mo8093i()) {
                sb.append("  Service Code: ").append(this.f1310a.mo8088c()).append(property);
            } else {
                sb.append("  No Service Code");
            }
            if (this.f1310a.mo8083e()) {
                sb.append("  Discretionary Data: ");
                sb.append(this.f1310a.mo8084f()).append(property);
            } else {
                sb.append("  No Discretionary Data");
            }
        } else {
            sb.append(" Not Available.").append(property);
        }
        sb.append("TRACK 2: ");
        if (this.f1311b.mo8082d()) {
            sb.append(this.f1311b.mo8037k()).append(property);
            if (this.f1311b.mo8091h()) {
                sb.append("  Primary Account Number: ").append(this.f1311b.mo8087b()).append(property);
            } else {
                sb.append("  No Primary Account Number").append(property);
            }
            if (this.f1311b.mo8090g()) {
                sb.append("  Expiration Date: ");
                sb.append(this.f1311b.mo8086a()).append(property);
            } else {
                sb.append("No Expiration Date").append(property);
            }
            if (this.f1311b.mo8093i()) {
                sb.append("  Service Code: ").append(this.f1311b.mo8088c()).append(property);
            } else {
                sb.append("  No Service Code");
            }
            if (this.f1311b.mo8083e()) {
                sb.append("  Discretionary Data: ");
                sb.append(this.f1311b.mo8084f()).append(property);
            } else {
                sb.append("  No Discretionary Data");
            }
        } else {
            sb.append(" Not Available.").append(property);
        }
        sb.append("TRACK 3: ");
        if (this.f1312c.mo8082d()) {
            sb.append(this.f1312c.mo8037k()).append(property);
            if (this.f1312c.mo8083e()) {
                sb.append("  Discretionary Data: ");
                sb.append(this.f1312c.mo8084f()).append(property);
            } else {
                sb.append("  No Discretionary Data");
            }
        } else {
            sb.append(" Not Available.").append(property);
        }
        sb.append(property).append(mo8081c()).append(property);
        return sb.toString();
    }
}
