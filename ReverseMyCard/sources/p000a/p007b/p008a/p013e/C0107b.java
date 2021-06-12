package p000a.p007b.p008a.p013e;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p000a.p007b.p008a.C0070d;
import p000a.p007b.p008a.C0103e;
import p000a.p007b.p008a.C0118g;
import p000a.p007b.p008a.C0136n;

/* renamed from: a.b.a.e.b */
/* compiled from: ZoneOffsetTransition */
public final class C0107b implements Serializable, Comparable<C0107b> {

    /* renamed from: a */
    private final C0118g f298a;

    /* renamed from: b */
    private final C0136n f299b;

    /* renamed from: c */
    private final C0136n f300c;

    C0107b(C0118g gVar, C0136n nVar, C0136n nVar2) {
        this.f298a = gVar;
        this.f299b = nVar;
        this.f300c = nVar2;
    }

    /* renamed from: a */
    public C0103e mo320a() {
        return this.f298a.mo43a(this.f299b);
    }

    /* renamed from: b */
    public long mo321b() {
        return this.f298a.mo44b(this.f299b);
    }

    /* renamed from: c */
    public C0118g mo322c() {
        return this.f298a;
    }

    /* renamed from: d */
    public C0118g mo324d() {
        return this.f298a.mo379d((long) m572j());
    }

    /* renamed from: e */
    public C0136n mo325e() {
        return this.f299b;
    }

    /* renamed from: f */
    public C0136n mo327f() {
        return this.f300c;
    }

    /* renamed from: g */
    public C0070d mo328g() {
        return C0070d.m388a((long) m572j());
    }

    /* renamed from: j */
    private int m572j() {
        return mo327f().mo452f() - mo325e().mo452f();
    }

    /* renamed from: h */
    public boolean mo329h() {
        return mo327f().mo452f() > mo325e().mo452f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public List<C0136n> mo331i() {
        if (mo329h()) {
            return Collections.emptyList();
        }
        return Arrays.asList(new C0136n[]{mo325e(), mo327f()});
    }

    /* renamed from: a */
    public int compareTo(C0107b bVar) {
        return mo320a().compareTo(bVar.mo320a());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0107b)) {
            return false;
        }
        C0107b bVar = (C0107b) obj;
        if (!this.f298a.equals(bVar.f298a) || !this.f299b.equals(bVar.f299b) || !this.f300c.equals(bVar.f300c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f298a.hashCode() ^ this.f299b.hashCode()) ^ Integer.rotateLeft(this.f300c.hashCode(), 16);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transition[").append(mo329h() ? "Gap" : "Overlap").append(" at ").append(this.f298a).append(this.f299b).append(" to ").append(this.f300c).append(']');
        return sb.toString();
    }
}
