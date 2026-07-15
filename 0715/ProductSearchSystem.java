import java.util.Scanner;

public class ProductSearchSystem {

    /*
     * ==================== 測試案例 ====================
     * 測試案例 1：
     * 選擇功能：1
     * 預期結果：
     * 顯示 Keyboard、Mouse、Monitor、USB Cable、Headset的商品名稱、價格與庫存。
     *
     * 測試案例 2：
     * 選擇功能：2
     * 輸入：Keyboard
     * 預期結果：
     * 找到 Keyboard，顯示價格 890、庫存 12。
     *
     * 測試案例 3：
     * 選擇功能：2
     * 輸入：  keyboard
     * 預期結果：
     * 忽略大小寫與前後空白，成功找到 Keyboard。
     *
     * 測試案例 4：
     * 選擇功能：2
     * 輸入：Printer
     * 預期結果：
     * 顯示「查無名稱完全相同的商品。」
     *
     * 測試案例 5：
     * 選擇功能：3
     * 輸入：e
     * 預期結果：
     * 顯示 Keyboard、Mouse、USB Cable、Headset 等多筆結果。
     *
     * 測試案例 6：
     * 選擇功能：3
     * 輸入：usb
     * 預期結果：
     * 忽略大小寫，顯示 USB Cable。
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard","Mouse","Monitor","USB Cable","Headset"};

        int[] prices = {890,490,5200,250,1290};

        int[] stocks = {12,20,5,30,8};

        int choice = -1;

        while (choice != 0) {

            printMenu();

            System.out.print("請選擇功能：");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("請輸入整數選項。");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    displayAllProducts(names, prices, stocks);
                    break;

                case 2:
                    searchExactProduct(sc, names, prices, stocks);
                    break;

                case 3:
                    searchPartialProduct(sc, names, prices, stocks);
                    break;

                case 4:
                    displayLongestProduct(names, prices, stocks);
                    break;

                case 5:
                    displayKeywordPosition(sc, names);
                    break;

                case 0:
                    System.out.println("系統結束。");
                    break;

                default:
                    System.out.println("選項錯誤，請輸入 0～5。");
            }
        }

        sc.close();
    }

    public static void printMenu() {

        System.out.println();
        System.out.println("===== 商品搜尋系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 完整名稱搜尋");
        System.out.println("3. 部分名稱搜尋");
        System.out.println("4. 顯示名稱最長的商品");
        System.out.println("5. 顯示關鍵字第一次出現的位置");
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

            System.out.println((i + 1) + "\t"+ names[i] + "\t" + prices[i] + "\t" + stocks[i]);
        }
    }

    public static void searchExactProduct(
            Scanner sc,
            String[] names,
            int[] prices,
            int[] stocks) {

        String keyword = readKeyword(sc);

        int foundIndex = -1;

        for (int i = 0; i < names.length; i++) {

            if (names[i].equalsIgnoreCase(keyword)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("查無名稱完全相同的商品。");
        } else {
            System.out.println();
            System.out.println("===== 搜尋結果 =====");

            displayOneProduct(foundIndex,names,prices,stocks);
        }
    }

    public static void searchPartialProduct( Scanner sc,String[] names,int[] prices,int[] stocks) {

        String keyword = readKeyword(sc);

        String lowerKeyword = keyword.toLowerCase();

        int resultCount = 0;

        System.out.println();
        System.out.println("===== 部分名稱搜尋結果 =====");

        for (int i = 0; i < names.length; i++) {

            String lowerName = names[i].toLowerCase();

            if (lowerName.contains(lowerKeyword)) {

                displayOneProduct(i,names,prices,stocks);

                System.out.println();

                resultCount++;
            }
        }

        if (resultCount == 0) {
            System.out.println("找不到包含此關鍵字的商品。");
        } else {
            System.out.println("共找到 " + resultCount + " 筆商品。");
        }
    }

    public static void displayLongestProduct(String[] names,int[] prices,int[] stocks) {

        int longestIndex = 0;

        for (int i = 1; i < names.length; i++) {

            if (names[i].length()> names[longestIndex].length()) {

                longestIndex = i;
            }
        }

        System.out.println();
        System.out.println("===== 名稱最長的商品 =====");

        displayOneProduct(longestIndex,names,prices,stocks);

        System.out.println("商品名稱長度："+ names[longestIndex].length());
    }

    public static void displayKeywordPosition(Scanner sc,String[] names) {

        String keyword = readKeyword(sc);

        String lowerKeyword = keyword.toLowerCase();

        int resultCount = 0;

        System.out.println();
        System.out.println("===== 關鍵字位置搜尋結果 =====");

        for (int i = 0; i < names.length; i++) {

            String lowerName = names[i].toLowerCase();

            int position = lowerName.indexOf(lowerKeyword);

            if (position != -1) {

                System.out.println("商品名稱：" + names[i]);

                System.out.println("關鍵字「"+ keyword+ "」第一次出現的位置："+ position);

                System.out.println();

                resultCount++;
            }
        }

        if (resultCount == 0) {
            System.out.println("所有商品名稱中都找不到此關鍵字。");
        }
    }

    public static String readKeyword(Scanner sc) {

        String keyword;

        System.out.print("請輸入搜尋關鍵字：");
        keyword = sc.nextLine().trim();

        while (keyword.isEmpty()) {

            System.out.println("搜尋關鍵字不能是空白。");

            System.out.print("請重新輸入搜尋關鍵字：");

            keyword = sc.nextLine().trim();
        }

        return keyword;
    }

    public static void displayOneProduct(int index,String[] names,int[] prices,int[] stocks) {

        System.out.println("商品編號：" + (index + 1));

        System.out.println("商品名稱：" + names[index]);

        System.out.println("商品價格：" + prices[index] + " 元");

        System.out.println("商品庫存：" + stocks[index]);
    }
}