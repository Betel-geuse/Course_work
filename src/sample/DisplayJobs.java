package sample;

public class DisplayJobs {
    int id;
    String name_firm, activity, addres, phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName_firm() {
        return name_firm;
    }

    public String getActivity() {
        return activity;
    }

    public String getAddres() {
        return addres;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName_firm(String name_firm) {
        this.name_firm = name_firm;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DisplayJobs(int id, String name_firm, String activity, String addres, String phoneNumber) {
        this.id = id;
        this.name_firm = name_firm;
        this.activity = activity;
        this.addres = addres;
        this.phoneNumber = phoneNumber;
    }



}
