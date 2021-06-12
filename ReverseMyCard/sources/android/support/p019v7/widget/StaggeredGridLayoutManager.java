package android.support.p019v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p016v4.media.TransportMediator;
import android.support.p016v4.view.accessibility.AccessibilityEventCompat;
import android.support.p016v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p016v4.view.accessibility.AccessibilityRecordCompat;
import android.support.p019v7.widget.ActivityChooserView;
import android.support.p019v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* renamed from: android.support.v7.widget.StaggeredGridLayoutManager */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLayoutManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo = new AnchorInfo();
    private final Runnable mCheckForGapsRunnable = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    };
    private int mFullSizeSpec;
    private int mGapStrategy = 2;
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout = false;
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout = false;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled = true;
    private int mSpanCount = -1;
    Span[] mSpans;
    private final Rect mTmpRect = new Rect();

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        setAutoMeasureEnabled(this.mGapStrategy == 0 ? false : z);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.mOrientation = i2;
        setSpanCount(i);
        setAutoMeasureEnabled(this.mGapStrategy == 0 ? false : z);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* access modifiers changed from: package-private */
    public boolean checkForGaps() {
        int firstChildPosition;
        int lastChildPosition;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            firstChildPosition = getLastChildPosition();
            lastChildPosition = getFirstChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
            lastChildPosition = getLastChildPosition();
        }
        if (firstChildPosition == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.mLaidOutInvalidFullSpan) {
            return false;
        } else {
            int i = this.mShouldReverseLayout ? -1 : 1;
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, lastChildPosition + 1, i, true);
            if (firstFullSpanItemInRange == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.mLazySpanLookup.forceInvalidateAfter(lastChildPosition + 1);
                return false;
            }
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, firstFullSpanItemInRange.mPosition, i * -1, true);
            if (firstFullSpanItemInRange2 == null) {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
            } else {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
        recyclerView.requestLayout();
    }

    /* access modifiers changed from: package-private */
    public View hasGapsToFix() {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        char c = (this.mOrientation != 1 || !isLayoutRTL()) ? (char) 65535 : 1;
        if (this.mShouldReverseLayout) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        for (int i3 = childCount; i3 != i; i3 += i2) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.mIndex)) {
                if (checkSpanForGap(layoutParams.mSpan)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.mSpan.mIndex);
            }
            if (!layoutParams.mFullSpan && i3 + i2 != i) {
                View childAt2 = getChildAt(i3 + i2);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd == decoratedEnd2) {
                        z = true;
                    }
                    z = false;
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart == decoratedStart2) {
                        z = true;
                    }
                    z = false;
                }
                if (!z) {
                    continue;
                } else {
                    if (layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != (c < 0)) {
                        return childAt;
                    }
                }
            }
        }
        return null;
    }

    private boolean checkSpanForGap(Span span) {
        boolean z = true;
        if (this.mShouldReverseLayout) {
            if (span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                return !span.getLayoutParams(span.mViews.get(span.mViews.size() + -1)).mFullSpan;
            }
        } else if (span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
            if (span.getLayoutParams(span.mViews.get(0)).mFullSpan) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (i != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                this.mSpans[i2] = new Span(i2);
            }
            requestLayout();
        }
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                OrientationHelper orientationHelper = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = orientationHelper;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (!(this.mPendingSavedState == null || this.mPendingSavedState.mReverseLayout == z)) {
            this.mPendingSavedState.mReverseLayout = z;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (i != this.mGapStrategy) {
            if (i == 0 || i == 2) {
                this.mGapStrategy = i;
                setAutoMeasureEnabled(this.mGapStrategy != 0);
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
            return;
        }
        if (this.mReverseLayout) {
            z = false;
        }
        this.mShouldReverseLayout = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = chooseSize(i2, paddingTop + rect.height(), getMinimumHeight());
            chooseSize = chooseSize(i, paddingRight + (this.mSizePerSpan * this.mSpanCount), getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, paddingRight + rect.width(), getMinimumWidth());
            chooseSize2 = chooseSize(i2, paddingTop + (this.mSizePerSpan * this.mSpanCount), getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onLayoutChildren(android.support.p019v7.widget.RecyclerView.Recycler r9, android.support.p019v7.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            r7 = -1
            r2 = 1
            r1 = 0
            android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo r3 = r8.mAnchorInfo
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r0 = r8.mPendingSavedState
            if (r0 != 0) goto L_0x000d
            int r0 = r8.mPendingScrollPosition
            if (r0 == r7) goto L_0x001a
        L_0x000d:
            int r0 = r10.getItemCount()
            if (r0 != 0) goto L_0x001a
            r8.removeAndRecycleAllViews(r9)
            r3.reset()
        L_0x0019:
            return
        L_0x001a:
            boolean r0 = r3.mValid
            if (r0 == 0) goto L_0x0026
            int r0 = r8.mPendingScrollPosition
            if (r0 != r7) goto L_0x0026
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r0 = r8.mPendingSavedState
            if (r0 == 0) goto L_0x0087
        L_0x0026:
            r0 = r2
        L_0x0027:
            if (r0 == 0) goto L_0x0038
            r3.reset()
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r4 = r8.mPendingSavedState
            if (r4 == 0) goto L_0x0089
            r8.applyPendingSavedState(r3)
        L_0x0033:
            r8.updateAnchorInfoForLayout(r10, r3)
            r3.mValid = r2
        L_0x0038:
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r4 = r8.mPendingSavedState
            if (r4 != 0) goto L_0x0055
            int r4 = r8.mPendingScrollPosition
            if (r4 != r7) goto L_0x0055
            boolean r4 = r3.mLayoutFromEnd
            boolean r5 = r8.mLastLayoutFromEnd
            if (r4 != r5) goto L_0x004e
            boolean r4 = r8.isLayoutRTL()
            boolean r5 = r8.mLastLayoutRTL
            if (r4 == r5) goto L_0x0055
        L_0x004e:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r8.mLazySpanLookup
            r4.clear()
            r3.mInvalidateOffsets = r2
        L_0x0055:
            int r4 = r8.getChildCount()
            if (r4 <= 0) goto L_0x00b3
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r4 = r8.mPendingSavedState
            if (r4 == 0) goto L_0x0065
            android.support.v7.widget.StaggeredGridLayoutManager$SavedState r4 = r8.mPendingSavedState
            int r4 = r4.mSpanOffsetsSize
            if (r4 >= r2) goto L_0x00b3
        L_0x0065:
            boolean r4 = r3.mInvalidateOffsets
            if (r4 == 0) goto L_0x0091
            r0 = r1
        L_0x006a:
            int r4 = r8.mSpanCount
            if (r0 >= r4) goto L_0x00b3
            android.support.v7.widget.StaggeredGridLayoutManager$Span[] r4 = r8.mSpans
            r4 = r4[r0]
            r4.clear()
            int r4 = r3.mOffset
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 == r5) goto L_0x0084
            android.support.v7.widget.StaggeredGridLayoutManager$Span[] r4 = r8.mSpans
            r4 = r4[r0]
            int r5 = r3.mOffset
            r4.setLine(r5)
        L_0x0084:
            int r0 = r0 + 1
            goto L_0x006a
        L_0x0087:
            r0 = r1
            goto L_0x0027
        L_0x0089:
            r8.resolveShouldLayoutReverse()
            boolean r4 = r8.mShouldReverseLayout
            r3.mLayoutFromEnd = r4
            goto L_0x0033
        L_0x0091:
            if (r0 != 0) goto L_0x0099
            android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r8.mAnchorInfo
            int[] r0 = r0.mSpanReferenceLines
            if (r0 != 0) goto L_0x0148
        L_0x0099:
            r0 = r1
        L_0x009a:
            int r4 = r8.mSpanCount
            if (r0 >= r4) goto L_0x00ac
            android.support.v7.widget.StaggeredGridLayoutManager$Span[] r4 = r8.mSpans
            r4 = r4[r0]
            boolean r5 = r8.mShouldReverseLayout
            int r6 = r3.mOffset
            r4.cacheReferenceLineAndClear(r5, r6)
            int r0 = r0 + 1
            goto L_0x009a
        L_0x00ac:
            android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r8.mAnchorInfo
            android.support.v7.widget.StaggeredGridLayoutManager$Span[] r4 = r8.mSpans
            r0.saveSpanReferenceLines(r4)
        L_0x00b3:
            r8.detachAndScrapAttachedViews(r9)
            android.support.v7.widget.LayoutState r0 = r8.mLayoutState
            r0.mRecycle = r1
            r8.mLaidOutInvalidFullSpan = r1
            android.support.v7.widget.OrientationHelper r0 = r8.mSecondaryOrientation
            int r0 = r0.getTotalSpace()
            r8.updateMeasureSpecs(r0)
            int r0 = r3.mPosition
            r8.updateLayoutState(r0, r10)
            boolean r0 = r3.mLayoutFromEnd
            if (r0 == 0) goto L_0x0160
            r8.setLayoutStateDirection(r7)
            android.support.v7.widget.LayoutState r0 = r8.mLayoutState
            r8.fill(r9, r0, r10)
            r8.setLayoutStateDirection(r2)
            android.support.v7.widget.LayoutState r0 = r8.mLayoutState
            int r4 = r3.mPosition
            android.support.v7.widget.LayoutState r5 = r8.mLayoutState
            int r5 = r5.mItemDirection
            int r4 = r4 + r5
            r0.mCurrentPosition = r4
            android.support.v7.widget.LayoutState r0 = r8.mLayoutState
            r8.fill(r9, r0, r10)
        L_0x00e9:
            r8.repositionToWrapContentIfNecessary()
            int r0 = r8.getChildCount()
            if (r0 <= 0) goto L_0x00fc
            boolean r0 = r8.mShouldReverseLayout
            if (r0 == 0) goto L_0x017d
            r8.fixEndGap(r9, r10, r2)
            r8.fixStartGap(r9, r10, r1)
        L_0x00fc:
            if (r11 == 0) goto L_0x0187
            boolean r0 = r10.isPreLayout()
            if (r0 != 0) goto L_0x0187
            int r0 = r8.mGapStrategy
            if (r0 == 0) goto L_0x0185
            int r0 = r8.getChildCount()
            if (r0 <= 0) goto L_0x0185
            boolean r0 = r8.mLaidOutInvalidFullSpan
            if (r0 != 0) goto L_0x0118
            android.view.View r0 = r8.hasGapsToFix()
            if (r0 == 0) goto L_0x0185
        L_0x0118:
            r0 = r2
        L_0x0119:
            if (r0 == 0) goto L_0x0187
            java.lang.Runnable r0 = r8.mCheckForGapsRunnable
            r8.removeCallbacks(r0)
            boolean r0 = r8.checkForGaps()
            if (r0 == 0) goto L_0x0187
            r0 = r2
        L_0x0127:
            boolean r2 = r10.isPreLayout()
            if (r2 == 0) goto L_0x0132
            android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo r2 = r8.mAnchorInfo
            r2.reset()
        L_0x0132:
            boolean r2 = r3.mLayoutFromEnd
            r8.mLastLayoutFromEnd = r2
            boolean r2 = r8.isLayoutRTL()
            r8.mLastLayoutRTL = r2
            if (r0 == 0) goto L_0x0019
            android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo r0 = r8.mAnchorInfo
            r0.reset()
            r8.onLayoutChildren(r9, r10, r1)
            goto L_0x0019
        L_0x0148:
            r0 = r1
        L_0x0149:
            int r4 = r8.mSpanCount
            if (r0 >= r4) goto L_0x00b3
            android.support.v7.widget.StaggeredGridLayoutManager$Span[] r4 = r8.mSpans
            r4 = r4[r0]
            r4.clear()
            android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo r5 = r8.mAnchorInfo
            int[] r5 = r5.mSpanReferenceLines
            r5 = r5[r0]
            r4.setLine(r5)
            int r0 = r0 + 1
            goto L_0x0149
        L_0x0160:
            r8.setLayoutStateDirection(r2)
            android.support.v7.widget.LayoutState r0 = r8.mLayoutState
            r8.fill(r9, r0, r10)
            r8.setLayoutStateDirection(r7)
            android.support.v7.widget.LayoutState r0 = r8.mLayoutState
            int r4 = r3.mPosition
            android.support.v7.widget.LayoutState r5 = r8.mLayoutState
            int r5 = r5.mItemDirection
            int r4 = r4 + r5
            r0.mCurrentPosition = r4
            android.support.v7.widget.LayoutState r0 = r8.mLayoutState
            r8.fill(r9, r0, r10)
            goto L_0x00e9
        L_0x017d:
            r8.fixStartGap(r9, r10, r2)
            r8.fixEndGap(r9, r10, r1)
            goto L_0x00fc
        L_0x0185:
            r0 = r1
            goto L_0x0119
        L_0x0187:
            r0 = r1
            goto L_0x0127
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.widget.StaggeredGridLayoutManager.onLayoutChildren(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, boolean):void");
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    private void repositionToWrapContentIfNecessary() {
        float f;
        float max;
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            float f2 = 0.0f;
            int childCount = getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = getChildAt(i);
                float decoratedMeasurement = (float) this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement < f2) {
                    max = f2;
                } else {
                    if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                        f = (1.0f * decoratedMeasurement) / ((float) this.mSpanCount);
                    } else {
                        f = decoratedMeasurement;
                    }
                    max = Math.max(f2, f);
                }
                i++;
                f2 = max;
            }
            int i2 = this.mSizePerSpan;
            int round = Math.round(((float) this.mSpanCount) * f2);
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
            }
            updateMeasureSpecs(round);
            if (this.mSizePerSpan != i2) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.mFullSpan) {
                        if (!isLayoutRTL() || this.mOrientation != 1) {
                            int i4 = layoutParams.mSpan.mIndex * this.mSizePerSpan;
                            int i5 = layoutParams.mSpan.mIndex * i2;
                            if (this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(i4 - i5);
                            } else {
                                childAt2.offsetTopAndBottom(i4 - i5);
                            }
                        } else {
                            childAt2.offsetLeftAndRight(((-((this.mSpanCount - 1) - layoutParams.mSpan.mIndex)) * this.mSizePerSpan) - ((-((this.mSpanCount - 1) - layoutParams.mSpan.mIndex)) * i2));
                        }
                    }
                }
            }
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        if (this.mPendingSavedState.mSpanOffsetsSize > 0) {
            if (this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount) {
                for (int i = 0; i < this.mSpanCount; i++) {
                    this.mSpans[i].clear();
                    int i2 = this.mPendingSavedState.mSpanOffsets[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.mPendingSavedState.mAnchorLayoutFromEnd) {
                            i2 += this.mPrimaryOrientation.getEndAfterPadding();
                        } else {
                            i2 += this.mPrimaryOrientation.getStartAfterPadding();
                        }
                    }
                    this.mSpans[i].setLine(i2);
                }
            } else {
                this.mPendingSavedState.invalidateSpanInfo();
                this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
            }
        }
        this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
        setReverseLayout(this.mPendingSavedState.mReverseLayout);
        resolveShouldLayoutReverse();
        if (this.mPendingSavedState.mAnchorPosition != -1) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (this.mPendingSavedState.mSpanLookupSize > 1) {
            this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
            this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = 0;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        int findFirstReferenceChildPosition;
        if (this.mLastLayoutFromEnd) {
            findFirstReferenceChildPosition = findLastReferenceChildPosition(state.getItemCount());
        } else {
            findFirstReferenceChildPosition = findFirstReferenceChildPosition(state.getItemCount());
        }
        anchorInfo.mPosition = findFirstReferenceChildPosition;
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int firstChildPosition;
        int startAfterPadding;
        boolean z = false;
        if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
            return false;
        }
        if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
        } else if (this.mPendingSavedState == null || this.mPendingSavedState.mAnchorPosition == -1 || this.mPendingSavedState.mSpanOffsetsSize < 1) {
            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
            if (findViewByPosition != null) {
                if (this.mShouldReverseLayout) {
                    firstChildPosition = getLastChildPosition();
                } else {
                    firstChildPosition = getFirstChildPosition();
                }
                anchorInfo.mPosition = firstChildPosition;
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    if (anchorInfo.mLayoutFromEnd) {
                        anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                        return true;
                    }
                    anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                    return true;
                } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                    if (anchorInfo.mLayoutFromEnd) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                    }
                    anchorInfo.mOffset = startAfterPadding;
                    return true;
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                    if (decoratedStart < 0) {
                        anchorInfo.mOffset = -decoratedStart;
                        return true;
                    }
                    int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                    if (endAfterPadding < 0) {
                        anchorInfo.mOffset = endAfterPadding;
                        return true;
                    }
                    anchorInfo.mOffset = Integer.MIN_VALUE;
                    return true;
                }
            } else {
                anchorInfo.mPosition = this.mPendingScrollPosition;
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    if (calculateScrollDirectionForPosition(anchorInfo.mPosition) == 1) {
                        z = true;
                    }
                    anchorInfo.mLayoutFromEnd = z;
                    anchorInfo.assignCoordinateFromPadding();
                } else {
                    anchorInfo.assignCoordinateFromPadding(this.mPendingScrollPositionOffset);
                }
                anchorInfo.mInvalidateOffsets = true;
                return true;
            }
        } else {
            anchorInfo.mOffset = Integer.MIN_VALUE;
            anchorInfo.mPosition = this.mPendingScrollPosition;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateMeasureSpecs(int i) {
        this.mSizePerSpan = i / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i, this.mSecondaryOrientation.getMode());
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled);
        if (this.mSmoothScrollbarEnabled) {
            z = false;
        }
        return ScrollbarHelper.computeScrollOffset(state, orientationHelper, findFirstVisibleItemClosestToStart, findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled);
        if (this.mSmoothScrollbarEnabled) {
            z = false;
        }
        return ScrollbarHelper.computeScrollExtent(state, orientationHelper, findFirstVisibleItemClosestToStart, findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    private int computeScrollRange(RecyclerView.State state) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled);
        if (this.mSmoothScrollbarEnabled) {
            z = false;
        }
        return ScrollbarHelper.computeScrollRange(state, orientationHelper, findFirstVisibleItemClosestToStart, findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
            } else {
                measureChildWithDecorationsAndMargin(view, getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), this.mFullSizeSpec, z);
            }
        } else if (this.mOrientation == 1) {
            measureChildWithDecorationsAndMargin(view, getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, layoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
        } else {
            measureChildWithDecorationsAndMargin(view, getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, layoutParams.height, false), z);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int updateSpecWithExtra = updateSpecWithExtra(i, layoutParams.leftMargin + this.mTmpRect.left, layoutParams.rightMargin + this.mTmpRect.right);
        int updateSpecWithExtra2 = updateSpecWithExtra(i2, layoutParams.topMargin + this.mTmpRect.top, layoutParams.bottomMargin + this.mTmpRect.bottom);
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int firstChildPosition;
        int startLine;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        if (this.mLazySpanLookup == null || this.mLazySpanLookup.mData == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = this.mLazySpanLookup.mData;
            savedState.mSpanLookupSize = savedState.mSpanLookup.length;
            savedState.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
        }
        if (getChildCount() > 0) {
            if (this.mLastLayoutFromEnd) {
                firstChildPosition = getLastChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
            }
            savedState.mAnchorPosition = firstChildPosition;
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            savedState.mSpanOffsetsSize = this.mSpanCount;
            savedState.mSpanOffsets = new int[this.mSpanCount];
            for (int i = 0; i < this.mSpanCount; i++) {
                if (this.mLastLayoutFromEnd) {
                    startLine = this.mSpans[i].getEndLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startLine -= this.mPrimaryOrientation.getEndAfterPadding();
                    }
                } else {
                    startLine = this.mSpans[i].getStartLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startLine -= this.mPrimaryOrientation.getStartAfterPadding();
                    }
                }
                savedState.mSpanOffsets[i] = startLine;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.mFullSpan ? this.mSpanCount : 1, -1, -1, layoutParams2.mFullSpan, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.mFullSpan ? this.mSpanCount : 1, layoutParams2.mFullSpan, false));
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    asRecord.setFromIndex(position);
                    asRecord.setToIndex(position2);
                    return;
                }
                asRecord.setFromIndex(position2);
                asRecord.setToIndex(position);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int findFirstVisibleItemPositionInt() {
        View findFirstVisibleItemClosestToStart;
        if (this.mShouldReverseLayout) {
            findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToEnd(true);
        } else {
            findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(true);
        }
        if (findFirstVisibleItemClosestToStart == null) {
            return -1;
        }
        return getPosition(findFirstVisibleItemClosestToStart);
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleItemClosestToStart(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleItemClosestToEnd(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.mPrimaryOrientation.offsetChildren(i);
            }
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int minStart = getMinStart(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    private void updateLayoutState(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int targetScrollPosition;
        boolean z = false;
        this.mLayoutState.mAvailable = 0;
        this.mLayoutState.mCurrentPosition = i;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            i2 = 0;
            i3 = 0;
        } else {
            if (this.mShouldReverseLayout == (targetScrollPosition < i)) {
                i2 = this.mPrimaryOrientation.getTotalSpace();
                i3 = 0;
            } else {
                i3 = this.mPrimaryOrientation.getTotalSpace();
                i2 = 0;
            }
        }
        if (getClipToPadding()) {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i3;
            this.mLayoutState.mEndLine = i2 + this.mPrimaryOrientation.getEndAfterPadding();
        } else {
            this.mLayoutState.mEndLine = i2 + this.mPrimaryOrientation.getEnd();
            this.mLayoutState.mStartLine = -i3;
        }
        this.mLayoutState.mStopInFocusable = false;
        this.mLayoutState.mRecycle = true;
        LayoutState layoutState = this.mLayoutState;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z = true;
        }
        layoutState.mInfinite = z;
    }

    private void setLayoutStateDirection(int i) {
        int i2 = 1;
        this.mLayoutState.mLayoutDirection = i;
        LayoutState layoutState = this.mLayoutState;
        if (this.mShouldReverseLayout != (i == -1)) {
            i2 = -1;
        }
        layoutState.mItemDirection = i2;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    private void handleUpdate(int i, int i2, int i3) {
        int i4;
        int i5;
        int lastChildPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.mLazySpanLookup.invalidateAfter(i5);
        switch (i3) {
            case 1:
                this.mLazySpanLookup.offsetForAddition(i, i2);
                break;
            case 2:
                this.mLazySpanLookup.offsetForRemoval(i, i2);
                break;
            case 8:
                this.mLazySpanLookup.offsetForRemoval(i, 1);
                this.mLazySpanLookup.offsetForAddition(i2, 1);
                break;
        }
        if (i4 > lastChildPosition) {
            if (i5 <= (this.mShouldReverseLayout ? getFirstChildPosition() : getLastChildPosition())) {
                requestLayout();
            }
        }
    }

    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i;
        int startAfterPadding;
        int maxEnd;
        Span span;
        int startLine;
        int decoratedMeasurement;
        int i2;
        int startAfterPadding2;
        int decoratedMeasurement2;
        int i3;
        int endAfterPadding;
        boolean z;
        int endLine;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite) {
            if (layoutState.mLayoutDirection == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (layoutState.mLayoutDirection == 1) {
            i = layoutState.mEndLine + layoutState.mAvailable;
        } else {
            i = layoutState.mStartLine - layoutState.mAvailable;
        }
        updateAllRemainingSpans(layoutState.mLayoutDirection, i);
        if (this.mShouldReverseLayout) {
            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        } else {
            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        }
        boolean z2 = false;
        while (layoutState.hasMore(state) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty())) {
            View next = layoutState.next(recycler);
            LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int span2 = this.mLazySpanLookup.getSpan(viewLayoutPosition);
            boolean z3 = span2 == -1;
            if (z3) {
                Span nextSpan = layoutParams.mFullSpan ? this.mSpans[0] : getNextSpan(layoutState);
                this.mLazySpanLookup.setSpan(viewLayoutPosition, nextSpan);
                span = nextSpan;
            } else {
                span = this.mSpans[span2];
            }
            layoutParams.mSpan = span;
            if (layoutState.mLayoutDirection == 1) {
                addView(next);
            } else {
                addView(next, 0);
            }
            measureChildWithDecorationsAndMargin(next, layoutParams, false);
            if (layoutState.mLayoutDirection == 1) {
                if (layoutParams.mFullSpan) {
                    endLine = getMaxEnd(startAfterPadding);
                } else {
                    endLine = span.getEndLine(startAfterPadding);
                }
                i2 = endLine + this.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (!z3 || !layoutParams.mFullSpan) {
                    decoratedMeasurement = endLine;
                } else {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromEnd = createFullSpanItemFromEnd(endLine);
                    createFullSpanItemFromEnd.mGapDir = -1;
                    createFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                    decoratedMeasurement = endLine;
                }
            } else {
                if (layoutParams.mFullSpan) {
                    startLine = getMinStart(startAfterPadding);
                } else {
                    startLine = span.getStartLine(startAfterPadding);
                }
                decoratedMeasurement = startLine - this.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (z3 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromStart = createFullSpanItemFromStart(startLine);
                    createFullSpanItemFromStart.mGapDir = 1;
                    createFullSpanItemFromStart.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromStart);
                }
                i2 = startLine;
            }
            if (layoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                if (z3) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    if (layoutState.mLayoutDirection == 1) {
                        z = !areAllEndsEqual();
                    } else {
                        z = !areAllStartsEqual();
                    }
                    if (z) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            attachViewToSpans(next, layoutParams, layoutState);
            if (!isLayoutRTL() || this.mOrientation != 1) {
                if (layoutParams.mFullSpan) {
                    startAfterPadding2 = this.mSecondaryOrientation.getStartAfterPadding();
                } else {
                    startAfterPadding2 = (span.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                }
                decoratedMeasurement2 = startAfterPadding2 + this.mSecondaryOrientation.getDecoratedMeasurement(next);
                i3 = startAfterPadding2;
            } else {
                if (layoutParams.mFullSpan) {
                    endAfterPadding = this.mSecondaryOrientation.getEndAfterPadding();
                } else {
                    endAfterPadding = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - span.mIndex) * this.mSizePerSpan);
                }
                i3 = endAfterPadding - this.mSecondaryOrientation.getDecoratedMeasurement(next);
                decoratedMeasurement2 = endAfterPadding;
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(next, i3, decoratedMeasurement, decoratedMeasurement2, i2);
            } else {
                layoutDecoratedWithMargins(next, decoratedMeasurement, i3, i2, decoratedMeasurement2);
            }
            if (layoutParams.mFullSpan) {
                updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i);
            } else {
                updateRemainingSpans(span, this.mLayoutState.mLayoutDirection, i);
            }
            recycle(recycler, this.mLayoutState);
            if (this.mLayoutState.mStopInFocusable && next.isFocusable()) {
                if (layoutParams.mFullSpan) {
                    this.mRemainingSpans.clear();
                } else {
                    this.mRemainingSpans.set(span.mIndex, false);
                }
            }
            z2 = true;
        }
        if (!z2) {
            recycle(recycler, this.mLayoutState);
        }
        if (this.mLayoutState.mLayoutDirection == -1) {
            maxEnd = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            maxEnd = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (maxEnd > 0) {
            return Math.min(layoutState.mAvailable, maxEnd);
        }
        return 0;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            fullSpanItem.mGapPerSpan[i2] = i - this.mSpans[i2].getEndLine(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            fullSpanItem.mGapPerSpan[i2] = this.mSpans[i2].getStartLine(i) - i;
        }
        return fullSpanItem;
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan) {
                appendViewToAllSpans(view);
            } else {
                layoutParams.mSpan.appendToSpan(view);
            }
        } else if (layoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    private void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int min;
        int min2;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable == 0) {
                if (layoutState.mLayoutDirection == -1) {
                    recycleFromEnd(recycler, layoutState.mEndLine);
                } else {
                    recycleFromStart(recycler, layoutState.mStartLine);
                }
            } else if (layoutState.mLayoutDirection == -1) {
                int maxStart = layoutState.mStartLine - getMaxStart(layoutState.mStartLine);
                if (maxStart < 0) {
                    min2 = layoutState.mEndLine;
                } else {
                    min2 = layoutState.mEndLine - Math.min(maxStart, layoutState.mAvailable);
                }
                recycleFromEnd(recycler, min2);
            } else {
                int minEnd = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
                if (minEnd < 0) {
                    min = layoutState.mStartLine;
                } else {
                    min = Math.min(minEnd, layoutState.mAvailable) + layoutState.mStartLine;
                }
                recycleFromStart(recycler, min);
            }
        }
    }

    private void appendViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].appendToSpan(view);
        }
    }

    private void prependViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].prependToSpan(view);
        }
    }

    private void updateAllRemainingSpans(int i, int i2) {
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2);
            }
        }
    }

    private void updateRemainingSpans(Span span, int i, int i2) {
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (deletedSize + span.getStartLine() <= i2) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        } else if (span.getEndLine() - deletedSize >= i2) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    private int getMaxStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    /* access modifiers changed from: package-private */
    public boolean areAllEndsEqual() {
        int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.mSpans[i].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean areAllStartsEqual() {
        int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.mSpans[i].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
    }

    private int getMaxEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i2 = 0;
                    while (i2 < this.mSpanCount) {
                        if (this.mSpans[i2].mViews.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                        this.mSpans[i3].popStart();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popStart();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i2 = 0;
                    while (i2 < this.mSpanCount) {
                        if (this.mSpans[i2].mViews.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                        this.mSpans[i3].popEnd();
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popEnd();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean preferLastSpan(int i) {
        boolean z;
        if (this.mOrientation == 0) {
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.mShouldReverseLayout) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.mShouldReverseLayout) != isLayoutRTL()) {
            return false;
        }
        return true;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i;
        int i2;
        Span span;
        Span span2;
        Span span3 = null;
        int i3 = -1;
        if (preferLastSpan(layoutState.mLayoutDirection)) {
            i = this.mSpanCount - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.mSpanCount;
            i3 = 1;
        }
        if (layoutState.mLayoutDirection == 1) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int i4 = i;
            int i5 = Integer.MAX_VALUE;
            while (i4 != i2) {
                Span span4 = this.mSpans[i4];
                int endLine = span4.getEndLine(startAfterPadding);
                if (endLine < i5) {
                    span2 = span4;
                } else {
                    endLine = i5;
                    span2 = span3;
                }
                i4 += i3;
                span3 = span2;
                i5 = endLine;
            }
        } else {
            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
            int i6 = i;
            int i7 = Integer.MIN_VALUE;
            while (i6 != i2) {
                Span span5 = this.mSpans[i6];
                int startLine = span5.getStartLine(endAfterPadding);
                if (startLine > i7) {
                    span = span5;
                } else {
                    startLine = i7;
                    span = span3;
                }
                i6 += i3;
                span3 = span;
                i7 = startLine;
            }
        }
        return span3;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    private int calculateScrollDirectionForPosition(int i) {
        int i2 = -1;
        if (getChildCount() != 0) {
            if ((i < getFirstChildPosition()) == this.mShouldReverseLayout) {
                i2 = 1;
            }
            return i2;
        } else if (this.mShouldReverseLayout) {
            return 1;
        } else {
            return -1;
        }
    }

    public PointF computeScrollVectorForPosition(int i) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = (float) calculateScrollDirectionForPosition;
        return pointF;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public void scrollToPosition(int i) {
        if (!(this.mPendingSavedState == null || this.mPendingSavedState.mAnchorPosition == i)) {
            this.mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public int getItemPrefetchCount() {
        return this.mSpanCount;
    }

    /* access modifiers changed from: package-private */
    public int gatherPrefetchIndices(int i, int i2, RecyclerView.State state, int[] iArr) {
        int i3 = 0;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (!(getChildCount() == 0 || i == 0)) {
            prepareLayoutStateForDelta(i, state);
            int i4 = this.mSpanCount;
            while (i3 < this.mSpanCount && this.mLayoutState.hasMore(state) && i4 > 0) {
                iArr[i3] = this.mLayoutState.mCurrentPosition;
                i4--;
                this.mLayoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
                i3++;
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public void prepareLayoutStateForDelta(int i, RecyclerView.State state) {
        int i2;
        int firstChildPosition;
        if (i > 0) {
            firstChildPosition = getLastChildPosition();
            i2 = 1;
        } else {
            i2 = -1;
            firstChildPosition = getFirstChildPosition();
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(firstChildPosition, state);
        setLayoutStateDirection(i2);
        this.mLayoutState.mCurrentPosition = this.mLayoutState.mItemDirection + firstChildPosition;
        this.mLayoutState.mAvailable = Math.abs(i);
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i, state);
        int fill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.mAvailable >= fill) {
            i = i < 0 ? -fill : fill;
        }
        this.mPrimaryOrientation.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        this.mLayoutState.mAvailable = 0;
        recycle(recycler, this.mLayoutState);
        return i;
    }

    private int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    private int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int findFirstReferenceChildPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int firstChildPosition;
        View focusableViewAfter;
        if (getChildCount() == 0) {
            return null;
        }
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.mFullSpan;
        Span span = layoutParams.mSpan;
        if (convertFocusDirectionToLayoutDirection == 1) {
            firstChildPosition = getLastChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
        }
        updateLayoutState(firstChildPosition, state);
        setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
        this.mLayoutState.mCurrentPosition = this.mLayoutState.mItemDirection + firstChildPosition;
        this.mLayoutState.mAvailable = (int) (MAX_SCROLL_FACTOR * ((float) this.mPrimaryOrientation.getTotalSpace()));
        this.mLayoutState.mStopInFocusable = true;
        this.mLayoutState.mRecycle = false;
        fill(recycler, this.mLayoutState, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z && (focusableViewAfter = span.getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != findContainingItemView) {
            return focusableViewAfter;
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i2 = this.mSpanCount - 1; i2 >= 0; i2--) {
                View focusableViewAfter2 = this.mSpans[i2].getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                View focusableViewAfter3 = this.mSpans[i3].getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        return null;
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                if (this.mOrientation == 1 || !isLayoutRTL()) {
                    return -1;
                }
                return 1;
            case 2:
                if (this.mOrientation == 1) {
                    return 1;
                }
                if (!isLayoutRTL()) {
                    return 1;
                }
                return -1;
            case 17:
                if (this.mOrientation != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.mOrientation != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                if (this.mOrientation != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case TransportMediator.KEYCODE_MEDIA_RECORD:
                if (this.mOrientation == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void setFullSpan(boolean z) {
            this.mFullSpan = z;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public final int getSpanIndex() {
            if (this.mSpan == null) {
                return -1;
            }
            return this.mSpan.mIndex;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$Span */
    class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd = Integer.MIN_VALUE;
        int mCachedStart = Integer.MIN_VALUE;
        int mDeletedSize = 0;
        final int mIndex;
        ArrayList<View> mViews = new ArrayList<>();

        Span(int i) {
            this.mIndex = i;
        }

        /* access modifiers changed from: package-private */
        public int getStartLine(int i) {
            if (this.mCachedStart != Integer.MIN_VALUE) {
                return this.mCachedStart;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        /* access modifiers changed from: package-private */
        public void calculateCachedStart() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
                this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        /* access modifiers changed from: package-private */
        public int getStartLine() {
            if (this.mCachedStart != Integer.MIN_VALUE) {
                return this.mCachedStart;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        /* access modifiers changed from: package-private */
        public int getEndLine(int i) {
            if (this.mCachedEnd != Integer.MIN_VALUE) {
                return this.mCachedEnd;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        /* access modifiers changed from: package-private */
        public void calculateCachedEnd() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.mViews.get(this.mViews.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
                this.mCachedEnd = fullSpanItem.getGapForSpan(this.mIndex) + this.mCachedEnd;
            }
        }

        /* access modifiers changed from: package-private */
        public int getEndLine() {
            if (this.mCachedEnd != Integer.MIN_VALUE) {
                return this.mCachedEnd;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        /* access modifiers changed from: package-private */
        public void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void cacheReferenceLineAndClear(boolean z, int i) {
            int startLine;
            if (z) {
                startLine = getEndLine(Integer.MIN_VALUE);
            } else {
                startLine = getStartLine(Integer.MIN_VALUE);
            }
            clear();
            if (startLine != Integer.MIN_VALUE) {
                if (z && startLine < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                    return;
                }
                if (z || startLine <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    if (i != Integer.MIN_VALUE) {
                        startLine += i;
                    }
                    this.mCachedEnd = startLine;
                    this.mCachedStart = startLine;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        /* access modifiers changed from: package-private */
        public void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void setLine(int i) {
            this.mCachedStart = i;
            this.mCachedEnd = i;
        }

        /* access modifiers changed from: package-private */
        public void popEnd() {
            int size = this.mViews.size();
            View remove = this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void popStart() {
            View remove = this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        /* access modifiers changed from: package-private */
        public LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public void onOffset(int i) {
            if (this.mCachedStart != Integer.MIN_VALUE) {
                this.mCachedStart += i;
            }
            if (this.mCachedEnd != Integer.MIN_VALUE) {
                this.mCachedEnd += i;
            }
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, false);
            }
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), false);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), true);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        public int findOneVisibleChild(int i, int i2, boolean z) {
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.mViews.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                    if (!z) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public View getFocusableViewAfter(int i, int i2) {
            boolean z;
            boolean z2;
            View view = null;
            if (i2 == -1) {
                int size = this.mViews.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.mViews.get(i3);
                    if (view2.isFocusable()) {
                        if (StaggeredGridLayoutManager.this.getPosition(view2) > i) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 != StaggeredGridLayoutManager.this.mReverseLayout) {
                            break;
                        }
                        i3++;
                        view = view2;
                    } else {
                        break;
                    }
                }
                return view;
            }
            int size2 = this.mViews.size() - 1;
            while (size2 >= 0) {
                View view3 = this.mViews.get(size2);
                if (view3.isFocusable()) {
                    if (StaggeredGridLayoutManager.this.getPosition(view3) > i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != (!StaggeredGridLayoutManager.this.mReverseLayout)) {
                        break;
                    }
                    size2--;
                    view = view3;
                } else {
                    break;
                }
            }
            return view;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup */
    static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        LazySpanLookup() {
        }

        /* access modifiers changed from: package-private */
        public int forceInvalidateAfter(int i) {
            if (this.mFullSpanItems != null) {
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    if (this.mFullSpanItems.get(size).mPosition >= i) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i);
        }

        /* access modifiers changed from: package-private */
        public int invalidateAfter(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            int invalidateFullSpansAfter = invalidateFullSpansAfter(i);
            if (invalidateFullSpansAfter == -1) {
                Arrays.fill(this.mData, i, this.mData.length, -1);
                return this.mData.length;
            }
            Arrays.fill(this.mData, i, invalidateFullSpansAfter + 1, -1);
            return invalidateFullSpansAfter + 1;
        }

        /* access modifiers changed from: package-private */
        public int getSpan(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            return this.mData[i];
        }

        /* access modifiers changed from: package-private */
        public void setSpan(int i, Span span) {
            ensureSize(i);
            this.mData[i] = span.mIndex;
        }

        /* access modifiers changed from: package-private */
        public int sizeForPosition(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        public void ensureSize(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                int[] iArr = this.mData;
                this.mData = new int[sizeForPosition(i)];
                System.arraycopy(iArr, 0, this.mData, 0, iArr.length);
                Arrays.fill(this.mData, iArr.length, this.mData.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.mFullSpanItems = null;
        }

        /* access modifiers changed from: package-private */
        public void offsetForRemoval(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                ensureSize(i + i2);
                System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                offsetFullSpansForRemoval(i, i2);
            }
        }

        private void offsetFullSpansForRemoval(int i, int i2) {
            if (this.mFullSpanItems != null) {
                int i3 = i + i2;
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.mFullSpanItems.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetForAddition(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                ensureSize(i + i2);
                System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                offsetFullSpansForAddition(i, i2);
            }
        }

        private void offsetFullSpansForAddition(int i, int i2) {
            if (this.mFullSpanItems != null) {
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        private int invalidateFullSpansAfter(int i) {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int size = this.mFullSpanItems.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.mFullSpanItems.get(i2).mPosition >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.mFullSpanItems.remove(i2);
            return this.mFullSpanItems.get(i2).mPosition;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        public FullSpanItem getFullSpanItem(int i) {
            if (this.mFullSpanItems == null) {
                return null;
            }
            for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            if (this.mFullSpanItems == null) {
                return null;
            }
            int size = this.mFullSpanItems.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i) {
                    if (i3 == 0 || fullSpanItem.mGapDir == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.mHasUnwantedGapAfter) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem */
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() != 1 ? false : z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.mGapPerSpan = new int[readInt];
                    parcel.readIntArray(this.mGapPerSpan);
                }
            }

            public FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            public int getGapForSpan(int i) {
                if (this.mGapPerSpan == null) {
                    return 0;
                }
                return this.mGapPerSpan[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                if (this.mGapPerSpan == null || this.mGapPerSpan.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.mGapPerSpan.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$SavedState */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            this.mSpanOffsetsSize = parcel.readInt();
            if (this.mSpanOffsetsSize > 0) {
                this.mSpanOffsets = new int[this.mSpanOffsetsSize];
                parcel.readIntArray(this.mSpanOffsets);
            }
            this.mSpanLookupSize = parcel.readInt();
            if (this.mSpanLookupSize > 0) {
                this.mSpanLookup = new int[this.mSpanLookupSize];
                parcel.readIntArray(this.mSpanLookup);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.mAnchorLayoutFromEnd = z;
            this.mLastLayoutRTL = parcel.readInt() != 1 ? false : z2;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        /* access modifiers changed from: package-private */
        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3;
            int i4 = 1;
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            if (this.mReverseLayout) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.mAnchorLayoutFromEnd) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            if (!this.mLastLayoutRTL) {
                i4 = 0;
            }
            parcel.writeInt(i4);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$AnchorInfo */
    class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;

        public AnchorInfo() {
            reset();
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            if (this.mSpanReferenceLines != null) {
                Arrays.fill(this.mSpanReferenceLines, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void saveSpanReferenceLines(Span[] spanArr) {
            int length = spanArr.length;
            if (this.mSpanReferenceLines == null || this.mSpanReferenceLines.length < length) {
                this.mSpanReferenceLines = new int[StaggeredGridLayoutManager.this.mSpans.length];
            }
            for (int i = 0; i < length; i++) {
                this.mSpanReferenceLines[i] = spanArr[i].getStartLine(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void assignCoordinateFromPadding() {
            int startAfterPadding;
            if (this.mLayoutFromEnd) {
                startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            }
            this.mOffset = startAfterPadding;
        }

        /* access modifiers changed from: package-private */
        public void assignCoordinateFromPadding(int i) {
            if (this.mLayoutFromEnd) {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i;
            }
        }
    }
}
