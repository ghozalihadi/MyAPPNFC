package android.support.p019v7.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.p016v4.graphics.ColorUtils;
import android.support.p019v7.appcompat.C0555R;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.content.res.AppCompatColorStateListInflater */
final class AppCompatColorStateListInflater {
    private static final int DEFAULT_COLOR = -65536;

    private AppCompatColorStateListInflater() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList createFromXml(android.content.res.Resources r4, org.xmlpull.v1.XmlPullParser r5, android.content.res.Resources.Theme r6) {
        /*
            r3 = 2
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0005:
            int r1 = r5.next()
            if (r1 == r3) goto L_0x000e
            r2 = 1
            if (r1 != r2) goto L_0x0005
        L_0x000e:
            if (r1 == r3) goto L_0x0018
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r1 = "No start tag found"
            r0.<init>(r1)
            throw r0
        L_0x0018:
            android.content.res.ColorStateList r0 = createFromXmlInner(r4, r5, r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.content.res.AppCompatColorStateListInflater.createFromXml(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    private static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static ColorStateList inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int i;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[][] iArr2 = iArr;
        int i2 = 0;
        int[] iArr3 = new int[iArr.length];
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                int[] iArr4 = new int[i2];
                int[][] iArr5 = new int[i2][];
                System.arraycopy(iArr3, 0, iArr4, 0, i2);
                System.arraycopy(iArr2, 0, iArr5, 0, i2);
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, C0555R.styleable.ColorStateListItem);
                int color = obtainAttributes.getColor(C0555R.styleable.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (obtainAttributes.hasValue(C0555R.styleable.ColorStateListItem_android_alpha)) {
                    f = obtainAttributes.getFloat(C0555R.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (obtainAttributes.hasValue(C0555R.styleable.ColorStateListItem_alpha)) {
                    f = obtainAttributes.getFloat(C0555R.styleable.ColorStateListItem_alpha, 1.0f);
                }
                obtainAttributes.recycle();
                int i3 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr6 = new int[attributeCount];
                int i4 = 0;
                while (i4 < attributeCount) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == C0555R.attr.alpha) {
                        i = i3;
                    } else {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr6[i3] = attributeNameResource;
                        i = i5;
                    }
                    i4++;
                    i3 = i;
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr6, i3);
                int modulateColorAlpha = modulateColorAlpha(color, f);
                if (i2 == 0 || trimStateSet.length == 0) {
                }
                int[] append = GrowingArrayUtils.append(iArr3, i2, modulateColorAlpha);
                i2++;
                iArr2 = (int[][]) GrowingArrayUtils.append((T[]) iArr2, i2, trimStateSet);
                iArr3 = append;
            }
        }
        int[] iArr42 = new int[i2];
        int[][] iArr52 = new int[i2][];
        System.arraycopy(iArr3, 0, iArr42, 0, i2);
        System.arraycopy(iArr2, 0, iArr52, 0, i2);
        return new ColorStateList(iArr52, iArr42);
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int modulateColorAlpha(int i, float f) {
        return ColorUtils.setAlphaComponent(i, Math.round(((float) Color.alpha(i)) * f));
    }
}
