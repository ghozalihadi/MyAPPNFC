package com.roaddogssoftware.cardapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LaunchScreenActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
