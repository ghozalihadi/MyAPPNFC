package p000a.p007b.p008a.p009a;

import java.util.List;
import p000a.p007b.p008a.p012d.C0087h;
import p000a.p007b.p008a.p012d.C0098l;

/* renamed from: a.b.a.a.d */
/* compiled from: ChronoPeriod */
public abstract class C0012d implements C0087h {
    /* renamed from: a */
    public abstract long mo69a(C0098l lVar);

    /* renamed from: a */
    public abstract List<C0098l> mo70a();

    /* renamed from: b */
    public boolean mo71b() {
        for (C0098l a : mo70a()) {
            if (mo69a(a) != 0) {
                return false;
            }
        }
        return true;
    }
}
