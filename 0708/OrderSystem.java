import java.util.Scanner;
public class OrderSystem {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int choice ;
        int quantity;
        int price = 0;
        int subtotal;
        int totalAmount=0;
        int totalQuantity=0;

        while(true){

            System.out.println("===MENU===");
            System.out.println("1.Black Tea $30");
            System.out.println("2.Green Tea $35");
            System.out.println("3.Coffee $50");
            System.out.println("0.Check Out");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            if(choice==0){
                break;
            }
            switch(choice){
                case 1:
                    price=30;
                    break;
                case 2:
                    price=35;
                    break;
                case 3:
                    price=50;
                    break;
                default:
                    System.out.println("Wrong choice");
                    continue;
            }
            System.out.print("Quantity:");
            quantity = sc.nextInt();

            if(quantity<=0){
                System.out.println("Quantity must > 0");
                continue;
            }

            subtotal = quantity*price;

            totalAmount = totalAmount +subtotal;
            totalQuantity=totalQuantity+quantity;

            System.out.println("Subtotal:"+subtotal);
            System.out.println("");
        } 

        System.out.println("===Check Out===");
        System.out.println("Total Quantity:"+totalQuantity);
        System.out.println("Total Amount:"+totalAmount);

        sc.close();
            
        }
    }

