package com.quocanle.letbefrienddatingapp.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quocanle.letbefrienddatingapp.Main.MainActivity;
import com.quocanle.letbefrienddatingapp.Matched.Matched_Activity;
import com.quocanle.letbefrienddatingapp.Profile.Profile_Activity;
import com.quocanle.letbefrienddatingapp.R;

public class TopNavigationViewHelper {
    private final static int ic_profile = R.id.ic_profile;
    private final static int ic_main = R.id.ic_main;
    private final static int ic_matched = R.id.ic_matched;

    private static final String TAG = "TopNavigationViewHelper";

    public static void setupTopNavigationView(BottomNavigationViewEx tv) {
        Log.d(TAG, "setupTopNavigationView: setting up navigationview");
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == ic_profile) {
                    Intent intent2 = new Intent(context, Profile_Activity.class);
                    context.startActivity(intent2);
                } else if (item.getItemId() == ic_main) {
                    Intent intent1 = new Intent(context, MainActivity.class);
                    context.startActivity(intent1);
                } else if (item.getItemId() == ic_matched) {
                    Intent intent3 = new Intent(context, Matched_Activity.class);
                    context.startActivity(intent3);
                }

                return false;
            }
        });
    }
}
