package android.support.p019v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.p016v4.view.PointerIconCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.widget.PopupWindowCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.view.menu.ShowableListMenu;
import android.support.p019v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.ListPopupWindow */
public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sClipToWindowEnabledMethod;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private boolean mIsAnimatedFromAnchor;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            sClipToWindowEnabledMethod = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        Class<PopupWindow> cls2 = PopupWindow.class;
        try {
            sGetMaxAvailableHeightMethod = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, C0555R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0555R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = PointerIconCompat.TYPE_HAND;
        this.mIsAnimatedFromAnchor = true;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0555R.styleable.ListPopupWindow, i, i2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(C0555R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = obtainStyledAttributes.getDimensionPixelOffset(C0555R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 11) {
            this.mPopup = new AppCompatPopupWindow(context, attributeSet, i, i2);
        } else {
            this.mPopup = new AppCompatPopupWindow(context, attributeSet, i);
        }
        this.mPopup.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int i) {
        this.mPromptPosition = i;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public void setModal(boolean z) {
        this.mModal = z;
        this.mPopup.setFocusable(z);
    }

    public boolean isModal() {
        return this.mModal;
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.mForceIgnoreOutsideTouch = z;
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.mDropDownAlwaysVisible = z;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public void setSoftInputMode(int i) {
        this.mPopup.setSoftInputMode(i);
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setAnimationStyle(int i) {
        this.mPopup.setAnimationStyle(i);
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setEpicenterBounds(Rect rect) {
        this.mEpicenterBounds = rect;
    }

    public void setDropDownGravity(int i) {
        this.mDropDownGravity = i;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public void setWidth(int i) {
        this.mDropDownWidth = i;
    }

    public void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + i;
            return;
        }
        setWidth(i);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public void setHeight(int i) {
        this.mDropDownHeight = i;
    }

    public void setWindowLayoutType(int i) {
        this.mDropDownWindowLayoutType = i;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void show() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z = true;
        boolean z2 = false;
        int i6 = -1;
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        if (this.mPopup.isShowing()) {
            if (this.mDropDownWidth == -1) {
                i2 = -1;
            } else if (this.mDropDownWidth == -2) {
                i2 = getAnchorView().getWidth();
            } else {
                i2 = this.mDropDownWidth;
            }
            if (this.mDropDownHeight == -1) {
                if (!isInputMethodNotNeeded) {
                    buildDropDown = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i5 = -1;
                    } else {
                        i5 = 0;
                    }
                    popupWindow.setWidth(i5);
                    this.mPopup.setHeight(0);
                    i3 = buildDropDown;
                } else {
                    PopupWindow popupWindow2 = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i4 = -1;
                    } else {
                        i4 = 0;
                    }
                    popupWindow2.setWidth(i4);
                    this.mPopup.setHeight(-1);
                    i3 = buildDropDown;
                }
            } else if (this.mDropDownHeight == -2) {
                i3 = buildDropDown;
            } else {
                i3 = this.mDropDownHeight;
            }
            PopupWindow popupWindow3 = this.mPopup;
            if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
                z2 = true;
            }
            popupWindow3.setOutsideTouchable(z2);
            PopupWindow popupWindow4 = this.mPopup;
            View anchorView = getAnchorView();
            int i7 = this.mDropDownHorizontalOffset;
            int i8 = this.mDropDownVerticalOffset;
            if (i2 < 0) {
                i2 = -1;
            }
            if (i3 >= 0) {
                i6 = i3;
            }
            popupWindow4.update(anchorView, i7, i8, i2, i6);
            return;
        }
        if (this.mDropDownWidth == -1) {
            i = -1;
        } else if (this.mDropDownWidth == -2) {
            i = getAnchorView().getWidth();
        } else {
            i = this.mDropDownWidth;
        }
        if (this.mDropDownHeight == -1) {
            buildDropDown = -1;
        } else if (this.mDropDownHeight != -2) {
            buildDropDown = this.mDropDownHeight;
        }
        this.mPopup.setWidth(i);
        this.mPopup.setHeight(buildDropDown);
        setPopupClipToScreenEnabled(true);
        PopupWindow popupWindow5 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            z = false;
        }
        popupWindow5.setOutsideTouchable(z);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (sSetEpicenterBoundsMethod != null) {
            try {
                sSetEpicenterBoundsMethod.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});
            } catch (Exception e) {
                Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView((View) null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    private void removePromptView() {
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    public void setInputMethodMode(int i) {
        this.mPopup.setInputMethodMode(i);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public void setSelection(int i) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i);
            if (Build.VERSION.SDK_INT >= 11 && dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i, true);
            }
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener != null) {
            DropDownListView dropDownListView = this.mDropDownList;
            View childAt = dropDownListView.getChildAt(i - dropDownListView.getFirstVisiblePosition());
            ListAdapter adapter = dropDownListView.getAdapter();
            this.mItemClickListener.onItemClick(dropDownListView, childAt, i, adapter.getItemId(i));
        }
        return true;
    }

    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    /* access modifiers changed from: package-private */
    public DropDownListView createDropDownListView(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    /* access modifiers changed from: package-private */
    public void setListItemExpandMax(int i) {
        this.mListItemExpandMaximum = i;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i))) {
            int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
            boolean z = !this.mPopup.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i3 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                if (areAllItemsEnabled) {
                    i2 = 0;
                } else {
                    i2 = this.mDropDownList.lookForSelectablePosition(0, true);
                }
                if (areAllItemsEnabled) {
                    i3 = listAdapter.getCount() - 1;
                } else {
                    i3 = this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
            }
            if ((!z || i != 19 || selectedItemPosition > i2) && (z || i != 20 || selectedItemPosition < i3)) {
                this.mDropDownList.setListSelectionHidden(false);
                if (this.mDropDownList.onKeyDown(i, keyEvent)) {
                    this.mPopup.setInputMethodMode(2);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    switch (i) {
                        case 19:
                        case 20:
                        case 23:
                        case 66:
                            return true;
                    }
                } else if (!z || i != 20) {
                    if (!z && i == 19 && selectedItemPosition == i2) {
                        return true;
                    }
                } else if (selectedItemPosition == i3) {
                    return true;
                }
            } else {
                clearListSelection();
                this.mPopup.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.mDropDownList.onKeyUp(i, keyEvent);
        if (!onKeyUp || !isConfirmKey(i)) {
            return onKeyUp;
        }
        dismiss();
        return onKeyUp;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.mDropDownAnchorView;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) {
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: android.support.v7.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: android.support.v7.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: android.support.v7.widget.DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int buildDropDown() {
        /*
            r10 = this;
            r9 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = -1
            r1 = 1
            r2 = 0
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            if (r0 != 0) goto L_0x010c
            android.content.Context r5 = r10.mContext
            android.support.v7.widget.ListPopupWindow$2 r0 = new android.support.v7.widget.ListPopupWindow$2
            r0.<init>()
            r10.mShowDropDownRunnable = r0
            boolean r0 = r10.mModal
            if (r0 != 0) goto L_0x00f8
            r0 = r1
        L_0x0019:
            android.support.v7.widget.DropDownListView r0 = r10.createDropDownListView(r5, r0)
            r10.mDropDownList = r0
            android.graphics.drawable.Drawable r0 = r10.mDropDownListHighlight
            if (r0 == 0) goto L_0x002a
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            android.graphics.drawable.Drawable r6 = r10.mDropDownListHighlight
            r0.setSelector(r6)
        L_0x002a:
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            android.widget.ListAdapter r6 = r10.mAdapter
            r0.setAdapter(r6)
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            android.widget.AdapterView$OnItemClickListener r6 = r10.mItemClickListener
            r0.setOnItemClickListener(r6)
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            r0.setFocusable(r1)
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            r0.setFocusableInTouchMode(r1)
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            android.support.v7.widget.ListPopupWindow$3 r6 = new android.support.v7.widget.ListPopupWindow$3
            r6.<init>()
            r0.setOnItemSelectedListener(r6)
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            android.support.v7.widget.ListPopupWindow$PopupScrollListener r6 = r10.mScrollListener
            r0.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r0 = r10.mItemSelectedListener
            if (r0 == 0) goto L_0x005e
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            android.widget.AdapterView$OnItemSelectedListener r6 = r10.mItemSelectedListener
            r0.setOnItemSelectedListener(r6)
        L_0x005e:
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            android.view.View r7 = r10.mPromptView
            if (r7 == 0) goto L_0x0196
            android.widget.LinearLayout r6 = new android.widget.LinearLayout
            r6.<init>(r5)
            r6.setOrientation(r1)
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r5.<init>(r3, r2, r8)
            int r8 = r10.mPromptPosition
            switch(r8) {
                case 0: goto L_0x0102;
                case 1: goto L_0x00fb;
                default: goto L_0x0078;
            }
        L_0x0078:
            java.lang.String r0 = "ListPopupWindow"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "Invalid hint position "
            java.lang.StringBuilder r5 = r5.append(r8)
            int r8 = r10.mPromptPosition
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
        L_0x0092:
            int r0 = r10.mDropDownWidth
            if (r0 < 0) goto L_0x0109
            int r0 = r10.mDropDownWidth
            r5 = r0
            r0 = r4
        L_0x009a:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            r7.measure(r0, r2)
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r7.getMeasuredHeight()
            int r7 = r0.topMargin
            int r5 = r5 + r7
            int r0 = r0.bottomMargin
            int r0 = r0 + r5
            r5 = r6
        L_0x00b2:
            android.widget.PopupWindow r6 = r10.mPopup
            r6.setContentView(r5)
            r6 = r0
        L_0x00b8:
            android.widget.PopupWindow r0 = r10.mPopup
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x012a
            android.graphics.Rect r5 = r10.mTempRect
            r0.getPadding(r5)
            android.graphics.Rect r0 = r10.mTempRect
            int r0 = r0.top
            android.graphics.Rect r5 = r10.mTempRect
            int r5 = r5.bottom
            int r0 = r0 + r5
            boolean r5 = r10.mDropDownVerticalOffsetSet
            if (r5 != 0) goto L_0x0190
            android.graphics.Rect r5 = r10.mTempRect
            int r5 = r5.top
            int r5 = -r5
            r10.mDropDownVerticalOffset = r5
            r7 = r0
        L_0x00da:
            android.widget.PopupWindow r0 = r10.mPopup
            int r0 = r0.getInputMethodMode()
            r5 = 2
            if (r0 != r5) goto L_0x0131
        L_0x00e3:
            android.view.View r0 = r10.getAnchorView()
            int r5 = r10.mDropDownVerticalOffset
            int r5 = r10.getMaxAvailableHeight(r0, r5, r1)
            boolean r0 = r10.mDropDownAlwaysVisible
            if (r0 != 0) goto L_0x00f5
            int r0 = r10.mDropDownHeight
            if (r0 != r3) goto L_0x0133
        L_0x00f5:
            int r0 = r5 + r7
        L_0x00f7:
            return r0
        L_0x00f8:
            r0 = r2
            goto L_0x0019
        L_0x00fb:
            r6.addView(r0, r5)
            r6.addView(r7)
            goto L_0x0092
        L_0x0102:
            r6.addView(r7)
            r6.addView(r0, r5)
            goto L_0x0092
        L_0x0109:
            r0 = r2
            r5 = r2
            goto L_0x009a
        L_0x010c:
            android.widget.PopupWindow r0 = r10.mPopup
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r5 = r10.mPromptView
            if (r5 == 0) goto L_0x0193
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r5.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r0 = r0 + r5
            r6 = r0
            goto L_0x00b8
        L_0x012a:
            android.graphics.Rect r0 = r10.mTempRect
            r0.setEmpty()
            r7 = r2
            goto L_0x00da
        L_0x0131:
            r1 = r2
            goto L_0x00e3
        L_0x0133:
            int r0 = r10.mDropDownWidth
            switch(r0) {
                case -2: goto L_0x015a;
                case -1: goto L_0x0175;
                default: goto L_0x0138;
            }
        L_0x0138:
            int r0 = r10.mDropDownWidth
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
        L_0x013e:
            android.support.v7.widget.DropDownListView r0 = r10.mDropDownList
            int r4 = r5 - r6
            r5 = r3
            int r0 = r0.measureHeightOfChildrenCompat(r1, r2, r3, r4, r5)
            if (r0 <= 0) goto L_0x0158
            android.support.v7.widget.DropDownListView r1 = r10.mDropDownList
            int r1 = r1.getPaddingTop()
            android.support.v7.widget.DropDownListView r2 = r10.mDropDownList
            int r2 = r2.getPaddingBottom()
            int r1 = r1 + r2
            int r1 = r1 + r7
            int r6 = r6 + r1
        L_0x0158:
            int r0 = r0 + r6
            goto L_0x00f7
        L_0x015a:
            android.content.Context r0 = r10.mContext
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.mTempRect
            int r1 = r1.left
            android.graphics.Rect r8 = r10.mTempRect
            int r8 = r8.right
            int r1 = r1 + r8
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L_0x013e
        L_0x0175:
            android.content.Context r0 = r10.mContext
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.mTempRect
            int r1 = r1.left
            android.graphics.Rect r4 = r10.mTempRect
            int r4 = r4.right
            int r1 = r1 + r4
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
            goto L_0x013e
        L_0x0190:
            r7 = r0
            goto L_0x00da
        L_0x0193:
            r6 = r2
            goto L_0x00b8
        L_0x0196:
            r5 = r0
            r0 = r2
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.widget.ListPopupWindow.buildDropDown():int");
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupDataSetObserver */
    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ListSelectorHider */
    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ResizePopupRunnable */
    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && ViewCompat.isAttachedToWindow(ListPopupWindow.this.mDropDownList) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupTouchInterceptor */
    private class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                return false;
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupScrollListener */
    private class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private static boolean isConfirmKey(int i) {
        return i == 66 || i == 23;
    }

    private void setPopupClipToScreenEnabled(boolean z) {
        if (sClipToWindowEnabledMethod != null) {
            try {
                sClipToWindowEnabledMethod.invoke(this.mPopup, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (sGetMaxAvailableHeightMethod != null) {
            try {
                return ((Integer) sGetMaxAvailableHeightMethod.invoke(this.mPopup, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.mPopup.getMaxAvailableHeight(view, i);
    }
}
