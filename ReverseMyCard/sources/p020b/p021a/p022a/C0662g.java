package p020b.p021a.p022a;

import android.support.p016v4.p018os.EnvironmentCompat;

/* renamed from: b.a.a.g */
/* compiled from: MajorIndustryIdentifier */
public enum C0662g {
    f1258a(-1, EnvironmentCompat.MEDIA_UNKNOWN),
    mii_0(0, "ISO/TC 68 and other future industry assignments"),
    mii_1(1, "Airlines"),
    mii_2(2, "Airlines and other future industry assignments"),
    mii_3(3, "Travel and entertainment and banking/financial"),
    mii_4(4, "Banking and financial"),
    mii_5(5, "Banking and financial"),
    mii_6(6, "Merchandising and banking/financial"),
    mii_7(7, "Petroleum and other future industry assignments"),
    mii_8(8, "Healthcare, telecommunications and other future industry assignments"),
    mii_9(9, "National assignment");
    

    /* renamed from: l */
    private final int f1270l;

    /* renamed from: m */
    private final String f1271m;

    /* renamed from: a */
    public static C0662g m1951a(String str) {
        if (str != null && !str.isEmpty()) {
            int digit = Character.digit(str.charAt(0), 10);
            for (C0662g gVar : values()) {
                if (gVar.mo8054a() == digit) {
                    return gVar;
                }
            }
        }
        return f1258a;
    }

    private C0662g(int i, String str) {
        this.f1270l = i;
        this.f1271m = str;
    }

    /* renamed from: a */
    public int mo8054a() {
        return this.f1270l;
    }

    public String toString() {
        return String.format("%d - %s", new Object[]{Integer.valueOf(this.f1270l), this.f1271m});
    }
}
