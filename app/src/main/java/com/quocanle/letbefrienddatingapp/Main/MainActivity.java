package com.quocanle.letbefrienddatingapp.Main;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.quocanle.letbefrienddatingapp.Matched.Matched_Activity;
import com.quocanle.letbefrienddatingapp.R;
import com.quocanle.letbefrienddatingapp.Utils.PulsatorLayout;
import com.quocanle.letbefrienddatingapp.Utils.TopNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 1;
    final private int MY_PERMISSIONS_REQUEST_LOCATION = 123;
    ListView listView;
    List<Cards> rowItems;
    FrameLayout cardFrame, moreFrame;
    private Context mContext = MainActivity.this;
    private NotificationHelper mNotificationHelper;
    private Cards cards_data[];
    private PhotoAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userEmail = getIntent().getStringExtra("userEmail");

        cardFrame = findViewById(R.id.card_frame);
        moreFrame = findViewById(R.id.more_frame);
        // start pulsator
        PulsatorLayout mPulsator = findViewById(R.id.pulsator);
        mPulsator.start();
        mNotificationHelper = new NotificationHelper(this);


        setupTopNavigationView();


        rowItems = new ArrayList<Cards>();
        Cards cards = new Cards("1", "Vu Dinh Trong Thang", 21, "https://raw.githack.com/chunche456/MyAssets/main/img/LetBeFriend/card/vudinhtrongthang.jpg", "La mot thanh vien ban nhac ngot ...", "Singing", 200);
        rowItems.add(cards);
        cards = new Cards("2", "Quoc An Le", 19, "https://raw.githack.com/chunche456/MyAssets/main/img/LetBeFriend/card/quocanle.jpg", "La mot sinh vien VNUK", "Singing", 800);
        rowItems.add(cards);
        cards = new Cards("3", "Huy Minh Pham Nguyen", 19, "https://raw.githack.com/chunche456/MyAssets/main/img/LetBeFriend/card/huyminhphamnguyen.jpg", "La sinh vien VNUK, ban cua quocan", "Singing", 400);
        rowItems.add(cards);
        cards = new Cards("4", "Pham Quang Vinh", 20, "https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-6/438300763_3674330286113806_3777441537352635807_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=c0TOZjcK4VcQ7kNvgFKMKzK&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYAn-bkaeFgrVJhCzkTAr6bV3CWVty90qMW4PMirs-ggew&oe=66822CE9", "The best handome guy in the world", "Listening to music", 1308);
        rowItems.add(cards);
        cards = new Cards("5", "Nguyen Minh Nhan", 21, "https://scontent.fsgn2-11.fna.fbcdn.net/v/t39.30808-1/357364288_1443123496513106_2568270581030725050_n.jpg?stp=cp6_dst-jpg_p480x480&_nc_cat=103&ccb=1-7&_nc_sid=0ecb9b&_nc_ohc=X-ZaewP_VZ4Q7kNvgHOpZnN&_nc_ht=scontent.fsgn2-11.fna&oh=00_AYB-HYfB6uK9ZKRyKrWa0PPVwZU-8fEXDM7EAmnWGGfDCQ&oe=66825221", "Bad guy like bad girls", "Playing games", 1200);
        rowItems.add(cards);
        cards = new Cards("6", "Jennie", 28, "https://ss-images.saostar.vn/wp700/2024/5/16/pc/1715844290373/i5r0s9zqbw1-peu8rl4jvb2-puyosq83l23.png", "Simple and beautiful Girl", "Singing", 200);
        rowItems.add(cards);
        cards = new Cards("7", "Lisa", 29, "https://image.tienphong.vn/w1000/Uploaded/2024/zaugtn/2023_09_11/lisa-1367.jpg", "cool Minded Girl", "Dancing", 800);
        rowItems.add(cards);
        cards = new Cards("8", "Jisoo", 19, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/20240226_Kim_Jisoo_%EA%B9%80%EC%A7%80%EC%88%98_02.jpg/250px-20240226_Kim_Jisoo_%EA%B9%80%EC%A7%80%EC%88%98_02.jpg", "Singing girl", "Art", 5000);
        rowItems.add(cards);
        cards = new Cards("9", "Thieu Bao Tram", 25, "https://vnn-imgs-f.vgcloud.vn/2021/01/21/08/thieu-bao-tram-la-ai-10.jpg", "dashing girl", "swiming", 1308);
        rowItems.add(cards);
        cards = new Cards("10", "Hai Tu", 20, "https://thanhnien.mediacdn.vn/Uploaded/thynhm/2021_01_21/133113648_156801309530550_8269644933371586165_o_QKIK.jpg?width=500", "chulbuli nautankibaj ", "Drawing", 1200);
        rowItems.add(cards);
        cards = new Cards("11", "Chau Bui", 21, "https://i.ex-cdn.com/nongnghiep.vn/files/content/2024/06/25/viechannelnala5co-van-chau-bui-2-1684144775776887953850-084624_64-094528.jpg", "Simple and beautiful Girl", "Sleeping", 700);
        rowItems.add(cards);

        arrayAdapter = new PhotoAdapter(this, R.layout.item, rowItems);

        checkRowItem();
        updateSwipeCard();
    }

    private void checkRowItem() {
        if (rowItems.isEmpty()) {
            moreFrame.setVisibility(View.VISIBLE);
            cardFrame.setVisibility(View.GONE);
        }
    }

    private void updateLocation() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
        } else {

        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        updateLocation();
                    } else {
                        Toast.makeText(MainActivity.this, "Location Permission Denied. You have to give permission inorder to know the user range ", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void updateSwipeCard() {
        final SwipeFlingAdapterView flingContainer = findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                rowItems.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                Cards obj = (Cards) dataObject;
                checkRowItem();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Cards obj = (Cards) dataObject;

                //check matches
                checkRowItem();

            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here


            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void sendNotification() {
        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(mContext.getString(R.string.app_name), mContext.getString(R.string.match_notification));

        mNotificationHelper.getManager().notify(1, nb.build());
    }


    public void DislikeBtn(View v) {
        if (rowItems.size() != 0) {
            Cards card_item = rowItems.get(0);

            String userId = card_item.getUserId();

            rowItems.remove(0);
            arrayAdapter.notifyDataSetChanged();

            Intent btnClick = new Intent(mContext, BtnDislikeActivity.class);
            btnClick.putExtra("url", card_item.getProfileImageUrl());
            startActivity(btnClick);
        }
    }

    public void LikeBtn(View v) {
        if (rowItems.size() != 0) {
            Cards card_item = rowItems.get(0);

            String userId = card_item.getUserId();

            //check matches
            sendNotification();


            rowItems.remove(0);
            arrayAdapter.notifyDataSetChanged();

            Intent btnClick = new Intent(mContext, BtnLikeActivity.class);
            btnClick.putExtra("url", card_item.getProfileImageUrl());
            startActivity(btnClick);
        }
    }
    /**
     * setup top tool bar
     */
    private void setupTopNavigationView() {
        Log.d(TAG, "setupTopNavigationView: setting up TopNavigationView");
        BottomNavigationViewEx tvEx = findViewById(R.id.topNavViewBar);
        TopNavigationViewHelper.setupTopNavigationView(tvEx);
        TopNavigationViewHelper.enableNavigation(mContext, tvEx);
        Menu menu = tvEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


    @Override
    public void onBackPressed() {

    }

}
