import  java.util.Scanner;

public class HealthCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("請輸入姓名");
        String name =sc.nextLine();

        System.out.print("請輸入年齡");
        int age =sc.nextInt();

        System.out.print("請輸入身高(公尺)");
        double high = sc.nextDouble();

        System.out.print("請輸入體重(公斤)");
        int weight = sc.nextInt();

        Double bmi = weight/(high*high);
        System.out.println("姓名:"+name);
        System.out.println("年齡"+age);
        System.out.println("身高"+high);
        System.out.println("體重"+weight);
        System.out.println("BMI:"+bmi);

        sc.close();
    }
}
