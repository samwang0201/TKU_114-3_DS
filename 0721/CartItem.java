public class CartItem {

    private String code;
    private String name;
    private double price;
    private int quantity;

    public CartItem(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public void addQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        }
    }

    public double calculateSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "代碼：" + code
                + "，名稱：" + name
                + "，單價：" + String.format("%.2f", price)
                + "，數量：" + quantity
                + "，小計：" + String.format("%.2f", calculateSubtotal());
    }
}