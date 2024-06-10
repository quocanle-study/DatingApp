package com.quocanle.letbefrienddatingapp.Introduction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//import com.quocanle.letbefrienddatingapp.Login.Login;
//import com.quocanle.letbefrienddatingapp.Login.RegisterBasicInfo;
import com.quocanle.letbefrienddatingapp.R;

public class IntroductionMain extends AppCompatActivity {

    private Button signupButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_main);

        signupButton = findViewById(R.id.signup_button);

//        signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openEmailAddressEntryPage();
//            }
//        });

        loginButton = findViewById(R.id.login_button);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openLoginPage();
//            }
//        });
    }

//    public void openLoginPage() {
//        Intent intent = new Intent(this, Login.class);
//        startActivity(intent);
//    }
//
//    public void openEmailAddressEntryPage() {
//        Intent intent = new Intent(this, RegisterBasicInfo.class);
//        startActivity(intent);
//    }
}
