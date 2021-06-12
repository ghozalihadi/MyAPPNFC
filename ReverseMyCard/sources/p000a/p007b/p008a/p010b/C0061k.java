package p000a.p007b.p008a.p010b;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0073c;
import p000a.p007b.p008a.p012d.C0088i;

/* renamed from: a.b.a.b.k */
/* compiled from: SimpleDateTimeTextProvider */
final class C0061k extends C0057g {

    /* renamed from: a */
    private static final ConcurrentMap<Map.Entry<C0088i, Locale>, Object> f152a = new ConcurrentHashMap(16, 0.75f, 2);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Comparator<Map.Entry<String, Long>> f153b = new Comparator<Map.Entry<String, Long>>() {
        /* renamed from: a */
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return entry2.getKey().length() - entry.getKey().length();
        }
    };

    C0061k() {
    }

    /* renamed from: a */
    public String mo163a(C0088i iVar, long j, C0064l lVar, Locale locale) {
        Object a = m345a(iVar, locale);
        if (a instanceof C0063a) {
            return ((C0063a) a).mo233a(j, lVar);
        }
        return null;
    }

    /* renamed from: a */
    public Iterator<Map.Entry<String, Long>> mo164a(C0088i iVar, C0064l lVar, Locale locale) {
        Object a = m345a(iVar, locale);
        if (a instanceof C0063a) {
            return ((C0063a) a).mo234a(lVar);
        }
        return null;
    }

    /* renamed from: a */
    private Object m345a(C0088i iVar, Locale locale) {
        Map.Entry b = m349b(iVar, locale);
        Object obj = f152a.get(b);
        if (obj != null) {
            return obj;
        }
        f152a.putIfAbsent(b, m347b(iVar, locale));
        return f152a.get(b);
    }

    /* renamed from: b */
    private Object m347b(C0088i iVar, Locale locale) {
        if (iVar == C0071a.MONTH_OF_YEAR) {
            DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            HashMap hashMap = new HashMap();
            String[] months = instance.getMonths();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(1L, months[0]);
            hashMap2.put(2L, months[1]);
            hashMap2.put(3L, months[2]);
            hashMap2.put(4L, months[3]);
            hashMap2.put(5L, months[4]);
            hashMap2.put(6L, months[5]);
            hashMap2.put(7L, months[6]);
            hashMap2.put(8L, months[7]);
            hashMap2.put(9L, months[8]);
            hashMap2.put(10L, months[9]);
            hashMap2.put(11, months[10]);
            hashMap2.put(12, months[11]);
            hashMap.put(C0064l.FULL, hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(1L, months[0].substring(0, 1));
            hashMap3.put(2L, months[1].substring(0, 1));
            hashMap3.put(3L, months[2].substring(0, 1));
            hashMap3.put(4L, months[3].substring(0, 1));
            hashMap3.put(5L, months[4].substring(0, 1));
            hashMap3.put(6L, months[5].substring(0, 1));
            hashMap3.put(7L, months[6].substring(0, 1));
            hashMap3.put(8L, months[7].substring(0, 1));
            hashMap3.put(9L, months[8].substring(0, 1));
            hashMap3.put(10L, months[9].substring(0, 1));
            hashMap3.put(11, months[10].substring(0, 1));
            hashMap3.put(12, months[11].substring(0, 1));
            hashMap.put(C0064l.NARROW, hashMap3);
            String[] shortMonths = instance.getShortMonths();
            HashMap hashMap4 = new HashMap();
            hashMap4.put(1L, shortMonths[0]);
            hashMap4.put(2L, shortMonths[1]);
            hashMap4.put(3L, shortMonths[2]);
            hashMap4.put(4L, shortMonths[3]);
            hashMap4.put(5L, shortMonths[4]);
            hashMap4.put(6L, shortMonths[5]);
            hashMap4.put(7L, shortMonths[6]);
            hashMap4.put(8L, shortMonths[7]);
            hashMap4.put(9L, shortMonths[8]);
            hashMap4.put(10L, shortMonths[9]);
            hashMap4.put(11, shortMonths[10]);
            hashMap4.put(12, shortMonths[11]);
            hashMap.put(C0064l.SHORT, hashMap4);
            return m344a(hashMap);
        } else if (iVar == C0071a.DAY_OF_WEEK) {
            DateFormatSymbols instance2 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap5 = new HashMap();
            String[] weekdays = instance2.getWeekdays();
            HashMap hashMap6 = new HashMap();
            hashMap6.put(1L, weekdays[2]);
            hashMap6.put(2L, weekdays[3]);
            hashMap6.put(3L, weekdays[4]);
            hashMap6.put(4L, weekdays[5]);
            hashMap6.put(5L, weekdays[6]);
            hashMap6.put(6L, weekdays[7]);
            hashMap6.put(7L, weekdays[1]);
            hashMap5.put(C0064l.FULL, hashMap6);
            HashMap hashMap7 = new HashMap();
            hashMap7.put(1L, weekdays[2].substring(0, 1));
            hashMap7.put(2L, weekdays[3].substring(0, 1));
            hashMap7.put(3L, weekdays[4].substring(0, 1));
            hashMap7.put(4L, weekdays[5].substring(0, 1));
            hashMap7.put(5L, weekdays[6].substring(0, 1));
            hashMap7.put(6L, weekdays[7].substring(0, 1));
            hashMap7.put(7L, weekdays[1].substring(0, 1));
            hashMap5.put(C0064l.NARROW, hashMap7);
            String[] shortWeekdays = instance2.getShortWeekdays();
            HashMap hashMap8 = new HashMap();
            hashMap8.put(1L, shortWeekdays[2]);
            hashMap8.put(2L, shortWeekdays[3]);
            hashMap8.put(3L, shortWeekdays[4]);
            hashMap8.put(4L, shortWeekdays[5]);
            hashMap8.put(5L, shortWeekdays[6]);
            hashMap8.put(6L, shortWeekdays[7]);
            hashMap8.put(7L, shortWeekdays[1]);
            hashMap5.put(C0064l.SHORT, hashMap8);
            return m344a(hashMap5);
        } else if (iVar == C0071a.AMPM_OF_DAY) {
            DateFormatSymbols instance3 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap9 = new HashMap();
            String[] amPmStrings = instance3.getAmPmStrings();
            HashMap hashMap10 = new HashMap();
            hashMap10.put(0L, amPmStrings[0]);
            hashMap10.put(1L, amPmStrings[1]);
            hashMap9.put(C0064l.FULL, hashMap10);
            hashMap9.put(C0064l.SHORT, hashMap10);
            return m344a(hashMap9);
        } else if (iVar == C0071a.ERA) {
            DateFormatSymbols instance4 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap11 = new HashMap();
            String[] eras = instance4.getEras();
            HashMap hashMap12 = new HashMap();
            hashMap12.put(0L, eras[0]);
            hashMap12.put(1L, eras[1]);
            hashMap11.put(C0064l.SHORT, hashMap12);
            if (locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
                HashMap hashMap13 = new HashMap();
                hashMap13.put(0L, "Before Christ");
                hashMap13.put(1L, "Anno Domini");
                hashMap11.put(C0064l.FULL, hashMap13);
            } else {
                hashMap11.put(C0064l.FULL, hashMap12);
            }
            HashMap hashMap14 = new HashMap();
            hashMap14.put(0L, eras[0].substring(0, 1));
            hashMap14.put(1L, eras[1].substring(0, 1));
            hashMap11.put(C0064l.NARROW, hashMap14);
            return m344a(hashMap11);
        } else if (iVar != C0073c.f233b) {
            return "";
        } else {
            HashMap hashMap15 = new HashMap();
            HashMap hashMap16 = new HashMap();
            hashMap16.put(1L, "Q1");
            hashMap16.put(2L, "Q2");
            hashMap16.put(3L, "Q3");
            hashMap16.put(4L, "Q4");
            hashMap15.put(C0064l.SHORT, hashMap16);
            HashMap hashMap17 = new HashMap();
            hashMap17.put(1L, "1st quarter");
            hashMap17.put(2L, "2nd quarter");
            hashMap17.put(3L, "3rd quarter");
            hashMap17.put(4L, "4th quarter");
            hashMap15.put(C0064l.FULL, hashMap17);
            return m344a(hashMap15);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <A, B> Map.Entry<A, B> m349b(A a, B b) {
        return new AbstractMap.SimpleImmutableEntry(a, b);
    }

    /* renamed from: a */
    private static C0063a m344a(Map<C0064l, Map<Long, String>> map) {
        map.put(C0064l.FULL_STANDALONE, map.get(C0064l.FULL));
        map.put(C0064l.SHORT_STANDALONE, map.get(C0064l.SHORT));
        if (map.containsKey(C0064l.NARROW) && !map.containsKey(C0064l.NARROW_STANDALONE)) {
            map.put(C0064l.NARROW_STANDALONE, map.get(C0064l.NARROW));
        }
        return new C0063a(map);
    }

    /* renamed from: a.b.a.b.k$a */
    /* compiled from: SimpleDateTimeTextProvider */
    static final class C0063a {

        /* renamed from: a */
        private final Map<C0064l, Map<Long, String>> f154a;

        /* renamed from: b */
        private final Map<C0064l, List<Map.Entry<String, Long>>> f155b;

        /* JADX WARNING: Removed duplicated region for block: B:6:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        C0063a(java.util.Map<p000a.p007b.p008a.p010b.C0064l, java.util.Map<java.lang.Long, java.lang.String>> r10) {
            /*
                r9 = this;
                r9.<init>()
                r9.f154a = r10
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Set r0 = r10.keySet()
                java.util.Iterator r4 = r0.iterator()
            L_0x0017:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0074
                java.lang.Object r0 = r4.next()
                a.b.a.b.l r0 = (p000a.p007b.p008a.p010b.C0064l) r0
                java.util.HashMap r5 = new java.util.HashMap
                r5.<init>()
                java.lang.Object r1 = r10.get(r0)
                java.util.Map r1 = (java.util.Map) r1
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r6 = r1.iterator()
            L_0x0036:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0059
                java.lang.Object r1 = r6.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r7 = r1.getValue()
                java.lang.Object r8 = r1.getValue()
                java.lang.Object r1 = r1.getKey()
                java.util.Map$Entry r1 = p000a.p007b.p008a.p010b.C0061k.m349b(r8, r1)
                java.lang.Object r1 = r5.put(r7, r1)
                if (r1 == 0) goto L_0x0036
                goto L_0x0036
            L_0x0059:
                java.util.ArrayList r1 = new java.util.ArrayList
                java.util.Collection r5 = r5.values()
                r1.<init>(r5)
                java.util.Comparator r5 = p000a.p007b.p008a.p010b.C0061k.f153b
                java.util.Collections.sort(r1, r5)
                r2.put(r0, r1)
                r3.addAll(r1)
                r0 = 0
                r2.put(r0, r3)
                goto L_0x0017
            L_0x0074:
                java.util.Comparator r0 = p000a.p007b.p008a.p010b.C0061k.f153b
                java.util.Collections.sort(r3, r0)
                r9.f155b = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p010b.C0061k.C0063a.<init>(java.util.Map):void");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo233a(long j, C0064l lVar) {
            Map map = this.f154a.get(lVar);
            if (map != null) {
                return (String) map.get(Long.valueOf(j));
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Iterator<Map.Entry<String, Long>> mo234a(C0064l lVar) {
            List list = this.f155b.get(lVar);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }
}
