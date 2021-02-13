package com.dclinic.patient.activities;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


abstract class BaseActivity extends AppCompatActivity {

    abstract @LayoutRes

    int inflate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inflate());
        init();
    }

    abstract void init ();

}
