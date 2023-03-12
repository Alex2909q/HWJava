package Connection;

public class Client {
    private int id;
    private String name;
    private String sName;
    private int phone;
    private String city;

    public Client() {
    }

    public Client(int id, String name, String sName, int phone, String city) {
        this.id = id;
        this.name = name;
        this.sName = sName;
        this.phone = phone;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sName='" + sName + '\'' +
                ", phone=" + phone +
                ", city='" + city + '\'' +
                '}';
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

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
