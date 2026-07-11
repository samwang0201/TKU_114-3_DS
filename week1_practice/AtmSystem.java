import java.util.Scanner;

public class AtmSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = 1000;
        int depositCount = 0;
        int withdrawCount = 0;
        int totalDeposit = 0;
        int totalWithdraw = 0;

        int option = -1;
        
        while(option!=0){
            printMenu();

            System.out.print("請輸入選項:");
            option = sc.nextInt();
            switch(option){
                case 1:
                    printBalance(balance);
                    System.out.println();
                    break;
                case 2:
                    int depositAmount=readPositiveAmount(sc,"請輸入存款金額:");
                    balance = deposit(balance,depositAmount);
                    depositCount = depositCount+1;
                    totalDeposit=totalDeposit+depositAmount;
                    printBalance(balance);
                    System.out.println();
                    break;
                case 3:
                    int withdrawAmount = readPositiveAmount(sc,"請輸入提款金額：");
                    if(withdrawAmount<=balance){
                        balance =withdraw(balance,withdrawAmount);
                        withdrawCount=withdrawCount+1;
                        totalWithdraw=totalWithdraw+withdrawAmount;
                        printBalance(balance);
                    }else{
                        System.out.println("餘額不足,無法提款!");
                        printBalance(balance);
                    }
                    System.out.println();
                    break;
                case 4:
                    printSummary( balance,depositCount,withdrawCount,totalDeposit,totalWithdraw);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("離開ATM系統:");
                    break;
                default:
                    System.out.println("輸入錯誤,請輸入0到4!");
                    System.out.println();
                    break;
            }
        }

        printSummary( balance,depositCount,withdrawCount,totalDeposit,totalWithdraw);
        sc.close();
        }

          public static void printMenu() {

        System.out.println("=== ATM Menu ===");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show summary");
        System.out.println("0. Exit");
    }

    public static int readPositiveAmount(Scanner sc, String message) {

        int amount = 0;

        while (amount <= 0) {

            System.out.print(message);
            amount = sc.nextInt();

            if (amount <= 0) {
                System.out.println("金額必須大於 0，請重新輸入！");
            }
        }

        return amount;
    }

    public static int deposit(int balance, int amount) {
        balance = balance + amount;
        return balance;
    }

    public static int withdraw(int balance, int amount) {

        balance = balance - amount;

        return balance;
    }

    public static boolean canWithdraw(int balance, int amount){
        if(amount<=balance){
            return true;
        }else{
            return false;
        }
    }

    public static void printBalance(int balance) {
        System.out.println("Balance: " + balance);
    }

    public static void printSummary(int balance,int depositCount,int withdrawCount,int totalDeposit, int totalWithdraw){

        System.out.println("=== ATM Summary ===");
        System.out.println("Final balance: " + balance);
        System.out.println("Deposit count: " + depositCount);
        System.out.println("Withdraw count: " + withdrawCount);
        System.out.println("Total deposit: " + totalDeposit);
        System.out.println("Total withdraw: " + totalWithdraw);
        }

    }