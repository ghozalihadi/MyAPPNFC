package p000a.p001a.p002a.p005b;

/* renamed from: a.a.a.b.a */
/* compiled from: StringUtils */
public class C0002a {
    /* renamed from: a */
    public static boolean m6a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: b */
    public static boolean m10b(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m2a(String str) {
        return str == null ? "" : str.trim();
    }

    /* renamed from: a */
    public static String m3a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) : str;
    }

    /* renamed from: b */
    public static String m7b(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() > i ? str.substring(str.length() - i) : str;
    }

    /* renamed from: a */
    public static String m1a(char c, int i) {
        char[] cArr = new char[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            cArr[i2] = c;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m4a(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return m5a(str, i, String.valueOf(c));
        }
        return str.concat(m1a(c, length));
    }

    /* renamed from: a */
    public static String m5a(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (m6a((CharSequence) str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return m4a(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return str.concat(new String(cArr));
    }

    /* renamed from: b */
    public static String m8b(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return m9b(str, i, String.valueOf(c));
        }
        return m1a(c, length).concat(str);
    }

    /* renamed from: b */
    public static String m9b(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (m6a((CharSequence) str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return m8b(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }
}
