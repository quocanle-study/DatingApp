package com.quocanle.letbefrienddatingapp.Utils;

import java.io.Serializable;

public class User implements Serializable {
    private String Uid;
    private String phone_number;
    private String email;
    private String username;
    private boolean sports;
    private boolean travel;
    private boolean music;
    private boolean fishing;
    private String description;
    private String sex;
    private String preferSex;
    private String dateOfBirth;
    private String profileImageUrl;
    private double latitude;
    private double longtitude;

    private String aboutYou;
    private String jobTitle;
    private String company;
    private String school;
    private boolean dontShowMyAge;
    private boolean makeMyDistanceInvisible;


    public User() {
    }

    public User(String sex, String preferSex, String Uid, String phone_number, String email, String username, boolean sport, boolean travel, boolean music, boolean fish, String description, String dateOfBirth, String profileImageUrl, double latitude, double longtitude) {
        this.sex = sex;
        this.Uid = Uid;
        this.phone_number = phone_number;
        this.email = email;
        this.username = username;
        this.sports = sport;
        this.travel = travel;
        this.music = music;
        this.fishing = fish;
        this.description = description;
        this.preferSex = preferSex;
        this.dateOfBirth = dateOfBirth;
        this.profileImageUrl = profileImageUrl;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isTravel() {
        return travel;
    }

    public void setTravel(boolean travel) {
        this.travel = travel;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isFishing() {
        return fishing;
    }

    public void setFishing(boolean fishing) {
        this.fishing = fishing;
    }

    public String getPreferSex() {
        return preferSex;
    }

    public void setPreferSex(String preferSex) {
        this.preferSex = preferSex;
    }

    // Added new attribute called date of birth.
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isDontShowMyAge() {
        return dontShowMyAge;
    }

    public void setDontShowMyAge(boolean dontShowMyAge) {
        this.dontShowMyAge = dontShowMyAge;
    }

    public boolean isMakeMyDistanceInvisible() {
        return makeMyDistanceInvisible;
    }

    public void setMakeMyDistanceInvisible(boolean makeMyDistanceInvisible) {
        this.makeMyDistanceInvisible = makeMyDistanceInvisible;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + Uid + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", sports=" + sports +
                ", travel=" + travel +
                ", music=" + music +
                ", fishing=" + fishing +
                ", description='" + description + '\'' +
                ", sex='" + sex + '\'' +
                ", preferSex='" + preferSex + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
