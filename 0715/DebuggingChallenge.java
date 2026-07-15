/*
 * 檔名：DebuggingChallenge.java
 * public class 名稱：DebuggingChallenge
 *
 * ==================== 錯誤修正紀錄 ====================
 *
 * 錯誤 1
 * 錯誤位置：
 * System.out.println("系統結束，年齡：" + age)
 *
 * 錯誤類型：
 * 編譯錯誤
 *
 * 原因：
 * 程式敘述最後缺少分號。
 *
 * 修正方式：
 * 在 println 後面加上分號。
 *
 * 修正後：
 * System.out.println("系統結束，年齡：" + age);
 *
 * ----------------------------------------------------
 *
 * 錯誤 2
 * 錯誤位置：
 * for (int i = 0; i <= scores.length; i++)
 *
 * 錯誤類型：
 * 陣列越界錯誤
 *
 * 原因：
 * scores 陣列長度為 3，有效索引只有 0、1、2。
 * 當 i 等於 scores.length，也就是 3 時，
 * 程式會執行 scores[3]，造成陣列越界。
 *
 * 修正方式：
 * 將 i <= scores.length 改成 i < scores.length。
 *
 * 修正後：
 * for (int i = 0; i < scores.length; i++)
 *
 * ----------------------------------------------------
 *
 * 錯誤 3
 * 錯誤位置：
 * if (command == "exit")
 *
 * 錯誤類型：
 * 字串比較錯誤
 *
 * 原因：
 * == 比較的是兩個字串物件的位置，
 * 不是比較字串內容是否相同。
 *
 * 修正方式：
 * 使用 equalsIgnoreCase() 比較字串內容，
 * 並且可以忽略大小寫。
 *
 * 修正後：
 * if (command.equalsIgnoreCase("exit"))
 *
 * ----------------------------------------------------
 *
 * 錯誤 4
 * 錯誤位置：
 * double average = total / scores.length;
 *
 * 錯誤類型：
 * 整數除法造成的邏輯錯誤
 *
 * 原因：
 * total 和 scores.length 都是 int，
 * 所以會先執行整數除法，小數部分會被捨去，
 * 最後才將結果存入 double。
 *
 * 例如：
 * 247 / 3 的整數除法結果是 82，
 * 而不是 82.3333。
 *
 * 修正方式：
 * 將 total 轉型成 double 後再進行除法。
 *
 * 修正後：
 * double average = (double) total / scores.length;
 *
 * ----------------------------------------------------
 *
 * 錯誤 5
 * 錯誤位置：
 * int age = sc.nextInt();
 * String command = sc.nextLine();
 *
 * 錯誤類型：
 * Scanner 換行問題
 *
 * 原因：
 * nextInt() 只會讀取整數，不會讀取使用者按下 Enter
 * 產生的換行字元。
 * 下一個 nextLine() 會直接讀取剩下的換行，
 * 導致 command 變成空字串。
 *
 * 修正方式：
 * 在 nextInt() 後面先執行一次 sc.nextLine()，
 * 清除輸入區剩下的換行。
 *
 * 修正後：
 * int age = sc.nextInt();
 * sc.nextLine();
 * String command = sc.nextLine();
 *
 * ==================== Breakpoint 文字記錄 ====================
 *
 * Breakpoint 1：
 * 設定位置：total += scores[i];
 *
 * 第一次執行時的重要變數：
 * i = 0
 * scores.length = 3
 * scores[i] = 80
 * total = 0
 *
 * 執行完第一次加總後：
 * total = 80
 *
 * ----------------------------------------------------
 *
 * Breakpoint 2：
 * 原故障程式執行到陣列越界前的重要變數：
 *
 * i = 3
 * scores.length = 3
 * total = 247
 *
 * 此時程式準備執行：
 * scores[3]
 *
 * 但有效索引只有：
 * scores[0]、scores[1]、scores[2]
 *
 * 因此發生 ArrayIndexOutOfBoundsException。
 *
 * ----------------------------------------------------
 *
 * Breakpoint 3：
 * 設定位置：double average = (double) total / scores.length;
 *
 * 重要變數：
 * total = 247
 * scores.length = 3
 * average = 82.33333333333333
 *
 * 使用 printf 顯示後：
 * 平均：82.33
 *
 * ----------------------------------------------------
 *
 * Breakpoint 4：
 * 輸入年齡 20，並輸入指令 exit。
 *
 * 執行 sc.nextLine() 清除換行後：
 * age = 20
 * command = "exit"
 *
 * command.equalsIgnoreCase("exit") 的結果：
 * true
 */

import java.util.Scanner;

public class DebuggingChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total = total + scores[i];
        }

        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n", average);
        System.out.print("請輸入年齡：");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        if (command.equalsIgnoreCase("exit")) {
            System.out.println("系統結束，年齡：" + age);
        } else {
            System.out.println("收到的指令：" + command);
        }

        sc.close();
    }
}