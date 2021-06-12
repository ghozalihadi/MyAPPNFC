package p000a.p007b.p008a.p013e;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.p007b.p008a.p011c.C0069c;

/* renamed from: a.b.a.e.f */
/* compiled from: ZoneRulesProvider */
public abstract class C0114f {

    /* renamed from: a */
    private static final CopyOnWriteArrayList<C0114f> f316a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    private static final ConcurrentMap<String, C0114f> f317b = new ConcurrentHashMap(512, 0.75f, 2);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract C0111d mo341b(String str, boolean z);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Set<String> mo342b();

    static {
        ServiceLoader<S> load = ServiceLoader.load(C0114f.class, C0114f.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = load.iterator();
        while (it.hasNext()) {
            try {
                m601a((C0114f) it.next());
            } catch (ServiceConfigurationError e) {
                if (!(e.getCause() instanceof SecurityException)) {
                    throw e;
                }
            }
        }
        f316a.addAll(arrayList);
    }

    /* renamed from: a */
    public static Set<String> m600a() {
        return new HashSet(f317b.keySet());
    }

    /* renamed from: a */
    public static C0111d m598a(String str, boolean z) {
        C0069c.m378a(str, "zoneId");
        return m599a(str).mo341b(str, z);
    }

    /* renamed from: a */
    private static C0114f m599a(String str) {
        C0114f fVar = (C0114f) f317b.get(str);
        if (fVar != null) {
            return fVar;
        }
        if (f317b.isEmpty()) {
            throw new C0113e("No time-zone data files registered");
        }
        throw new C0113e("Unknown time-zone ID: " + str);
    }

    /* renamed from: a */
    private static void m601a(C0114f fVar) {
        for (String next : fVar.mo342b()) {
            C0069c.m378a(next, "zoneId");
            if (f317b.putIfAbsent(next, fVar) != null) {
                throw new C0113e("Unable to register zone as one already registered with that ID: " + next + ", currently loading from provider: " + fVar);
            }
        }
    }

    protected C0114f() {
    }
}
