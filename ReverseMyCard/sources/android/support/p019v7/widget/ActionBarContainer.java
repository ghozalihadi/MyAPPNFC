package android.support.p019v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p016v4.view.ViewCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.widget.ActionBarContainer */
public class ActionBarContainer extends FrameLayout {
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Drawable actionBarBackgroundDrawable;
        if (Build.VERSION.SDK_INT >= 21) {
            actionBarBackgroundDrawable = new ActionBarBackgroundDrawableV21(this);
        } else {
            actionBarBackgroundDrawable = new ActionBarBackgroundDrawable(this);
        }
        ViewCompat.setBackground(this, actionBarBackgroundDrawable);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0555R.styleable.ActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(C0555R.styleable.ActionBar_background);
        this.mStackedBackground = obtainStyledAttributes.getDrawable(C0555R.styleable.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(C0555R.styleable.ActionBar_height, -1);
        if (getId() == C0555R.C0557id.split_action_bar) {
            this.mIsSplit = true;
            this.mSplitBackground = obtainStyledAttributes.getDrawable(C0555R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(this.mIsSplit ? this.mSplitBackground == null : this.mBackground == null && this.mStackedBackground == null);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(C0555R.C0557id.action_bar);
        this.mContextView = findViewById(C0555R.C0557id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.mBackground != null) {
            this.mBackground.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mBackground);
        }
        this.mBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mActionBarView != null) {
                this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
            }
        }
        if (this.mIsSplit) {
            if (this.mSplitBackground != null) {
                z = false;
            }
        } else if (!(this.mBackground == null && this.mStackedBackground == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.mStackedBackground != null) {
            this.mStackedBackground.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mStackedBackground);
        }
        this.mStackedBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsStacked && this.mStackedBackground != null) {
                this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
            }
        }
        if (this.mIsSplit) {
            if (this.mSplitBackground != null) {
                z = false;
            }
        } else if (!(this.mBackground == null && this.mStackedBackground == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.mSplitBackground != null) {
            this.mSplitBackground.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mSplitBackground);
        }
        this.mSplitBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsSplit && this.mSplitBackground != null) {
                this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.mIsSplit) {
            if (this.mSplitBackground != null) {
                z = false;
            }
        } else if (!(this.mBackground == null && this.mStackedBackground == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mBackground != null) {
            this.mBackground.setVisible(z, false);
        }
        if (this.mStackedBackground != null) {
            this.mStackedBackground.setVisible(z, false);
        }
        if (this.mSplitBackground != null) {
            this.mSplitBackground.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.mBackground && !this.mIsSplit) || (drawable == this.mStackedBackground && this.mIsStacked) || ((drawable == this.mSplitBackground && this.mIsSplit) || super.verifyDrawable(drawable));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackground != null && this.mBackground.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
        if (this.mStackedBackground != null && this.mStackedBackground.isStateful()) {
            this.mStackedBackground.setState(getDrawableState());
        }
        if (this.mSplitBackground != null && this.mSplitBackground.isStateful()) {
            this.mSplitBackground.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.mBackground != null) {
                this.mBackground.jumpToCurrentState();
            }
            if (this.mStackedBackground != null) {
                this.mStackedBackground.jumpToCurrentState();
            }
            if (this.mSplitBackground != null) {
                this.mSplitBackground.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.mIsTransitioning = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mIsTransitioning || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.mTabContainer != null) {
            removeView(this.mTabContainer);
        }
        this.mTabContainer = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private boolean isCollapsed(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int getMeasuredHeightWithMargins(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        if (this.mActionBarView == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.mActionBarView != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.mTabContainer != null && this.mTabContainer.getVisibility() != 8 && mode != 1073741824) {
                if (!isCollapsed(this.mActionBarView)) {
                    i3 = getMeasuredHeightWithMargins(this.mActionBarView);
                } else if (!isCollapsed(this.mContextView)) {
                    i3 = getMeasuredHeightWithMargins(this.mContextView);
                } else {
                    i3 = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + getMeasuredHeightWithMargins(this.mTabContainer), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.mTabContainer;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.mIsSplit) {
            if (this.mBackground != null) {
                if (this.mActionBarView.getVisibility() == 0) {
                    this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
                } else if (this.mContextView == null || this.mContextView.getVisibility() != 0) {
                    this.mBackground.setBounds(0, 0, 0, 0);
                } else {
                    this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.mIsStacked = z4;
            if (!z4 || this.mStackedBackground == null) {
                z3 = z2;
            } else {
                this.mStackedBackground.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.mSplitBackground != null) {
            this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z3 = false;
        }
        if (z3) {
            invalidate();
        }
    }
}
