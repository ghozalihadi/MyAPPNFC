package p020b.p021a.p022a;

import java.util.regex.Pattern;
import p000a.p001a.p002a.p005b.C0002a;

/* renamed from: b.a.a.e */
/* compiled from: CardBrand */
public enum C0660e {
    Unknown(Pattern.compile("^unknown$")),
    Visa(Pattern.compile("^4[0-9]{6,}$")),
    MasterCard(Pattern.compile("^5[1-5][0-9]{5,}$")),
    AmericanExpress(Pattern.compile("^3[47][0-9]{5,}$")),
    DinersClub(Pattern.compile("^3(?:0[0-5]|[68][0-9])[0-9]{4,}$")),
    Discover(Pattern.compile("^6(?:011|5[0-9]{2})[0-9]{3,}$")),
    JCB(Pattern.compile("^(?:2131|1800|35[0-9]{3})[0-9]{3,}$"));
    

    /* renamed from: h */
    private final Pattern f1255h;

    /* renamed from: a */
    public static C0660e m1947a(String str) {
        if (C0002a.m10b(str)) {
            return Unknown;
        }
        for (C0660e eVar : values()) {
            if (eVar.f1255h.matcher(str).matches()) {
                return eVar;
            }
        }
        return Unknown;
    }

    private C0660e(Pattern pattern) {
        this.f1255h = pattern;
    }
}
