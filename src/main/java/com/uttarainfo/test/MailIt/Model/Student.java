package com.uttarainfo.test.MailIt.Model;

public class Student {
    private String email;
    private String firstName;
    private String lastName;
    private String javaScore;
    private String aptitudeScore;

    public Student(String email, String firstName, String lastName, String javaScore, String aptitudeScore) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.javaScore = javaScore;
        this.aptitudeScore = aptitudeScore;
    }

    public Student() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(String javaScore) {
        this.javaScore = javaScore;
    }

    public String getAptitudeScore() {
        return aptitudeScore;
    }

    public void setAptitudeScore(String aptitudeScore) {
        this.aptitudeScore = aptitudeScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", javaScore='" + javaScore + '\'' +
                ", aptitudeScore='" + aptitudeScore + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (javaScore != null ? !javaScore.equals(student.javaScore) : student.javaScore != null) return false;
        return aptitudeScore != null ? aptitudeScore.equals(student.aptitudeScore) : student.aptitudeScore == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (javaScore != null ? javaScore.hashCode() : 0);
        result = 31 * result + (aptitudeScore != null ? aptitudeScore.hashCode() : 0);
        return result;
    }
}
