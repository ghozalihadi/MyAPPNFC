package android.support.p019v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.p016v4.animation.AnimatorCompatHelper;
import android.support.p016v4.animation.AnimatorListenerCompat;
import android.support.p016v4.animation.AnimatorUpdateListenerCompat;
import android.support.p016v4.animation.ValueAnimatorCompat;
import android.support.p016v4.view.GestureDetectorCompat;
import android.support.p016v4.view.MotionEventCompat;
import android.support.p016v4.view.VelocityTrackerCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p019v7.recyclerview.C0559R;
import android.support.p019v7.widget.RecyclerView;
import android.support.p019v7.widget.helper.ItemTouchUIUtilImpl;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.helper.ItemTouchHelper */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    static final String TAG = "ItemTouchHelper";

    /* renamed from: UP */
    public static final int f1227UP = 1;
    int mActionState = 0;
    int mActivePointerId = -1;
    Callback mCallback;
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    float mMaxSwipeVelocity;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation findAnimation;
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                if (ItemTouchHelper.this.mSelected == null && (findAnimation = ItemTouchHelper.this.findAnimation(motionEvent)) != null) {
                    ItemTouchHelper.this.mInitialTouchX -= findAnimation.f1228mX;
                    ItemTouchHelper.this.mInitialTouchY -= findAnimation.f1229mY;
                    ItemTouchHelper.this.endRecoverAnimation(findAnimation.mViewHolder, true);
                    if (ItemTouchHelper.this.mPendingCleanup.remove(findAnimation.mViewHolder.itemView)) {
                        ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, findAnimation.mViewHolder);
                    }
                    ItemTouchHelper.this.select(findAnimation.mViewHolder, findAnimation.mActionState);
                    ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper.this.mActivePointerId = -1;
                ItemTouchHelper.this.select((RecyclerView.ViewHolder) null, 0);
            } else if (ItemTouchHelper.this.mActivePointerId != -1 && (findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId)) >= 0) {
                ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
            }
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mSelected != null) {
                return true;
            }
            return false;
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int i = 0;
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId != -1) {
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.mSelected;
                if (viewHolder != null) {
                    switch (actionMasked) {
                        case 1:
                            break;
                        case 2:
                            if (findPointerIndex >= 0) {
                                ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, findPointerIndex);
                                ItemTouchHelper.this.moveIfNecessary(viewHolder);
                                ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                                ItemTouchHelper.this.mScrollRunnable.run();
                                ItemTouchHelper.this.mRecyclerView.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (ItemTouchHelper.this.mVelocityTracker != null) {
                                ItemTouchHelper.this.mVelocityTracker.clear();
                                break;
                            }
                            break;
                        case 6:
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.mActivePointerId) {
                                if (actionIndex == 0) {
                                    i = 1;
                                }
                                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(i);
                                ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, actionIndex);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    ItemTouchHelper.this.select((RecyclerView.ViewHolder) null, 0);
                    ItemTouchHelper.this.mActivePointerId = -1;
                }
            }
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.select((RecyclerView.ViewHolder) null, 0);
            }
        }
    };
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    final List<View> mPendingCleanup = new ArrayList();
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable = new Runnable() {
        public void run() {
            if (ItemTouchHelper.this.mSelected != null && ItemTouchHelper.this.scrollIfNecessary()) {
                if (ItemTouchHelper.this.mSelected != null) {
                    ItemTouchHelper.this.moveIfNecessary(ItemTouchHelper.this.mSelected);
                }
                ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
            }
        }
    };
    RecyclerView.ViewHolder mSelected = null;
    int mSelectedFlags;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    float mSwipeEscapeVelocity;
    private final float[] mTmpPosition = new float[2];
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$ViewDropHandler */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public ItemTouchHelper(Callback callback) {
        this.mCallback = callback;
    }

    private static boolean hitTest(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        if (this.mRecyclerView != recyclerView) {
            if (this.mRecyclerView != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.mSwipeEscapeVelocity = resources.getDimension(C0559R.dimen.item_touch_helper_swipe_escape_velocity);
                this.mMaxSwipeVelocity = resources.getDimension(C0559R.dimen.item_touch_helper_swipe_escape_max_velocity);
                setupCallbacks();
            }
        }
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        initGestureDetector();
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
    }

    private void initGestureDetector() {
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), new ItemTouchHelperGestureListener());
        }
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - ((float) this.mSelected.itemView.getLeft());
        } else {
            fArr[0] = ViewCompat.getTranslationX(this.mSelected.itemView);
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - ((float) this.mSelected.itemView.getTop());
        } else {
            fArr[1] = ViewCompat.getTranslationY(this.mSelected.itemView);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = 0.0f;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            f = this.mTmpPosition[0];
            f2 = this.mTmpPosition[1];
        } else {
            f = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2 = 0.0f;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            f = this.mTmpPosition[0];
            f2 = this.mTmpPosition[1];
        } else {
            f = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
    }

    /* access modifiers changed from: package-private */
    public void select(RecyclerView.ViewHolder viewHolder, int i) {
        final int swipeIfNecessary;
        float f;
        float signum;
        int i2;
        if (viewHolder != this.mSelected || i != this.mActionState) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            int i3 = this.mActionState;
            endRecoverAnimation(viewHolder, true);
            this.mActionState = i;
            if (i == 2) {
                this.mOverdrawChild = viewHolder.itemView;
                addChildDrawingOrderCallback();
            }
            int i4 = (1 << ((i * 8) + 8)) - 1;
            boolean z = false;
            if (this.mSelected != null) {
                RecyclerView.ViewHolder viewHolder2 = this.mSelected;
                if (viewHolder2.itemView.getParent() != null) {
                    if (i3 == 2) {
                        swipeIfNecessary = 0;
                    } else {
                        swipeIfNecessary = swipeIfNecessary(viewHolder2);
                    }
                    releaseVelocityTracker();
                    switch (swipeIfNecessary) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.mDy) * ((float) this.mRecyclerView.getHeight());
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.mDx) * ((float) this.mRecyclerView.getWidth());
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    if (i3 == 2) {
                        i2 = 8;
                    } else if (swipeIfNecessary > 0) {
                        i2 = 2;
                    } else {
                        i2 = 4;
                    }
                    getSelectedDxDy(this.mTmpPosition);
                    float f2 = this.mTmpPosition[0];
                    float f3 = this.mTmpPosition[1];
                    final RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                    C06503 r0 = new RecoverAnimation(viewHolder2, i2, i3, f2, f3, f, signum) {
                        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
                            super.onAnimationEnd(valueAnimatorCompat);
                            if (!this.mOverridden) {
                                if (swipeIfNecessary <= 0) {
                                    ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, viewHolder3);
                                } else {
                                    ItemTouchHelper.this.mPendingCleanup.add(viewHolder3.itemView);
                                    this.mIsPendingCleanup = true;
                                    if (swipeIfNecessary > 0) {
                                        ItemTouchHelper.this.postDispatchSwipe(this, swipeIfNecessary);
                                    }
                                }
                                if (ItemTouchHelper.this.mOverdrawChild == viewHolder3.itemView) {
                                    ItemTouchHelper.this.removeChildDrawingOrderCallbackIfNecessary(viewHolder3.itemView);
                                }
                            }
                        }
                    };
                    r0.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i2, f - f2, signum - f3));
                    this.mRecoverAnimations.add(r0);
                    r0.start();
                    z = true;
                } else {
                    removeChildDrawingOrderCallbackIfNecessary(viewHolder2.itemView);
                    this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                }
                this.mSelected = null;
            }
            boolean z2 = z;
            if (viewHolder != null) {
                this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder) & i4) >> (this.mActionState * 8);
                this.mSelectedStartX = (float) viewHolder.itemView.getLeft();
                this.mSelectedStartY = (float) viewHolder.itemView.getTop();
                this.mSelected = viewHolder;
                if (i == 2) {
                    this.mSelected.itemView.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.mRecyclerView.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.mSelected != null);
            }
            if (!z2) {
                this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
            }
            this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
            this.mRecyclerView.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i) {
        this.mRecyclerView.post(new Runnable() {
            public void run() {
                if (ItemTouchHelper.this.mRecyclerView != null && ItemTouchHelper.this.mRecyclerView.isAttachedToWindow() && !recoverAnimation.mOverridden && recoverAnimation.mViewHolder.getAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                        ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i);
                    } else {
                        ItemTouchHelper.this.mRecyclerView.post(this);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i = 0; i < size; i++) {
            if (!this.mRecoverAnimations.get(i).mEnded) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r4 < 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        if (r8 < 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e4, code lost:
        if (r4 > 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010c, code lost:
        if (r8 > 0) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scrollIfNecessary() {
        /*
            r14 = this;
            r12 = -9223372036854775808
            r0 = 0
            r5 = 0
            android.support.v7.widget.RecyclerView$ViewHolder r1 = r14.mSelected
            if (r1 != 0) goto L_0x000b
            r14.mDragScrollStartTimeInMs = r12
        L_0x000a:
            return r0
        L_0x000b:
            long r10 = java.lang.System.currentTimeMillis()
            long r2 = r14.mDragScrollStartTimeInMs
            int r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x00bb
            r6 = 0
        L_0x0017:
            android.support.v7.widget.RecyclerView r1 = r14.mRecyclerView
            android.support.v7.widget.RecyclerView$LayoutManager r1 = r1.getLayoutManager()
            android.graphics.Rect r2 = r14.mTmpRect
            if (r2 != 0) goto L_0x0028
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r14.mTmpRect = r2
        L_0x0028:
            android.support.v7.widget.RecyclerView$ViewHolder r2 = r14.mSelected
            android.view.View r2 = r2.itemView
            android.graphics.Rect r3 = r14.mTmpRect
            r1.calculateItemDecorationsForChild(r2, r3)
            boolean r2 = r1.canScrollHorizontally()
            if (r2 == 0) goto L_0x00e6
            float r2 = r14.mSelectedStartX
            float r3 = r14.mDx
            float r2 = r2 + r3
            int r2 = (int) r2
            android.graphics.Rect r3 = r14.mTmpRect
            int r3 = r3.left
            int r3 = r2 - r3
            android.support.v7.widget.RecyclerView r4 = r14.mRecyclerView
            int r4 = r4.getPaddingLeft()
            int r4 = r3 - r4
            float r3 = r14.mDx
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x00c1
            if (r4 >= 0) goto L_0x00c1
        L_0x0053:
            boolean r1 = r1.canScrollVertically()
            if (r1 == 0) goto L_0x010e
            float r1 = r14.mSelectedStartY
            float r2 = r14.mDy
            float r1 = r1 + r2
            int r1 = (int) r1
            android.graphics.Rect r2 = r14.mTmpRect
            int r2 = r2.top
            int r2 = r1 - r2
            android.support.v7.widget.RecyclerView r3 = r14.mRecyclerView
            int r3 = r3.getPaddingTop()
            int r8 = r2 - r3
            float r2 = r14.mDy
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x00e9
            if (r8 >= 0) goto L_0x00e9
        L_0x0075:
            if (r4 == 0) goto L_0x0117
            android.support.v7.widget.helper.ItemTouchHelper$Callback r1 = r14.mCallback
            android.support.v7.widget.RecyclerView r2 = r14.mRecyclerView
            android.support.v7.widget.RecyclerView$ViewHolder r3 = r14.mSelected
            android.view.View r3 = r3.itemView
            int r3 = r3.getWidth()
            android.support.v7.widget.RecyclerView r5 = r14.mRecyclerView
            int r5 = r5.getWidth()
            int r4 = r1.interpolateOutOfBoundsScroll(r2, r3, r4, r5, r6)
            r9 = r4
        L_0x008e:
            if (r8 == 0) goto L_0x0115
            android.support.v7.widget.helper.ItemTouchHelper$Callback r1 = r14.mCallback
            android.support.v7.widget.RecyclerView r2 = r14.mRecyclerView
            android.support.v7.widget.RecyclerView$ViewHolder r3 = r14.mSelected
            android.view.View r3 = r3.itemView
            int r3 = r3.getHeight()
            android.support.v7.widget.RecyclerView r4 = r14.mRecyclerView
            int r5 = r4.getHeight()
            r4 = r8
            int r1 = r1.interpolateOutOfBoundsScroll(r2, r3, r4, r5, r6)
        L_0x00a7:
            if (r9 != 0) goto L_0x00ab
            if (r1 == 0) goto L_0x0111
        L_0x00ab:
            long r2 = r14.mDragScrollStartTimeInMs
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x00b3
            r14.mDragScrollStartTimeInMs = r10
        L_0x00b3:
            android.support.v7.widget.RecyclerView r0 = r14.mRecyclerView
            r0.scrollBy(r9, r1)
            r0 = 1
            goto L_0x000a
        L_0x00bb:
            long r2 = r14.mDragScrollStartTimeInMs
            long r6 = r10 - r2
            goto L_0x0017
        L_0x00c1:
            float r3 = r14.mDx
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e6
            android.support.v7.widget.RecyclerView$ViewHolder r3 = r14.mSelected
            android.view.View r3 = r3.itemView
            int r3 = r3.getWidth()
            int r2 = r2 + r3
            android.graphics.Rect r3 = r14.mTmpRect
            int r3 = r3.right
            int r2 = r2 + r3
            android.support.v7.widget.RecyclerView r3 = r14.mRecyclerView
            int r3 = r3.getWidth()
            android.support.v7.widget.RecyclerView r4 = r14.mRecyclerView
            int r4 = r4.getPaddingRight()
            int r3 = r3 - r4
            int r4 = r2 - r3
            if (r4 > 0) goto L_0x0053
        L_0x00e6:
            r4 = r0
            goto L_0x0053
        L_0x00e9:
            float r2 = r14.mDy
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x010e
            android.support.v7.widget.RecyclerView$ViewHolder r2 = r14.mSelected
            android.view.View r2 = r2.itemView
            int r2 = r2.getHeight()
            int r1 = r1 + r2
            android.graphics.Rect r2 = r14.mTmpRect
            int r2 = r2.bottom
            int r1 = r1 + r2
            android.support.v7.widget.RecyclerView r2 = r14.mRecyclerView
            int r2 = r2.getHeight()
            android.support.v7.widget.RecyclerView r3 = r14.mRecyclerView
            int r3 = r3.getPaddingBottom()
            int r2 = r2 - r3
            int r8 = r1 - r2
            if (r8 > 0) goto L_0x0075
        L_0x010e:
            r8 = r0
            goto L_0x0075
        L_0x0111:
            r14.mDragScrollStartTimeInMs = r12
            goto L_0x000a
        L_0x0115:
            r1 = r8
            goto L_0x00a7
        L_0x0117:
            r9 = r4
            goto L_0x008e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.widget.helper.ItemTouchHelper.scrollIfNecessary():boolean");
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        if (this.mSwapTargets == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            this.mSwapTargets.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int width = viewHolder.itemView.getWidth() + round + (boundingBoxMargin * 2);
        int height = viewHolder.itemView.getHeight() + round2 + (boundingBoxMargin * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(i - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i2 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int i4 = (abs * abs) + (abs2 * abs2);
                    int size = this.mSwapTargets.size();
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < size && i4 > this.mDistances.get(i6).intValue()) {
                        i5++;
                        i6++;
                    }
                    this.mSwapTargets.add(i5, childViewHolder);
                    this.mDistances.add(i5, Integer.valueOf(i4));
                }
            }
        }
        return this.mSwapTargets;
    }

    /* access modifiers changed from: package-private */
    public void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
            int i = (int) (this.mSelectedStartX + this.mDx);
            int i2 = (int) (this.mSelectedStartY + this.mDy);
            if (((float) Math.abs(i2 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i - viewHolder.itemView.getLeft())) >= moveThreshold * ((float) viewHolder.itemView.getWidth())) {
                List<RecyclerView.ViewHolder> findSwapTargets = findSwapTargets(viewHolder);
                if (findSwapTargets.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i, i2);
                    if (chooseDropTarget == null) {
                        this.mSwapTargets.clear();
                        this.mDistances.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
                        this.mCallback.onMoved(this.mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (this.mSelected == null || childViewHolder != this.mSelected) {
                endRecoverAnimation(childViewHolder, false);
                if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
                    this.mCallback.clearView(this.mRecyclerView, childViewHolder);
                    return;
                }
                return;
            }
            select((RecyclerView.ViewHolder) null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public int endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return recoverAnimation.mAnimationType;
            }
        }
        return 0;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    /* access modifiers changed from: package-private */
    public void obtainVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (this.mActivePointerId == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.mInitialTouchX);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialTouchY);
        if (abs < ((float) this.mSlop) && abs2 < ((float) this.mSlop)) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (findChildView = findChildView(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(findChildView);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean checkSelectForSwipe(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder findSwipedView;
        int absoluteMovementFlags;
        if (this.mSelected != null || i != 2 || this.mActionState == 2 || !this.mCallback.isItemViewSwipeEnabled() || this.mRecyclerView.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, findSwipedView) & 65280) >> 8) == 0) {
            return false;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.mInitialTouchX;
        float f2 = y - this.mInitialTouchY;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (abs < ((float) this.mSlop) && abs2 < ((float) this.mSlop)) {
            return false;
        }
        if (abs > abs2) {
            if (f < 0.0f && (absoluteMovementFlags & 4) == 0) {
                return false;
            }
            if (f > 0.0f && (absoluteMovementFlags & 8) == 0) {
                return false;
            }
        } else if (f2 < 0.0f && (absoluteMovementFlags & 1) == 0) {
            return false;
        } else {
            if (f2 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                return false;
            }
        }
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
        return true;
    }

    /* access modifiers changed from: package-private */
    public View findChildView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.mSelected != null) {
            View view = this.mSelected.itemView;
            if (hitTest(view, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x, y, recoverAnimation.f1228mX, recoverAnimation.f1229mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start drag has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 2);
        }
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start swipe has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == findChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void updateDxDy(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.mDx = x - this.mInitialTouchX;
        this.mDy = y - this.mInitialTouchY;
        if ((i & 4) == 0) {
            this.mDx = Math.max(0.0f, this.mDx);
        }
        if ((i & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & 65280) >> 8;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            int checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe > 0) {
                return (i & checkHorizontalSwipe) == 0 ? Callback.convertToRelativeDirection(checkHorizontalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkHorizontalSwipe;
            }
            int checkVerticalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe > 0) {
                return checkVerticalSwipe;
            }
            return 0;
        }
        int checkVerticalSwipe2 = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
        if (checkVerticalSwipe2 > 0) {
            return checkVerticalSwipe2;
        }
        int checkHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
        if (checkHorizontalSwipe2 > 0) {
            return (i & checkHorizontalSwipe2) == 0 ? Callback.convertToRelativeDirection(checkHorizontalSwipe2, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkHorizontalSwipe2;
        }
        return 0;
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.mDx > 0.0f ? 8 : 4;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                if (xVelocity <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((i2 & i) != 0 && i3 == i2 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                    return i2;
                }
            }
            float width = ((float) this.mRecyclerView.getWidth()) * this.mCallback.getSwipeThreshold(viewHolder);
            if ((i & i3) != 0 && Math.abs(this.mDx) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.mDy > 0.0f ? 2 : 1;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                if (yVelocity <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((i2 & i) != 0 && i2 == i3 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                    return i2;
                }
            }
            float height = ((float) this.mRecyclerView.getHeight()) * this.mCallback.getSwipeThreshold(viewHolder);
            if ((i & i3) != 0 && Math.abs(this.mDy) > height) {
                return i3;
            }
        }
        return 0;
    }

    private void addChildDrawingOrderCallback() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.mChildDrawingOrderCallback == null) {
                this.mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback() {
                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.mOverdrawChild == null) {
                            return i2;
                        }
                        int i3 = ItemTouchHelper.this.mOverdrawChildPosition;
                        if (i3 == -1) {
                            i3 = ItemTouchHelper.this.mRecyclerView.indexOfChild(ItemTouchHelper.this.mOverdrawChild);
                            ItemTouchHelper.this.mOverdrawChildPosition = i3;
                        }
                        if (i2 == i - 1) {
                            return i3;
                        }
                        return i2 >= i3 ? i2 + 1 : i2;
                    }
                };
            }
            this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback((RecyclerView.ChildDrawingOrderCallback) null);
            }
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$Callback */
    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() {
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() {
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        private static final ItemTouchUIUtil sUICallback;
        private int mCachedMaxScrollSpeed = -1;

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);

        static {
            if (Build.VERSION.SDK_INT >= 21) {
                sUICallback = new ItemTouchUIUtilImpl.Lollipop();
            } else if (Build.VERSION.SDK_INT >= 11) {
                sUICallback = new ItemTouchUIUtilImpl.Honeycomb();
            } else {
                sUICallback = new ItemTouchUIUtilImpl.Gingerbread();
            }
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return sUICallback;
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3 = i & ABS_HORIZONTAL_DIR_FLAGS;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 << 2);
            }
            return i4 | ((i3 << 1) & -789517) | (((i3 << 1) & ABS_HORIZONTAL_DIR_FLAGS) << 2);
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(0, i2 | i) | makeFlag(1, i2) | makeFlag(2, i);
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3 = i & RELATIVE_DIR_FLAGS;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 >> 2);
            }
            return i4 | ((i3 >> 1) & -3158065) | (((i3 >> 1) & RELATIVE_DIR_FLAGS) >> 2);
        }

        /* access modifiers changed from: package-private */
        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        /* access modifiers changed from: package-private */
        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            RecyclerView.ViewHolder viewHolder2;
            int i3;
            int i4;
            int i5;
            int i6;
            RecyclerView.ViewHolder viewHolder3;
            int bottom;
            int abs;
            int top;
            int left;
            int right;
            int abs2;
            int width = i + viewHolder.itemView.getWidth();
            int height = i2 + viewHolder.itemView.getHeight();
            RecyclerView.ViewHolder viewHolder4 = null;
            int i7 = -1;
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            int i8 = 0;
            while (i8 < size) {
                RecyclerView.ViewHolder viewHolder5 = list.get(i8);
                if (left2 <= 0 || (right = viewHolder5.itemView.getRight() - width) >= 0 || viewHolder5.itemView.getRight() <= viewHolder.itemView.getRight() || (abs2 = Math.abs(right)) <= i7) {
                    viewHolder2 = viewHolder4;
                    i3 = i7;
                } else {
                    i3 = abs2;
                    viewHolder2 = viewHolder5;
                }
                if (left2 >= 0 || (left = viewHolder5.itemView.getLeft() - i) <= 0 || viewHolder5.itemView.getLeft() >= viewHolder.itemView.getLeft() || (i4 = Math.abs(left)) <= i3) {
                    i4 = i3;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 >= 0 || (top = viewHolder5.itemView.getTop() - i2) <= 0 || viewHolder5.itemView.getTop() >= viewHolder.itemView.getTop() || (i5 = Math.abs(top)) <= i4) {
                    i5 = i4;
                } else {
                    viewHolder2 = viewHolder5;
                }
                if (top2 <= 0 || (bottom = viewHolder5.itemView.getBottom() - height) >= 0 || viewHolder5.itemView.getBottom() <= viewHolder.itemView.getBottom() || (abs = Math.abs(bottom)) <= i5) {
                    i6 = i5;
                    viewHolder3 = viewHolder2;
                } else {
                    int i9 = abs;
                    viewHolder3 = viewHolder5;
                    i6 = i9;
                }
                i8++;
                viewHolder4 = viewHolder3;
                i7 = i6;
            }
            return viewHolder4;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                sUICallback.onSelected(viewHolder.itemView);
            }
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(C0559R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.f1228mX, recoverAnimation.f1229mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            boolean z;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.f1228mX, recoverAnimation.f1229mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            boolean z2 = false;
            int i3 = size - 1;
            while (i3 >= 0) {
                RecoverAnimation recoverAnimation2 = list.get(i3);
                if (recoverAnimation2.mEnded && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(i3);
                    z = z2;
                } else if (!recoverAnimation2.mEnded) {
                    z = true;
                } else {
                    z = z2;
                }
                i3--;
                z2 = z;
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            sUICallback.clearView(viewHolder.itemView);
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            }
            if (i == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int maxDragScroll = (int) (((float) (getMaxDragScroll(recyclerView) * ((int) Math.signum((float) i2)))) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (sDragScrollInterpolator.getInterpolation(f) * ((float) maxDragScroll));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$SimpleCallback */
    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i, int i2) {
            this.mDefaultSwipeDirs = i2;
            this.mDefaultDragDirs = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.mDefaultSwipeDirs = i;
        }

        public void setDefaultDragDirs(int i) {
            this.mDefaultDragDirs = i;
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$ItemTouchHelperGestureListener */
    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        ItemTouchHelperGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            RecyclerView.ViewHolder childViewHolder;
            View findChildView = ItemTouchHelper.this.findChildView(motionEvent);
            if (findChildView != null && (childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(findChildView)) != null && ItemTouchHelper.this.mCallback.hasDragFlag(ItemTouchHelper.this.mRecyclerView, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.mActivePointerId) {
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                ItemTouchHelper.this.mInitialTouchX = x;
                ItemTouchHelper.this.mInitialTouchY = y;
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                ItemTouchHelper.this.mDy = 0.0f;
                itemTouchHelper.mDx = 0.0f;
                if (ItemTouchHelper.this.mCallback.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.select(childViewHolder, 2);
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation */
    private class RecoverAnimation implements AnimatorListenerCompat {
        final int mActionState;
        final int mAnimationType;
        boolean mEnded = false;
        private float mFraction;
        public boolean mIsPendingCleanup;
        boolean mOverridden = false;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimatorCompat mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;

        /* renamed from: mX */
        float f1228mX;

        /* renamed from: mY */
        float f1229mY;

        public RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.mActionState = i2;
            this.mAnimationType = i;
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            this.mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
            this.mValueAnimator.addUpdateListener(new AnimatorUpdateListenerCompat(ItemTouchHelper.this) {
                public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                    RecoverAnimation.this.setFraction(valueAnimatorCompat.getAnimatedFraction());
                }
            });
            this.mValueAnimator.setTarget(viewHolder.itemView);
            this.mValueAnimator.addListener(this);
            setFraction(0.0f);
        }

        public void setDuration(long j) {
            this.mValueAnimator.setDuration(j);
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public void update() {
            if (this.mStartDx == this.mTargetX) {
                this.f1228mX = ViewCompat.getTranslationX(this.mViewHolder.itemView);
            } else {
                this.f1228mX = this.mStartDx + (this.mFraction * (this.mTargetX - this.mStartDx));
            }
            if (this.mStartDy == this.mTargetY) {
                this.f1229mY = ViewCompat.getTranslationY(this.mViewHolder.itemView);
            } else {
                this.f1229mY = this.mStartDy + (this.mFraction * (this.mTargetY - this.mStartDy));
            }
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
            setFraction(1.0f);
        }

        public void onAnimationRepeat(ValueAnimatorCompat valueAnimatorCompat) {
        }
    }
}
