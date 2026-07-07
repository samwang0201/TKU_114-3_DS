import java.util.Scanner;
public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 1;

        while(number !=0){
            System.out.print("請輸入整數:");
            number =sc.nextInt();

            if(number !=0){
                System.out.println("輸入的是:"+number);
            }
        }
        sc.close();
    }
}
