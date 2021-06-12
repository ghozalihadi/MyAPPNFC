package p000a.p007b.p008a.p010b;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0118g;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p009a.C0018g;
import p000a.p007b.p008a.p010b.C0061k;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0073c;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0100n;
import p000a.p007b.p008a.p012d.C0101o;
import p000a.p007b.p008a.p013e.C0114f;

/* renamed from: a.b.a.b.c */
/* compiled from: DateTimeFormatterBuilder */
public final class C0028c {

    /* renamed from: a */
    static final Comparator<String> f54a = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
        }
    };

    /* renamed from: b */
    private static final C0097k<C0134m> f55b = new C0097k<C0134m>() {
        /* renamed from: a */
        public C0134m mo107b(C0082e eVar) {
            C0134m mVar = (C0134m) eVar.mo17a(C0089j.m467a());
            if (mVar == null || (mVar instanceof C0136n)) {
                return null;
            }
            return mVar;
        }
    };

    /* renamed from: j */
    private static final Map<Character, C0088i> f56j = new HashMap();

    /* renamed from: c */
    private C0028c f57c;

    /* renamed from: d */
    private final C0028c f58d;

    /* renamed from: e */
    private final List<C0035c> f59e;

    /* renamed from: f */
    private final boolean f60f;

    /* renamed from: g */
    private int f61g;

    /* renamed from: h */
    private char f62h;

    /* renamed from: i */
    private int f63i;

    /* renamed from: a.b.a.b.c$c */
    /* compiled from: DateTimeFormatterBuilder */
    interface C0035c {
        /* renamed from: a */
        int mo167a(C0051d dVar, CharSequence charSequence, int i);

        /* renamed from: a */
        boolean mo168a(C0055f fVar, StringBuilder sb);
    }

    static {
        f56j.put('G', C0071a.ERA);
        f56j.put('y', C0071a.YEAR_OF_ERA);
        f56j.put('u', C0071a.YEAR);
        f56j.put('Q', C0073c.f233b);
        f56j.put('q', C0073c.f233b);
        f56j.put('M', C0071a.MONTH_OF_YEAR);
        f56j.put('L', C0071a.MONTH_OF_YEAR);
        f56j.put('D', C0071a.DAY_OF_YEAR);
        f56j.put('d', C0071a.DAY_OF_MONTH);
        f56j.put('F', C0071a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        f56j.put('E', C0071a.DAY_OF_WEEK);
        f56j.put('c', C0071a.DAY_OF_WEEK);
        f56j.put('e', C0071a.DAY_OF_WEEK);
        f56j.put('a', C0071a.AMPM_OF_DAY);
        f56j.put('H', C0071a.HOUR_OF_DAY);
        f56j.put('k', C0071a.CLOCK_HOUR_OF_DAY);
        f56j.put('K', C0071a.HOUR_OF_AMPM);
        f56j.put('h', C0071a.CLOCK_HOUR_OF_AMPM);
        f56j.put('m', C0071a.MINUTE_OF_HOUR);
        f56j.put('s', C0071a.SECOND_OF_MINUTE);
        f56j.put('S', C0071a.NANO_OF_SECOND);
        f56j.put('A', C0071a.MILLI_OF_DAY);
        f56j.put('n', C0071a.NANO_OF_SECOND);
        f56j.put('N', C0071a.NANO_OF_DAY);
    }

    public C0028c() {
        this.f57c = this;
        this.f59e = new ArrayList();
        this.f63i = -1;
        this.f58d = null;
        this.f60f = false;
    }

    private C0028c(C0028c cVar, boolean z) {
        this.f57c = this;
        this.f59e = new ArrayList();
        this.f63i = -1;
        this.f58d = cVar;
        this.f60f = z;
    }

    /* renamed from: a */
    public C0028c mo136a() {
        m202a((C0035c) C0043k.SENSITIVE);
        return this;
    }

    /* renamed from: b */
    public C0028c mo151b() {
        m202a((C0035c) C0043k.INSENSITIVE);
        return this;
    }

    /* renamed from: c */
    public C0028c mo154c() {
        m202a((C0035c) C0043k.LENIENT);
        return this;
    }

    /* renamed from: a */
    public C0028c mo142a(C0088i iVar) {
        C0069c.m378a(iVar, "field");
        m203a(new C0039g(iVar, 1, 19, C0060j.NORMAL));
        return this;
    }

    /* renamed from: a */
    public C0028c mo143a(C0088i iVar, int i) {
        C0069c.m378a(iVar, "field");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i);
        }
        m203a(new C0039g(iVar, i, i, C0060j.NOT_NEGATIVE));
        return this;
    }

    /* renamed from: a */
    public C0028c mo145a(C0088i iVar, int i, int i2, C0060j jVar) {
        if (i == i2 && jVar == C0060j.NOT_NEGATIVE) {
            return mo143a(iVar, i2);
        }
        C0069c.m378a(iVar, "field");
        C0069c.m378a(jVar, "signStyle");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i);
        } else if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i2);
        } else if (i2 < i) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
        } else {
            m203a(new C0039g(iVar, i, i2, jVar));
            return this;
        }
    }

    /* renamed from: a */
    public C0028c mo144a(C0088i iVar, int i, int i2, C0006a aVar) {
        C0069c.m378a(iVar, "field");
        C0069c.m378a(aVar, "baseDate");
        m203a((C0039g) new C0042j(iVar, i, i2, 0, aVar));
        return this;
    }

    /* renamed from: a */
    private C0028c m203a(C0039g gVar) {
        C0039g a;
        if (this.f57c.f63i < 0 || !(this.f57c.f59e.get(this.f57c.f63i) instanceof C0039g)) {
            this.f57c.f63i = m202a((C0035c) gVar);
        } else {
            int i = this.f57c.f63i;
            C0039g gVar2 = (C0039g) this.f57c.f59e.get(i);
            if (gVar.f78c == gVar.f79d && gVar.f80e == C0060j.NOT_NEGATIVE) {
                a = gVar2.mo177a(gVar.f79d);
                m202a((C0035c) gVar.mo176a());
                this.f57c.f63i = i;
            } else {
                a = gVar2.mo176a();
                this.f57c.f63i = m202a((C0035c) gVar);
            }
            this.f57c.f59e.set(i, a);
        }
        return this;
    }

    /* renamed from: a */
    public C0028c mo146a(C0088i iVar, int i, int i2, boolean z) {
        m202a((C0035c) new C0036d(iVar, i, i2, z));
        return this;
    }

    /* renamed from: a */
    public C0028c mo147a(C0088i iVar, C0064l lVar) {
        C0069c.m378a(iVar, "field");
        C0069c.m378a(lVar, "textStyle");
        m202a((C0035c) new C0045m(iVar, lVar, C0057g.m334a()));
        return this;
    }

    /* renamed from: a */
    public C0028c mo148a(C0088i iVar, Map<Long, String> map) {
        C0069c.m378a(iVar, "field");
        C0069c.m378a(map, "textLookup");
        final C0061k.C0063a aVar = new C0061k.C0063a(Collections.singletonMap(C0064l.FULL, new LinkedHashMap(map)));
        m202a((C0035c) new C0045m(iVar, C0064l.FULL, new C0057g() {
            /* renamed from: a */
            public String mo163a(C0088i iVar, long j, C0064l lVar, Locale locale) {
                return aVar.mo233a(j, lVar);
            }

            /* renamed from: a */
            public Iterator<Map.Entry<String, Long>> mo164a(C0088i iVar, C0064l lVar, Locale locale) {
                return aVar.mo234a(lVar);
            }
        }));
        return this;
    }

    /* renamed from: d */
    public C0028c mo155d() {
        m202a((C0035c) new C0037e(-2));
        return this;
    }

    /* renamed from: e */
    public C0028c mo156e() {
        m202a((C0035c) C0040h.f83b);
        return this;
    }

    /* renamed from: a */
    public C0028c mo150a(String str, String str2) {
        m202a((C0035c) new C0040h(str2, str));
        return this;
    }

    /* renamed from: a */
    public C0028c mo141a(C0064l lVar) {
        C0069c.m378a(lVar, "style");
        if (lVar == C0064l.FULL || lVar == C0064l.SHORT) {
            m202a((C0035c) new C0038f(lVar));
            return this;
        }
        throw new IllegalArgumentException("Style must be either full or short");
    }

    /* renamed from: f */
    public C0028c mo157f() {
        m202a((C0035c) new C0047o(C0089j.m467a(), "ZoneId()"));
        return this;
    }

    /* renamed from: g */
    public C0028c mo158g() {
        m202a((C0035c) new C0047o(f55b, "ZoneRegionId()"));
        return this;
    }

    /* renamed from: b */
    public C0028c mo152b(C0064l lVar) {
        m202a((C0035c) new C0049p(lVar));
        return this;
    }

    /* renamed from: a */
    public C0028c mo137a(char c) {
        m202a((C0035c) new C0033a(c));
        return this;
    }

    /* renamed from: a */
    public C0028c mo149a(String str) {
        C0069c.m378a(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                m202a((C0035c) new C0033a(str.charAt(0)));
            } else {
                m202a((C0035c) new C0044l(str));
            }
        }
        return this;
    }

    /* renamed from: a */
    public C0028c mo140a(C0025b bVar) {
        C0069c.m378a(bVar, "formatter");
        m202a((C0035c) bVar.mo123a(false));
        return this;
    }

    /* renamed from: b */
    public C0028c mo153b(String str) {
        C0069c.m378a(str, "pattern");
        m205c(str);
        return this;
    }

    /* renamed from: c */
    private void m205c(String str) {
        char c;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c2;
        int i6;
        int i7 = 0;
        while (i7 < str.length()) {
            char charAt = str.charAt(i7);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int i8 = i7 + 1;
                while (i8 < str.length() && str.charAt(i8) == charAt) {
                    i8++;
                }
                int i9 = i8 - i7;
                if (charAt == 'p') {
                    if (i8 >= str.length() || (((charAt = str.charAt(i8)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        i4 = i9;
                        i5 = i8;
                        c2 = charAt;
                        i6 = 0;
                    } else {
                        int i10 = i8 + 1;
                        while (i10 < str.length() && str.charAt(i10) == charAt) {
                            i10++;
                        }
                        int i11 = i9;
                        i5 = i10;
                        i4 = i10 - i8;
                        c2 = charAt;
                        i6 = i11;
                    }
                    if (i6 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                    mo138a(i6);
                    i = i5;
                    c = c2;
                    i2 = i4;
                } else {
                    int i12 = i9;
                    c = charAt;
                    i = i8;
                    i2 = i12;
                }
                C0088i iVar = f56j.get(Character.valueOf(c));
                if (iVar != null) {
                    m204a(c, i2, iVar);
                } else if (c == 'z') {
                    if (i2 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                    } else if (i2 == 4) {
                        mo152b(C0064l.FULL);
                    } else {
                        mo152b(C0064l.SHORT);
                    }
                } else if (c == 'V') {
                    if (i2 != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + c);
                    }
                    mo157f();
                } else if (c == 'Z') {
                    if (i2 < 4) {
                        mo150a("+HHMM", "+0000");
                    } else if (i2 == 4) {
                        mo141a(C0064l.FULL);
                    } else if (i2 == 5) {
                        mo150a("+HH:MM:ss", "Z");
                    } else {
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                    }
                } else if (c == 'O') {
                    if (i2 == 1) {
                        mo141a(C0064l.SHORT);
                    } else if (i2 == 4) {
                        mo141a(C0064l.FULL);
                    } else {
                        throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + c);
                    }
                } else if (c == 'X') {
                    if (i2 > 5) {
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                    }
                    mo150a(C0040h.f82a[(i2 == 1 ? 0 : 1) + i2], "Z");
                } else if (c == 'x') {
                    if (i2 > 5) {
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                    }
                    String str2 = i2 == 1 ? "+00" : i2 % 2 == 0 ? "+0000" : "+00:00";
                    String[] strArr = C0040h.f82a;
                    if (i2 == 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    mo150a(strArr[i2 + i3], str2);
                } else if (c == 'W') {
                    if (i2 > 1) {
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                    }
                    m202a((C0035c) new C0046n('W', i2));
                } else if (c == 'w') {
                    if (i2 > 2) {
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                    }
                    m202a((C0035c) new C0046n('w', i2));
                } else if (c == 'Y') {
                    m202a((C0035c) new C0046n('Y', i2));
                } else {
                    throw new IllegalArgumentException("Unknown pattern letter: " + c);
                }
                i7 = i - 1;
            } else if (charAt == '\'') {
                int i13 = i7 + 1;
                while (i13 < str.length()) {
                    if (str.charAt(i13) == '\'') {
                        if (i13 + 1 >= str.length() || str.charAt(i13 + 1) != '\'') {
                            break;
                        }
                        i13++;
                    }
                    i13++;
                }
                if (i13 >= str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
                String substring = str.substring(i7 + 1, i13);
                if (substring.length() == 0) {
                    mo137a('\'');
                } else {
                    mo149a(substring.replace("''", "'"));
                }
                i7 = i13;
            } else if (charAt == '[') {
                mo159h();
            } else if (charAt == ']') {
                if (this.f57c.f58d == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                mo160i();
            } else if (charAt == '{' || charAt == '}' || charAt == '#') {
                throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
            } else {
                mo137a(charAt);
            }
            i7++;
        }
    }

    /* renamed from: a */
    private void m204a(char c, int i, C0088i iVar) {
        switch (c) {
            case 'D':
                if (i == 1) {
                    mo142a(iVar);
                    return;
                } else if (i <= 3) {
                    mo143a(iVar, i);
                    return;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters: " + c);
                }
            case 'E':
            case 'G':
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                        mo147a(iVar, C0064l.SHORT);
                        return;
                    case 4:
                        mo147a(iVar, C0064l.FULL);
                        return;
                    case 5:
                        mo147a(iVar, C0064l.NARROW);
                        return;
                    default:
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                }
            case 'F':
                if (i == 1) {
                    mo142a(iVar);
                    return;
                }
                throw new IllegalArgumentException("Too many pattern letters: " + c);
            case 'H':
            case 'K':
            case 'd':
            case 'h':
            case 'k':
            case 'm':
            case 's':
                if (i == 1) {
                    mo142a(iVar);
                    return;
                } else if (i == 2) {
                    mo143a(iVar, i);
                    return;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters: " + c);
                }
            case 'L':
            case 'q':
                switch (i) {
                    case 1:
                        mo142a(iVar);
                        return;
                    case 2:
                        mo143a(iVar, 2);
                        return;
                    case 3:
                        mo147a(iVar, C0064l.SHORT_STANDALONE);
                        return;
                    case 4:
                        mo147a(iVar, C0064l.FULL_STANDALONE);
                        return;
                    case 5:
                        mo147a(iVar, C0064l.NARROW_STANDALONE);
                        return;
                    default:
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                }
            case 'M':
            case 'Q':
                switch (i) {
                    case 1:
                        mo142a(iVar);
                        return;
                    case 2:
                        mo143a(iVar, 2);
                        return;
                    case 3:
                        mo147a(iVar, C0064l.SHORT);
                        return;
                    case 4:
                        mo147a(iVar, C0064l.FULL);
                        return;
                    case 5:
                        mo147a(iVar, C0064l.NARROW);
                        return;
                    default:
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                }
            case 'S':
                mo146a((C0088i) C0071a.NANO_OF_SECOND, i, i, false);
                return;
            case 'a':
                if (i == 1) {
                    mo147a(iVar, C0064l.SHORT);
                    return;
                }
                throw new IllegalArgumentException("Too many pattern letters: " + c);
            case 'c':
                switch (i) {
                    case 1:
                        m202a((C0035c) new C0046n('c', i));
                        return;
                    case 2:
                        throw new IllegalArgumentException("Invalid number of pattern letters: " + c);
                    case 3:
                        mo147a(iVar, C0064l.SHORT_STANDALONE);
                        return;
                    case 4:
                        mo147a(iVar, C0064l.FULL_STANDALONE);
                        return;
                    case 5:
                        mo147a(iVar, C0064l.NARROW_STANDALONE);
                        return;
                    default:
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                }
            case 'e':
                switch (i) {
                    case 1:
                    case 2:
                        m202a((C0035c) new C0046n('e', i));
                        return;
                    case 3:
                        mo147a(iVar, C0064l.SHORT);
                        return;
                    case 4:
                        mo147a(iVar, C0064l.FULL);
                        return;
                    case 5:
                        mo147a(iVar, C0064l.NARROW);
                        return;
                    default:
                        throw new IllegalArgumentException("Too many pattern letters: " + c);
                }
            case 'u':
            case 'y':
                if (i == 2) {
                    mo144a(iVar, 2, 2, (C0006a) C0042j.f89g);
                    return;
                } else if (i < 4) {
                    mo145a(iVar, i, 19, C0060j.NORMAL);
                    return;
                } else {
                    mo145a(iVar, i, 19, C0060j.EXCEEDS_PAD);
                    return;
                }
            default:
                if (i == 1) {
                    mo142a(iVar);
                    return;
                } else {
                    mo143a(iVar, i);
                    return;
                }
        }
    }

    /* renamed from: a */
    public C0028c mo138a(int i) {
        return mo139a(i, ' ');
    }

    /* renamed from: a */
    public C0028c mo139a(int i, char c) {
        if (i < 1) {
            throw new IllegalArgumentException("The pad width must be at least one but was " + i);
        }
        this.f57c.f61g = i;
        this.f57c.f62h = c;
        this.f57c.f63i = -1;
        return this;
    }

    /* renamed from: h */
    public C0028c mo159h() {
        this.f57c.f63i = -1;
        this.f57c = new C0028c(this.f57c, true);
        return this;
    }

    /* renamed from: i */
    public C0028c mo160i() {
        if (this.f57c.f58d == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (this.f57c.f59e.size() > 0) {
            C0034b bVar = new C0034b(this.f57c.f59e, this.f57c.f60f);
            this.f57c = this.f57c.f58d;
            m202a((C0035c) bVar);
        } else {
            this.f57c = this.f57c.f58d;
        }
        return this;
    }

    /* renamed from: a */
    private int m202a(C0035c cVar) {
        C0069c.m378a(cVar, "pp");
        if (this.f57c.f61g > 0) {
            if (cVar != null) {
                cVar = new C0041i(cVar, this.f57c.f61g, this.f57c.f62h);
            }
            this.f57c.f61g = 0;
            this.f57c.f62h = 0;
        }
        this.f57c.f59e.add(cVar);
        this.f57c.f63i = -1;
        return this.f57c.f59e.size() - 1;
    }

    /* renamed from: j */
    public C0025b mo161j() {
        return mo135a(Locale.getDefault());
    }

    /* renamed from: a */
    public C0025b mo135a(Locale locale) {
        C0069c.m378a(locale, "locale");
        while (this.f57c.f58d != null) {
            mo160i();
        }
        return new C0025b(new C0034b(this.f59e, false), locale, C0058h.f136a, C0059i.SMART, (Set<C0088i>) null, (C0018g) null, (C0134m) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0025b mo134a(C0059i iVar) {
        return mo161j().mo122a(iVar);
    }

    /* renamed from: a.b.a.b.c$b */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0034b implements C0035c {

        /* renamed from: a */
        private final C0035c[] f68a;

        /* renamed from: b */
        private final boolean f69b;

        C0034b(List<C0035c> list, boolean z) {
            this((C0035c[]) list.toArray(new C0035c[list.size()]), z);
        }

        C0034b(C0035c[] cVarArr, boolean z) {
            this.f68a = cVarArr;
            this.f69b = z;
        }

        /* renamed from: a */
        public C0034b mo170a(boolean z) {
            return z == this.f69b ? this : new C0034b(this.f68a, z);
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            int length = sb.length();
            if (this.f69b) {
                fVar.mo218d();
            }
            try {
                C0035c[] cVarArr = this.f68a;
                int length2 = cVarArr.length;
                int i = 0;
                while (true) {
                    if (i < length2) {
                        if (!cVarArr[i].mo168a(fVar, sb)) {
                            sb.setLength(length);
                        } else {
                            i++;
                        }
                    } else if (this.f69b) {
                        fVar.mo219e();
                    }
                }
                return true;
            } finally {
                if (this.f69b) {
                    fVar.mo219e();
                }
            }
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            if (this.f69b) {
                dVar.mo206g();
                C0035c[] cVarArr = this.f68a;
                int length = cVarArr.length;
                int i2 = 0;
                int i3 = i;
                while (i2 < length) {
                    int a = cVarArr[i2].mo167a(dVar, charSequence, i3);
                    if (a < 0) {
                        dVar.mo202c(false);
                        return i;
                    }
                    i2++;
                    i3 = a;
                }
                dVar.mo202c(true);
                return i3;
            }
            int i4 = i;
            for (C0035c a2 : this.f68a) {
                i4 = a2.mo167a(dVar, charSequence, i4);
                if (i4 < 0) {
                    break;
                }
            }
            return i4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f68a != null) {
                sb.append(this.f69b ? "[" : "(");
                for (C0035c append : this.f68a) {
                    sb.append(append);
                }
                sb.append(this.f69b ? "]" : ")");
            }
            return sb.toString();
        }
    }

    /* renamed from: a.b.a.b.c$i */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0041i implements C0035c {

        /* renamed from: a */
        private final C0035c f86a;

        /* renamed from: b */
        private final int f87b;

        /* renamed from: c */
        private final char f88c;

        C0041i(C0035c cVar, int i, char c) {
            this.f86a = cVar;
            this.f87b = i;
            this.f88c = c;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            int length = sb.length();
            if (!this.f86a.mo168a(fVar, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 > this.f87b) {
                throw new C0023b("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.f87b);
            }
            for (int i = 0; i < this.f87b - length2; i++) {
                sb.insert(length, this.f88c);
            }
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            boolean f = dVar.mo205f();
            boolean e = dVar.mo204e();
            if (i > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            } else if (i == charSequence.length()) {
                return i ^ -1;
            } else {
                int i2 = this.f87b + i;
                if (i2 > charSequence.length()) {
                    if (f) {
                        return i ^ -1;
                    }
                    i2 = charSequence.length();
                }
                int i3 = i;
                while (i3 < i2) {
                    if (e) {
                        if (charSequence.charAt(i3) != this.f88c) {
                            break;
                        }
                    } else if (!dVar.mo197a(charSequence.charAt(i3), this.f88c)) {
                        break;
                    }
                    i3++;
                }
                int a = this.f86a.mo167a(dVar, charSequence.subSequence(0, i2), i3);
                return (a == i2 || !f) ? a : (i + i3) ^ -1;
            }
        }

        public String toString() {
            return "Pad(" + this.f86a + "," + this.f87b + (this.f88c == ' ' ? ")" : ",'" + this.f88c + "')");
        }
    }

    /* renamed from: a.b.a.b.c$k */
    /* compiled from: DateTimeFormatterBuilder */
    enum C0043k implements C0035c {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            switch (ordinal()) {
                case 0:
                    dVar.mo196a(true);
                    break;
                case 1:
                    dVar.mo196a(false);
                    break;
                case 2:
                    dVar.mo200b(true);
                    break;
                case 3:
                    dVar.mo200b(false);
                    break;
            }
            return i;
        }

        public String toString() {
            switch (ordinal()) {
                case 0:
                    return "ParseCaseSensitive(true)";
                case 1:
                    return "ParseCaseSensitive(false)";
                case 2:
                    return "ParseStrict(true)";
                case 3:
                    return "ParseStrict(false)";
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }
    }

    /* renamed from: a.b.a.b.c$a */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0033a implements C0035c {

        /* renamed from: a */
        private final char f67a;

        C0033a(char c) {
            this.f67a = c;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            sb.append(this.f67a);
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            if (i == charSequence.length()) {
                return i ^ -1;
            }
            if (!dVar.mo197a(this.f67a, charSequence.charAt(i))) {
                return i ^ -1;
            }
            return i + 1;
        }

        public String toString() {
            if (this.f67a == '\'') {
                return "''";
            }
            return "'" + this.f67a + "'";
        }
    }

    /* renamed from: a.b.a.b.c$l */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0044l implements C0035c {

        /* renamed from: a */
        private final String f97a;

        C0044l(String str) {
            this.f97a = str;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            sb.append(this.f97a);
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            if (i > charSequence.length() || i < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (!dVar.mo198a(charSequence, i, this.f97a, 0, this.f97a.length())) {
                return i ^ -1;
            }
            return this.f97a.length() + i;
        }

        public String toString() {
            return "'" + this.f97a.replace("'", "''") + "'";
        }
    }

    /* renamed from: a.b.a.b.c$g */
    /* compiled from: DateTimeFormatterBuilder */
    static class C0039g implements C0035c {

        /* renamed from: a */
        static final int[] f76a = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

        /* renamed from: b */
        final C0088i f77b;

        /* renamed from: c */
        final int f78c;

        /* renamed from: d */
        final int f79d;

        /* renamed from: e */
        final C0060j f80e;

        /* renamed from: f */
        final int f81f;

        C0039g(C0088i iVar, int i, int i2, C0060j jVar) {
            this.f77b = iVar;
            this.f78c = i;
            this.f79d = i2;
            this.f80e = jVar;
            this.f81f = 0;
        }

        private C0039g(C0088i iVar, int i, int i2, C0060j jVar, int i3) {
            this.f77b = iVar;
            this.f78c = i;
            this.f79d = i2;
            this.f80e = jVar;
            this.f81f = i3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0039g mo176a() {
            return this.f81f == -1 ? this : new C0039g(this.f77b, this.f78c, this.f79d, this.f80e, -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0039g mo177a(int i) {
            return new C0039g(this.f77b, this.f78c, this.f79d, this.f80e, this.f81f + i);
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            Long a = fVar.mo214a(this.f77b);
            if (a == null) {
                return false;
            }
            long a2 = mo175a(fVar, a.longValue());
            C0058h c = fVar.mo217c();
            String l = a2 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(a2));
            if (l.length() > this.f79d) {
                throw new C0023b("Field " + this.f77b + " cannot be printed as the value " + a2 + " exceeds the maximum print width of " + this.f79d);
            }
            String a3 = c.mo223a(l);
            if (a2 >= 0) {
                switch (this.f80e) {
                    case EXCEEDS_PAD:
                        if (this.f78c < 19 && a2 >= ((long) f76a[this.f78c])) {
                            sb.append(c.mo224b());
                            break;
                        }
                    case ALWAYS:
                        sb.append(c.mo224b());
                        break;
                }
            } else {
                switch (this.f80e) {
                    case EXCEEDS_PAD:
                    case ALWAYS:
                    case NORMAL:
                        sb.append(c.mo225c());
                        break;
                    case NOT_NEGATIVE:
                        throw new C0023b("Field " + this.f77b + " cannot be printed as the value " + a2 + " cannot be negative according to the SignStyle");
                }
            }
            for (int i = 0; i < this.f78c - a3.length(); i++) {
                sb.append(c.mo221a());
            }
            sb.append(a3);
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo175a(C0055f fVar, long j) {
            return j;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo178a(C0051d dVar) {
            return this.f81f == -1 || (this.f81f > 0 && this.f78c == this.f79d && this.f80e == C0060j.NOT_NEGATIVE);
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            boolean z;
            int i2;
            boolean z2;
            BigInteger bigInteger;
            int i3;
            BigInteger bigInteger2;
            long j;
            int length = charSequence.length();
            if (i == length) {
                return i ^ -1;
            }
            char charAt = charSequence.charAt(i);
            if (charAt == dVar.mo201c().mo224b()) {
                if (!this.f80e.mo230a(true, dVar.mo205f(), this.f78c == this.f79d)) {
                    return i ^ -1;
                }
                z = true;
                z2 = false;
                i2 = i + 1;
            } else if (charAt == dVar.mo201c().mo225c()) {
                if (!this.f80e.mo230a(false, dVar.mo205f(), this.f78c == this.f79d)) {
                    return i ^ -1;
                }
                i2 = i + 1;
                z = false;
                z2 = true;
            } else if (this.f80e == C0060j.ALWAYS && dVar.mo205f()) {
                return i ^ -1;
            } else {
                z = false;
                i2 = i;
                z2 = false;
            }
            int i4 = (dVar.mo205f() || mo178a(dVar)) ? this.f78c : 1;
            int i5 = i2 + i4;
            if (i5 > length) {
                return i2 ^ -1;
            }
            int max = ((dVar.mo205f() || mo178a(dVar)) ? this.f79d : 9) + Math.max(this.f81f, 0);
            long j2 = 0;
            BigInteger bigInteger3 = null;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                bigInteger = bigInteger3;
                i3 = i2;
                if (i7 >= 2) {
                    break;
                }
                int min = Math.min(max + i3, length);
                while (true) {
                    if (i3 >= min) {
                        break;
                    }
                    int i8 = i3 + 1;
                    int a = dVar.mo201c().mo222a(charSequence.charAt(i3));
                    if (a < 0) {
                        i3 = i8 - 1;
                        if (i3 < i5) {
                            return i2 ^ -1;
                        }
                    } else {
                        if (i8 - i2 > 18) {
                            if (bigInteger == null) {
                                bigInteger = BigInteger.valueOf(j2);
                            }
                            bigInteger = bigInteger.multiply(BigInteger.TEN).add(BigInteger.valueOf((long) a));
                        } else {
                            j2 = (j2 * 10) + ((long) a);
                        }
                        i3 = i8;
                    }
                }
                if (this.f81f <= 0 || i7 != 0) {
                    break;
                }
                max = Math.max(i4, (i3 - i2) - this.f81f);
                j2 = 0;
                bigInteger3 = null;
                i6 = i7 + 1;
            }
            int i9 = i3;
            if (!z2) {
                if (this.f80e == C0060j.EXCEEDS_PAD && dVar.mo205f()) {
                    int i10 = i9 - i2;
                    if (z) {
                        if (i10 <= this.f78c) {
                            return (i2 - 1) ^ -1;
                        }
                    } else if (i10 > this.f78c) {
                        return i2 ^ -1;
                    }
                }
                bigInteger2 = bigInteger;
                j = j2;
            } else if (bigInteger != null) {
                if (bigInteger.equals(BigInteger.ZERO) && dVar.mo205f()) {
                    return (i2 - 1) ^ -1;
                }
                bigInteger2 = bigInteger.negate();
                j = j2;
            } else if (j2 == 0 && dVar.mo205f()) {
                return (i2 - 1) ^ -1;
            } else {
                BigInteger bigInteger4 = bigInteger;
                j = -j2;
                bigInteger2 = bigInteger4;
            }
            if (bigInteger2 == null) {
                return mo174a(dVar, j, i2, i9);
            }
            if (bigInteger2.bitLength() > 63) {
                bigInteger2 = bigInteger2.divide(BigInteger.TEN);
                i9--;
            }
            return mo174a(dVar, bigInteger2.longValue(), i2, i9);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo174a(C0051d dVar, long j, int i, int i2) {
            return dVar.mo191a(this.f77b, j, i, i2);
        }

        public String toString() {
            if (this.f78c == 1 && this.f79d == 19 && this.f80e == C0060j.NORMAL) {
                return "Value(" + this.f77b + ")";
            }
            if (this.f78c == this.f79d && this.f80e == C0060j.NOT_NEGATIVE) {
                return "Value(" + this.f77b + "," + this.f78c + ")";
            }
            return "Value(" + this.f77b + "," + this.f78c + "," + this.f79d + "," + this.f80e + ")";
        }
    }

    /* renamed from: a.b.a.b.c$j */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0042j extends C0039g {

        /* renamed from: g */
        static final C0115f f89g = C0115f.m606a(2000, 1, 1);

        /* renamed from: h */
        private final int f90h;

        /* renamed from: i */
        private final C0006a f91i;

        C0042j(C0088i iVar, int i, int i2, int i3, C0006a aVar) {
            super(iVar, i, i2, C0060j.NOT_NEGATIVE);
            if (i < 1 || i > 10) {
                throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + i);
            } else if (i2 < 1 || i2 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i2);
            } else if (i2 < i) {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            } else {
                if (aVar == null) {
                    if (!iVar.mo249a().mo274a((long) i3)) {
                        throw new IllegalArgumentException("The base value must be within the range of the field");
                    } else if (((long) i3) + ((long) f76a[i]) > 2147483647L) {
                        throw new C0023b("Unable to add printer-parser as the range exceeds the capacity of an int");
                    }
                }
                this.f90h = i3;
                this.f91i = aVar;
            }
        }

        private C0042j(C0088i iVar, int i, int i2, int i3, C0006a aVar, int i4) {
            super(iVar, i, i2, C0060j.NOT_NEGATIVE, i4);
            this.f90h = i3;
            this.f91i = aVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo175a(C0055f fVar, long j) {
            long abs = Math.abs(j);
            int i = this.f90h;
            if (this.f91i != null) {
                i = C0018g.m125a(fVar.mo213a()).mo98b((C0082e) this.f91i).mo67c(this.f77b);
            }
            if (j < ((long) i) || j >= ((long) (i + f76a[this.f78c]))) {
                return abs % ((long) f76a[this.f79d]);
            }
            return abs % ((long) f76a[this.f78c]);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo174a(C0051d dVar, long j, int i, int i2) {
            long j2;
            int i3 = this.f90h;
            if (this.f91i != null) {
                int c = dVar.mo203d().mo98b((C0082e) this.f91i).mo67c(this.f77b);
                dVar.mo194a(this, j, i, i2);
                i3 = c;
            }
            if (i2 - i == this.f78c && j >= 0) {
                long j3 = (long) f76a[this.f78c];
                long j4 = ((long) i3) - (((long) i3) % j3);
                if (i3 > 0) {
                    j += j4;
                } else {
                    j = j4 - j;
                }
                if (j < ((long) i3)) {
                    j2 = j + j3;
                    return dVar.mo191a(this.f77b, j2, i, i2);
                }
            }
            j2 = j;
            return dVar.mo191a(this.f77b, j2, i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0039g mo176a() {
            return this.f81f == -1 ? this : new C0042j(this.f77b, this.f78c, this.f79d, this.f90h, this.f91i, -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0042j mo177a(int i) {
            return new C0042j(this.f77b, this.f78c, this.f79d, this.f90h, this.f91i, this.f81f + i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo178a(C0051d dVar) {
            if (!dVar.mo205f()) {
                return false;
            }
            return super.mo178a(dVar);
        }

        public String toString() {
            return "ReducedValue(" + this.f77b + "," + this.f78c + "," + this.f79d + "," + (this.f91i != null ? this.f91i : Integer.valueOf(this.f90h)) + ")";
        }
    }

    /* renamed from: a.b.a.b.c$d */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0036d implements C0035c {

        /* renamed from: a */
        private final C0088i f70a;

        /* renamed from: b */
        private final int f71b;

        /* renamed from: c */
        private final int f72c;

        /* renamed from: d */
        private final boolean f73d;

        C0036d(C0088i iVar, int i, int i2, boolean z) {
            C0069c.m378a(iVar, "field");
            if (!iVar.mo249a().mo273a()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + iVar);
            } else if (i < 0 || i > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i);
            } else if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i2);
            } else if (i2 < i) {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
            } else {
                this.f70a = iVar;
                this.f71b = i;
                this.f72c = i2;
                this.f73d = z;
            }
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            Long a = fVar.mo214a(this.f70a);
            if (a == null) {
                return false;
            }
            C0058h c = fVar.mo217c();
            BigDecimal a2 = m247a(a.longValue());
            if (a2.scale() != 0) {
                String a3 = c.mo223a(a2.setScale(Math.min(Math.max(a2.scale(), this.f71b), this.f72c), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.f73d) {
                    sb.append(c.mo226d());
                }
                sb.append(a3);
            } else if (this.f71b > 0) {
                if (this.f73d) {
                    sb.append(c.mo226d());
                }
                for (int i = 0; i < this.f71b; i++) {
                    sb.append(c.mo221a());
                }
            }
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            int i2;
            int i3 = 0;
            int i4 = dVar.mo205f() ? this.f71b : 0;
            int i5 = dVar.mo205f() ? this.f72c : 9;
            int length = charSequence.length();
            if (i == length) {
                return i4 > 0 ? i ^ -1 : i;
            }
            if (!this.f73d) {
                i2 = i;
            } else if (charSequence.charAt(i) == dVar.mo201c().mo226d()) {
                i2 = i + 1;
            } else if (i4 > 0) {
                return i ^ -1;
            } else {
                return i;
            }
            int i6 = i2 + i4;
            if (i6 > length) {
                return i2 ^ -1;
            }
            int min = Math.min(i2 + i5, length);
            int i7 = i2;
            while (true) {
                if (i7 >= min) {
                    break;
                }
                int i8 = i7 + 1;
                int a = dVar.mo201c().mo222a(charSequence.charAt(i7));
                if (a >= 0) {
                    i3 = (i3 * 10) + a;
                    i7 = i8;
                } else if (i8 < i6) {
                    return i2 ^ -1;
                } else {
                    i7 = i8 - 1;
                }
            }
            return dVar.mo191a(this.f70a, m246a(new BigDecimal(i3).movePointLeft(i7 - i2)), i2, i7);
        }

        /* renamed from: a */
        private BigDecimal m247a(long j) {
            C0100n a = this.f70a.mo249a();
            a.mo272a(j, this.f70a);
            BigDecimal valueOf = BigDecimal.valueOf(a.mo276b());
            BigDecimal divide = BigDecimal.valueOf(j).subtract(valueOf).divide(BigDecimal.valueOf(a.mo278c()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            return divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
        }

        /* renamed from: a */
        private long m246a(BigDecimal bigDecimal) {
            C0100n a = this.f70a.mo249a();
            BigDecimal valueOf = BigDecimal.valueOf(a.mo276b());
            return bigDecimal.multiply(BigDecimal.valueOf(a.mo278c()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact();
        }

        public String toString() {
            return "Fraction(" + this.f70a + "," + this.f71b + "," + this.f72c + (this.f73d ? ",DecimalPoint" : "") + ")";
        }
    }

    /* renamed from: a.b.a.b.c$m */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0045m implements C0035c {

        /* renamed from: a */
        private final C0088i f98a;

        /* renamed from: b */
        private final C0064l f99b;

        /* renamed from: c */
        private final C0057g f100c;

        /* renamed from: d */
        private volatile C0039g f101d;

        C0045m(C0088i iVar, C0064l lVar, C0057g gVar) {
            this.f98a = iVar;
            this.f99b = lVar;
            this.f100c = gVar;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            Long a = fVar.mo214a(this.f98a);
            if (a == null) {
                return false;
            }
            String a2 = this.f100c.mo163a(this.f98a, a.longValue(), this.f99b, fVar.mo216b());
            if (a2 == null) {
                return m277a().mo168a(fVar, sb);
            }
            sb.append(a2);
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            int length = charSequence.length();
            if (i < 0 || i > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator<Map.Entry<String, Long>> a = this.f100c.mo164a(this.f98a, dVar.mo205f() ? this.f99b : null, dVar.mo199b());
            if (a != null) {
                while (a.hasNext()) {
                    Map.Entry next = a.next();
                    String str = (String) next.getKey();
                    if (dVar.mo198a(str, 0, charSequence, i, str.length())) {
                        return dVar.mo191a(this.f98a, ((Long) next.getValue()).longValue(), i, i + str.length());
                    }
                }
                if (dVar.mo205f()) {
                    return i ^ -1;
                }
            }
            return m277a().mo167a(dVar, charSequence, i);
        }

        /* renamed from: a */
        private C0039g m277a() {
            if (this.f101d == null) {
                this.f101d = new C0039g(this.f98a, 1, 19, C0060j.NORMAL);
            }
            return this.f101d;
        }

        public String toString() {
            if (this.f99b == C0064l.FULL) {
                return "Text(" + this.f98a + ")";
            }
            return "Text(" + this.f98a + "," + this.f99b + ")";
        }
    }

    /* renamed from: a.b.a.b.c$e */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0037e implements C0035c {

        /* renamed from: a */
        private final int f74a;

        C0037e(int i) {
            this.f74a = i;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            Long a = fVar.mo214a((C0088i) C0071a.INSTANT_SECONDS);
            Long l = 0L;
            if (fVar.mo213a().mo18a((C0088i) C0071a.NANO_OF_SECOND)) {
                l = Long.valueOf(fVar.mo213a().mo68d(C0071a.NANO_OF_SECOND));
            }
            if (a == null) {
                return false;
            }
            long longValue = a.longValue();
            int b = C0071a.NANO_OF_SECOND.mo251b(l.longValue());
            if (longValue >= -62167219200L) {
                long j = (longValue - 315569520000L) + 62167219200L;
                long e = C0069c.m386e(j, 315569520000L) + 1;
                C0118g a2 = C0118g.m665a(C0069c.m387f(j, 315569520000L) - 62167219200L, 0, C0136n.f379d);
                if (e > 0) {
                    sb.append('+').append(e);
                }
                sb.append(a2);
                if (a2.mo373b() == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = 62167219200L + longValue;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                C0118g a3 = C0118g.m665a(j4 - 62167219200L, 0, C0136n.f379d);
                int length = sb.length();
                sb.append(a3);
                if (a3.mo373b() == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (a3.mo366a() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb.insert(length, j3);
                    } else {
                        sb.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            if (this.f74a == -2) {
                if (b != 0) {
                    sb.append('.');
                    if (b % 1000000 == 0) {
                        sb.append(Integer.toString((b / 1000000) + 1000).substring(1));
                    } else if (b % 1000 == 0) {
                        sb.append(Integer.toString((b / 1000) + 1000000).substring(1));
                    } else {
                        sb.append(Integer.toString(1000000000 + b).substring(1));
                    }
                }
            } else if (this.f74a > 0 || (this.f74a == -1 && b > 0)) {
                sb.append('.');
                int i = 100000000;
                int i2 = 0;
                while (true) {
                    if ((this.f74a != -1 || b <= 0) && i2 >= this.f74a) {
                        break;
                    }
                    int i3 = b / i;
                    sb.append((char) (i3 + 48));
                    b -= i3 * i;
                    i /= 10;
                    i2++;
                }
            }
            sb.append('Z');
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            int i2;
            int i3;
            C0051d a = dVar.mo192a();
            int a2 = new C0028c().mo140a(C0025b.f30a).mo137a('T').mo143a((C0088i) C0071a.HOUR_OF_DAY, 2).mo137a(':').mo143a((C0088i) C0071a.MINUTE_OF_HOUR, 2).mo137a(':').mo143a((C0088i) C0071a.SECOND_OF_MINUTE, 2).mo146a((C0088i) C0071a.NANO_OF_SECOND, this.f74a < 0 ? 0 : this.f74a, this.f74a < 0 ? 9 : this.f74a, true).mo137a('Z').mo161j().mo123a(false).mo167a(a, charSequence, i);
            if (a2 < 0) {
                return a2;
            }
            long longValue = a.mo193a((C0088i) C0071a.YEAR).longValue();
            int intValue = a.mo193a((C0088i) C0071a.MONTH_OF_YEAR).intValue();
            int intValue2 = a.mo193a((C0088i) C0071a.DAY_OF_MONTH).intValue();
            int intValue3 = a.mo193a((C0088i) C0071a.HOUR_OF_DAY).intValue();
            int intValue4 = a.mo193a((C0088i) C0071a.MINUTE_OF_HOUR).intValue();
            Long a3 = a.mo193a((C0088i) C0071a.SECOND_OF_MINUTE);
            Long a4 = a.mo193a((C0088i) C0071a.NANO_OF_SECOND);
            int intValue5 = a3 != null ? a3.intValue() : 0;
            int intValue6 = a4 != null ? a4.intValue() : 0;
            int i4 = ((int) longValue) % 10000;
            if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                i2 = 1;
                i3 = 0;
            } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                dVar.mo207h();
                intValue5 = 59;
                i2 = 0;
                i3 = intValue3;
            } else {
                i2 = 0;
                i3 = intValue3;
            }
            try {
                return dVar.mo191a((C0088i) C0071a.NANO_OF_SECOND, (long) intValue6, i, dVar.mo191a((C0088i) C0071a.INSTANT_SECONDS, C0069c.m385d(longValue / 10000, 315569520000L) + C0118g.m664a(i4, intValue, intValue2, i3, intValue4, intValue5, 0).mo367a((long) i2).mo44b(C0136n.f379d), i, a2));
            } catch (RuntimeException e) {
                return i ^ -1;
            }
        }

        public String toString() {
            return "Instant()";
        }
    }

    /* renamed from: a.b.a.b.c$h */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0040h implements C0035c {

        /* renamed from: a */
        static final String[] f82a = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

        /* renamed from: b */
        static final C0040h f83b = new C0040h("Z", "+HH:MM:ss");

        /* renamed from: c */
        private final String f84c;

        /* renamed from: d */
        private final int f85d;

        C0040h(String str, String str2) {
            C0069c.m378a(str, "noOffsetText");
            C0069c.m378a(str2, "pattern");
            this.f84c = str;
            this.f85d = m261a(str2);
        }

        /* renamed from: a */
        private int m261a(String str) {
            for (int i = 0; i < f82a.length; i++) {
                if (f82a[i].equals(str)) {
                    return i;
                }
            }
            throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo168a(p000a.p007b.p008a.p010b.C0055f r8, java.lang.StringBuilder r9) {
            /*
                r7 = this;
                r1 = 1
                a.b.a.d.a r0 = p000a.p007b.p008a.p012d.C0071a.OFFSET_SECONDS
                java.lang.Long r0 = r8.mo214a((p000a.p007b.p008a.p012d.C0088i) r0)
                if (r0 != 0) goto L_0x000b
                r0 = 0
            L_0x000a:
                return r0
            L_0x000b:
                long r2 = r0.longValue()
                int r0 = p000a.p007b.p008a.p011c.C0069c.m375a(r2)
                if (r0 != 0) goto L_0x001c
                java.lang.String r0 = r7.f84c
                r9.append(r0)
            L_0x001a:
                r0 = r1
                goto L_0x000a
            L_0x001c:
                int r2 = r0 / 3600
                int r2 = r2 % 100
                int r2 = java.lang.Math.abs(r2)
                int r3 = r0 / 60
                int r3 = r3 % 60
                int r3 = java.lang.Math.abs(r3)
                int r4 = r0 % 60
                int r4 = java.lang.Math.abs(r4)
                int r5 = r9.length()
                if (r0 >= 0) goto L_0x00af
                java.lang.String r0 = "-"
            L_0x003a:
                java.lang.StringBuilder r0 = r9.append(r0)
                int r6 = r2 / 10
                int r6 = r6 + 48
                char r6 = (char) r6
                java.lang.StringBuilder r0 = r0.append(r6)
                int r6 = r2 % 10
                int r6 = r6 + 48
                char r6 = (char) r6
                r0.append(r6)
                int r0 = r7.f85d
                r6 = 3
                if (r0 >= r6) goto L_0x005a
                int r0 = r7.f85d
                if (r0 < r1) goto L_0x00b8
                if (r3 <= 0) goto L_0x00b8
            L_0x005a:
                int r0 = r7.f85d
                int r0 = r0 % 2
                if (r0 != 0) goto L_0x00b2
                java.lang.String r0 = ":"
            L_0x0062:
                java.lang.StringBuilder r0 = r9.append(r0)
                int r6 = r3 / 10
                int r6 = r6 + 48
                char r6 = (char) r6
                java.lang.StringBuilder r0 = r0.append(r6)
                int r6 = r3 % 10
                int r6 = r6 + 48
                char r6 = (char) r6
                r0.append(r6)
                int r2 = r2 + r3
                int r0 = r7.f85d
                r3 = 7
                if (r0 >= r3) goto L_0x0084
                int r0 = r7.f85d
                r3 = 5
                if (r0 < r3) goto L_0x00b8
                if (r4 <= 0) goto L_0x00b8
            L_0x0084:
                int r0 = r7.f85d
                int r0 = r0 % 2
                if (r0 != 0) goto L_0x00b5
                java.lang.String r0 = ":"
            L_0x008c:
                java.lang.StringBuilder r0 = r9.append(r0)
                int r3 = r4 / 10
                int r3 = r3 + 48
                char r3 = (char) r3
                java.lang.StringBuilder r0 = r0.append(r3)
                int r3 = r4 % 10
                int r3 = r3 + 48
                char r3 = (char) r3
                r0.append(r3)
                int r0 = r2 + r4
            L_0x00a3:
                if (r0 != 0) goto L_0x001a
                r9.setLength(r5)
                java.lang.String r0 = r7.f84c
                r9.append(r0)
                goto L_0x001a
            L_0x00af:
                java.lang.String r0 = "+"
                goto L_0x003a
            L_0x00b2:
                java.lang.String r0 = ""
                goto L_0x0062
            L_0x00b5:
                java.lang.String r0 = ""
                goto L_0x008c
            L_0x00b8:
                r0 = r2
                goto L_0x00a3
            */
            throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p010b.C0028c.C0040h.mo168a(a.b.a.b.f, java.lang.StringBuilder):boolean");
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo167a(p000a.p007b.p008a.p010b.C0051d r11, java.lang.CharSequence r12, int r13) {
            /*
                r10 = this;
                int r0 = r12.length()
                java.lang.String r1 = r10.f84c
                int r5 = r1.length()
                if (r5 != 0) goto L_0x001a
                if (r13 != r0) goto L_0x0037
                a.b.a.d.a r1 = p000a.p007b.p008a.p012d.C0071a.OFFSET_SECONDS
                r2 = 0
                r0 = r11
                r4 = r13
                r5 = r13
                int r0 = r0.mo191a((p000a.p007b.p008a.p012d.C0088i) r1, (long) r2, (int) r4, (int) r5)
            L_0x0019:
                return r0
            L_0x001a:
                if (r13 != r0) goto L_0x001f
                r0 = r13 ^ -1
                goto L_0x0019
            L_0x001f:
                java.lang.String r3 = r10.f84c
                r4 = 0
                r0 = r11
                r1 = r12
                r2 = r13
                boolean r0 = r0.mo198a(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L_0x0037
                a.b.a.d.a r1 = p000a.p007b.p008a.p012d.C0071a.OFFSET_SECONDS
                r2 = 0
                int r5 = r5 + r13
                r0 = r11
                r4 = r13
                int r0 = r0.mo191a((p000a.p007b.p008a.p012d.C0088i) r1, (long) r2, (int) r4, (int) r5)
                goto L_0x0019
            L_0x0037:
                char r0 = r12.charAt(r13)
                r1 = 43
                if (r0 == r1) goto L_0x0043
                r1 = 45
                if (r0 != r1) goto L_0x0098
            L_0x0043:
                r1 = 45
                if (r0 != r1) goto L_0x0092
                r0 = -1
            L_0x0048:
                r1 = 4
                int[] r4 = new int[r1]
                r1 = 0
                int r2 = r13 + 1
                r4[r1] = r2
                r1 = 1
                r2 = 1
                boolean r1 = r10.m262a(r4, r1, r12, r2)
                if (r1 != 0) goto L_0x006d
                r2 = 2
                int r1 = r10.f85d
                r3 = 3
                if (r1 < r3) goto L_0x0094
                r1 = 1
            L_0x005f:
                boolean r1 = r10.m262a(r4, r2, r12, r1)
                if (r1 != 0) goto L_0x006d
                r1 = 3
                r2 = 0
                boolean r1 = r10.m262a(r4, r1, r12, r2)
                if (r1 == 0) goto L_0x0096
            L_0x006d:
                r1 = 1
            L_0x006e:
                if (r1 != 0) goto L_0x0098
                long r0 = (long) r0
                r2 = 1
                r2 = r4[r2]
                long r2 = (long) r2
                r6 = 3600(0xe10, double:1.7786E-320)
                long r2 = r2 * r6
                r5 = 2
                r5 = r4[r5]
                long r6 = (long) r5
                r8 = 60
                long r6 = r6 * r8
                long r2 = r2 + r6
                r5 = 3
                r5 = r4[r5]
                long r6 = (long) r5
                long r2 = r2 + r6
                long r2 = r2 * r0
                a.b.a.d.a r1 = p000a.p007b.p008a.p012d.C0071a.OFFSET_SECONDS
                r0 = 0
                r5 = r4[r0]
                r0 = r11
                r4 = r13
                int r0 = r0.mo191a((p000a.p007b.p008a.p012d.C0088i) r1, (long) r2, (int) r4, (int) r5)
                goto L_0x0019
            L_0x0092:
                r0 = 1
                goto L_0x0048
            L_0x0094:
                r1 = 0
                goto L_0x005f
            L_0x0096:
                r1 = 0
                goto L_0x006e
            L_0x0098:
                if (r5 != 0) goto L_0x00a7
                a.b.a.d.a r1 = p000a.p007b.p008a.p012d.C0071a.OFFSET_SECONDS
                r2 = 0
                int r5 = r5 + r13
                r0 = r11
                r4 = r13
                int r0 = r0.mo191a((p000a.p007b.p008a.p012d.C0088i) r1, (long) r2, (int) r4, (int) r5)
                goto L_0x0019
            L_0x00a7:
                r0 = r13 ^ -1
                goto L_0x0019
            */
            throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p010b.C0028c.C0040h.mo167a(a.b.a.b.d, java.lang.CharSequence, int):int");
        }

        /* renamed from: a */
        private boolean m262a(int[] iArr, int i, CharSequence charSequence, boolean z) {
            int i2;
            if ((this.f85d + 3) / 2 < i) {
                return false;
            }
            int i3 = iArr[0];
            if (this.f85d % 2 == 0 && i > 1) {
                if (i3 + 1 > charSequence.length() || charSequence.charAt(i3) != ':') {
                    return z;
                }
                i3++;
            }
            if (i3 + 2 > charSequence.length()) {
                return z;
            }
            int i4 = i3 + 1;
            char charAt = charSequence.charAt(i3);
            int i5 = i4 + 1;
            char charAt2 = charSequence.charAt(i4);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i2 = ((charAt - '0') * 10) + (charAt2 - '0')) < 0 || i2 > 59) {
                return z;
            }
            iArr[i] = i2;
            iArr[0] = i5;
            return false;
        }

        public String toString() {
            return "Offset(" + f82a[this.f85d] + ",'" + this.f84c.replace("'", "''") + "')";
        }
    }

    /* renamed from: a.b.a.b.c$f */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0038f implements C0035c {

        /* renamed from: a */
        private final C0064l f75a;

        public C0038f(C0064l lVar) {
            this.f75a = lVar;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            Long a = fVar.mo214a((C0088i) C0071a.OFFSET_SECONDS);
            if (a == null) {
                return false;
            }
            sb.append("GMT");
            if (this.f75a == C0064l.FULL) {
                return new C0040h("", "+HH:MM:ss").mo168a(fVar, sb);
            }
            int a2 = C0069c.m375a(a.longValue());
            if (a2 != 0) {
                int abs = Math.abs((a2 / 3600) % 100);
                int abs2 = Math.abs((a2 / 60) % 60);
                int abs3 = Math.abs(a2 % 60);
                sb.append(a2 < 0 ? "-" : "+").append(abs);
                if (abs2 > 0 || abs3 > 0) {
                    sb.append(":").append((char) ((abs2 / 10) + 48)).append((char) ((abs2 % 10) + 48));
                    if (abs3 > 0) {
                        sb.append(":").append((char) ((abs3 / 10) + 48)).append((char) ((abs3 % 10) + 48));
                    }
                }
            }
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            char charAt;
            if (!dVar.mo198a(charSequence, i, "GMT", 0, 3)) {
                return i ^ -1;
            }
            int i2 = i + 3;
            if (this.f75a == C0064l.FULL) {
                return new C0040h("", "+HH:MM:ss").mo167a(dVar, charSequence, i2);
            }
            int length = charSequence.length();
            if (i2 == length) {
                return dVar.mo191a((C0088i) C0071a.OFFSET_SECONDS, 0, i2, i2);
            }
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 == '+' || charAt2 == '-') {
                int i3 = charAt2 == '-' ? -1 : 1;
                if (i2 == length) {
                    return i2 ^ -1;
                }
                int i4 = i2 + 1;
                char charAt3 = charSequence.charAt(i4);
                if (charAt3 < '0' || charAt3 > '9') {
                    return i4 ^ -1;
                }
                int i5 = i4 + 1;
                int i6 = charAt3 - '0';
                if (i5 != length && (charAt = charSequence.charAt(i5)) >= '0' && charAt <= '9') {
                    i6 = (i6 * 10) + (charAt - '0');
                    if (i6 > 23) {
                        return i5 ^ -1;
                    }
                    i5++;
                }
                if (i5 == length || charSequence.charAt(i5) != ':') {
                    return dVar.mo191a((C0088i) C0071a.OFFSET_SECONDS, (long) (i6 * i3 * 3600), i5, i5);
                }
                int i7 = i5 + 1;
                if (i7 > length - 2) {
                    return i7 ^ -1;
                }
                char charAt4 = charSequence.charAt(i7);
                if (charAt4 < '0' || charAt4 > '9') {
                    return i7 ^ -1;
                }
                int i8 = i7 + 1;
                int i9 = charAt4 - '0';
                char charAt5 = charSequence.charAt(i8);
                if (charAt5 < '0' || charAt5 > '9') {
                    return i8 ^ -1;
                }
                int i10 = i8 + 1;
                int i11 = (i9 * 10) + (charAt5 - '0');
                if (i11 > 59) {
                    return i10 ^ -1;
                }
                if (i10 == length || charSequence.charAt(i10) != ':') {
                    return dVar.mo191a((C0088i) C0071a.OFFSET_SECONDS, (long) (((i6 * 3600) + (i11 * 60)) * i3), i10, i10);
                }
                int i12 = i10 + 1;
                if (i12 > length - 2) {
                    return i12 ^ -1;
                }
                char charAt6 = charSequence.charAt(i12);
                if (charAt6 < '0' || charAt6 > '9') {
                    return i12 ^ -1;
                }
                int i13 = i12 + 1;
                int i14 = charAt6 - '0';
                char charAt7 = charSequence.charAt(i13);
                if (charAt7 < '0' || charAt7 > '9') {
                    return i13 ^ -1;
                }
                int i15 = i13 + 1;
                int i16 = (i14 * 10) + (charAt7 - '0');
                if (i16 > 59) {
                    return i15 ^ -1;
                }
                return dVar.mo191a((C0088i) C0071a.OFFSET_SECONDS, (long) (((i6 * 3600) + (i11 * 60) + i16) * i3), i15, i15);
            }
            return dVar.mo191a((C0088i) C0071a.OFFSET_SECONDS, 0, i2, i2);
        }
    }

    /* renamed from: a.b.a.b.c$p */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0049p implements C0035c {

        /* renamed from: a */
        private static final Comparator<String> f110a = new Comparator<String>() {
            /* renamed from: a */
            public int compare(String str, String str2) {
                int length = str2.length() - str.length();
                if (length == 0) {
                    return str.compareTo(str2);
                }
                return length;
            }
        };

        /* renamed from: b */
        private final C0064l f111b;

        C0049p(C0064l lVar) {
            this.f111b = (C0064l) C0069c.m378a(lVar, "textStyle");
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            C0103e a;
            int i;
            C0134m mVar = (C0134m) fVar.mo215a(C0089j.m467a());
            if (mVar == null) {
                return false;
            }
            if (mVar.mo445e() instanceof C0136n) {
                sb.append(mVar.mo443c());
                return true;
            }
            Long valueOf = Long.valueOf(fVar.mo213a().mo68d(C0071a.INSTANT_SECONDS));
            if (valueOf != null) {
                a = C0103e.m532a(valueOf.longValue());
            } else {
                a = C0103e.m532a(-6307200000L);
            }
            TimeZone timeZone = TimeZone.getTimeZone(mVar.mo443c());
            boolean c = mVar.mo444d().mo315c(a);
            if (this.f111b.mo235a() == C0064l.FULL) {
                i = 1;
            } else {
                i = 0;
            }
            sb.append(timeZone.getDisplayName(c, i, fVar.mo216b()));
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            int i2;
            TreeMap treeMap = new TreeMap(f110a);
            for (String next : C0134m.m825b()) {
                treeMap.put(next, next);
                TimeZone timeZone = TimeZone.getTimeZone(next);
                if (this.f111b.mo235a() == C0064l.FULL) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                treeMap.put(timeZone.getDisplayName(false, i2, dVar.mo199b()), next);
                treeMap.put(timeZone.getDisplayName(true, i2, dVar.mo199b()), next);
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str = (String) entry.getKey();
                if (dVar.mo198a(charSequence, i, str, 0, str.length())) {
                    dVar.mo195a(C0134m.m822a((String) entry.getValue()));
                    return str.length() + i;
                }
            }
            return i ^ -1;
        }

        public String toString() {
            return "ZoneText(" + this.f111b + ")";
        }
    }

    /* renamed from: a.b.a.b.c$o */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0047o implements C0035c {

        /* renamed from: c */
        private static volatile Map.Entry<Integer, C0048a> f104c;

        /* renamed from: a */
        private final C0097k<C0134m> f105a;

        /* renamed from: b */
        private final String f106b;

        C0047o(C0097k<C0134m> kVar, String str) {
            this.f105a = kVar;
            this.f106b = str;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            C0134m mVar = (C0134m) fVar.mo215a(this.f105a);
            if (mVar == null) {
                return false;
            }
            sb.append(mVar.mo443c());
            return true;
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            Map.Entry<Integer, C0048a> entry;
            String str = null;
            int length = charSequence.length();
            if (i > length) {
                throw new IndexOutOfBoundsException();
            } else if (i == length) {
                return i ^ -1;
            } else {
                char charAt = charSequence.charAt(i);
                if (charAt == '+' || charAt == '-') {
                    C0051d a = dVar.mo192a();
                    int a2 = C0040h.f83b.mo167a(a, charSequence, i);
                    if (a2 < 0) {
                        return a2;
                    }
                    dVar.mo195a((C0134m) C0136n.m832a((int) a.mo193a((C0088i) C0071a.OFFSET_SECONDS).longValue()));
                    return a2;
                }
                if (length >= i + 2) {
                    char charAt2 = charSequence.charAt(i + 1);
                    if (!dVar.mo197a(charAt, 'U') || !dVar.mo197a(charAt2, 'T')) {
                        if (dVar.mo197a(charAt, 'G') && length >= i + 3 && dVar.mo197a(charAt2, 'M') && dVar.mo197a(charSequence.charAt(i + 2), 'T')) {
                            return m283a(dVar, charSequence, i, i + 3);
                        }
                    } else if (length < i + 3 || !dVar.mo197a(charSequence.charAt(i + 2), 'C')) {
                        return m283a(dVar, charSequence, i, i + 2);
                    } else {
                        return m283a(dVar, charSequence, i, i + 3);
                    }
                }
                Set<String> a3 = C0114f.m600a();
                int size = a3.size();
                Map.Entry<Integer, C0048a> entry2 = f104c;
                if (entry2 == null || entry2.getKey().intValue() != size) {
                    synchronized (this) {
                        Map.Entry<Integer, C0048a> entry3 = f104c;
                        if (entry3 == null || entry3.getKey().intValue() != size) {
                            entry = new AbstractMap.SimpleImmutableEntry<>(Integer.valueOf(size), m284a(a3));
                            f104c = entry;
                        } else {
                            entry = entry3;
                        }
                    }
                } else {
                    entry = entry2;
                }
                String str2 = null;
                C0048a value = entry.getValue();
                while (value != null) {
                    int i2 = value.f107a;
                    if (i + i2 > length) {
                        break;
                    }
                    String obj = charSequence.subSequence(i, i2 + i).toString();
                    value = value.m289a((CharSequence) obj, dVar.mo204e());
                    str2 = str;
                    str = obj;
                }
                C0134m a4 = m285a(a3, str, dVar.mo204e());
                if (a4 == null) {
                    a4 = m285a(a3, str2, dVar.mo204e());
                    if (a4 == null) {
                        if (!dVar.mo197a(charAt, 'Z')) {
                            return i ^ -1;
                        }
                        dVar.mo195a((C0134m) C0136n.f379d);
                        return i + 1;
                    }
                } else {
                    str2 = str;
                }
                dVar.mo195a(a4);
                return str2.length() + i;
            }
        }

        /* renamed from: a */
        private C0134m m285a(Set<String> set, String str, boolean z) {
            if (str == null) {
                return null;
            }
            if (z) {
                return set.contains(str) ? C0134m.m822a(str) : null;
            }
            for (String next : set) {
                if (next.equalsIgnoreCase(str)) {
                    return C0134m.m822a(next);
                }
            }
            return null;
        }

        /* renamed from: a */
        private int m283a(C0051d dVar, CharSequence charSequence, int i, int i2) {
            String upperCase = charSequence.subSequence(i, i2).toString().toUpperCase();
            C0051d a = dVar.mo192a();
            if (i2 >= charSequence.length() || !dVar.mo197a(charSequence.charAt(i2), 'Z')) {
                int a2 = C0040h.f83b.mo167a(a, charSequence, i2);
                if (a2 < 0) {
                    dVar.mo195a(C0134m.m823a(upperCase, C0136n.f379d));
                    return i2;
                }
                dVar.mo195a(C0134m.m823a(upperCase, C0136n.m832a((int) a.mo193a((C0088i) C0071a.OFFSET_SECONDS).longValue())));
                return a2;
            }
            dVar.mo195a(C0134m.m823a(upperCase, C0136n.f379d));
            return i2;
        }

        /* renamed from: a.b.a.b.c$o$a */
        /* compiled from: DateTimeFormatterBuilder */
        private static final class C0048a {

            /* renamed from: a */
            final int f107a;

            /* renamed from: b */
            private final Map<CharSequence, C0048a> f108b;

            /* renamed from: c */
            private final Map<String, C0048a> f109c;

            private C0048a(int i) {
                this.f108b = new HashMap();
                this.f109c = new HashMap();
                this.f107a = i;
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public C0048a m289a(CharSequence charSequence, boolean z) {
                if (z) {
                    return this.f108b.get(charSequence);
                }
                return this.f109c.get(charSequence.toString().toLowerCase(Locale.ENGLISH));
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public void m291a(String str) {
                int length = str.length();
                if (length == this.f107a) {
                    this.f108b.put(str, (Object) null);
                    this.f109c.put(str.toLowerCase(Locale.ENGLISH), (Object) null);
                } else if (length > this.f107a) {
                    String substring = str.substring(0, this.f107a);
                    C0048a aVar = this.f108b.get(substring);
                    if (aVar == null) {
                        aVar = new C0048a(length);
                        this.f108b.put(substring, aVar);
                        this.f109c.put(substring.toLowerCase(Locale.ENGLISH), aVar);
                    }
                    aVar.m291a(str);
                }
            }
        }

        /* renamed from: a */
        private static C0048a m284a(Set<String> set) {
            ArrayList<String> arrayList = new ArrayList<>(set);
            Collections.sort(arrayList, C0028c.f54a);
            C0048a aVar = new C0048a(((String) arrayList.get(0)).length());
            for (String a : arrayList) {
                aVar.m291a(a);
            }
            return aVar;
        }

        public String toString() {
            return this.f106b;
        }
    }

    /* renamed from: a.b.a.b.c$n */
    /* compiled from: DateTimeFormatterBuilder */
    static final class C0046n implements C0035c {

        /* renamed from: a */
        private final char f102a;

        /* renamed from: b */
        private final int f103b;

        public C0046n(char c, int i) {
            this.f102a = c;
            this.f103b = i;
        }

        /* renamed from: a */
        public boolean mo168a(C0055f fVar, StringBuilder sb) {
            return m280a(C0101o.m504a(fVar.mo216b())).mo168a(fVar, sb);
        }

        /* renamed from: a */
        public int mo167a(C0051d dVar, CharSequence charSequence, int i) {
            return m280a(C0101o.m504a(dVar.mo199b())).mo167a(dVar, charSequence, i);
        }

        /* renamed from: a */
        private C0035c m280a(C0101o oVar) {
            switch (this.f102a) {
                case 'W':
                    return new C0039g(oVar.mo286d(), 1, 2, C0060j.NOT_NEGATIVE);
                case 'Y':
                    if (this.f103b == 2) {
                        return new C0042j(oVar.mo289f(), 2, 2, 0, C0042j.f89g);
                    }
                    return new C0039g(oVar.mo289f(), this.f103b, 19, this.f103b < 4 ? C0060j.NORMAL : C0060j.EXCEEDS_PAD, -1);
                case 'c':
                    return new C0039g(oVar.mo285c(), this.f103b, 2, C0060j.NOT_NEGATIVE);
                case 'e':
                    return new C0039g(oVar.mo285c(), this.f103b, 2, C0060j.NOT_NEGATIVE);
                case 'w':
                    return new C0039g(oVar.mo287e(), this.f103b, 2, C0060j.NOT_NEGATIVE);
                default:
                    return null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            if (this.f102a != 'Y') {
                if (this.f102a == 'c' || this.f102a == 'e') {
                    sb.append("DayOfWeek");
                } else if (this.f102a == 'w') {
                    sb.append("WeekOfWeekBasedYear");
                } else if (this.f102a == 'W') {
                    sb.append("WeekOfMonth");
                }
                sb.append(",");
                sb.append(this.f103b);
            } else if (this.f103b == 1) {
                sb.append("WeekBasedYear");
            } else if (this.f103b == 2) {
                sb.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
            } else {
                sb.append("WeekBasedYear,").append(this.f103b).append(",").append(19).append(",").append(this.f103b < 4 ? C0060j.NORMAL : C0060j.EXCEEDS_PAD);
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
