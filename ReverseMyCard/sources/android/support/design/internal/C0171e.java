package android.support.design.internal;

import android.content.Context;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.view.SubMenu;

/* renamed from: android.support.design.internal.e */
/* compiled from: NavigationMenu */
public class C0171e extends MenuBuilder {
    public C0171e(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i2, i3, charSequence);
        C0184g gVar = new C0184g(getContext(), this, menuItemImpl);
        menuItemImpl.setSubMenu(gVar);
        return gVar;
    }
}
