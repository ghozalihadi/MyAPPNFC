package android.support.p014a.p015a;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.a.a.c */
/* compiled from: PathParser */
class C0147c {
    /* renamed from: a */
    static float[] m901a(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    /* renamed from: a */
    public static C0149b[] m902a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a = m898a(str, i);
            String trim = str.substring(i2, a).trim();
            if (trim.length() > 0) {
                m900a((ArrayList<C0149b>) arrayList, trim.charAt(0), m904b(trim));
            }
            i = a + 1;
            i2 = a;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            m900a((ArrayList<C0149b>) arrayList, str.charAt(i2), new float[0]);
        }
        return (C0149b[]) arrayList.toArray(new C0149b[arrayList.size()]);
    }

    /* renamed from: a */
    public static C0149b[] m903a(C0149b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        C0149b[] bVarArr2 = new C0149b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new C0149b(bVarArr[i]);
        }
        return bVarArr2;
    }

    /* renamed from: a */
    private static int m898a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private static void m900a(ArrayList<C0149b> arrayList, char c, float[] fArr) {
        arrayList.add(new C0149b(c, fArr));
    }

    /* renamed from: android.support.a.a.c$a */
    /* compiled from: PathParser */
    private static class C0148a {

        /* renamed from: a */
        int f410a;

        /* renamed from: b */
        boolean f411b;

        C0148a() {
        }
    }

    /* renamed from: b */
    private static float[] m904b(String str) {
        int i;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            C0148a aVar = new C0148a();
            int length = str.length();
            int i2 = 0;
            int i3 = 1;
            while (i3 < length) {
                m899a(str, i3, aVar);
                int i4 = aVar.f410a;
                if (i3 < i4) {
                    i = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i3, i4));
                } else {
                    i = i2;
                }
                if (aVar.f411b) {
                    i3 = i4;
                    i2 = i;
                } else {
                    i3 = i4 + 1;
                    i2 = i;
                }
            }
            return m901a(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m899a(java.lang.String r7, int r8, android.support.p014a.p015a.C0147c.C0148a r9) {
        /*
            r1 = 0
            r5 = 1
            r9.f411b = r1
            r0 = r1
            r2 = r1
            r3 = r1
            r4 = r8
        L_0x0008:
            int r6 = r7.length()
            if (r4 >= r6) goto L_0x0018
            char r6 = r7.charAt(r4)
            switch(r6) {
                case 32: goto L_0x001b;
                case 44: goto L_0x001b;
                case 45: goto L_0x001e;
                case 46: goto L_0x0027;
                case 69: goto L_0x0031;
                case 101: goto L_0x0031;
                default: goto L_0x0015;
            }
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r3 == 0) goto L_0x0033
        L_0x0018:
            r9.f410a = r4
            return
        L_0x001b:
            r0 = r1
            r3 = r5
            goto L_0x0016
        L_0x001e:
            if (r4 == r8) goto L_0x0015
            if (r0 != 0) goto L_0x0015
            r9.f411b = r5
            r0 = r1
            r3 = r5
            goto L_0x0016
        L_0x0027:
            if (r2 != 0) goto L_0x002c
            r0 = r1
            r2 = r5
            goto L_0x0016
        L_0x002c:
            r9.f411b = r5
            r0 = r1
            r3 = r5
            goto L_0x0016
        L_0x0031:
            r0 = r5
            goto L_0x0016
        L_0x0033:
            int r4 = r4 + 1
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p014a.p015a.C0147c.m899a(java.lang.String, int, android.support.a.a.c$a):void");
    }

    /* renamed from: android.support.a.a.c$b */
    /* compiled from: PathParser */
    public static class C0149b {

        /* renamed from: a */
        char f412a;

        /* renamed from: b */
        float[] f413b;

        C0149b(char c, float[] fArr) {
            this.f412a = c;
            this.f413b = fArr;
        }

        C0149b(C0149b bVar) {
            this.f412a = bVar.f412a;
            this.f413b = C0147c.m901a(bVar.f413b, 0, bVar.f413b.length);
        }

        /* renamed from: a */
        public static void m908a(C0149b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                m907a(path, fArr, c, bVarArr[i].f412a, bVarArr[i].f413b);
                c = bVarArr[i].f412a;
            }
        }

        /* renamed from: a */
        private static void m907a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            boolean z;
            float f;
            float f2;
            int i2;
            float f3;
            int i3;
            int i4;
            boolean z2;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            int i5 = fArr[0];
            int i6 = fArr[1];
            int i7 = fArr[2];
            int i8 = fArr[3];
            int i9 = fArr[4];
            int i10 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(i9, i10);
                    i8 = i10;
                    i7 = i9;
                    i6 = i10;
                    i5 = i9;
                    i = 2;
                    break;
                default:
                    i = 2;
                    break;
            }
            int i11 = 0;
            int i12 = i10;
            int i13 = i9;
            int i14 = i6;
            int i15 = i5;
            while (i11 < fArr2.length) {
                switch (c2) {
                    case 'A':
                        float f10 = fArr2[i11 + 5];
                        float f11 = fArr2[i11 + 6];
                        float f12 = fArr2[i11 + 0];
                        float f13 = fArr2[i11 + 1];
                        float f14 = fArr2[i11 + 2];
                        boolean z3 = fArr2[i11 + 3] != 0.0f;
                        if (fArr2[i11 + 4] != 0.0f) {
                            z = true;
                        } else {
                            z = false;
                        }
                        m906a(path, i15, i14, f10, f11, f12, f13, f14, z3, z);
                        int i16 = fArr2[i11 + 5];
                        int i17 = fArr2[i11 + 6];
                        f = i12;
                        f2 = i13;
                        i2 = i16;
                        f3 = i17;
                        i3 = i16;
                        i4 = i17;
                        break;
                    case 'C':
                        path.cubicTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3], fArr2[i11 + 4], fArr2[i11 + 5]);
                        float f15 = fArr2[i11 + 4];
                        int i18 = fArr2[i11 + 5];
                        i2 = fArr2[i11 + 2];
                        f3 = i18;
                        i3 = f15;
                        f = i12;
                        f2 = i13;
                        i4 = fArr2[i11 + 3];
                        break;
                    case 'H':
                        path.lineTo(fArr2[i11 + 0], i14);
                        f = i12;
                        i2 = i7;
                        f3 = i14;
                        i3 = fArr2[i11 + 0];
                        i4 = i8;
                        f2 = i13;
                        break;
                    case 'L':
                        path.lineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                        float f16 = fArr2[i11 + 0];
                        i2 = i7;
                        f3 = fArr2[i11 + 1];
                        i3 = f16;
                        f = i12;
                        f2 = i13;
                        i4 = i8;
                        break;
                    case 'M':
                        f2 = fArr2[i11 + 0];
                        f = fArr2[i11 + 1];
                        if (i11 <= 0) {
                            path.moveTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                            i2 = i7;
                            f3 = f;
                            i3 = f2;
                            i4 = i8;
                            break;
                        } else {
                            path.lineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                            i2 = i7;
                            f3 = f;
                            i3 = f2;
                            f = i12;
                            f2 = i13;
                            i4 = i8;
                            break;
                        }
                    case 'Q':
                        path.quadTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                        float f17 = fArr2[i11 + 0];
                        int i19 = fArr2[i11 + 1];
                        float f18 = fArr2[i11 + 2];
                        i2 = f17;
                        f3 = fArr2[i11 + 3];
                        i3 = f18;
                        f = i12;
                        f2 = i13;
                        i4 = i19;
                        break;
                    case 'S':
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f7 = (2.0f * i15) - i7;
                            f6 = (2.0f * i14) - i8;
                        } else {
                            f6 = i14;
                            f7 = i15;
                        }
                        path.cubicTo(f7, f6, fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                        int i20 = fArr2[i11 + 0];
                        int i21 = fArr2[i11 + 1];
                        float f19 = fArr2[i11 + 2];
                        i2 = i20;
                        f3 = fArr2[i11 + 3];
                        i3 = f19;
                        f = i12;
                        f2 = i13;
                        i4 = i21;
                        break;
                    case 'T':
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            i15 = (2.0f * i15) - i7;
                            i14 = (2.0f * i14) - i8;
                        }
                        path.quadTo(i15, i14, fArr2[i11 + 0], fArr2[i11 + 1]);
                        float f20 = fArr2[i11 + 0];
                        i4 = i14;
                        i2 = i15;
                        f3 = fArr2[i11 + 1];
                        i3 = f20;
                        f = i12;
                        f2 = i13;
                        break;
                    case 'V':
                        path.lineTo(i15, fArr2[i11 + 0]);
                        f2 = i13;
                        i2 = i7;
                        f3 = fArr2[i11 + 0];
                        i3 = i15;
                        i4 = i8;
                        f = i12;
                        break;
                    case 'a':
                        float f21 = fArr2[i11 + 5] + i15;
                        float f22 = fArr2[i11 + 6] + i14;
                        float f23 = fArr2[i11 + 0];
                        float f24 = fArr2[i11 + 1];
                        float f25 = fArr2[i11 + 2];
                        boolean z4 = fArr2[i11 + 3] != 0.0f;
                        if (fArr2[i11 + 4] != 0.0f) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        m906a(path, i15, i14, f21, f22, f23, f24, f25, z4, z2);
                        float f26 = i15 + fArr2[i11 + 5];
                        float f27 = fArr2[i11 + 6] + i14;
                        f = i12;
                        f2 = i13;
                        i2 = f26;
                        f3 = f27;
                        i3 = f26;
                        i4 = f27;
                        break;
                    case 'c':
                        path.rCubicTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3], fArr2[i11 + 4], fArr2[i11 + 5]);
                        float f28 = i15 + fArr2[i11 + 2];
                        float f29 = i15 + fArr2[i11 + 4];
                        i2 = f28;
                        f3 = fArr2[i11 + 5] + i14;
                        i3 = f29;
                        f = i12;
                        f2 = i13;
                        i4 = fArr2[i11 + 3] + i14;
                        break;
                    case 'h':
                        path.rLineTo(fArr2[i11 + 0], 0.0f);
                        f = i12;
                        i2 = i7;
                        f3 = i14;
                        i3 = i15 + fArr2[i11 + 0];
                        i4 = i8;
                        f2 = i13;
                        break;
                    case 'l':
                        path.rLineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                        float f30 = i15 + fArr2[i11 + 0];
                        i2 = i7;
                        f3 = fArr2[i11 + 1] + i14;
                        i3 = f30;
                        f = i12;
                        f2 = i13;
                        i4 = i8;
                        break;
                    case 'm':
                        f2 = i15 + fArr2[i11 + 0];
                        f = fArr2[i11 + 1] + i14;
                        if (i11 <= 0) {
                            path.rMoveTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                            i2 = i7;
                            f3 = f;
                            i3 = f2;
                            i4 = i8;
                            break;
                        } else {
                            path.rLineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                            i2 = i7;
                            f3 = f;
                            i3 = f2;
                            f = i12;
                            f2 = i13;
                            i4 = i8;
                            break;
                        }
                    case 'q':
                        path.rQuadTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                        float f31 = i15 + fArr2[i11 + 0];
                        float f32 = i15 + fArr2[i11 + 2];
                        i2 = f31;
                        f3 = fArr2[i11 + 3] + i14;
                        i3 = f32;
                        f = i12;
                        f2 = i13;
                        i4 = fArr2[i11 + 1] + i14;
                        break;
                    case 's':
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f9 = i15 - i7;
                            f8 = i14 - i8;
                        } else {
                            f8 = 0.0f;
                            f9 = 0.0f;
                        }
                        path.rCubicTo(f9, f8, fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                        float f33 = i15 + fArr2[i11 + 0];
                        float f34 = i15 + fArr2[i11 + 2];
                        i2 = f33;
                        f3 = fArr2[i11 + 3] + i14;
                        i3 = f34;
                        f = i12;
                        f2 = i13;
                        i4 = fArr2[i11 + 1] + i14;
                        break;
                    case 't':
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f4 = i15 - i7;
                            f5 = i14 - i8;
                        } else {
                            f5 = 0.0f;
                            f4 = 0.0f;
                        }
                        path.rQuadTo(f4, f5, fArr2[i11 + 0], fArr2[i11 + 1]);
                        float f35 = i15 + fArr2[i11 + 0];
                        i2 = i15 + f4;
                        f3 = fArr2[i11 + 1] + i14;
                        i3 = f35;
                        f = i12;
                        f2 = i13;
                        i4 = f5 + i14;
                        break;
                    case 'v':
                        path.rLineTo(0.0f, fArr2[i11 + 0]);
                        f2 = i13;
                        i2 = i7;
                        f3 = fArr2[i11 + 0] + i14;
                        i3 = i15;
                        i4 = i8;
                        f = i12;
                        break;
                    default:
                        f = i12;
                        f2 = i13;
                        i2 = i7;
                        f3 = i14;
                        i3 = i15;
                        i4 = i8;
                        break;
                }
                i11 += i;
                i12 = f;
                i13 = f2;
                i14 = f3;
                i15 = i3;
                c = c2;
                i8 = i4;
                i7 = i2;
            }
            fArr[0] = i15;
            fArr[1] = i14;
            fArr[2] = i7;
            fArr[3] = i8;
            fArr[4] = i13;
            fArr[5] = i12;
        }

        /* renamed from: a */
        private static void m906a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
            double d4 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
            double d5 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
            double d6 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
            double d7 = d3 - d5;
            double d8 = d4 - d6;
            double d9 = (d3 + d5) / 2.0d;
            double d10 = (d4 + d6) / 2.0d;
            double d11 = (d7 * d7) + (d8 * d8);
            if (d11 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d12 = (1.0d / d11) - 0.25d;
            if (d12 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d11);
                float sqrt = (float) (Math.sqrt(d11) / 1.99999d);
                m906a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d12);
            double d13 = d7 * sqrt2;
            double d14 = d8 * sqrt2;
            if (z == z2) {
                d = d9 - d14;
                d2 = d13 + d10;
            } else {
                d = d14 + d9;
                d2 = d10 - d13;
            }
            double atan2 = Math.atan2(d4 - d2, d3 - d);
            double atan22 = Math.atan2(d6 - d2, d5 - d) - atan2;
            if (z2 != (atan22 >= 0.0d)) {
                if (atan22 > 0.0d) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d15 = ((double) f5) * d;
            double d16 = d2 * ((double) f6);
            m905a(path, (d15 * cos) - (d16 * sin), (d15 * sin) + (d16 * cos), (double) f5, (double) f6, (double) f, (double) f2, radians, atan2, atan22);
        }

        /* renamed from: a */
        private static void m905a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
            double d11 = d9 / ((double) ceil);
            int i = 0;
            double d12 = (sin2 * (-d3) * sin) + (cos2 * d4 * cos);
            double d13 = d10;
            while (i < ceil) {
                double d14 = d8 + d11;
                double sin3 = Math.sin(d14);
                double cos3 = Math.cos(d14);
                double d15 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * sin3);
                double d16 = (d4 * cos * sin3) + (d3 * sin * cos3) + d2;
                double d17 = (((-d3) * cos) * sin3) - ((d4 * sin) * cos3);
                double d18 = (cos3 * d4 * cos) + (sin3 * (-d3) * sin);
                double tan = Math.tan((d14 - d8) / 2.0d);
                double sqrt = ((Math.sqrt((tan * (3.0d * tan)) + 4.0d) - 1.0d) * Math.sin(d14 - d8)) / 3.0d;
                path.rCubicTo(((float) ((d13 * sqrt) + d5)) - ((float) d5), ((float) (d6 + (d12 * sqrt))) - ((float) d6), ((float) (d15 - (sqrt * d17))) - ((float) d5), ((float) (d16 - (sqrt * d18))) - ((float) d6), ((float) d15) - ((float) d5), ((float) d16) - ((float) d6));
                i++;
                d13 = d17;
                d8 = d14;
                d6 = d16;
                d5 = d15;
                d12 = d18;
            }
        }
    }
}
