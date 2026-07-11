import java.util.Scanner;
public class GradeStatistics {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int total = 0;
        int count = 0;
        int passCount = 0;
        int failCount = 0;
        int max = 0;
        int min = 0;

        while (true) { 
            
            System.out.println("請輸入成績(輸入-1結束):");
            int score =sc.nextInt();

            if(score==-1){
                break;
            }

            if(score<0||score>100){
                System.out.println("輸入錯誤,請重新輸入:");
            }else{
                total = total +score;
                count=count+1;

                if(count==1){
                    max=score;
                    min=score;
                }else{
                    if(score>max){
                        max=score;
                    }
                    if(score<min){
                        min=score;
                    }
                    }

                    if(score>=60){
                        passCount = passCount+1;
                    }else{
                        failCount=failCount+1;
                    }
                }
            }

            if(count==0){
                System.out.println("No scores entered.");
            }else{
                double average = (double)total/count;
                String grade = getGrade(average);
                 printSummary(count,total,average,max,min,passCount,failCount,grade);
            }
            sc.close();
        }

        public static boolean isValidScore(int score) {
        if (score >= 0 && score <= 100) {
            return true;
        } else {
            return false;
        }
    }

     public static boolean isPassing(int score) {
        if (score >= 60) {
            return true;
        } else {
            return false;
        }
    }

    public static String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void printSummary(int count,int total,double average,int max,int min,int passCount,int failCount,String grade){
        
         System.out.println();
        System.out.println("=== Grade Summary ===");
        System.out.println("Count: " + count);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Pass count: " + passCount);
        System.out.println("Fail count: " + failCount);
        System.out.println("Average grade: " + grade);
    }
    }
    

