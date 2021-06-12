package p000a.p007b.p008a.p013e;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0118g;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0008b;
import p000a.p007b.p008a.p011c.C0069c;
import p000a.p007b.p008a.p013e.C0111d;

/* renamed from: a.b.a.e.a */
/* compiled from: StandardZoneRules */
final class C0106a extends C0111d implements Serializable {

    /* renamed from: a */
    private final long[] f291a;

    /* renamed from: b */
    private final C0136n[] f292b;

    /* renamed from: c */
    private final long[] f293c;

    /* renamed from: d */
    private final C0118g[] f294d;

    /* renamed from: e */
    private final C0136n[] f295e;

    /* renamed from: f */
    private final C0108c[] f296f;

    /* renamed from: g */
    private final ConcurrentMap<Integer, C0107b[]> f297g;

    /* renamed from: a */
    public boolean mo311a() {
        return this.f293c.length == 0;
    }

    /* renamed from: a */
    public C0136n mo309a(C0103e eVar) {
        long a = eVar.mo294a();
        if (this.f296f.length <= 0 || a <= this.f293c[this.f293c.length - 1]) {
            int binarySearch = Arrays.binarySearch(this.f293c, a);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            return this.f295e[binarySearch + 1];
        }
        C0107b[] a2 = m563a(m561a(a, this.f295e[this.f295e.length - 1]));
        C0107b bVar = null;
        for (int i = 0; i < a2.length; i++) {
            bVar = a2[i];
            if (a < bVar.mo321b()) {
                return bVar.mo325e();
            }
        }
        return bVar.mo327f();
    }

    /* renamed from: a */
    public List<C0136n> mo310a(C0118g gVar) {
        Object c = m564c(gVar);
        if (c instanceof C0107b) {
            return ((C0107b) c).mo331i();
        }
        return Collections.singletonList((C0136n) c);
    }

    /* renamed from: b */
    public C0107b mo313b(C0118g gVar) {
        Object c = m564c(gVar);
        if (c instanceof C0107b) {
            return (C0107b) c;
        }
        return null;
    }

    /* renamed from: c */
    private Object m564c(C0118g gVar) {
        if (this.f296f.length <= 0 || !gVar.mo47b((C0008b<?>) this.f294d[this.f294d.length - 1])) {
            int binarySearch = Arrays.binarySearch(this.f294d, gVar);
            if (binarySearch == -1) {
                return this.f295e[0];
            }
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            } else if (binarySearch < this.f294d.length - 1 && this.f294d[binarySearch].equals(this.f294d[binarySearch + 1])) {
                binarySearch++;
            }
            if ((binarySearch & 1) != 0) {
                return this.f295e[(binarySearch / 2) + 1];
            }
            C0118g gVar2 = this.f294d[binarySearch];
            C0118g gVar3 = this.f294d[binarySearch + 1];
            C0136n nVar = this.f295e[binarySearch / 2];
            C0136n nVar2 = this.f295e[(binarySearch / 2) + 1];
            if (nVar2.mo452f() > nVar.mo452f()) {
                return new C0107b(gVar2, nVar, nVar2);
            }
            return new C0107b(gVar3, nVar, nVar2);
        }
        Object obj = null;
        for (C0107b bVar : m563a(gVar.mo366a())) {
            obj = m562a(gVar, bVar);
            if ((obj instanceof C0107b) || obj.equals(bVar.mo325e())) {
                return obj;
            }
        }
        return obj;
    }

    /* renamed from: a */
    private Object m562a(C0118g gVar, C0107b bVar) {
        C0118g c = bVar.mo322c();
        if (bVar.mo329h()) {
            if (gVar.mo50c((C0008b<?>) c)) {
                return bVar.mo325e();
            }
            if (!gVar.mo50c((C0008b<?>) bVar.mo324d())) {
                return bVar.mo327f();
            }
            return bVar;
        } else if (!gVar.mo50c((C0008b<?>) c)) {
            return bVar.mo327f();
        } else {
            if (gVar.mo50c((C0008b<?>) bVar.mo324d())) {
                return bVar.mo325e();
            }
            return bVar;
        }
    }

    /* renamed from: a */
    public boolean mo312a(C0118g gVar, C0136n nVar) {
        return mo310a(gVar).contains(nVar);
    }

    /* renamed from: a */
    private C0107b[] m563a(int i) {
        Integer valueOf = Integer.valueOf(i);
        C0107b[] bVarArr = (C0107b[]) this.f297g.get(valueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        C0108c[] cVarArr = this.f296f;
        C0107b[] bVarArr2 = new C0107b[cVarArr.length];
        for (int i2 = 0; i2 < cVarArr.length; i2++) {
            bVarArr2[i2] = cVarArr[i2].mo333a(i);
        }
        if (i < 2100) {
            this.f297g.putIfAbsent(valueOf, bVarArr2);
        }
        return bVarArr2;
    }

    /* renamed from: b */
    public C0136n mo314b(C0103e eVar) {
        int binarySearch = Arrays.binarySearch(this.f291a, eVar.mo294a());
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f292b[binarySearch + 1];
    }

    /* renamed from: c */
    public boolean mo315c(C0103e eVar) {
        return !mo314b(eVar).equals(mo309a(eVar));
    }

    /* renamed from: a */
    private int m561a(long j, C0136n nVar) {
        return C0115f.m608a(C0069c.m386e(((long) nVar.mo452f()) + j, 86400)).mo356d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0106a) {
            C0106a aVar = (C0106a) obj;
            if (!Arrays.equals(this.f291a, aVar.f291a) || !Arrays.equals(this.f292b, aVar.f292b) || !Arrays.equals(this.f293c, aVar.f293c) || !Arrays.equals(this.f295e, aVar.f295e) || !Arrays.equals(this.f296f, aVar.f296f)) {
                return false;
            }
            return true;
        } else if (!(obj instanceof C0111d.C0112a)) {
            return false;
        } else {
            if (!mo311a() || !mo309a(C0103e.f283a).equals(((C0111d.C0112a) obj).mo309a(C0103e.f283a))) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.f291a) ^ Arrays.hashCode(this.f292b)) ^ Arrays.hashCode(this.f293c)) ^ Arrays.hashCode(this.f295e)) ^ Arrays.hashCode(this.f296f);
    }

    public String toString() {
        return "StandardZoneRules[currentStandardOffset=" + this.f292b[this.f292b.length - 1] + "]";
    }
}
