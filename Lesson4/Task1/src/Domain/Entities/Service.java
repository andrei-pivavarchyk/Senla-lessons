package Domain.Entities;

public class Service {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String title;
    private int price;

    public Service(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Title: %s. Price: %s.",  title, price);
    }
}
