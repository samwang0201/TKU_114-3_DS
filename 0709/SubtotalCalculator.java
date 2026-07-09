public class SubtotalCalculator {
    public static void main(String[] args) {
        int total=calculateSubtotal(100,2);
        System.out.println("Total"+total);
    }
    public static int calculateSubtotal(int price,int quantity){
        return price*quantity;
    }
}
