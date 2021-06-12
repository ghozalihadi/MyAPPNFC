package p000a.p007b.p008a.p012d;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.C0065c;
import p000a.p007b.p008a.C0128k;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p010b.C0059i;
import p000a.p007b.p008a.p011c.C0069c;

/* renamed from: a.b.a.d.o */
/* compiled from: WeekFields */
public final class C0101o implements Serializable {

    /* renamed from: a */
    public static final C0101o f263a = new C0101o(C0065c.MONDAY, 4);

    /* renamed from: b */
    public static final C0101o f264b = m503a(C0065c.SUNDAY, 1);

    /* renamed from: c */
    private static final ConcurrentMap<String, C0101o> f265c = new ConcurrentHashMap(4, 0.75f, 2);

    /* renamed from: d */
    private final C0065c f266d;

    /* renamed from: e */
    private final int f267e;

    /* renamed from: f */
    private final transient C0088i f268f = C0102a.m513a(this);

    /* renamed from: g */
    private final transient C0088i f269g = C0102a.m516b(this);

    /* renamed from: h */
    private final transient C0088i f270h = C0102a.m518c(this);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final transient C0088i f271i = C0102a.m520d(this);

    /* renamed from: j */
    private final transient C0088i f272j = C0102a.m522e(this);

    /* renamed from: a */
    public static C0101o m504a(Locale locale) {
        C0069c.m378a(locale, "locale");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry()));
        return m503a(C0065c.SUNDAY.mo237a((long) (gregorianCalendar.getFirstDayOfWeek() - 1)), gregorianCalendar.getMinimalDaysInFirstWeek());
    }

    /* renamed from: a */
    public static C0101o m503a(C0065c cVar, int i) {
        String str = cVar.toString() + i;
        C0101o oVar = (C0101o) f265c.get(str);
        if (oVar != null) {
            return oVar;
        }
        f265c.putIfAbsent(str, new C0101o(cVar, i));
        return (C0101o) f265c.get(str);
    }

    private C0101o(C0065c cVar, int i) {
        C0069c.m378a(cVar, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.f266d = cVar;
        this.f267e = i;
    }

    /* renamed from: a */
    public C0065c mo283a() {
        return this.f266d;
    }

    /* renamed from: b */
    public int mo284b() {
        return this.f267e;
    }

    /* renamed from: c */
    public C0088i mo285c() {
        return this.f268f;
    }

    /* renamed from: d */
    public C0088i mo286d() {
        return this.f269g;
    }

    /* renamed from: e */
    public C0088i mo287e() {
        return this.f271i;
    }

    /* renamed from: f */
    public C0088i mo289f() {
        return this.f272j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0101o)) {
            return false;
        }
        if (hashCode() != obj.hashCode()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f266d.ordinal() * 7) + this.f267e;
    }

    public String toString() {
        return "WeekFields[" + this.f266d + ',' + this.f267e + ']';
    }

    /* renamed from: a.b.a.d.o$a */
    /* compiled from: WeekFields */
    static class C0102a implements C0088i {

        /* renamed from: f */
        private static final C0100n f273f = C0100n.m491a(1, 7);

        /* renamed from: g */
        private static final C0100n f274g = C0100n.m493a(0, 1, 4, 6);

        /* renamed from: h */
        private static final C0100n f275h = C0100n.m493a(0, 1, 52, 54);

        /* renamed from: i */
        private static final C0100n f276i = C0100n.m492a(1, 52, 53);

        /* renamed from: j */
        private static final C0100n f277j = C0071a.YEAR.mo249a();

        /* renamed from: a */
        private final String f278a;

        /* renamed from: b */
        private final C0101o f279b;

        /* renamed from: c */
        private final C0098l f280c;

        /* renamed from: d */
        private final C0098l f281d;

        /* renamed from: e */
        private final C0100n f282e;

        /* renamed from: a */
        static C0102a m513a(C0101o oVar) {
            return new C0102a("DayOfWeek", oVar, C0072b.DAYS, C0072b.WEEKS, f273f);
        }

        /* renamed from: b */
        static C0102a m516b(C0101o oVar) {
            return new C0102a("WeekOfMonth", oVar, C0072b.WEEKS, C0072b.MONTHS, f274g);
        }

        /* renamed from: c */
        static C0102a m518c(C0101o oVar) {
            return new C0102a("WeekOfYear", oVar, C0072b.WEEKS, C0072b.YEARS, f275h);
        }

        /* renamed from: d */
        static C0102a m520d(C0101o oVar) {
            return new C0102a("WeekOfWeekBasedYear", oVar, C0072b.WEEKS, C0073c.f236e, f276i);
        }

        /* renamed from: e */
        static C0102a m522e(C0101o oVar) {
            return new C0102a("WeekBasedYear", oVar, C0073c.f236e, C0072b.FOREVER, f277j);
        }

        private C0102a(String str, C0101o oVar, C0098l lVar, C0098l lVar2, C0100n nVar) {
            this.f278a = str;
            this.f279b = oVar;
            this.f280c = lVar;
            this.f281d = lVar2;
            this.f282e = nVar;
        }

        /* renamed from: c */
        public long mo254c(C0082e eVar) {
            int c = C0069c.m383c(eVar.mo67c(C0071a.DAY_OF_WEEK) - this.f279b.mo283a().mo236a(), 7) + 1;
            if (this.f281d == C0072b.WEEKS) {
                return (long) c;
            }
            if (this.f281d == C0072b.MONTHS) {
                int c2 = eVar.mo67c(C0071a.DAY_OF_MONTH);
                return (long) m514b(m511a(c2, c), c2);
            } else if (this.f281d == C0072b.YEARS) {
                int c3 = eVar.mo67c(C0071a.DAY_OF_YEAR);
                return (long) m514b(m511a(c3, c), c3);
            } else if (this.f281d == C0073c.f236e) {
                return (long) m519d(eVar);
            } else {
                if (this.f281d == C0072b.FOREVER) {
                    return (long) m521e(eVar);
                }
                throw new IllegalStateException("unreachable");
            }
        }

        /* renamed from: a */
        private int m512a(C0082e eVar, int i) {
            return C0069c.m383c(eVar.mo67c(C0071a.DAY_OF_WEEK) - i, 7) + 1;
        }

        /* renamed from: b */
        private long m515b(C0082e eVar, int i) {
            int c = eVar.mo67c(C0071a.DAY_OF_MONTH);
            return (long) m514b(m511a(c, i), c);
        }

        /* renamed from: c */
        private long m517c(C0082e eVar, int i) {
            int c = eVar.mo67c(C0071a.DAY_OF_YEAR);
            return (long) m514b(m511a(c, i), c);
        }

        /* renamed from: d */
        private int m519d(C0082e eVar) {
            int c = C0069c.m383c(eVar.mo67c(C0071a.DAY_OF_WEEK) - this.f279b.mo283a().mo236a(), 7) + 1;
            long c2 = m517c(eVar, c);
            if (c2 == 0) {
                return ((int) m517c(C0018g.m125a(eVar).mo98b(eVar).mo27c(1, C0072b.WEEKS), c)) + 1;
            }
            if (c2 >= 53) {
                int b = m514b(m511a(eVar.mo67c(C0071a.DAY_OF_YEAR), c), (C0128k.m770a((long) eVar.mo67c(C0071a.YEAR)) ? 366 : 365) + this.f279b.mo284b());
                if (c2 >= ((long) b)) {
                    return (int) (c2 - ((long) (b - 1)));
                }
            }
            return (int) c2;
        }

        /* renamed from: e */
        private int m521e(C0082e eVar) {
            int c = C0069c.m383c(eVar.mo67c(C0071a.DAY_OF_WEEK) - this.f279b.mo283a().mo236a(), 7) + 1;
            int c2 = eVar.mo67c(C0071a.YEAR);
            long c3 = m517c(eVar, c);
            if (c3 == 0) {
                return c2 - 1;
            }
            if (c3 < 53) {
                return c2;
            }
            if (c3 >= ((long) m514b(m511a(eVar.mo67c(C0071a.DAY_OF_YEAR), c), (C0128k.m770a((long) c2) ? 366 : 365) + this.f279b.mo284b()))) {
                return c2 + 1;
            }
            return c2;
        }

        /* renamed from: a */
        private int m511a(int i, int i2) {
            int c = C0069c.m383c(i - i2, 7);
            int i3 = -c;
            if (c + 1 > this.f279b.mo284b()) {
                return 7 - c;
            }
            return i3;
        }

        /* renamed from: b */
        private int m514b(int i, int i2) {
            return ((i + 7) + (i2 - 1)) / 7;
        }

        /* renamed from: a */
        public <R extends C0081d> R mo247a(R r, long j) {
            R d;
            int b = this.f282e.mo275b(j, this);
            int c = r.mo67c(this);
            if (b == c) {
                return r;
            }
            if (this.f281d != C0072b.FOREVER) {
                return r.mo30d((long) (b - c), this.f280c);
            }
            int c2 = r.mo67c(this.f279b.f271i);
            C0081d d2 = r.mo30d((long) (((double) (j - ((long) c))) * 52.1775d), C0072b.WEEKS);
            if (d2.mo67c(this) > b) {
                d = d2.mo27c((long) d2.mo67c(this.f279b.f271i), C0072b.WEEKS);
            } else {
                if (d2.mo67c(this) < b) {
                    d2 = d2.mo30d(2, C0072b.WEEKS);
                }
                d = d2.mo30d((long) (c2 - d2.mo67c(this.f279b.f271i)), C0072b.WEEKS);
                if (d.mo67c(this) > b) {
                    d = d.mo27c(1, C0072b.WEEKS);
                }
            }
            return d;
        }

        /* renamed from: a */
        public C0082e mo248a(Map<C0088i, Long> map, C0082e eVar, C0059i iVar) {
            long b;
            C0006a a;
            long b2;
            C0006a a2;
            long b3;
            int a3 = this.f279b.mo283a().mo236a();
            if (this.f281d == C0072b.WEEKS) {
                map.put(C0071a.DAY_OF_WEEK, Long.valueOf((long) (C0069c.m383c((this.f282e.mo275b(map.remove(this).longValue(), this) - 1) + (a3 - 1), 7) + 1)));
                return null;
            } else if (!map.containsKey(C0071a.DAY_OF_WEEK)) {
                return null;
            } else {
                if (this.f281d == C0072b.FOREVER) {
                    if (!map.containsKey(this.f279b.f271i)) {
                        return null;
                    }
                    C0018g a4 = C0018g.m125a(eVar);
                    int c = C0069c.m383c(C0071a.DAY_OF_WEEK.mo251b(map.get(C0071a.DAY_OF_WEEK).longValue()) - a3, 7) + 1;
                    int b4 = mo249a().mo275b(map.get(this).longValue(), this);
                    if (iVar == C0059i.LENIENT) {
                        a2 = a4.mo91a(b4, 1, this.f279b.mo284b());
                        long longValue = map.get(this.f279b.f271i).longValue();
                        int a5 = m512a((C0082e) a2, a3);
                        b3 = ((longValue - m517c(a2, a5)) * 7) + ((long) (c - a5));
                    } else {
                        a2 = a4.mo91a(b4, 1, this.f279b.mo284b());
                        int a6 = m512a((C0082e) a2, a3);
                        b3 = ((((long) this.f279b.f271i.mo249a().mo275b(map.get(this.f279b.f271i).longValue(), this.f279b.f271i)) - m517c(a2, a6)) * 7) + ((long) (c - a6));
                    }
                    C0006a f = a2.mo30d(b3, C0072b.DAYS);
                    if (iVar != C0059i.STRICT || f.mo68d(this) == map.get(this).longValue()) {
                        map.remove(this);
                        map.remove(this.f279b.f271i);
                        map.remove(C0071a.DAY_OF_WEEK);
                        return f;
                    }
                    throw new C0023b("Strict mode rejected date parsed to a different year");
                } else if (!map.containsKey(C0071a.YEAR)) {
                    return null;
                } else {
                    int c2 = C0069c.m383c(C0071a.DAY_OF_WEEK.mo251b(map.get(C0071a.DAY_OF_WEEK).longValue()) - a3, 7) + 1;
                    int b5 = C0071a.YEAR.mo251b(map.get(C0071a.YEAR).longValue());
                    C0018g a7 = C0018g.m125a(eVar);
                    if (this.f281d == C0072b.MONTHS) {
                        if (!map.containsKey(C0071a.MONTH_OF_YEAR)) {
                            return null;
                        }
                        long longValue2 = map.remove(this).longValue();
                        if (iVar == C0059i.LENIENT) {
                            a = a7.mo91a(b5, 1, 1).mo30d(map.get(C0071a.MONTH_OF_YEAR).longValue() - 1, C0072b.MONTHS);
                            int a8 = m512a((C0082e) a, a3);
                            b2 = ((long) (c2 - a8)) + ((longValue2 - m515b((C0082e) a, a8)) * 7);
                        } else {
                            a = a7.mo91a(b5, C0071a.MONTH_OF_YEAR.mo251b(map.get(C0071a.MONTH_OF_YEAR).longValue()), 8);
                            int a9 = m512a((C0082e) a, a3);
                            b2 = ((long) (c2 - a9)) + ((((long) this.f282e.mo275b(longValue2, this)) - m515b((C0082e) a, a9)) * 7);
                        }
                        C0006a f2 = a.mo30d(b2, C0072b.DAYS);
                        if (iVar != C0059i.STRICT || f2.mo68d(C0071a.MONTH_OF_YEAR) == map.get(C0071a.MONTH_OF_YEAR).longValue()) {
                            map.remove(this);
                            map.remove(C0071a.YEAR);
                            map.remove(C0071a.MONTH_OF_YEAR);
                            map.remove(C0071a.DAY_OF_WEEK);
                            return f2;
                        }
                        throw new C0023b("Strict mode rejected date parsed to a different month");
                    } else if (this.f281d == C0072b.YEARS) {
                        long longValue3 = map.remove(this).longValue();
                        C0006a a10 = a7.mo91a(b5, 1, 1);
                        if (iVar == C0059i.LENIENT) {
                            int a11 = m512a((C0082e) a10, a3);
                            b = ((longValue3 - m517c(a10, a11)) * 7) + ((long) (c2 - a11));
                        } else {
                            int a12 = m512a((C0082e) a10, a3);
                            b = ((((long) this.f282e.mo275b(longValue3, this)) - m517c(a10, a12)) * 7) + ((long) (c2 - a12));
                        }
                        C0006a f3 = a10.mo30d(b, C0072b.DAYS);
                        if (iVar != C0059i.STRICT || f3.mo68d(C0071a.YEAR) == map.get(C0071a.YEAR).longValue()) {
                            map.remove(this);
                            map.remove(C0071a.YEAR);
                            map.remove(C0071a.DAY_OF_WEEK);
                            return f3;
                        }
                        throw new C0023b("Strict mode rejected date parsed to a different year");
                    } else {
                        throw new IllegalStateException("unreachable");
                    }
                }
            }
        }

        /* renamed from: a */
        public C0100n mo249a() {
            return this.f282e;
        }

        /* renamed from: b */
        public boolean mo253b() {
            return true;
        }

        /* renamed from: c */
        public boolean mo255c() {
            return false;
        }

        /* renamed from: a */
        public boolean mo250a(C0082e eVar) {
            if (eVar.mo18a((C0088i) C0071a.DAY_OF_WEEK)) {
                if (this.f281d == C0072b.WEEKS) {
                    return true;
                }
                if (this.f281d == C0072b.MONTHS) {
                    return eVar.mo18a((C0088i) C0071a.DAY_OF_MONTH);
                }
                if (this.f281d == C0072b.YEARS) {
                    return eVar.mo18a((C0088i) C0071a.DAY_OF_YEAR);
                }
                if (this.f281d == C0073c.f236e) {
                    return eVar.mo18a((C0088i) C0071a.EPOCH_DAY);
                }
                if (this.f281d == C0072b.FOREVER) {
                    return eVar.mo18a((C0088i) C0071a.EPOCH_DAY);
                }
            }
            return false;
        }

        /* renamed from: b */
        public C0100n mo252b(C0082e eVar) {
            C0071a aVar;
            if (this.f281d == C0072b.WEEKS) {
                return this.f282e;
            }
            if (this.f281d == C0072b.MONTHS) {
                aVar = C0071a.DAY_OF_MONTH;
            } else if (this.f281d == C0072b.YEARS) {
                aVar = C0071a.DAY_OF_YEAR;
            } else if (this.f281d == C0073c.f236e) {
                return m523f(eVar);
            } else {
                if (this.f281d == C0072b.FOREVER) {
                    return eVar.mo66b(C0071a.YEAR);
                }
                throw new IllegalStateException("unreachable");
            }
            int a = this.f279b.mo283a().mo236a();
            int a2 = m511a(eVar.mo67c(aVar), C0069c.m383c(eVar.mo67c(C0071a.DAY_OF_WEEK) - a, 7) + 1);
            C0100n b = eVar.mo66b(aVar);
            return C0100n.m491a((long) m514b(a2, (int) b.mo276b()), (long) m514b(a2, (int) b.mo278c()));
        }

        /* renamed from: f */
        private C0100n m523f(C0082e eVar) {
            int c = C0069c.m383c(eVar.mo67c(C0071a.DAY_OF_WEEK) - this.f279b.mo283a().mo236a(), 7) + 1;
            long c2 = m517c(eVar, c);
            if (c2 == 0) {
                return m523f(C0018g.m125a(eVar).mo98b(eVar).mo27c(2, C0072b.WEEKS));
            }
            int b = m514b(m511a(eVar.mo67c(C0071a.DAY_OF_YEAR), c), (C0128k.m770a((long) eVar.mo67c(C0071a.YEAR)) ? 366 : 365) + this.f279b.mo284b());
            if (c2 >= ((long) b)) {
                return m523f(C0018g.m125a(eVar).mo98b(eVar).mo30d(2, C0072b.WEEKS));
            }
            return C0100n.m491a(1, (long) (b - 1));
        }

        public String toString() {
            return this.f278a + "[" + this.f279b.toString() + "]";
        }
    }
}
