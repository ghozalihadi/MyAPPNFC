package android.support.transition;

import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.transition.ae */
/* compiled from: TransitionValues */
public class C0325ae {

    /* renamed from: a */
    public final Map<String, Object> f1101a = new HashMap();

    /* renamed from: b */
    public View f1102b;

    public boolean equals(Object obj) {
        if (!(obj instanceof C0325ae) || this.f1102b != ((C0325ae) obj).f1102b || !this.f1101a.equals(((C0325ae) obj).f1101a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f1102b.hashCode() * 31) + this.f1101a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f1102b + "\n") + "    values:";
        Iterator<String> it = this.f1101a.keySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String next = it.next();
            str = str2 + "    " + next + ": " + this.f1101a.get(next) + "\n";
        }
    }
}
