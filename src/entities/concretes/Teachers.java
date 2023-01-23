package entities.concretes;

import entities.abstracts.User;

import java.util.ArrayList;
import java.util.List;

public class Teachers extends User {

    public List<Teachers> teachersList = new ArrayList<>();

    private String registrationNumber;
    private String department;


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDepartment() {
        return department;
    }


    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Teachers(String registrationNumber, String department,int age, String id, String firstName, String lastName) {
        this.registrationNumber = registrationNumber;
        this.department = department;
        super.setAge(age);
        super.setId(id);
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public Teachers() {
    }

    @Override
    public String toString() {
        return "Name: "+super.getFirstName()+
                ", Surname: "+super.getLastName()+
                ", Age: "+super.getAge()+
                ", Registration No: "+this.registrationNumber+
                ", ID: "+super.getId()+
                ", Department: "+this.department;
    }


    public void fillTeacherList(){
        Teachers s = new Teachers(this.registrationNumber,this.department,super.getAge(),super.getId(),super.getFirstName(),super.getLastName());
        teachersList.add(s);
    }
}
