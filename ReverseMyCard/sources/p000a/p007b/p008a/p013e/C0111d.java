package p000a.p007b.p008a.p013e;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0118g;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p011c.C0069c;

/* renamed from: a.b.a.e.d */
/* compiled from: ZoneRules */
public abstract class C0111d {
    /* renamed from: a */
    public abstract C0136n mo309a(C0103e eVar);

    /* renamed from: a */
    public abstract List<C0136n> mo310a(C0118g gVar);

    /* renamed from: a */
    public abstract boolean mo311a();

    /* renamed from: a */
    public abstract boolean mo312a(C0118g gVar, C0136n nVar);

    /* renamed from: b */
    public abstract C0107b mo313b(C0118g gVar);

    /* renamed from: c */
    public abstract boolean mo315c(C0103e eVar);

    /* renamed from: a */
    public static C0111d m585a(C0136n nVar) {
        C0069c.m378a(nVar, "offset");
        return new C0112a(nVar);
    }

    C0111d() {
    }

    /* renamed from: a.b.a.e.d$a */
    /* compiled from: ZoneRules */
    static final class C0112a extends C0111d implements Serializable {

        /* renamed from: a */
        private final C0136n f315a;

        C0112a(C0136n nVar) {
            this.f315a = nVar;
        }

        /* renamed from: a */
        public boolean mo311a() {
            return true;
        }

        /* renamed from: a */
        public C0136n mo309a(C0103e eVar) {
            return this.f315a;
        }

        /* renamed from: a */
        public List<C0136n> mo310a(C0118g gVar) {
            return Collections.singletonList(this.f315a);
        }

        /* renamed from: b */
        public C0107b mo313b(C0118g gVar) {
            return null;
        }

        /* renamed from: a */
        public boolean mo312a(C0118g gVar, C0136n nVar) {
            return this.f315a.equals(nVar);
        }

        /* renamed from: c */
        public boolean mo315c(C0103e eVar) {
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0112a) {
                return this.f315a.equals(((C0112a) obj).f315a);
            }
            if (!(obj instanceof C0106a)) {
                return false;
            }
            C0106a aVar = (C0106a) obj;
            if (!aVar.mo311a() || !this.f315a.equals(aVar.mo309a(C0103e.f283a))) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((((this.f315a.hashCode() + 31) ^ 1) ^ 1) ^ (this.f315a.hashCode() + 31)) ^ 1;
        }

        public String toString() {
            return "FixedRules:" + this.f315a;
        }
    }
}
