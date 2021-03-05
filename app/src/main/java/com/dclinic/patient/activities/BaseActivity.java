package com.dclinic.patient.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


abstract class BaseActivity extends AppCompatActivity {

    abstract @LayoutRes
    int inflate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }


    void addBackButton(androidx.appcompat.widget.Toolbar toolbar, @DrawableRes int backIcon, @SuppressLint("SupportAnnotationUsage") @StringRes int titleText) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (titleText == 0) {
            getSupportActionBar().setTitle("");
        } else
            getSupportActionBar().setTitle(titleText);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, backIcon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    abstract void init();

}
