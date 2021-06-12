package android.support.p014a.p015a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.d */
/* compiled from: TypedArrayUtils */
class C0150d {
    /* renamed from: a */
    public static boolean m912a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: a */
    public static float m909a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m912a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* renamed from: a */
    public static boolean m911a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m912a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static int m910a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m912a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    public static int m913b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m912a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
