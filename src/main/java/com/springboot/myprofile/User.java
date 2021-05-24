package com.springboot.myprofile;

public class User {
    private String username;
    private long phone;
    private String email;
    private String subject;
    private String message;

    public User() {
    }

    public User(String username, long phone, String email, String subject, String message) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
