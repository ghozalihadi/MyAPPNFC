package p020b.p021a.p022a;

import java.io.Serializable;

/* renamed from: b.a.a.c */
/* compiled from: BankCard */
public final class C0658c implements Serializable {

    /* renamed from: a */
    private final C0664i f1242a;

    /* renamed from: b */
    private final C0663h f1243b;

    /* renamed from: c */
    private final C0661f f1244c;

    /* renamed from: d */
    private final C0666k f1245d;

    public C0658c() {
        this((C0664i) null);
    }

    public C0658c(C0664i iVar) {
        this(iVar, (C0661f) null);
    }

    public C0658c(C0664i iVar, C0661f fVar) {
        this(iVar, fVar, (C0663h) null);
    }

    public C0658c(C0664i iVar, C0661f fVar, C0663h hVar) {
        this(iVar, fVar, hVar, (C0666k) null);
    }

    public C0658c(C0664i iVar, C0661f fVar, C0663h hVar, C0666k kVar) {
        if (iVar != null) {
            this.f1242a = iVar;
        } else {
            this.f1242a = new C0656a();
        }
        if (hVar != null) {
            this.f1243b = hVar;
        } else {
            this.f1243b = new C0663h();
        }
        if (fVar != null) {
            this.f1244c = fVar;
        } else {
            this.f1244c = new C0661f();
        }
        if (kVar != null) {
            this.f1245d = kVar;
        } else {
            this.f1245d = new C0666k();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0658c)) {
            return false;
        }
        C0658c cVar = (C0658c) obj;
        if (this.f1244c == null) {
            if (cVar.f1244c != null) {
                return false;
            }
        } else if (!this.f1244c.equals(cVar.f1244c)) {
            return false;
        }
        if (this.f1243b == null) {
            if (cVar.f1243b != null) {
                return false;
            }
        } else if (!this.f1243b.equals(cVar.f1243b)) {
            return false;
        }
        if (this.f1242a == null) {
            if (cVar.f1242a != null) {
                return false;
            }
            return true;
        } else if (!this.f1242a.equals(cVar.f1242a)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public C0663h mo8040a() {
        return this.f1243b;
    }

    /* renamed from: b */
    public C0666k mo8041b() {
        return this.f1245d;
    }

    /* renamed from: c */
    public boolean mo8042c() {
        return this.f1244c != null && this.f1244c.mo8049a();
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f1244c == null) {
            hashCode = 0;
        } else {
            hashCode = this.f1244c.hashCode();
        }
        int hashCode2 = ((this.f1243b == null ? 0 : this.f1243b.hashCode()) + ((hashCode + 31) * 31)) * 31;
        if (this.f1242a != null) {
            i = this.f1242a.hashCode();
        }
        return hashCode2 + i;
    }

    /* renamed from: d */
    public boolean mo8043d() {
        return this.f1243b != null && this.f1243b.mo8060e();
    }

    /* renamed from: e */
    public boolean mo8044e() {
        return this.f1242a != null && this.f1242a.mo8032g();
    }

    /* renamed from: f */
    public boolean mo8046f() {
        return this.f1245d != null && this.f1245d.mo8068e();
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("Bank Card Information: ").append(property);
        if (mo8044e()) {
            sb.append("  Raw Account Number: ");
            sb.append(this.f1242a.mo8037k()).append(property);
            sb.append("  Primary Account Number: ");
            sb.append(this.f1242a).append(property);
            sb.append("  Primary Account Number (Secure): ");
            sb.append(new C0657b(this.f1242a)).append(property);
            sb.append("    Major Industry Identifier: ");
            sb.append(this.f1242a.mo8031f()).append(property);
            sb.append("    Issuer Identification Number: ");
            sb.append(this.f1242a.mo8028d()).append(property);
            sb.append("    Card Brand: ");
            sb.append(this.f1242a.mo8026c()).append(property);
            sb.append("    Last Four Digits: ");
            sb.append(this.f1242a.mo8029e()).append(property);
            sb.append("    Passes Luhn Check? ");
            sb.append(this.f1242a.mo8036j() ? "Yes" : "No").append(property);
            sb.append("    Is Primary Account Number Valid? ");
            sb.append(this.f1242a.mo8035i() ? "Yes" : "No").append(property);
        }
        if (mo8042c()) {
            sb.append("  Expiration Date: ");
            sb.append(this.f1244c).append(property);
            sb.append("    Is Expired: ");
            sb.append(this.f1244c.mo8050b() ? "Yes" : "No").append(property);
        }
        if (mo8043d()) {
            sb.append("  Name: ");
            sb.append(mo8040a()).append(property);
        }
        if (mo8046f()) {
            C0666k b = mo8041b();
            sb.append("  Service Code: ");
            sb.append(property);
            sb.append("    ");
            sb.append(b.mo8065b()).append(property);
            sb.append("    ");
            sb.append(b.mo8066c()).append(property);
            sb.append("    ");
            sb.append(b.mo8067d()).append(property);
        }
        return sb.toString();
    }
}
