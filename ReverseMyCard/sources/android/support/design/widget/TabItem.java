package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.p019v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {

    /* renamed from: a */
    final CharSequence f780a;

    /* renamed from: b */
    final Drawable f781b;

    /* renamed from: c */
    final int f782c;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TabItem);
        this.f780a = obtainStyledAttributes.getText(R.styleable.TabItem_android_text);
        this.f781b = obtainStyledAttributes.getDrawable(R.styleable.TabItem_android_icon);
        this.f782c = obtainStyledAttributes.getResourceId(R.styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
