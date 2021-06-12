package com.roaddogssoftware.cardapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/* renamed from: com.roaddogssoftware.cardapp.c */
/* compiled from: DataBaseHandler */
public class C0788c extends SQLiteOpenHelper {

    /* renamed from: a */
    String f1766a = "CREATE TABLE card_data(id INTEGER PRIMARY KEY AUTOINCREMENT,card_name TEXT,card_data TEXT,card_image TEXT,card_cvv TEXT,card_holder TEXT,date_added TEXT,date_last TEXT)";

    public C0788c(Context context) {
        super(context, "cardapp", (SQLiteDatabase.CursorFactory) null, 10);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.f1766a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        if (r4 == 10) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r3.execSQL("DROP TABLE IF EXISTS card_data");
        onCreate(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r3.execSQL("ALTER TABLE card_data ADD COLUMN card_holder TEXT");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        r3.execSQL("ALTER TABLE card_data ADD COLUMN date_added TEXT");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        r3.execSQL("ALTER TABLE card_data ADD COLUMN date_last TEXT");
        r4 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r3, int r4, int r5) {
        /*
            r2 = this;
            r0 = 10
            switch(r4) {
                case 6: goto L_0x0010;
                case 7: goto L_0x0015;
                case 8: goto L_0x001a;
                case 9: goto L_0x001f;
                default: goto L_0x0005;
            }
        L_0x0005:
            if (r4 == r0) goto L_0x000f
            java.lang.String r0 = "DROP TABLE IF EXISTS card_data"
            r3.execSQL(r0)
            r2.onCreate(r3)
        L_0x000f:
            return
        L_0x0010:
            java.lang.String r1 = "ALTER TABLE card_data ADD COLUMN card_cvv TEXT"
            r3.execSQL(r1)
        L_0x0015:
            java.lang.String r1 = "ALTER TABLE card_data ADD COLUMN card_holder TEXT"
            r3.execSQL(r1)
        L_0x001a:
            java.lang.String r1 = "ALTER TABLE card_data ADD COLUMN date_added TEXT"
            r3.execSQL(r1)
        L_0x001f:
            java.lang.String r1 = "ALTER TABLE card_data ADD COLUMN date_last TEXT"
            r3.execSQL(r1)
            r4 = r0
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.roaddogssoftware.cardapp.C0788c.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8320a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("card_name", str);
        contentValues.put("card_data", str2);
        contentValues.put("card_image", str3);
        contentValues.put("card_cvv", str4);
        contentValues.put("card_holder", str5);
        contentValues.put("date_added", str6);
        contentValues.put("date_last", str7);
        writableDatabase.insert("card_data", (String) null, contentValues);
        writableDatabase.close();
    }

    /* renamed from: a */
    public ArrayList<C0724a> mo8317a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ArrayList<C0724a> arrayList = new ArrayList<>();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM card_data", (String[]) null);
        if (rawQuery.moveToFirst()) {
            do {
                if (rawQuery.getString(1) != null) {
                    str = rawQuery.getString(1);
                } else {
                    str = "";
                }
                if (rawQuery.getString(2) != null) {
                    str2 = rawQuery.getString(2);
                } else {
                    str2 = "";
                }
                if (rawQuery.getString(3) != null) {
                    str3 = rawQuery.getString(3);
                } else {
                    str3 = "";
                }
                if (rawQuery.getString(4) != null) {
                    str4 = rawQuery.getString(4);
                } else {
                    str4 = "";
                }
                if (rawQuery.getString(5) != null) {
                    str5 = rawQuery.getString(5);
                } else {
                    str5 = "";
                }
                if (rawQuery.getString(6) != null) {
                    str6 = rawQuery.getString(6);
                } else {
                    str6 = "";
                }
                if (rawQuery.getString(7) != null) {
                    str7 = rawQuery.getString(7);
                } else {
                    str7 = "";
                }
                arrayList.add(new C0724a(str, str2, str3, str4, str5, str6, str7));
            } while (rawQuery.moveToNext());
        }
        readableDatabase.close();
        return arrayList;
    }

    /* renamed from: b */
    public void mo8322b() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("card_data", (String) null, (String[]) null);
        writableDatabase.close();
    }

    /* renamed from: a */
    public void mo8318a(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("card_data", "card_name = ?", new String[]{str});
        writableDatabase.close();
    }

    /* renamed from: a */
    public void mo8319a(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor query = writableDatabase.query("card_data", new String[]{"id", "card_name", "card_data", "card_image", "card_cvv", "card_holder", "date_added"}, "card_name=?", new String[]{str}, (String) null, (String) null, (String) null);
        try {
            if (query.moveToFirst()) {
                if (query.getString(1) != null) {
                    contentValues.put("card_name", query.getString(1));
                } else {
                    contentValues.put("card_name", "");
                }
                if (query.getString(2) != null) {
                    contentValues.put("card_data", query.getString(2));
                } else {
                    contentValues.put("card_data", "");
                }
                if (query.getString(3) != null) {
                    contentValues.put("card_image", query.getString(3));
                } else {
                    contentValues.put("card_image", "");
                }
                if (query.getString(4) != null) {
                    contentValues.put("card_cvv", query.getString(4));
                } else {
                    contentValues.put("card_cvv", "");
                }
                if (query.getString(5) != null) {
                    contentValues.put("card_holder", query.getString(5));
                } else {
                    contentValues.put("card_holder", "");
                }
                if (query.getString(6) != null) {
                    contentValues.put("date_added", query.getString(6));
                } else {
                    contentValues.put("date_added", "");
                }
                contentValues.put("date_last", str2);
                writableDatabase.update("card_data", contentValues, "card_name= ?", new String[]{str});
            }
        } catch (Exception e) {
        }
        writableDatabase.close();
    }

    /* renamed from: a */
    public void mo8321a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT  * FROM card_data", (String[]) null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(new C0789a(rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(5), rawQuery.getString(6), rawQuery.getString(7)));
            } while (rawQuery.moveToNext());
        }
        writableDatabase.delete("card_data", (String) null, (String[]) null);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                break;
            }
            if (i3 == i) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("card_name", str);
                contentValues.put("card_data", str2);
                contentValues.put("card_image", str3);
                contentValues.put("card_cvv", str4);
                contentValues.put("card_holder", str5);
                contentValues.put("date_added", str6);
                contentValues.put("date_last", str7);
                writableDatabase.insert("card_data", (String) null, contentValues);
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("card_name", ((C0789a) arrayList.get(i3)).f1767a);
            contentValues2.put("card_data", ((C0789a) arrayList.get(i3)).f1768b);
            contentValues2.put("card_image", ((C0789a) arrayList.get(i3)).f1769c);
            contentValues2.put("card_cvv", ((C0789a) arrayList.get(i3)).f1770d);
            contentValues2.put("card_holder", ((C0789a) arrayList.get(i3)).f1771e);
            contentValues2.put("date_added", ((C0789a) arrayList.get(i3)).f1772f);
            contentValues2.put("date_last", ((C0789a) arrayList.get(i3)).f1773g);
            writableDatabase.insert("card_data", (String) null, contentValues2);
            i2 = i3 + 1;
        }
        if (i == arrayList.size()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("card_name", str);
            contentValues3.put("card_data", str2);
            contentValues3.put("card_image", str3);
            contentValues3.put("card_cvv", str4);
            contentValues3.put("date_added", str6);
            contentValues3.put("date_last", str7);
            writableDatabase.insert("card_data", (String) null, contentValues3);
        }
        writableDatabase.close();
    }

    /* renamed from: com.roaddogssoftware.cardapp.c$a */
    /* compiled from: DataBaseHandler */
    public class C0789a {

        /* renamed from: a */
        public String f1767a = "";

        /* renamed from: b */
        public String f1768b = "";

        /* renamed from: c */
        public String f1769c = "";

        /* renamed from: d */
        public String f1770d = "";

        /* renamed from: e */
        public String f1771e = "";

        /* renamed from: f */
        public String f1772f = "";

        /* renamed from: g */
        public String f1773g = "";

        public C0789a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f1767a = str;
            this.f1768b = str2;
            this.f1769c = str3;
            this.f1770d = str4;
            this.f1771e = str5;
            this.f1772f = str6;
            this.f1773g = str7;
        }
    }
}
