package com.roaddogssoftware.cardapp.p029a;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.p016v4.app.Fragment;
import android.support.p016v4.internal.view.SupportMenu;
import android.support.p019v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.roaddogssoftware.cardapp.MainActivity;
import com.roaddogssoftware.cardapp.R;

/* renamed from: com.roaddogssoftware.cardapp.a.g */
/* compiled from: FragmentSettings */
public class C0750g extends Fragment {

    /* renamed from: a */
    View f1649a;

    /* renamed from: b */
    AlertDialog f1650b;

    /* renamed from: c */
    private CheckBox f1651c;

    /* renamed from: d */
    private CheckBox f1652d;

    /* renamed from: e */
    private CheckBox f1653e;

    /* renamed from: f */
    private CheckBox f1654f;

    /* renamed from: g */
    private CheckBox f1655g;

    /* renamed from: h */
    private CheckBox f1656h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1649a = layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false);
        this.f1653e = (CheckBox) this.f1649a.findViewById(R.id.checkBoxShowAll);
        this.f1653e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0750g.this.m2273b();
            }
        });
        this.f1652d = (CheckBox) this.f1649a.findViewById(R.id.checkBoxPassToStart);
        this.f1652d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0750g.this.m2279c();
            }
        });
        this.f1655g = (CheckBox) this.f1649a.findViewById(R.id.checkBoxSounds);
        this.f1655g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0750g.this.m2282d();
            }
        });
        this.f1651c = (CheckBox) this.f1649a.findViewById(R.id.text_set_pass);
        this.f1651c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0750g.this.m2284e();
            }
        });
        this.f1654f = (CheckBox) this.f1649a.findViewById(R.id.text_clear_pass);
        this.f1654f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0750g.this.m2286f();
            }
        });
        this.f1656h = (CheckBox) this.f1649a.findViewById(R.id.text_reset);
        this.f1656h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0750g.this.m2288g();
            }
        });
        m2260a();
        return this.f1649a;
    }

    public void onResume() {
        super.onResume();
        MainActivity.m2116a("FRAG_SETTINGS");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2260a() {
        if (MainActivity.f1423n) {
            m2261a((int) R.id.checkBoxShowAll);
        }
        if (MainActivity.f1426q) {
            m2261a((int) R.id.checkBoxPassToStart);
        }
        if (MainActivity.f1427r) {
            m2261a((int) R.id.checkBoxSounds);
        }
        if (MainActivity.f1424o) {
            this.f1652d.setEnabled(true);
            this.f1654f.setEnabled(true);
            this.f1651c.setText(R.string.change_password);
            return;
        }
        this.f1652d.setEnabled(false);
        this.f1654f.setEnabled(false);
        this.f1651c.setText(R.string.set_password);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2273b() {
        if (MainActivity.f1423n) {
            MainActivity.f1423n = false;
            mo8268b(false);
        } else if (MainActivity.f1424o) {
            m2291i();
        } else {
            MainActivity.f1423n = true;
            mo8268b(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2279c() {
        if (MainActivity.f1426q) {
            MainActivity.f1426q = false;
            mo8267a(false);
            return;
        }
        MainActivity.f1426q = true;
        mo8267a(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2282d() {
        if (MainActivity.f1427r) {
            MainActivity.f1427r = false;
            mo8269c(false);
            return;
        }
        MainActivity.f1427r = true;
        mo8269c(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2284e() {
        if (MainActivity.f1424o) {
            m2270a("", "", "", false);
        } else {
            m2271a("", "", false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2286f() {
        m2272a("", false);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m2288g() {
        m2292j();
    }

    /* renamed from: h */
    private void m2290h() {
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getView().getWindowToken(), 0);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m2261a(int i) {
        final CheckBox checkBox = (CheckBox) this.f1649a.findViewById(i);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                checkBox.setChecked(false);
                checkBox.setChecked(true);
            }
        }, 300);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2274b(int i) {
        final CheckBox checkBox = (CheckBox) this.f1649a.findViewById(i);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                checkBox.setChecked(true);
                checkBox.setChecked(false);
            }
        }, 100);
    }

    /* renamed from: i */
    private void m2291i() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.enter_password);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        final EditText editText = new EditText(getContext());
        editText.setInputType(18);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView((View) linearLayout);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return true;
                }
                C0750g.this.m2277b(editText.getText().toString().trim());
                return true;
            }
        });
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                C0750g.this.m2277b(editText.getText().toString().trim());
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                C0750g.this.m2274b((int) R.id.checkBoxShowAll);
            }
        });
        this.f1650b = builder.create();
        this.f1650b.getWindow().setSoftInputMode(5);
        this.f1650b.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2277b(String str) {
        this.f1650b.hide();
        if (str.equals(MainActivity.f1425p)) {
            MainActivity.f1423n = true;
            mo8268b(true);
            m2260a();
            return;
        }
        m2291i();
    }

    /* renamed from: a */
    private void m2271a(String str, String str2, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.set_password);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        final EditText editText = new EditText(getContext());
        editText.setInputType(18);
        TextView textView2 = new TextView(getContext());
        textView2.setText(R.string.confirm_password);
        textView2.setPadding(30, 0, 0, 0);
        final EditText editText2 = new EditText(getContext());
        editText2.setInputType(18);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        linearLayout.addView(textView2);
        linearLayout.addView(editText2);
        builder.setView((View) linearLayout);
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return true;
                }
                C0750g.this.m2268a(editText.getText().toString().trim(), editText2.getText().toString().trim());
                return true;
            }
        });
        if (z && (!str.equals("") || !str2.equals(""))) {
            editText.setText(str);
            textView2.setTextColor(SupportMenu.CATEGORY_MASK);
            editText2.requestFocus();
        }
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                C0750g.this.m2268a(editText.getText().toString().trim(), editText2.getText().toString().trim());
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        this.f1650b = builder.create();
        this.f1650b.getWindow().setSoftInputMode(5);
        this.f1650b.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2268a(String str, String str2) {
        this.f1650b.hide();
        if (str.equals("")) {
            m2271a(str, str2, true);
        } else if (str.equals(str2)) {
            m2278b(str, false);
        } else {
            m2271a(str, str2, true);
        }
        m2260a();
    }

    /* renamed from: a */
    private void m2270a(String str, String str2, String str3, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.change_password);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setText(R.string.current_password);
        textView2.setPadding(30, 0, 0, 0);
        final EditText editText = new EditText(getContext());
        editText.setInputType(18);
        TextView textView3 = new TextView(getContext());
        textView3.setText(R.string.new_password);
        textView3.setPadding(30, 0, 0, 0);
        final EditText editText2 = new EditText(getContext());
        editText2.setInputType(18);
        TextView textView4 = new TextView(getContext());
        textView4.setText(R.string.confirm_new_password);
        textView4.setPadding(30, 0, 0, 0);
        final EditText editText3 = new EditText(getContext());
        editText3.setInputType(18);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(editText);
        linearLayout.addView(textView3);
        linearLayout.addView(editText2);
        linearLayout.addView(textView4);
        linearLayout.addView(editText3);
        builder.setView((View) linearLayout);
        editText3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return true;
                }
                C0750g.this.m2269a(editText.getText().toString().trim(), editText2.getText().toString().trim(), editText3.getText().toString().trim());
                return true;
            }
        });
        if (z) {
            if (!str.equals(MainActivity.f1425p)) {
                textView2.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                editText.setText(str);
            }
            if (!str2.equals(str3)) {
                editText2.setText(str2);
                textView4.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                editText2.setText(str2);
                editText3.setText(str3);
            }
        }
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                C0750g.this.m2269a(editText.getText().toString().trim(), editText2.getText().toString().trim(), editText3.getText().toString().trim());
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        this.f1650b = builder.create();
        this.f1650b.getWindow().setSoftInputMode(5);
        this.f1650b.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2269a(String str, String str2, String str3) {
        this.f1650b.hide();
        if (!str.equals(MainActivity.f1425p)) {
            m2270a(str, str2, str3, true);
        } else if (str2.equals(str3)) {
            m2278b(str2, true);
        } else {
            m2270a(str, str2, str3, true);
        }
        m2260a();
    }

    /* renamed from: a */
    private void m2272a(String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle((int) R.string.clear_password);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setText(R.string.current_password);
        textView2.setPadding(30, 0, 0, 0);
        final EditText editText = new EditText(getContext());
        editText.setInputType(18);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(editText);
        builder.setView((View) linearLayout);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return true;
                }
                C0750g.this.m2281c(editText.getText().toString().trim());
                return true;
            }
        });
        if (z) {
            if (!str.equals(MainActivity.f1425p)) {
                textView2.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                editText.setText(str);
            }
        }
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                C0750g.this.m2281c(editText.getText().toString().trim());
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        this.f1650b = builder.create();
        this.f1650b.getWindow().setSoftInputMode(5);
        this.f1650b.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2281c(String str) {
        this.f1650b.hide();
        if (str.equals(MainActivity.f1425p)) {
            m2278b("", true);
            m2290h();
        } else {
            m2272a(str, true);
        }
        m2260a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2278b(String str, boolean z) {
        if (!str.equals("")) {
            MainActivity.f1424o = true;
            MainActivity.f1425p = str;
            mo8266a(str);
            if (z) {
                MainActivity.m2119b(getResources().getString(R.string.snack_password_changed));
            } else {
                MainActivity.m2119b(getResources().getString(R.string.snack_password_set));
            }
        } else {
            MainActivity.f1424o = false;
            MainActivity.f1425p = str;
            MainActivity.f1426q = false;
            mo8266a(str);
            MainActivity.m2119b(getResources().getString(R.string.snack_password_cleared));
        }
        m2260a();
    }

    /* renamed from: j */
    private void m2292j() {
        new AlertDialog.Builder(getContext()).setIcon((int) R.drawable.ic_alert).setTitle((int) R.string.warning_full_reset).setNegativeButton((CharSequence) "No", (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                C0750g.this.m2278b("", false);
                MainActivity.f1426q = false;
                MainActivity.f1423n = true;
                MainActivity.f1427r = true;
                C0750g.this.mo8266a("");
                C0750g.this.mo8267a(false);
                C0750g.this.mo8268b(true);
                C0750g.this.mo8269c(true);
                ((MainActivity) MainActivity.f1414e).mo8189o();
                C0750g.this.m2260a();
            }
        }).show();
    }

    /* renamed from: a */
    public void mo8266a(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        edit.putString("PASSWORD", MainActivity.f1425p);
        edit.apply();
    }

    /* renamed from: a */
    public void mo8267a(boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        if (z) {
            edit.putString("PASS_TO_START", "TRUE");
        } else {
            edit.putString("PASS_TO_START", "FALSE");
        }
        edit.apply();
    }

    /* renamed from: b */
    public void mo8268b(boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        if (z) {
            edit.putString("SHOW_ALL_INFO", "TRUE");
        } else {
            edit.putString("SHOW_ALL_INFO", "FALSE");
        }
        edit.apply();
    }

    /* renamed from: c */
    public void mo8269c(boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        if (z) {
            edit.putString("ENABLE_SOUND", "TRUE");
        } else {
            edit.putString("ENABLE_SOUND", "FALSE");
        }
        edit.apply();
    }
}
