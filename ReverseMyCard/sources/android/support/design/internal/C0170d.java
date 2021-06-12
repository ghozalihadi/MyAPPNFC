package android.support.design.internal;

import android.content.Context;
import android.os.Parcelable;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.support.p019v7.view.menu.MenuPresenter;
import android.support.p019v7.view.menu.MenuView;
import android.support.p019v7.view.menu.SubMenuBuilder;
import android.view.ViewGroup;

/* renamed from: android.support.design.internal.d */
/* compiled from: BottomNavigationPresenter */
public class C0170d implements MenuPresenter {

    /* renamed from: a */
    private MenuBuilder f535a;

    /* renamed from: b */
    private BottomNavigationMenuView f536b;

    /* renamed from: c */
    private boolean f537c = false;

    /* renamed from: a */
    public void mo634a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f536b = bottomNavigationMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.f536b.initialize(this.f535a);
        this.f535a = menuBuilder;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.f536b;
    }

    public void updateMenuView(boolean z) {
        if (!this.f537c) {
            if (z) {
                this.f536b.mo588a();
            } else {
                this.f536b.mo589b();
            }
        }
    }

    public void setCallback(MenuPresenter.Callback callback) {
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
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
        return -1;
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    /* renamed from: a */
    public void mo635a(boolean z) {
        this.f537c = z;
    }
}
