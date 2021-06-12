package com.roaddogssoftware.cardapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.roaddogssoftware.cardapp.h */
/* compiled from: Util */
public class C0797h {
    /* renamed from: a */
    public static String m2363a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m2365a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) | Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* renamed from: b */
    public static int m2366b(String str) {
        int i = 0;
        while (true) {
            if (i >= MainActivity.f1398L.size()) {
                i = -1;
                break;
            } else if (MainActivity.f1398L.get(i).equals(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i > -1) {
            return MainActivity.f1397K.get(i).intValue();
        }
        return 0;
    }

    /* renamed from: c */
    public static int m2367c(String str) {
        int i = 0;
        while (true) {
            if (i >= MainActivity.f1400N.size()) {
                i = -1;
                break;
            } else if (MainActivity.f1400N.get(i).contains(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i > -1) {
            return MainActivity.f1399M.get(i).intValue();
        }
        return 0;
    }

    /* renamed from: d */
    public static String m2368d(String str) {
        if (str.length() < 7) {
            return str;
        }
        String substring = str.substring(5, 7);
        return substring + "/" + str.substring(2, 4);
    }

    /* renamed from: e */
    public static String m2369e(String str) {
        String[] split = str.split(";");
        if (split.length <= 1) {
            return "";
        }
        String substring = split[1].substring(17, 19);
        return "20" + substring + "-" + split[1].substring(19, 21);
    }

    /* renamed from: f */
    public static String m2370f(String str) {
        String[] split = str.split("=");
        if (split.length > 0) {
            return split[0].replace(";", "").substring(0, 16);
        }
        return "";
    }

    /* renamed from: g */
    public static String m2371g(String str) {
        if (str.length() == 16) {
            return (((((str.substring(0, 4) + " ") + str.substring(4, 8)) + " ") + str.substring(8, 12)) + " ") + str.substring(12, 16);
        } else if (str.length() != 15) {
            return "";
        } else {
            return (((str.substring(0, 4) + " ") + str.substring(4, 10)) + " ") + str.substring(10, 15);
        }
    }

    /* renamed from: h */
    public static String m2372h(String str) {
        if (str.length() == 16) {
            return "**** " + str.substring(str.length() - 4, str.length());
        }
        if (str.length() == 15) {
            return "**** " + str.substring(str.length() - 5, str.length());
        }
        return "****";
    }

    /* renamed from: i */
    public static String m2373i(String str) {
        if (str.length() == 16) {
            return "**** **** **** " + str.substring(str.length() - 4, str.length());
        }
        if (str.length() == 15) {
            return "**** ****** " + str.substring(str.length() - 5, str.length());
        }
        return "****";
    }

    /* renamed from: j */
    public static String m2374j(String str) {
        try {
            return str.substring(0, 16) + "********" + str.substring(24, str.length());
        } catch (Exception e) {
            return "Exception hiding data!";
        }
    }

    /* renamed from: k */
    public static String m2375k(String str) {
        try {
            Matcher matcher = Pattern.compile(".*;(\\d{12,19}=\\d{1,128})\\?.*").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1).replace(";", "").substring(0, 6);
            }
            return "Error getting BIN number!";
        } catch (Exception e) {
            return "Exception getting BIN number!";
        }
    }

    /* renamed from: l */
    public static String m2376l(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1908845485:
                if (str.equals("discover_white")) {
                    c = 15;
                    break;
                }
                break;
            case -1294066730:
                if (str.equals("master_hsbc_11")) {
                    c = 6;
                    break;
                }
                break;
            case -936806741:
                if (str.equals("visa_white")) {
                    c = 18;
                    break;
                }
                break;
            case -821554514:
                if (str.equals("visa_cap1_no_hassle")) {
                    c = 9;
                    break;
                }
                break;
            case -805879620:
                if (str.equals("master_cap1_bird")) {
                    c = 4;
                    break;
                }
                break;
            case -796751860:
                if (str.equals("master_white")) {
                    c = 16;
                    break;
                }
                break;
            case -463143872:
                if (str.equals("visa_usbank_flex")) {
                    c = 11;
                    break;
                }
                break;
            case -23789205:
                if (str.equals("master_chase_gas")) {
                    c = 5;
                    break;
                }
                break;
            case 0:
                if (str.equals("")) {
                    c = 0;
                    break;
                }
                break;
            case 351121155:
                if (str.equals("visa_citi_white")) {
                    c = 10;
                    break;
                }
                break;
            case 426869962:
                if (str.equals("visa_bow_rwb")) {
                    c = 8;
                    break;
                }
                break;
            case 563333577:
                if (str.equals("amex_white")) {
                    c = 17;
                    break;
                }
                break;
            case 979949406:
                if (str.equals("card_empty")) {
                    c = 1;
                    break;
                }
                break;
            case 1536002414:
                if (str.equals("visa_wells_fargo_inc4")) {
                    c = 12;
                    break;
                }
                break;
            case 1536002416:
                if (str.equals("visa_wells_fargo_inc6")) {
                    c = 13;
                    break;
                }
                break;
            case 1536002417:
                if (str.equals("visa_wells_fargo_inc7")) {
                    c = 14;
                    break;
                }
                break;
            case 1650750048:
                if (str.equals("master_us_bank")) {
                    c = 7;
                    break;
                }
                break;
            case 1679608775:
                if (str.equals("master_boa_grey")) {
                    c = 2;
                    break;
                }
                break;
            case 1855306965:
                if (str.equals("master_boa_rwb")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "#000000";
            case 1:
                return "#000000";
            case 2:
                return "#000000";
            case 3:
                return "#000000";
            case 4:
                return "#000000";
            case 5:
                return "#000000";
            case 6:
                return "#000000";
            case 7:
                return "#000000";
            case 8:
                return "#000000";
            case 9:
                return "#000000";
            case 10:
                return "#000000";
            case 11:
                return "#000000";
            case 12:
                return "#000000";
            case 13:
                return "#000000";
            case 14:
                return "#000000";
            case 15:
                return "#000000";
            case 16:
                return "#000000";
            case 17:
                return "#000000";
            case 18:
                return "#000000";
            default:
                return "#FFFFFF";
        }
    }

    /* renamed from: a */
    public static void m2364a(String... strArr) {
    }
}
