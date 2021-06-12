package p000a.p007b.p008a.p010b;

/* renamed from: a.b.a.b.j */
/* compiled from: SignStyle */
public enum C0060j {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo230a(boolean z, boolean z2, boolean z3) {
        boolean z4 = false;
        switch (ordinal()) {
            case 0:
                if (!z || !z2) {
                    z4 = true;
                }
                return z4;
            case 1:
            case 4:
                return true;
            default:
                if (z2 || z3) {
                    return false;
                }
                return true;
        }
    }
}
