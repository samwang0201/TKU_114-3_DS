import java.util.Scanner;
public class ProductManagementSystem {
    /*
     * ==================== 測試案例 ====================
     *
     * 測試案例 1：顯示全部商品
     * 操作：
     * 選擇功能 1
     *
     * 預期結果：
     * 顯示初始的 5 項商品資料。
     *
     * --------------------------------------------------
     *
     * 測試案例 2：完整名稱搜尋
     * 操作：
     * 選擇功能 2
     * 輸入：Keyboard
     *
     * 預期結果：
     * 成功找到 Keyboard。
     *
     * --------------------------------------------------
     *
     * 測試案例 3：搜尋忽略大小寫與前後空白
     * 操作：
     * 選擇功能 2
     * 輸入：  keyboard
     *
     * 預期結果：
     * 忽略前後空白與大小寫，成功找到 Keyboard。
     *
     * --------------------------------------------------
     *
     * 測試案例 4：新增商品
     * 操作：
     * 選擇功能 3
     * 商品名稱：Webcam
     * 商品價格：1500
     * 商品庫存：10
     *
     * 預期結果：
     * 新增成功，商品總數增加為 6。
     *
     * --------------------------------------------------
     *
     * 測試案例 5：新增重複商品
     * 操作：
     * 選擇功能 3
     * 商品名稱：mouse
     * 商品價格：600
     * 商品庫存：10
     *
     * 預期結果：
     * 因 Mouse 已存在，顯示不可新增重複名稱。
     *
     * --------------------------------------------------
     *
     * 測試案例 6：出售商品成功
     * 操作：
     * 選擇功能 4
     * 商品名稱：Mouse
     * 出售數量：5
     *
     * 預期結果：
     * 出售成功，Mouse 庫存由 20 變成 15。
     *
     * --------------------------------------------------
     *
     * 測試案例 7：出售數量超過庫存
     * 操作：
     * 選擇功能 4
     * 商品名稱：Monitor
     * 出售數量：10
     *
     * 預期結果：
     * 因 Monitor 庫存只有 5，出售失敗。
     *
     * --------------------------------------------------
     *
     * 測試案例 8：補充庫存
     * 操作：
     * 選擇功能 5
     * 商品名稱：Headset
     * 補貨數量：5
     *
     * 預期結果：
     * 補貨成功，Headset 庫存由 8 變成 13。
     *
     * --------------------------------------------------
     *
     * 測試案例 9：修改價格
     * 操作：
     * 選擇功能 6
     * 商品名稱：Keyboard
     * 新價格：990
     *
     * 預期結果：
     * 價格修改成功，Keyboard 價格變成 990。
     *
     * --------------------------------------------------
     *
     * 測試案例 10：輸入無效價格
     * 操作：
     * 選擇功能 6
     * 商品名稱：Keyboard
     * 新價格：0
     *
     * 預期結果：
     * Product 類別拒絕修改，顯示價格必須大於 0。
     *
     * --------------------------------------------------
     *
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];

        products[0] = new Product("Keyboard", 890, 12);
        products[1] = new Product("Mouse", 490, 20);
        products[2] = new Product("Monitor", 5200, 5);
        products[3] = new Product("USB Cable", 250, 30);
        products[4] = new Product("Headset", 1290, 8);

        int productCount = 5;
        int choice = -1;

        int addCount = 0;
        int sellCount = 0;
        int restockCount = 0;
        int priceChangeCount = 0;

        int totalSoldQuantity = 0;
        int totalRestockQuantity = 0;

        while (choice != 0) {

            printMenu();

            choice = readMenuChoice(sc);

            switch (choice) {

                case 1:
                    displayAllProducts(products, productCount);
                    break;

                case 2:
                    searchProductByName(sc, products, productCount);
                    break;

                case 3:
                    boolean addSuccess =
                            addProduct(sc, products, productCount);

                    if (addSuccess) {
                        productCount++;
                        addCount++;
                    }
                    break;

                case 4:
                    int soldQuantity =
                            sellProduct(sc, products, productCount);

                    if (soldQuantity > 0) {
                        sellCount++;
                        totalSoldQuantity =
                                totalSoldQuantity + soldQuantity;
                    }
                    break;

                case 5:
                    int restockedQuantity =
                            restockProduct(sc, products, productCount);

                    if (restockedQuantity > 0) {
                        restockCount++;
                        totalRestockQuantity =
                                totalRestockQuantity + restockedQuantity;
                    }
                    break;

                case 6:
                    boolean priceChanged =
                            changeProductPrice(
                                    sc,
                                    products,
                                    productCount);

                    if (priceChanged) {
                        priceChangeCount++;
                    }
                    break;

                case 7:
                    displayLowStockProducts(
                            products,
                            productCount);
                    break;

                case 8:
                    long totalValue =
                            calculateTotalInventoryValue(
                                    products,
                                    productCount);

                    System.out.println();
                    System.out.println(
                            "全部庫存總價值："
                                    + totalValue
                                    + " 元");
                    break;

                case 0:
                    displaySummary(
                            addCount,
                            sellCount,
                            restockCount,
                            priceChangeCount,
                            totalSoldQuantity,
                            totalRestockQuantity);

                    System.out.println("系統結束。");
                    break;

                default:
                    System.out.println(
                            "選項錯誤，請輸入 0～8。");
            }
        }

        sc.close();
    }

    // 顯示主選單
    public static void printMenu() {

        System.out.println();
        System.out.println("===== 商品管理系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依完整名稱搜尋");
        System.out.println("3. 新增商品");
        System.out.println("4. 出售商品");
        System.out.println("5. 補充庫存");
        System.out.println("6. 修改商品價格");
        System.out.println("7. 顯示低庫存商品");
        System.out.println("8. 顯示全部庫存總價值");
        System.out.println("0. 結束並顯示操作摘要");
    }

    // 輸入並驗證主選單選項
    public static int readMenuChoice(Scanner sc) {

        while (true) {

            System.out.print("請選擇功能：");

            if (sc.hasNextInt()) {

                int choice = sc.nextInt();
                sc.nextLine();

                return choice;

            } else {

                System.out.println(
                        "輸入錯誤，請輸入整數。");

                sc.nextLine();
            }
        }
    }

    // 顯示全部商品
    public static void displayAllProducts(
            Product[] products,
            int productCount) {

        System.out.println();
        System.out.println("===== 全部商品 =====");
        System.out.println(
                "編號\t商品名稱\t價格\t庫存");

        for (int i = 0; i < productCount; i++) {

            System.out.println(
                    (i + 1)
                            + "\t"
                            + products[i].getName()
                            + "\t"
                            + products[i].getPrice()
                            + "\t"
                            + products[i].getStock());
        }
    }

    // 依完整名稱搜尋並顯示商品
    public static void searchProductByName(
            Scanner sc,
            Product[] products,
            int productCount) {

        String name = readProductName(sc);

        int index = findProductIndex(
                products,
                productCount,
                name);

        if (index == -1) {

            System.out.println("查無此商品。");

        } else {

            System.out.println();
            System.out.println("===== 搜尋結果 =====");

            displayOneProduct(products[index], index);
        }
    }

    // 搜尋商品索引
    public static int findProductIndex(
            Product[] products,
            int productCount,
            String name) {

        String searchName = name.trim();

        for (int i = 0; i < productCount; i++) {

            if (products[i]
                    .getName()
                    .equalsIgnoreCase(searchName)) {

                return i;
            }
        }

        return -1;
    }

    // 新增商品
    public static boolean addProduct(
            Scanner sc,
            Product[] products,
            int productCount) {

        if (productCount >= products.length) {

            System.out.println(
                    "商品陣列已滿，不能再新增商品。");

            return false;
        }

        String name = readProductName(sc);

        int existingIndex =
                findProductIndex(
                        products,
                        productCount,
                        name);

        if (existingIndex != -1) {

            System.out.println(
                    "商品名稱已存在，不可重複新增。");

            return false;
        }

        int price = readInteger(
                sc,
                "請輸入商品價格：");

        int stock = readInteger(
                sc,
                "請輸入商品庫存：");

        Product newProduct =
                new Product(name, price, stock);

        products[productCount] = newProduct;

        System.out.println("新增商品成功。");

        displayOneProduct(
                products[productCount],
                productCount);

        return true;
    }

    public static int sellProduct(
            Scanner sc,
            Product[] products,
            int productCount) {

        String name = readProductName(sc);

        int index = findProductIndex(
                products,
                productCount,
                name);

        if (index == -1) {

            System.out.println("查無此商品。");

            return 0;
        }

        System.out.println(
                "目前庫存："
                        + products[index].getStock());

        int quantity = readInteger(
                sc,
                "請輸入出售數量：");

        boolean success =
                products[index].sell(quantity);

        if (success) {

            long amount =
                    (long) products[index].getPrice()
                            * quantity;

            System.out.println("出售成功。");
            System.out.println(
                    "出售商品："
                            + products[index].getName());
            System.out.println(
                    "出售數量：" + quantity);
            System.out.println(
                    "出售金額：" + amount + " 元");
            System.out.println(
                    "剩餘庫存："
                            + products[index].getStock());

            return quantity;

        } else {

            System.out.println(
                    "出售失敗，數量必須大於 0，"
                            + "且不能超過目前庫存。");

            return 0;
        }
    }

    // 補充商品庫存
    public static int restockProduct(
            Scanner sc,
            Product[] products,
            int productCount) {

        String name = readProductName(sc);

        int index = findProductIndex(
                products,
                productCount,
                name);

        if (index == -1) {

            System.out.println("查無此商品。");

            return 0;
        }

        System.out.println(
                "目前庫存："
                        + products[index].getStock());

        int quantity = readInteger(
                sc,
                "請輸入補貨數量：");

        boolean success =
                products[index].restock(quantity);

        if (success) {

            System.out.println("補貨成功。");
            System.out.println(
                    "商品名稱："
                            + products[index].getName());
            System.out.println(
                    "補貨數量：" + quantity);
            System.out.println(
                    "目前庫存："
                            + products[index].getStock());

            return quantity;

        } else {

            System.out.println(
                    "補貨失敗，補貨數量必須大於 0。");

            return 0;
        }
    }

    public static boolean changeProductPrice(
            Scanner sc,
            Product[] products,
            int productCount) {

        String name = readProductName(sc);

        int index = findProductIndex(
                products,
                productCount,
                name);

        if (index == -1) {

            System.out.println("查無此商品。");

            return false;
        }
        System.out.println("目前價格："+ products[index].getPrice()+ " 元");

        int newPrice = readInteger(sc,"請輸入新的商品價格：");

        boolean success =
                products[index].setPrice(newPrice);

        if (success) {
            System.out.println("商品價格修改成功。");
            System.out.println("商品名稱："+ products[index].getName());
            System.out.println("新的價格："+ products[index].getPrice()+ " 元");

            return true;
        } else {

            System.out.println("價格修改失敗，商品價格必須大於 0。");

            return false;
        }
    }

    public static void displayLowStockProducts(Product[] products,int productCount) {

        System.out.println();
        System.out.println("===== 低庫存商品 =====");

        int lowStockCount = 0;

        for (int i = 0; i < productCount; i++) {

            if (products[i].isLowStock()) {

                displayOneProduct(products[i],i);

                System.out.println();
                lowStockCount++;
            }
        }

        if (lowStockCount == 0) {
            System.out.println("目前沒有低庫存商品。");
        }
    }

    public static long calculateTotalInventoryValue(
            Product[] products,
            int productCount) {

        long totalValue = 0;

        for (int i = 0; i < productCount; i++) {

            totalValue = totalValue+ products[i].getInventoryValue();
        }

        return totalValue;
    }

    public static String readProductName(Scanner sc) {

        String name;

        System.out.print("請輸入商品名稱：");
        name = sc.nextLine().trim();

        while (name.isEmpty()) {
            System.out.println("商品名稱不能是空白。");
            System.out.print("請重新輸入商品名稱：");
            name = sc.nextLine().trim();
        }

        return name;
    }

    public static int readInteger(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            if (sc.hasNextInt()) {

                int number = sc.nextInt();
                sc.nextLine();

                return number;

            } else {
                System.out.println("輸入錯誤，請輸入整數。");
                sc.nextLine();
            }
        }
    }

    public static void displayOneProduct(Product product,int index) {
        System.out.println("商品編號：" + (index + 1));
        System.out.println( "商品名稱："    + product.getName());
        System.out.println("商品價格：" + product.getPrice() + " 元");
        System.out.println( "商品庫存：" + product.getStock());
        System.out.println("庫存價值："+ product.getInventoryValue()+ " 元");
    }

    public static void displaySummary(int addCount,int sellCount,int restockCount,int priceChangeCount,int totalSoldQuantity,int totalRestockQuantity) {

        System.out.println();
        System.out.println("===== 操作摘要 =====");
        System.out.println( "成功新增商品次數："+ addCount);
        System.out.println("成功出售次數："+ sellCount);
        System.out.println("出售商品總數量：" + totalSoldQuantity);
        System.out.println("成功補貨次數："+ restockCount);
        System.out.println("補貨商品總數量："+ totalRestockQuantity);
        System.out.println("成功修改價格次數：" + priceChangeCount);
    
}
}
