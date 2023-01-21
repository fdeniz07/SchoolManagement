package entities.concretes;

import entities.abstracts.User;

public class Students extends User {

    private String number;

    private String grade;


    public String getNumber() {
        return number;
    }

    public String getGrade() {
        return grade;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "number='" + number + '\'' +
                ", grade='" + grade + '\'';
    }


}
