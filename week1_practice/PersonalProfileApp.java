import java.util.Scanner;
public class PersonalProfileApp {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.print("請輸入姓名:");
        String name = sc.nextLine();

        int age = readPositiveInt(sc,"請輸入年齡:");
        double height = readPositiveDouble(sc,"請輸入身高(公尺):");
        double weight = readPositiveDouble(sc,"請輸入體重(公斤):");

        double bmi = caculateBmi(height,weight);
        String level = getBmiLevel(bmi);
        boolean adult = isAdult(age);
        printReport(name,age,adult,height,weight,bmi,level);
        sc.close();
    }

    public static int readPositiveInt(Scanner sc,String message){
        int number;

        while (true) { 
            System.out.print(message);
            number =sc.nextInt();

            if(number>0){
                return number;
            }
            System.out.println("輸入錯誤,請重新輸入!");
        }
    }

    public  static double readPositiveDouble(Scanner sc,String message){
        double number;

        while (true) { 
            System.out.print(message);
            number =sc.nextDouble();

            if(number>0){
                return number;
            }
            System.out.println("輸入錯誤,請重新輸入!");
        }
    }
    
    public static double caculateBmi(double height,double  weight){
        return weight/(height*height);
    }

    public static String getBmiLevel(double bmi){

        if(bmi<18.5){
            return "體重過輕";
        }else if(bmi<24){
            return "正常";
        }else if(bmi<27){
            return "過重";
        }else{
            return "肥胖";
        }
    }

    public static boolean isAdult(int age) {

        if (age >= 18) {
            return true;
        } else {
            return false;
        }

    }

    public static void printReport(String name, int age, boolean adult, double height, double weight, double bmi, String level){
        System.out.println();
        System.out.println("=== Personal Health Report ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Adult: " + adult);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("BMI: " + bmi);
        System.out.println("Level: " + level);
    }

    }

    

