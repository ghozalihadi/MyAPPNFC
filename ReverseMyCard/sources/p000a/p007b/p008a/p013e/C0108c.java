package p000a.p007b.p008a.p013e;

import java.io.Serializable;
import p000a.p007b.p008a.C0065c;
import p000a.p007b.p008a.C0115f;
import p000a.p007b.p008a.C0118g;
import p000a.p007b.p008a.C0121h;
import p000a.p007b.p008a.C0124i;
import p000a.p007b.p008a.C0136n;
import p000a.p007b.p008a.p009a.C0021i;
import p000a.p007b.p008a.p012d.C0084g;

/* renamed from: a.b.a.e.c */
/* compiled from: ZoneOffsetTransitionRule */
public final class C0108c implements Serializable {

    /* renamed from: a */
    private final C0124i f301a;

    /* renamed from: b */
    private final byte f302b;

    /* renamed from: c */
    private final C0065c f303c;

    /* renamed from: d */
    private final C0121h f304d;

    /* renamed from: e */
    private final boolean f305e;

    /* renamed from: f */
    private final C0110a f306f;

    /* renamed from: g */
    private final C0136n f307g;

    /* renamed from: h */
    private final C0136n f308h;

    /* renamed from: i */
    private final C0136n f309i;

    /* renamed from: a */
    public C0107b mo333a(int i) {
        C0115f a;
        if (this.f302b < 0) {
            a = C0115f.m607a(i, this.f301a, this.f301a.mo405a(C0021i.f19b.mo97a((long) i)) + 1 + this.f302b);
            if (this.f303c != null) {
                a = a.mo24c(C0084g.m456b(this.f303c));
            }
        } else {
            a = C0115f.m607a(i, this.f301a, (int) this.f302b);
            if (this.f303c != null) {
                a = a.mo24c(C0084g.m455a(this.f303c));
            }
        }
        if (this.f305e) {
            a = a.mo359e(1);
        }
        return new C0107b(this.f306f.mo337a(C0118g.m668a(a, this.f304d), this.f307g, this.f308h), this.f308h, this.f309i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0108c)) {
            return false;
        }
        C0108c cVar = (C0108c) obj;
        if (this.f301a == cVar.f301a && this.f302b == cVar.f302b && this.f303c == cVar.f303c && this.f306f == cVar.f306f && this.f304d.equals(cVar.f304d) && this.f305e == cVar.f305e && this.f307g.equals(cVar.f307g) && this.f308h.equals(cVar.f308h) && this.f309i.equals(cVar.f309i)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f303c == null ? 7 : this.f303c.ordinal()) << 2) + (((this.f302b + 32) << 5) + ((((this.f305e ? 1 : 0) + this.f304d.mo391c()) << 15) + (this.f301a.ordinal() << 11)))) + this.f306f.ordinal()) ^ this.f307g.hashCode()) ^ this.f308h.hashCode()) ^ this.f309i.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransitionRule[").append(this.f308h.compareTo(this.f309i) > 0 ? "Gap " : "Overlap ").append(this.f308h).append(" to ").append(this.f309i).append(", ");
        if (this.f303c == null) {
            sb.append(this.f301a.name()).append(' ').append(this.f302b);
        } else if (this.f302b == -1) {
            sb.append(this.f303c.name()).append(" on or before last day of ").append(this.f301a.name());
        } else if (this.f302b < 0) {
            sb.append(this.f303c.name()).append(" on or before last day minus ").append((-this.f302b) - 1).append(" of ").append(this.f301a.name());
        } else {
            sb.append(this.f303c.name()).append(" on or after ").append(this.f301a.name()).append(' ').append(this.f302b);
        }
        sb.append(" at ").append(this.f305e ? "24:00" : this.f304d.toString()).append(" ").append(this.f306f).append(", standard offset ").append(this.f307g).append(']');
        return sb.toString();
    }

    /* renamed from: a.b.a.e.c$a */
    /* compiled from: ZoneOffsetTransitionRule */
    public enum C0110a {
        UTC,
        WALL,
        STANDARD;

        /* renamed from: a */
        public C0118g mo337a(C0118g gVar, C0136n nVar, C0136n nVar2) {
            switch (this) {
                case UTC:
                    return gVar.mo379d((long) (nVar2.mo452f() - C0136n.f379d.mo452f()));
                case STANDARD:
                    return gVar.mo379d((long) (nVar2.mo452f() - nVar.mo452f()));
                default:
                    return gVar;
            }
        }
    }
}
