package entities.concretes;

import entities.abstracts.User;
import java.util.ArrayList;
import java.util.List;

public class Students extends User {

    private String number;

    private String grade;

    public List<Students> studentsList = new ArrayList<>();



    public Students() {
    }

    public Students(String number, String grade, int age, String id, String firstName, String lastName) {
        this.number = number;
        this.grade = grade;
        super.setAge(age);
        super.setId(id);
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }



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
        return "Name: "+super.getFirstName()+
                ", Surname: "+super.getLastName()+
                ", Age: "+super.getAge()+
                ", Grade: "+this.grade+
                ", ID: "+super.getId()+
                ", Student No: "+this.number;
    }


    public void fillStudentList(){
        Students s = new Students(this.number,this.grade,super.getAge(),super.getId(),super.getFirstName(),super.getLastName());
        studentsList.add(s);
    }


}
