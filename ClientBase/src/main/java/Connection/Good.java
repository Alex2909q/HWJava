package Connection;

public class Good {
    private int article;
    private String name;
    private int price;

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Good(int article, String name, int price) {
        this.article = article;
        this.name = name;
        this.price = price;
    }

    public Good() {
    }

    @Override
    public String toString() {
        return "Good{" +
                "article=" + article +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
