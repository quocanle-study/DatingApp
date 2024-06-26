package com.quocanle.letbefrienddatingapp.Matched;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quocanle.letbefrienddatingapp.R;
import com.quocanle.letbefrienddatingapp.Utils.TopNavigationViewHelper;
import com.quocanle.letbefrienddatingapp.Utils.User;

import java.util.ArrayList;
import java.util.List;

public class Matched_Activity extends AppCompatActivity {

    private static final String TAG = "Matched_Activity";
    private static final int ACTIVITY_NUM = 2;
    List<Users> matchList = new ArrayList<>();
    List<User> copyList = new ArrayList<>();
    private Context mContext = Matched_Activity.this;
    private String userId, userSex, lookforSex;
    private double latitude = 37.349642;
    private double longtitude = -121.938987;
    private EditText search;
    private List<Users> usersList = new ArrayList<>();
    private RecyclerView recyclerView, mRecyclerView;
    private ActiveUserAdapter adapter;
    private MatchUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matched);

        setupTopNavigationView();
        searchFunc();


        recyclerView = findViewById(R.id.active_recycler_view);
        mRecyclerView = findViewById(R.id.matche_recycler_view);

        adapter = new ActiveUserAdapter(usersList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareActiveData();

        mAdapter = new MatchUserAdapter(matchList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager1);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareMatchData();


    }

    private void prepareActiveData() {
        Users users = new Users("1", "Jennie", 28, "https://ss-images.saostar.vn/wp700/2024/5/16/pc/1715844290373/i5r0s9zqbw1-peu8rl4jvb2-puyosq83l23.png", "Simple and beautiful Girl", "Singing", 200);
        usersList.add(users);
        users = new Users("2", "Lisa", 29, "https://image.tienphong.vn/w1000/Uploaded/2024/zaugtn/2023_09_11/lisa-1367.jpg", "cool Minded Girl", "Dancing", 800);
        usersList.add(users);
        users = new Users("3", "Rose", 27, "https://media-cdn-v2.laodong.vn/storage/newsportal/2022/9/9/1090978/Rose-8B1a.jpg", "Simple and beautiful Girl", "Singing", 400);
        usersList.add(users);
        users = new Users("7", "Jisoo", 19, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/20240226_Kim_Jisoo_%EA%B9%80%EC%A7%80%EC%88%98_02.jpg/250px-20240226_Kim_Jisoo_%EA%B9%80%EC%A7%80%EC%88%98_02.jpg", "Singing girl", "Art", 5000);
        usersList.add(users);

        adapter.notifyDataSetChanged();
    }

    private void prepareMatchData() {
        Users users = new Users("1", "Jennie", 28, "https://ss-images.saostar.vn/wp700/2024/5/16/pc/1715844290373/i5r0s9zqbw1-peu8rl4jvb2-puyosq83l23.png", "Simple and beautiful Girl", "Singing", 200);
        usersList.add(users);
        users = new Users("2", "Lisa", 29, "https://image.tienphong.vn/w1000/Uploaded/2024/zaugtn/2023_09_11/lisa-1367.jpg", "cool Minded Girl", "Dancing", 800);
        usersList.add(users);
        users = new Users("3", "Rose", 27, "https://media-cdn-v2.laodong.vn/storage/newsportal/2022/9/9/1090978/Rose-8B1a.jpg", "Simple and beautiful Girl", "Singing", 400);
        usersList.add(users);
        users = new Users("4", "Thiều Bảo Trâm", 25, "https://vnn-imgs-f.vgcloud.vn/2021/01/21/08/thieu-bao-tram-la-ai-10.jpg", "dashing girl", "swiming", 1308);
        matchList.add(users);
        users = new Users("5", "Hải Tú", 20, "https://thanhnien.mediacdn.vn/Uploaded/thynhm/2021_01_21/133113648_156801309530550_8269644933371586165_o_QKIK.jpg?width=500", "chulbuli nautankibaj ", "Drawing", 1200);
        matchList.add(users);
        users = new Users("6", "Châu Bùi", 21, "https://i.ex-cdn.com/nongnghiep.vn/files/content/2024/06/25/viechannelnala5co-van-chau-bui-2-1684144775776887953850-084624_64-094528.jpg", "Simple and beautiful Girl", "Sleeping", 700);
        matchList.add(users);
        users = new Users("7", "Jisoo", 19, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/20240226_Kim_Jisoo_%EA%B9%80%EC%A7%80%EC%88%98_02.jpg/250px-20240226_Kim_Jisoo_%EA%B9%80%EC%A7%80%EC%88%98_02.jpg", "Singing girl", "Art", 5000);
        usersList.add(users);

        mAdapter.notifyDataSetChanged();
    }

    private void searchFunc() {
       /* search = findViewById(R.id.searchBar);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchText();
            }

            @Override
            public void afterTextChanged(Editable s) {
                searchText();
            }
        });*/
    }

    /* private void searchText() {
         String text = search.getText().toString().toLowerCase(Locale.getDefault());
         if (text.length() != 0) {
             if (matchList.size() != 0) {
                 matchList.clear();
                 for (User user : copyList) {
                     if (user.getUsername().toLowerCase(Locale.getDefault()).contains(text)) {
                         matchList.add(user);
                     }
                 }
             }
         } else {
             matchList.clear();
             matchList.addAll(copyList);
         }

         mAdapter.notifyDataSetChanged();
     }

     private boolean checkDup(User user) {
         if (matchList.size() != 0) {
             for (User u : matchList) {
                 if (u.getUsername() == user.getUsername()) {
                     return true;
                 }
             }
         }

         return false;
     }

     private void checkClickedItem(int position) {

         User user = matchList.get(position);
         //calculate distance
         Intent intent = new Intent(this, ProfileCheckinMatched.class);
         intent.putExtra("classUser", user);

         startActivity(intent);
     }
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


}
