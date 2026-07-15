import java.util.Scanner;

public class ProductArraySystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = { "Keyboard","Mouse","Monitor","USB Cable","Headset"};

        int[] prices = {890,490,5200,250,1290};

        int[] stocks = {12,20,5,30,8};

        int choice = -1;

        int purchaseCount = 0;
        int restockCount = 0;
        int totalPurchaseQuantity = 0;
        int totalRestockQuantity = 0;

        while (choice != 0) {

            printMenu();

            System.out.print("請選擇功能：");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayAllProducts(names, prices, stocks);
                    break;

                case 2:
                    searchProduct(sc,names,prices,stocks);
                    break;

                case 3:
                    int purchasedQuantity = purchaseProduct(sc,names,prices,stocks);

                    if (purchasedQuantity > 0) {
                        purchaseCount++;
                        totalPurchaseQuantity = totalPurchaseQuantity + purchasedQuantity;
                    }

                    break;

                case 4:
                    int restockedQuantity = restockProduct(sc,names,prices,stocks);

                    if (restockedQuantity > 0) {
                        restockCount++;
                        totalRestockQuantity = totalRestockQuantity + restockedQuantity;
                    }

                    break;

                case 5:
                    displayLowStockProducts(names, prices, stocks);
                    break;

                case 6:
                    int totalValue =
                            calculateTotalStockValue(prices, stocks);

                    System.out.println();
                    System.out.println("全部庫存總價值：" + totalValue + " 元");
                    break;

                case 0:
                    displaySummary(purchaseCount,restockCount,totalPurchaseQuantity,totalRestockQuantity);

                    System.out.println("系統結束。");
                    break;

                default:
                    System.out.println("選項錯誤，請重新輸入。");
            }
        }
        sc.close();
    }

    public static void printMenu() {

        System.out.println();
        System.out.println("===== 商品陣列管理系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依商品編號查詢");
        System.out.println("3. 購買商品");
        System.out.println("4. 補充商品庫存");
        System.out.println("5. 顯示低庫存商品");
        System.out.println("6. 顯示全部庫存總價值");
        System.out.println("0. 結束");
    }

    public static void displayAllProducts(
            String[] names,
            int[] prices,
            int[] stocks) {

        System.out.println();
        System.out.println("===== 全部商品 =====");

        System.out.println("編號\t商品名稱\t價格\t庫存");

        for (int i = 0; i < names.length; i++) {

            System.out.println((i + 1) + "\t"+ names[i] + "\t"+ prices[i] + "\t"+ stocks[i]);
        }
    }

    public static int readProductNumber(Scanner sc, String[] names) {

        int productNumber;

        System.out.print("請輸入商品編號(1~" + names.length + "):");

        productNumber = sc.nextInt();

        while (productNumber < 1 || productNumber > names.length) {

            System.out.println("商品編號錯誤，請重新輸入。");

            System.out.print("請輸入商品編號(1~"+ names.length + "）：");

            productNumber = sc.nextInt();
        }

        return productNumber;
    }

    public static void searchProduct(Scanner sc,String[] names,int[] prices,int[] stocks) {

        int productNumber = readProductNumber(sc, names);

        int index = productNumber - 1;

        System.out.println();
        System.out.println("===== 商品資料 =====");
        System.out.println("商品編號：" + productNumber);

        System.out.println("商品名稱：" + names[index]);

        System.out.println("商品價格：" + prices[index]);

        System.out.println("商品庫存：" + stocks[index]);
    }

    public static int purchaseProduct(Scanner sc,String[] names,int[] prices,int[] stocks) {

        int productNumber = readProductNumber(sc, names);

        int index = productNumber - 1;

        System.out.println("商品名稱：" + names[index]);

        System.out.println("目前庫存：" + stocks[index]);

        System.out.print("請輸入購買數量：");
        int quantity = sc.nextInt();

        while (quantity <= 0 || quantity > stocks[index]) {

            if (quantity <= 0) {
                System.out.println("購買數量必須大於 0。");
            } else {
                System.out.println("購買數量不能超過目前庫存。");
            }

            System.out.print("請重新輸入購買數量：");

            quantity = sc.nextInt();
        }

        stocks[index] =stocks[index] - quantity;

        int amount = prices[index] * quantity;

        System.out.println("購買成功。");

        System.out.println("購買商品：" + names[index]);

        System.out.println("購買數量：" + quantity);

        System.out.println("購買金額：" + amount + " 元");

        System.out.println("剩餘庫存：" + stocks[index]);

        return quantity;
    }

    public static int restockProduct(Scanner sc,String[] names,int[] prices,int[] stocks) {
        int productNumber = readProductNumber(sc, names);

        int index = productNumber - 1;

        System.out.println("商品名稱：" + names[index]);

        System.out.println("目前庫存：" + stocks[index]);

        System.out.print("請輸入補貨數量：");
        int quantity = sc.nextInt();

        while (quantity <= 0) {
            System.out.println("補貨數量必須大於 0。");

            System.out.print("請重新輸入補貨數量：");

            quantity = sc.nextInt();
        }

        stocks[index] =stocks[index] + quantity;

        System.out.println("補貨成功。");

        System.out.println("商品名稱：" + names[index]);

        System.out.println("補貨數量：" + quantity);

        System.out.println("目前庫存：" + stocks[index]);

        return quantity;
    }

    public static void displayLowStockProducts(String[] names,int[] prices,int[] stocks) {

        System.out.println();
        System.out.println("===== 低庫存商品 =====");

        int lowStockCount = 0;

        for (int i = 0; i < names.length; i++) {

            if (stocks[i] < 10) {

                System.out.println("商品編號：" + (i + 1));

                System.out.println("商品名稱：" + names[i]);

                System.out.println("商品價格：" + prices[i]);

                System.out.println("目前庫存：" + stocks[i]);

                System.out.println();

                lowStockCount++;
            }
        }

        if (lowStockCount == 0) {
            System.out.println("目前沒有低庫存商品。");
        }
    }

    public static int calculateTotalStockValue(int[] prices,int[] stocks) {

        int totalValue = 0;

        for (int i = 0; i < prices.length; i++) {

            totalValue =totalValue + prices[i] * stocks[i];
        }

        return totalValue;
    }

    public static void displaySummary(int purchaseCount,int restockCount,int totalPurchaseQuantity,int totalRestockQuantity) {

        System.out.println();
        System.out.println("===== 操作摘要 =====");

        System.out.println("成功購買次數："+ purchaseCount);

        System.out.println("購買商品總數量："+ totalPurchaseQuantity);

        System.out.println("成功補貨次數："+ restockCount);

        System.out.println("補貨商品總數量："+ totalRestockQuantity);
    }
}