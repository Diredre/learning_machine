package com.example.learning_machine;

/**
 * @author Diredre
 * @brief description
 * @date 2022-05-25
 */
public class CollectBean {

    private String fmurl, title, date, time;

    public CollectBean(String fmurl, String title, String date, String time) {
        this.fmurl = fmurl;
        this.title = title;
        this.date = date;
        this.time = time;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
