package org.androidtown.signalapplication.Server.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Meeting extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String title;
    @Required
    private String content;
    private String meetingImg;
    private String date;


    private RealmList<User> publisher;

    //getter setter
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getMeetingImg(){
        return meetingImg;
    }
    public void setMeetingImg(String meetingImg){
        this.meetingImg = meetingImg;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public RealmList<User> getPublisher() {
        return publisher;
    }

    public void setPublisher(RealmList<User> publisher) {
        this.publisher = publisher;
    }



}
