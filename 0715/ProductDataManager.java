import java.util.Scanner;
public class ProductDataManager {
    /*
     * ==================== 測試案例 ====================
     *
     * 測試案例 1：顯示全部商品
     * 操作：
     * 選擇功能 1
     *
     * 預期結果：
     * 顯示 Keyboard、Mouse、Monitor、USB Cable、Headset
     * 的名稱、價格與庫存。
     *
     * --------------------------------------------------
     *
     * 測試案例 2：完整名稱搜尋
     * 操作：
     * 選擇功能 2
     * 輸入：Keyboard
     *
     * 預期結果：
     * 找到 Keyboard，價格 890 元，庫存 12。
     *
     * --------------------------------------------------
     *
     * 測試案例 3：完整名稱搜尋，忽略大小寫及空白
     * 操作：
     * 選擇功能 2
     * 輸入：  keyboard
     *
     * 預期結果：
     * 忽略前後空白及大小寫，成功找到 Keyboard。
     *
     * --------------------------------------------------
     *
     * 測試案例 4：部分名稱搜尋
     * 操作：
     * 選擇功能 3
     * 輸入：e
     *
     * 預期結果：
     * 顯示 Keyboard、Mouse、USB Cable、Headset 等多筆商品。
     *
     * --------------------------------------------------
     *
     * 測試案例 5：顯示低庫存商品
     * 操作：
     * 選擇功能 4
     *
     * 預期結果：
     * 顯示 Monitor，庫存 5。
     * 顯示 Headset，庫存 8。
     *
     * --------------------------------------------------
     *
     * 測試案例 6：顯示庫存總價值
     * 操作：
     * 選擇功能 5
     *
     * 預期結果：
     * 顯示全部商品庫存總價值。
     *
     * 計算：
     * 890 × 12 + 490 × 20 + 5200 × 5
     * + 250 × 30 + 1290 × 8
     * = 64300 元
     *
     * --------------------------------------------------
     *
     * 測試案例 7：新增正確格式資料
     * 操作：
     * 選擇功能 6
     * 輸入：Webcam,1500,10
     *
     * 預期結果：
     * 顯示新增成功。
     * 再選擇功能 1，可以看到 Webcam。
     *
     * --------------------------------------------------
     *
     * 測試案例 8：欄位數量錯誤
     * 操作：
     * 選擇功能 6
     * 輸入：Webcam,1500
     *
     * 預期結果：
     * 顯示格式錯誤，必須包含商品名稱、價格與庫存。
     * 程式不會中止。
     *
     * --------------------------------------------------
     *
     * 測試案例 9：價格轉換錯誤
     * 操作：
     * 選擇功能 6
     * 輸入：Webcam,一千五百,10
     *
     * 預期結果：
     * 顯示價格與庫存必須是整數。
     * 程式不會中止。
     *
     * --------------------------------------------------
     *
     * 測試案例 10：數值不合法
     * 操作：
     * 選擇功能 6
     * 輸入：Webcam,-1500,10
     *
     * 預期結果：
     * 顯示商品價格不能小於 0。
     * 程式不會中止。
     *
     * --------------------------------------------------
     *
     * 測試案例 11：商品名稱空白
     * 操作：
     * 選擇功能 6
     * 輸入：   ,1500,10
     *
     * 預期結果：
     * 顯示商品名稱不能是空白。
     * 程式不會中止。
     *
     * --------------------------------------------------
     *
     * 測試案例 12：結束程式
     * 操作：
     * 選擇功能 0
     *
     * 預期結果：
     * 顯示系統結束並離開程式。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] records = {"Keyboard,890,12","Mouse,490,20","Monitor,5200,5","USB Cable,250,30","Headset,1290,8"};
        String[] names = new String[records.length + 1];
        int[] prices = new int[records.length + 1];
        int[] stocks = new int[records.length + 1];
        int productCount = parseRecords(records, names,prices,stocks);
        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = readChoice(sc);

            switch (choice) {

                case 1:
                    displayAllProducts(names,prices,stocks,productCount);
                    break;
                case 2:
                    searchExactProduct(sc,names,prices,stocks,productCount);
                    break;
                case 3:
                    searchPartialProduct( sc,names,prices,stocks,productCount);
                    break;
                case 4:
                    displayLowStockProducts(names,prices,stocks,productCount);
                    break;
                case 5:
                    int totalValue = calculateTotalStockValue(prices,stocks,productCount);
                    System.out.println();
                    System.out.println( "全部庫存總價值：" + totalValue + " 元");
                    break;
                case 6:
                    if (productCount >= names.length) {
                        System.out.println("目前商品陣列已滿，無法再新增商品。");
                    } else {
                        boolean success = addNewRecord( sc,names,prices,stocks,productCount);
                        if (success) {
                            productCount++;
                        }
                    }
                    break;

                case 0:
                    System.out.println("系統結束。");
                    break;

                default:
                    System.out.println("選項錯誤，請輸入 0～6。");
            }
        }

        sc.close();
    }

    public static void printMenu() {

        System.out.println();
        System.out.println("===== 商品資料管理系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 完整名稱搜尋");
        System.out.println("3. 部分名稱搜尋");
        System.out.println("4. 顯示低庫存商品");
        System.out.println("5. 顯示庫存總價值");
        System.out.println("6. 輸入一筆新文字資料");
        System.out.println("0. 結束");
    }

    public static int readChoice(Scanner sc) {
        int choice;

        while (true) {
            System.out.print("請選擇功能：");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();

                return choice;
            } else {
                System.out.println("輸入錯誤，選項必須是整數。");
                sc.nextLine();
            }
        }
    }

    public static int parseRecords(String[] records,String[] names,int[] prices,int[] stocks) {

        int productCount = 0;
        for (int i = 0; i < records.length; i++) {
            String[] parts = records[i].split(",");
            if (parts.length != 3) {
                System.out.println("第 " + (i + 1) + " 筆資料格式錯誤：欄位數量必須是 3。");
                continue;
            }
            String name = parts[0].trim();
            try {

                int price = Integer.parseInt(parts[1].trim());
                int stock = Integer.parseInt(parts[2].trim());
                if (name.isEmpty()) {
                    System.out.println("第 " + (i + 1)+ " 筆資料錯誤：商品名稱不能是空白。");
                } else if (price < 0) {

                    System.out.println( "第 " + (i + 1)+ " 筆資料錯誤：商品價格不能小於 0。");

                } else if (stock < 0) {

                    System.out.println("第 " + (i + 1)+ " 筆資料錯誤：商品庫存不能小於 0。");
                } else {

                    names[productCount] = name;
                    prices[productCount] = price;
                    stocks[productCount] = stock;

                    productCount++;
                }

            } catch (NumberFormatException e) {

                System.out.println("第 " + (i + 1)+ " 筆資料錯誤：價格與庫存必須是整數。");
            }
        }

        return productCount;
    }

    public static void displayAllProducts(String[] names,
            int[] prices,
            int[] stocks,
            int productCount) {

        System.out.println();
        System.out.println("===== 解析後的商品表格 =====");
        System.out.println("編號\t商品名稱\t價格\t庫存");

        for (int i = 0; i < productCount; i++) {

            System.out.println(
                    (i + 1) + "\t"
                            + names[i] + "\t"
                            + prices[i] + "\t"
                            + stocks[i]);
        }
    }

    // 完整名稱搜尋
    public static void searchExactProduct(
            Scanner sc,
            String[] names,
            int[] prices,
            int[] stocks,
            int productCount) {

        String keyword = readKeyword(sc);

        int foundIndex = -1;

        for (int i = 0; i < productCount; i++) {

            if (names[i].equalsIgnoreCase(keyword)) {

                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {

            System.out.println(
                    "查無名稱完全相同的商品。");

        } else {

            System.out.println();
            System.out.println("===== 完整名稱搜尋結果 =====");

            displayOneProduct(
                    foundIndex,
                    names,
                    prices,
                    stocks);
        }
    }

    // 部分名稱搜尋
    public static void searchPartialProduct(
            Scanner sc,
            String[] names,
            int[] prices,
            int[] stocks,
            int productCount) {

        String keyword = readKeyword(sc);

        String lowerKeyword = keyword.toLowerCase();

        int resultCount = 0;

        System.out.println();
        System.out.println("===== 部分名稱搜尋結果 =====");

        for (int i = 0; i < productCount; i++) {

            String lowerName = names[i].toLowerCase();

            if (lowerName.contains(lowerKeyword)) {

                displayOneProduct(
                        i,
                        names,
                        prices,
                        stocks);

                System.out.println();

                resultCount++;
            }
        }

        if (resultCount == 0) {

            System.out.println(
                    "找不到包含此關鍵字的商品。");

        } else {

            System.out.println(
                    "共找到 " + resultCount + " 筆商品。");
        }
    }

    // 輸入並驗證搜尋關鍵字
    public static String readKeyword(Scanner sc) {

        String keyword;

        System.out.print("請輸入商品名稱或關鍵字：");
        keyword = sc.nextLine().trim();

        while (keyword.isEmpty()) {

            System.out.println(
                    "搜尋內容不能是空白。");

            System.out.print(
                    "請重新輸入商品名稱或關鍵字：");

            keyword = sc.nextLine().trim();
        }

        return keyword;
    }

    // 顯示低庫存商品，庫存小於 10
    public static void displayLowStockProducts(
            String[] names,
            int[] prices,
            int[] stocks,
            int productCount) {

        System.out.println();
        System.out.println("===== 低庫存商品 =====");

        int lowStockCount = 0;

        for (int i = 0; i < productCount; i++) {

            if (stocks[i] < 10) {

                displayOneProduct(
                        i,
                        names,
                        prices,
                        stocks);

                System.out.println();

                lowStockCount++;
            }
        }

        if (lowStockCount == 0) {

            System.out.println(
                    "目前沒有低庫存商品。");
        }
    }

    // 計算全部商品庫存總價值
    public static int calculateTotalStockValue(
            int[] prices,
            int[] stocks,
            int productCount) {

        int totalValue = 0;

        for (int i = 0; i < productCount; i++) {

            totalValue = totalValue
                    + prices[i] * stocks[i];
        }

        return totalValue;
    }

    // 輸入並解析一筆新文字資料
    public static boolean addNewRecord(
            Scanner sc,
            String[] names,
            int[] prices,
            int[] stocks,
            int productCount) {

        System.out.println();
        System.out.println(
                "資料格式：商品名稱,價格,庫存");

        System.out.print(
                "請輸入一筆新商品資料：");

        String newRecord = sc.nextLine();

        /*
         * 使用 -1 保留結尾的空欄位。
         * 例如 Webcam,1500,
         * 仍然會切割成 3 個部分。
         */
        String[] parts = newRecord.split(",", -1);

        if (parts.length != 3) {

            System.out.println(
                    "格式錯誤：資料必須包含商品名稱、價格與庫存，"
                            + "並使用兩個逗號分隔。");

            return false;
        }

        String name = parts[0].trim();
        String priceText = parts[1].trim();
        String stockText = parts[2].trim();

        if (name.isEmpty()) {

            System.out.println(
                    "格式錯誤：商品名稱不能是空白。");

            return false;
        }

        if (priceText.isEmpty()) {

            System.out.println(
                    "格式錯誤：商品價格不能是空白。");

            return false;
        }

        if (stockText.isEmpty()) {

            System.out.println(
                    "格式錯誤：商品庫存不能是空白。");

            return false;
        }

        try {

            int price = Integer.parseInt(priceText);
            int stock = Integer.parseInt(stockText);

            if (price < 0) {
                System.out.println("數值錯誤：商品價格不能小於 0。");

                return false;
            }

            if (stock < 0) {
                System.out.println("數值錯誤：商品庫存不能小於 0。");
                return false;
            }

            names[productCount] = name;
            prices[productCount] = price;
            stocks[productCount] = stock;

            System.out.println("新增商品成功。");

            displayOneProduct(productCount,names,prices,stocks);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("數字轉換錯誤：價格與庫存必須輸入整數。");
            return false;
        }
    }

    public static void displayOneProduct(int index,String[] names,int[] prices,int[] stocks) {
        System.out.println("商品編號：" + (index + 1));
        System.out.println("商品名稱：" + names[index]);
        System.out.println("商品價格：" + prices[index] + " 元");
        System.out.println("商品庫存：" + stocks[index]);
    }
}