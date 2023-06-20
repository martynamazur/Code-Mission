package com.example.nauka;

public class Users {

    String userId, username,email,profile,idUser;



    public Users(String userId, String username, String email, String idUser) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.idUser = idUser;
    }





    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
