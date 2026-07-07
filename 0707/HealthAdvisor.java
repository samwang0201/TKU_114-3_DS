import  java.util.Scanner;
public class HealthAdvisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String again ="y";
        while(again.equals("y")){
            System.out.print("Input Name:");
            String name =sc.next();

            System.out.print("Input height(M):");
            double height = sc.nextDouble();

            System.out.print("Input weight(kg):");
            double weight =sc.nextDouble();

            double bmi = weight/(height*height);

            String level;

            if(bmi<18.5){
                level="Too Thin";
            }else if(bmi<24&&bmi>=18.5){
                level="Normal";
            }else if(bmi>=24&&bmi<27){
                level="Heavy";
            }else{
                level="Too Heavy";
            }
            System.out.println("Name"+name);
            System.out.println("BMI"+bmi);
            System.out.println("Level"+level);
            System.out.print("Input Next Deta?(y/n)");
            again =sc.next();
        }
        sc.close();
    }
}
