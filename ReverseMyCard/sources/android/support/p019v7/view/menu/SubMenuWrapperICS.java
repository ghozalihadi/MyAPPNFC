package android.support.p019v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p016v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.SubMenuWrapperICS */
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    public SupportSubMenu getWrappedObject() {
        return (SupportSubMenu) this.mWrappedObject;
    }

    public SubMenu setHeaderTitle(int i) {
        getWrappedObject().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        getWrappedObject().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        getWrappedObject().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        getWrappedObject().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        getWrappedObject().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        getWrappedObject().clearHeader();
    }

    public SubMenu setIcon(int i) {
        getWrappedObject().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        getWrappedObject().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return getMenuItemWrapper(getWrappedObject().getItem());
    }
}
