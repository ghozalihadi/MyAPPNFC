package p000a.p007b.p008a.p012d;

import java.util.Map;
import p000a.p007b.p008a.C0065c;
import p000a.p007b.p008a.C0070d;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p009a.C0021i;
import p000a.p007b.p008a.p010b.C0059i;
import p000a.p007b.p008a.p011c.C0069c;

/* renamed from: a.b.a.d.c */
/* compiled from: IsoFields */
public final class C0073c {

    /* renamed from: a */
    public static final C0088i f232a = C0075a.DAY_OF_QUARTER;

    /* renamed from: b */
    public static final C0088i f233b = C0075a.QUARTER_OF_YEAR;

    /* renamed from: c */
    public static final C0088i f234c = C0075a.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: d */
    public static final C0088i f235d = C0075a.WEEK_BASED_YEAR;

    /* renamed from: e */
    public static final C0098l f236e = C0080b.WEEK_BASED_YEARS;

    /* renamed from: f */
    public static final C0098l f237f = C0080b.QUARTER_YEARS;

    /* renamed from: a.b.a.d.c$a */
    /* compiled from: IsoFields */
    private enum C0075a implements C0088i {
        DAY_OF_QUARTER {
            public String toString() {
                return "DayOfQuarter";
            }

            /* renamed from: a */
            public C0100n mo249a() {
                return C0100n.m492a(1, 90, 92);
            }

            /* renamed from: a */
            public boolean mo250a(C0082e eVar) {
                return eVar.mo18a((C0088i) C0071a.DAY_OF_YEAR) && eVar.mo18a((C0088i) C0071a.MONTH_OF_YEAR) && eVar.mo18a((C0088i) C0071a.YEAR) && C0075a.m416e(eVar);
            }

            /* renamed from: b */
            public C0100n mo252b(C0082e eVar) {
                if (!eVar.mo18a((C0088i) this)) {
                    throw new C0099m("Unsupported field: DayOfQuarter");
                }
                long d = eVar.mo68d(QUARTER_OF_YEAR);
                if (d == 1) {
                    return C0021i.f19b.mo97a(eVar.mo68d(C0071a.YEAR)) ? C0100n.m491a(1, 91) : C0100n.m491a(1, 90);
                } else if (d == 2) {
                    return C0100n.m491a(1, 91);
                } else {
                    if (d == 3 || d == 4) {
                        return C0100n.m491a(1, 92);
                    }
                    return mo249a();
                }
            }

            /* renamed from: c */
            public long mo254c(C0082e eVar) {
                if (!eVar.mo18a((C0088i) this)) {
                    throw new C0099m("Unsupported field: DayOfQuarter");
                }
                int c = eVar.mo67c(C0071a.DAY_OF_YEAR);
                int c2 = eVar.mo67c(C0071a.MONTH_OF_YEAR);
                return (long) (c - C0075a.f243e[(C0021i.f19b.mo97a(eVar.mo68d(C0071a.YEAR)) ? 4 : 0) + ((c2 - 1) / 3)]);
            }

            /* renamed from: a */
            public <R extends C0081d> R mo247a(R r, long j) {
                long c = mo254c(r);
                mo249a().mo272a(j, (C0088i) this);
                return r.mo22b(C0071a.DAY_OF_YEAR, (j - c) + r.mo68d(C0071a.DAY_OF_YEAR));
            }

            /* renamed from: a */
            public C0082e mo248a(Map<C0088i, Long> map, C0082e eVar, C0059i iVar) {
                C0115f e;
                Long l = map.get(C0071a.YEAR);
                Long l2 = map.get(QUARTER_OF_YEAR);
                if (l == null || l2 == null) {
                    return null;
                }
                int b = C0071a.YEAR.mo251b(l.longValue());
                long longValue = map.get(DAY_OF_QUARTER).longValue();
                if (iVar == C0059i.LENIENT) {
                    e = C0115f.m606a(b, 1, 1).mo355c(C0069c.m377a(C0069c.m384c(l2.longValue(), 1), 3)).mo359e(C0069c.m384c(longValue, 1));
                } else {
                    int b2 = QUARTER_OF_YEAR.mo249a().mo275b(l2.longValue(), QUARTER_OF_YEAR);
                    if (iVar == C0059i.STRICT) {
                        int i = 92;
                        if (b2 == 1) {
                            i = C0021i.f19b.mo97a((long) b) ? 91 : 90;
                        } else if (b2 == 2) {
                            i = 91;
                        }
                        C0100n.m491a(1, (long) i).mo272a(longValue, (C0088i) this);
                    } else {
                        mo249a().mo272a(longValue, (C0088i) this);
                    }
                    e = C0115f.m606a(b, ((b2 - 1) * 3) + 1, 1).mo359e(longValue - 1);
                }
                map.remove(this);
                map.remove(C0071a.YEAR);
                map.remove(QUARTER_OF_YEAR);
                return e;
            }
        },
        QUARTER_OF_YEAR {
            public String toString() {
                return "QuarterOfYear";
            }

            /* renamed from: a */
            public C0100n mo249a() {
                return C0100n.m491a(1, 4);
            }

            /* renamed from: a */
            public boolean mo250a(C0082e eVar) {
                return eVar.mo18a((C0088i) C0071a.MONTH_OF_YEAR) && C0075a.m416e(eVar);
            }

            /* renamed from: b */
            public C0100n mo252b(C0082e eVar) {
                return mo249a();
            }

            /* renamed from: c */
            public long mo254c(C0082e eVar) {
                if (eVar.mo18a((C0088i) this)) {
                    return (eVar.mo68d(C0071a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new C0099m("Unsupported field: QuarterOfYear");
            }

            /* renamed from: a */
            public <R extends C0081d> R mo247a(R r, long j) {
                long c = mo254c(r);
                mo249a().mo272a(j, (C0088i) this);
                return r.mo22b(C0071a.MONTH_OF_YEAR, ((j - c) * 3) + r.mo68d(C0071a.MONTH_OF_YEAR));
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            public String toString() {
                return "WeekOfWeekBasedYear";
            }

            /* renamed from: a */
            public C0100n mo249a() {
                return C0100n.m492a(1, 52, 53);
            }

            /* renamed from: a */
            public boolean mo250a(C0082e eVar) {
                return eVar.mo18a((C0088i) C0071a.EPOCH_DAY) && C0075a.m416e(eVar);
            }

            /* renamed from: b */
            public C0100n mo252b(C0082e eVar) {
                if (eVar.mo18a((C0088i) this)) {
                    return C0075a.m412d(C0115f.m610a(eVar));
                }
                throw new C0099m("Unsupported field: WeekOfWeekBasedYear");
            }

            /* renamed from: c */
            public long mo254c(C0082e eVar) {
                if (eVar.mo18a((C0088i) this)) {
                    return (long) C0075a.m415e(C0115f.m610a(eVar));
                }
                throw new C0099m("Unsupported field: WeekOfWeekBasedYear");
            }

            /* renamed from: a */
            public <R extends C0081d> R mo247a(R r, long j) {
                mo249a().mo272a(j, (C0088i) this);
                return r.mo30d(C0069c.m384c(j, mo254c(r)), C0072b.WEEKS);
            }

            /* renamed from: a */
            public C0082e mo248a(Map<C0088i, Long> map, C0082e eVar, C0059i iVar) {
                C0115f a;
                Long l = map.get(WEEK_BASED_YEAR);
                Long l2 = map.get(C0071a.DAY_OF_WEEK);
                if (l == null || l2 == null) {
                    return null;
                }
                int b = WEEK_BASED_YEAR.mo249a().mo275b(l.longValue(), WEEK_BASED_YEAR);
                long longValue = map.get(WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (iVar == C0059i.LENIENT) {
                    long longValue2 = l2.longValue();
                    long j = 0;
                    if (longValue2 > 7) {
                        j = (longValue2 - 1) / 7;
                        longValue2 = ((longValue2 - 1) % 7) + 1;
                    } else if (longValue2 < 1) {
                        j = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    }
                    a = C0115f.m606a(b, 1, 4).mo358d(longValue - 1).mo358d(j).mo25c((C0088i) C0071a.DAY_OF_WEEK, longValue2);
                } else {
                    int b2 = C0071a.DAY_OF_WEEK.mo251b(l2.longValue());
                    if (iVar == C0059i.STRICT) {
                        C0075a.m412d(C0115f.m606a(b, 1, 4)).mo272a(longValue, (C0088i) this);
                    } else {
                        mo249a().mo272a(longValue, (C0088i) this);
                    }
                    a = C0115f.m606a(b, 1, 4).mo358d(longValue - 1).mo25c((C0088i) C0071a.DAY_OF_WEEK, (long) b2);
                }
                map.remove(this);
                map.remove(WEEK_BASED_YEAR);
                map.remove(C0071a.DAY_OF_WEEK);
                return a;
            }
        },
        WEEK_BASED_YEAR {
            public String toString() {
                return "WeekBasedYear";
            }

            /* renamed from: a */
            public C0100n mo249a() {
                return C0071a.YEAR.mo249a();
            }

            /* renamed from: a */
            public boolean mo250a(C0082e eVar) {
                return eVar.mo18a((C0088i) C0071a.EPOCH_DAY) && C0075a.m416e(eVar);
            }

            /* renamed from: b */
            public C0100n mo252b(C0082e eVar) {
                return C0071a.YEAR.mo249a();
            }

            /* renamed from: c */
            public long mo254c(C0082e eVar) {
                if (eVar.mo18a((C0088i) this)) {
                    return (long) C0075a.m417f(C0115f.m610a(eVar));
                }
                throw new C0099m("Unsupported field: WeekBasedYear");
            }

            /* renamed from: a */
            public <R extends C0081d> R mo247a(R r, long j) {
                int i = 52;
                if (!mo250a(r)) {
                    throw new C0099m("Unsupported field: WeekBasedYear");
                }
                int b = mo249a().mo275b(j, WEEK_BASED_YEAR);
                C0115f a = C0115f.m610a((C0082e) r);
                int c = a.mo67c((C0088i) C0071a.DAY_OF_WEEK);
                int b2 = C0075a.m415e(a);
                if (!(b2 == 53 && C0075a.m409b(b) == 52)) {
                    i = b2;
                }
                C0115f a2 = C0115f.m606a(b, 1, 4);
                return r.mo21b(a2.mo359e((long) (((i - 1) * 7) + (c - a2.mo67c((C0088i) C0071a.DAY_OF_WEEK)))));
            }
        };
        
        /* access modifiers changed from: private */

        /* renamed from: e */
        public static final int[] f243e = null;

        static {
            f243e = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
        }

        /* renamed from: a */
        public C0082e mo248a(Map<C0088i, Long> map, C0082e eVar, C0059i iVar) {
            return null;
        }

        /* renamed from: b */
        public boolean mo253b() {
            return true;
        }

        /* renamed from: c */
        public boolean mo255c() {
            return false;
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public static boolean m416e(C0082e eVar) {
            return C0018g.m125a(eVar).equals(C0021i.f19b);
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public static C0100n m412d(C0115f fVar) {
            return C0100n.m491a(1, (long) m409b(m417f(fVar)));
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static int m409b(int i) {
            C0115f a = C0115f.m606a(i, 1, 1);
            if (a.mo363g() == C0065c.THURSDAY || (a.mo363g() == C0065c.WEDNESDAY && a.mo34h())) {
                return 53;
            }
            return 52;
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public static int m415e(C0115f fVar) {
            int i;
            int ordinal = fVar.mo363g().ordinal();
            int f = fVar.mo361f() - 1;
            int i2 = (3 - ordinal) + f;
            int i3 = (i2 - ((i2 / 7) * 7)) - 3;
            if (i3 < -3) {
                i = i3 + 7;
            } else {
                i = i3;
            }
            if (f < i) {
                return (int) m412d(fVar.mo357d(180).mo362f(1)).mo278c();
            }
            int i4 = ((f - i) / 7) + 1;
            if (i4 == 53) {
                if (!(i == -3 || (i == -2 && fVar.mo34h()))) {
                    return 1;
                }
            }
            return i4;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public static int m417f(C0115f fVar) {
            int d = fVar.mo356d();
            int f = fVar.mo361f();
            if (f <= 3) {
                if (f - fVar.mo363g().ordinal() < -2) {
                    return d - 1;
                }
                return d;
            } else if (f < 363) {
                return d;
            } else {
                if (((f - 363) - (fVar.mo34h() ? 1 : 0)) - fVar.mo363g().ordinal() >= 0) {
                    return d + 1;
                }
                return d;
            }
        }
    }

    /* renamed from: a.b.a.d.c$b */
    /* compiled from: IsoFields */
    private enum C0080b implements C0098l {
        WEEK_BASED_YEARS("WeekBasedYears", C0070d.m388a(31556952)),
        QUARTER_YEARS("QuarterYears", C0070d.m388a(7889238));
        

        /* renamed from: c */
        private final String f248c;

        /* renamed from: d */
        private final C0070d f249d;

        private C0080b(String str, C0070d dVar) {
            this.f248c = str;
            this.f249d = dVar;
        }

        /* renamed from: a */
        public boolean mo258a() {
            return true;
        }

        /* renamed from: a */
        public <R extends C0081d> R mo257a(R r, long j) {
            switch (this) {
                case WEEK_BASED_YEARS:
                    return r.mo22b(C0073c.f235d, C0069c.m382b((long) r.mo67c(C0073c.f235d), j));
                case QUARTER_YEARS:
                    return r.mo30d(j / 256, C0072b.YEARS).mo30d((j % 256) * 3, C0072b.MONTHS);
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }

        public String toString() {
            return this.f248c;
        }
    }
}
