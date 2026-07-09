import java.util.Scanner;
public class OrderSystemRefactor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        int quantity;
        int price;
        int subtotal;
        int totalAmount=0;
        int totalQuantity=0;

        while (true) { 
            
            printMenu();
            choice=sc.nextInt();

            if(choice==0){
                break;
            }

            price=getPrice(choice);

            if(price==0){
                System.out.println("Wrong Choice");
                continue;
            }

            quantity= readValidQuantity(sc);

            if(quantity==0){
                continue;
            }

            subtotal = calculateSubtotal(price,quantity);

            totalAmount = totalAmount+subtotal;
            totalQuantity=totalQuantity+quantity;

            System.out.println("Subtotal:"+subtotal);
            System.out.print("");
        }

        printReceipt(totalQuantity,totalAmount);
        sc.close();
    }

    public static void printMenu(){
        System.out.println("=== MENU ===");
        System.out.println("1. Black Tea $30");
        System.out.println("2. Green Tea $35");
        System.out.println("3. Coffee $50");
        System.out.println("0. Check Out");
        System.out.print("Choose: ");
    }

    public static int getPrice(int option){
        switch(option){
               case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 50;
            default:
                return 0;
        }
    }
    public static int readValidQuantity(Scanner sc){
        int quantity;

        System.out.println("Quantity:");
        quantity=sc.nextInt();

        if(quantity<=0){
            System.out.println("Quantity must > 0");
            return 0;
        }
        return quantity;
    }

    public static int calculateSubtotal(int price,int quantity){
        return price*quantity;
    }

    public static void printReceipt(int totalItems,int totalAmount){
         System.out.println("=== Check Out ===");
        System.out.println("Total Quantity: " + totalItems);
        System.out.println("Total Amount: " + totalAmount);
        }
    }

