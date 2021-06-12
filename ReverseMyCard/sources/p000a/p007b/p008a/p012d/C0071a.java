package p000a.p007b.p008a.p012d;

import java.util.Map;
import p000a.p007b.p008a.p010b.C0059i;

/* renamed from: a.b.a.d.a */
/* compiled from: ChronoField */
public enum C0071a implements C0088i {
    NANO_OF_SECOND("NanoOfSecond", C0072b.NANOS, C0072b.SECONDS, C0100n.m491a(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", C0072b.NANOS, C0072b.DAYS, C0100n.m491a(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", C0072b.MICROS, C0072b.SECONDS, C0100n.m491a(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", C0072b.MICROS, C0072b.DAYS, C0100n.m491a(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", C0072b.MILLIS, C0072b.SECONDS, C0100n.m491a(0, 999)),
    MILLI_OF_DAY("MilliOfDay", C0072b.MILLIS, C0072b.DAYS, C0100n.m491a(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", C0072b.SECONDS, C0072b.MINUTES, C0100n.m491a(0, 59)),
    SECOND_OF_DAY("SecondOfDay", C0072b.SECONDS, C0072b.DAYS, C0100n.m491a(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", C0072b.MINUTES, C0072b.HOURS, C0100n.m491a(0, 59)),
    MINUTE_OF_DAY("MinuteOfDay", C0072b.MINUTES, C0072b.DAYS, C0100n.m491a(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", C0072b.HOURS, C0072b.HALF_DAYS, C0100n.m491a(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", C0072b.HOURS, C0072b.HALF_DAYS, C0100n.m491a(1, 12)),
    HOUR_OF_DAY("HourOfDay", C0072b.HOURS, C0072b.DAYS, C0100n.m491a(0, 23)),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", C0072b.HOURS, C0072b.DAYS, C0100n.m491a(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", C0072b.HALF_DAYS, C0072b.DAYS, C0100n.m491a(0, 1)),
    DAY_OF_WEEK("DayOfWeek", C0072b.DAYS, C0072b.WEEKS, C0100n.m491a(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", C0072b.DAYS, C0072b.WEEKS, C0100n.m491a(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", C0072b.DAYS, C0072b.WEEKS, C0100n.m491a(1, 7)),
    DAY_OF_MONTH("DayOfMonth", r11, C0072b.MONTHS, C0100n.m492a(1, 28, 31)),
    DAY_OF_YEAR("DayOfYear", r11, C0072b.YEARS, C0100n.m492a(1, 365, 366)),
    EPOCH_DAY("EpochDay", C0072b.DAYS, C0072b.FOREVER, C0100n.m491a(-365249999634L, 365249999634L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", r11, C0072b.MONTHS, C0100n.m492a(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", C0072b.WEEKS, C0072b.YEARS, C0100n.m491a(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", C0072b.MONTHS, C0072b.YEARS, C0100n.m491a(1, 12)),
    PROLEPTIC_MONTH("ProlepticMonth", C0072b.MONTHS, C0072b.FOREVER, C0100n.m491a(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", r11, C0072b.FOREVER, C0100n.m492a(1, 999999999, 1000000000)),
    YEAR("Year", C0072b.YEARS, C0072b.FOREVER, C0100n.m491a(-999999999, 999999999)),
    ERA("Era", C0072b.ERAS, C0072b.FOREVER, C0100n.m491a(0, 1)),
    INSTANT_SECONDS("InstantSeconds", C0072b.SECONDS, C0072b.FOREVER, C0100n.m491a(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", C0072b.SECONDS, C0072b.FOREVER, C0100n.m491a(-64800, 64800));
    

    /* renamed from: E */
    private final String f209E;

    /* renamed from: F */
    private final C0098l f210F;

    /* renamed from: G */
    private final C0098l f211G;

    /* renamed from: H */
    private final C0100n f212H;

    private C0071a(String str, C0098l lVar, C0098l lVar2, C0100n nVar) {
        this.f209E = str;
        this.f210F = lVar;
        this.f211G = lVar2;
        this.f212H = nVar;
    }

    /* renamed from: a */
    public C0100n mo249a() {
        return this.f212H;
    }

    /* renamed from: b */
    public boolean mo253b() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    /* renamed from: c */
    public boolean mo255c() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    /* renamed from: a */
    public long mo246a(long j) {
        return mo249a().mo272a(j, (C0088i) this);
    }

    /* renamed from: b */
    public int mo251b(long j) {
        return mo249a().mo275b(j, this);
    }

    /* renamed from: a */
    public boolean mo250a(C0082e eVar) {
        return eVar.mo18a((C0088i) this);
    }

    /* renamed from: b */
    public C0100n mo252b(C0082e eVar) {
        return eVar.mo66b(this);
    }

    /* renamed from: c */
    public long mo254c(C0082e eVar) {
        return eVar.mo68d(this);
    }

    /* renamed from: a */
    public <R extends C0081d> R mo247a(R r, long j) {
        return r.mo22b(this, j);
    }

    /* renamed from: a */
    public C0082e mo248a(Map<C0088i, Long> map, C0082e eVar, C0059i iVar) {
        return null;
    }

    public String toString() {
        return this.f209E;
    }
}
