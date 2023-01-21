package entities.concretes;

import entities.abstracts.User;

public class Teachers extends User {

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


    @Override
    public String toString() {
        return  "registrationNumber='" + registrationNumber + '\'' +
                ", department='" + department + '\'';
    }

}
