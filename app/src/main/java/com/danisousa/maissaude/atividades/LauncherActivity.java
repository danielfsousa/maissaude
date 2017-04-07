package com.danisousa.maissaude.atividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;

import com.danisousa.maissaude.R;
import com.google.firebase.auth.FirebaseAuth;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        Intent it;

        if (auth.getCurrentUser() != null) {
            it = new Intent(this, MainActivity.class);
        } else {
            it = new Intent(this, LoginActivity.class);
        }

        finish();
        startActivity(it);
    }
}
