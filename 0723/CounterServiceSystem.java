import java.util.LinkedList;
import java.util.Queue;

public class CounterServiceSystem {

    public static void main(String[] args) {

        Queue<String> waitingQueue = new LinkedList<>();
        Queue<String> historyQueue = new LinkedList<>();

        takeNumber(waitingQueue, "A001", "小明");
        takeNumber(waitingQueue, "A002", "小華");
        takeNumber(waitingQueue, "A003", "小美");

        showNext(waitingQueue);

        showWaitingCount(waitingQueue);

        callNext(waitingQueue, historyQueue);

        showNext(waitingQueue);

        callNext(waitingQueue, historyQueue);
        callNext(waitingQueue, historyQueue);

        callNext(waitingQueue, historyQueue);

        showHistory(historyQueue);
    }

    public static void takeNumber(
            Queue<String> waitingQueue,
            String number,
            String name) {

        waitingQueue.offer(number + " " + name);
        System.out.println("取號成功：" + number + " " + name);
    }

    public static void callNext(
            Queue<String> waitingQueue,
            Queue<String> historyQueue) {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有等待號碼！");
            return;
        }

        String customer = waitingQueue.poll();
        historyQueue.offer(customer);

        System.out.println("叫號：" + customer);
    }

    public static void showNext(Queue<String> waitingQueue) {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有等待號碼！");
            return;
        }

        System.out.println("下一位：" + waitingQueue.peek());
    }

    public static void showWaitingCount(Queue<String> waitingQueue) {

        System.out.println("等待人數：" + waitingQueue.size());
    }

    public static void showHistory(Queue<String> historyQueue) {

        System.out.println("===== 處理紀錄 =====");

        if (historyQueue.isEmpty()) {
            System.out.println("目前沒有紀錄！");
            return;
        }

        for (String customer : historyQueue) {
            System.out.println(customer);
        }
    }
}