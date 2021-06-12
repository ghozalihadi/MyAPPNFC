package p000a.p007b.p008a.p012d;

import java.io.Serializable;
import p000a.p007b.p008a.C0023b;

/* renamed from: a.b.a.d.n */
/* compiled from: ValueRange */
public final class C0100n implements Serializable {

    /* renamed from: a */
    private final long f259a;

    /* renamed from: b */
    private final long f260b;

    /* renamed from: c */
    private final long f261c;

    /* renamed from: d */
    private final long f262d;

    /* renamed from: a */
    public static C0100n m491a(long j, long j2) {
        if (j <= j2) {
            return new C0100n(j, j, j2, j2);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    /* renamed from: a */
    public static C0100n m492a(long j, long j2, long j3) {
        return m493a(j, j, j2, j3);
    }

    /* renamed from: a */
    public static C0100n m493a(long j, long j2, long j3, long j4) {
        if (j > j2) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j3 > j4) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j2 <= j4) {
            return new C0100n(j, j2, j3, j4);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    private C0100n(long j, long j2, long j3, long j4) {
        this.f259a = j;
        this.f260b = j2;
        this.f261c = j3;
        this.f262d = j4;
    }

    /* renamed from: a */
    public boolean mo273a() {
        return this.f259a == this.f260b && this.f261c == this.f262d;
    }

    /* renamed from: b */
    public long mo276b() {
        return this.f259a;
    }

    /* renamed from: c */
    public long mo278c() {
        return this.f262d;
    }

    /* renamed from: d */
    public boolean mo279d() {
        return mo276b() >= -2147483648L && mo278c() <= 2147483647L;
    }

    /* renamed from: a */
    public boolean mo274a(long j) {
        return j >= mo276b() && j <= mo278c();
    }

    /* renamed from: b */
    public boolean mo277b(long j) {
        return mo279d() && mo274a(j);
    }

    /* renamed from: a */
    public long mo272a(long j, C0088i iVar) {
        if (mo274a(j)) {
            return j;
        }
        if (iVar != null) {
            throw new C0023b("Invalid value for " + iVar + " (valid values " + this + "): " + j);
        }
        throw new C0023b("Invalid value (valid values " + this + "): " + j);
    }

    /* renamed from: b */
    public int mo275b(long j, C0088i iVar) {
        if (mo277b(j)) {
            return (int) j;
        }
        throw new C0023b("Invalid int value for " + iVar + ": " + j);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0100n)) {
            return false;
        }
        C0100n nVar = (C0100n) obj;
        if (this.f259a == nVar.f259a && this.f260b == nVar.f260b && this.f261c == nVar.f261c && this.f262d == nVar.f262d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = ((((((this.f259a + this.f260b) << ((int) (16 + this.f260b))) >> ((int) (this.f261c + 48))) << ((int) (this.f261c + 32))) >> ((int) (this.f262d + 32))) << ((int) (this.f262d + 48))) >> 16;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f259a);
        if (this.f259a != this.f260b) {
            sb.append('/').append(this.f260b);
        }
        sb.append(" - ").append(this.f261c);
        if (this.f261c != this.f262d) {
            sb.append('/').append(this.f262d);
        }
        return sb.toString();
    }
}
