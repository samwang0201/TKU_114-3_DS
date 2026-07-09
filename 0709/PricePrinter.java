public abstract class PricePrinter {
    public static void main(String[] args) {
        printItem("apple",30);
        printItem("orange", 40);
    }
    public static void printItem(String itemName, int price){
        System.out.println(itemName+" $"+price);
    }
}
