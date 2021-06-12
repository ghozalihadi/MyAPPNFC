package p000a.p007b.p008a.p009a;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p000a.p007b.p008a.C0023b;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0121h;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0082e;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;

/* renamed from: a.b.a.a.g */
/* compiled from: Chronology */
public abstract class C0018g implements Comparable<C0018g> {

    /* renamed from: a */
    public static final C0097k<C0018g> f15a = new C0097k<C0018g>() {
        /* renamed from: a */
        public C0018g mo107b(C0082e eVar) {
            return C0018g.m125a(eVar);
        }
    };

    /* renamed from: b */
    private static final ConcurrentHashMap<String, C0018g> f16b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private static final ConcurrentHashMap<String, C0018g> f17c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private static final Method f18d;

    /* renamed from: a */
    public abstract C0006a mo91a(int i, int i2, int i3);

    /* renamed from: a */
    public abstract C0020h mo94a(int i);

    /* renamed from: a */
    public abstract String mo95a();

    /* renamed from: a */
    public abstract boolean mo97a(long j);

    /* renamed from: b */
    public abstract C0006a mo98b(C0082e eVar);

    static {
        Method method = null;
        try {
            method = Locale.class.getMethod("getUnicodeLocaleType", new Class[]{String.class});
        } catch (Throwable th) {
        }
        f18d = method;
    }

    /* renamed from: a */
    public static C0018g m125a(C0082e eVar) {
        C0069c.m378a(eVar, "temporal");
        C0018g gVar = (C0018g) eVar.mo17a(C0089j.m468b());
        return gVar != null ? gVar : C0021i.f19b;
    }

    protected C0018g() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <D extends C0006a> D mo92a(C0081d dVar) {
        D d = (C0006a) dVar;
        if (equals(d.mo38l())) {
            return d;
        }
        throw new ClassCastException("Chrono mismatch, expected: " + mo95a() + ", actual: " + d.mo38l().mo95a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public <D extends C0006a> C0010c<D> mo99b(C0081d dVar) {
        C0010c<D> cVar = (C0010c) dVar;
        if (equals(cVar.mo55f().mo38l())) {
            return cVar;
        }
        throw new ClassCastException("Chrono mismatch, required: " + mo95a() + ", supplied: " + cVar.mo55f().mo38l().mo95a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public <D extends C0006a> C0016f<D> mo101c(C0081d dVar) {
        C0016f<D> fVar = (C0016f) dVar;
        if (equals(fVar.mo84h().mo38l())) {
            return fVar;
        }
        throw new ClassCastException("Chrono mismatch, required: " + mo95a() + ", supplied: " + fVar.mo84h().mo38l().mo95a());
    }

    /* renamed from: c */
    public C0008b<?> mo100c(C0082e eVar) {
        try {
            return mo98b(eVar).mo20b(C0121h.m714a(eVar));
        } catch (C0023b e) {
            throw new C0023b("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + eVar.getClass(), e);
        }
    }

    /* renamed from: a */
    public C0013e<?> mo93a(C0103e eVar, C0134m mVar) {
        return C0016f.m115a(this, eVar, mVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96a(Map<C0088i, Long> map, C0071a aVar, long j) {
        Long l = map.get(aVar);
        if (l == null || l.longValue() == j) {
            map.put(aVar, Long.valueOf(j));
            return;
        }
        throw new C0023b("Invalid state, field: " + aVar + " " + l + " conflicts with " + aVar + " " + j);
    }

    /* renamed from: a */
    public int compareTo(C0018g gVar) {
        return mo95a().compareTo(gVar.mo95a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0018g)) {
            return false;
        }
        if (compareTo((C0018g) obj) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getClass().hashCode() ^ mo95a().hashCode();
    }

    public String toString() {
        return mo95a();
    }
}
