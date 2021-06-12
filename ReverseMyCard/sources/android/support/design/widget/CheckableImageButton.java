package android.support.design.widget;

import android.content.Context;
import android.support.p016v4.view.AccessibilityDelegateCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: a */
    private static final int[] f627a = {16842912};

    /* renamed from: b */
    private boolean f628b;

    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0555R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(true);
                accessibilityNodeInfoCompat.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public void setChecked(boolean z) {
        if (this.f628b != z) {
            this.f628b = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.f628b;
    }

    public void toggle() {
        setChecked(!this.f628b);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.f628b) {
            return mergeDrawableStates(super.onCreateDrawableState(f627a.length + i), f627a);
        }
        return super.onCreateDrawableState(i);
    }
}
