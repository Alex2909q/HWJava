package Connection;

public class Flat {
    private int id;
    private String region;
    private int square;
    private String adress;
    private int rooms;

    private int price;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getRooms() {
        return rooms;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", square=" + square +
                ", adress='" + adress + '\'' +
                ", rooms=" + rooms +
                ", price=" + price +
                '}';
    }
}
