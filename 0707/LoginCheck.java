public class LoginCheck {
    public static void main(String[] args) {
        String username ="admin";
        String password ="1234";

        String inputUsername ="admin";
        String inputPassword ="1234";

        boolean sucessinput = username.equals(inputUsername)&&password.equals(inputPassword);

        System.out.println("username"+username);
        System.out.println("password"+password);
        System.out.println("Input sucess"+sucessinput);
    }
}
