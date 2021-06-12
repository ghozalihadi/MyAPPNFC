package android.support.design.internal;

import android.content.Context;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.view.menu.MenuItemImpl;
import android.support.p019v7.view.menu.SubMenuBuilder;

/* renamed from: android.support.design.internal.g */
/* compiled from: NavigationSubMenu */
public class C0184g extends SubMenuBuilder {
    public C0184g(Context context, C0171e eVar, MenuItemImpl menuItemImpl) {
        super(context, eVar, menuItemImpl);
    }

    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((MenuBuilder) getParentMenu()).onItemsChanged(z);
    }
}
