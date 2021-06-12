package p000a.p007b.p008a.p011c;

/* renamed from: a.b.a.c.c */
/* compiled from: Jdk8Methods */
public final class C0069c {
    /* renamed from: a */
    public static <T> T m378a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " must not be null");
    }

    /* renamed from: a */
    public static boolean m379a(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        } else if (obj2 != null) {
            return obj.equals(obj2);
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public static int m374a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m376a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        return 0;
    }

    /* renamed from: b */
    public static long m382b(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        throw new ArithmeticException("Addition overflows a long: " + j + " + " + j2);
    }

    /* renamed from: b */
    public static int m380b(int i, int i2) {
        int i3 = i - i2;
        if ((i ^ i3) >= 0 || (i ^ i2) >= 0) {
            return i3;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i + " - " + i2);
    }

    /* renamed from: c */
    public static long m384c(long j, long j2) {
        long j3 = j - j2;
        if ((j ^ j3) >= 0 || (j ^ j2) >= 0) {
            return j3;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j + " - " + j2);
    }

    /* renamed from: a */
    public static long m377a(long j, int i) {
        switch (i) {
            case -1:
                if (j != Long.MIN_VALUE) {
                    return -j;
                }
                throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
            case 0:
                return 0;
            case 1:
                return j;
            default:
                long j2 = ((long) i) * j;
                if (j2 / ((long) i) == j) {
                    return j2;
                }
                throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
        }
    }

    /* renamed from: d */
    public static long m385d(long j, long j2) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + j2);
    }

    /* renamed from: a */
    public static int m375a(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j);
    }

    /* renamed from: e */
    public static long m386e(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    /* renamed from: f */
    public static long m387f(long j, long j2) {
        return ((j % j2) + j2) % j2;
    }

    /* renamed from: b */
    public static int m381b(long j, int i) {
        return (int) (((j % ((long) i)) + ((long) i)) % ((long) i));
    }

    /* renamed from: c */
    public static int m383c(int i, int i2) {
        return ((i % i2) + i2) % i2;
    }
}
