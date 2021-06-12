package android.support.p019v7.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.p019v7.content.res.AppCompatResources;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.AppCompatImageHelper */
public class AppCompatImageHelper {
    private final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r1 = android.support.p019v7.widget.TintTypedArray.obtainStyledAttributes(r6.mView.getContext(), r7, android.support.p019v7.appcompat.C0555R.styleable.AppCompatImageView, r8, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(android.util.AttributeSet r7, int r8) {
        /*
            r6 = this;
            r5 = -1
            r1 = 0
            android.widget.ImageView r0 = r6.mView     // Catch:{ all -> 0x003c }
            android.graphics.drawable.Drawable r0 = r0.getDrawable()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0031
            android.widget.ImageView r2 = r6.mView     // Catch:{ all -> 0x003c }
            android.content.Context r2 = r2.getContext()     // Catch:{ all -> 0x003c }
            int[] r3 = android.support.p019v7.appcompat.C0555R.styleable.AppCompatImageView     // Catch:{ all -> 0x003c }
            r4 = 0
            android.support.v7.widget.TintTypedArray r1 = android.support.p019v7.widget.TintTypedArray.obtainStyledAttributes(r2, r7, r3, r8, r4)     // Catch:{ all -> 0x003c }
            int r2 = android.support.p019v7.appcompat.C0555R.styleable.AppCompatImageView_srcCompat     // Catch:{ all -> 0x003c }
            r3 = -1
            int r2 = r1.getResourceId(r2, r3)     // Catch:{ all -> 0x003c }
            if (r2 == r5) goto L_0x0031
            android.widget.ImageView r0 = r6.mView     // Catch:{ all -> 0x003c }
            android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x003c }
            android.graphics.drawable.Drawable r0 = android.support.p019v7.content.res.AppCompatResources.getDrawable(r0, r2)     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0031
            android.widget.ImageView r2 = r6.mView     // Catch:{ all -> 0x003c }
            r2.setImageDrawable(r0)     // Catch:{ all -> 0x003c }
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            android.support.p019v7.widget.DrawableUtils.fixDrawable(r0)     // Catch:{ all -> 0x003c }
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.recycle()
        L_0x003b:
            return
        L_0x003c:
            r0 = move-exception
            if (r1 == 0) goto L_0x0042
            r1.recycle()
        L_0x0042:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.widget.AppCompatImageHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.mView.getContext(), i);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            this.mView.setImageDrawable(drawable);
            return;
        }
        this.mView.setImageDrawable((Drawable) null);
    }

    /* access modifiers changed from: package-private */
    public boolean hasOverlappingRendering() {
        Drawable background = this.mView.getBackground();
        if (Build.VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }
}
