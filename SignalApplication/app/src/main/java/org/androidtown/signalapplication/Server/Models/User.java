package org.androidtown.signalapplication.Server.Models;

import com.google.gson.annotations.SerializedName;

import java.io.File;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;


public class User extends RealmObject{

    @PrimaryKey
    private int id;
    @Required
    private String username;
    private String type;
    private String job;
    private String phoneNumber;
    private String profilePhoto;
    @Required
    private String password;

    private RealmList<Meeting> publishedMeeting;

    //getter and setter

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getJob(){
        return job;
    }
    public void setJob(String job){
        this.job = job;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePhoto(){
        return profilePhoto;
    }
    public void setProfilePhoto(String profilePhoto){
        this.profilePhoto = profilePhoto;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public RealmList<Meeting> getPublishedMeeting() {
        return publishedMeeting;
    }

    public void setPublishedMeeting(RealmList<Meeting> publishedMeeting) {
        this.publishedMeeting = publishedMeeting;
    }




}
