package p020b.p021a.p023b.p024a;

import p020b.p021a.p022a.C0661f;
import p020b.p021a.p022a.C0664i;
import p020b.p021a.p022a.C0666k;

/* renamed from: b.a.b.a.b */
/* compiled from: BaseBankCardTrackData */
abstract class C0673b extends C0674c {

    /* renamed from: a */
    private final C0664i f1313a;

    /* renamed from: b */
    private final C0661f f1314b;

    /* renamed from: c */
    private final C0666k f1315c;

    C0673b(String str, C0664i iVar, C0661f fVar, C0666k kVar, String str2) {
        super(str, str2);
        this.f1313a = iVar;
        this.f1314b = fVar;
        this.f1315c = kVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0673b)) {
            return false;
        }
        C0673b bVar = (C0673b) obj;
        if (this.f1314b == null) {
            if (bVar.f1314b != null) {
                return false;
            }
        } else if (!this.f1314b.equals(bVar.f1314b)) {
            return false;
        }
        if (this.f1313a == null) {
            if (bVar.f1313a != null) {
                return false;
            }
        } else if (!this.f1313a.equals(bVar.f1313a)) {
            return false;
        }
        if (this.f1315c == null) {
            if (bVar.f1315c != null) {
                return false;
            }
            return true;
        } else if (!this.f1315c.equals(bVar.f1315c)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public C0661f mo8086a() {
        return this.f1314b;
    }

    /* renamed from: b */
    public C0664i mo8087b() {
        return this.f1313a;
    }

    /* renamed from: c */
    public C0666k mo8088c() {
        return this.f1315c;
    }

    /* renamed from: g */
    public boolean mo8090g() {
        return this.f1314b != null && this.f1314b.mo8049a();
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f1314b == null) {
            hashCode = 0;
        } else {
            hashCode = this.f1314b.hashCode();
        }
        int hashCode2 = ((this.f1313a == null ? 0 : this.f1313a.hashCode()) + ((hashCode + 31) * 31)) * 31;
        if (this.f1315c != null) {
            i = this.f1315c.hashCode();
        }
        return hashCode2 + i;
    }

    /* renamed from: h */
    public boolean mo8091h() {
        return this.f1313a != null && this.f1313a.mo8032g();
    }

    /* renamed from: i */
    public boolean mo8093i() {
        return this.f1315c != null && this.f1315c.mo8068e();
    }
}
