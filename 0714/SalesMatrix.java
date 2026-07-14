import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] sales = new int[3][4];

        inputSales(sc, sales);

        displaySales(sales);

        displayProductTotals(sales);

        displayDayTotals(sales);

        int highestProduct = findHighestProduct(sales);

        System.out.println();
        System.out.println("總銷售量最高的是商品 "+ (highestProduct + 1));

        System.out.println("總銷售量為："+ calculateProductTotal(sales, highestProduct));

        sc.close();
    }

    public static void inputSales(Scanner sc, int[][] sales) {

        System.out.println("===== 輸入銷售量 =====");

        for (int i = 0; i < sales.length; i++) {

            for (int j = 0; j < sales[i].length; j++) {

                System.out.print("請輸入商品 " + (i + 1)+ " 第 " + (j + 1)+ " 天的銷售量：");

                sales[i][j] = sc.nextInt();

                while (sales[i][j] < 0) {
                    System.out.println("銷售量不得小於 0。");

                    System.out.print("請重新輸入商品 " + (i + 1)+ " 第 " + (j + 1)+ " 天的銷售量：");

                    sales[i][j] = sc.nextInt();
                }
            }
        }
    }

    public static void displaySales(int[][] sales) {

        System.out.println();
        System.out.println("===== 銷售量表格 =====");

        System.out.println("\t第1天\t第2天\t第3天\t第4天");

        for (int i = 0; i < sales.length; i++) {

            System.out.print("商品" + (i + 1) + "\t");

            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public static int calculateProductTotal(
            int[][] sales, int productIndex) {

        int total = 0;

        for (int j = 0;j < sales[productIndex].length;j++) {
            total = total + sales[productIndex][j];
        }

        return total;
    }

    public static void displayProductTotals(int[][] sales) {

        System.out.println();
        System.out.println("===== 每項商品銷售總量 =====");

        for (int i = 0; i < sales.length; i++) {

            int total = calculateProductTotal(sales, i);

            System.out.println("商品 " + (i + 1)+ " 的銷售總量：" + total);
        }
    }

    public static int calculateDayTotal(
            int[][] sales, int dayIndex) {

        int total = 0;

        for (int i = 0; i < sales.length; i++) {
            total = total + sales[i][dayIndex];
        }

        return total;
    }

    public static void displayDayTotals(int[][] sales) {

        System.out.println();
        System.out.println("===== 每天銷售總量 =====");

        for (int j = 0; j < sales[0].length; j++) {

            int total = calculateDayTotal(sales, j);

            System.out.println("第 " + (j + 1)+ " 天的銷售總量：" + total);
        }
    }

    public static int findHighestProduct(int[][] sales) {

        int highestIndex = 0;

        int highestTotal =
                calculateProductTotal(sales, 0);

        for (int i = 1; i < sales.length; i++) {

            int currentTotal =calculateProductTotal(sales, i);

            if (currentTotal > highestTotal) {
                highestTotal = currentTotal;
                highestIndex = i;
            }
        }

        return highestIndex;
    }
}