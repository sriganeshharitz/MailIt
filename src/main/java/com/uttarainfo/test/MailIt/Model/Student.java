package com.uttarainfo.test.MailIt.Model;

public class Student {
    private String email;
    private String firstName;
    private String lastName;
    private int javaScore;
    private int aptitudeScore;

    public Student(String email, String firstName, String lastName, int javaScore, int aptitudeScore) {
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

    public int getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(int javaScore) {
        this.javaScore = javaScore;
    }

    public int getAptitudeScore() {
        return aptitudeScore;
    }

    public void setAptitudeScore(int aptitudeScore) {
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

        if (javaScore != student.javaScore) return false;
        if (aptitudeScore != student.aptitudeScore) return false;
        if (!email.equals(student.email)) return false;
        if (!firstName.equals(student.firstName)) return false;
        return lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + javaScore;
        result = 31 * result + aptitudeScore;
        return result;
    }
}
