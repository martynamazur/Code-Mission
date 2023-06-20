package com.example.nauka;

public class User {
    public String userId;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

}
