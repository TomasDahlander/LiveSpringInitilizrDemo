package models;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-08 <br>
 * Time: 14:40 <br>
 * Project: LiveSpringInitilizrDemo <br>
 */
public class Friend {
    protected int id;
    protected String name;
    protected String address;
    protected String phoneNr;

    public Friend(){}

    public Friend(int id, String name, String address, String phoneNr) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    @Override
    public String toString() {
        return "{id: " + id +
                " | name: '" + name + '\'' +
                " | address: '" + address + '\'' +
                " | phoneNr: '" + phoneNr + '\'' +
                '}';
    }
}
