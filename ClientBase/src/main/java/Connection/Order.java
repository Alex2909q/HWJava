package Connection;

public class Order {
    private int id;
    private String nameGood;
    private int articleGood;
    private int quantity;
    private int phoneClient;
    private String nameClient;

    public Order(int id, String nameGood, int articleGood, int quantity, int phoneClient, String nameClient) {
        this.id = id;
        this.nameGood = nameGood;
        this.articleGood = articleGood;
        this.quantity = quantity;
        this.phoneClient = phoneClient;
        this.nameClient = nameClient;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGood() {
        return nameGood;
    }

    public void setNameGood(String nameGood) {
        this.nameGood = nameGood;
    }

    public int getArticleGood() {
        return articleGood;
    }

    public void setArticleGood(int articleGood) {
        this.articleGood = articleGood;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(int phoneClient) {
        this.phoneClient = phoneClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nameGood='" + nameGood + '\'' +
                ", articleGood=" + articleGood +
                ", quantity=" + quantity +
                ", phoneClient=" + phoneClient +
                ", nameClient='" + nameClient + '\'' +
                '}';
    }
}
