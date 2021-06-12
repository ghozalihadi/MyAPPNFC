package p000a.p007b.p008a.p010b;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.C0127j;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p009a.C0021i;
import p000a.p007b.p008a.p010b.C0028c;
import p000a.p007b.p008a.p010b.C0051d;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0073c;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0097k;

/* renamed from: a.b.a.b.b */
/* compiled from: DateTimeFormatter */
public final class C0025b {

    /* renamed from: a */
    public static final C0025b f30a = new C0028c().mo145a((C0088i) C0071a.YEAR, 4, 10, C0060j.EXCEEDS_PAD).mo137a('-').mo143a((C0088i) C0071a.MONTH_OF_YEAR, 2).mo137a('-').mo143a((C0088i) C0071a.DAY_OF_MONTH, 2).mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: b */
    public static final C0025b f31b = new C0028c().mo151b().mo140a(f30a).mo156e().mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: c */
    public static final C0025b f32c = new C0028c().mo151b().mo140a(f30a).mo159h().mo156e().mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: d */
    public static final C0025b f33d = new C0028c().mo143a((C0088i) C0071a.HOUR_OF_DAY, 2).mo137a(':').mo143a((C0088i) C0071a.MINUTE_OF_HOUR, 2).mo159h().mo137a(':').mo143a((C0088i) C0071a.SECOND_OF_MINUTE, 2).mo159h().mo146a((C0088i) C0071a.NANO_OF_SECOND, 0, 9, true).mo134a(C0059i.STRICT);

    /* renamed from: e */
    public static final C0025b f34e = new C0028c().mo151b().mo140a(f33d).mo156e().mo134a(C0059i.STRICT);

    /* renamed from: f */
    public static final C0025b f35f = new C0028c().mo151b().mo140a(f33d).mo159h().mo156e().mo134a(C0059i.STRICT);

    /* renamed from: g */
    public static final C0025b f36g = new C0028c().mo151b().mo140a(f30a).mo137a('T').mo140a(f33d).mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: h */
    public static final C0025b f37h = new C0028c().mo151b().mo140a(f36g).mo156e().mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: i */
    public static final C0025b f38i = new C0028c().mo140a(f37h).mo159h().mo137a('[').mo136a().mo158g().mo137a(']').mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: j */
    public static final C0025b f39j = new C0028c().mo140a(f36g).mo159h().mo156e().mo159h().mo137a('[').mo136a().mo158g().mo137a(']').mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: k */
    public static final C0025b f40k = new C0028c().mo151b().mo145a((C0088i) C0071a.YEAR, 4, 10, C0060j.EXCEEDS_PAD).mo137a('-').mo143a((C0088i) C0071a.DAY_OF_YEAR, 3).mo159h().mo156e().mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: l */
    public static final C0025b f41l = new C0028c().mo151b().mo145a(C0073c.f235d, 4, 10, C0060j.EXCEEDS_PAD).mo149a("-W").mo143a(C0073c.f234c, 2).mo137a('-').mo143a((C0088i) C0071a.DAY_OF_WEEK, 1).mo159h().mo156e().mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: m */
    public static final C0025b f42m = new C0028c().mo151b().mo155d().mo134a(C0059i.STRICT);

    /* renamed from: n */
    public static final C0025b f43n = new C0028c().mo151b().mo143a((C0088i) C0071a.YEAR, 4).mo143a((C0088i) C0071a.MONTH_OF_YEAR, 2).mo143a((C0088i) C0071a.DAY_OF_MONTH, 2).mo159h().mo150a("+HHMMss", "Z").mo134a(C0059i.STRICT).mo121a((C0018g) C0021i.f19b);

    /* renamed from: o */
    public static final C0025b f44o;

    /* renamed from: p */
    private static final C0097k<C0127j> f45p = new C0097k<C0127j>() {
        /* renamed from: a */
        public C0127j mo107b(C0082e eVar) {
            if (eVar instanceof C0024a) {
                return ((C0024a) eVar).f29g;
            }
            return C0127j.f360a;
        }
    };

    /* renamed from: q */
    private static final C0097k<Boolean> f46q = new C0097k<Boolean>() {
        /* renamed from: a */
        public Boolean mo107b(C0082e eVar) {
            if (eVar instanceof C0024a) {
                return Boolean.valueOf(((C0024a) eVar).f28f);
            }
            return Boolean.FALSE;
        }
    };

    /* renamed from: r */
    private final C0028c.C0034b f47r;

    /* renamed from: s */
    private final Locale f48s;

    /* renamed from: t */
    private final C0058h f49t;

    /* renamed from: u */
    private final C0059i f50u;

    /* renamed from: v */
    private final Set<C0088i> f51v;

    /* renamed from: w */
    private final C0018g f52w;

    /* renamed from: x */
    private final C0134m f53x;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        f44o = new C0028c().mo151b().mo154c().mo159h().mo148a((C0088i) C0071a.DAY_OF_WEEK, (Map<Long, String>) hashMap).mo149a(", ").mo160i().mo145a((C0088i) C0071a.DAY_OF_MONTH, 1, 2, C0060j.NOT_NEGATIVE).mo137a(' ').mo148a((C0088i) C0071a.MONTH_OF_YEAR, (Map<Long, String>) hashMap2).mo137a(' ').mo143a((C0088i) C0071a.YEAR, 4).mo137a(' ').mo143a((C0088i) C0071a.HOUR_OF_DAY, 2).mo137a(':').mo143a((C0088i) C0071a.MINUTE_OF_HOUR, 2).mo159h().mo137a(':').mo143a((C0088i) C0071a.SECOND_OF_MINUTE, 2).mo160i().mo137a(' ').mo150a("+HHMM", "GMT").mo134a(C0059i.SMART).mo121a((C0018g) C0021i.f19b);
    }

    /* renamed from: a */
    public static C0025b m185a(String str) {
        return new C0028c().mo153b(str).mo161j();
    }

    C0025b(C0028c.C0034b bVar, Locale locale, C0058h hVar, C0059i iVar, Set<C0088i> set, C0018g gVar, C0134m mVar) {
        this.f47r = (C0028c.C0034b) C0069c.m378a(bVar, "printerParser");
        this.f48s = (Locale) C0069c.m378a(locale, "locale");
        this.f49t = (C0058h) C0069c.m378a(hVar, "decimalStyle");
        this.f50u = (C0059i) C0069c.m378a(iVar, "resolverStyle");
        this.f51v = set;
        this.f52w = gVar;
        this.f53x = mVar;
    }

    /* renamed from: a */
    public Locale mo126a() {
        return this.f48s;
    }

    /* renamed from: b */
    public C0058h mo128b() {
        return this.f49t;
    }

    /* renamed from: c */
    public C0018g mo129c() {
        return this.f52w;
    }

    /* renamed from: a */
    public C0025b mo121a(C0018g gVar) {
        if (C0069c.m379a((Object) this.f52w, (Object) gVar)) {
            return this;
        }
        return new C0025b(this.f47r, this.f48s, this.f49t, this.f50u, this.f51v, gVar, this.f53x);
    }

    /* renamed from: d */
    public C0134m mo130d() {
        return this.f53x;
    }

    /* renamed from: a */
    public C0025b mo122a(C0059i iVar) {
        C0069c.m378a(iVar, "resolverStyle");
        if (C0069c.m379a((Object) this.f50u, (Object) iVar)) {
            return this;
        }
        return new C0025b(this.f47r, this.f48s, this.f49t, iVar, this.f51v, this.f52w, this.f53x);
    }

    /* renamed from: a */
    public String mo125a(C0082e eVar) {
        StringBuilder sb = new StringBuilder(32);
        mo127a(eVar, (Appendable) sb);
        return sb.toString();
    }

    /* renamed from: a */
    public void mo127a(C0082e eVar, Appendable appendable) {
        C0069c.m378a(eVar, "temporal");
        C0069c.m378a(appendable, "appendable");
        try {
            C0055f fVar = new C0055f(eVar, this);
            if (appendable instanceof StringBuilder) {
                this.f47r.mo168a(fVar, (StringBuilder) appendable);
                return;
            }
            StringBuilder sb = new StringBuilder(32);
            this.f47r.mo168a(fVar, sb);
            appendable.append(sb);
        } catch (IOException e) {
            throw new C0023b(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public <T> T mo124a(CharSequence charSequence, C0097k<T> kVar) {
        C0069c.m378a(charSequence, "text");
        C0069c.m378a(kVar, "type");
        try {
            return m184a(charSequence, (ParsePosition) null).mo115a(this.f50u, this.f51v).mo119b(kVar);
        } catch (C0054e e) {
            throw e;
        } catch (RuntimeException e2) {
            throw m186a(charSequence, e2);
        }
    }

    /* renamed from: a */
    private C0054e m186a(CharSequence charSequence, RuntimeException runtimeException) {
        String obj;
        if (charSequence.length() > 64) {
            obj = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            obj = charSequence.toString();
        }
        return new C0054e("Text '" + obj + "' could not be parsed: " + runtimeException.getMessage(), charSequence, 0, runtimeException);
    }

    /* renamed from: a */
    private C0024a m184a(CharSequence charSequence, ParsePosition parsePosition) {
        String obj;
        ParsePosition parsePosition2 = parsePosition != null ? parsePosition : new ParsePosition(0);
        C0051d.C0053a b = m187b(charSequence, parsePosition2);
        if (b != null && parsePosition2.getErrorIndex() < 0 && (parsePosition != null || parsePosition2.getIndex() >= charSequence.length())) {
            return b.mo211b();
        }
        if (charSequence.length() > 64) {
            obj = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            obj = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            throw new C0054e("Text '" + obj + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
        }
        throw new C0054e("Text '" + obj + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
    }

    /* renamed from: b */
    private C0051d.C0053a m187b(CharSequence charSequence, ParsePosition parsePosition) {
        C0069c.m378a(charSequence, "text");
        C0069c.m378a(parsePosition, "position");
        C0051d dVar = new C0051d(this);
        int a = this.f47r.mo167a(dVar, charSequence, parsePosition.getIndex());
        if (a < 0) {
            parsePosition.setErrorIndex(a ^ -1);
            return null;
        }
        parsePosition.setIndex(a);
        return dVar.mo208i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0028c.C0034b mo123a(boolean z) {
        return this.f47r.mo170a(z);
    }

    public String toString() {
        String bVar = this.f47r.toString();
        return bVar.startsWith("[") ? bVar : bVar.substring(1, bVar.length() - 1);
    }
}
