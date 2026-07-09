import java.util.Scanner;
public class AtmMethodHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int choice =-1;
        int balance =1000;
        int amount;

        while(choice!=0){
            printMenu();
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    printBalance(balance);
                    break;

                case 2:
                    amount = readPostiveAmount(sc,"請輸入存款金額:");
                    if(amount>0){
                        balance = deposit(balance,amount);
                        System.out.println("存款成功");
                        printBalance(balance);
                    }
                    break;

                case 3:
                    amount = readPostiveAmount(sc,"請輸入提款金額:");
                    if(amount>0){
                        if(amount>balance){
                            System.out.println("存款不足");
                        }else {
                            balance = withdraw(balance,amount);
                            System.out.println("提款成功");
                            printBalance(balance);
                        }
                    }
                    break;

                case 0:
                    System.out.println("謝謝光臨");
                    break;

                default:
                    System.out.println("選擇錯誤");
            }

            System.out.print("");

        }

        sc.close();
    }

    public static void printMenu() {
        System.out.println("=== ATM Menu ===");
        System.out.println("1. 查詢餘額");
        System.out.println("2. 存款");
        System.out.println("3. 提款");
        System.out.println("0. 離開");
        System.out.print("Choose: ");
    }

    public static int readPostiveAmount(Scanner sc,String message){
        int amount;

        System.out.print("message");
        amount = sc.nextInt();

        if(amount<=0){
            System.out.println("存款金額必須 > 0 ");
            return 0;
        }
        return amount;
    }

    public static int deposit(int balance,int amount){
        return  balance+amount;
    }

    public static int withdraw(int balance,int amount){
        return balance-amount;
    }

    public static  void printBalance(int balance){
        System.out.println("餘額:"+balance);
    }
}
