import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();

        int choice = -1;

        do {
            printMenu();
            System.out.print("請選擇功能：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤，請輸入數字！");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addItem(cart, sc);
                    break;

                case 2:
                    updateQuantity(cart, sc);
                    break;

                case 3:
                    removeItem(cart, sc);
                    break;

                case 4:
                    showCart(cart);
                    break;

                case 5:
                    showTotal(cart);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("沒有這個選項，請重新輸入！");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n===== 購物車系統 =====");
        System.out.println("1. 加入商品");
        System.out.println("2. 修改商品數量");
        System.out.println("3. 移除商品");
        System.out.println("4. 顯示購物車");
        System.out.println("5. 計算總額");
        System.out.println("0. 離開");
    }

    public static void addItem(
            ArrayList<CartItem> cart,
            Scanner sc
    ) {
        System.out.print("請輸入商品代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("商品代碼不可空白！");
            return;
        }

        CartItem item = findItemByCode(cart, code);

        if (item != null) {
            int addQuantity = readPositiveInt(
                    sc,
                    "商品已存在，請輸入要增加的數量："
            );

            if (addQuantity == -1) {
                return;
            }

            item.addQuantity(addQuantity);

            System.out.println(
                    "商品已存在，數量增加成功！目前數量："
                            + item.getQuantity()
            );

            return;
        }

        System.out.print("請輸入商品名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("商品名稱不可空白！");
            return;
        }

        double price = readPositiveDouble(sc, "請輸入商品單價：");

        if (price == -1) {
            return;
        }

        int quantity = readPositiveInt(sc, "請輸入商品數量：");

        if (quantity == -1) {
            return;
        }

        cart.add(new CartItem(code, name, price, quantity));
        System.out.println("商品加入成功！");
    }

    public static void updateQuantity(
            ArrayList<CartItem> cart,
            Scanner sc
    ) {
        System.out.print("請輸入要修改的商品代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("商品代碼不可空白！");
            return;
        }

        CartItem item = findItemByCode(cart, code);

        if (item == null) {
            System.out.println("找不到此商品，修改失敗！");
            return;
        }

        System.out.println("目前數量：" + item.getQuantity());

        int newQuantity = readPositiveInt(sc, "請輸入新的數量：");

        if (newQuantity == -1) {
            return;
        }

        item.setQuantity(newQuantity);
        System.out.println("數量修改成功！");
    }

    public static void removeItem(
            ArrayList<CartItem> cart,
            Scanner sc
    ) {
        System.out.print("請輸入要移除的商品代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("商品代碼不可空白！");
            return;
        }

        CartItem item = findItemByCode(cart, code);

        if (item == null) {
            System.out.println("找不到此商品，移除失敗！");
            return;
        }

        cart.remove(item);
        System.out.println("商品移除成功：" + item.getName());
    }

    public static void showCart(ArrayList<CartItem> cart) {

        System.out.println("\n===== 購物車內容 =====");

        if (cart.isEmpty()) {
            System.out.println("購物車目前是空的。");
            return;
        }

        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i));
        }
    }

    public static void showTotal(ArrayList<CartItem> cart) {

        if (cart.isEmpty()) {
            System.out.println("購物車目前是空的，總額為 0 元。");
            return;
        }

        double total = calculateTotal(cart);
        System.out.printf("購物車總額：%.2f 元%n", total);
    }

    public static double calculateTotal(ArrayList<CartItem> cart) {

        double total = 0;

        for (CartItem item : cart) {
            total += item.calculateSubtotal();
        }

        return total;
    }

    public static CartItem findItemByCode(
            ArrayList<CartItem> cart,
            String code
    ) {
        for (CartItem item : cart) {
            if (item.getCode().equalsIgnoreCase(code)) {
                return item;
            }
        }

        return null;
    }

    public static int readPositiveInt(
            Scanner sc,
            String message
    ) {
        System.out.print(message);

        if (!sc.hasNextInt()) {
            System.out.println("輸入錯誤，必須輸入整數！");
            sc.nextLine();
            return -1;
        }

        int value = sc.nextInt();
        sc.nextLine();

        if (value <= 0) {
            System.out.println("數量必須大於 0！");
            return -1;
        }

        return value;
    }

    public static double readPositiveDouble(
            Scanner sc,
            String message
    ) {
        System.out.print(message);

        if (!sc.hasNextDouble()) {
            System.out.println("輸入錯誤，單價必須是數字！");
            sc.nextLine();
            return -1;
        }

        double value = sc.nextDouble();
        sc.nextLine();

        if (value <= 0) {
            System.out.println("單價必須大於 0！");
            return -1;
        }

        return value;
    }
}