package p000a.p007b.p008a.p010b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0121h;
import p000a.p007b.p008a.C0127j;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p009a.C0008b;
import p000a.p007b.p008a.p009a.C0013e;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p009a.C0021i;
import p000a.p007b.p008a.p011c.C0068b;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0087h;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;

/* renamed from: a.b.a.b.a */
/* compiled from: DateTimeBuilder */
final class C0024a extends C0068b implements C0082e, Cloneable {

    /* renamed from: a */
    final Map<C0088i, Long> f23a = new HashMap();

    /* renamed from: b */
    C0018g f24b;

    /* renamed from: c */
    C0134m f25c;

    /* renamed from: d */
    C0006a f26d;

    /* renamed from: e */
    C0121h f27e;

    /* renamed from: f */
    boolean f28f;

    /* renamed from: g */
    C0127j f29g;

    /* renamed from: e */
    private Long m175e(C0088i iVar) {
        return this.f23a.get(iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0024a mo116a(C0088i iVar, long j) {
        C0069c.m378a(iVar, "field");
        Long e = m175e(iVar);
        if (e == null || e.longValue() == j) {
            return m168b(iVar, j);
        }
        throw new C0023b("Conflict found: " + iVar + " " + e + " differs from " + iVar + " " + j + ": " + this);
    }

    /* renamed from: b */
    private C0024a m168b(C0088i iVar, long j) {
        this.f23a.put(iVar, Long.valueOf(j));
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo117a(C0006a aVar) {
        this.f26d = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo118a(C0121h hVar) {
        this.f27e = hVar;
    }

    /* renamed from: a */
    public C0024a mo115a(C0059i iVar, Set<C0088i> set) {
        if (set != null) {
            this.f23a.keySet().retainAll(set);
        }
        m161a();
        m170b(iVar);
        m172c(iVar);
        if (m167a(iVar)) {
            m161a();
            m170b(iVar);
            m172c(iVar);
        }
        m174d(iVar);
        m169b();
        if (!(this.f29g == null || this.f29g.mo71b() || this.f26d == null || this.f27e == null)) {
            this.f26d = this.f26d.mo28c((C0087h) this.f29g);
            this.f29g = C0127j.f360a;
        }
        m171c();
        m173d();
        return this;
    }

    /* renamed from: a */
    private boolean m167a(C0059i iVar) {
        int i = 0;
        loop0:
        while (i < 100) {
            for (Map.Entry<C0088i, Long> key : this.f23a.entrySet()) {
                C0088i iVar2 = (C0088i) key.getKey();
                Object a = iVar2.mo248a(this.f23a, this, iVar);
                if (a != null) {
                    if (a instanceof C0013e) {
                        C0013e eVar = (C0013e) a;
                        if (this.f25c == null) {
                            this.f25c = eVar.mo75b();
                        } else if (!this.f25c.equals(eVar.mo75b())) {
                            throw new C0023b("ChronoZonedDateTime must use the effective parsed zone: " + this.f25c);
                        }
                        a = eVar.mo83g();
                    }
                    if (a instanceof C0006a) {
                        m163a(iVar2, (C0006a) a);
                        i++;
                    } else if (a instanceof C0121h) {
                        m164a(iVar2, (C0121h) a);
                        i++;
                    } else if (a instanceof C0008b) {
                        C0008b bVar = (C0008b) a;
                        m163a(iVar2, bVar.mo55f());
                        m164a(iVar2, bVar.mo53e());
                        i++;
                    } else {
                        throw new C0023b("Unknown type: " + a.getClass().getName());
                    }
                } else if (!this.f23a.containsKey(iVar2)) {
                    i++;
                }
            }
            break loop0;
        }
        if (i != 100) {
            return i > 0;
        }
        throw new C0023b("Badly written field");
    }

    /* renamed from: a */
    private void m163a(C0088i iVar, C0006a aVar) {
        if (!this.f24b.equals(aVar.mo38l())) {
            throw new C0023b("ChronoLocalDate must use the effective parsed chronology: " + this.f24b);
        }
        long k = aVar.mo37k();
        Long put = this.f23a.put(C0071a.EPOCH_DAY, Long.valueOf(k));
        if (put != null && put.longValue() != k) {
            throw new C0023b("Conflict found: " + C0115f.m608a(put.longValue()) + " differs from " + C0115f.m608a(k) + " while resolving  " + iVar);
        }
    }

    /* renamed from: a */
    private void m164a(C0088i iVar, C0121h hVar) {
        long d = hVar.mo395d();
        Long put = this.f23a.put(C0071a.NANO_OF_DAY, Long.valueOf(d));
        if (put != null && put.longValue() != d) {
            throw new C0023b("Conflict found: " + C0121h.m716b(put.longValue()) + " differs from " + hVar + " while resolving  " + iVar);
        }
    }

    /* renamed from: b */
    private void m170b(C0059i iVar) {
        if (this.f24b instanceof C0021i) {
            m165a(C0021i.f19b.mo108a(this.f23a, iVar));
        } else if (this.f23a.containsKey(C0071a.EPOCH_DAY)) {
            m165a(C0115f.m608a(this.f23a.remove(C0071a.EPOCH_DAY).longValue()));
        }
    }

    /* renamed from: a */
    private void m165a(C0115f fVar) {
        if (fVar != null) {
            mo117a((C0006a) fVar);
            for (C0088i next : this.f23a.keySet()) {
                if ((next instanceof C0071a) && next.mo253b()) {
                    try {
                        long d = fVar.mo68d(next);
                        Long l = this.f23a.get(next);
                        if (d != l.longValue()) {
                            throw new C0023b("Conflict found: Field " + next + " " + d + " differs from " + next + " " + l + " derived from " + fVar);
                        }
                    } catch (C0023b e) {
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m172c(C0059i iVar) {
        if (this.f23a.containsKey(C0071a.CLOCK_HOUR_OF_DAY)) {
            long longValue = this.f23a.remove(C0071a.CLOCK_HOUR_OF_DAY).longValue();
            if (!(iVar == C0059i.LENIENT || (iVar == C0059i.SMART && longValue == 0))) {
                C0071a.CLOCK_HOUR_OF_DAY.mo246a(longValue);
            }
            C0071a aVar = C0071a.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            mo116a((C0088i) aVar, longValue);
        }
        if (this.f23a.containsKey(C0071a.CLOCK_HOUR_OF_AMPM)) {
            long longValue2 = this.f23a.remove(C0071a.CLOCK_HOUR_OF_AMPM).longValue();
            if (!(iVar == C0059i.LENIENT || (iVar == C0059i.SMART && longValue2 == 0))) {
                C0071a.CLOCK_HOUR_OF_AMPM.mo246a(longValue2);
            }
            C0071a aVar2 = C0071a.HOUR_OF_AMPM;
            if (longValue2 == 12) {
                longValue2 = 0;
            }
            mo116a((C0088i) aVar2, longValue2);
        }
        if (iVar != C0059i.LENIENT) {
            if (this.f23a.containsKey(C0071a.AMPM_OF_DAY)) {
                C0071a.AMPM_OF_DAY.mo246a(this.f23a.get(C0071a.AMPM_OF_DAY).longValue());
            }
            if (this.f23a.containsKey(C0071a.HOUR_OF_AMPM)) {
                C0071a.HOUR_OF_AMPM.mo246a(this.f23a.get(C0071a.HOUR_OF_AMPM).longValue());
            }
        }
        if (this.f23a.containsKey(C0071a.AMPM_OF_DAY) && this.f23a.containsKey(C0071a.HOUR_OF_AMPM)) {
            long longValue3 = this.f23a.remove(C0071a.AMPM_OF_DAY).longValue();
            mo116a((C0088i) C0071a.HOUR_OF_DAY, this.f23a.remove(C0071a.HOUR_OF_AMPM).longValue() + (longValue3 * 12));
        }
        if (this.f23a.containsKey(C0071a.NANO_OF_DAY)) {
            long longValue4 = this.f23a.remove(C0071a.NANO_OF_DAY).longValue();
            if (iVar != C0059i.LENIENT) {
                C0071a.NANO_OF_DAY.mo246a(longValue4);
            }
            mo116a((C0088i) C0071a.SECOND_OF_DAY, longValue4 / 1000000000);
            mo116a((C0088i) C0071a.NANO_OF_SECOND, longValue4 % 1000000000);
        }
        if (this.f23a.containsKey(C0071a.MICRO_OF_DAY)) {
            long longValue5 = this.f23a.remove(C0071a.MICRO_OF_DAY).longValue();
            if (iVar != C0059i.LENIENT) {
                C0071a.MICRO_OF_DAY.mo246a(longValue5);
            }
            mo116a((C0088i) C0071a.SECOND_OF_DAY, longValue5 / 1000000);
            mo116a((C0088i) C0071a.MICRO_OF_SECOND, longValue5 % 1000000);
        }
        if (this.f23a.containsKey(C0071a.MILLI_OF_DAY)) {
            long longValue6 = this.f23a.remove(C0071a.MILLI_OF_DAY).longValue();
            if (iVar != C0059i.LENIENT) {
                C0071a.MILLI_OF_DAY.mo246a(longValue6);
            }
            mo116a((C0088i) C0071a.SECOND_OF_DAY, longValue6 / 1000);
            mo116a((C0088i) C0071a.MILLI_OF_SECOND, longValue6 % 1000);
        }
        if (this.f23a.containsKey(C0071a.SECOND_OF_DAY)) {
            long longValue7 = this.f23a.remove(C0071a.SECOND_OF_DAY).longValue();
            if (iVar != C0059i.LENIENT) {
                C0071a.SECOND_OF_DAY.mo246a(longValue7);
            }
            mo116a((C0088i) C0071a.HOUR_OF_DAY, longValue7 / 3600);
            mo116a((C0088i) C0071a.MINUTE_OF_HOUR, (longValue7 / 60) % 60);
            mo116a((C0088i) C0071a.SECOND_OF_MINUTE, longValue7 % 60);
        }
        if (this.f23a.containsKey(C0071a.MINUTE_OF_DAY)) {
            long longValue8 = this.f23a.remove(C0071a.MINUTE_OF_DAY).longValue();
            if (iVar != C0059i.LENIENT) {
                C0071a.MINUTE_OF_DAY.mo246a(longValue8);
            }
            mo116a((C0088i) C0071a.HOUR_OF_DAY, longValue8 / 60);
            mo116a((C0088i) C0071a.MINUTE_OF_HOUR, longValue8 % 60);
        }
        if (iVar != C0059i.LENIENT) {
            if (this.f23a.containsKey(C0071a.MILLI_OF_SECOND)) {
                C0071a.MILLI_OF_SECOND.mo246a(this.f23a.get(C0071a.MILLI_OF_SECOND).longValue());
            }
            if (this.f23a.containsKey(C0071a.MICRO_OF_SECOND)) {
                C0071a.MICRO_OF_SECOND.mo246a(this.f23a.get(C0071a.MICRO_OF_SECOND).longValue());
            }
        }
        if (this.f23a.containsKey(C0071a.MILLI_OF_SECOND) && this.f23a.containsKey(C0071a.MICRO_OF_SECOND)) {
            long longValue9 = this.f23a.remove(C0071a.MILLI_OF_SECOND).longValue();
            mo116a((C0088i) C0071a.MICRO_OF_SECOND, (this.f23a.get(C0071a.MICRO_OF_SECOND).longValue() % 1000) + (longValue9 * 1000));
        }
        if (this.f23a.containsKey(C0071a.MICRO_OF_SECOND) && this.f23a.containsKey(C0071a.NANO_OF_SECOND)) {
            mo116a((C0088i) C0071a.MICRO_OF_SECOND, this.f23a.get(C0071a.NANO_OF_SECOND).longValue() / 1000);
            this.f23a.remove(C0071a.MICRO_OF_SECOND);
        }
        if (this.f23a.containsKey(C0071a.MILLI_OF_SECOND) && this.f23a.containsKey(C0071a.NANO_OF_SECOND)) {
            mo116a((C0088i) C0071a.MILLI_OF_SECOND, this.f23a.get(C0071a.NANO_OF_SECOND).longValue() / 1000000);
            this.f23a.remove(C0071a.MILLI_OF_SECOND);
        }
        if (this.f23a.containsKey(C0071a.MICRO_OF_SECOND)) {
            mo116a((C0088i) C0071a.NANO_OF_SECOND, this.f23a.remove(C0071a.MICRO_OF_SECOND).longValue() * 1000);
        } else if (this.f23a.containsKey(C0071a.MILLI_OF_SECOND)) {
            mo116a((C0088i) C0071a.NANO_OF_SECOND, this.f23a.remove(C0071a.MILLI_OF_SECOND).longValue() * 1000000);
        }
    }

    /* renamed from: d */
    private void m174d(C0059i iVar) {
        Long l = this.f23a.get(C0071a.HOUR_OF_DAY);
        Long l2 = this.f23a.get(C0071a.MINUTE_OF_HOUR);
        Long l3 = this.f23a.get(C0071a.SECOND_OF_MINUTE);
        Long l4 = this.f23a.get(C0071a.NANO_OF_SECOND);
        if (l != null) {
            if (l2 == null && (l3 != null || l4 != null)) {
                return;
            }
            if (l2 == null || l3 != null || l4 == null) {
                if (iVar != C0059i.LENIENT) {
                    if (l != null) {
                        if (iVar == C0059i.SMART && l.longValue() == 24 && ((l2 == null || l2.longValue() == 0) && ((l3 == null || l3.longValue() == 0) && (l4 == null || l4.longValue() == 0)))) {
                            l = 0L;
                            this.f29g = C0127j.m761a(1);
                        }
                        int b = C0071a.HOUR_OF_DAY.mo251b(l.longValue());
                        if (l2 != null) {
                            int b2 = C0071a.MINUTE_OF_HOUR.mo251b(l2.longValue());
                            if (l3 != null) {
                                int b3 = C0071a.SECOND_OF_MINUTE.mo251b(l3.longValue());
                                if (l4 != null) {
                                    mo118a(C0121h.m711a(b, b2, b3, C0071a.NANO_OF_SECOND.mo251b(l4.longValue())));
                                } else {
                                    mo118a(C0121h.m710a(b, b2, b3));
                                }
                            } else if (l4 == null) {
                                mo118a(C0121h.m709a(b, b2));
                            }
                        } else if (l3 == null && l4 == null) {
                            mo118a(C0121h.m709a(b, 0));
                        }
                    }
                } else if (l != null) {
                    long longValue = l.longValue();
                    if (l2 == null) {
                        int a = C0069c.m375a(C0069c.m386e(longValue, 24));
                        mo118a(C0121h.m709a((int) ((long) C0069c.m381b(longValue, 24)), 0));
                        this.f29g = C0127j.m761a(a);
                    } else if (l3 != null) {
                        if (l4 == null) {
                            l4 = 0L;
                        }
                        long b4 = C0069c.m382b(C0069c.m382b(C0069c.m382b(C0069c.m385d(longValue, 3600000000000L), C0069c.m385d(l2.longValue(), 60000000000L)), C0069c.m385d(l3.longValue(), 1000000000)), l4.longValue());
                        mo118a(C0121h.m716b(C0069c.m387f(b4, 86400000000000L)));
                        this.f29g = C0127j.m761a((int) C0069c.m386e(b4, 86400000000000L));
                    } else {
                        long b5 = C0069c.m382b(C0069c.m385d(longValue, 3600), C0069c.m385d(l2.longValue(), 60));
                        mo118a(C0121h.m712a(C0069c.m387f(b5, 86400)));
                        this.f29g = C0127j.m761a((int) C0069c.m386e(b5, 86400));
                    }
                }
                this.f23a.remove(C0071a.HOUR_OF_DAY);
                this.f23a.remove(C0071a.MINUTE_OF_HOUR);
                this.f23a.remove(C0071a.SECOND_OF_MINUTE);
                this.f23a.remove(C0071a.NANO_OF_SECOND);
            }
        }
    }

    /* renamed from: a */
    private void m161a() {
        if (!this.f23a.containsKey(C0071a.INSTANT_SECONDS)) {
            return;
        }
        if (this.f25c != null) {
            m166a(this.f25c);
            return;
        }
        Long l = this.f23a.get(C0071a.OFFSET_SECONDS);
        if (l != null) {
            m166a((C0134m) C0136n.m832a(l.intValue()));
        }
    }

    /* renamed from: a */
    private void m166a(C0134m mVar) {
        C0013e a = this.f24b.mo93a(C0103e.m532a(this.f23a.remove(C0071a.INSTANT_SECONDS).longValue()), mVar);
        if (this.f26d == null) {
            mo117a(a.mo84h());
        } else {
            m163a((C0088i) C0071a.INSTANT_SECONDS, a.mo84h());
        }
        mo116a((C0088i) C0071a.SECOND_OF_DAY, (long) a.mo82f().mo391c());
    }

    /* renamed from: b */
    private void m169b() {
        if (this.f23a.size() <= 0) {
            return;
        }
        if (this.f26d != null && this.f27e != null) {
            m162a((C0082e) this.f26d.mo20b(this.f27e));
        } else if (this.f26d != null) {
            m162a((C0082e) this.f26d);
        } else if (this.f27e != null) {
            m162a((C0082e) this.f27e);
        }
    }

    /* renamed from: a */
    private void m162a(C0082e eVar) {
        Iterator<Map.Entry<C0088i, Long>> it = this.f23a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            C0088i iVar = (C0088i) next.getKey();
            long longValue = ((Long) next.getValue()).longValue();
            if (eVar.mo18a(iVar)) {
                try {
                    long d = eVar.mo68d(iVar);
                    if (d != longValue) {
                        throw new C0023b("Cross check failed: " + iVar + " " + d + " vs " + iVar + " " + longValue);
                    }
                    it.remove();
                } catch (RuntimeException e) {
                }
            }
        }
    }

    /* renamed from: c */
    private void m171c() {
        if (this.f27e != null) {
            return;
        }
        if (!this.f23a.containsKey(C0071a.INSTANT_SECONDS) && !this.f23a.containsKey(C0071a.SECOND_OF_DAY) && !this.f23a.containsKey(C0071a.SECOND_OF_MINUTE)) {
            return;
        }
        if (this.f23a.containsKey(C0071a.NANO_OF_SECOND)) {
            long longValue = this.f23a.get(C0071a.NANO_OF_SECOND).longValue();
            this.f23a.put(C0071a.MICRO_OF_SECOND, Long.valueOf(longValue / 1000));
            this.f23a.put(C0071a.MILLI_OF_SECOND, Long.valueOf(longValue / 1000000));
            return;
        }
        this.f23a.put(C0071a.NANO_OF_SECOND, 0L);
        this.f23a.put(C0071a.MICRO_OF_SECOND, 0L);
        this.f23a.put(C0071a.MILLI_OF_SECOND, 0L);
    }

    /* renamed from: d */
    private void m173d() {
        if (this.f26d != null && this.f27e != null) {
            if (this.f25c != null) {
                this.f23a.put(C0071a.INSTANT_SECONDS, Long.valueOf(this.f26d.mo20b(this.f27e).mo46b(this.f25c).mo68d(C0071a.INSTANT_SECONDS)));
                return;
            }
            Long l = this.f23a.get(C0071a.OFFSET_SECONDS);
            if (l != null) {
                this.f23a.put(C0071a.INSTANT_SECONDS, Long.valueOf(this.f26d.mo20b(this.f27e).mo46b((C0134m) C0136n.m832a(l.intValue())).mo68d(C0071a.INSTANT_SECONDS)));
            }
        }
    }

    /* renamed from: b */
    public <R> R mo119b(C0097k<R> kVar) {
        return kVar.mo107b(this);
    }

    /* renamed from: a */
    public boolean mo18a(C0088i iVar) {
        if (iVar == null) {
            return false;
        }
        if (this.f23a.containsKey(iVar) || ((this.f26d != null && this.f26d.mo18a(iVar)) || (this.f27e != null && this.f27e.mo18a(iVar)))) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        C0069c.m378a(iVar, "field");
        Long e = m175e(iVar);
        if (e != null) {
            return e.longValue();
        }
        if (this.f26d != null && this.f26d.mo18a(iVar)) {
            return this.f26d.mo68d(iVar);
        }
        if (this.f27e != null && this.f27e.mo18a(iVar)) {
            return this.f27e.mo68d(iVar);
        }
        throw new C0023b("Field not found: " + iVar);
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m467a()) {
            return this.f25c;
        }
        if (kVar == C0089j.m468b()) {
            return this.f24b;
        }
        if (kVar == C0089j.m472f()) {
            if (this.f26d != null) {
                return C0115f.m610a((C0082e) this.f26d);
            }
            return null;
        } else if (kVar == C0089j.m473g()) {
            return this.f27e;
        } else {
            if (kVar == C0089j.m470d() || kVar == C0089j.m471e()) {
                return kVar.mo107b(this);
            }
            if (kVar != C0089j.m469c()) {
                return kVar.mo107b(this);
            }
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("DateTimeBuilder[");
        if (this.f23a.size() > 0) {
            sb.append("fields=").append(this.f23a);
        }
        sb.append(", ").append(this.f24b);
        sb.append(", ").append(this.f25c);
        sb.append(", ").append(this.f26d);
        sb.append(", ").append(this.f27e);
        sb.append(']');
        return sb.toString();
    }
}
