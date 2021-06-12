package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.design.widget.f */
/* compiled from: DrawableUtils */
class C0263f {

    /* renamed from: a */
    private static Method f968a;

    /* renamed from: b */
    private static boolean f969b;

    /* renamed from: a */
    static boolean m1467a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return m1468b(drawableContainer, constantState);
    }

    /* renamed from: b */
    private static boolean m1468b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f969b) {
            try {
                f968a = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainer.DrawableContainerState.class});
                f968a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f969b = true;
        }
        if (f968a != null) {
            try {
                f968a.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
