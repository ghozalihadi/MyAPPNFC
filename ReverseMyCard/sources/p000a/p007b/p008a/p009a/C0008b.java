package p000a.p007b.p008a.p009a;

import java.util.Comparator;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0121h;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0006a;
import p000a.p007b.p008a.p011c.C0067a;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p012d.C0071a;
import p000a.p007b.p008a.p012d.C0072b;
import p000a.p007b.p008a.p012d.C0081d;
import p000a.p007b.p008a.p012d.C0083f;
import p000a.p007b.p008a.p012d.C0087h;
import p000a.p007b.p008a.p012d.C0088i;
import p000a.p007b.p008a.p012d.C0089j;
import p000a.p007b.p008a.p012d.C0097k;
import p000a.p007b.p008a.p012d.C0098l;

/* renamed from: a.b.a.a.b */
/* compiled from: ChronoLocalDateTime */
public abstract class C0008b<D extends C0006a> extends C0067a implements C0081d, C0083f, Comparable<C0008b<?>> {

    /* renamed from: a */
    private static final Comparator<C0008b<?>> f5a = new Comparator<C0008b<?>>() {
        /* JADX WARNING: type inference failed for: r5v0, types: [a.b.a.a.b<?>, a.b.a.a.b] */
        /* JADX WARNING: type inference failed for: r6v0, types: [a.b.a.a.b<?>, a.b.a.a.b] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(p000a.p007b.p008a.p009a.C0008b<?> r5, p000a.p007b.p008a.p009a.C0008b<?> r6) {
            /*
                r4 = this;
                a.b.a.a.a r0 = r5.mo55f()
                long r0 = r0.mo37k()
                a.b.a.a.a r2 = r6.mo55f()
                long r2 = r2.mo37k()
                int r0 = p000a.p007b.p008a.p011c.C0069c.m376a((long) r0, (long) r2)
                if (r0 != 0) goto L_0x002a
                a.b.a.h r0 = r5.mo53e()
                long r0 = r0.mo395d()
                a.b.a.h r2 = r6.mo53e()
                long r2 = r2.mo395d()
                int r0 = p000a.p007b.p008a.p011c.C0069c.m376a((long) r0, (long) r2)
            L_0x002a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p009a.C0008b.C00091.compare(a.b.a.a.b, a.b.a.a.b):int");
        }
    };

    /* renamed from: b */
    public abstract C0013e<D> mo46b(C0134m mVar);

    /* renamed from: c */
    public abstract C0008b<D> mo22b(C0088i iVar, long j);

    /* renamed from: e */
    public abstract C0121h mo53e();

    /* renamed from: f */
    public abstract D mo55f();

    /* renamed from: f */
    public abstract C0008b<D> mo30d(long j, C0098l lVar);

    /* renamed from: g */
    public C0018g mo57g() {
        return mo55f().mo38l();
    }

    /* renamed from: c */
    public C0008b<D> mo21b(C0083f fVar) {
        return mo55f().mo38l().mo99b(super.mo21b(fVar));
    }

    /* renamed from: b */
    public C0008b<D> mo28c(C0087h hVar) {
        return mo55f().mo38l().mo99b(super.mo28c(hVar));
    }

    /* renamed from: e */
    public C0008b<D> mo27c(long j, C0098l lVar) {
        return mo55f().mo38l().mo99b(super.mo27c(j, lVar));
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m468b()) {
            return mo57g();
        }
        if (kVar == C0089j.m469c()) {
            return C0072b.NANOS;
        }
        if (kVar == C0089j.m472f()) {
            return C0115f.m608a(mo55f().mo37k());
        }
        if (kVar == C0089j.m473g()) {
            return mo53e();
        }
        if (kVar == C0089j.m470d() || kVar == C0089j.m467a() || kVar == C0089j.m471e()) {
            return null;
        }
        return super.mo17a(kVar);
    }

    /* renamed from: a */
    public C0081d mo16a(C0081d dVar) {
        return dVar.mo22b(C0071a.EPOCH_DAY, mo55f().mo37k()).mo22b(C0071a.NANO_OF_DAY, mo53e().mo395d());
    }

    /* renamed from: a */
    public C0103e mo43a(C0136n nVar) {
        return C0103e.m534a(mo44b(nVar), (long) mo53e().mo388b());
    }

    /* renamed from: b */
    public long mo44b(C0136n nVar) {
        C0069c.m378a(nVar, "offset");
        return ((mo55f().mo37k() * 86400) + ((long) mo53e().mo391c())) - ((long) nVar.mo452f());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [a.b.a.a.b<?>, a.b.a.a.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(p000a.p007b.p008a.p009a.C0008b<?> r3) {
        /*
            r2 = this;
            a.b.a.a.a r0 = r2.mo55f()
            a.b.a.a.a r1 = r3.mo55f()
            int r0 = r0.compareTo((p000a.p007b.p008a.p009a.C0006a) r1)
            if (r0 != 0) goto L_0x0028
            a.b.a.h r0 = r2.mo53e()
            a.b.a.h r1 = r3.mo53e()
            int r0 = r0.compareTo((p000a.p007b.p008a.C0121h) r1)
            if (r0 != 0) goto L_0x0028
            a.b.a.a.g r0 = r2.mo57g()
            a.b.a.a.g r1 = r3.mo57g()
            int r0 = r0.compareTo((p000a.p007b.p008a.p009a.C0018g) r1)
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p009a.C0008b.compareTo(a.b.a.a.b):int");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [a.b.a.a.b<?>, a.b.a.a.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo47b(p000a.p007b.p008a.p009a.C0008b<?> r6) {
        /*
            r5 = this;
            a.b.a.a.a r0 = r5.mo55f()
            long r0 = r0.mo37k()
            a.b.a.a.a r2 = r6.mo55f()
            long r2 = r2.mo37k()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x002c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002e
            a.b.a.h r0 = r5.mo53e()
            long r0 = r0.mo395d()
            a.b.a.h r2 = r6.mo53e()
            long r2 = r2.mo395d()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
        L_0x002c:
            r0 = 1
        L_0x002d:
            return r0
        L_0x002e:
            r0 = 0
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p009a.C0008b.mo47b(a.b.a.a.b):boolean");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [a.b.a.a.b<?>, a.b.a.a.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo50c(p000a.p007b.p008a.p009a.C0008b<?> r6) {
        /*
            r5 = this;
            a.b.a.a.a r0 = r5.mo55f()
            long r0 = r0.mo37k()
            a.b.a.a.a r2 = r6.mo55f()
            long r2 = r2.mo37k()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x002c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002e
            a.b.a.h r0 = r5.mo53e()
            long r0 = r0.mo395d()
            a.b.a.h r2 = r6.mo53e()
            long r2 = r2.mo395d()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x002e
        L_0x002c:
            r0 = 1
        L_0x002d:
            return r0
        L_0x002e:
            r0 = 0
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p009a.C0008b.mo50c(a.b.a.a.b):boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0008b)) {
            return false;
        }
        if (compareTo((C0008b<?>) (C0008b) obj) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return mo55f().hashCode() ^ mo53e().hashCode();
    }

    public String toString() {
        return mo55f().toString() + 'T' + mo53e().toString();
    }
}
