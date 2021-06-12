package p000a.p007b.p008a.p009a;

import java.io.Serializable;
import java.util.Map;
import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.C0065c;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0118g;
import p000a.p007b.p008a.C0124i;
import p000a.p007b.p008a.C0128k;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0139p;
import p000a.p007b.p008a.p010b.C0059i;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0084g;
import p000a.p007b.p008a.p012d.C0088i;

/* renamed from: a.b.a.a.i */
/* compiled from: IsoChronology */
public final class C0021i extends C0018g implements Serializable {

    /* renamed from: b */
    public static final C0021i f19b = new C0021i();

    private C0021i() {
    }

    /* renamed from: a */
    public String mo95a() {
        return "ISO";
    }

    /* renamed from: b */
    public C0115f mo91a(int i, int i2, int i3) {
        return C0115f.m606a(i, i2, i3);
    }

    /* renamed from: d */
    public C0115f mo98b(C0082e eVar) {
        return C0115f.m610a(eVar);
    }

    /* renamed from: e */
    public C0118g mo100c(C0082e eVar) {
        return C0118g.m666a(eVar);
    }

    /* renamed from: b */
    public C0139p mo93a(C0103e eVar, C0134m mVar) {
        return C0139p.m856a(eVar, mVar);
    }

    /* renamed from: a */
    public boolean mo97a(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    /* renamed from: b */
    public C0022j mo94a(int i) {
        return C0022j.m153a(i);
    }

    /* renamed from: a */
    public C0115f mo108a(Map<C0088i, Long> map, C0059i iVar) {
        long c;
        if (map.containsKey(C0071a.EPOCH_DAY)) {
            return C0115f.m608a(map.remove(C0071a.EPOCH_DAY).longValue());
        }
        Long remove = map.remove(C0071a.PROLEPTIC_MONTH);
        if (remove != null) {
            if (iVar != C0059i.LENIENT) {
                C0071a.PROLEPTIC_MONTH.mo246a(remove.longValue());
            }
            mo96a(map, C0071a.MONTH_OF_YEAR, (long) (C0069c.m381b(remove.longValue(), 12) + 1));
            mo96a(map, C0071a.YEAR, C0069c.m386e(remove.longValue(), 12));
        }
        Long remove2 = map.remove(C0071a.YEAR_OF_ERA);
        if (remove2 != null) {
            if (iVar != C0059i.LENIENT) {
                C0071a.YEAR_OF_ERA.mo246a(remove2.longValue());
            }
            Long remove3 = map.remove(C0071a.ERA);
            if (remove3 == null) {
                Long l = map.get(C0071a.YEAR);
                if (iVar != C0059i.STRICT) {
                    mo96a(map, C0071a.YEAR, (l == null || l.longValue() > 0) ? remove2.longValue() : C0069c.m384c(1, remove2.longValue()));
                } else if (l != null) {
                    C0071a aVar = C0071a.YEAR;
                    if (l.longValue() > 0) {
                        c = remove2.longValue();
                    } else {
                        c = C0069c.m384c(1, remove2.longValue());
                    }
                    mo96a(map, aVar, c);
                } else {
                    map.put(C0071a.YEAR_OF_ERA, remove2);
                }
            } else if (remove3.longValue() == 1) {
                mo96a(map, C0071a.YEAR, remove2.longValue());
            } else if (remove3.longValue() == 0) {
                mo96a(map, C0071a.YEAR, C0069c.m384c(1, remove2.longValue()));
            } else {
                throw new C0023b("Invalid value for era: " + remove3);
            }
        } else if (map.containsKey(C0071a.ERA)) {
            C0071a.ERA.mo246a(map.get(C0071a.ERA).longValue());
        }
        if (map.containsKey(C0071a.YEAR)) {
            if (map.containsKey(C0071a.MONTH_OF_YEAR)) {
                if (map.containsKey(C0071a.DAY_OF_MONTH)) {
                    int b = C0071a.YEAR.mo251b(map.remove(C0071a.YEAR).longValue());
                    int a = C0069c.m375a(map.remove(C0071a.MONTH_OF_YEAR).longValue());
                    int a2 = C0069c.m375a(map.remove(C0071a.DAY_OF_MONTH).longValue());
                    if (iVar == C0059i.LENIENT) {
                        return C0115f.m606a(b, 1, 1).mo355c((long) C0069c.m380b(a, 1)).mo359e((long) C0069c.m380b(a2, 1));
                    } else if (iVar != C0059i.SMART) {
                        return C0115f.m606a(b, a, a2);
                    } else {
                        C0071a.DAY_OF_MONTH.mo246a((long) a2);
                        if (a == 4 || a == 6 || a == 9 || a == 11) {
                            a2 = Math.min(a2, 30);
                        } else if (a == 2) {
                            a2 = Math.min(a2, C0124i.FEBRUARY.mo405a(C0128k.m770a((long) b)));
                        }
                        return C0115f.m606a(b, a, a2);
                    }
                } else if (map.containsKey(C0071a.ALIGNED_WEEK_OF_MONTH)) {
                    if (map.containsKey(C0071a.ALIGNED_DAY_OF_WEEK_IN_MONTH)) {
                        int b2 = C0071a.YEAR.mo251b(map.remove(C0071a.YEAR).longValue());
                        if (iVar == C0059i.LENIENT) {
                            long c2 = C0069c.m384c(map.remove(C0071a.MONTH_OF_YEAR).longValue(), 1);
                            return C0115f.m606a(b2, 1, 1).mo355c(c2).mo358d(C0069c.m384c(map.remove(C0071a.ALIGNED_WEEK_OF_MONTH).longValue(), 1)).mo359e(C0069c.m384c(map.remove(C0071a.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue(), 1));
                        }
                        int b3 = C0071a.MONTH_OF_YEAR.mo251b(map.remove(C0071a.MONTH_OF_YEAR).longValue());
                        C0115f e = C0115f.m606a(b2, b3, 1).mo359e((long) ((C0071a.ALIGNED_DAY_OF_WEEK_IN_MONTH.mo251b(map.remove(C0071a.ALIGNED_DAY_OF_WEEK_IN_MONTH).longValue()) - 1) + ((C0071a.ALIGNED_WEEK_OF_MONTH.mo251b(map.remove(C0071a.ALIGNED_WEEK_OF_MONTH).longValue()) - 1) * 7)));
                        if (iVar != C0059i.STRICT || e.mo67c((C0088i) C0071a.MONTH_OF_YEAR) == b3) {
                            return e;
                        }
                        throw new C0023b("Strict mode rejected date parsed to a different month");
                    } else if (map.containsKey(C0071a.DAY_OF_WEEK)) {
                        int b4 = C0071a.YEAR.mo251b(map.remove(C0071a.YEAR).longValue());
                        if (iVar == C0059i.LENIENT) {
                            long c3 = C0069c.m384c(map.remove(C0071a.MONTH_OF_YEAR).longValue(), 1);
                            return C0115f.m606a(b4, 1, 1).mo355c(c3).mo358d(C0069c.m384c(map.remove(C0071a.ALIGNED_WEEK_OF_MONTH).longValue(), 1)).mo359e(C0069c.m384c(map.remove(C0071a.DAY_OF_WEEK).longValue(), 1));
                        }
                        int b5 = C0071a.MONTH_OF_YEAR.mo251b(map.remove(C0071a.MONTH_OF_YEAR).longValue());
                        C0115f a3 = C0115f.m606a(b4, b5, 1).mo358d((long) (C0071a.ALIGNED_WEEK_OF_MONTH.mo251b(map.remove(C0071a.ALIGNED_WEEK_OF_MONTH).longValue()) - 1)).mo24c(C0084g.m455a(C0065c.m356a(C0071a.DAY_OF_WEEK.mo251b(map.remove(C0071a.DAY_OF_WEEK).longValue()))));
                        if (iVar != C0059i.STRICT || a3.mo67c((C0088i) C0071a.MONTH_OF_YEAR) == b5) {
                            return a3;
                        }
                        throw new C0023b("Strict mode rejected date parsed to a different month");
                    }
                }
            }
            if (map.containsKey(C0071a.DAY_OF_YEAR)) {
                int b6 = C0071a.YEAR.mo251b(map.remove(C0071a.YEAR).longValue());
                if (iVar != C0059i.LENIENT) {
                    return C0115f.m605a(b6, C0071a.DAY_OF_YEAR.mo251b(map.remove(C0071a.DAY_OF_YEAR).longValue()));
                }
                return C0115f.m605a(b6, 1).mo359e(C0069c.m384c(map.remove(C0071a.DAY_OF_YEAR).longValue(), 1));
            } else if (map.containsKey(C0071a.ALIGNED_WEEK_OF_YEAR)) {
                if (map.containsKey(C0071a.ALIGNED_DAY_OF_WEEK_IN_YEAR)) {
                    int b7 = C0071a.YEAR.mo251b(map.remove(C0071a.YEAR).longValue());
                    if (iVar == C0059i.LENIENT) {
                        return C0115f.m606a(b7, 1, 1).mo358d(C0069c.m384c(map.remove(C0071a.ALIGNED_WEEK_OF_YEAR).longValue(), 1)).mo359e(C0069c.m384c(map.remove(C0071a.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue(), 1));
                    }
                    C0115f e2 = C0115f.m606a(b7, 1, 1).mo359e((long) ((C0071a.ALIGNED_DAY_OF_WEEK_IN_YEAR.mo251b(map.remove(C0071a.ALIGNED_DAY_OF_WEEK_IN_YEAR).longValue()) - 1) + ((C0071a.ALIGNED_WEEK_OF_YEAR.mo251b(map.remove(C0071a.ALIGNED_WEEK_OF_YEAR).longValue()) - 1) * 7)));
                    if (iVar != C0059i.STRICT || e2.mo67c((C0088i) C0071a.YEAR) == b7) {
                        return e2;
                    }
                    throw new C0023b("Strict mode rejected date parsed to a different year");
                } else if (map.containsKey(C0071a.DAY_OF_WEEK)) {
                    int b8 = C0071a.YEAR.mo251b(map.remove(C0071a.YEAR).longValue());
                    if (iVar == C0059i.LENIENT) {
                        return C0115f.m606a(b8, 1, 1).mo358d(C0069c.m384c(map.remove(C0071a.ALIGNED_WEEK_OF_YEAR).longValue(), 1)).mo359e(C0069c.m384c(map.remove(C0071a.DAY_OF_WEEK).longValue(), 1));
                    }
                    C0115f a4 = C0115f.m606a(b8, 1, 1).mo358d((long) (C0071a.ALIGNED_WEEK_OF_YEAR.mo251b(map.remove(C0071a.ALIGNED_WEEK_OF_YEAR).longValue()) - 1)).mo24c(C0084g.m455a(C0065c.m356a(C0071a.DAY_OF_WEEK.mo251b(map.remove(C0071a.DAY_OF_WEEK).longValue()))));
                    if (iVar != C0059i.STRICT || a4.mo67c((C0088i) C0071a.YEAR) == b8) {
                        return a4;
                    }
                    throw new C0023b("Strict mode rejected date parsed to a different month");
                }
            }
        }
        return null;
    }
}
