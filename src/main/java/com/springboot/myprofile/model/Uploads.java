package com.springboot.myprofile.model;

import javax.persistence.*;

@Entity
@Table(name = "uploads")
public class Uploads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upload_id;

    @Column(nullable = false, length = 64)
    private String title;

    @Column(nullable = false, length = 1000)
    private String url;

    @Column(nullable = false, length = 64)
    private String description;



    public Uploads() {
    }

    public Uploads(String title, String url, String description) {
        this.title = title;
        this.url = url;
        this.description = description;
    }

    public Long getUpload_id() {
        return upload_id;
    }

    public void setUpload_id(Long upload_id) {
        this.upload_id = upload_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
