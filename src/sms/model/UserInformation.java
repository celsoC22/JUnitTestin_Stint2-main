package sms.model;

public class UserInformation {
    private String Fname;
    private String Bdate;
    private String address;


    public UserInformation(String newFname, String newBdate, String newAddress){
        this.Fname = newFname;
        this.Bdate = newBdate;
        this.address = newAddress;

    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public void setBdate(String bdate) {
        Bdate = bdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFname() {
        return Fname;
    }

    public String getBdate() {
        return Bdate;
    }

    public String getAddress() {
        return address;
    }

}
