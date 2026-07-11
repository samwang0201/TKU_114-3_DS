import java.util.Scanner;

public class PatternGenerator{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = -1;

        while (option != 0) {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    printMultiplicationTable();
                    System.out.println();
                    break;
                case 2:
                    int height = readPositiveInt(sc,"請輸入三角形高度：");
                    printTriangle(height);
                    System.out.println();
                    break;
                case 3:
                    int reverseHeight = readPositiveInt(sc,"請輸入倒三角形高度：");
                    printReverseTriangle(reverseHeight);
                    System.out.println();
                    break;
                case 4:
                    int rows = readPositiveInt(sc,"請輸入列數：");
                    int cols = readPositiveInt(sc,"請輸入欄數：");
                    printNumberGrid(rows, cols);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("程式結束。");
                    break;
                default:
                    System.out.println("輸入錯誤，請輸入 0 到 4！");
                    System.out.println();
                    break;
            }
        }

        sc.close();
    }

    public static void printMenu() {

        System.out.println("=== Pattern and Table Menu ===");
        System.out.println("1. Multiplication table");
        System.out.println("2. Triangle");
        System.out.println("3. Reverse triangle");
        System.out.println("4. Number grid");
        System.out.println("0. Exit");
    }

    public static int readPositiveInt(Scanner sc, String message) {

        int number = 0;

        while (number <= 0) {

            System.out.print(message);
            number = sc.nextInt();

            if (number <= 0) {
                System.out.println("輸入錯誤，數字必須大於 0！");
            }
        }

        return number;
    }

    public static void printMultiplicationTable() {

        for (int i = 1; i <= 9; i = i + 1) {

            for (int j = 1; j <= 9; j = j + 1) {

                System.out.print(i + " x " + j + " = " + (i * j));

                if (j < 9) {
                    System.out.print("\t");
                }
            }

            System.out.println();
        }
    }

    public static void printTriangle(int height) {

        for (int i = 1; i <= height; i = i + 1) {

            for (int j = 1; j <= i; j = j + 1) {

                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void printReverseTriangle(int height) {

        for (int i = height; i >= 1; i = i - 1) {

            for (int j = 1; j <= i; j = j + 1) {

                System.out.print("*");
            }

            System.out.println();
        }
    }
    
    public static void printNumberGrid(int rows, int cols) {

        for (int i = 1; i <= rows; i = i + 1) {

            for (int j = 1; j <= cols; j = j + 1) {

                System.out.print(j);

                if (j < cols) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}