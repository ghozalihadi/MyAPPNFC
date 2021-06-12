package android.support.p019v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.p014a.p015a.C0143b;
import android.support.p014a.p015a.C0152f;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.graphics.ColorUtils;
import android.support.p016v4.graphics.drawable.DrawableCompat;
import android.support.p016v4.util.ArrayMap;
import android.support.p016v4.util.LongSparseArray;
import android.support.p016v4.util.LruCache;
import android.support.p019v7.appcompat.C0555R;
import android.support.p019v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v7.widget.AppCompatDrawableManager */
public final class AppCompatDrawableManager {
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {C0555R.C0556drawable.abc_popup_background_mtrl_mult, C0555R.C0556drawable.abc_cab_background_internal_bg, C0555R.C0556drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {C0555R.C0556drawable.abc_textfield_activated_mtrl_alpha, C0555R.C0556drawable.abc_textfield_search_activated_mtrl_alpha, C0555R.C0556drawable.abc_cab_background_top_mtrl_alpha, C0555R.C0556drawable.abc_text_cursor_material, C0555R.C0556drawable.abc_text_select_handle_left_mtrl_dark, C0555R.C0556drawable.abc_text_select_handle_middle_mtrl_dark, C0555R.C0556drawable.abc_text_select_handle_right_mtrl_dark, C0555R.C0556drawable.abc_text_select_handle_left_mtrl_light, C0555R.C0556drawable.abc_text_select_handle_middle_mtrl_light, C0555R.C0556drawable.abc_text_select_handle_right_mtrl_light};
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {C0555R.C0556drawable.abc_textfield_search_default_mtrl_alpha, C0555R.C0556drawable.abc_textfield_default_mtrl_alpha, C0555R.C0556drawable.abc_ab_share_pack_mtrl_alpha};
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "AppCompatDrawableManager";
    private static final int[] TINT_CHECKABLE_BUTTON_LIST = {C0555R.C0556drawable.abc_btn_check_material, C0555R.C0556drawable.abc_btn_radio_material};
    private static final int[] TINT_COLOR_CONTROL_NORMAL = {C0555R.C0556drawable.abc_ic_commit_search_api_mtrl_alpha, C0555R.C0556drawable.abc_seekbar_tick_mark_material, C0555R.C0556drawable.abc_ic_menu_share_mtrl_alpha, C0555R.C0556drawable.abc_ic_menu_copy_mtrl_am_alpha, C0555R.C0556drawable.abc_ic_menu_cut_mtrl_alpha, C0555R.C0556drawable.abc_ic_menu_selectall_mtrl_alpha, C0555R.C0556drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST = {C0555R.C0556drawable.abc_tab_indicator_material, C0555R.C0556drawable.abc_textfield_search_material};
    private ArrayMap<String, InflateDelegate> mDelegates;
    private final Object mDrawableCacheLock = new Object();
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap<>(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private SparseArray<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArray<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    /* renamed from: android.support.v7.widget.AppCompatDrawableManager$InflateDelegate */
    private interface InflateDelegate {
        Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public static AppCompatDrawableManager get() {
        if (INSTANCE == null) {
            INSTANCE = new AppCompatDrawableManager();
            installDefaultInflateDelegates(INSTANCE);
        }
        return INSTANCE;
    }

    private static void installDefaultInflateDelegates(AppCompatDrawableManager appCompatDrawableManager) {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            appCompatDrawableManager.addDelegate("vector", new VdcInflateDelegate());
            if (i >= 11) {
                appCompatDrawableManager.addDelegate("animated-vector", new AvdcInflateDelegate());
            }
        }
    }

    public Drawable getDrawable(Context context, int i) {
        return getDrawable(context, i, false);
    }

    /* access modifiers changed from: package-private */
    public Drawable getDrawable(Context context, int i, boolean z) {
        checkVectorDrawableSetup(context);
        Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = createDrawableIfNeeded(context, i);
        }
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = ContextCompat.getDrawable(context, i);
        }
        if (loadDrawableFromDelegates != null) {
            loadDrawableFromDelegates = tintDrawable(context, i, z, loadDrawableFromDelegates);
        }
        if (loadDrawableFromDelegates != null) {
            DrawableUtils.fixDrawable(loadDrawableFromDelegates);
        }
        return loadDrawableFromDelegates;
    }

    public void onConfigurationChanged(Context context) {
        synchronized (this.mDrawableCacheLock) {
            LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }

    private static long createCacheKey(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable createDrawableIfNeeded(Context context, int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable == null) {
            if (i == C0555R.C0556drawable.abc_cab_background_top_material) {
                cachedDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, C0555R.C0556drawable.abc_cab_background_internal_bg), getDrawable(context, C0555R.C0556drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (cachedDrawable != null) {
                cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                addDrawableToCache(context, createCacheKey, cachedDrawable);
            }
        }
        return cachedDrawable;
    }

    private Drawable tintDrawable(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList tintList = getTintList(context, i);
        if (tintList != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, tintList);
            PorterDuff.Mode tintMode = getTintMode(i);
            if (tintMode == null) {
                return wrap;
            }
            DrawableCompat.setTintMode(wrap, tintMode);
            return wrap;
        } else if (i == C0555R.C0556drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorControlActivated), DEFAULT_MODE);
            return drawable;
        } else if (i == C0555R.C0556drawable.abc_ratingbar_material || i == C0555R.C0556drawable.abc_ratingbar_indicator_material || i == C0555R.C0556drawable.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, C0555R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorControlActivated), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorControlActivated), DEFAULT_MODE);
            return drawable;
        } else if (tintDrawableUsingColorFilter(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable loadDrawableFromDelegates(android.content.Context r10, int r11) {
        /*
            r9 = this;
            r1 = 0
            r8 = 2
            r7 = 1
            android.support.v4.util.ArrayMap<java.lang.String, android.support.v7.widget.AppCompatDrawableManager$InflateDelegate> r0 = r9.mDelegates
            if (r0 == 0) goto L_0x00bf
            android.support.v4.util.ArrayMap<java.lang.String, android.support.v7.widget.AppCompatDrawableManager$InflateDelegate> r0 = r9.mDelegates
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00bf
            android.util.SparseArray<java.lang.String> r0 = r9.mKnownDrawableIdTags
            if (r0 == 0) goto L_0x002f
            android.util.SparseArray<java.lang.String> r0 = r9.mKnownDrawableIdTags
            java.lang.Object r0 = r0.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "appcompat_skip_skip"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002d
            if (r0 == 0) goto L_0x0036
            android.support.v4.util.ArrayMap<java.lang.String, android.support.v7.widget.AppCompatDrawableManager$InflateDelegate> r2 = r9.mDelegates
            java.lang.Object r0 = r2.get(r0)
            if (r0 != 0) goto L_0x0036
        L_0x002d:
            r0 = r1
        L_0x002e:
            return r0
        L_0x002f:
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            r9.mKnownDrawableIdTags = r0
        L_0x0036:
            android.util.TypedValue r0 = r9.mTypedValue
            if (r0 != 0) goto L_0x0041
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r9.mTypedValue = r0
        L_0x0041:
            android.util.TypedValue r2 = r9.mTypedValue
            android.content.res.Resources r0 = r10.getResources()
            r0.getValue(r11, r2, r7)
            long r4 = createCacheKey(r2)
            android.graphics.drawable.Drawable r1 = r9.getCachedDrawable(r10, r4)
            if (r1 == 0) goto L_0x0056
            r0 = r1
            goto L_0x002e
        L_0x0056:
            java.lang.CharSequence r3 = r2.string
            if (r3 == 0) goto L_0x008a
            java.lang.CharSequence r3 = r2.string
            java.lang.String r3 = r3.toString()
            java.lang.String r6 = ".xml"
            boolean r3 = r3.endsWith(r6)
            if (r3 == 0) goto L_0x008a
            android.content.res.XmlResourceParser r3 = r0.getXml(r11)     // Catch:{ Exception -> 0x0082 }
            android.util.AttributeSet r6 = android.util.Xml.asAttributeSet(r3)     // Catch:{ Exception -> 0x0082 }
        L_0x0070:
            int r0 = r3.next()     // Catch:{ Exception -> 0x0082 }
            if (r0 == r8) goto L_0x0078
            if (r0 != r7) goto L_0x0070
        L_0x0078:
            if (r0 == r8) goto L_0x0095
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0082 }
            java.lang.String r2 = "No start tag found"
            r0.<init>(r2)     // Catch:{ Exception -> 0x0082 }
            throw r0     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            java.lang.String r2 = "AppCompatDrawableManager"
            java.lang.String r3 = "Exception while inflating drawable"
            android.util.Log.e(r2, r3, r0)
        L_0x008a:
            r0 = r1
        L_0x008b:
            if (r0 != 0) goto L_0x002e
            android.util.SparseArray<java.lang.String> r1 = r9.mKnownDrawableIdTags
            java.lang.String r2 = "appcompat_skip_skip"
            r1.append(r11, r2)
            goto L_0x002e
        L_0x0095:
            java.lang.String r0 = r3.getName()     // Catch:{ Exception -> 0x0082 }
            android.util.SparseArray<java.lang.String> r7 = r9.mKnownDrawableIdTags     // Catch:{ Exception -> 0x0082 }
            r7.append(r11, r0)     // Catch:{ Exception -> 0x0082 }
            android.support.v4.util.ArrayMap<java.lang.String, android.support.v7.widget.AppCompatDrawableManager$InflateDelegate> r7 = r9.mDelegates     // Catch:{ Exception -> 0x0082 }
            java.lang.Object r0 = r7.get(r0)     // Catch:{ Exception -> 0x0082 }
            android.support.v7.widget.AppCompatDrawableManager$InflateDelegate r0 = (android.support.p019v7.widget.AppCompatDrawableManager.InflateDelegate) r0     // Catch:{ Exception -> 0x0082 }
            if (r0 == 0) goto L_0x00b0
            android.content.res.Resources$Theme r7 = r10.getTheme()     // Catch:{ Exception -> 0x0082 }
            android.graphics.drawable.Drawable r1 = r0.createFromXmlInner(r10, r3, r6, r7)     // Catch:{ Exception -> 0x0082 }
        L_0x00b0:
            if (r1 == 0) goto L_0x00bd
            int r0 = r2.changingConfigurations     // Catch:{ Exception -> 0x0082 }
            r1.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x0082 }
            boolean r0 = r9.addDrawableToCache(r10, r4, r1)     // Catch:{ Exception -> 0x0082 }
            if (r0 == 0) goto L_0x00bd
        L_0x00bd:
            r0 = r1
            goto L_0x008b
        L_0x00bf:
            r0 = r1
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.widget.AppCompatDrawableManager.loadDrawableFromDelegates(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable getCachedDrawable(android.content.Context r5, long r6) {
        /*
            r4 = this;
            r2 = 0
            java.lang.Object r3 = r4.mDrawableCacheLock
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, android.support.v4.util.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r4.mDrawableCaches     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x002b }
            android.support.v4.util.LongSparseArray r0 = (android.support.p016v4.util.LongSparseArray) r0     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            r0 = r2
        L_0x0010:
            return r0
        L_0x0011:
            java.lang.Object r1 = r0.get(r6)     // Catch:{ all -> 0x002b }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0031
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x002b }
            android.graphics.drawable.Drawable$ConstantState r1 = (android.graphics.drawable.Drawable.ConstantState) r1     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x002e
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ all -> 0x002b }
            android.graphics.drawable.Drawable r0 = r1.newDrawable(r0)     // Catch:{ all -> 0x002b }
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            goto L_0x0010
        L_0x002b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            throw r0
        L_0x002e:
            r0.delete(r6)     // Catch:{ all -> 0x002b }
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            r0 = r2
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p019v7.widget.AppCompatDrawableManager.getCachedDrawable(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean addDrawableToCache(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.mDrawableCacheLock) {
            LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.mDrawableCaches.put(context, longSparseArray);
            }
            longSparseArray.put(j, new WeakReference(constantState));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = vectorEnabledTintResources.superGetDrawable(i);
        }
        if (loadDrawableFromDelegates != null) {
            return tintDrawable(context, i, false, loadDrawableFromDelegates);
        }
        return null;
    }

    static boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
        int i2;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        PorterDuff.Mode mode2 = DEFAULT_MODE;
        if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
            i3 = C0555R.attr.colorControlNormal;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
            i3 = C0555R.attr.colorControlActivated;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            i2 = -1;
        } else if (i == C0555R.C0556drawable.abc_list_divider_mtrl_alpha) {
            i3 = 16842800;
            i2 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == C0555R.C0556drawable.abc_dialog_material_background) {
            i3 = 16842801;
            mode = mode2;
            z = true;
            i2 = -1;
        } else {
            i2 = -1;
            i3 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i3), mode));
        if (i2 == -1) {
            return true;
        }
        drawable.setAlpha(i2);
        return true;
    }

    private void addDelegate(String str, InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new ArrayMap<>();
        }
        this.mDelegates.put(str, inflateDelegate);
    }

    private void removeDelegate(String str, InflateDelegate inflateDelegate) {
        if (this.mDelegates != null && this.mDelegates.get(str) == inflateDelegate) {
            this.mDelegates.remove(str);
        }
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    static PorterDuff.Mode getTintMode(int i) {
        if (i == C0555R.C0556drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getTintList(Context context, int i) {
        return getTintList(context, i, (ColorStateList) null);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getTintList(Context context, int i, ColorStateList colorStateList) {
        boolean z = colorStateList == null;
        ColorStateList tintListFromCache = z ? getTintListFromCache(context, i) : null;
        if (tintListFromCache == null) {
            if (i == C0555R.C0556drawable.abc_edit_text_material) {
                tintListFromCache = AppCompatResources.getColorStateList(context, C0555R.color.abc_tint_edittext);
            } else if (i == C0555R.C0556drawable.abc_switch_track_mtrl_alpha) {
                tintListFromCache = AppCompatResources.getColorStateList(context, C0555R.color.abc_tint_switch_track);
            } else if (i == C0555R.C0556drawable.abc_switch_thumb_material) {
                tintListFromCache = AppCompatResources.getColorStateList(context, C0555R.color.abc_tint_switch_thumb);
            } else if (i == C0555R.C0556drawable.abc_btn_default_mtrl_shape) {
                tintListFromCache = createDefaultButtonColorStateList(context, colorStateList);
            } else if (i == C0555R.C0556drawable.abc_btn_borderless_material) {
                tintListFromCache = createBorderlessButtonColorStateList(context, colorStateList);
            } else if (i == C0555R.C0556drawable.abc_btn_colored_material) {
                tintListFromCache = createColoredButtonColorStateList(context, colorStateList);
            } else if (i == C0555R.C0556drawable.abc_spinner_mtrl_am_alpha || i == C0555R.C0556drawable.abc_spinner_textfield_background_material) {
                tintListFromCache = AppCompatResources.getColorStateList(context, C0555R.color.abc_tint_spinner);
            } else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, i)) {
                tintListFromCache = ThemeUtils.getThemeAttrColorStateList(context, C0555R.attr.colorControlNormal);
            } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i)) {
                tintListFromCache = AppCompatResources.getColorStateList(context, C0555R.color.abc_tint_default);
            } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, i)) {
                tintListFromCache = AppCompatResources.getColorStateList(context, C0555R.color.abc_tint_btn_checkable);
            } else if (i == C0555R.C0556drawable.abc_seekbar_thumb_material) {
                tintListFromCache = AppCompatResources.getColorStateList(context, C0555R.color.abc_tint_seek_thumb);
            }
            if (z && tintListFromCache != null) {
                addTintListToCache(context, i, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    private ColorStateList getTintListFromCache(Context context, int i) {
        if (this.mTintLists == null) {
            return null;
        }
        SparseArray sparseArray = this.mTintLists.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    private void addTintListToCache(Context context, int i, ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap<>();
        }
        SparseArray sparseArray = this.mTintLists.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.mTintLists.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private ColorStateList createDefaultButtonColorStateList(Context context, ColorStateList colorStateList) {
        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorButtonNormal), colorStateList);
    }

    private ColorStateList createBorderlessButtonColorStateList(Context context, ColorStateList colorStateList) {
        return createButtonColorStateList(context, 0, (ColorStateList) null);
    }

    private ColorStateList createColoredButtonColorStateList(Context context, ColorStateList colorStateList) {
        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorAccent), colorStateList);
    }

    private ColorStateList createButtonColorStateList(Context context, int i, ColorStateList colorStateList) {
        int colorForState;
        int colorForState2;
        int[][] iArr = new int[4][];
        int[] iArr2 = new int[4];
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0555R.attr.colorControlHighlight);
        int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, C0555R.attr.colorButtonNormal);
        iArr[0] = ThemeUtils.DISABLED_STATE_SET;
        if (colorStateList != null) {
            disabledThemeAttrColor = colorStateList.getColorForState(iArr[0], 0);
        }
        iArr2[0] = disabledThemeAttrColor;
        iArr[1] = ThemeUtils.PRESSED_STATE_SET;
        if (colorStateList == null) {
            colorForState = i;
        } else {
            colorForState = colorStateList.getColorForState(iArr[1], 0);
        }
        iArr2[1] = ColorUtils.compositeColors(themeAttrColor, colorForState);
        iArr[2] = ThemeUtils.FOCUSED_STATE_SET;
        if (colorStateList == null) {
            colorForState2 = i;
        } else {
            colorForState2 = colorStateList.getColorForState(iArr[2], 0);
        }
        iArr2[2] = ColorUtils.compositeColors(themeAttrColor, colorForState2);
        iArr[3] = ThemeUtils.EMPTY_STATE_SET;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(iArr[3], 0);
        }
        iArr2[3] = i;
        return new ColorStateList(iArr, iArr2);
    }

    /* renamed from: android.support.v7.widget.AppCompatDrawableManager$ColorFilterLruCache */
    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter get(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter put(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }

        private static int generateCacheKey(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (!DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                drawable.setColorFilter(createTintFilter(tintInfo.mHasTintList ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = COLOR_FILTER_CACHE.get(i, mode);
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        PorterDuffColorFilter porterDuffColorFilter2 = new PorterDuffColorFilter(i, mode);
        COLOR_FILTER_CACHE.put(i, mode, porterDuffColorFilter2);
        return porterDuffColorFilter2;
    }

    private static void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = DEFAULT_MODE;
        }
        drawable.setColorFilter(getPorterDuffColorFilter(i, mode));
    }

    private void checkVectorDrawableSetup(Context context) {
        if (!this.mHasCheckedVectorDrawableSetup) {
            this.mHasCheckedVectorDrawableSetup = true;
            Drawable drawable = getDrawable(context, C0555R.C0556drawable.abc_vector_test);
            if (drawable == null || !isVectorDrawable(drawable)) {
                this.mHasCheckedVectorDrawableSetup = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean isVectorDrawable(Drawable drawable) {
        return (drawable instanceof C0152f) || PLATFORM_VD_CLAZZ.equals(drawable.getClass().getName());
    }

    /* renamed from: android.support.v7.widget.AppCompatDrawableManager$VdcInflateDelegate */
    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0152f.m918a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: android.support.v7.widget.AppCompatDrawableManager$AvdcInflateDelegate */
    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0143b.m894a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }
}
