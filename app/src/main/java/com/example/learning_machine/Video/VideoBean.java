package com.example.learning_machine.Video;

/**
 * @author Diredre
 * @brief description
 * @date 2022-05-22
 */
public class VideoBean {

    private String fmurl, title, time, iconurl, username, usertime;

    public VideoBean(String fmurl, String title, String time, String iconurl, String username, String usertime) {
        this.fmurl = fmurl;
        this.title = title;
        this.time = time;
        this.iconurl = iconurl;
        this.username = username;
        this.usertime = usertime;
    }

    public String getFmurl() {
        return fmurl;
    }

    public void setFmurl(String fmurl) {
        this.fmurl = fmurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertime() {
        return usertime;
    }

    public void setUsertime(String usertime) {
        this.usertime = usertime;
    }
}
