package com.quocanle.letbefrienddatingapp.Firebase;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.quocanle.letbefrienddatingapp.Utils.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseLoginHelper {
    private static final String TAG = "EmailPassword";
    private static FirebaseAuth mAuth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("users");
    public FirebaseLoginHelper() {
        mAuth = FirebaseAuth.getInstance();
    }

    public FirebaseAuth getInstance() {
        return mAuth;
    }

    public FirebaseUser getFirebaseCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public void createAccount(String email, String password, Activity activity, OnCompleteListener<AuthResult> listener) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, listener);
    }

    public void signIn(String email, String password, Activity activity, OnCompleteListener<AuthResult> listener) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, listener);
    }

    public void logOut() {
        mAuth.signOut();
    }

    public void sendEmailVerification(Activity activity, OnCompleteListener<Void> listener) {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(activity, listener);
        }
    }

    public User getCurrentUser() {
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null) {
            User user = new User();
            user.setUser_id(firebaseUser.getUid());
            user.setEmail(firebaseUser.getEmail());
            // Set other user properties
            return user;
        } else {
            return null;
        }
    }
}