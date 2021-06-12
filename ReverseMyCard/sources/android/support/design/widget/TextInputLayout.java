package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.C0292s;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.p018os.ParcelableCompat;
import android.support.p016v4.p018os.ParcelableCompatCreatorCallbacks;
import android.support.p016v4.view.AbsSavedState;
import android.support.p016v4.view.AccessibilityDelegateCompat;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.p016v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p016v4.widget.Space;
import android.support.p016v4.widget.TextViewCompat;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.content.res.AppCompatResources;
import android.support.p019v7.widget.AppCompatDrawableManager;
import android.support.p019v7.widget.DrawableUtils;
import android.support.p019v7.widget.TintTypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout {

    /* renamed from: A */
    private Drawable f853A;

    /* renamed from: B */
    private ColorStateList f854B;

    /* renamed from: C */
    private boolean f855C;

    /* renamed from: D */
    private PorterDuff.Mode f856D;

    /* renamed from: E */
    private boolean f857E;

    /* renamed from: F */
    private ColorStateList f858F;

    /* renamed from: G */
    private ColorStateList f859G;

    /* renamed from: H */
    private boolean f860H;

    /* renamed from: I */
    private boolean f861I;

    /* renamed from: J */
    private C0292s f862J;

    /* renamed from: K */
    private boolean f863K;

    /* renamed from: L */
    private boolean f864L;

    /* renamed from: a */
    EditText f865a;

    /* renamed from: b */
    TextView f866b;

    /* renamed from: c */
    boolean f867c;

    /* renamed from: d */
    final C0261d f868d;

    /* renamed from: e */
    private final FrameLayout f869e;

    /* renamed from: f */
    private boolean f870f;

    /* renamed from: g */
    private CharSequence f871g;

    /* renamed from: h */
    private Paint f872h;

    /* renamed from: i */
    private final Rect f873i;

    /* renamed from: j */
    private LinearLayout f874j;

    /* renamed from: k */
    private int f875k;

    /* renamed from: l */
    private boolean f876l;

    /* renamed from: m */
    private int f877m;

    /* renamed from: n */
    private boolean f878n;

    /* renamed from: o */
    private CharSequence f879o;

    /* renamed from: p */
    private TextView f880p;

    /* renamed from: q */
    private int f881q;

    /* renamed from: r */
    private int f882r;

    /* renamed from: s */
    private int f883s;

    /* renamed from: t */
    private boolean f884t;

    /* renamed from: u */
    private boolean f885u;

    /* renamed from: v */
    private Drawable f886v;

    /* renamed from: w */
    private CharSequence f887w;

    /* renamed from: x */
    private CheckableImageButton f888x;

    /* renamed from: y */
    private boolean f889y;

    /* renamed from: z */
    private Drawable f890z;

    public TextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f873i = new Rect();
        this.f868d = new C0261d(this);
        C0291r.m1597a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f869e = new FrameLayout(context);
        this.f869e.setAddStatesFromChildren(true);
        addView(this.f869e);
        this.f868d.mo1222a(C0255a.f900b);
        this.f868d.mo1231b((Interpolator) new AccelerateInterpolator());
        this.f868d.mo1227b(8388659);
        this.f860H = this.f868d.mo1239g() == 1.0f;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextInputLayout, i, R.style.Widget_Design_TextInputLayout);
        this.f870f = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(R.styleable.TextInputLayout_android_hint));
        this.f861I = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
            this.f859G = colorStateList;
            this.f858F = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.f877m = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.f882r = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.f883s = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.f885u = obtainStyledAttributes.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, true);
        this.f886v = obtainStyledAttributes.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
        this.f887w = obtainStyledAttributes.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_passwordToggleTint)) {
            this.f855C = true;
            this.f854B = obtainStyledAttributes.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.f857E = true;
            this.f856D = C0314z.m1693a(obtainStyledAttributes.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), (PorterDuff.Mode) null);
        }
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        m1393i();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new C0254a());
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            this.f869e.addView(view, new FrameLayout.LayoutParams(layoutParams));
            this.f869e.setLayoutParams(layoutParams);
            m1384b();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        this.f868d.mo1234c(typeface);
    }

    public Typeface getTypeface() {
        return this.f868d.mo1235d();
    }

    private void setEditText(EditText editText) {
        if (this.f865a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f865a = editText;
        if (!m1391g()) {
            this.f868d.mo1234c(this.f865a.getTypeface());
        }
        this.f868d.mo1216a(this.f865a.getTextSize());
        int gravity = this.f865a.getGravity();
        this.f868d.mo1227b((8388615 & gravity) | 48);
        this.f868d.mo1217a(gravity);
        this.f865a.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.mo1157a(true);
                if (TextInputLayout.this.f867c) {
                    TextInputLayout.this.mo1156a(editable.length());
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.f858F == null) {
            this.f858F = this.f865a.getHintTextColors();
        }
        if (this.f870f && TextUtils.isEmpty(this.f871g)) {
            setHint(this.f865a.getHint());
            this.f865a.setHint((CharSequence) null);
        }
        if (this.f880p != null) {
            mo1156a(this.f865a.getText().length());
        }
        if (this.f874j != null) {
            m1386c();
        }
        m1390f();
        mo1157a(false);
    }

    /* renamed from: b */
    private void m1384b() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f869e.getLayoutParams();
        if (this.f870f) {
            if (this.f872h == null) {
                this.f872h = new Paint();
            }
            this.f872h.setTypeface(this.f868d.mo1235d());
            this.f872h.setTextSize(this.f868d.mo1240h());
            i = (int) (-this.f872h.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.f869e.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1157a(boolean z) {
        boolean z2 = true;
        boolean isEnabled = isEnabled();
        boolean z3 = this.f865a != null && !TextUtils.isEmpty(this.f865a.getText());
        boolean a = m1383a(getDrawableState(), 16842908);
        if (TextUtils.isEmpty(getError())) {
            z2 = false;
        }
        if (this.f858F != null) {
            this.f868d.mo1229b(this.f858F);
        }
        if (isEnabled && this.f884t && this.f880p != null) {
            this.f868d.mo1219a(this.f880p.getTextColors());
        } else if (isEnabled && a && this.f859G != null) {
            this.f868d.mo1219a(this.f859G);
        } else if (this.f858F != null) {
            this.f868d.mo1219a(this.f858F);
        }
        if (z3 || (isEnabled() && (a || z2))) {
            m1385b(z);
        } else {
            m1387c(z);
        }
    }

    public EditText getEditText() {
        return this.f865a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.f870f) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f871g = charSequence;
        this.f868d.mo1223a(charSequence);
    }

    public CharSequence getHint() {
        if (this.f870f) {
            return this.f871g;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f870f) {
            this.f870f = z;
            CharSequence hint = this.f865a.getHint();
            if (!this.f870f) {
                if (!TextUtils.isEmpty(this.f871g) && TextUtils.isEmpty(hint)) {
                    this.f865a.setHint(this.f871g);
                }
                setHintInternal((CharSequence) null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f871g)) {
                    setHint(hint);
                }
                this.f865a.setHint((CharSequence) null);
            }
            if (this.f865a != null) {
                m1384b();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f868d.mo1233c(i);
        this.f859G = this.f868d.mo1243k();
        if (this.f865a != null) {
            mo1157a(false);
            m1384b();
        }
    }

    /* renamed from: a */
    private void m1381a(TextView textView, int i) {
        if (this.f874j == null) {
            this.f874j = new LinearLayout(getContext());
            this.f874j.setOrientation(0);
            addView(this.f874j, -1, -2);
            this.f874j.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f865a != null) {
                m1386c();
            }
        }
        this.f874j.setVisibility(0);
        this.f874j.addView(textView, i);
        this.f875k++;
    }

    /* renamed from: c */
    private void m1386c() {
        ViewCompat.setPaddingRelative(this.f874j, ViewCompat.getPaddingStart(this.f865a), 0, ViewCompat.getPaddingEnd(this.f865a), this.f865a.getPaddingBottom());
    }

    /* renamed from: a */
    private void m1380a(TextView textView) {
        if (this.f874j != null) {
            this.f874j.removeView(textView);
            int i = this.f875k - 1;
            this.f875k = i;
            if (i == 0) {
                this.f874j.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        boolean z2;
        if (this.f876l != z) {
            if (this.f866b != null) {
                ViewCompat.animate(this.f866b).cancel();
            }
            if (z) {
                this.f866b = new TextView(getContext());
                try {
                    TextViewCompat.setTextAppearance(this.f866b, this.f877m);
                    if (Build.VERSION.SDK_INT < 23 || this.f866b.getTextColors().getDefaultColor() != -65281) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } catch (Exception e) {
                    z2 = true;
                }
                if (z2) {
                    TextViewCompat.setTextAppearance(this.f866b, C0555R.style.TextAppearance_AppCompat_Caption);
                    this.f866b.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
                }
                this.f866b.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f866b, 1);
                m1381a(this.f866b, 0);
            } else {
                this.f878n = false;
                m1388d();
                m1380a(this.f866b);
                this.f866b = null;
            }
            this.f876l = z;
        }
    }

    public void setError(CharSequence charSequence) {
        m1382a(charSequence, ViewCompat.isLaidOut(this) && isEnabled() && (this.f866b == null || !TextUtils.equals(this.f866b.getText(), charSequence)));
    }

    /* renamed from: a */
    private void m1382a(final CharSequence charSequence, boolean z) {
        boolean z2 = true;
        this.f879o = charSequence;
        if (!this.f876l) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            z2 = false;
        }
        this.f878n = z2;
        ViewCompat.animate(this.f866b).cancel();
        if (this.f878n) {
            this.f866b.setText(charSequence);
            this.f866b.setVisibility(0);
            if (z) {
                if (ViewCompat.getAlpha(this.f866b) == 1.0f) {
                    ViewCompat.setAlpha(this.f866b, 0.0f);
                }
                ViewCompat.animate(this.f866b).alpha(1.0f).setDuration(200).setInterpolator(C0255a.f902d).setListener(new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationStart(View view) {
                        view.setVisibility(0);
                    }
                }).start();
            } else {
                ViewCompat.setAlpha(this.f866b, 1.0f);
            }
        } else if (this.f866b.getVisibility() == 0) {
            if (z) {
                ViewCompat.animate(this.f866b).alpha(0.0f).setDuration(200).setInterpolator(C0255a.f901c).setListener(new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationEnd(View view) {
                        TextInputLayout.this.f866b.setText(charSequence);
                        view.setVisibility(4);
                    }
                }).start();
            } else {
                this.f866b.setText(charSequence);
                this.f866b.setVisibility(4);
            }
        }
        m1388d();
        mo1157a(z);
    }

    public void setCounterEnabled(boolean z) {
        if (this.f867c != z) {
            if (z) {
                this.f880p = new TextView(getContext());
                this.f880p.setMaxLines(1);
                try {
                    TextViewCompat.setTextAppearance(this.f880p, this.f882r);
                } catch (Exception e) {
                    TextViewCompat.setTextAppearance(this.f880p, C0555R.style.TextAppearance_AppCompat_Caption);
                    this.f880p.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
                }
                m1381a(this.f880p, -1);
                if (this.f865a == null) {
                    mo1156a(0);
                } else {
                    mo1156a(this.f865a.getText().length());
                }
            } else {
                m1380a(this.f880p);
                this.f880p = null;
            }
            this.f867c = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f881q != i) {
            if (i > 0) {
                this.f881q = i;
            } else {
                this.f881q = -1;
            }
            if (this.f867c) {
                mo1156a(this.f865a == null ? 0 : this.f865a.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        m1379a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    /* renamed from: a */
    private static void m1379a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m1379a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f881q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1156a(int i) {
        boolean z = this.f884t;
        if (this.f881q == -1) {
            this.f880p.setText(String.valueOf(i));
            this.f884t = false;
        } else {
            this.f884t = i > this.f881q;
            if (z != this.f884t) {
                TextViewCompat.setTextAppearance(this.f880p, this.f884t ? this.f883s : this.f882r);
            }
            this.f880p.setText(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f881q)}));
        }
        if (this.f865a != null && z != this.f884t) {
            mo1157a(false);
            m1388d();
        }
    }

    /* renamed from: d */
    private void m1388d() {
        Drawable background;
        if (this.f865a != null && (background = this.f865a.getBackground()) != null) {
            m1389e();
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.f878n && this.f866b != null) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.f866b.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else if (!this.f884t || this.f880p == null) {
                DrawableCompat.clearColorFilter(background);
                this.f865a.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.f880p.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* renamed from: e */
    private void m1389e() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i == 21 || i == 22) && (background = this.f865a.getBackground()) != null && !this.f863K) {
            Drawable newDrawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                this.f863K = C0263f.m1467a((DrawableContainer) background, newDrawable.getConstantState());
            }
            if (!this.f863K) {
                ViewCompat.setBackground(this.f865a, newDrawable);
                this.f863K = true;
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });

        /* renamed from: a */
        CharSequence f897a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f897a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f897a, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f897a + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f878n) {
            savedState.f897a = getError();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f897a);
        requestLayout();
    }

    public CharSequence getError() {
        if (this.f876l) {
            return this.f879o;
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f861I = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f870f) {
            this.f868d.mo1220a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m1390f();
        super.onMeasure(i, i2);
    }

    /* renamed from: f */
    private void m1390f() {
        if (this.f865a != null) {
            if (m1392h()) {
                if (this.f888x == null) {
                    this.f888x = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, this.f869e, false);
                    this.f888x.setImageDrawable(this.f886v);
                    this.f888x.setContentDescription(this.f887w);
                    this.f869e.addView(this.f888x);
                    this.f888x.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            TextInputLayout.this.mo1155a();
                        }
                    });
                }
                this.f888x.setVisibility(0);
                if (this.f890z == null) {
                    this.f890z = new ColorDrawable();
                }
                this.f890z.setBounds(0, 0, this.f888x.getMeasuredWidth(), 1);
                Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f865a);
                if (compoundDrawablesRelative[2] != this.f890z) {
                    this.f853A = compoundDrawablesRelative[2];
                }
                TextViewCompat.setCompoundDrawablesRelative(this.f865a, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.f890z, compoundDrawablesRelative[3]);
                this.f888x.setPadding(this.f865a.getPaddingLeft(), this.f865a.getPaddingTop(), this.f865a.getPaddingRight(), this.f865a.getPaddingBottom());
                return;
            }
            if (this.f888x != null && this.f888x.getVisibility() == 0) {
                this.f888x.setVisibility(8);
            }
            Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f865a);
            if (compoundDrawablesRelative2[2] == this.f890z) {
                TextViewCompat.setCompoundDrawablesRelative(this.f865a, compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.f853A, compoundDrawablesRelative2[3]);
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f886v = drawable;
        if (this.f888x != null) {
            this.f888x.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f887w = charSequence;
        if (this.f888x != null) {
            this.f888x.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f886v;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f887w;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.f885u != z) {
            this.f885u = z;
            if (!z && this.f889y && this.f865a != null) {
                this.f865a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f889y = false;
            m1390f();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f854B = colorStateList;
        this.f855C = true;
        m1393i();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f856D = mode;
        this.f857E = true;
        m1393i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1155a() {
        if (this.f885u) {
            int selectionEnd = this.f865a.getSelectionEnd();
            if (m1391g()) {
                this.f865a.setTransformationMethod((TransformationMethod) null);
                this.f889y = true;
            } else {
                this.f865a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f889y = false;
            }
            this.f888x.setChecked(this.f889y);
            this.f865a.setSelection(selectionEnd);
        }
    }

    /* renamed from: g */
    private boolean m1391g() {
        return this.f865a != null && (this.f865a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* renamed from: h */
    private boolean m1392h() {
        return this.f885u && (m1391g() || this.f889y);
    }

    /* renamed from: i */
    private void m1393i() {
        if (this.f886v == null) {
            return;
        }
        if (this.f855C || this.f857E) {
            this.f886v = DrawableCompat.wrap(this.f886v).mutate();
            if (this.f855C) {
                DrawableCompat.setTintList(this.f886v, this.f854B);
            }
            if (this.f857E) {
                DrawableCompat.setTintMode(this.f886v, this.f856D);
            }
            if (this.f888x != null && this.f888x.getDrawable() != this.f886v) {
                this.f888x.setImageDrawable(this.f886v);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f870f && this.f865a != null) {
            Rect rect = this.f873i;
            C0307v.m1677b(this, this.f865a, rect);
            int compoundPaddingLeft = rect.left + this.f865a.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.f865a.getCompoundPaddingRight();
            this.f868d.mo1218a(compoundPaddingLeft, rect.top + this.f865a.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f865a.getCompoundPaddingBottom());
            this.f868d.mo1228b(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.f868d.mo1241i();
        }
    }

    /* renamed from: b */
    private void m1385b(boolean z) {
        if (this.f862J != null && this.f862J.mo1324b()) {
            this.f862J.mo1327e();
        }
        if (!z || !this.f861I) {
            this.f868d.mo1226b(1.0f);
        } else {
            m1378a(1.0f);
        }
        this.f860H = false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z;
        boolean z2 = true;
        if (!this.f864L) {
            this.f864L = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                z2 = false;
            }
            mo1157a(z2);
            m1388d();
            if (this.f868d != null) {
                z = this.f868d.mo1224a(drawableState) | false;
            } else {
                z = false;
            }
            if (z) {
                invalidate();
            }
            this.f864L = false;
        }
    }

    /* renamed from: c */
    private void m1387c(boolean z) {
        if (this.f862J != null && this.f862J.mo1324b()) {
            this.f862J.mo1327e();
        }
        if (!z || !this.f861I) {
            this.f868d.mo1226b(0.0f);
        } else {
            m1378a(0.0f);
        }
        this.f860H = true;
    }

    /* renamed from: a */
    private void m1378a(float f) {
        if (this.f868d.mo1239g() != f) {
            if (this.f862J == null) {
                this.f862J = C0314z.m1694a();
                this.f862J.mo1323a(C0255a.f899a);
                this.f862J.mo1320a(200);
                this.f862J.mo1322a((C0292s.C0297c) new C0292s.C0297c() {
                    /* renamed from: a */
                    public void mo746a(C0292s sVar) {
                        TextInputLayout.this.f868d.mo1226b(sVar.mo1326d());
                    }
                });
            }
            this.f862J.mo1318a(this.f868d.mo1239g(), f);
            this.f862J.mo1317a();
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$a */
    private class C0254a extends AccessibilityDelegateCompat {
        C0254a() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence j = TextInputLayout.this.f868d.mo1242j();
            if (!TextUtils.isEmpty(j)) {
                accessibilityEvent.getText().add(j);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence j = TextInputLayout.this.f868d.mo1242j();
            if (!TextUtils.isEmpty(j)) {
                accessibilityNodeInfoCompat.setText(j);
            }
            if (TextInputLayout.this.f865a != null) {
                accessibilityNodeInfoCompat.setLabelFor(TextInputLayout.this.f865a);
            }
            CharSequence text = TextInputLayout.this.f866b != null ? TextInputLayout.this.f866b.getText() : null;
            if (!TextUtils.isEmpty(text)) {
                accessibilityNodeInfoCompat.setContentInvalid(true);
                accessibilityNodeInfoCompat.setError(text);
            }
        }
    }

    /* renamed from: a */
    private static boolean m1383a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
