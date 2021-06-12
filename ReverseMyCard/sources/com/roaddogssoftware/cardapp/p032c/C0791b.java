package com.roaddogssoftware.cardapp.p032c;

/* renamed from: com.roaddogssoftware.cardapp.c.b */
/* compiled from: SharedUtils */
public class C0791b {
    /* renamed from: a */
    public static String m2360a(byte[] bArr) {
        return m2361a(bArr, " ");
    }

    /* renamed from: a */
    public static String m2361a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : bArr) {
            sb.append(String.format("%02X" + str, new Object[]{Byte.valueOf(valueOf)}));
        }
        return sb.toString();
    }
}
