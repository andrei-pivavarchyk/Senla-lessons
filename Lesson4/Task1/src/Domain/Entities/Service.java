package Domain.Entities;

public class Service extends Entity {
    private String title;
    private int price;

    public Service(String title, int price, int id) {
        super(id);
        this.title = title;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return String.format("Title: %s. Price: %s.", title, price);
    }
}
