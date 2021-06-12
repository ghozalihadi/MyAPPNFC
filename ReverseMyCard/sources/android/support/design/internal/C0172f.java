package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.R;
import android.support.p016v4.view.ViewCompat;
import android.support.p016v4.view.WindowInsetsCompat;
import android.support.p019v7.view.menu.ListMenuPresenter;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.support.p019v7.view.menu.MenuPresenter;
import android.support.p019v7.view.menu.MenuView;
import android.support.p019v7.view.menu.SubMenuBuilder;
import android.support.p019v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.design.internal.f */
/* compiled from: NavigationMenuPresenter */
public class C0172f implements MenuPresenter {

    /* renamed from: a */
    LinearLayout f538a;

    /* renamed from: b */
    MenuBuilder f539b;

    /* renamed from: c */
    C0175b f540c;

    /* renamed from: d */
    LayoutInflater f541d;

    /* renamed from: e */
    int f542e;

    /* renamed from: f */
    boolean f543f;

    /* renamed from: g */
    ColorStateList f544g;

    /* renamed from: h */
    ColorStateList f545h;

    /* renamed from: i */
    Drawable f546i;

    /* renamed from: j */
    int f547j;

    /* renamed from: k */
    final View.OnClickListener f548k = new View.OnClickListener() {
        public void onClick(View view) {
            C0172f.this.mo655a(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            boolean performItemAction = C0172f.this.f539b.performItemAction(itemData, C0172f.this, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                C0172f.this.f540c.mo668a(itemData);
            }
            C0172f.this.mo655a(false);
            C0172f.this.updateMenuView(false);
        }
    };

    /* renamed from: l */
    private NavigationMenuView f549l;

    /* renamed from: m */
    private MenuPresenter.Callback f550m;

    /* renamed from: n */
    private int f551n;

    /* renamed from: o */
    private int f552o;

    /* renamed from: android.support.design.internal.f$d */
    /* compiled from: NavigationMenuPresenter */
    private interface C0177d {
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.f541d = LayoutInflater.from(context);
        this.f539b = menuBuilder;
        this.f547j = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f549l == null) {
            this.f549l = (NavigationMenuView) this.f541d.inflate(R.layout.design_navigation_menu, viewGroup, false);
            if (this.f540c == null) {
                this.f540c = new C0175b();
            }
            this.f538a = (LinearLayout) this.f541d.inflate(R.layout.design_navigation_item_header, this.f549l, false);
            this.f549l.setAdapter(this.f540c);
        }
        return this.f549l;
    }

    public void updateMenuView(boolean z) {
        if (this.f540c != null) {
            this.f540c.mo664a();
        }
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f550m = callback;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.f550m != null) {
            this.f550m.onCloseMenu(menuBuilder, z);
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public int getId() {
        return this.f551n;
    }

    /* renamed from: a */
    public void mo649a(int i) {
        this.f551n = i;
    }

    public Parcelable onSaveInstanceState() {
        if (Build.VERSION.SDK_INT < 11) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.f549l != null) {
            SparseArray sparseArray = new SparseArray();
            this.f549l.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        if (this.f540c == null) {
            return bundle;
        }
        bundle.putBundle("android:menu:adapter", this.f540c.mo670b());
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.f549l.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f540c.mo665a(bundle2);
            }
        }
    }

    /* renamed from: a */
    public void mo653a(MenuItemImpl menuItemImpl) {
        this.f540c.mo668a(menuItemImpl);
    }

    /* renamed from: b */
    public View mo657b(int i) {
        View inflate = this.f541d.inflate(i, this.f538a, false);
        mo654a(inflate);
        return inflate;
    }

    /* renamed from: a */
    public void mo654a(View view) {
        this.f538a.addView(view);
        this.f549l.setPadding(0, 0, 0, this.f549l.getPaddingBottom());
    }

    /* renamed from: a */
    public int mo648a() {
        return this.f538a.getChildCount();
    }

    /* renamed from: b */
    public ColorStateList mo656b() {
        return this.f545h;
    }

    /* renamed from: a */
    public void mo650a(ColorStateList colorStateList) {
        this.f545h = colorStateList;
        updateMenuView(false);
    }

    /* renamed from: c */
    public ColorStateList mo659c() {
        return this.f544g;
    }

    /* renamed from: b */
    public void mo658b(ColorStateList colorStateList) {
        this.f544g = colorStateList;
        updateMenuView(false);
    }

    /* renamed from: c */
    public void mo660c(int i) {
        this.f542e = i;
        this.f543f = true;
        updateMenuView(false);
    }

    /* renamed from: d */
    public Drawable mo661d() {
        return this.f546i;
    }

    /* renamed from: a */
    public void mo651a(Drawable drawable) {
        this.f546i = drawable;
        updateMenuView(false);
    }

    /* renamed from: a */
    public void mo655a(boolean z) {
        if (this.f540c != null) {
            this.f540c.mo669a(z);
        }
    }

    /* renamed from: a */
    public void mo652a(WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.f552o != systemWindowInsetTop) {
            this.f552o = systemWindowInsetTop;
            if (this.f538a.getChildCount() == 0) {
                this.f549l.setPadding(0, this.f552o, 0, this.f549l.getPaddingBottom());
            }
        }
        ViewCompat.dispatchApplyWindowInsets(this.f538a, windowInsetsCompat);
    }

    /* renamed from: android.support.design.internal.f$j */
    /* compiled from: NavigationMenuPresenter */
    private static abstract class C0183j extends RecyclerView.ViewHolder {
        public C0183j(View view) {
            super(view);
        }
    }

    /* renamed from: android.support.design.internal.f$g */
    /* compiled from: NavigationMenuPresenter */
    private static class C0180g extends C0183j {
        public C0180g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: android.support.design.internal.f$i */
    /* compiled from: NavigationMenuPresenter */
    private static class C0182i extends C0183j {
        public C0182i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* renamed from: android.support.design.internal.f$h */
    /* compiled from: NavigationMenuPresenter */
    private static class C0181h extends C0183j {
        public C0181h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* renamed from: android.support.design.internal.f$a */
    /* compiled from: NavigationMenuPresenter */
    private static class C0174a extends C0183j {
        public C0174a(View view) {
            super(view);
        }
    }

    /* renamed from: android.support.design.internal.f$b */
    /* compiled from: NavigationMenuPresenter */
    private class C0175b extends RecyclerView.Adapter<C0183j> {

        /* renamed from: b */
        private final ArrayList<C0177d> f555b = new ArrayList<>();

        /* renamed from: c */
        private MenuItemImpl f556c;

        /* renamed from: d */
        private boolean f557d;

        C0175b() {
            m994c();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemCount() {
            return this.f555b.size();
        }

        public int getItemViewType(int i) {
            C0177d dVar = this.f555b.get(i);
            if (dVar instanceof C0178e) {
                return 2;
            }
            if (dVar instanceof C0176c) {
                return 3;
            }
            if (!(dVar instanceof C0179f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((C0179f) dVar).mo679a().hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        /* renamed from: a */
        public C0183j onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new C0180g(C0172f.this.f541d, viewGroup, C0172f.this.f548k);
                case 1:
                    return new C0182i(C0172f.this.f541d, viewGroup);
                case 2:
                    return new C0181h(C0172f.this.f541d, viewGroup);
                case 3:
                    return new C0174a(C0172f.this.f538a);
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public void onBindViewHolder(C0183j jVar, int i) {
            switch (getItemViewType(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.itemView;
                    navigationMenuItemView.setIconTintList(C0172f.this.f545h);
                    if (C0172f.this.f543f) {
                        navigationMenuItemView.setTextAppearance(C0172f.this.f542e);
                    }
                    if (C0172f.this.f544g != null) {
                        navigationMenuItemView.setTextColor(C0172f.this.f544g);
                    }
                    ViewCompat.setBackground(navigationMenuItemView, C0172f.this.f546i != null ? C0172f.this.f546i.getConstantState().newDrawable() : null);
                    C0179f fVar = (C0179f) this.f555b.get(i);
                    navigationMenuItemView.setNeedsEmptyIcon(fVar.f560a);
                    navigationMenuItemView.initialize(fVar.mo679a(), 0);
                    return;
                case 1:
                    ((TextView) jVar.itemView).setText(((C0179f) this.f555b.get(i)).mo679a().getTitle());
                    return;
                case 2:
                    C0178e eVar = (C0178e) this.f555b.get(i);
                    jVar.itemView.setPadding(0, eVar.mo677a(), 0, eVar.mo678b());
                    return;
                default:
                    return;
            }
        }

        /* renamed from: a */
        public void onViewRecycled(C0183j jVar) {
            if (jVar instanceof C0180g) {
                ((NavigationMenuItemView) jVar.itemView).mo613a();
            }
        }

        /* renamed from: a */
        public void mo664a() {
            m994c();
            notifyDataSetChanged();
        }

        /* renamed from: c */
        private void m994c() {
            boolean z;
            int i;
            int i2;
            if (!this.f557d) {
                this.f557d = true;
                this.f555b.clear();
                this.f555b.add(new C0176c());
                int i3 = -1;
                int i4 = 0;
                boolean z2 = false;
                int size = C0172f.this.f539b.getVisibleItems().size();
                int i5 = 0;
                while (i5 < size) {
                    MenuItemImpl menuItemImpl = C0172f.this.f539b.getVisibleItems().get(i5);
                    if (menuItemImpl.isChecked()) {
                        mo668a(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.setExclusiveCheckable(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i5 != 0) {
                                this.f555b.add(new C0178e(C0172f.this.f547j, 0));
                            }
                            this.f555b.add(new C0179f(menuItemImpl));
                            boolean z3 = false;
                            int size2 = this.f555b.size();
                            int size3 = subMenu.size();
                            for (int i6 = 0; i6 < size3; i6++) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i6);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z3 && menuItemImpl2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.setExclusiveCheckable(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        mo668a(menuItemImpl);
                                    }
                                    this.f555b.add(new C0179f(menuItemImpl2));
                                }
                            }
                            if (z3) {
                                m993a(size2, this.f555b.size());
                            }
                        }
                        i2 = i3;
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i3) {
                            i = this.f555b.size();
                            z = menuItemImpl.getIcon() != null;
                            if (i5 != 0) {
                                i++;
                                this.f555b.add(new C0178e(C0172f.this.f547j, C0172f.this.f547j));
                            }
                        } else if (z2 || menuItemImpl.getIcon() == null) {
                            z = z2;
                            i = i4;
                        } else {
                            z = true;
                            m993a(i4, this.f555b.size());
                            i = i4;
                        }
                        C0179f fVar = new C0179f(menuItemImpl);
                        fVar.f560a = z;
                        this.f555b.add(fVar);
                        z2 = z;
                        i4 = i;
                        i2 = groupId;
                    }
                    i5++;
                    i3 = i2;
                }
                this.f557d = false;
            }
        }

        /* renamed from: a */
        private void m993a(int i, int i2) {
            while (i < i2) {
                ((C0179f) this.f555b.get(i)).f560a = true;
                i++;
            }
        }

        /* renamed from: a */
        public void mo668a(MenuItemImpl menuItemImpl) {
            if (this.f556c != menuItemImpl && menuItemImpl.isCheckable()) {
                if (this.f556c != null) {
                    this.f556c.setChecked(false);
                }
                this.f556c = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        /* renamed from: b */
        public Bundle mo670b() {
            Bundle bundle = new Bundle();
            if (this.f556c != null) {
                bundle.putInt("android:menu:checked", this.f556c.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<C0177d> it = this.f555b.iterator();
            while (it.hasNext()) {
                C0177d next = it.next();
                if (next instanceof C0179f) {
                    MenuItemImpl a = ((C0179f) next).mo679a();
                    View actionView = a != null ? a.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        /* renamed from: a */
        public void mo665a(Bundle bundle) {
            MenuItemImpl a;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f557d = true;
                Iterator<C0177d> it = this.f555b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0177d next = it.next();
                    if ((next instanceof C0179f) && (a = ((C0179f) next).mo679a()) != null && a.getItemId() == i) {
                        mo668a(a);
                        break;
                    }
                }
                this.f557d = false;
                m994c();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            Iterator<C0177d> it2 = this.f555b.iterator();
            while (it2.hasNext()) {
                C0177d next2 = it2.next();
                if (next2 instanceof C0179f) {
                    MenuItemImpl a2 = ((C0179f) next2).mo679a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray.get(a2.getItemId()));
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo669a(boolean z) {
            this.f557d = z;
        }
    }

    /* renamed from: android.support.design.internal.f$f */
    /* compiled from: NavigationMenuPresenter */
    private static class C0179f implements C0177d {

        /* renamed from: a */
        boolean f560a;

        /* renamed from: b */
        private final MenuItemImpl f561b;

        C0179f(MenuItemImpl menuItemImpl) {
            this.f561b = menuItemImpl;
        }

        /* renamed from: a */
        public MenuItemImpl mo679a() {
            return this.f561b;
        }
    }

    /* renamed from: android.support.design.internal.f$e */
    /* compiled from: NavigationMenuPresenter */
    private static class C0178e implements C0177d {

        /* renamed from: a */
        private final int f558a;

        /* renamed from: b */
        private final int f559b;

        public C0178e(int i, int i2) {
            this.f558a = i;
            this.f559b = i2;
        }

        /* renamed from: a */
        public int mo677a() {
            return this.f558a;
        }

        /* renamed from: b */
        public int mo678b() {
            return this.f559b;
        }
    }

    /* renamed from: android.support.design.internal.f$c */
    /* compiled from: NavigationMenuPresenter */
    private static class C0176c implements C0177d {
        C0176c() {
        }
    }
}
