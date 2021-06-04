package sample;

public class DislpayWorkers {
    int id;
    String name;
    String qualification;
    String speciality;
    String salary;
    String phone_number;

    public DislpayWorkers(int id, String name, String qualification, String speciality, String salary, String phone_number) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.speciality = speciality;
        this.salary = salary;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getSalary() {
        return salary;
    }

    public String getPhone_number() {
        return phone_number;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}