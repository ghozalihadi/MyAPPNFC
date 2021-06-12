package p000a.p001a.p002a.p005b.p006a;

import p000a.p001a.p002a.p005b.C0002a;

/* renamed from: a.a.a.b.a.a */
/* compiled from: WordUtils */
public class C0003a {
    /* renamed from: a */
    public static String m11a(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (C0002a.m6a((CharSequence) str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (m12a(c, cArr)) {
                z = true;
            } else if (z) {
                charArray[i] = Character.toTitleCase(c);
                z = false;
            }
        }
        return new String(charArray);
    }

    /* renamed from: b */
    public static String m13b(String str, char... cArr) {
        return (C0002a.m6a((CharSequence) str) || (cArr == null ? -1 : cArr.length) == 0) ? str : m11a(str.toLowerCase(), cArr);
    }

    /* renamed from: a */
    private static boolean m12a(char c, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }
}
