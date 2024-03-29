package com.example.umlmentor;

public class Student {
    private String studentId;
    private String studentFirstName;
    private String studentLastName;
    private String userName;
    private String studentEmail;
    private String studentMajor;
    private String studentPassword;
    private String studentConfirmPassword;

    public Student()
    {

    }

    public Student(String studentId, String studentFirstName, String studentLastName,
                   String userName, String studentMajor, String studentEmail,
                   String studentPassword, String studentConfirmPassword)
    {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.userName = userName;
        this.studentEmail = studentEmail;
        this.studentMajor = studentMajor;
        this.studentPassword = studentPassword;
        this.studentConfirmPassword = studentConfirmPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentName() {
        return userName;
    }

    public void setStudentName(String studentName) {
        this.userName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentConfirmPassword() {
        return studentConfirmPassword;
    }

    public void setStudentConfirmPassword(String studentConfirmPassword) {
        this.studentConfirmPassword = studentConfirmPassword;
    }
}
