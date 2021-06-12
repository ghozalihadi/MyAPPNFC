package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: android.support.design.widget.w */
/* compiled from: ViewGroupUtilsHoneycomb */
class C0311w {

    /* renamed from: a */
    private static final ThreadLocal<Matrix> f1081a = new ThreadLocal<>();

    /* renamed from: b */
    private static final ThreadLocal<RectF> f1082b = new ThreadLocal<>();

    /* renamed from: a */
    public static void m1681a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = f1081a.get();
        if (matrix2 == null) {
            Matrix matrix3 = new Matrix();
            f1081a.set(matrix3);
            matrix = matrix3;
        } else {
            matrix2.reset();
            matrix = matrix2;
        }
        m1682a((ViewParent) viewGroup, view, matrix);
        RectF rectF = f1082b.get();
        if (rectF == null) {
            rectF = new RectF();
            f1082b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    static void m1682a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m1682a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
