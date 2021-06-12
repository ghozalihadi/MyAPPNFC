package p000a.p007b.p008a.p012d;

import p000a.p007b.p008a.C0065c;
import p000a.p007b.p008a.p011c.C0069c;

/* renamed from: a.b.a.d.g */
/* compiled from: TemporalAdjusters */
public final class C0084g {
    /* renamed from: a */
    public static C0083f m455a(C0065c cVar) {
        return new C0086a(0, cVar);
    }

    /* renamed from: b */
    public static C0083f m456b(C0065c cVar) {
        return new C0086a(1, cVar);
    }

    /* renamed from: a.b.a.d.g$a */
    /* compiled from: TemporalAdjusters */
    private static final class C0086a implements C0083f {

        /* renamed from: a */
        private final int f250a;

        /* renamed from: b */
        private final int f251b;

        private C0086a(int i, C0065c cVar) {
            C0069c.m378a(cVar, "dayOfWeek");
            this.f250a = i;
            this.f251b = cVar.mo236a();
        }

        /* renamed from: a */
        public C0081d mo16a(C0081d dVar) {
            int c = dVar.mo67c(C0071a.DAY_OF_WEEK);
            if (this.f250a < 2 && c == this.f251b) {
                return dVar;
            }
            if ((this.f250a & 1) == 0) {
                int i = c - this.f251b;
                return dVar.mo30d(i >= 0 ? (long) (7 - i) : (long) (-i), C0072b.DAYS);
            }
            int i2 = this.f251b - c;
            return dVar.mo27c(i2 >= 0 ? (long) (7 - i2) : (long) (-i2), C0072b.DAYS);
        }
    }
}
