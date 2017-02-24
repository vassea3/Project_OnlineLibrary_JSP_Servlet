package com.biblioteca.entitati;

public class MyMessageFromContact {

    private int id;
    private String name;
    private String email;
    private String subject;
    private String message;

    public MyMessageFromContact(int id, String name, String email, String subject, String message) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public MyMessageFromContact( String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "MyMessageFromContact{" + "id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message + '}';
    }

}
