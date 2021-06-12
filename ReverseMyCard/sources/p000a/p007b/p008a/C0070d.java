package p000a.p007b.p008a;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0087h;

/* renamed from: a.b.a.d */
/* compiled from: Duration */
public final class C0070d implements C0087h, Serializable, Comparable<C0070d> {

    /* renamed from: a */
    public static final C0070d f173a = new C0070d(0, 0);

    /* renamed from: b */
    private static final BigInteger f174b = BigInteger.valueOf(1000000000);

    /* renamed from: c */
    private static final Pattern f175c = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

    /* renamed from: d */
    private final long f176d;

    /* renamed from: e */
    private final int f177e;

    /* renamed from: a */
    public static C0070d m388a(long j) {
        return m389a(j, 0);
    }

    /* renamed from: a */
    public static C0070d m390a(long j, long j2) {
        return m389a(C0069c.m382b(j, C0069c.m386e(j2, 1000000000)), C0069c.m381b(j2, 1000000000));
    }

    /* renamed from: b */
    public static C0070d m391b(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i += 1000000000;
            j2--;
        }
        return m389a(j2, i);
    }

    /* renamed from: a */
    private static C0070d m389a(long j, int i) {
        if ((((long) i) | j) == 0) {
            return f173a;
        }
        return new C0070d(j, i);
    }

    private C0070d(long j, int i) {
        this.f176d = j;
        this.f177e = i;
    }

    /* renamed from: a */
    public long mo240a() {
        return this.f176d;
    }

    /* renamed from: a */
    public C0081d mo241a(C0081d dVar) {
        if (this.f176d != 0) {
            dVar = dVar.mo30d(this.f176d, C0072b.SECONDS);
        }
        if (this.f177e != 0) {
            return dVar.mo30d((long) this.f177e, C0072b.NANOS);
        }
        return dVar;
    }

    /* renamed from: a */
    public int compareTo(C0070d dVar) {
        int a = C0069c.m376a(this.f176d, dVar.f176d);
        return a != 0 ? a : this.f177e - dVar.f177e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0070d)) {
            return false;
        }
        C0070d dVar = (C0070d) obj;
        if (this.f176d == dVar.f176d && this.f177e == dVar.f177e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((int) (this.f176d ^ (this.f176d >>> 32))) + (this.f177e * 51);
    }

    public String toString() {
        if (this == f173a) {
            return "PT0S";
        }
        long j = this.f176d / 3600;
        int i = (int) ((this.f176d % 3600) / 60);
        int i2 = (int) (this.f176d % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j != 0) {
            sb.append(j).append('H');
        }
        if (i != 0) {
            sb.append(i).append('M');
        }
        if (i2 == 0 && this.f177e == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i2 >= 0 || this.f177e <= 0) {
            sb.append(i2);
        } else if (i2 == -1) {
            sb.append("-0");
        } else {
            sb.append(i2 + 1);
        }
        if (this.f177e > 0) {
            int length = sb.length();
            if (i2 < 0) {
                sb.append(2000000000 - this.f177e);
            } else {
                sb.append(this.f177e + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
