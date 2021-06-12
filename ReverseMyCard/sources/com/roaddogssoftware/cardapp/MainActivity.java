package com.roaddogssoftware.cardapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.cardemulation.CardEmulation;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.p016v4.app.ActivityCompat;
import android.support.p016v4.app.FragmentTransaction;
import android.support.p016v4.content.ContextCompat;
import android.support.p016v4.view.GravityCompat;
import android.support.p016v4.widget.DrawerLayout;
import android.support.p019v7.app.ActionBarDrawerToggle;
import android.support.p019v7.app.AlertDialog;
import android.support.p019v7.app.AppCompatActivity;
import android.support.p019v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.roaddogssoftware.cardapp.R;
import com.roaddogssoftware.cardapp.p029a.C0725a;
import com.roaddogssoftware.cardapp.p029a.C0732b;
import com.roaddogssoftware.cardapp.p029a.C0742e;
import com.roaddogssoftware.cardapp.p029a.C0749f;
import com.roaddogssoftware.cardapp.p029a.C0750g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements NavigationView.C0217a {

    /* renamed from: A */
    public static C0724a f1387A;

    /* renamed from: B */
    public static ArrayList<C0724a> f1388B = new ArrayList<>();

    /* renamed from: C */
    public static ArrayList<Integer> f1389C = new ArrayList<>();

    /* renamed from: D */
    public static ActionMode f1390D;

    /* renamed from: E */
    public static FloatingActionButton f1391E;

    /* renamed from: F */
    public static FrameLayout f1392F;

    /* renamed from: G */
    public static int f1393G = 0;

    /* renamed from: H */
    public static double f1394H = 1.5697d;

    /* renamed from: I */
    public static int f1395I = 0;

    /* renamed from: J */
    public static String f1396J = "";

    /* renamed from: K */
    public static ArrayList<Integer> f1397K = new ArrayList<>();

    /* renamed from: L */
    public static ArrayList<String> f1398L = new ArrayList<>();

    /* renamed from: M */
    public static ArrayList<Integer> f1399M = new ArrayList<>();

    /* renamed from: N */
    public static ArrayList<String> f1400N = new ArrayList<>();

    /* renamed from: O */
    public static int f1401O;

    /* renamed from: P */
    public static C0724a f1402P;

    /* renamed from: Q */
    public static String f1403Q = "";

    /* renamed from: R */
    public static C0742e f1404R = null;

    /* renamed from: S */
    public static C0732b f1405S = null;

    /* renamed from: T */
    public static C0725a f1406T = null;

    /* renamed from: U */
    public static C0750g f1407U = null;

    /* renamed from: V */
    public static C0749f f1408V = null;

    /* renamed from: Y */
    private static NavigationView f1409Y;

    /* renamed from: a */
    public static String f1410a = "";

    /* renamed from: b */
    public static String f1411b = "/mycard_log.txt";

    /* renamed from: c */
    public static int f1412c = 20;

    /* renamed from: d */
    public static DrawerLayout f1413d;

    /* renamed from: e */
    public static Context f1414e;

    /* renamed from: f */
    public static View f1415f;

    /* renamed from: g */
    public static Toolbar f1416g;

    /* renamed from: h */
    public static Button f1417h;

    /* renamed from: i */
    public static Button f1418i;

    /* renamed from: j */
    public static Button f1419j;

    /* renamed from: k */
    public static AlertDialog f1420k;

    /* renamed from: l */
    public static boolean f1421l = false;

    /* renamed from: m */
    public static boolean f1422m = true;

    /* renamed from: n */
    public static boolean f1423n = true;

    /* renamed from: o */
    public static boolean f1424o = false;

    /* renamed from: p */
    public static String f1425p = "";

    /* renamed from: q */
    public static boolean f1426q = false;

    /* renamed from: r */
    public static boolean f1427r = false;

    /* renamed from: s */
    public static boolean f1428s = false;

    /* renamed from: t */
    public static boolean f1429t = true;

    /* renamed from: u */
    public static C0788c f1430u;

    /* renamed from: v */
    public static String f1431v = "";

    /* renamed from: w */
    public static String f1432w = "";

    /* renamed from: x */
    public static String f1433x = "";

    /* renamed from: y */
    public static String f1434y = "";

    /* renamed from: z */
    public static int f1435z;

    /* renamed from: W */
    Menu f1436W;

    /* renamed from: X */
    private Tag f1437X;

    /* renamed from: Z */
    private ActionMode.Callback f1438Z = new ActionMode.Callback() {
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.action_menu, menu);
            MainActivity.this.f1436W = menu;
            return true;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            MainActivity.f1390D = actionMode;
            if (MainActivity.f1389C.size() == 0) {
                return false;
            }
            switch (menuItem.getItemId()) {
                case R.id.item_delete:
                    MainActivity.this.mo8174a(MainActivity.f1389C);
                    return true;
                case R.id.item_edit:
                    MainActivity.m2110a(MainActivity.f1389C.get(0).intValue(), false);
                    actionMode.finish();
                    return true;
                case R.id.item_move_up:
                    MainActivity.this.m2128g(MainActivity.f1389C.get(0).intValue());
                    actionMode.finish();
                    return true;
                case R.id.item_move_down:
                    MainActivity.this.m2130h(MainActivity.f1389C.get(0).intValue());
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            MainActivity.f1390D = null;
            MainActivity.f1389C = new ArrayList<>();
            MainActivity.f1405S.mo8244a();
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        f1416g = (Toolbar) findViewById(R.id.toolbar);
        f1417h = (Button) findViewById(R.id.toolbarButton1);
        f1418i = (Button) findViewById(R.id.toolbarButton2);
        f1419j = (Button) findViewById(R.id.toolbarButton3);
        f1392F = (FrameLayout) findViewById(R.id.frame_fragment);
        setSupportActionBar(f1416g);
        f1415f = findViewById(R.id.drawer_layout);
        f1414e = this;
        f1393G = (int) (((double) f1414e.getResources().getDisplayMetrics().widthPixels) / f1394H);
        try {
            f1391E = (FloatingActionButton) findViewById(R.id.fab);
            f1391E.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MainActivity.this.m2133p();
                }
            });
            f1413d = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, f1413d, f1416g, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            f1413d.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
            f1409Y = (NavigationView) findViewById(R.id.nav_view);
            f1409Y.setNavigationItemSelectedListener(this);
            f1409Y.getMenu().getItem(0).setChecked(true);
            if (Build.VERSION.SDK_INT >= 23) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") != 0) {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, 1);
                }
                if (ContextCompat.checkSelfPermission(this, "android.permission.SYSTEM_ALERT_WINDOW") != 0) {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.SYSTEM_ALERT_WINDOW"}, 1);
                }
                if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 1);
                }
            }
        } catch (Exception e) {
            m2124e("1: " + e.getMessage());
            C0797h.m2364a("1: " + e.getMessage());
        }
        try {
            f1425p = mo8185k();
            if (f1425p != null && !f1425p.isEmpty()) {
                f1424o = true;
                f1426q = mo8186l();
            }
            m2143z();
            f1430u = new C0788c(this);
            f1388B = f1430u.mo8317a();
            f1423n = mo8187m();
            f1427r = mo8188n();
            f1431v = mo8181g();
            f1432w = mo8182h();
            f1434y = mo8183i();
            f1433x = mo8184j();
            f1387A = new C0724a(f1431v, f1432w);
            f1387A.f1500H = f1433x;
            f1387A.f1498F = C0797h.m2366b(f1433x);
            f1435z = m2122d(f1387A.f1508h);
            if (f1387A.f1498F == 0) {
                f1433x = "card_empty";
                f1387A.f1500H = "card_empty";
                f1387A.f1498F = C0797h.m2366b(f1433x);
            }
            f1387A.f1499G = C0797h.m2367c(f1387A.f1500H);
            f1387A.f1512l = m2120c(f1431v);
        } catch (Exception e2) {
            m2124e("2: " + e2.getMessage());
            C0797h.m2364a("2: " + e2.getMessage());
        }
        try {
            if (CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this)).isDefaultServiceForCategory(new ComponentName(getApplicationContext(), PaymentService.class.getCanonicalName()), "payment")) {
                f1421l = false;
                f1422m = true;
                m2108C();
            }
        } catch (Exception e3) {
            C0797h.m2364a("3: " + e3.getMessage());
            f1429t = false;
            f1409Y.getMenu().findItem(R.id.nav_set_as_default_pay).setVisible(false);
            f1409Y.getMenu().findItem(R.id.warning_nfc).setVisible(true);
        }
        try {
            f1404R = new C0742e();
            f1405S = new C0732b();
            f1407U = new C0750g();
            f1406T = C0725a.m2194a(-1, false);
            f1408V = new C0749f();
            mo8172a();
            if (f1421l) {
                m2106A();
            }
            m2142y();
        } catch (Exception e4) {
            m2124e("4: " + e4.getMessage());
            C0797h.m2364a("4: " + e4.getMessage());
        }
    }

    public void onStart() {
        super.onStart();
        try {
            if (f1426q) {
                f1392F.setVisibility(4);
                m2109D();
            }
        } catch (Exception e) {
            m2124e("8: " + e.getMessage());
            C0797h.m2364a("8: " + e.getMessage());
        }
    }

    public void onBackPressed() {
        if (f1413d.isDrawerOpen((int) GravityCompat.START)) {
            f1413d.closeDrawer((int) GravityCompat.START);
            return;
        }
        String str = f1403Q;
        char c = 65535;
        switch (str.hashCode()) {
            case -1465705888:
                if (str.equals("FRAG_CARD_LIST")) {
                    c = 2;
                    break;
                }
                break;
            case -1465408409:
                if (str.equals("FRAG_CARD_VIEW")) {
                    c = 1;
                    break;
                }
                break;
            case -1110409460:
                if (str.equals("FRAG_HOME")) {
                    c = 0;
                    break;
                }
                break;
            case -960995376:
                if (str.equals("FRAG_SETTINGS")) {
                    c = 4;
                    break;
                }
                break;
            case 692554683:
                if (str.equals("FRAG_ADD_CARD")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                finish();
                return;
            case 1:
                super.onBackPressed();
                return;
            case 2:
                mo8172a();
                return;
            case 3:
                if (f1406T.f1537c) {
                    f1406T.mo8234c();
                }
                f1406T.f1537c = false;
                if (f1428s) {
                    f1428s = false;
                    C0732b bVar = f1405S;
                    C0732b.f1570d = true;
                    if (!C0725a.f1528d) {
                        mo8175b();
                        return;
                    } else {
                        mo8172a();
                        return;
                    }
                } else {
                    super.onBackPressed();
                    return;
                }
            case 4:
                mo8172a();
                return;
            default:
                super.onBackPressed();
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            if (CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this)).isDefaultServiceForCategory(new ComponentName(getApplicationContext(), PaymentService.class.getCanonicalName()), "payment")) {
                f1422m = true;
                m2108C();
                m2119b("Set as default payment app");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1437X = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        if (this.f1437X != null) {
            f1406T.f1536a.mo8250a(this.f1437X);
        }
    }

    /* renamed from: a */
    public boolean mo1015a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.nav_home) {
            mo8172a();
        } else if (itemId == R.id.nav_card_list) {
            mo8175b();
        } else if (itemId == R.id.nav_add_card) {
            mo8177c();
            f1413d.closeDrawer((int) GravityCompat.START);
            return false;
        } else if (itemId == R.id.nav_settings) {
            mo8178d();
        } else if (itemId == R.id.nav_set_as_default_pay) {
            m2106A();
        }
        f1413d.closeDrawer((int) GravityCompat.START);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m2133p() {
        String str = f1403Q;
        char c = 65535;
        switch (str.hashCode()) {
            case -1465705888:
                if (str.equals("FRAG_CARD_LIST")) {
                    c = 2;
                    break;
                }
                break;
            case -1465408409:
                if (str.equals("FRAG_CARD_VIEW")) {
                    c = 1;
                    break;
                }
                break;
            case -1110409460:
                if (str.equals("FRAG_HOME")) {
                    c = 0;
                    break;
                }
                break;
            case -960995376:
                if (str.equals("FRAG_SETTINGS")) {
                    c = 4;
                    break;
                }
                break;
            case 692554683:
                if (str.equals("FRAG_ADD_CARD")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                mo8177c();
                return;
            case 2:
                mo8177c();
                return;
            case 3:
                f1406T.addThisCard();
                return;
            default:
                return;
        }
    }

    public void toolbarButton1(View view) {
        if (f1403Q.equals("FRAG_ADD_CARD")) {
            f1406T.mo8234c();
            f1406T.f1537c = false;
            onBackPressed();
        }
    }

    public void toolbarButton2(View view) {
        if (f1403Q.equals("FRAG_ADD_CARD")) {
            f1406T.addThisCard();
        }
    }

    public void toolbarButton3(View view) {
        if (f1403Q.equals("FRAG_ADD_CARD")) {
            f1406T.mo8231a();
        }
    }

    /* renamed from: a */
    public void mo8173a(int i) {
        if (f1390D == null) {
            m2121c(i);
            f1405S.mo8244a();
            return;
        }
        if (f1389C.contains(Integer.valueOf(i))) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= f1389C.size()) {
                    break;
                } else if (f1389C.get(i3).intValue() == i) {
                    f1389C.remove(i3);
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (f1389C.size() == 0) {
                f1390D.finish();
            } else if (f1389C.size() == 1) {
                m2134q();
            } else {
                m2135r();
            }
        } else {
            f1389C.add(Integer.valueOf(i));
            m2135r();
        }
        f1405S.mo8244a();
    }

    /* renamed from: b */
    public boolean mo8176b(int i) {
        if (f1390D == null) {
            f1390D = startActionMode(this.f1438Z);
            if (f1390D != null) {
                f1389C.add(Integer.valueOf(i));
                m2134q();
            }
            f1405S.mo8244a();
            return true;
        } else if (f1389C.contains(Integer.valueOf(i))) {
            int i2 = 0;
            while (true) {
                if (i2 >= f1389C.size()) {
                    break;
                } else if (f1389C.get(i2).intValue() == i) {
                    f1389C.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
            if (f1389C.size() == 0) {
                f1390D.finish();
            } else if (f1389C.size() == 1) {
                m2134q();
            } else {
                m2135r();
            }
            f1405S.mo8244a();
            return false;
        } else {
            f1389C.add(Integer.valueOf(i));
            m2135r();
            f1405S.mo8244a();
            return false;
        }
    }

    /* renamed from: q */
    private void m2134q() {
        if (this.f1436W != null) {
            f1390D.setTitle("1 Card");
            this.f1436W.getItem(1).setVisible(true);
            this.f1436W.getItem(2).setVisible(true);
            this.f1436W.getItem(3).setVisible(true);
        }
    }

    /* renamed from: r */
    private void m2135r() {
        if (this.f1436W != null) {
            f1390D.setTitle(f1389C.size() + " Cards");
            this.f1436W.getItem(1).setVisible(false);
            this.f1436W.getItem(2).setVisible(false);
            this.f1436W.getItem(3).setVisible(false);
        }
    }

    /* renamed from: a */
    public static void m2116a(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1465705888:
                if (str.equals("FRAG_CARD_LIST")) {
                    c = 1;
                    break;
                }
                break;
            case -1465408409:
                if (str.equals("FRAG_CARD_VIEW")) {
                    c = 4;
                    break;
                }
                break;
            case -1350141304:
                if (str.equals("FRAG_SELECT_PICTURE")) {
                    c = 5;
                    break;
                }
                break;
            case -1110409460:
                if (str.equals("FRAG_HOME")) {
                    c = 0;
                    break;
                }
                break;
            case -960995376:
                if (str.equals("FRAG_SETTINGS")) {
                    c = 3;
                    break;
                }
                break;
            case 692554683:
                if (str.equals("FRAG_ADD_CARD")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                m2136s();
                return;
            case 1:
                m2137t();
                return;
            case 2:
                m2138u();
                return;
            case 3:
                m2139v();
                return;
            case 4:
                m2140w();
                return;
            case 5:
                m2141x();
                return;
            default:
                return;
        }
    }

    /* renamed from: s */
    private static void m2136s() {
        f1403Q = "FRAG_HOME";
        f1391E.setImageDrawable(ContextCompat.getDrawable(f1414e, R.drawable.ic_add_white_24dp));
        f1391E.mo953a();
        f1409Y.getMenu().getItem(0).setChecked(true);
        m2131i(R.string.app_name);
        f1417h.setVisibility(8);
        f1418i.setVisibility(8);
        f1419j.setVisibility(8);
        f1406T.f1537c = false;
    }

    /* renamed from: t */
    private static void m2137t() {
        f1403Q = "FRAG_CARD_LIST";
        f1391E.setImageDrawable(ContextCompat.getDrawable(f1414e, R.drawable.ic_add_white_24dp));
        f1391E.mo953a();
        f1409Y.getMenu().getItem(1).setChecked(true);
        m2131i(R.string.app_name);
        f1417h.setVisibility(8);
        f1418i.setVisibility(8);
        f1419j.setVisibility(8);
        f1406T.f1537c = false;
    }

    /* renamed from: u */
    private static void m2138u() {
        f1403Q = "FRAG_ADD_CARD";
        f1391E.mo957b();
        f1409Y.getMenu().getItem(2).setChecked(true);
        if (f1406T.f1537c) {
            m2131i(R.string.drawer_edit_card);
        } else {
            m2131i(R.string.drawer_add_card);
        }
        f1417h.setVisibility(0);
        f1418i.setVisibility(0);
    }

    /* renamed from: v */
    private static void m2139v() {
        f1403Q = "FRAG_SETTINGS";
        f1391E.mo957b();
        f1409Y.getMenu().getItem(3).setChecked(true);
        m2131i(R.string.drawer_settings);
        f1417h.setVisibility(8);
        f1418i.setVisibility(8);
        f1419j.setVisibility(8);
        f1406T.f1537c = false;
    }

    /* renamed from: w */
    private static void m2140w() {
        f1403Q = "FRAG_CARD_VIEW";
        f1391E.mo957b();
        m2131i(R.string.app_name);
        f1417h.setVisibility(8);
        f1418i.setVisibility(8);
        f1419j.setVisibility(8);
        f1406T.f1537c = false;
    }

    /* renamed from: x */
    private static void m2141x() {
        f1403Q = "FRAG_SELECT_PICTURE";
        f1391E.mo957b();
        m2131i(R.string.title_activity_select_picture);
        f1417h.setVisibility(8);
        f1418i.setVisibility(8);
        f1419j.setVisibility(8);
    }

    /* renamed from: a */
    public void mo8172a() {
        if (f1390D != null) {
            f1390D.finish();
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame_fragment, f1404R);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    /* renamed from: b */
    public void mo8175b() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame_fragment, f1405S);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    /* renamed from: c */
    public void mo8177c() {
        if (f1390D != null) {
            f1390D.finish();
        }
        if (!f1406T.f1537c) {
            C0725a aVar = f1406T;
            C0725a.f1527b = -1;
        }
        if (f1406T.f1537c) {
            f1406T = C0725a.m2194a(-1, false);
        } else if (f1388B.size() >= f1412c) {
            m2119b("App limit is " + f1412c + " cards");
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame_fragment, f1406T);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    /* renamed from: d */
    public void mo8178d() {
        if (f1390D != null) {
            f1390D.finish();
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame_fragment, f1407U);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    /* renamed from: e */
    public void mo8180e() {
        if (f1390D != null) {
            f1390D.finish();
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame_fragment, f1408V);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    /* renamed from: c */
    public static void m2121c(int i) {
        if (i == -1) {
            f1431v = "";
            f1432w = "";
            f1433x = "";
            f1434y = "";
            f1435z = -1;
            m2117a(f1431v, f1432w, f1433x, f1434y);
        } else if (f1388B.get(i).f1508h.equals(f1431v)) {
        } else {
            if (f1388B.get(i).f1501a) {
                f1431v = f1388B.get(i).f1508h;
                f1432w = f1388B.get(i).f1506f;
                f1433x = f1388B.get(i).f1500H;
                f1434y = f1388B.get(i).f1509i;
                m2117a(f1431v, f1432w, f1433x, f1434y);
                m2142y();
                return;
            }
            m2119b("Invalid swipe data");
        }
    }

    /* renamed from: y */
    private static void m2142y() {
        for (int i = 0; i < f1388B.size(); i++) {
            if (f1388B.get(i).f1508h.equals(f1431v)) {
                f1435z = i;
                f1387A = f1388B.get(i);
                f1388B.get(i).f1505e = true;
            } else {
                f1388B.get(i).f1505e = false;
            }
        }
    }

    /* renamed from: a */
    public static void m2110a(int i, boolean z) {
        f1395I = f1388B.get(i).f1498F;
        f1396J = f1388B.get(i).f1500H;
        f1406T = C0725a.m2194a(i, z);
        FragmentTransaction beginTransaction = ((MainActivity) f1414e).getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame_fragment, f1406T);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    /* renamed from: a */
    public static void m2114a(C0724a aVar) {
        f1430u.mo8320a(aVar.f1508h, aVar.f1506f, aVar.f1500H, aVar.f1512l, aVar.f1509i, aVar.f1522v, aVar.f1523w);
        f1388B.add(aVar);
        f1405S.mo8244a();
        if (f1388B.size() == 1) {
            m2121c(0);
        }
        f1404R.mo8261d();
    }

    /* renamed from: a */
    public static void m2115a(C0724a aVar, int i) {
        f1430u.mo8321a(aVar.f1508h, aVar.f1506f, aVar.f1500H, aVar.f1512l, aVar.f1509i, aVar.f1522v, aVar.f1523w, i);
        f1388B.add(i, aVar);
        f1405S.mo8244a();
        if (f1435z >= i) {
            f1435z++;
            m2121c(f1435z);
        }
    }

    /* renamed from: a */
    public void mo8174a(final ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1) {
            mo8179d(arrayList.get(0).intValue());
        } else {
            new AlertDialog.Builder(this).setIcon((int) R.drawable.ic_alert).setTitle((CharSequence) "Delete " + arrayList.size() + " cards?").setNegativeButton((CharSequence) "No", (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Collections.sort(arrayList);
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        MainActivity.m2123e(((Integer) arrayList.get(size)).intValue());
                    }
                    if (MainActivity.f1390D != null) {
                        MainActivity.f1390D.finish();
                    }
                    MainActivity.f1405S.mo8244a();
                }
            }).show();
        }
    }

    /* renamed from: d */
    public void mo8179d(final int i) {
        new AlertDialog.Builder(this).setIcon((int) R.drawable.ic_alert).setTitle((CharSequence) "Delete card " + f1388B.get(i).f1508h + "?").setNegativeButton((CharSequence) "No", (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.m2123e(i);
                MainActivity.f1405S.mo8244a();
                if (MainActivity.f1390D != null) {
                    MainActivity.f1390D.finish();
                }
            }
        }).show();
    }

    /* renamed from: e */
    public static void m2123e(int i) {
        f1430u.mo8318a(f1388B.get(i).f1508h);
        f1388B.remove(i);
        if (i == f1435z) {
            if (f1388B.size() > i) {
                m2121c(i);
            } else if (f1388B.size() > 0) {
                m2121c(f1388B.size() - 1);
            }
        } else if (i < f1435z) {
            f1435z--;
        }
        if (f1388B.size() == 0) {
            f1404R.mo8260c();
            m2121c(-1);
        }
        f1405S.mo8244a();
        if (f1403Q.equals("FRAG_HOME")) {
            f1404R = new C0742e();
            ((MainActivity) f1414e).mo8172a();
        }
    }

    /* renamed from: c */
    private String m2120c(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= f1388B.size()) {
                return "";
            }
            if (f1388B.get(i2).f1508h.equals(str)) {
                return f1388B.get(i2).f1512l;
            }
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m2128g(int i) {
        if (i != 0) {
            m2123e(i);
            m2115a(f1388B.get(i), i - 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m2130h(int i) {
        if (i != f1388B.size() - 1) {
            m2123e(i);
            m2115a(f1388B.get(i), i + 1);
        }
    }

    /* renamed from: d */
    private int m2122d(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= f1388B.size()) {
                return -1;
            }
            if (str.equals(f1388B.get(i2).f1508h)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: f */
    public static void m2126f(int i) {
        f1402P = f1388B.get(i);
        f1402P.f1505e = false;
        f1401O = i;
        m2123e(i);
        f1405S.mo8244a();
        m2125f();
    }

    /* renamed from: f */
    public static void m2125f() {
        Snackbar.m1257a(f1415f, "Card deleted", 0).mo1018a("UNDO", new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.m2115a(MainActivity.f1402P, MainActivity.f1401O);
            }
        }).mo1019a();
    }

    /* renamed from: z */
    private void m2143z() {
        f1397K = new ArrayList<>();
        f1398L = new ArrayList<>();
        f1399M = new ArrayList<>();
        f1400N = new ArrayList<>();
        f1397K.add(Integer.valueOf(R.drawable.card_empty));
        f1398L.add("card_empty");
        f1399M.add(Integer.valueOf(R.drawable._small_card_empty));
        f1400N.add("_small_card_empty");
        for (Field field : R.drawable.class.getDeclaredFields()) {
            try {
                int i = field.getInt(R.drawable.class);
                String lowerCase = field.toString().toLowerCase();
                if ((lowerCase.contains("amex") || lowerCase.contains("visa") || lowerCase.contains("master") || lowerCase.contains("discover") || lowerCase.contains("blank")) && !lowerCase.contains("empty")) {
                    String str = "";
                    if (lowerCase.split("drawable.").length > 1) {
                        str = lowerCase.split("drawable.")[1];
                    }
                    if (!lowerCase.contains("small")) {
                        f1398L.add(str.replace("-", "_"));
                        f1397K.add(Integer.valueOf(i));
                    } else {
                        f1400N.add(str.replace("-", "_"));
                        f1399M.add(Integer.valueOf(i));
                    }
                }
            } catch (Exception e) {
            }
        }
        if (f1397K.size() > 0 && f1398L.size() > 0) {
            f1395I = f1397K.get(0).intValue();
            f1396J = f1398L.get(0);
        }
    }

    /* renamed from: i */
    private static void m2131i(int i) {
        ((MainActivity) f1414e).m2132j(i);
    }

    /* renamed from: j */
    private void m2132j(int i) {
        f1416g = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setTitle(i);
    }

    /* renamed from: e */
    private void m2124e(String str) {
    }

    /* renamed from: b */
    public static void m2119b(String str) {
        Snackbar.m1257a(f1415f, str, 0).mo1019a();
    }

    /* renamed from: g */
    public String mo8181g() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("SWIPE_NAME", "NAME");
    }

    /* renamed from: h */
    public String mo8182h() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("SWIPE_DATA", "%B4046460664629718^000NETSPEND^161012100000181000000?;4046460664629718=16101210000018100000?");
    }

    /* renamed from: i */
    public String mo8183i() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("CARD_HOLDER", "CARD HOLDER");
    }

    /* renamed from: j */
    public String mo8184j() {
        String string = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("DRAW_NAME", "first_run");
        if (!string.equals("first_run")) {
            return string;
        }
        f1421l = true;
        m2127f("card_empty");
        return "card_empty";
    }

    /* renamed from: f */
    private static void m2127f(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(f1414e).edit();
        edit.putString("DRAW_NAME", str);
        edit.commit();
    }

    /* renamed from: a */
    private static void m2117a(String str, String str2, String str3, String str4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(f1414e).edit();
        edit.putString("SWIPE_NAME", str);
        edit.putString("SWIPE_DATA", str2);
        edit.putString("DRAW_NAME", str3);
        edit.putString("CARD_HOLDER", str4);
        edit.commit();
    }

    /* renamed from: k */
    public String mo8185k() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("PASSWORD", "");
    }

    /* renamed from: l */
    public boolean mo8186l() {
        if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("PASS_TO_START", "").equals("TRUE")) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public boolean mo8187m() {
        if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("SHOW_ALL_INFO", "").equals("TRUE")) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    public boolean mo8188n() {
        if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("ENABLE_SOUND", "").equals("TRUE")) {
            return true;
        }
        return false;
    }

    public void openWebPage(View view) {
    }

    public void share(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "MyCard");
        intent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=com.roaddogssoftware.cardapp");
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    /* renamed from: o */
    public void mo8189o() {
        m2117a("NAME", "%B4046460664629718^000NETSPEND^161012100000181000000?;4046460664629718=16101210000018100000?", "first_run", "CARD HOLDER");
        f1431v = mo8181g();
        f1432w = mo8182h();
        f1433x = mo8184j();
        f1435z = -1;
        f1387A = new C0724a(f1431v, f1432w);
        f1387A.f1500H = f1433x;
        f1387A.f1498F = C0797h.m2366b(f1433x);
        if (f1387A.f1498F == 0) {
            f1433x = "card_empty";
            f1387A.f1500H = "card_empty";
            f1387A.f1498F = C0797h.m2366b(f1433x);
        }
        f1387A.f1499G = C0797h.m2367c(f1387A.f1500H);
        f1387A.f1512l = m2120c(f1431v);
        f1404R.mo8259b();
        f1430u.mo8322b();
        f1388B = new ArrayList<>();
        f1405S.mo8244a();
        m2119b(getResources().getString(R.string.snack_full_reset));
    }

    /* renamed from: A */
    private void m2106A() {
        try {
            CardEmulation instance = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this));
            ComponentName componentName = new ComponentName(getApplicationContext(), PaymentService.class.getCanonicalName());
            if (instance.isDefaultServiceForCategory(componentName, "payment")) {
                f1422m = true;
                m2108C();
                return;
            }
            Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
            intent.putExtra("category", "payment");
            intent.putExtra("component", componentName);
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            m2107B();
        }
    }

    /* renamed from: B */
    private void m2107B() {
        new AlertDialog.Builder(this).setTitle((int) R.string.ncf_message_title).setMessage((int) R.string.ncf_message_body).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setIcon(17301543).show();
    }

    /* renamed from: C */
    private void m2108C() {
        f1409Y.getMenu().findItem(R.id.nav_set_as_default_pay).setEnabled(false);
        f1409Y.getMenu().findItem(R.id.nav_set_as_default_title).setTitle(R.string.drawer_is_default);
        f1409Y.getMenu().findItem(R.id.nav_set_as_default_pay).setIcon(R.drawable.ic_check_box_on);
    }

    /* renamed from: D */
    private void m2109D() {
        AlertDialog.Builder builder = new AlertDialog.Builder(f1414e);
        builder.setTitle((int) R.string.enter_password);
        builder.setCancelable(false);
        LinearLayout linearLayout = new LinearLayout(f1414e);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(f1414e);
        final EditText editText = new EditText(f1414e);
        editText.setInputType(18);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView((View) linearLayout);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return true;
                }
                MainActivity.this.m2129g(editText.getText().toString().trim());
                return true;
            }
        });
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.m2129g(editText.getText().toString().trim());
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        f1420k = builder.create();
        f1420k.getWindow().setSoftInputMode(5);
        f1420k.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m2129g(String str) {
        f1420k.hide();
        if (str.equals(f1425p)) {
            f1420k.cancel();
            f1392F.setVisibility(0);
            return;
        }
        m2109D();
    }

    public void selectThisPicture(View view) {
        int positionForView = ((GridView) findViewById(R.id.listViewSelectPicture)).getPositionForView(view);
        f1395I = f1397K.get(positionForView).intValue();
        f1396J = f1398L.get(positionForView);
        f1406T.mo8236d();
        onBackPressed();
    }
}
