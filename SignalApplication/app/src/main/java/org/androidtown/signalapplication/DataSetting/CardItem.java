package org.androidtown.signalapplication.DataSetting;

/**
 * Created by seoyoungoh on 2017. 12. 2..
 */

public class CardItem {
    int image; //퍼블리셔 이미지
    String userName; //퍼블리셔 이름
    String userTitle; //퍼블리셔 직업
    String meetingTitle; // 카드 제목(만남 또는 시그널)
    String meetingContents; // 카드 내용



    public int getImage() {
        return this.image;
    }
    public String getUserName() {return this.userName;}
    public String getUserTitle() {return  this.userTitle;}
    public String getMeetingTitle() {return this.meetingTitle;}
    public String getMeetingContents() {return this.meetingContents;}


    // 이후 데이터 파싱해서 가져오는 것으로 수정 할 것
    public CardItem(int image, String userName, String userTitle, String meetingTitle, String meetingContents) {
        this.image = image;
        this.userName = userName;
        this.userTitle = userTitle;
        this.meetingTitle = meetingTitle;
        this.meetingContents = meetingContents;
    }
}
