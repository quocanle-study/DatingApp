package com.quocanle.letbefrienddatingapp.Firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.quocanle.letbefrienddatingapp.Utils.User;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirestoreDatabaseHelper {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirestoreDatabaseHelper() {
    }

    public void writeNewUser(String userId, User user) {
        if (userId == null || user == null) {
            throw new IllegalArgumentException("userId and user must not be null");
        }

        db.collection("users").document(userId).set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("FirestoreDatabaseHelper", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("FirestoreDatabaseHelper", "Error writing document", e);
                    }
                });
    }

    public void readData(String userId, final OnGetDataListener listener) {
        listener.onStart();
        db.collection("users").document(userId).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                User user = document.toObject(User.class);
                                listener.onSuccess(user);
                            } else {
                                listener.onFailed(new Exception("No such document"));
                            }
                        } else {
                            listener.onFailed(task.getException());
                        }
                    }
                });
    }

    public interface OnGetDataListener {
        void onStart();
        void onSuccess(User user);
        void onFailed(Exception e);
    }
}