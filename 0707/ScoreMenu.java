import java.util.Scanner;

public class ScoreMenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input Name：");
        String name = sc.next();

        System.out.print("Input Java score：");
        double javaScore = sc.nextDouble();

        System.out.print("Input English score：");
        double englishScore = sc.nextDouble();

        System.out.print("Input Math Score：");
        double mathScore = sc.nextDouble();

        double average = (javaScore + englishScore + mathScore) / 3;

        String pass;
        if (average >= 60) {
            pass = "Pass";
        } else {
            pass = "False";
        }

        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        int choice=-1;

        while (choice !=0) {

            System.out.println();
            System.out.println("===== 選單 =====");
            System.out.println("1. 顯示平均分數");
            System.out.println("2. 顯示及格狀態");
            System.out.println("3. 顯示等第");
            System.out.println("0. 離開");
            System.out.print("請輸入選項：");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(name + " 的平均：" + average);
                    break;

                case 2:
                    System.out.println(name + "：" + pass);
                    break;

                case 3:
                    System.out.println(name + " 的等第：" + grade);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    sc.close();
                    return;

                default:
                    System.out.println("輸入錯誤！");
            }

        }

    }
}