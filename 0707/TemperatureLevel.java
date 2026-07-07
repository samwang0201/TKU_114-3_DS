public class TemperatureLevel {
    public static void main(String[] args) {
        double temperature =29.7;
        if(temperature<15){
            System.out.println("cold");
        }else if(temperature>15&&temperature<28){
            System.out.println("Comfortable");
        }else{
            System.out.println("Hot");
        }
    }
}
