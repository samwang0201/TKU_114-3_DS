public class GradeMethod {
    public static void main(String[] args) {
        int javaScore=70;
        int englishScore=90;
        int mathScore=90;
        double average=calculateAverage(javaScore,  englishScore,  mathScore);
        String grade =getGrade( average);

        System.out.println("average:"+average);
        System.out.println("grade"+grade);

    }
    public static double calculateAverage(int javaScore, int englishScore, int mathScore){
        return (javaScore+englishScore+mathScore)/3;
    }
    public static String getGrade(double average){
        if(average>=90){
            return ":A";
        }else if(average>=80){
            return ":B";
        }else if(average>=70){
            return ":C";
        }else if(average>=60){
            return":D";
        }else{
            return ":F";
        }
    }

}
