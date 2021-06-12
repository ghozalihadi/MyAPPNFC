package android.support.design.internal;

import android.content.Context;
import android.support.p019v7.view.menu.MenuBuilder;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.design.internal.c */
/* compiled from: BottomNavigationMenu */
public final class C0169c extends MenuBuilder {
    public C0169c(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    /* access modifiers changed from: protected */
    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 <= 5) {
            return super.addInternal(i, i2, i3, charSequence);
        }
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }
}
