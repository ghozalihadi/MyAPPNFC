package p000a.p007b.p008a.p009a;

import java.util.Comparator;
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
import p000a.p007b.p008a.p012d.C0099m;
import p000a.p007b.p008a.p012d.C0100n;

/* renamed from: a.b.a.a.e */
/* compiled from: ChronoZonedDateTime */
public abstract class C0013e<D extends C0006a> extends C0067a implements C0081d, Comparable<C0013e<?>> {

    /* renamed from: a */
    private static Comparator<C0013e<?>> f9a = new Comparator<C0013e<?>>() {
        /* renamed from: a */
        public int compare(C0013e<?> eVar, C0013e<?> eVar2) {
            int a = C0069c.m376a(eVar.mo86i(), eVar2.mo86i());
            if (a == 0) {
                return C0069c.m376a(eVar.mo82f().mo395d(), eVar2.mo82f().mo395d());
            }
            return a;
        }
    };

    /* renamed from: a */
    public abstract C0136n mo73a();

    /* renamed from: b */
    public abstract C0134m mo75b();

    /* renamed from: c */
    public abstract C0013e<D> mo22b(C0088i iVar, long j);

    /* renamed from: f */
    public abstract C0013e<D> mo30d(long j, C0098l lVar);

    /* renamed from: g */
    public abstract C0008b<D> mo83g();

    /* renamed from: b */
    public C0100n mo66b(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo252b(this);
        }
        if (iVar == C0071a.INSTANT_SECONDS || iVar == C0071a.OFFSET_SECONDS) {
            return iVar.mo249a();
        }
        return mo83g().mo66b(iVar);
    }

    /* renamed from: c */
    public int mo67c(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return super.mo67c(iVar);
        }
        switch ((C0071a) iVar) {
            case INSTANT_SECONDS:
                throw new C0099m("Field too large for an int: " + iVar);
            case OFFSET_SECONDS:
                return mo73a().mo452f();
            default:
                return mo83g().mo67c(iVar);
        }
    }

    /* renamed from: d */
    public long mo68d(C0088i iVar) {
        if (!(iVar instanceof C0071a)) {
            return iVar.mo254c(this);
        }
        switch ((C0071a) iVar) {
            case INSTANT_SECONDS:
                return mo86i();
            case OFFSET_SECONDS:
                return (long) mo73a().mo452f();
            default:
                return mo83g().mo68d(iVar);
        }
    }

    /* renamed from: h */
    public D mo84h() {
        return mo83g().mo55f();
    }

    /* renamed from: f */
    public C0121h mo82f() {
        return mo83g().mo53e();
    }

    /* renamed from: c */
    public C0013e<D> mo21b(C0083f fVar) {
        return mo84h().mo38l().mo101c(super.mo21b(fVar));
    }

    /* renamed from: b */
    public C0013e<D> mo28c(C0087h hVar) {
        return mo84h().mo38l().mo101c(super.mo28c(hVar));
    }

    /* renamed from: e */
    public C0013e<D> mo27c(long j, C0098l lVar) {
        return mo84h().mo38l().mo101c(super.mo27c(j, lVar));
    }

    /* renamed from: a */
    public <R> R mo17a(C0097k<R> kVar) {
        if (kVar == C0089j.m467a() || kVar == C0089j.m470d()) {
            return mo75b();
        }
        if (kVar == C0089j.m468b()) {
            return mo84h().mo38l();
        }
        if (kVar == C0089j.m469c()) {
            return C0072b.NANOS;
        }
        if (kVar == C0089j.m471e()) {
            return mo73a();
        }
        if (kVar == C0089j.m472f()) {
            return C0115f.m608a(mo84h().mo37k());
        }
        if (kVar == C0089j.m473g()) {
            return mo82f();
        }
        return super.mo17a(kVar);
    }

    /* renamed from: i */
    public long mo86i() {
        return ((mo84h().mo37k() * 86400) + ((long) mo82f().mo391c())) - ((long) mo73a().mo452f());
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [a.b.a.a.e, a.b.a.a.e<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(p000a.p007b.p008a.p009a.C0013e<?> r5) {
        /*
            r4 = this;
            long r0 = r4.mo86i()
            long r2 = r5.mo86i()
            int r0 = p000a.p007b.p008a.p011c.C0069c.m376a((long) r0, (long) r2)
            if (r0 != 0) goto L_0x0059
            a.b.a.h r0 = r4.mo82f()
            int r0 = r0.mo388b()
            a.b.a.h r1 = r5.mo82f()
            int r1 = r1.mo388b()
            int r0 = r0 - r1
            if (r0 != 0) goto L_0x0059
            a.b.a.a.b r0 = r4.mo83g()
            a.b.a.a.b r1 = r5.mo83g()
            int r0 = r0.compareTo((p000a.p007b.p008a.p009a.C0008b<?>) r1)
            if (r0 != 0) goto L_0x0059
            a.b.a.m r0 = r4.mo75b()
            java.lang.String r0 = r0.mo443c()
            a.b.a.m r1 = r5.mo75b()
            java.lang.String r1 = r1.mo443c()
            int r0 = r0.compareTo(r1)
            if (r0 != 0) goto L_0x0059
            a.b.a.a.a r0 = r4.mo84h()
            a.b.a.a.g r0 = r0.mo38l()
            a.b.a.a.a r1 = r5.mo84h()
            a.b.a.a.g r1 = r1.mo38l()
            int r0 = r0.compareTo((p000a.p007b.p008a.p009a.C0018g) r1)
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p007b.p008a.p009a.C0013e.compareTo(a.b.a.a.e):int");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0013e)) {
            return false;
        }
        if (compareTo((C0013e<?>) (C0013e) obj) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (mo83g().hashCode() ^ mo73a().hashCode()) ^ Integer.rotateLeft(mo75b().hashCode(), 3);
    }

    public String toString() {
        String str = mo83g().toString() + mo73a().toString();
        if (mo73a() != mo75b()) {
            return str + '[' + mo75b().toString() + ']';
        }
        return str;
    }
}
