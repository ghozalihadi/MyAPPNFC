package com.roaddogssoftware.cardapp.p030b.p031a;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.roaddogssoftware.cardapp.b.a.a */
/* compiled from: AudioDecoder */
public class C0782a {

    /* renamed from: a */
    public static String f1742a = "Rhombus AudioDecoder";

    /* renamed from: b */
    public static int f1743b = 7;

    /* renamed from: c */
    public static int f1744c = 32;

    /* renamed from: d */
    public static int f1745d = 5;

    /* renamed from: e */
    public static int f1746e = 48;

    /* renamed from: f */
    private boolean f1747f = true;

    /* renamed from: g */
    private int f1748g = 500;

    /* renamed from: h */
    private int f1749h = this.f1748g;

    /* renamed from: i */
    private double f1750i = 0.1d;

    /* renamed from: j */
    private double f1751j = 0.5d;

    /* renamed from: d */
    private List<Integer> m2338d(List<Integer> list) {
        return m2340f(m2339e(list));
    }

    /* renamed from: a */
    public C0784c mo8306a(List<Integer> list) {
        C0784c cVar;
        BitSet bitSet;
        m2334a(f1742a, "processing data");
        List<Integer> d = m2338d(list);
        C0784c cVar2 = new C0784c();
        cVar2.mo8314a("Unevaluated.  This shouldn't happen");
        cVar2.mo8312a();
        this.f1749h = m2331a(d, this.f1751j);
        m2334a(f1742a, "first, the zero crossing method");
        BitSet c = mo8308c(d);
        C0784c a = m2332a(c);
        if (a.mo8315b()) {
            m2334a(f1742a, "bad read, lets try it backwards");
            a = m2332a(m2335b(c));
        }
        if (a.mo8315b()) {
            bitSet = mo8307b(m2333a(d, this.f1749h));
            m2334a(f1742a, "and now the peaks method");
            cVar = m2332a(bitSet);
        } else {
            BitSet bitSet2 = c;
            cVar = a;
            bitSet = bitSet2;
        }
        if (cVar.mo8315b()) {
            m2334a(f1742a, "bad read, lets try it backwards");
            cVar = m2332a(m2335b(bitSet));
        }
        cVar.f1757d = list;
        return cVar;
    }

    /* renamed from: e */
    private List<Integer> m2339e(List<Integer> list) {
        int i;
        int i2 = 0;
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Integer> it = list.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = it.next().intValue() + i;
        }
        int round = Math.round((float) (i / list.size()));
        for (Integer intValue : list) {
            arrayList.add(Integer.valueOf(intValue.intValue() - round));
        }
        return arrayList;
    }

    /* renamed from: f */
    private List<Integer> m2340f(List<Integer> list) {
        if (list.size() == 0) {
            return new ArrayList(0);
        }
        m2334a(f1742a, "smoothing data.  smoothing param is " + this.f1750i);
        ArrayList arrayList = new ArrayList(list.size());
        Integer num = list.get(0);
        for (Integer intValue : list) {
            arrayList.add(Integer.valueOf((int) ((((double) num.intValue()) * this.f1750i) + (((double) intValue.intValue()) * (1.0d - this.f1750i)))));
        }
        return arrayList;
    }

    /* renamed from: a */
    private int m2331a(List<Integer> list, double d) {
        boolean z = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (Integer next : list) {
            if (next.intValue() > 0 && i4 <= 0) {
                z = false;
                i = 0;
            } else if (next.intValue() < 0 && i4 >= 0 && z) {
                i2 += i;
                i3++;
            }
            if (next.intValue() > 0 && i4 > next.intValue() && i4 > this.f1748g && next.intValue() > i) {
                z = true;
                i = next.intValue();
            }
            i4 = next.intValue();
        }
        if (i3 <= 0) {
            return this.f1748g;
        }
        int floor = (int) Math.floor(((double) (i2 / i3)) * d);
        m2334a(f1742a, "returning " + floor + " for minLevel");
        m2334a(f1742a, "there were " + i3 + " peaks");
        return floor;
    }

    /* renamed from: a */
    private List<C0783b> m2333a(List<Integer> list, int i) {
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        for (Integer next : list) {
            i3++;
            if (Math.abs(next.intValue()) >= i) {
                if (next.intValue() > 0 && next.intValue() < i2 && i2 >= i4) {
                    linkedList.add(new C0783b(i3, i2));
                } else if (next.intValue() < 0 && next.intValue() > i2 && i2 <= i4) {
                    linkedList.add(new C0783b(i3, i2));
                }
                i4 = i2;
                i2 = next.intValue();
            }
        }
        m2334a(f1742a, "got " + linkedList.size() + " peaks");
        return linkedList;
    }

    /* renamed from: b */
    public BitSet mo8307b(List<C0783b> list) {
        BitSet bitSet = new BitSet();
        m2334a(f1742a, "there are " + list.size() + " peaks to decode");
        Iterator<C0783b> it = list.iterator();
        if (!it.hasNext()) {
            m2334a(f1742a, "no peaks to decode");
            return bitSet;
        }
        C0783b next = it.next();
        m2334a(f1742a, "initial peak:" + next);
        int i = 1;
        boolean z = false;
        int i2 = -1;
        C0783b bVar = next;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0783b next2 = it.next();
            boolean z2 = !next2.mo8310a(bVar);
            int i5 = i + 1;
            m2334a(f1742a, "peak:" + next2 + " flip:" + z2 + " peakcount:" + i);
            if (z2) {
                if (i3 < 1) {
                    m2334a(f1742a, "discard");
                    i3++;
                } else {
                    int i6 = next2.f1752a - bVar.f1752a;
                    if (i2 == -1) {
                        m2334a(f1742a, "set oneinterval");
                        i2 = i6 / 2;
                    } else {
                        boolean b = m2336b(i6, i2);
                        m2334a(f1742a, "diff (peaks): " + i6 + " oneinterval: " + i2 + " idx:" + next2.f1752a + " one?: " + b);
                        if (b) {
                            if (z) {
                                i2 = (i2 + i6) / 2;
                                bitSet.set(i4, true);
                                i4++;
                                z = false;
                            } else {
                                z = true;
                            }
                        } else if (z) {
                            m2334a(f1742a, "got a 0 where expected a 1.  result so far: " + bitSet);
                            break;
                        } else {
                            i2 = ((i6 / 2) + i2) / 2;
                            bitSet.set(i4, false);
                            i4++;
                        }
                    }
                }
                i2 = i2;
                bVar = next2;
                i3 = i3;
                i4 = i4;
                i = i5;
            } else {
                i = i5;
            }
        }
        m2334a(f1742a, "raw binary: " + m2337c(bitSet));
        return bitSet;
    }

    /* renamed from: c */
    public BitSet mo8308c(List<Integer> list) {
        BitSet bitSet = new BitSet();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        boolean z = false;
        int i8 = 1;
        Iterator<Integer> it = list.iterator();
        while (true) {
            int i9 = i;
            int i10 = i2;
            int i11 = i3;
            int i12 = i4;
            int i13 = i5;
            int i14 = i6;
            int i15 = i7;
            boolean z2 = z;
            int i16 = i8;
            if (!it.hasNext()) {
                break;
            }
            Integer next = it.next();
            if (next.intValue() * i11 >= 0 || Math.abs(next.intValue()) <= this.f1749h) {
                i8 = i16;
                z = z2;
                i7 = i15;
                i6 = i14;
                i5 = i13;
                i4 = i12;
                i3 = i11;
                i2 = i10;
            } else {
                if (i13 == 0) {
                    m2334a(f1742a, "set first to: " + i9);
                    i13 = i9;
                } else if (i15 < 1) {
                    i15++;
                } else {
                    int i17 = i9 - i12;
                    if (i14 == -1) {
                        i14 = i17 / 2;
                    } else {
                        boolean b = m2336b(i17, i14);
                        m2334a(f1742a, "diff: " + i17 + " oneinterval: " + i14 + " idx:" + i9 + " one?: " + b);
                        if (!b) {
                            i14 = i17 / 2;
                            if (z2) {
                                break;
                            }
                            bitSet.set(i10, false);
                            i10++;
                        } else if (z2) {
                            i16 = 1 - i16;
                            bitSet.set(i10, true);
                            i10++;
                            z2 = false;
                            i14 = i17;
                        } else {
                            z2 = true;
                            i14 = i17;
                        }
                    }
                }
                i8 = i16;
                i3 = i11 * -1;
                z = z2;
                i2 = i10;
                i7 = i15;
                i6 = i14;
                i5 = i13;
                i4 = i9;
            }
            i = i9 + 1;
        }
        m2334a(f1742a, "raw binary: " + m2337c(bitSet));
        return bitSet;
    }

    /* renamed from: a */
    private C0784c m2332a(BitSet bitSet) {
        int i = 0;
        C0784c cVar = new C0784c();
        int nextSetBit = bitSet.nextSetBit(0);
        if (nextSetBit < 0) {
            m2334a(f1742a, "no 1 bits detected.");
            cVar.mo8312a();
            return cVar;
        }
        m2334a(f1742a, "first 1 bit is at position " + nextSetBit);
        int i2 = nextSetBit;
        int i3 = 0;
        while (i2 < nextSetBit + 4) {
            if (bitSet.get(i2)) {
                i3 += 1 << i;
            }
            i++;
            i2++;
        }
        m2334a(f1742a, "sentinel value for 4 bit:" + i3);
        if (i3 == 11) {
            return mo8305a(bitSet, nextSetBit, 4, 48);
        }
        while (i2 < nextSetBit + 6) {
            if (bitSet.get(i2)) {
                i3 += 1 << i;
            }
            i++;
            i2++;
        }
        m2334a(f1742a, "sentinel value for 6 bit:" + i3);
        if (i3 == 5) {
            return mo8305a(bitSet, nextSetBit, 6, 32);
        }
        m2334a(f1742a, "could not match sentinel value to either 11 or 5 magic values");
        cVar.mo8312a();
        return cVar;
    }

    /* renamed from: a */
    public C0784c mo8305a(BitSet bitSet, int i, int i2, int i3) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        C0784c cVar = new C0784c();
        boolean z2 = false;
        int size = bitSet.size();
        int i4 = 0;
        int i5 = i;
        while (i5 < size && !z2) {
            int i6 = i5 + i2;
            boolean z3 = true;
            int i7 = 0;
            int i8 = 0;
            while (i5 < i6) {
                if (bitSet.get(i5)) {
                    i7 += 1 << i8;
                    z3 = !z3;
                }
                i8++;
                i5++;
            }
            char a = m2330a(i7, i3);
            sb.append(a);
            if (bitSet.get(i5) != z3) {
                m2334a(f1742a, "addBadCharIndex " + i4);
                cVar.mo8313a(i4);
            }
            i5++;
            int i9 = i4 + 1;
            if (a == '?') {
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
            i4 = i9;
        }
        cVar.mo8314a(sb.toString());
        return cVar;
    }

    /* renamed from: a */
    private char m2330a(int i, int i2) {
        return (char) (i + i2);
    }

    /* renamed from: b */
    private boolean m2336b(int i, int i2) {
        if (Math.abs(i - i2) < Math.abs(i - (i2 * 2))) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private BitSet m2335b(BitSet bitSet) {
        int size = bitSet.size();
        BitSet bitSet2 = new BitSet(size);
        for (int i = 0; i < size; i++) {
            bitSet2.set(i, bitSet.get((size - 1) - i));
        }
        return bitSet2;
    }

    /* renamed from: c */
    private String m2337c(BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m2334a(String str, String str2) {
        if (this.f1747f) {
        }
    }
}
