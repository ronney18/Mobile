package com.example.umlmentor;

public class StudentPost {
    private String subject;
    private String description;
    private String id;
    private String studentName;

    public StudentPost() {

    }

    public StudentPost(String id, String studentName, String subject, String description) {
        this.id = id;
        this.studentName = studentName;
        this.subject = subject;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
