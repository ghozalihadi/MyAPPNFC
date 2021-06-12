package android.support.p016v4.text;

import android.os.Build;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextUtilsCompat */
public final class TextUtilsCompat {
    static String ARAB_SCRIPT_SUBTAG = "Arab";
    static String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final TextUtilsCompatImpl IMPL;
    public static final Locale ROOT = new Locale("", "");

    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatImpl */
    private static class TextUtilsCompatImpl {
        TextUtilsCompatImpl() {
        }

        public String htmlEncode(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case '\"':
                        sb.append("&quot;");
                        break;
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#39;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    default:
                        sb.append(charAt);
                        break;
                }
            }
            return sb.toString();
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (locale != null && !locale.equals(TextUtilsCompat.ROOT)) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript == null) {
                    return getLayoutDirectionFromFirstChar(locale);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int getLayoutDirectionFromFirstChar(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case 1:
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl */
    private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        TextUtilsCompatJellybeanMr1Impl() {
        }

        public String htmlEncode(String str) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(str);
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new TextUtilsCompatJellybeanMr1Impl();
        } else {
            IMPL = new TextUtilsCompatImpl();
        }
    }

    public static String htmlEncode(String str) {
        return IMPL.htmlEncode(str);
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return IMPL.getLayoutDirectionFromLocale(locale);
    }

    private TextUtilsCompat() {
    }
}
