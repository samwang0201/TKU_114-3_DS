import java.util.Scanner;
public class AtmMenu {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int choice=-1;
        int balance =1000;
        int amount;

        while(choice!=0){

            System.out.println("=== ATM Menu ===");
            System.out.println("1.查詢餘額");
            System.out.println("2.存款");
            System.out.println("3.提款");
            System.out.println("0.離開");
            System.out.println("Choose:");
            choice =sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("餘額:"+ balance);
                    break;
                case 2:
                    System.out.println("存款");
                    amount = sc.nextInt();

                    if(amount<=0){
                        System.out.println("存款需>0");
                        break;
                }

                balance =balance+amount;
                System.out.println("存款成功");
                System.out.println("Balance:"+balance);
                break;

                case 3:
                    System.out.println("提款");
                    amount =sc.nextInt();
                    
                    if(amount<=0){
                        System.out.println("提款需>0");
                        break;
                    }
                    if(amount>balance){
                        System.out.println("餘額不足");
                        break;
                    }

                    balance=balance-amount;
                    System.out.println("提款成功");
                    System.out.println("Balance:"+balance);

                case 0:
                    System.out.println("謝謝光臨");
                    break;

                default:
                    System.out.println("選擇錯誤");
                    }

                    System.out.println("");
            }

            sc.close();
        }
    }

