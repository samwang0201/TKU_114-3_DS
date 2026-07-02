import java.util.Scanner;

public class ScoreReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入姓名");
        String name =sc.nextLine();
        System.out.print("Java成績");
        int Java成績 =sc.nextInt();
        System.out.print("English成績");
        int English成績=sc.nextInt();
        System.out.print("Math成績");
        int Math成績=sc.nextInt();

        int score3 = Java成績+English成績+Math成績;
        int score4 =(Java成績+English成績+Math成績)/(3);

        System.out.println("姓名"+name);
        System.out.println("三科成績"+ score3 );
        System.out.println("平均分數"+score4);
        sc.close();


    }
}
