package p000a.p007b.p008a.p012d;

import p000a.p007b.p008a.C0070d;

/* renamed from: a.b.a.d.b */
/* compiled from: ChronoUnit */
public enum C0072b implements C0098l {
    NANOS("Nanos", C0070d.m391b(1)),
    MICROS("Micros", C0070d.m391b(1000)),
    MILLIS("Millis", C0070d.m391b(1000000)),
    SECONDS("Seconds", C0070d.m388a(1)),
    MINUTES("Minutes", C0070d.m388a(60)),
    HOURS("Hours", C0070d.m388a(3600)),
    HALF_DAYS("HalfDays", C0070d.m388a(43200)),
    DAYS("Days", C0070d.m388a(86400)),
    WEEKS("Weeks", C0070d.m388a(604800)),
    MONTHS("Months", C0070d.m388a(2629746)),
    YEARS("Years", C0070d.m388a(31556952)),
    DECADES("Decades", C0070d.m388a(315569520)),
    CENTURIES("Centuries", C0070d.m388a(3155695200L)),
    MILLENNIA("Millennia", C0070d.m388a(31556952000L)),
    ERAS("Eras", C0070d.m388a(31556952000000000L)),
    FOREVER("Forever", C0070d.m390a(Long.MAX_VALUE, 999999999));
    

    /* renamed from: q */
    private final String f230q;

    /* renamed from: r */
    private final C0070d f231r;

    private C0072b(String str, C0070d dVar) {
        this.f230q = str;
        this.f231r = dVar;
    }

    /* renamed from: a */
    public boolean mo258a() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    /* renamed from: a */
    public <R extends C0081d> R mo257a(R r, long j) {
        return r.mo30d(j, this);
    }

    public String toString() {
        return this.f230q;
    }
}
