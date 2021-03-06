package android.support.design.internal;

import android.content.Context;
import android.support.p019v7.view.menu.MenuBuilder;
import android.support.p019v7.view.menu.MenuView;
import android.support.p019v7.widget.LinearLayoutManager;
import android.support.p019v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView extends RecyclerView implements MenuView {
    public NavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }

    public void initialize(MenuBuilder menuBuilder) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
