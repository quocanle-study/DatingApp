package com.quocanle.letbefrienddatingapp.Firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.quocanle.letbefrienddatingapp.Utils.User;

public class FirebaseDatabaseHelper {
    private DatabaseReference mDatabase;

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void writeData(String userId, User user) {
        mDatabase.child("users").child(userId).setValue(user);
    }

    public void readData(String userId, final OnGetDataListener listener) {
        listener.onStart();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                listener.onSuccess(user);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onFailed(databaseError);
            }
        });
    }

    public interface OnGetDataListener {
        void onStart();
        void onSuccess(User user);
        void onFailed(DatabaseError databaseError);
    }

    public void updateData(String userId, User user) {
        mDatabase.child("users").child(userId).setValue(user);
    }

    public void deleteData(String userId) {
        mDatabase.child("users").child(userId).removeValue();
    }

    public void deleteAllData() {
        mDatabase.child("users").removeValue();
    }
}
