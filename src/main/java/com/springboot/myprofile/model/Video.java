package com.springboot.myprofile.model;

import javax.persistence.*;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long video_id;

    @Column(nullable = false, length = 64)
    private String title;

    @Column(nullable = false, length = 1000)
    private String url;

    public Video() {
    }

    public Video(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Long video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
