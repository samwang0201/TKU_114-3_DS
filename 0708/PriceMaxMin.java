public class PriceMaxMin {
    public static void main(String[] args) {
        
        int price1=1000;
        int price2=650;
        int price3=800;

        int max=price1;
        int min=price1;

        if(price2>max){
            max=price2;
        }
        if(price3>max){
            max=price3;
        }
        if(price2<min){
            min=price2;
        }
        if(price3<min){
            min=price3;
        }
        System.out.println("Max:"+max);
        System.out.println("Min"+min);

    }
}
