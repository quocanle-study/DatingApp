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
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DatabaseError;
import com.quocanle.letbefrienddatingapp.Utils.User;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class FirebaseLoginHelper {
    private static final String TAG = "EmailPassword";
    private static FirebaseAuth mAuth;
    private static FirebaseLoginHelper instance;
    private FirestoreDatabaseHelper firestoreDatabaseHelper;
    private FirebaseLoginHelper() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static FirebaseLoginHelper getInstance() {
        if (instance == null) {
            instance = new FirebaseLoginHelper();
        }
        return instance;
    }

    public FirebaseUser getFirebaseCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public void checkIfEmailExists(String email, Activity activity) {
        FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
                .addOnCompleteListener(activity, new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                        if (task.isSuccessful()) {
                            SignInMethodQueryResult result = task.getResult();
                            List<String> signInMethods = result.getSignInMethods();
                            if (signInMethods != null && !signInMethods.isEmpty()) {
                                // The email exists, do something
                                Log.d(TAG, "Email already registered with " + signInMethods.get(0));
                            } else {
                                // The email does not exist, do something else
                                Log.d(TAG, "Email not registered");
                            }
                        } else {
                            Log.e(TAG, "Error checking if email exists", task.getException());
                        }
                    }
                });
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

//    public User getCurrentUser() {
//        FirebaseUser firebaseUser = mAuth.getCurrentUser();
//        if (firebaseUser != null) {
//            final User user = new User();
//            user.setUid(firebaseUser.getUid());
//            user.setEmail(firebaseUser.getEmail());
//            FirestoreDatabaseHelper firestoreDatabaseHelper = new FirestoreDatabaseHelper();
//            firestoreDatabaseHelper.readData(firebaseUser.getUid(), new FirestoreDatabaseHelper.OnGetDataListener() {
//                @Override
//                public void onStart() {
//                }
//
//                @Override
//                public void onSuccess(User userSuccess) {
//                    Log.d(TAG, "onSuccess: " + userSuccess.getUsername() + " " + userSuccess.getUid() + " " + userSuccess.getEmail() + " " + userSuccess.getProfileImageUrl() + " " + userSuccess.getAboutYou() + " " + userSuccess.getCompany() + " " + userSuccess.isDontShowMyAge() + " " + userSuccess.isMakeMyDistanceInvisible() + " " + userSuccess.getJobTitle() + " " + userSuccess.getSchool() + " " + userSuccess.getUsername() + " " + userSuccess.getDateOfBirth() + " " + userSuccess.getDescription() + " " + userSuccess.isFishing() + " " + userSuccess.getLatitude() + " " + userSuccess.getLongtitude() + " " + userSuccess.getPhone_number() + " " + userSuccess.getPreferSex() + " " + userSuccess.getProfileImageUrl() + " " + userSuccess.getSex() + " " + userSuccess.isMusic() + " " + userSuccess.isSports() + " " + userSuccess.isTravel());
//                    user.setAboutYou(userSuccess.getAboutYou());
//                    user.setCompany(userSuccess.getCompany());
//                    user.setDontShowMyAge(userSuccess.isDontShowMyAge());
//                    user.setMakeMyDistanceInvisible(userSuccess.isMakeMyDistanceInvisible());
//                    user.setJobTitle(userSuccess.getJobTitle());
//                    user.setSchool(userSuccess.getSchool());
//                    user.setUsername(userSuccess.getUsername());
//                    user.setDateOfBirth(userSuccess.getDateOfBirth());
//                    user.setDescription(userSuccess.getDescription());
//                    user.setFishing(userSuccess.isFishing());
//                    user.setLatitude(userSuccess.getLatitude());
//                    user.setLongtitude(userSuccess.getLongtitude());
//                    user.setPhone_number(userSuccess.getPhone_number());
//                    user.setPreferSex(userSuccess.getPreferSex());
//                    user.setProfileImageUrl(userSuccess.getProfileImageUrl());
//                    user.setSex(userSuccess.getSex());
//                    user.setMusic(userSuccess.isMusic());
//                    user.setSports(userSuccess.isSports());
//                    user.setTravel(userSuccess.isTravel());
//                }
//
//                @Override
//                public void onFailed(Exception e) {
//
//                }
//
//
//            });
//            Log.d(TAG, "onSuccess" + user.getUsername() + " " + user.getUid() + " " + user.getEmail() + " " + user.getProfileImageUrl() + " " + user.getAboutYou() + " " + user.getCompany() + " " + user.isDontShowMyAge() + " " + user.isMakeMyDistanceInvisible() + " " + user.getJobTitle() + " " + user.getSchool() + " " + user.getUsername() + " " + user.getDateOfBirth() + " " + user.getDescription() + " " + user.isFishing() + " " + user.getLatitude() + " " + user.getLongtitude() + " " + user.getPhone_number() + " " + user.getPreferSex() + " " + user.getProfileImageUrl() + " " + user.getSex() + " " + user.isMusic() + " " + user.isSports() + " " + user.isTravel());
//            return user;
//        } else {
//            return null;
//        }
//    }

    public String getUid() {
        return mAuth.getCurrentUser().getUid();
    }

    public interface OnUserFetchedListener {
        void onUserFetched(User user);
    }

    public void getCurrentUser(OnUserFetchedListener listener) {
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null) {
            final User user = new User();
            user.setUid(firebaseUser.getUid());
            user.setEmail(firebaseUser.getEmail());
            FirestoreDatabaseHelper firestoreDatabaseHelper = new FirestoreDatabaseHelper();
            firestoreDatabaseHelper.readData(firebaseUser.getUid(), new FirestoreDatabaseHelper.OnGetDataListener() {
                @Override
                public void onStart() {
                }

                @Override
                public void onSuccess(User userSuccess) {
                    user.setAboutYou(userSuccess.getAboutYou());
                    user.setCompany(userSuccess.getCompany());
                    user.setDontShowMyAge(userSuccess.isDontShowMyAge());
                    user.setMakeMyDistanceInvisible(userSuccess.isMakeMyDistanceInvisible());
                    user.setJobTitle(userSuccess.getJobTitle());
                    user.setSchool(userSuccess.getSchool());
                    user.setUsername(userSuccess.getUsername());
                    user.setDateOfBirth(userSuccess.getDateOfBirth());
                    user.setDescription(userSuccess.getDescription());
                    user.setFishing(userSuccess.isFishing());
                    user.setLatitude(userSuccess.getLatitude());
                    user.setLongtitude(userSuccess.getLongtitude());
                    user.setPhone_number(userSuccess.getPhone_number());
                    user.setPreferSex(userSuccess.getPreferSex());
                    user.setProfileImageUrl(userSuccess.getProfileImageUrl());
                    user.setSex(userSuccess.getSex());
                    user.setMusic(userSuccess.isMusic());
                    user.setSports(userSuccess.isSports());
                    user.setTravel(userSuccess.isTravel());
                    user.setFishing(userSuccess.isFishing());

                    listener.onUserFetched(user);
                }

                @Override
                public void onFailed(Exception e) {

                }
            });
        } else {
            listener.onUserFetched(null);
        }
    }
}