package p000a.p007b.p008a.p012d;

import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0121h;
import p000a.p007b.p008a.C0134m;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0018g;

/* renamed from: a.b.a.d.j */
/* compiled from: TemporalQueries */
public final class C0089j {

    /* renamed from: a */
    static final C0097k<C0134m> f252a = new C0097k<C0134m>() {
        /* renamed from: a */
        public C0134m mo107b(C0082e eVar) {
            return (C0134m) eVar.mo17a(this);
        }
    };

    /* renamed from: b */
    static final C0097k<C0018g> f253b = new C0097k<C0018g>() {
        /* renamed from: a */
        public C0018g mo107b(C0082e eVar) {
            return (C0018g) eVar.mo17a(this);
        }
    };

    /* renamed from: c */
    static final C0097k<C0098l> f254c = new C0097k<C0098l>() {
        /* renamed from: a */
        public C0098l mo107b(C0082e eVar) {
            return (C0098l) eVar.mo17a(this);
        }
    };

    /* renamed from: d */
    static final C0097k<C0134m> f255d = new C0097k<C0134m>() {
        /* renamed from: a */
        public C0134m mo107b(C0082e eVar) {
            C0134m mVar = (C0134m) eVar.mo17a(C0089j.f252a);
            return mVar != null ? mVar : (C0134m) eVar.mo17a(C0089j.f256e);
        }
    };

    /* renamed from: e */
    static final C0097k<C0136n> f256e = new C0097k<C0136n>() {
        /* renamed from: a */
        public C0136n mo107b(C0082e eVar) {
            if (eVar.mo18a((C0088i) C0071a.OFFSET_SECONDS)) {
                return C0136n.m832a(eVar.mo67c(C0071a.OFFSET_SECONDS));
            }
            return null;
        }
    };

    /* renamed from: f */
    static final C0097k<C0115f> f257f = new C0097k<C0115f>() {
        /* renamed from: a */
        public C0115f mo107b(C0082e eVar) {
            if (eVar.mo18a((C0088i) C0071a.EPOCH_DAY)) {
                return C0115f.m608a(eVar.mo68d(C0071a.EPOCH_DAY));
            }
            return null;
        }
    };

    /* renamed from: g */
    static final C0097k<C0121h> f258g = new C0097k<C0121h>() {
        /* renamed from: a */
        public C0121h mo107b(C0082e eVar) {
            if (eVar.mo18a((C0088i) C0071a.NANO_OF_DAY)) {
                return C0121h.m716b(eVar.mo68d(C0071a.NANO_OF_DAY));
            }
            return null;
        }
    };

    /* renamed from: a */
    public static final C0097k<C0134m> m467a() {
        return f252a;
    }

    /* renamed from: b */
    public static final C0097k<C0018g> m468b() {
        return f253b;
    }

    /* renamed from: c */
    public static final C0097k<C0098l> m469c() {
        return f254c;
    }

    /* renamed from: d */
    public static final C0097k<C0134m> m470d() {
        return f255d;
    }

    /* renamed from: e */
    public static final C0097k<C0136n> m471e() {
        return f256e;
    }

    /* renamed from: f */
    public static final C0097k<C0115f> m472f() {
        return f257f;
    }

    /* renamed from: g */
    public static final C0097k<C0121h> m473g() {
        return f258g;
    }
}
