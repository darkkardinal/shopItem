package shopitem;

public class Item {

    private int itemId;
    private float price;
    private String name;
    private float sum;

    public Item(int itemId, float price, String name) {
        this.itemId = itemId;
        this.price = price;
        this.name = name;
    }

    public int getItemId() {
        return itemId;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {

        return name;
    }

    public float getSum(int quantity, float price) {

        return quantity * price;
    }

    @Override
    public String toString() {
        return "Item [itemId =" + itemId + ", price=" + price + ", name=" + name + "]\n";
    }

}
