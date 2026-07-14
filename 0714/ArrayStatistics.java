import java.util.Scanner;

public class ArrayStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = readCount(sc);

        int[] scores = new int[count];

        inputScores(sc, scores);

        displayScores(scores);

        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int passCount = countPass(scores);
        int failCount = scores.length - passCount;

        System.out.println("\n===== 成績統計結果 =====");
        System.out.println("總分：" + total);
        System.out.println("平均：" + average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + passCount);
        System.out.println("不及格人數：" + failCount);

        int target = readTarget(sc);

        int index = findIndex(scores, target);

        if (index == -1) {
            System.out.println("找不到成績 " + target);
        } else {
            System.out.println("成績 " + target + " 第一次出現的索引是：" + index);
        }

        sc.close();
    }

    public static int readCount(Scanner sc) {
        int count;

        System.out.print("請輸入資料筆數（1～50）：");
        count = sc.nextInt();

        while (count < 1 || count > 50) {
            System.out.println("輸入錯誤，資料筆數必須介於 1 到 50。");
            System.out.print("請重新輸入資料筆數（1～50）：");
            count = sc.nextInt();
        }

        return count;
    }

    public static void inputScores(Scanner sc, int[] scores) {

        for (int i = 0; i < scores.length; i++) {
            System.out.print("請輸入第 " + (i + 1) + " 筆成績（0～100）：");
            scores[i] = sc.nextInt();

            while (scores[i] < 0 || scores[i] > 100) {
                System.out.println("輸入錯誤，成績必須介於 0 到 100。");
                System.out.print("請重新輸入第 " + (i + 1) + " 筆成績：");
                scores[i] = sc.nextInt();
            }
        }
    }

    public static void displayScores(int[] scores) {
        System.out.println("\n===== 全部成績 =====");

        for (int i = 0; i < scores.length; i++) {
            System.out.println("索引 " + i + "：" + scores[i]);
        }
    }

    public static int calculateTotal(int[] scores) {
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total = total + scores[i];
        }

        return total;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }

        return min;
    }

    public static int countPass(int[] scores) {
        int passCount = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) {
                passCount++;
            }
        }

        return passCount;
    }

    public static int readTarget(Scanner sc) {
        int target;

        System.out.print("\n請輸入要尋找的目標成績（0～100）：");
        target = sc.nextInt();

        while (target < 0 || target > 100) {
            System.out.println("輸入錯誤，目標成績必須介於 0 到 100。");
            System.out.print("請重新輸入目標成績（0～100）：");
            target = sc.nextInt();
        }

        return target;
    }

    public static int findIndex(int[] scores, int target) {

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }

        return -1;
    }
}