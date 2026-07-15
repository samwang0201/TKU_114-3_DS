public class Q04_LoopRepair {

    public static void main(String[] args) {
        System.out.println(sumOddRange(3, 7));
        System.out.println(sumOddRange(7, 3));
        System.out.println(sumOddRange(2, 2));
        System.out.println(sumOddRange(-3, 3));
    }

    public static int sumOddRange(int start, int end) {
        int sum = 0;

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }

        return sum;
    }
}